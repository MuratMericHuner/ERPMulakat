package ERPMulakat.ERPMulakat.Service;

import ERPMulakat.ERPMulakat.Entities.Shipment;
import ERPMulakat.ERPMulakat.Entities.ShipmentList;

import java.util.List;

public interface ShipmentService {
    Shipment saveShipment(Shipment shipment);
    List<Shipment> getShipmentList();

}
