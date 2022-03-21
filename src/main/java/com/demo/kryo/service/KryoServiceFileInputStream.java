//package com.demo.kryo.service;
//
//import com.demo.kryo.common.models.SomeClass;
//import com.esotericsoftware.kryo.Kryo;
//import com.esotericsoftware.kryo.io.Input;
//import com.esotericsoftware.kryo.io.Output;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.io.*;
//
//
//@Slf4j
//@Service
//public class KryoServiceFileInputStream implements SerializerDeserializer {
//
//    @Override
//    public byte[] serialize(Object object) throws FileNotFoundException {
//        Kryo kryo = new Kryo();
//        kryo.register(SomeClass.class);
//
//        SomeClass someClass = new SomeClass();
//        someClass.value = "Hello Kryo!";
//
//        Output output = new Output(new FileOutputStream("file.bin"));
//        kryo.writeObject(output, object);
//        output.close();
//        return null;
//    }
//
//    @Override
//    public Object deserialize(InputStream byteArrayInputStream) throws IOException {
//        Kryo kryo = new Kryo();
//        kryo.register(SomeClass.class);
//        Input input = new Input(new FileInputStream("file.bin"));
//        SomeClass object2 = kryo.readObject(input, SomeClass.class);
//        input.close();
//        return object2;
//    }
//}
