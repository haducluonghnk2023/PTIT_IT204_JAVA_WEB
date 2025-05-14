package com.data.session07.model;

public class FeedBack {
    private String fullName;
    private String phone;
    private String address;
    private String content;

    public FeedBack() {
    }

    public FeedBack(String fullName, String phone, String address, String content) {
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.content = content;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
