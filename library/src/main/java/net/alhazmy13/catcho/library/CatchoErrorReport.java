package net.alhazmy13.catcho.library;

import android.os.Build;

import java.io.StringWriter;

/**
 * Created by Alhazmy13 on 4/17/16.
 * Catcho
 */
abstract class CatchoErrorReport {

    /**
     * Gets report.
     *
     * @param stackTrace the stack trace
     * @return the report
     */
    static String getReport(StringWriter stackTrace) {
        String LINE_SEPARATOR = "\n";
        return "************ CAUSE OF ERROR ************\n\n" +
                stackTrace.toString() +
                "\n************ DEVICE INFORMATION ***********\n" +
                "Brand: " +
                Build.BRAND +
                LINE_SEPARATOR +
                "Device: " +
                Build.DEVICE +
                LINE_SEPARATOR +
                "Model: " +
                Build.MODEL +
                LINE_SEPARATOR +
                "Id: " +
                Build.ID +
                LINE_SEPARATOR +
                "Product: " +
                Build.PRODUCT +
                LINE_SEPARATOR +
                "\n************ FIRMWARE ************\n" +
                "SDK: " +
                Build.VERSION.SDK_INT +
                LINE_SEPARATOR +
                "Release: " +
                Build.VERSION.RELEASE +
                LINE_SEPARATOR +
                "Incremental: " +
                Build.VERSION.INCREMENTAL +
                LINE_SEPARATOR;
    }

}
