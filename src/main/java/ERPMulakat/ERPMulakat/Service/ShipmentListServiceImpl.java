package ERPMulakat.ERPMulakat.Service;

import ERPMulakat.ERPMulakat.Entities.Product;
import ERPMulakat.ERPMulakat.Entities.Shipment;
import ERPMulakat.ERPMulakat.Entities.ShipmentList;
import ERPMulakat.ERPMulakat.Repo.ShipmentListRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ShipmentListServiceImpl implements ShipmentListService {
    private final ShipmentListRepo shipmentListRepo;
    @Override
    public ShipmentList saveShipmentList(ShipmentList shipmentList) {
        return shipmentListRepo.save(shipmentList);
    }

    @Override
    public List<ShipmentList> getShipmentLists() {
        return shipmentListRepo.findAll();
    }

    @Override
    public double getTotalById(Shipment shipment) {
        List<ShipmentList> ShipmentList = shipmentListRepo.findAll().stream().filter(x->x.getShipment().equals(shipment)).toList();
        return ShipmentList.stream().mapToDouble(x-> (x.getQuantity()*x.getPrice())).reduce(Double::sum).orElse(0);
    }

    @Override
    public double getTotal() {
        List<ShipmentList> ShipmentList = shipmentListRepo.findAll();
        return ShipmentList.stream().mapToDouble(x-> (x.getQuantity()*x.getPrice())).reduce(Double::sum).orElse(0);
    }

    @Override
    public double getAverageById(Shipment shipment) {
        List<ShipmentList> ShipmentList = shipmentListRepo.findAll().stream().filter(x->x.getShipment().equals(shipment)).toList();
        int totalQuantity = ShipmentList.stream().map(ERPMulakat.ERPMulakat.Entities.ShipmentList::getQuantity).reduce(Integer::sum).orElse(0);
        return ShipmentList.stream().mapToDouble(x-> (x.getQuantity()*x.getPrice())).reduce(Double::sum).orElse(0)/totalQuantity;
    }

    @Override
    public double getAverage() {
        List<ShipmentList> ShipmentList = shipmentListRepo.findAll();
        int totalQuantity = ShipmentList.stream().map(ERPMulakat.ERPMulakat.Entities.ShipmentList::getQuantity).reduce(Integer::sum).orElse(0);
        return ShipmentList.stream().mapToDouble(x-> (x.getQuantity()*x.getPrice())).reduce(Double::sum).orElse(0)/totalQuantity;
    }

    @Override
    public double getAverageProduct(Product product) {
        List<ShipmentList> ShipmentList = shipmentListRepo.findAll().stream().filter(x->x.getProduct().equals(product)).toList();
        int totalQuantity = ShipmentList.stream().map(ERPMulakat.ERPMulakat.Entities.ShipmentList::getQuantity).reduce(Integer::sum).orElse(0);
        return ShipmentList.stream().mapToDouble(x-> (x.getQuantity()*x.getPrice())).reduce(Double::sum).orElse(0)/totalQuantity;
    }


    @Override
    public Map<Shipment,Integer> getTotalProductQuantity(Product product) {
        List<ShipmentList> ShipmentList = shipmentListRepo.findAll().stream().filter(x->x.getProduct().equals(product)).toList();
        Map<Shipment,Integer> productQuantityInShipment = new HashMap<>();
        for (ERPMulakat.ERPMulakat.Entities.ShipmentList shipmentList : ShipmentList) {
            if (productQuantityInShipment.containsKey(shipmentList.getShipment())) {
                int quantity = productQuantityInShipment.get(shipmentList.getShipment());
                productQuantityInShipment.put(shipmentList.getShipment(), quantity+shipmentList.getQuantity());
            }else{
                productQuantityInShipment.put(shipmentList.getShipment(), shipmentList.getQuantity());
            }

        }
        return productQuantityInShipment;
    }
}
