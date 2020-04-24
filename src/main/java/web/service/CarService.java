package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    public List<Car> getThreeCars() {
        List<Car> list = new ArrayList<>();
        list.add(new Car(1, "bmw", "H154BC"));
        list.add(new Car(3, "mers", "C666KK"));
        list.add(new Car(7, "lada", "E678KX"));

        return list;
    }
}
