package tech.ada.compraservice.payloads.response;

import lombok.Data;

@Data
public class InformarErroResponse {
    private String compraId;
    private String error;
}
