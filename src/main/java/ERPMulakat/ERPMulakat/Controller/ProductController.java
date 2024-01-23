package ERPMulakat.ERPMulakat.Controller;

import ERPMulakat.ERPMulakat.Entities.Product;
import ERPMulakat.ERPMulakat.Entities.Shipment;
import ERPMulakat.ERPMulakat.Service.ProductService;
import ERPMulakat.ERPMulakat.Service.ShipmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getProductList()
    {
        return productService.getProducts();
    }
}
