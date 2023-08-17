package teknopar.RentACar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "brands")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","car"})
public class Brand {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int brandId;

    @Column(name="ad")
    private String markaAd;

    @Column(name="uretimyeri")
    private String uretimYeri;

    @OneToMany(mappedBy = "brand",cascade = CascadeType.ALL)
    private List<Car> car;

}
