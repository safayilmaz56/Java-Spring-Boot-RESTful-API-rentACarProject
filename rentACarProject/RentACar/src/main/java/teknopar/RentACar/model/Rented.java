package teknopar.RentACar.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name = "renteds")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rented {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int rentedId;

    @Column(name = "kiralamasuresi")
    private int kiralamaSuresi;

    @Column(name = "fiyat")
    private BigInteger fiyat;

    @Column(name = "kiralamatarihi")
    private String kiralamaTarihi;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "carid")
    private Car car;

}
