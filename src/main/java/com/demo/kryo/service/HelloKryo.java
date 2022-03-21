//package com.demo.kryo.service;
//import com.esotericsoftware.kryo.Kryo;
//import com.esotericsoftware.kryo.io.Input;
//import com.esotericsoftware.kryo.io.Output;
//import java.io.*;
//
//public class HelloKryo {
//
//    private void process() {
//        try {
//        Kryo kryo = new Kryo();
//        kryo.register(SomeClass.class);
//
//        SomeClass object = new SomeClass();
//        object.value = "Hello Kryo!";
//
//        Output output = new Output(new FileOutputStream("file.bin"));
//        kryo.writeObject(output, object);
//        output.close();
//
//        Input input = new Input(new FileInputStream("file.bin"));
//        SomeClass object2 = kryo.readObject(input, SomeClass.class);
//        input.close();
//        } catch (Exception e) {
//            ;
//        }
//    }
//
//    public static void main (String[] args) {
//        HelloKryo helloKryo = new HelloKryo();
//        helloKryo.process();
//    }
//
//}
