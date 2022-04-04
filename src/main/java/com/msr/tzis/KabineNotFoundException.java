package com.msr.tzis;

public class KabineNotFoundException extends RuntimeException{

    public KabineNotFoundException(Long id){
        super("Could not find cabin " + id);
    }
}
