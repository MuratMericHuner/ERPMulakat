package ERPMulakat.ERPMulakat.Service;

import ERPMulakat.ERPMulakat.Entities.Product;
import ERPMulakat.ERPMulakat.Repo.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;
    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }
}
