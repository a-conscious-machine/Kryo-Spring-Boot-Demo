package com.demo.kryo.common.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class SomeClass implements Serializable {

    public String value;

}