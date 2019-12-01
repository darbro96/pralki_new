package pl.utp.edu.pralki.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.utp.edu.pralki.entity.Dormitory;
import pl.utp.edu.pralki.entity.Laundry;
import pl.utp.edu.pralki.exceptions.ObjectInDatabaseException;
import pl.utp.edu.pralki.service.DormitoryService;
import pl.utp.edu.pralki.service.LaundryService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private LaundryService laundryService;

    @RequestMapping("/aka/all")
    public List<Dormitory> allDorms() {
        return dormitoryService.findAll();
    }

    @PostMapping("/aka/add/{name}")
    public void addNew(@PathVariable("name") String name) throws ObjectInDatabaseException {
        dormitoryService.addNew(name);
    }

    @RequestMapping("/laundry/all")
    public List<Laundry> allLaundries() {
        return laundryService.findAll();
    }

    @PostMapping("/laundry/add/{number}/{dormitory}")
    public void addNewLaundry(@PathVariable("number") int number, @PathVariable("dormitory") String dormitoryName) throws ObjectInDatabaseException {
        Dormitory dormitory = dormitoryService.findOne(dormitoryName);
        laundryService.addLaundry(number, dormitory);
    }
}
