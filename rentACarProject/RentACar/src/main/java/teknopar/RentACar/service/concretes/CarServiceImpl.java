package teknopar.RentACar.service.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teknopar.RentACar.Core.utulities.results.DataResult;
import teknopar.RentACar.Core.utulities.results.Result;
import teknopar.RentACar.Core.utulities.results.SuccessDataResult;
import teknopar.RentACar.Core.utulities.results.SuccessResult;
import teknopar.RentACar.model.Car;
import teknopar.RentACar.repository.CarRepository;
import teknopar.RentACar.service.abstracts.BrandService;
import teknopar.RentACar.service.abstracts.CarService;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final BrandService brandService;


    @Override
    public Result save(Car car) {
        carRepository.save(car);
        return new SuccessResult("Araç kaydetme basarili");
    }

    @Transactional
    @Override
    public Result deleteAll(List<Car> carList) {
        for (Car car : carList){
            carRepository.delete(car);
        }
        return new SuccessResult("araclar silindi");
    }

    @Override
    public DataResult<Car> getByCarModel( String model) {
        return new SuccessDataResult<Car>(this.carRepository.getByModel(model),"Araç başarıyla getirildi");
    }

    @Override
    public Result aracEkle(String markaAd, String renk, BigInteger fiyat, String model, String yakitTuru) {
        Car car = new Car();

        car.setBrand(this.brandService.getByMarkaAd(markaAd).getData());
        car.setRenk(renk);
        car.setFiyat(fiyat);
        car.setModel(model);
        car.setYakitTuru(yakitTuru);

        this.carRepository.save(car);
        return new SuccessResult("Araç başarıyla eklendi");
    }

    @Override
    public DataResult<List<Car>> getByModelContains(String aracModel) {
        return new SuccessDataResult<List<Car>>(this.carRepository.getByModelContains(aracModel),"Araç(lar) başarıyla getirildi");
    }

    @Override
    public DataResult<List<Car>> getALL() {
        return new SuccessDataResult<List<Car>>(this.carRepository.findAll(),"Araçlar başarıyla getirildi");
    }


    @Override
    public Result deleteCar(int id) {
        Car car = carRepository.findById(id).get();
        this.carRepository.delete(car);
        return new SuccessResult("Araç başarıyla silindi");
    }

    @Override
    public Result updateCar(int carId, BigInteger fiyat) {
        Car car = this.carRepository.findById(carId).get();
        car.setFiyat(fiyat);
        this.carRepository.save(car);
        return new SuccessResult("Araç güncellendi");
    }

    @Override
    public DataResult<List<Car>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.ASC,"fiyat");
        return new SuccessDataResult<List<Car>>(this.carRepository.findAll(sort),"Araçlar başarıyla getirildi");
    }

    @Override
    public DataResult<List<Car>> getByBrand_BrandId(int markaId) {
        return new SuccessDataResult<List<Car>>(this.carRepository.getByBrand_BrandId(markaId));
    }
}
