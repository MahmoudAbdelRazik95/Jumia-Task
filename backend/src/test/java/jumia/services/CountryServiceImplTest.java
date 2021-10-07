package jumia.services;

import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CountryServiceImplTest {

    @Autowired
    private CountryService countryService;

    @Test
    public void getServicedCountries() {
        List<String> countries = countryService.getServicedCountries();
        List<String> expectedCountries =  Arrays.asList("Morocco", "Uganda", "Mozambique", "Cameroon", "Ethiopia");
        Assert.assertTrue(countries.size() > 0);
        Assert.assertEquals(expectedCountries, countries);
    }
}