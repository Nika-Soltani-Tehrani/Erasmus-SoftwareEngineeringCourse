import java.util.List;

public class Payroll {
    private List<Worker> workers;
    private double globalTaxRate; // e.g., 0.10 means 10%

    public Payroll(List<Worker> workers, double globalTaxRate) {
        this.workers = workers;
        this.globalTaxRate = globalTaxRate;
    }

    // Compute total salary before tax
    public double getGlobalTotalSalary() {
        return workers.stream()
                .mapToDouble(Worker::getTotalSalary)
                .sum();
    }

    // Compute salary after applying global tax
    public double getGlobalTotalAfterTax() {
        double total = getGlobalTotalSalary();
        return total - (total * globalTaxRate);
    }

    public void printPayrollSummary() {
        workers.forEach(Worker::printWorkerInfo);
        System.out.printf("Global Total Salary (before tax): %.2f%n", getGlobalTotalSalary());
        System.out.printf("Global Total Salary (after %.2f%% tax): %.2f%n",
                globalTaxRate * 100, getGlobalTotalAfterTax());
    }
}
