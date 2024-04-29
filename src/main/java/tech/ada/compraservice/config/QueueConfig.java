package tech.ada.compraservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Value("${negocio.compra.fila}")
    private String compraQueueResponse;

    @Value("${negocio.pagamento.fila}")
    private String pagamentoQueueResponse;

    @Value("${negocio.estoque.fila}")
    private String estoqueQueueResponse;

    @Value("${negocio.envio.fila}")
    private String envioQueueResponse;

    @Value("${negocio.error.routingkey}")
    private String errorRoutingKey;

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topic-exchange");
    }

    @Bean
    public Queue compraQueue() {
        return new Queue(compraQueueResponse, true);
    }

    @Bean
    public Queue pagamentoQueue() {
        return new Queue(pagamentoQueueResponse, true);
    }

    @Bean
    Binding pagamentoBinding(Queue pagamentoQueue, TopicExchange exchange) {
        return BindingBuilder.bind(pagamentoQueue).to(exchange).with(errorRoutingKey);
    }

    @Bean
    public Queue estoqueQueue() {
        return new Queue(estoqueQueueResponse, true);
    }

    @Bean
    Binding estoqueBinding(Queue estoqueQueue, TopicExchange exchange) {
        return BindingBuilder.bind(estoqueQueue).to(exchange).with(errorRoutingKey);
    }

    @Bean
    public Queue envioQueue() {
        return new Queue(envioQueueResponse, true);
    }

    @Bean
    Binding envioBinding(Queue envioQueue, TopicExchange exchange) {
        return BindingBuilder.bind(envioQueue).to(exchange).with(errorRoutingKey);
    }
}
