package teknopar.RentACar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teknopar.RentACar.model.Rented;

public interface RentedRepository extends JpaRepository<Rented,Integer> {


}
