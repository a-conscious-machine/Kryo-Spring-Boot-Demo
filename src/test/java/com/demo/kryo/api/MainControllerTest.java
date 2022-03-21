package com.demo.kryo.api;

import com.demo.kryo.common.models.SomeClass;
import com.demo.kryo.service.KryoServiceGenericByteArrayInputStream;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class MainControllerTest {

  private String name;

  @Mock
  private KryoServiceGenericByteArrayInputStream kryoService;

  @InjectMocks
  private MainController mainController;

  @BeforeEach
  void setUp() throws IOException {
    name = "Hello";
    InputStream inputStream = new ByteArrayInputStream(new byte[] {1, 2, 3, 4});
    when(kryoService.serialize(any())).thenReturn(inputStream);
    SomeClass deserializedObject = new SomeClass();
    deserializedObject.setValue(name);
    when(kryoService.deserialize(any())).thenReturn(deserializedObject);
  }

  @Test
  public void testKryoSerialize() throws IOException {
    String serialized_val = mainController.kryoSerialize(name);
    log.info("serialized_val: {}", serialized_val);
    assertEquals("Serialized: " + name + "[1, 2, 3, 4]", serialized_val);
  }

  @Test
  public void testKryoDeSerialize() throws IOException {
    String serialized_val = mainController.kryoDeserialize();
    assertEquals("Deserialized: " + name, serialized_val);
  }
}