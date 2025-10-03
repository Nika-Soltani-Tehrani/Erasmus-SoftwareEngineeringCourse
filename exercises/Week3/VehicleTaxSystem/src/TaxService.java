import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxService {
    public Map<Person, Double> generateYearlyTaxes(List<Person> persons) {
        Map<Person, Double> report = new HashMap<>();
        for (Person p : persons) {
            double total = 0;
            for (Vehicle v : p.getVehicles()) {
                total += v.calculateTax();
            }
            report.put(p, total);
        }
        return report;
    }
}
