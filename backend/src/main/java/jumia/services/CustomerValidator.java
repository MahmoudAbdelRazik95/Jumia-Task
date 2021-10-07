package jumia.services;

import jumia.models.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class CustomerValidator {

    private final Map<String, String> codeCountryMap = new HashMap<>();
    private final Map<String, String> codeRegexMap = new HashMap<>();

    public CustomerValidator() {
        this.initializeMaps();
    }

    private void initializeMaps(){
        codeCountryMap.put("237", "Cameroon");
        codeCountryMap.put("251", "Ethiopia");
        codeCountryMap.put("212", "Morocco");
        codeCountryMap.put("258", "Mozambique");
        codeCountryMap.put("256", "Uganda");

        codeRegexMap.put("237", "\\(237\\)\\ ?[2368]\\d{7,8}$");
        codeRegexMap.put("251", "\\(251\\)\\ ?[1-59]\\d{8}$");
        codeRegexMap.put("212", "\\(212\\)\\ ?[5-9]\\d{8}$");
        codeRegexMap.put("258", "\\(258\\)\\ ?[28]\\d{7,8}$");
        codeRegexMap.put("256", "\\(256\\)\\ ?\\d{9}$");
    }

    // A method to validate a number and set its country
    public void validateNumber(Customer customer){
        String countryCode = customer.getPhone().substring(1, 4);

        String country = codeCountryMap.get(countryCode);
        String countryRegex = codeRegexMap.get(countryCode);

        if (Pattern.matches(countryRegex, customer.getPhone())){
            customer.setState("Valid");
        }
        else{
            customer.setState("Not Valid");
        }
        customer.setCountry(country);
    }

    // A method which returns a list of countries
    public List<String> getCountries(){
        return new ArrayList<>(codeCountryMap.values());
    }
}
