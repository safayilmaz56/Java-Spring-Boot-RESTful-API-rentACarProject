package teknopar.RentACar.service.abstracts;

import teknopar.RentACar.Core.utulities.results.DataResult;
import teknopar.RentACar.Core.utulities.results.Result;
import teknopar.RentACar.model.User;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getByAdContains(String ad);
    DataResult<List<User>> getBySoyadContains(String soyad);

    DataResult<User> getByAd(String ad);

    DataResult<List<User>> getAll();

    Result deleteUser(int id);

    Result updateUser(int id,String eposta,String telefonNo,String adres);

    Result kullaniciEkle(String ad,String soyad,String eposta,String telefonNo,String adres);
}
