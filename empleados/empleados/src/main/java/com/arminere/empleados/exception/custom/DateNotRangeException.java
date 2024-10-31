package com.arminere.empleados.exception.custom;

public class DateNotRangeException extends RuntimeException{
    public  DateNotRangeException(String mensaje){
        super(mensaje);
    }
}
