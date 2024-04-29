package tech.ada.compraservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ada.compraservice.model.Compra;
import tech.ada.compraservice.model.enums.StatusCompra;
import tech.ada.compraservice.payloads.response.InformarErroResponse;
import tech.ada.compraservice.repository.CompraRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class TratarErroPagamentoService {
    private final CompraRepository compraRepository;

    public void execute(InformarErroResponse informarErroResponse){
        log.info("Tratando a resposta de erro do Pagamento {}", informarErroResponse);
        Compra compra = compraRepository.findById(UUID.fromString(informarErroResponse.getCompraId())).get();
        compra.setStatus(StatusCompra.ERRO);
        compraRepository.save(compra);
    }
}
