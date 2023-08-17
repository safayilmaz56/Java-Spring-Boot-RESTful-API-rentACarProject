package teknopar.RentACar.service.abstracts;

import teknopar.RentACar.Core.utulities.results.DataResult;
import teknopar.RentACar.Core.utulities.results.Result;
import teknopar.RentACar.model.Brand;

import java.util.List;

public interface BrandService {

        Result markaEkle(String ad,String uretimYeri);
        Result updateBrand(int markaId,String markaAd,String uretimYeri);
        DataResult<List<Brand>> getAllBrand();
        Result deleteBrand(int markaId);
        DataResult<Brand> getByMarkaAd(String markaAd);
        DataResult<Brand> getByMarkaAdAndCar_CarId(String markaAd, int carId);

        Result deleteRentedsByCarBrandId(int brandId);
        Result deleteCarsByBrandId(int brandId);
        Result deleteBrandById(int brandId);



}
