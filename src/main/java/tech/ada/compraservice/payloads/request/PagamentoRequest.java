package tech.ada.compraservice.payloads.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import tech.ada.compraservice.payloads.request.entities.Envio;

@Data
@Schema
public class PagamentoRequest {
    private String compraId;
    private String clienteId;
    private String numeroCartao;
    private String titular;
    private String ccv;
    private Double valor;
    private Envio envio;
}
