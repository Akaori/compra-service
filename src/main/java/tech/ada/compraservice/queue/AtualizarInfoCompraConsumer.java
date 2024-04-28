package tech.ada.compraservice.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;
import tech.ada.compraservice.payloads.response.CompraInfoResponse;
import tech.ada.compraservice.service.AtualizarCompraService;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AtualizarInfoCompraConsumer {

    private final ObjectMapper objectMapper;
    private final AtualizarCompraService atualizarCompraService;

    @RabbitListener(queues = {"${negocio.compra.fila}"})
    public void consumer(Message message , Channel channel)  {
        try {
            String mensagemString = new String(message.getBody());
            CompraInfoResponse compraInfo = objectMapper.readValue(mensagemString, CompraInfoResponse.class);
            log.info("Mensagem de informação da Compra consumida  {}", compraInfo);
            atualizarCompraService.execute(compraInfo);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
