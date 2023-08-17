package teknopar.RentACar.apiController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;
import teknopar.RentACar.Core.utulities.results.DataResult;
import teknopar.RentACar.Core.utulities.results.Result;
import teknopar.RentACar.model.Brand;
import teknopar.RentACar.service.abstracts.BrandService;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
@Getter
@Setter
public class BrandsController {

    private BrandService brandService;

    @PostMapping("/markaEkle")
    public Result markaEkle(String ad, String uretimYeri){
        return this.brandService.markaEkle(ad,uretimYeri);
    }

    @PostMapping("/markaGüncelle")
    public Result updateBrand(int markaId,String markaAd,String uretimYeri){
        return this.brandService.updateBrand(markaId, markaAd, uretimYeri);
    }

    @GetMapping("/markaListesi")
    public DataResult<List<Brand>> getAllBrand(){
        return this.brandService.getAllBrand();
    }

    @DeleteMapping("/markaSil")
    public Result deleteBrand(int markaId){
        return this.brandService.deleteBrand(markaId);
    }

    @GetMapping("/markaGetir")
    DataResult<Brand> getByMarkaAd(String markaAd){
        return this.brandService.getByMarkaAd(markaAd);
    }

    @GetMapping("/getByMarkaAdAndCar_CarId")
    public DataResult<Brand> getByMarkaAdAndCar_CarId(@RequestParam("markaAd") String markaAd,@RequestParam("carId") int carId){
        return this.brandService.getByMarkaAdAndCar_CarId(markaAd,carId);
    }


}
