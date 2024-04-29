package tech.ada.compraservice.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import tech.ada.compraservice.payloads.response.InformarErroResponse;
import tech.ada.compraservice.service.TratarErroPagamentoService;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class InformarErroPagamentoConsumer {
    private final ObjectMapper objectMapper;
    private final TratarErroPagamentoService tratarErroPagamentoService;

    @RabbitListener(queues = {"${negocio.pagamento.fila}"})
    public void consumer(Message message , Channel channel)  {
        try {
            String mensagemString = new String(message.getBody());
            InformarErroResponse informarErro = objectMapper.readValue(mensagemString, InformarErroResponse.class);
            log.info("Mensagem de erro do Pagamento consumida {}", informarErro);
            tratarErroPagamentoService.execute(informarErro);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
