package com.example.finalyear;
public class BookingHelper {
    String vehicle;
    String username;
    String contact_number;
    String vehicle_model;
    String vehicle_number;
    String date;
    String time;


    public BookingHelper(String username, String contact_number, String vehicle_model, String vehicle_number, String date, String time) {

    }

    public BookingHelper(String vehicle, String username, String contact_number, String vehicle_model, String vehicle_number, String date, String time) {
        this.vehicle = vehicle;
        this.username = username;
        this.contact_number = contact_number;
        this.vehicle_model = vehicle_model;
        this.vehicle_number = vehicle_number;
        this.date = date;
        this.time = time;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}