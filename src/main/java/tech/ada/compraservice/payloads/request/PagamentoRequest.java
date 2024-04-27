package tech.ada.compraservice.payloads.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class PagamentoRequest {
    private String numeroCartao;
    private String titular;
    private String ccv;
    private Double valor;
}
