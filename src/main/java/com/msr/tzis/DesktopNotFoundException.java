package com.msr.tzis;

public class DesktopNotFoundException extends RuntimeException{

    public DesktopNotFoundException(Long id){
        super("Could not find desktop " + id);
    }
}
