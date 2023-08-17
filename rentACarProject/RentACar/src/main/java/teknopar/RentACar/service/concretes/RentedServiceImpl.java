package teknopar.RentACar.service.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teknopar.RentACar.Core.utulities.results.*;
import teknopar.RentACar.model.Car;
import teknopar.RentACar.model.Rented;
import teknopar.RentACar.model.User;
import teknopar.RentACar.repository.CarRepository;
import teknopar.RentACar.repository.RentedRepository;
import teknopar.RentACar.repository.UserRepository;
import teknopar.RentACar.service.abstracts.RentedService;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentedServiceImpl implements RentedService {

    private final RentedRepository rentedRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;


    @Override
    public Result save(Rented rented) {
        this.rentedRepository.save(rented);
        return new SuccessResult("Başarılı");
    }

    @Transactional
    @Override
    public void deleteAll(List<Rented> rentedList) {
        for (Rented rented : rentedList){
            this.rentedRepository.delete(rented);
        }
    }

    @Override
    public DataResult<List<Rented>> getAll() {
        return new SuccessDataResult<List<Rented>>(this.rentedRepository.findAll(),"Rented listesi başarıyla getirildi");
    }

    @Override
    public Result deleteRented(int rentedId) {
        try{
            Rented rented = rentedRepository.findById(rentedId).get();
            this.rentedRepository.delete(rented);
            System.out.println(rented.getFiyat() + " rented silindi");
            return new SuccessResult("Kayıt silindi");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return new ErrorResult("Kayıt silinemedi");
        }
    }

    @Override
    public Result updateRented(int rentedId, int kiralamaSuresi, String kiralamaTarihi, int carId, int userId) {
        Rented rented = this.rentedRepository.findById(rentedId).get();

        rented.setKiralamaSuresi(kiralamaSuresi);
        rented.setKiralamaTarihi(kiralamaTarihi);
        rented.setCar(this.carRepository.findById(carId).get());
        rented.setUser(this.userRepository.findById(userId).get());

        this.rentedRepository.save(rented);
        return new SuccessResult("Kayıt başarıyla güncellendi");
    }

    @Override
    public Result getFiyat(int rentedId) {

        Rented rented = this.rentedRepository.findById(rentedId).get();
        BigInteger sonuc = rented.getFiyat();


        return new SuccessResult("İşlem başarıyla gerçekleşti.Fiyat: " + sonuc);
    }

    @Override
    public Result aracKirala(int userId, int carId, String kiralamaTarihi, int kiralamaSuresi) {
        Rented rented = new Rented();
        User user = this.userRepository.findById(userId).get();
        Car car = this.carRepository.findById(carId).get();

        rented.setCar(car);
        rented.setUser(user);
        rented.setKiralamaTarihi(kiralamaTarihi);
        rented.setKiralamaSuresi(kiralamaSuresi);

        BigInteger tutar = car.getFiyat();
        BigInteger sonuc = tutar.multiply(BigInteger.valueOf(kiralamaSuresi));

        rented.setFiyat(sonuc);

        this.rentedRepository.save(rented);
        return new SuccessResult("Kiralama bilgisi başarıyla oluşturuldu");
    }


}
