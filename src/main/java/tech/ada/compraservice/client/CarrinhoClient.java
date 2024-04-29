package tech.ada.compraservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.ada.compraservice.payloads.response.CarrinhoResponse;

@FeignClient(name = "carrinhoClient", url = "${negocio.carrinho.url}")
public interface CarrinhoClient {
    @RequestMapping(method = RequestMethod.GET, value = "/{carrinhoId}")
    CarrinhoResponse consultarCarrinho(@PathVariable("carrinhoId") String carrinhoId);
}