package pl.edu.pjwstk.s30900.pawkoz.L4.service;

import org.springframework.stereotype.Service;
import pl.edu.pjwstk.s30900.pawkoz.L4.model.Car;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CarService {

    private final Map<Long, Car> carStorage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    public Car createCar(Car newCar) {
        long id = idGenerator.incrementAndGet();
        carStorage.put(id, newCar);
        return newCar;
    }

    public Car getCar(Long id) {
        return carStorage.get(id);
    }

    public Car updateCar(Long id, Car updatedCar) {
        if (carStorage.containsKey(id)) {
            carStorage.put(id, updatedCar);
            return updatedCar;
        }
        return null;
    }

    public void deleteCar(Long id) {
        carStorage.remove(id);
    }
}