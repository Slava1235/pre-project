package web.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import web.dao.CarDAOImp;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarService {
    private CarDAOImp carDAOImp;

    @Autowired
    public CarServiceImp(CarDAOImp carDAOImp) {
        this.carDAOImp = carDAOImp;
    }

    @Override
    public List<Car> getReturnCars(String count) {
        return carDAOImp.getReturnCars(count);
    }
}