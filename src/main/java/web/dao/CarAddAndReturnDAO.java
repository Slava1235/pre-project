package web.dao;

import web.model.Car;

import java.util.List;

public interface CarAddAndReturnDAO {
    List<Car> getReturnCars(String count);
}
