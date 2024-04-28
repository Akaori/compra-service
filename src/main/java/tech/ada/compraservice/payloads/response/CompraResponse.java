package tech.ada.compraservice.payloads.response;

import lombok.Data;

@Data
public class CompraResponse {
    private String compraId;
    private String psgamentoId;
    private String envioId;
    private String status;
}
