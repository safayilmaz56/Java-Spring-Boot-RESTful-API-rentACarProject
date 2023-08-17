package teknopar.RentACar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teknopar.RentACar.model.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    Car getByModel(String model);
    List<Car> getByModelContains(String aracModel);

    List<Car> getByBrand_BrandId(int markaId);

}
