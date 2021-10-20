package web.servies;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarAddAndReturn {
    public static List<Car> getAddCars() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("lada", 250000, 2010));
        carList.add(new Car("BMV", 3000000, 2019));
        carList.add(new Car("Volvo", 450000, 2006));
        carList.add(new Car("Tesla", 5000000, 2020));
        carList.add(new Car("Patriot", 500, 2021));
        return carList;
    }

    public static List<Car> getReturnCars(String count) {
        return getAddCars().stream().limit(Long.parseLong(count)).collect(Collectors.toList());
    }
}
