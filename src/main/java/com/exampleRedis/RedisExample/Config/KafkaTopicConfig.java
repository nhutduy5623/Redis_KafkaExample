package com.exampleRedis.RedisExample.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic notification() {
        // TopicName, Number partition, replication number
        return new NewTopic("add_student1", 1, (short) 1);
    }

}
