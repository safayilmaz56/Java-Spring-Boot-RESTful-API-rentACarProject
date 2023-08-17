package teknopar.RentACar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teknopar.RentACar.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> getByAdContains(String ad);
    User getByAd(String ad);
    List<User> getBySoyadContains(String soyad);
}
