import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.citi.model.Receipt;
import com.citi.service.CalculationService;
import com.citi.service.impl.CalculationServiceImpl;

public class TestClass {

    CalculationService calculationService;

    @Before
    public void instanciate() {
        calculationService = new CalculationServiceImpl();
    }

    @Test
    public void getTotalProductPrice1() {
        Receipt receipt = calculationService
                .calculate(new String[] { "Large|Pan|Margarita|Capsicum,Onion,Jalapeno|Mozzarella" });
        assertTrue(285 == receipt.getProductPriceTotal());
    }

    @Test
    public void getTotalProductPrice2() {
        Receipt receipt = calculationService.calculate(new String[] {
                "Large|Pan|Margarita|Capsicum,Onion,Jalapeno|Mozzarella",
                "Small|Normal|Margarita|Paneer,Onion,Jalapeno|Mozzarella,Double" });
        assertTrue(420 == receipt.getProductPriceTotal());
    }

    @Test
    public void getTotalPrice1() {
        Receipt receipt = calculationService.calculate(new String[] {
                "Large|Pan|Margarita|Capsicum,Onion,Jalapeno|Mozzarella",
                "Small|Normal|Margarita|Paneer,Onion,Jalapeno|Mozzarella,Double" });
        assertTrue(466 == receipt.getTotalAmount());
    }

}
