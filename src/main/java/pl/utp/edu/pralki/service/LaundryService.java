package pl.utp.edu.pralki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.utp.edu.pralki.entity.Dormitory;
import pl.utp.edu.pralki.entity.Laundry;
import pl.utp.edu.pralki.exceptions.ObjectInDatabaseException;
import pl.utp.edu.pralki.repository.LaundryRepository;

import java.util.List;

@Service
public class LaundryService {
    @Autowired
    private LaundryRepository laundryRepository;

    public List<Laundry> findAll() {
        return laundryRepository.findAll();
    }

    public void addLaundry(int number, Dormitory dormitory) throws ObjectInDatabaseException {
        Laundry laundry = new Laundry();
        laundry.setNumberWasher(number);
        laundry.setDormitory(dormitory);
        if (findAll().stream().filter(d -> d.getNumberWasher() == number).filter(d -> d.getDormitory().equals(dormitory)).count() == 0) {
            laundryRepository.save(laundry);
        } else {
            throw new ObjectInDatabaseException();
        }
    }
}
