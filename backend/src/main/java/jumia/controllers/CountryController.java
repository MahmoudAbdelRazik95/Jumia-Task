package jumia.controllers;

import jumia.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping("/getCountries")
    public List<String> getAllCountries() {
        return countryService.getServicedCountries();
    }
}
