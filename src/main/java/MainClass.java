import com.citi.service.CalculationService;
import com.citi.service.impl.CalculationServiceImpl;

public class MainClass {

    public static void main(String[] args) {

        MainClass.showReceipt(new String[] { "Large|Pan|Margarita|Capsicum,Onion,Jalapeno|Mozzarella",
                "Small|Normal|Margarita|Paneer,Onion,Jalapeno|Mozzarella,Double" });
        // MainClass.showReceipt(new
        // String[]{"Large|Pan|Margarita|Capsicum,Onion,Jalapeno|Mozzarella"});
    }

    private static void showReceipt(String[] orders) {
        CalculationService calculationService = new CalculationServiceImpl();
        calculationService.calculate(orders);
    }

}
