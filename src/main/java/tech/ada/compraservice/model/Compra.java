package tech.ada.compraservice.model;

import jakarta.persistence.*;
import lombok.Data;
import tech.ada.compraservice.model.enums.StatusCompra;

import java.util.UUID;

@Data
@Entity
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private StatusCompra status;

    private String carrinhoId;
}
