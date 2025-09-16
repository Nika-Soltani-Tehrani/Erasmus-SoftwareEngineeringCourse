public class Worker {
    private String name;
    private double baseSalary;
    private double compensationSalary;

    public Worker(String name, double baseSalary, double compensationSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.compensationSalary = compensationSalary;
    }

    public double calculateTotalSalary() {
        return baseSalary + compensationSalary;
    }

    public void printWorkerInfo() {
        System.out.printf("Name: %s, Base Salary: %.2f, Compensation: %.2f, Total Salary: %.2f%n",
                name, baseSalary, compensationSalary, calculateTotalSalary());
    }

}
