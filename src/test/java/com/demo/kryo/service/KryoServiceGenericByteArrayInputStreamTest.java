package com.demo.kryo.service;

import com.demo.kryo.common.models.SomeClass;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static com.demo.kryo.common.models.Utils.*;
import static org.junit.Assert.assertEquals;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class KryoServiceGenericByteArrayInputStreamTest {

  @InjectMocks
  private KryoServiceGenericByteArrayInputStream kryoServiceGenericByteArrayInputStream;

  @BeforeEach
  void setUp() {
  }

  @Test
  public void testSerializeMap() throws IOException {
    String name = "Ajay";
    InputStream inputStream = kryoServiceGenericByteArrayInputStream.serialize(getMapObjInput(name));
    HashMap<String, String> deserializedObj = (HashMap) kryoServiceGenericByteArrayInputStream.deserialize(inputStream);
    assertEquals(name, deserializedObj.get("Custom"));
  }

  @Test
  public void testSerializeSomeClass() throws IOException {
    String name = "Ajay";
    InputStream inputStream = kryoServiceGenericByteArrayInputStream.serialize(getSomeClassObjInp(name));
    SomeClass deserializedObj = (SomeClass) kryoServiceGenericByteArrayInputStream.deserialize(inputStream);
    assertEquals(name, deserializedObj.value);
  }
}