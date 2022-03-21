package com.demo.kryo.service;

import java.io.IOException;
import java.io.InputStream;

public interface SerializerDeserializer {

    InputStream serialize(Object object) throws IOException;

    Object deserialize(InputStream byteArrayInputStream) throws IOException;
}
