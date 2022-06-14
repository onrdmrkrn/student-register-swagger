package com.example.finaltask.response;

import java.io.Serializable;

public class Meta implements Serializable {
    public String errorDesc;
    public int errorCode;

    public Meta() {
    }

    public Meta(String errorDesc, int errorCode) {
        this.errorDesc = errorDesc;
        this.errorCode = errorCode;

    }
}
