package com.example.libraryconsumer.config;

import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.rest.exceptions.RestClientException;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumWriter;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

public class CustomDeserializerAvro<T> implements Deserializer<T> {
    public Schema getSchema() throws RestClientException, IOException {

        CachedSchemaRegistryClient client = new CachedSchemaRegistryClient("http://localhost:8085", 1000);

        return client.getBySubjectAndID("LibraryEventTransport", 9);

    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public T deserialize(String s, byte[] bytes) {

            GenericData genericData = new ReflectData();
            try(InputStream inputStream = new ByteArrayInputStream(bytes)) {
                BinaryMessageDecoder<T> binaryMessageDecoder= new BinaryMessageDecoder<>(genericData, getSchema());



                return binaryMessageDecoder.decode(inputStream, null);

            } catch (RestClientException | IOException e) {
                throw new RuntimeException(e);
            }

    }

    @Override
    public T deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
