package com.customconcern.awesomeapp;

public class Marker {
    private String color;
    public enum tipTypes{CHISEL, FINE, POINTY};
    private tipTypes tip;
    private String objectId;

    public Marker(){

    }

    public Marker(String color, tipTypes tip) {
        this.color = color;
        this.tip = tip;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public tipTypes getTip() {
        return tip;
    }

    public void setTip(tipTypes tip) {
        this.tip = tip;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
