package tech.ada.compraservice.model;

import jakarta.persistence.*;
import lombok.Data;
import tech.ada.compraservice.model.enums.StatusCompra;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private BigDecimal valorTotal;

    private StatusCompra status;
}
