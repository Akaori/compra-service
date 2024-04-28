package tech.ada.compraservice.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import tech.ada.compraservice.payloads.response.InformarErroResponse;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class InformarErroEstoqueConsumer {
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = {"${negocio.estoque.fila}"})
    public void consumer(Message message , Channel channel)  {
        try {
            String mensagemString = new String(message.getBody());
            InformarErroResponse informarErro = objectMapper.readValue(mensagemString, InformarErroResponse.class);
            log.info("mensagem consumida  {}", informarErro);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
