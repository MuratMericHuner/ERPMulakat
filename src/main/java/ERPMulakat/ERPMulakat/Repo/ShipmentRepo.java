package ERPMulakat.ERPMulakat.Repo;

import ERPMulakat.ERPMulakat.Entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepo extends JpaRepository<Shipment,Long> {
}
