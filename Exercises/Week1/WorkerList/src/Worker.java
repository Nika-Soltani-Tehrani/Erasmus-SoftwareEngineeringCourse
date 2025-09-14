public class Worker {
    private String name;
    private double baseSalary;
    private double compensationSalary;
    private float taxRate;

    public Worker(String name, double baseSalary, double compensationSalary, float taxRate) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.compensationSalary = compensationSalary;
        this.taxRate = taxRate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getCompensationSalary() {
        return compensationSalary;
    }

    public void setCompensationSalary(double compensationSalary) {
        this.compensationSalary = compensationSalary;
    }

    public float calculateTaxRate() {
        return taxRate;
    }

    public double getTotalSalary() {
        return (baseSalary - baseSalary * taxRate) + compensationSalary;
    }

    public void printWorkerInfo() {
        System.out.printf("Name: %s, Base Salary: %.2f, Compensation: %.2f, Total Salary: %.2f%n",
                name, baseSalary, compensationSalary, getTotalSalary());
    }

}
