package teknopar.RentACar.service.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import teknopar.RentACar.Core.utulities.results.DataResult;
import teknopar.RentACar.Core.utulities.results.Result;
import teknopar.RentACar.Core.utulities.results.SuccessDataResult;
import teknopar.RentACar.Core.utulities.results.SuccessResult;
import teknopar.RentACar.model.User;
import teknopar.RentACar.repository.UserRepository;
import teknopar.RentACar.service.abstracts.UserService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public DataResult<List<User>> getByAdContains(String ad) {
        return new SuccessDataResult<List<User>>(this.userRepository.getByAdContains(ad),"User(lar) başarıyla getirildi");
    }

    @Override
    public DataResult<List<User>> getBySoyadContains(String soyad) {
        return new SuccessDataResult<List<User>>(this.userRepository.getBySoyadContains(soyad),"User(lar) başarıyla getirildi");
    }

    @Override
    public DataResult<User> getByAd(String ad) {
        return new SuccessDataResult<User>(this.userRepository.getByAd(ad),"User başarıyla getirildi");
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userRepository.findAll(),"User listesi başarıyla getirildi");
    }

    @Override
    public Result deleteUser(int id) {
        this.userRepository.deleteById(id);
        return new SuccessResult("User başaarıyla silindi");
    }

    @Override
    public Result updateUser(int id, String eposta, String telefonNo, String adres) {
        User user = this.userRepository.findById(id).get();

        user.setEposta(eposta);
        user.setTelefonNo(telefonNo);
        user.setAdres(adres);

        this.userRepository.save(user);
        return new SuccessResult("User başarıyla güncellendi");
    }

    @Override
    public Result kullaniciEkle(String ad, String soyad, String eposta, String telefonNo, String adres) {
        User user = new User();

        user.setAd(ad);
        user.setSoyad(soyad);
        user.setEposta(eposta);
        user.setTelefonNo(telefonNo);
        user.setAdres(adres);

        this.userRepository.save(user);
        return new SuccessResult("Kullanıcı başarıyla kaydedildi");
    }
}
