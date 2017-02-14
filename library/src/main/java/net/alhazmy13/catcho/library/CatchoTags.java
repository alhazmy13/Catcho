package net.alhazmy13.catcho.library;

/**
 * Created by Alhazmy13 on 4/17/16.
 * Catcho
 */
abstract class CatchoTags {


    static final String REPORT = "REPORT";
    static final String TITLE = "TITLE";
    static final String EMAIL = "EMAIL";
    static final String DESCRIPTION = "DESCRIPTION";
    static final String EMAIL_MODE = "EMAIL_MODE";
    static final String RECIPIENT_EMAIL = "RECIPIENT_EMAIL";
    static final String PASSWORD = "PASSWORD";
    static final String SMTP_EMAIL = "SMTP";

    enum EmailMode {

        G_MAIL_SENDER(1),
        DEFAULT(2);
        private final int value;

        EmailMode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
