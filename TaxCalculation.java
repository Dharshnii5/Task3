import java.util.Scanner;

    public class TaxCalculation {
        interface Taxable {
            double salesTax = 0.07; // 7%
            double incomeTax = 0.105; // 10.5%


            double calculateTax();
        }

        // Class Employee implementing Taxable
        public static class Employee implements Taxable {
            private int empId;
            private String name;
            private double salary;

            // Constructor
            public Employee(int empId, String name, double salary) {
                this.empId = empId;
                this.name = name;
                this.salary = salary;
            }


            @Override
            public double calculateTax() {
                // Calculating income tax on yearly salary
                double incomeTaxAmount = salary * incomeTax;
                System.out.println("Income Tax for employee " + name + " (ID: " + empId + ") is: " + incomeTaxAmount);
                return incomeTaxAmount;
            }
        }

        // Class Product implementing Taxable
        public static class Product implements Taxable {
            private int pid;
            private double price;
            private int quantity;

            // Constructor
            public Product(int pid, double price, int quantity) {
                this.pid = pid;
                this.price = price;
                this.quantity = quantity;
            }

            // Implementing the abstract method from Taxable interface

            @Override
            public double calculateTax() {
                // Calculating sales tax on unit price of the product
                double salesTaxAmount = price * salesTax;
                System.out.println("Sales Tax for product with ID " + pid + " is: " + salesTaxAmount);
                return salesTaxAmount;
            }
        }
    }
        // Main class DriverMain
        class DriverMain {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                // Accept employee information
                System.out.println("Enter Employee ID:");
                int empId = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                System.out.println("Enter Employee Name:");
                String empName = scanner.nextLine();
                System.out.println("Enter Employee Salary:");
                double empSalary = scanner.nextDouble();

                // Create Employee object
                TaxCalculation.Employee employee = new TaxCalculation.Employee(empId, empName, empSalary);


                // Accept product information
                System.out.println("\nEnter Product ID:");
                int productId = scanner.nextInt();
                System.out.println("Enter Product Price per unit:");
                double productPrice = scanner.nextDouble();
                System.out.println("Enter Product Quantity:");
                int productQuantity = scanner.nextInt();

                // Create Product object
                TaxCalculation.Product product = new TaxCalculation.Product(productId, productPrice, productQuantity);
                System.out.println("Employee Income Tax: " + employee.calculateTax());
                System.out.println("Product Sales Tax: " + product.calculateTax());


            }
        }



