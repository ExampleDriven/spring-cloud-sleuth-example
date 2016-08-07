package org.exampledriven.sleuth.rest;

import java.util.Date;

/**
 * Created by Peter_Szanto on 8/7/2016.
 */
public class SleepResponse {
    private String message;
    private Date date;

    public SleepResponse() {
    }

    public SleepResponse(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
