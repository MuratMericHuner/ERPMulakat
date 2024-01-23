package ERPMulakat.ERPMulakat.config;

import ERPMulakat.ERPMulakat.Entities.Product;
import ERPMulakat.ERPMulakat.Entities.Shipment;
import ERPMulakat.ERPMulakat.Entities.ShipmentList;
import ERPMulakat.ERPMulakat.Repo.ProductRepo;
import ERPMulakat.ERPMulakat.Repo.ShipmentListRepo;
import ERPMulakat.ERPMulakat.Repo.ShipmentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class DBConfig {

    @Bean
    CommandLineRunner commandLineRunner(ShipmentRepo shipmentRepo, ProductRepo productRepo, ShipmentListRepo shipmentListRepo){
        return args -> {
            Shipment firstShipment = new Shipment(1000);
            Shipment secondShipment = new Shipment(1001);
            Shipment thirdShipment = new Shipment(1002);
            Product firstProduct = new Product(2000);
            Product secondProduct = new Product(2001);
            Product thirdProduct = new Product(2002);
            Product fourtProduct = new Product(2003);
            Product fifthproduct = new Product(2004);
            Product sixthProduct = new Product(2005);
            Product seventhProduct = new Product(2006);
            shipmentRepo.saveAll(List.of(firstShipment,secondShipment,thirdShipment));
            productRepo.saveAll(List.of(firstProduct,secondProduct,thirdProduct,fourtProduct,fifthproduct,sixthProduct,seventhProduct));
            ShipmentList shipmentList = new ShipmentList(firstShipment,firstProduct,12,100.51);
            ShipmentList shipmentList2 = new ShipmentList(firstShipment,secondProduct,31,200);
            ShipmentList shipmentList3 = new ShipmentList(firstShipment,thirdProduct,22,150.86);
            ShipmentList shipmentList4 = new ShipmentList(firstShipment,fourtProduct,41,250);
            ShipmentList shipmentList5 = new ShipmentList(firstShipment,fifthproduct,55,244);
            ShipmentList secondShipmentList = new ShipmentList(secondShipment,secondProduct,88,44.531);
            ShipmentList secondShipmentList2 = new ShipmentList(secondShipment,thirdProduct,121,88.11);
            ShipmentList secondShipmentList3 = new ShipmentList(secondShipment,fifthproduct,74,211);
            ShipmentList secondShipmentList4 = new ShipmentList(secondShipment,thirdProduct,14,88.11);
            ShipmentList thirdShipmentList = new ShipmentList(thirdShipment,fourtProduct,2,12.1);
            ShipmentList thirdShipmentList2 = new ShipmentList(thirdShipment,fifthproduct,3,22.3);
            ShipmentList thirdShipmentList3 = new ShipmentList(thirdShipment,fourtProduct,8,12.1);
            ShipmentList thirdShipmentList4 = new ShipmentList(thirdShipment,thirdProduct,16,94);
            ShipmentList thirdShipmentList5 = new ShipmentList(thirdShipment,sixthProduct,9,44.1);
            ShipmentList thirdShipmentList6 = new ShipmentList(thirdShipment,seventhProduct,19,90);
            shipmentListRepo.saveAll(List.of(shipmentList,shipmentList2,shipmentList3,shipmentList4,shipmentList5,secondShipmentList,secondShipmentList2,
                    secondShipmentList3,secondShipmentList4,thirdShipmentList,thirdShipmentList2,thirdShipmentList3,thirdShipmentList4,thirdShipmentList5,thirdShipmentList6));

        };
    }
}
