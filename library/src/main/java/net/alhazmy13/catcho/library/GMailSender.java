package net.alhazmy13.catcho.library;

import android.os.AsyncTask;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Security;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Created by Alhazmy13 on 4/16/16.
 * Catcho
 */
class GMailSender extends Authenticator {
    static {
        Security.addProvider(new JSSEProvider());
    }

    private String mailhost = "smtp.gmail.com";
    private String user;
    private String password;
    private Session session;
    private MimeMessage message;

    /**
     * Instantiates a new G mail sender.
     *
     * @param user     the user
     * @param password the password
     */
    public GMailSender(String user, String password) {
        this.user = user;
        this.password = password;

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", mailhost);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.quitwait", "false");

        session = Session.getDefaultInstance(props, this);
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, password);
    }

    /**
     * Send mail.
     *
     * @param subject    the subject
     * @param body       the body
     * @param sender     the sender
     * @param recipients the recipients
     * @throws Exception the exception
     */
    public synchronized void sendMail(String subject, String body, String sender, String[] recipients) throws MessagingException {
        try {
            message = new MimeMessage(session);
            DataHandler handler = new DataHandler(new ByteArrayDataSource(body.getBytes(), "text/plain"));
            message.setSender(new InternetAddress(sender));
            message.setSubject(subject);
            message.setDataHandler(handler);
            String resp = getEmailStrings(recipients);
            if (resp.indexOf(',') > 0)
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(resp));
            else
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(resp));
            new sendEmailOnBackground().execute();

        } catch (MessagingException e) {
            throw e;
        }
    }

    private String getEmailStrings(String[] recipients) {
        StringBuilder sb = new StringBuilder();
        for (String n : recipients) {
            if (sb.length() > 0) sb.append(',');
            sb.append("'").append(n).append("'");
        }
        return sb.toString();
    }

    class sendEmailOnBackground extends AsyncTask<String, String, String> {

        private Exception exception;

        protected String doInBackground(String... urls) {
            try {
                Transport.send(message);
            } catch (MessagingException e) {
                //e.printStackTrace();
            }

            return "";
        }

        protected void onPostExecute() {
            // TODO: check this.exception
            // TODO: do something with the feed
        }
    }

    /**
     * The type Byte array data source.
     */
    public class ByteArrayDataSource implements DataSource {
        private byte[] data;
        private String type;

        /**
         * Instantiates a new Byte array data source.
         *
         * @param data the data
         * @param type the type
         */
        public ByteArrayDataSource(byte[] data, String type) {
            super();
            this.data = data;
            this.type = type;
        }

        /**
         * Instantiates a new Byte array data source.
         *
         * @param data the data
         */
        public ByteArrayDataSource(byte[] data) {
            super();
            this.data = data;
        }

        /**
         * Sets type.
         *
         * @param type the type
         */
        public void setType(String type) {
            this.type = type;
        }

        public String getContentType() {
            if (type == null)
                return "application/octet-stream";
            else
                return type;
        }

        public InputStream getInputStream() throws IOException {
            return new ByteArrayInputStream(data);
        }

        public String getName() {
            return "ByteArrayDataSource";
        }

        public OutputStream getOutputStream() throws IOException {
            throw new IOException("Not Supported");
        }
    }
}