package com.example.spring.exercise.kafka;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * 生产者.
 */
@SpringBootTest
public class KfkProducer {
  public static void main(String[] args) {
    Map<String, Object> props = new HashMap<String, Object>();
    props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    String topic = "test-topic";
    Producer<String, String> producer = new KafkaProducer<String, String>(props);
    producer.send(new ProducerRecord(topic, "idea-key2", "java-message 1"));
    producer.send(new ProducerRecord(topic, "idea-key2", "java-message 2"));
    producer.send(new ProducerRecord(topic, "idea-key2", "java-message 3"));

    producer.close();
  }
}
