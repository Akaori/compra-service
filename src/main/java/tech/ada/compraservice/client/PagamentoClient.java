package tech.ada.compraservice.client;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.ada.compraservice.payloads.request.PagamentoRequest;

@FeignClient(name = "pagamentoClient", url = "${negocio.pagamento.url}")
public interface PagamentoClient {
    @RequestMapping(method = RequestMethod.POST, value = "/", consumes = "application/json")
    void realizarPagamento(@RequestBody PagamentoRequest pagamento);
}