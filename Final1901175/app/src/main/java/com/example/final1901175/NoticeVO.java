package com.example.final1901175;


public class NoticeVO{
    
    /** name */
    private String name;
    
    /** number */
    private String number;
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getNumber() {
        return this.number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "NoticeVO{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
