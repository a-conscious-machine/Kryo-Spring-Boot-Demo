package com.demo.kryo.service;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Service
public class KryoServiceGenericByteArrayInputStream implements SerializerDeserializer {

    Kryo kryo = new Kryo();

//    @Autowired
//    public KryoServiceByteArrayInputStream() {
//    }

    @Override
    public InputStream serialize(Object inputObject) throws IOException {
        log.info("InputObject: {}", inputObject);
        kryo.register(inputObject.getClass());
        Output outputBAOStream = new Output(new ByteArrayOutputStream());
        kryo.writeClassAndObject(outputBAOStream, inputObject);
        byte[] outputBytes = outputBAOStream.toBytes();
        InputStream byteArrayInputStream = new ByteArrayInputStream(outputBytes);
        log.info("serialized byte[]: {}, {}, {}", byteArrayInputStream, outputBytes, outputBytes.length);
        byteArrayInputStream.close();
        return byteArrayInputStream;
    }

    @Override
    public Object deserialize(InputStream byteArrayInputStream) throws IOException {
        log.info("to be deserialized byte[]: {}", byteArrayInputStream);
        Input input = new Input(byteArrayInputStream.readAllBytes());
//        Input input = new Input(byteArrayInputStream);
        Object object = kryo.readClassAndObject(input);
        log.info("Object: {}", object);
        input.close();
        return object;
    }

//    @Override
//    public Object deserialize(byte[] inputBytes, Class<?> clazz) {
//        Kryo kryo = new Kryo();
//        kryo.register(clazz);
//        Input input = new Input(inputBytes);
//        Object object = kryo.readObject(input, clazz);
//        input.close();
//        return object;
//    }

}
