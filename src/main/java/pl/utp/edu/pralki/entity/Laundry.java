package pl.utp.edu.pralki.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Laundry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pralni")
    private int id;
    @Column(name = "nr_pralki")
    private int numberWasher;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dormitory", nullable = false)
    private Dormitory dormitory;
}
