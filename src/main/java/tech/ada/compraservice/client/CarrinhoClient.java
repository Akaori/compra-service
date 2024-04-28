package tech.ada.compraservice.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import tech.ada.compraservice.payloads.response.CarrinhoResponse;

public interface CarrinhoClient {
    @GetExchange(value = "/{carrinhoId}")
    CarrinhoResponse consultarCarrinho(@PathVariable("carrinhoId") String carrinhoId);
}
