package com.arminere.empleados.exception.custom;

public class ResourcesNotFoundException extends RuntimeException{

    public ResourcesNotFoundException(String message){
        super(message);
    }
}
