import java.util.Scanner;

public class TaxableProgram {

    // Interface inside same file
    interface Taxable {
        double SALES_TAX = 0.07;
        double INCOME_TAX = 0.105;

        double calcTax();
    }

    // Employee class
    static class Employee implements Taxable {
        int empId;
        String name;
        double salary;

        Employee(int empId, String name, double salary) {
            this.empId = empId;
            this.name = name;
            this.salary = salary;
        }

        public double calcTax() {
            return salary * INCOME_TAX;
        }
    }

    // Product class
    static class Product implements Taxable {
        int pid;
        double price;
        int quantity;

        Product(int pid, double price, int quantity) {
            this.pid = pid;
            this.price = price;
            this.quantity = quantity;
        }

        public double calcTax() {
            return price * SALES_TAX;
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Employee input
        System.out.println("Enter Employee ID:");
        int eid = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Employee Name:");
        String name = sc.nextLine();

        System.out.println("Enter Employee Salary:");
        double salary = sc.nextDouble();

        Employee emp = new Employee(eid, name, salary);
        System.out.println("Income Tax: " + emp.calcTax());

        // Product input
        System.out.println("\nEnter Product ID:");
        int pid = sc.nextInt();

        System.out.println("Enter Product Price:");
        double price = sc.nextDouble();

        System.out.println("Enter Product Quantity:");
        int qty = sc.nextInt();

        Product prod = new Product(pid, price, qty);
        System.out.println("Sales Tax: " + prod.calcTax());
    }
}
