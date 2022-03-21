//package com.demo.kryo.service;
//
//import com.demo.kryo.common.models.SomeClass;
//import com.esotericsoftware.kryo.Kryo;
//import com.esotericsoftware.kryo.io.Input;
//import com.esotericsoftware.kryo.io.Output;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Arrays;
//
//@Slf4j
//@Service
//public class KryoServiceByteArrayInputStream implements SerializerDeserializer {
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
//        kryo.register(SomeClass.class);
//        Output byteArrayOutputStream = new Output(new ByteArrayOutputStream());
//        kryo.writeObject(byteArrayOutputStream, inputObject);
//        byte[] outbytes = byteArrayOutputStream.toBytes();
//        byteArrayOutputStream.close();
//        InputStream byteArrayInputStream = new ByteArrayInputStream(outbytes);
//        log.info("byteArrayInputStream: {}", byteArrayInputStream.toString());
//        log.info("outputSerializedBytes: {}", Arrays.toString(outbytes));
//        SomeClass someClassCrossCheck = kryo.readObject(new Input(outbytes), SomeClass.class);
//        log.info("Cross-Check val: {}", someClassCrossCheck.value);
////        log.info("Cross-Check val: {}", kryo.readObject(new Input(new ByteArrayInputStream(byteArrayOutputStream.toBytes())), SomeClass.class));
//        return byteArrayInputStream;
//    }
//
//    @Override
//    public Object deserialize(InputStream byteArrayInputStream) throws IOException {
////        Kryo kryo = new Kryo();
//        kryo.register(SomeClass.class);
//        log.info("byteArrayInputStream: {}", byteArrayInputStream);
//        byte[] inputSerializedBytes = byteArrayInputStream.readAllBytes();
//        log.info("inputSerializedBytes: {}", Arrays.toString(inputSerializedBytes));
//        Input input = new Input(inputSerializedBytes);
//        Object object = kryo.readObject(input, SomeClass.class);
//        input.close();
//        return object;
//    }
//
//}
