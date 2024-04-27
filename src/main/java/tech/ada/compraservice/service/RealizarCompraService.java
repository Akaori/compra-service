package tech.ada.compraservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ada.compraservice.model.Compra;
import tech.ada.compraservice.model.enums.StatusCompra;
import tech.ada.compraservice.payloads.request.CompraRequest;
import tech.ada.compraservice.payloads.response.CompraResponse;
import tech.ada.compraservice.repository.CompraRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class RealizarCompraService {

    private final CompraRepository compraRepository;

    public CompraResponse realizarCompra(CompraRequest compraRequest) {
        Compra compra = new Compra();
        compra.setStatus(StatusCompra.PENDENTE);
        log.info("Recebendo solicitacao de venda {}", compraRequest);
        compraRepository.save(compra);
        return null;
    }
}
