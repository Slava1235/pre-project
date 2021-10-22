package web.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import web.dao.CarAddAndReturnDAOImp;
import web.model.Car;

import java.util.List;

@Service
public class CarAddAndReturnImp implements CarAddAndReturn {
    @Autowired
    private CarAddAndReturnDAOImp carAddAndReturnDAOImp;

    @Override
    public List<Car> getReturnCars(String count) {
        if (count == null) {
            return Car.getCarList();
        }
        return carAddAndReturnDAOImp.getReturnCars(count);
    }
}