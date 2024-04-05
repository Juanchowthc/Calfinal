package com.example.calculadora20;

import java.io.Serializable;

public class Message implements Serializable {

    private String information;
    private String result;

    public String getInformation(){
        return  this.information;
    }

    public String getResult(){
        return this.result;
    }

    public void setnformation(String information){
        this.information = information;
    }

    public void setResult(String result){
        this.result = result;
    }
}

