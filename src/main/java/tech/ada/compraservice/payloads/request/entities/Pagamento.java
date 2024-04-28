package tech.ada.compraservice.payloads.request.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class Pagamento {
    private String numeroCartao;
    private String titular;
    private String ccv;
    private Double valor;
}
