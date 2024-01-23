package ERPMulakat.ERPMulakat.Service;

import ERPMulakat.ERPMulakat.Entities.Product;
import ERPMulakat.ERPMulakat.Entities.Shipment;
import ERPMulakat.ERPMulakat.Entities.ShipmentList;

import java.util.List;
import java.util.Map;

public interface ShipmentListService {
    ShipmentList saveShipmentList(ShipmentList shipmentList);
    List<ShipmentList> getShipmentLists();

    double getTotalById(Shipment shipment);

    double getTotal();
    double getAverageById(Shipment shipment);

    double getAverage();

    double getAverageProduct(Product product);

    Map<Shipment,Integer> getTotalProductQuantity(Product product);
}
