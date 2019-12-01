package pl.utp.edu.pralki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.utp.edu.pralki.entity.Dormitory;
import pl.utp.edu.pralki.exceptions.ObjectInDatabaseException;
import pl.utp.edu.pralki.repository.DormitoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DormitoryService {
    @Autowired
    private DormitoryRepository dormitoryRepository;

    public List<Dormitory> findAll() {
        return dormitoryRepository.findAll();
    }

    public void addNew(String name) throws ObjectInDatabaseException {
        Dormitory dormitory = new Dormitory();
        dormitory.setName(name);
        if (findAll().stream().filter(d -> d.getName().equals(name)).count() == 0) {
            dormitoryRepository.save(dormitory);
        } else {
            throw new ObjectInDatabaseException();
        }
    }

    public Dormitory findOne(String name) {
        Optional<Dormitory> value = findAll().stream().filter(d -> d.getName().equals(name)).findFirst();
        return value.isPresent() ? value.get() : null;
    }
}
