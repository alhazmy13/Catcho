package net.alhazmy13.catcho.library.error;

import java.io.Serializable;

/**
 * Created by alhazmy13 on 2/13/17.
 */

class DeviceInformation implements Serializable {

    private String brand;
    private String device;
    private String model;
    private String id;
    private String product;

    public String getBrand() {
        return brand;
    }

    void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDevice() {
        return device;
    }

    void setDevice(String device) {
        this.device = device;
    }

    public String getModel() {
        return model;
    }

    void setModel(String model) {
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "DeviceInformation{\n" +
                "'brand'='" + brand + "'\n" +
                ", 'device'='" + device + "'\n"+
                ", 'model'='" + model + "'\n"+
                ", 'id'='" + id + "'\n" +
                ", 'product'='" + product + "'\n" +
                '}';
    }
}
