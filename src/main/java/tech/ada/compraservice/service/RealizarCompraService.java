package tech.ada.compraservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ada.compraservice.client.CarrinhoClient;
import tech.ada.compraservice.client.PagamentoClient;
import tech.ada.compraservice.model.Compra;
import tech.ada.compraservice.model.enums.StatusCompra;
import tech.ada.compraservice.payloads.request.CompraRequest;
import tech.ada.compraservice.payloads.request.PagamentoRequest;
import tech.ada.compraservice.payloads.response.CarrinhoResponse;
import tech.ada.compraservice.payloads.response.CompraResponse;
import tech.ada.compraservice.repository.CompraRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class RealizarCompraService {

    private final CompraRepository compraRepository;
    private final CarrinhoClient carrinhoClient;
    private final PagamentoClient pagamentoClient;

    public CompraResponse realizarCompra(CompraRequest compraRequest) {
        log.info("Recebendo solicitacao de compra {}", compraRequest);

        Compra compra = new Compra();
        compra.setCarrinhoId(compraRequest.getCarrinhoId());
        compra.setStatus(StatusCompra.INICIADA);

        // Salvar compra para obter o ID da compra
        Compra savedCompra = compraRepository.save(compra);

        // Conectar com o Carrinho via REST para obter o valor total para enviar para pagamento
        CarrinhoResponse carrinhoResponse = carrinhoClient.consultarCarrinho(compraRequest.getCarrinhoId());

        // Prepara request para enviar o pagamento
        PagamentoRequest pagamentoRequest = new PagamentoRequest();
        pagamentoRequest.setCompraId(savedCompra.getId().toString());
        pagamentoRequest.setClienteId(compraRequest.getClienteId());
        pagamentoRequest.setNumeroCartao(compraRequest.getPagamento().getNumeroCartao());
        pagamentoRequest.setTitular(compraRequest.getPagamento().getTitular());
        pagamentoRequest.setCcv(compraRequest.getPagamento().getCcv());
        pagamentoRequest.setValor(carrinhoResponse.getValorTotal());
        pagamentoRequest.setEnvio(compraRequest.getEnvio());

        // Enviar REST api request para realizar Pagamento
        pagamentoClient.realizarPagamento(pagamentoRequest);

        // Retornar CompraResponse com o ID da compra salva
        CompraResponse compraResponse = new CompraResponse();
        compraResponse.setCompraId(savedCompra.getId().toString());

        return compraResponse;
    }
}
