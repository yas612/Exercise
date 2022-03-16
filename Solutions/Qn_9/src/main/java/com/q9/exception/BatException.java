package com.q9.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.q9.bat.ServiceStatus;



@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BatException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private ServiceStatus serviceStatus;

    public BatException(String message, ServiceStatus serviceStatus) {
        super(message);
        this.serviceStatus = serviceStatus;
    }

    public BatException(String message, Throwable e, ServiceStatus serviceStatus) {
        super(message, e);
        this.serviceStatus = serviceStatus;
    }

    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(ServiceStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

}