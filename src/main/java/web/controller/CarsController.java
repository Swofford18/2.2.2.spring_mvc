package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.Car;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarService carService;

    @GetMapping
    public String printCars(ModelMap model, HttpServletRequest request) {
        String locale = request.getParameter("locale");
        if (locale.equals("en")) {
            model.addAttribute("locale", "CARS");
        }
        else {
            model.addAttribute("locale", "МАШИНЫ");
        }

        List<Car> cars = carService.getThreeCars();

        model.addAttribute("cars", cars);
        return "cars";
    }
}
