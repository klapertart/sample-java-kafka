package klapertart.lab.belajarkafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class BelajarKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BelajarKafkaApplication.class, args);

		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());


		Producer<String, String> producer = new KafkaProducer<>(properties);
		for (int i = 0; i < 100; i++){
			ProducerRecord<String, String> record = new ProducerRecord<>("java-topic", "Data ke " + i);
			producer.send(record);
		}

		producer.close();

	}

}
