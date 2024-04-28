package tech.ada.compraservice.client;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import tech.ada.compraservice.payloads.request.PagamentoRequest;

public interface PagamentoClient {
    @PostExchange(value = "/")
    void realizarPagamento(@RequestBody PagamentoRequest pagamento);
}
