package ERPMulakat.ERPMulakat.Service;

import ERPMulakat.ERPMulakat.Entities.Shipment;
import ERPMulakat.ERPMulakat.Repo.ShipmentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ShipmentServiceImpl implements ShipmentService{

    private final ShipmentRepo shipmentRepo;
    @Override
    public Shipment saveShipment(Shipment shipment) {
        return shipmentRepo.save(shipment);
    }

    @Override
    public List<Shipment> getShipmentList() {
        return shipmentRepo.findAll();
    }

}
