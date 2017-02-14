package net.alhazmy13.catcho.library.error;

import java.io.Serializable;

/**
 * Created by alhazmy13 on 2/13/17.
 */

public class CatchoError implements Serializable {
    private String error;
    private DeviceInformation deviceInformation;
    private Firmware firmware;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public DeviceInformation getDeviceInformation() {
        return deviceInformation;
    }

    void setDeviceInformation(DeviceInformation deviceInformation) {
        this.deviceInformation = deviceInformation;
    }

    public Firmware getFirmware() {
        return firmware;
    }

    void setFirmware(Firmware firmware) {
        this.firmware = firmware;
    }

    @Override
    public String toString() {
        return "************ CAUSE OF ERROR ************\n\n" +
                error +
                "\n************ DEVICE INFORMATION ***********\n" +
                deviceInformation +
                "n************ FIRMWARE ************\n" +
                firmware;
    }

}
