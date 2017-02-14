package net.alhazmy13.catcho.library.error;

import android.os.Build;

import java.io.StringWriter;

/**
 * Created by Alhazmy13 on 4/17/16.
 * Catcho
 */
public abstract class CatchoErrorParser {


    /**
     * Gets report.
     *
     * @param stackTrace the stack trace
     * @return the report
     */
    public static CatchoError getReport(StringWriter stackTrace) {
        CatchoError catchoError = new CatchoError();
        catchoError.setError(stackTrace.toString());
        catchoError.setDeviceInformation(getDeviceInfo());
        catchoError.setFirmware(getFrimware());
        return catchoError;
    }

    static DeviceInformation getDeviceInfo() {
        DeviceInformation deviceInfo = new DeviceInformation();
        deviceInfo.setBrand(Build.BRAND);
        deviceInfo.setDevice(Build.DEVICE);
        deviceInfo.setModel(Build.MODEL);
        deviceInfo.setId(Build.ID);
        deviceInfo.setProduct(Build.PRODUCT);
        return deviceInfo;
    }

    static Firmware getFrimware() {
        Firmware firmware = new Firmware();
        firmware.setIncremental(Build.VERSION.INCREMENTAL);
        firmware.setRelease(Build.VERSION.RELEASE);
        firmware.setSdk(String.valueOf(Build.VERSION.SDK_INT));
        return firmware;
    }
}
