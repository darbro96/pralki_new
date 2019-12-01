package pl.utp.edu.pralki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.utp.edu.pralki.entity.Laundry;

public interface LaundryRepository extends JpaRepository<Laundry, Integer> {
}
