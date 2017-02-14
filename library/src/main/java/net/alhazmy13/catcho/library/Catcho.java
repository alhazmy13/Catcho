package net.alhazmy13.catcho.library;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import net.alhazmy13.catcho.library.error.CatchoError;
import net.alhazmy13.catcho.library.error.CatchoErrorParser;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;

/**
 * Created by Alhazmy13 on 4/16/16.
 * Catcho
 */
public class Catcho implements java.lang.Thread.UncaughtExceptionHandler {

    public static final String ERROR = "error";
    private final WeakReference<Context> context;
    private CatchoTags.EmailMode emailMode;
    private String[] recipients;
    private String smtpEmail;
    private String password;
    private Class<Activity> mActivity;

    public static Catcho Builder(Context context) {
        return new Catcho(context);
    }

    private Catcho(Context context){
        this.context = new WeakReference<>(context);
    }

    public Catcho recipients(String... recipients){
        this.emailMode = CatchoTags.EmailMode.DEFAULT;
        this.recipients = recipients;
        return this;
    }

    private Catcho gmailSMTPSenderMode(String smtpEmail,String password){
        this.emailMode = CatchoTags.EmailMode.G_MAIL_SENDER;
        this.smtpEmail = smtpEmail;
        this.password = password;
        return this;
    }

    public Catcho build() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        return this;
    }

    public <T extends Activity> Catcho activity(Class<T> customActivityClass) {
        this.mActivity = (Class<Activity>) customActivityClass;
        return this;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable exception) {
        StringWriter stackTrace = new StringWriter();
        exception.printStackTrace(new PrintWriter(stackTrace));
        CatchoError errorReport = CatchoErrorParser.getReport(stackTrace);

        if(mActivity != null){
            (context.get()).startActivity(getCallingIntent(context.get(),errorReport));
        }else {
            (context.get()).startActivity(CatchoReportActivity.getCallingIntent(context.get(),emailMode,recipients,smtpEmail,password,errorReport));
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(10);
    }

    private Intent getCallingIntent(Context context, CatchoError errorReport) {
        Intent intent = new Intent(context, mActivity);
        intent.putExtra(Catcho.ERROR,errorReport);
        return intent;
    }
}