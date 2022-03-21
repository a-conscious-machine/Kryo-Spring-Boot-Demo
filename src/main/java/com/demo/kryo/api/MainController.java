package com.demo.kryo.api;

import com.demo.kryo.common.models.SomeClass;
import com.demo.kryo.service.SerializerDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static com.demo.kryo.common.models.Utils.getObject;

@Slf4j
@RestController
public class MainController {

    @Autowired
    private SerializerDeserializer kryoService;
//    private KryoServiceByteArrayInputStream kryoService;
//    private KryoServiceFileInputStream kryoService;

    private InputStream tempInputStream;
//    private InputStream tempBytes;

    @GetMapping("/hello")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return name;
    }

    @GetMapping("/kryoSerialize")
    public String kryoSerialize(@RequestParam(value = "name", defaultValue = "World") String name) throws IOException {
        InputStream inputStream = kryoService.serialize(getObject(name));
        byte[] serializedBytes = inputStream.readAllBytes();
        log.info("inputStream: {}, {}", inputStream, serializedBytes);
        log.info("inputStream: {}, {}", inputStream, inputStream.readAllBytes());
        tempInputStream = new ByteArrayInputStream(serializedBytes);
        tempInputStream.close();
        String resp = "Serialized: " + name + Arrays.toString(tempInputStream.readAllBytes());
        log.info("Serialized Value: {}, {}, {}", name, tempInputStream.readAllBytes(), resp);
        return resp;
    }

    @GetMapping("/kryoDeserialize")
    public String kryoDeserialize() throws IOException {
        SomeClass deserialized = (SomeClass) kryoService.deserialize(tempInputStream);
        log.info("Deserialized Value: {}", deserialized);
        return "Deserialized: " + deserialized.value;
    }

//    @GetMapping("/kryoDeserialize")
//    public String kryoDeserialize() {
//        SomeClass deserialized = (SomeClass) kryoService.deserialize(tempBytes);
//        log.info("Deserialized Value: {}", deserialized);
//        return "Deserialized: " + deserialized.value;
//    }
}
