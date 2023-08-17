package teknopar.RentACar.apiController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;
import teknopar.RentACar.Core.utulities.results.DataResult;
import teknopar.RentACar.Core.utulities.results.Result;
import teknopar.RentACar.model.Car;
import teknopar.RentACar.service.abstracts.CarService;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
@Getter
@Setter
@AllArgsConstructor
public class CarsController {

    private CarService carService;

    @GetMapping("/getByCarModel")
    public DataResult<Car> getByCarModel(String model){
        return this.carService.getByCarModel(model);
    }

    @PostMapping("/aracEkle")
    public Result aracEkle(String markaAd,String renk, BigInteger fiyat, String model, String yakitTuru){
        return this.carService.aracEkle(markaAd,renk, fiyat, model, yakitTuru);
    }

    @GetMapping("/getByModelContains")
    public DataResult<List<Car>> getByModelContains(String aracModel){
        return this.carService.getByModelContains(aracModel);
    }

    @GetMapping("/araçListesi")
    public DataResult<List<Car>> getALL(){
        return this.carService.getALL();
    }

    @DeleteMapping("/araçSil")
    public Result deleteCar(int id){
        return this.carService.deleteCar(id);
    }

    @PostMapping("/araçGüncelle")
    public Result updateCar(int carId, BigInteger fiyat){
        return this.carService.updateCar(carId,fiyat);
    }

    @GetMapping("/getAllSorted")
    public DataResult<List<Car>> getAllSorted(){
        return this.carService.getAllSorted();
    }
}
