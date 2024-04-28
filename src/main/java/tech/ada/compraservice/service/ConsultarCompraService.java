package tech.ada.compraservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.compraservice.mapping.ConvertCompraToCompraResponse;
import tech.ada.compraservice.model.Compra;
import tech.ada.compraservice.payloads.response.CompraResponse;
import tech.ada.compraservice.repository.CompraRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConsultarCompraService {

    private final CompraRepository compraRepository;

    @Transactional
    public CompraResponse execute(String compraId) {
        Compra compra = compraRepository.getReferenceById(UUID.fromString(compraId));
        return ConvertCompraToCompraResponse.convertToCompraResponse(compra);
    }
}
