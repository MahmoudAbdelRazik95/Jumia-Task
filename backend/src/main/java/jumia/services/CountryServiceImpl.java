package jumia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements  CountryService{

    private final CustomerValidator customerValidator;

    @Autowired
    public CountryServiceImpl() {
        this.customerValidator = new CustomerValidator();
    }

    public List<String> getServicedCountries(){
        return customerValidator.getCountries();
    }
}
