import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of workers
        List<Worker> workers = new ArrayList<>();

        // Example workers
        workers.add(new Worker("Nika", 3000, 500));
        workers.add(new Worker("Nikoleta", 2800, 700));
        workers.add(new Worker("Nikolas", 3200, 450));

        // Create Payroll with 15% global tax
        Payroll payroll = new Payroll(workers, 0.15);

        payroll.printPayrollSummary();
    }
}
