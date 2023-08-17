package teknopar.RentACar.service.abstracts;

import teknopar.RentACar.Core.utulities.results.DataResult;
import teknopar.RentACar.Core.utulities.results.Result;
import teknopar.RentACar.model.Rented;

import java.util.List;

public interface RentedService {

    Result save(Rented rented);

    void deleteAll(List<Rented> rentedList);

    DataResult<List<Rented>> getAll();
    Result deleteRented(int rentedId);
    Result updateRented(int rentedId,int kiralamaSuresi,String kiralamaTarihi,int carId,int userId);
    Result getFiyat(int rentedId);
    Result aracKirala(int userId, int carId,String kiralamaTarihi,int kiralamaSuresi);


}
