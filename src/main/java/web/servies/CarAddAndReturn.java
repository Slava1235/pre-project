package web.servies;

import web.model.Car;

import java.util.List;

public interface CarAddAndReturn {
    List<Car> getReturnCars(String count);
}
