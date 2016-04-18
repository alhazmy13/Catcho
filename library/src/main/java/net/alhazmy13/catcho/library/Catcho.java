package net.alhazmy13.catcho.library;

import android.content.Context;
import android.content.Intent;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;

/**
 * Created by Alhazmy13 on 4/16/16.
 * Catcho
 */
public class Catcho implements
        java.lang.Thread.UncaughtExceptionHandler {
    /**
     * The constant ERROR.
     */
    protected static final String ERROR = "error";
    private final WeakReference<Context> context;
    private EmailMode emailMode;
    private Intent callingIntent;
    private String[] recipients;
    private String smtpEmail;
    private String password;

    /**
     * Instantiates a new Catcho.
     *
     * @param builder the builder
     */
    public Catcho(Builder builder) {
        context = builder.context;
        emailMode = builder.emailMode;
        callingIntent = CatchoReportActivity.getCallingIntent(context.get(),emailMode,recipients,smtpEmail,password);
    }

    public void uncaughtException(Thread thread, Throwable exception) {
        StringWriter stackTrace = new StringWriter();
        exception.printStackTrace(new PrintWriter(stackTrace));
        String errorReport = CatchoErrorReport.getReport(stackTrace);

        callingIntent.putExtra(ERROR, errorReport);
        context.get().startActivity(callingIntent);

        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(10);
    }


    /**
     * The enum Email mode.
     */
    public enum EmailMode {
        /**
         * G mail sender email mode.
         */
        G_MAIL_SENDER(1), /**
         * Default email mode.
         */
        DEFAULT(2);

        private final int value;

        EmailMode(int value) {
            this.value = value;
        }

        /**
         * Gets value.
         *
         * @return the value
         */
        public int getValue() {
            return value;
        }
    }


    /**
     * The type Builder.
     */
    public static class Builder {
        private WeakReference<Context> context;

        private EmailMode emailMode;
        private String[] email;
        private String password;
        private String smtpEmail;

        /**
         * Instantiates a new Builder.
         *
         * @param context the context
         */
        public Builder(Context context) {
            this.context = new WeakReference<>(context);
        }

        /**
         * Email mode catcho . builder.
         *
         * @param emailMode the email mode
         * @return the catcho . builder
         */
        public Catcho.Builder emailMode(EmailMode emailMode) {
            this.emailMode = emailMode;
            return this;
        }

        /**
         * Recipients catcho . builder.
         *
         * @param email the email
         * @return the catcho . builder
         */
        public Catcho.Builder recipients(String... email){
            this.emailMode = EmailMode.DEFAULT;
            this.email = email;
            return this;
        }

        /**
         * G mail sender catcho . builder.
         *
         * @param smtpEmail the smtp email
         * @param password  the password
         * @return the catcho . builder
         */
        public Catcho.Builder smtpSender(String smtpEmail,String password){
            this.emailMode = EmailMode.G_MAIL_SENDER;
            this.smtpEmail = smtpEmail;
            this.password = password;
            return this;
        }

        /**
         * Build catcho.
         *
         * @return the catcho
         */
        public Catcho build() {
            return new Catcho(this);
        }
    }

}