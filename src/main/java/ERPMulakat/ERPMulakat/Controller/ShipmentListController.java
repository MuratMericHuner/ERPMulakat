package ERPMulakat.ERPMulakat.Controller;

import ERPMulakat.ERPMulakat.Entities.Product;
import ERPMulakat.ERPMulakat.Entities.Shipment;
import ERPMulakat.ERPMulakat.Entities.ShipmentList;
import ERPMulakat.ERPMulakat.Service.ShipmentListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("shipments")
@AllArgsConstructor
public class ShipmentListController {

    private final ShipmentListService shipmentListService;

    @PostMapping("/save")
    public ShipmentList saveShipmentList(@RequestBody ShipmentList shipmentList){
        return shipmentListService.saveShipmentList(shipmentList);
    }

    @GetMapping("/all")
    public List<ShipmentList> getShipmentLists()
    {
        return shipmentListService.getShipmentLists();
    }

    @GetMapping("/total/{id}")
    public double getShipmentListTotalById(@PathVariable("id")Shipment shipment){
        return shipmentListService.getTotalById(shipment);
    }
    @GetMapping("/total")
    public double getShipmentListTotal(){
        return shipmentListService.getTotal();
    }

    @GetMapping("/average/{id}")
    public double getShipmentListAverageById(@PathVariable("id")Shipment shipment){
        return shipmentListService.getAverageById(shipment);
    }

    @GetMapping("/average")
    public double getShipmentListAverage(){
        return shipmentListService.getAverage();
    }

    @GetMapping("/averageproduct/{id}")
    public double getShipmentListAverageProduct(@PathVariable("id") Product product){
        return shipmentListService.getAverageProduct(product);
    }

    @GetMapping("/totalproduct/{id}")
    public Map<Shipment,Integer> getShipmentListTotalProduct(@PathVariable("id") Product product){
        return shipmentListService.getTotalProductQuantity(product);
    }
}
