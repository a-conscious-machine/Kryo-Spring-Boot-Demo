//package com.demo.kryo.service;
//
//import com.esotericsoftware.kryo.Kryo;
//import com.esotericsoftware.kryo.io.Input;
//import com.esotericsoftware.kryo.io.Output;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//
//@Slf4j
//@Service
//public class KryoServiceGenericByteArray implements SerializerDeserializer {
//
//    Kryo kryo = new Kryo();
//
////    @Autowired
////    public KryoServiceByteArrayInputStream() {
////    }
//
//    @Override
//    public byte[] serialize(Object inputObject) {
//        log.info("InputObject: {}", inputObject);
//        kryo.register(inputObject.getClass());
//        Output byteArrayOutputStream = new Output(new ByteArrayOutputStream());
//        kryo.writeClassAndObject(byteArrayOutputStream, inputObject);
//        return byteArrayOutputStream.toBytes();
//    }
//
//    @Override
//    public Object deserialize(byte[] inputBytes) {
//        Input input = new Input(inputBytes);
//        Object object = kryo.readClassAndObject(input);
//        input.close();
//        return object;
//    }
//
////    @Override
////    public Object deserialize(byte[] inputBytes, Class<?> clazz) {
////        Kryo kryo = new Kryo();
////        kryo.register(clazz);
////        Input input = new Input(inputBytes);
////        Object object = kryo.readObject(input, clazz);
////        input.close();
////        return object;
////    }
//
//}
