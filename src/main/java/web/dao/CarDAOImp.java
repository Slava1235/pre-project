package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDAOImp implements CarDAO {
    private List<Car> carList = new ArrayList<>(Arrays.asList(
            new Car("Lada", 250000, 2010),
            new Car("BMW", 3000000, 2019),
            new Car("Volvo", 450000, 2006),
            new Car("Tesla", 5000000, 2020),
            new Car("Patriot", 500, 2021))
    );

    @Override
    public List<Car> getReturnCars(String count) {
        if (count == null || Integer.parseInt(count) >= 5) {
            return carList;
        }
        return carList.stream()
                .limit(Long.parseLong(count))
                .collect(Collectors.toList());
    }

}
