package ERPMulakat.ERPMulakat.Controller;

import ERPMulakat.ERPMulakat.Entities.Shipment;
import ERPMulakat.ERPMulakat.Service.ShipmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shipment")
@AllArgsConstructor
public class ShipmentController {
    private final ShipmentService shipmentService;

    @PostMapping("/save")
    public Shipment saveShipment(@RequestBody Shipment shipment){
        return shipmentService.saveShipment(shipment);
    }

    @GetMapping("/all")
    public List<Shipment> getShipments()
    {
        return shipmentService.getShipmentList();
    }
}
