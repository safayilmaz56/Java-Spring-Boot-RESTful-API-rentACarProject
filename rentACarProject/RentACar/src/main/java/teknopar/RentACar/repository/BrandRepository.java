package teknopar.RentACar.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import teknopar.RentACar.model.Brand;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

    Brand getByMarkaAd(String markaAd);
    Brand getByMarkaAdAndCar_CarId(String markaAd,int carId);  //burada fonksiyon isminde yer alan CarId bölümü car sınıfında tanımladığımız private int carId'den gelmektedir

    @Modifying
    @Transactional
    @Query("DELETE FROM Rented r WHERE r.car.id IN (SELECT c.id FROM Car c WHERE c.brand.id = :brandId)")
    void deleteRentedsByCarBrandId(int brandId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Car c WHERE c.brand.id = :brandId")
    void deleteCarsByBrandId(int brandId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Brand b WHERE b.id = :brandId")
    void deleteBrandById(int brandId);


}
