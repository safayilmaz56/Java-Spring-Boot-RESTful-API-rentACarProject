package teknopar.RentACar.apiController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;
import teknopar.RentACar.Core.utulities.results.DataResult;
import teknopar.RentACar.Core.utulities.results.Result;
import teknopar.RentACar.model.User;
import teknopar.RentACar.service.abstracts.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@Getter
@Setter
public class UsersController {
    private UserService userService;

    @PostMapping("/kullanıcıEkle")
    public Result kullaniciEkle(String ad, String soyad, String eposta, String telefonNo, String adres){
        return this.userService.kullaniciEkle(ad,soyad,eposta,telefonNo,adres);
    }

    @GetMapping("/userListesi")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }

    @PostMapping("/userGüncelle")
    public Result updateUser(int id, String eposta, String telefonNo, String adres){
        return this.userService.updateUser(id,eposta,telefonNo,adres);
    }

    @DeleteMapping("/userSil")
    public Result deleteUser(int id){
        return this.userService.deleteUser(id);
    }

    @GetMapping("/getByAd")
    public DataResult<User> getByAd(String ad){
        return this.userService.getByAd(ad);
    }

    @GetMapping("/getByAdContains")
    public DataResult<List<User>> getByAdContains(String ad){
        return this.userService.getByAdContains(ad);
    }

    @GetMapping("/getBySoyadContains")
    public DataResult<List<User>> getBySoyadContains(String soyad){
        return this.userService.getBySoyadContains(soyad);
    }
}
