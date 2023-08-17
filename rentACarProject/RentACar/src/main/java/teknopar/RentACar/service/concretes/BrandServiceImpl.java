package teknopar.RentACar.service.concretes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import teknopar.RentACar.Core.utulities.results.*;
import teknopar.RentACar.model.Brand;
import teknopar.RentACar.model.Car;
import teknopar.RentACar.model.Rented;
import teknopar.RentACar.repository.BrandRepository;
import teknopar.RentACar.service.abstracts.BrandService;
import teknopar.RentACar.service.abstracts.CarService;
import teknopar.RentACar.service.abstracts.RentedService;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;
    private CarService carService;
    private RentedService rentedService;

    public BrandServiceImpl(BrandRepository brandRepository, @Lazy CarService carService, RentedService rentedService) {
        this.brandRepository = brandRepository;
        this.carService = carService;
        this.rentedService = rentedService;
    }

    @Override
    public Result markaEkle(String ad, String uretimYeri) {

        Brand brand = new Brand();
        brand.setMarkaAd(ad);
        brand.setUretimYeri(uretimYeri);
        this.brandRepository.save(brand);
        return new SuccessResult("Marka başarıyla eklendi");
    }

    @Override
    public Result updateBrand(int markaId, String markaAd, String uretimYeri) {
        Brand brand = this.brandRepository.findById(markaId).get();
        brand.setMarkaAd(markaAd);
        brand.setUretimYeri(uretimYeri);

        this.brandRepository.save(brand);
        return new SuccessResult("Marka başarıyla güncellendi");
    }

    @Override
    public DataResult<List<Brand>> getAllBrand() {
        return new SuccessDataResult<List<Brand>>(this.brandRepository.findAll(), "Markalar başarıyla getirildi");
    }

    @Override
    public Result deleteBrand(int markaId) {

        this.brandRepository.deleteRentedsByCarBrandId(markaId);
        this.brandRepository.deleteCarsByBrandId(markaId);
        this.brandRepository.deleteBrandById(markaId);

        return new SuccessResult("işlem başarılı");
    }

    @Override
    public DataResult<Brand> getByMarkaAd(String markaAd) {
        return new SuccessDataResult<Brand>(this.brandRepository.getByMarkaAd(markaAd),"Marka başarıyla getirildi");
    }

    @Override
    public DataResult<Brand> getByMarkaAdAndCar_CarId(String markaAd, int carId) {
        return new SuccessDataResult<Brand>(this.brandRepository.getByMarkaAdAndCar_CarId(markaAd, carId),"Marka başarıyla getirildi");
    }
    @Override
    public Result deleteRentedsByCarBrandId(int brandId) {
        this.brandRepository.deleteRentedsByCarBrandId(brandId);
        return new SuccessResult("rented başarıyla silindi");
    }
    @Override
    public Result deleteCarsByBrandId(int brandId) {
        this.brandRepository.deleteCarsByBrandId(brandId);
        return new SuccessResult("car başarıyla silindi");
    }
    @Override
    public Result deleteBrandById(int brandId) {
        this.brandRepository.deleteBrandById(brandId);
        return new SuccessResult("brand başarıyla silindi");
    }
}
