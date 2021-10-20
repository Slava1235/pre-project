package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.servies.CarAddAndReturn;

import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printCar(ModelMap model, @RequestParam(value = "count", required = false) String count) {
        if (count != null) {
            model.addAttribute("message", CarAddAndReturn.getReturnCars(count));
            return "cars";
        }
        List<Car> list = CarAddAndReturn.getAddCars();
        model.addAttribute("message", list);
        return "cars";
    }
}
