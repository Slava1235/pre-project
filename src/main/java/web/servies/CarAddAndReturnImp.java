package web.servies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web.dao.CarAddAndReturnDAOImp;
import web.model.Car;

import java.util.List;

@Component
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