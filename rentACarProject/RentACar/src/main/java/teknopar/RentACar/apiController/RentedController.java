package teknopar.RentACar.apiController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;
import teknopar.RentACar.Core.utulities.results.DataResult;
import teknopar.RentACar.Core.utulities.results.Result;
import teknopar.RentACar.model.Rented;
import teknopar.RentACar.service.abstracts.RentedService;

import java.util.List;

@RestController
@RequestMapping("/api/renteds")
@AllArgsConstructor
@Getter
@Setter
public class RentedController {
    private RentedService rentedService;

    @PostMapping("/rentedEkle")
    public Result aracKirala(int userId, int carId, String kiralamaTarihi, int kiralamaSuresi){
        return this.rentedService.aracKirala(userId,carId,kiralamaTarihi,kiralamaSuresi);
    }

    @GetMapping("/rentedListesi")
    public DataResult<List<Rented>> getAll(){
        return this.rentedService.getAll();
    }

    @DeleteMapping("/rentedSil")
    public Result deleteRented(int rentedId){
        return this.rentedService.deleteRented(rentedId);
    }

    @PostMapping("/rentedGüncelle")
    public Result updateRented(int rentedId, int kiralamaSuresi, String kiralamaTarihi, int carId, int userId){  //buraya DTO yazılabilir
        return this.rentedService.updateRented(rentedId,kiralamaSuresi,kiralamaTarihi,carId,userId);
    }

    @GetMapping("/fiyat")
    public Result getFiyat(int rentedId){
        return this.rentedService.getFiyat(rentedId);
    }
}
