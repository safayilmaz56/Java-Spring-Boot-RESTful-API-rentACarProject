package teknopar.RentACar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cars")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","rented"})
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int carId;
    @ManyToOne
    @JoinColumn(name = "markaid")
    private Brand brand;
    @Column(name="model")
    private String model;
    @Column(name="renk")
    private String renk;
    @Column(name="yakitturu")
    private String yakitTuru;
    @Column(name="fiyat")
    private BigInteger fiyat;
    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    private List<Rented> rented;


}
