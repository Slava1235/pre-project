package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarAddAndReturn;

@Controller
public class CarController {
    @Autowired
    private CarAddAndReturn carAddAndReturn;

    @GetMapping(value = "/cars")
    public String printCar(ModelMap model, @RequestParam(value = "count", required = false) String count) {
        model.addAttribute("message", carAddAndReturn.getReturnCars(count));
        return "cars";
    }
}