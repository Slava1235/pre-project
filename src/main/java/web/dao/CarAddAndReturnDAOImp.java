package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarAddAndReturnDAOImp implements CarAddAndReturnDAO {

    @Override
    public List<Car> getReturnCars(String count) {
        return Car.getCarList()
                .stream()
                .limit(Long.parseLong(count))
                .collect(Collectors.toList());
    }

}
