package no.fdk.rabbit;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {

    @Bean
    public Queue compactQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public TopicExchange compactExchange() {
        return new TopicExchange("fdk-sparql-service-compact", false, false);
    }

    @Bean
    Binding updatesBinding(Queue compactQueue, TopicExchange compactExchange) {
        return BindingBuilder
                .bind(compactQueue)
                .to(compactExchange)
                .with("fuseki.compact");
    }
}
