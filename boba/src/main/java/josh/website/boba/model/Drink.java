package josh.website.boba.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Drink")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="sweetness", nullable = false)
    private Integer sweetness;

    @Column(name="rating", nullable = false)
    private Float rating;

    @ManyToOne
    @JoinColumn(name="restaurantid", nullable = false, updatable = false)
    private Restaurant restaurant;
}
