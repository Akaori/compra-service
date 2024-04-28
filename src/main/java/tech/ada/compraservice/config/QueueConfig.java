package tech.ada.compraservice.config;

import org.springframework.amqp.core.Queue;
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

    @Bean
    public Queue compraQueue() {
        return new Queue(compraQueueResponse, true);
    }

    @Bean
    public Queue pagamentoQueue() {
        return new Queue(pagamentoQueueResponse, true);
    }

    @Bean
    public Queue estoqueQueue() {
        return new Queue(estoqueQueueResponse, true);
    }

    @Bean
    public Queue envioQueue() {
        return new Queue(envioQueueResponse, true);
    }

}
