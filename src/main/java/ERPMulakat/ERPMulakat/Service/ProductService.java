package ERPMulakat.ERPMulakat.Service;

import ERPMulakat.ERPMulakat.Entities.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);
    List<Product> getProducts();
}
