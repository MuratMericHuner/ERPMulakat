package ERPMulakat.ERPMulakat.Repo;

import ERPMulakat.ERPMulakat.Entities.Shipment;
import ERPMulakat.ERPMulakat.Entities.ShipmentList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipmentListRepo extends JpaRepository<ShipmentList,Long> {

}
