package teknopar.RentACar.service.abstracts;

import teknopar.RentACar.Core.utulities.results.DataResult;
import teknopar.RentACar.Core.utulities.results.Result;
import teknopar.RentACar.model.Car;

import java.math.BigInteger;
import java.util.List;

public interface CarService {

    Result save(Car car);

    Result deleteAll(List<Car> carList);

    DataResult<Car> getByCarModel(String model);
    Result aracEkle(String markaAd,String renk, BigInteger fiyat, String model, String yakitTuru);

    DataResult<List<Car>> getByModelContains(String aracModel);

    DataResult<List<Car>> getALL();

    Result deleteCar(int id);

    Result updateCar(int carId, BigInteger fiyat);

    DataResult<List<Car>> getAllSorted();

    DataResult<List<Car>> getByBrand_BrandId(int markaId);
}
