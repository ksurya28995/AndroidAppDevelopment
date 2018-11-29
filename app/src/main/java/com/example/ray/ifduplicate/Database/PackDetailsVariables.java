package com.example.ray.ifduplicate.Database;

public class PackDetailsVariables {

    private String price;
    private String validity;
    private String talktime;
    private String message;

   /* public PackDetailsVariables(String price, String validity, String talktime, String message){
        this.price = price;
        this.validity = validity;
        this.talktime = talktime;
        this.message = message;
    }*/

    public String getPrice() {
        return price;
    }

    public  void setPrice(String price) {
        this.price = price;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getTalktime() {
        return talktime;
    }

    public void setTalktime(String talktime) {
        this.talktime = talktime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
