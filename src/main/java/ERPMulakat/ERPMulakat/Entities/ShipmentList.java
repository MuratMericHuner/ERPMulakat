package ERPMulakat.ERPMulakat.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class ShipmentList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long shipmentListId;

    @ManyToOne
    private Shipment shipment;
    @ManyToOne
    private Product product;

    public ShipmentList(Shipment shipment, Product product, int quantity, double price) {
        this.shipment = shipment;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    private int quantity;
    private double price;
}
