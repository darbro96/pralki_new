package pl.utp.edu.pralki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.utp.edu.pralki.entity.Dormitory;

public interface DormitoryRepository extends JpaRepository<Dormitory, Integer> {
}
