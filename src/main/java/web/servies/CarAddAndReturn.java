package web.servies;

import org.springframework.stereotype.Component;

import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarAddAndReturn {

    public List<Car> getReturnCars(String count) {
        return Car.getCarList()
                .stream()
                .limit(Long.parseLong(count))
                .collect(Collectors.toList());
    }
}