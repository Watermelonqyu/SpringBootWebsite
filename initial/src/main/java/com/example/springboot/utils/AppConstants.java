package com.example.springboot.utils;

/*
 * Constants for the project
 */
public enum AppConstants {
    LOGIN("login", 200),
    LOGIN_FAILED("Log in failed!", 404);
    
    /*
     * message
     */
    public final String message;
    
    /*
     * code
     */
    public final int code;
    
    /*
     * Element
     */
    private AppConstants(String message, int code) {
        this.message = message;
        this.code = code;
    }

    /*
     * toString
     */
    @Override
    public String toString() { 
        return this.message; 
    }

    /*
     * getMessage
     */
    public String getMessage() {
        return this.message;
    }

    /*
     * getCode
     */
    public int getCode() {
        return this.code;
    }
}