package tech.ada.compraservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ada.compraservice.model.Compra;
import tech.ada.compraservice.model.enums.StatusCompra;
import tech.ada.compraservice.payloads.request.CompraRequest;
import tech.ada.compraservice.payloads.response.CompraInfoResponse;
import tech.ada.compraservice.payloads.response.CompraResponse;
import tech.ada.compraservice.payloads.response.InformarErroResponse;
import tech.ada.compraservice.repository.CompraRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AtualizarCompraService {

    private final CompraRepository compraRepository;

    public void execute(CompraInfoResponse compraInfoResponse){
        log.info("Atualizando o status da Compra {}", compraInfoResponse);

        Compra compra = compraRepository.findById(UUID.fromString(compraInfoResponse.getCompraId())).get();

        if (compra.getStatus() == StatusCompra.INICIADA && !compraInfoResponse.getPagamentoId().isBlank()) {
            compra.setStatus(StatusCompra.AGUARDANDO_ENVIO);
            compraRepository.save(compra);
        } else if (compra.getStatus() == StatusCompra.AGUARDANDO_ENVIO && !compraInfoResponse.getEnvioId().isBlank()) {
            compra.setStatus(StatusCompra.AGUARDANDO_ENTREGA);
            compraRepository.save(compra);
        }

    }

}
