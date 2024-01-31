class Customer {
    private String name;
    private String membership;

    public Customer(String name, String membership) {
        this.name = name;
        this.membership = membership;
    }

    public String getName() {
        return name;
    }

    public String getMembership() {
        return membership;
    }
}

class Discount {
    private static final double PREMIUM_DISCOUNT_RATE = 0.20;
    private static final double GOLD_DISCOUNT_RATE = 0.15;
    private static final double SILVER_DISCOUNT_RATE = 0.10;
    private static final double PRODUCT_DISCOUNT_RATE = 0.10;

    public static double getServiceDiscountRate(String membership) {
        switch (membership.toLowerCase()) {
            case "premium":
                return PREMIUM_DISCOUNT_RATE;
            case "gold":
                return GOLD_DISCOUNT_RATE;
            case "silver":
                return SILVER_DISCOUNT_RATE;
            default:
                return 0.0;
        }
    }

    public static double getProductDiscountRate() {
        return PRODUCT_DISCOUNT_RATE;
    }
}

class Visit {
    private Customer customer;
    private double serviceExpense;
    private double productExpense;

    public Visit(Customer customer, double serviceExpense, double productExpense) {
        this.customer = customer;
        this.serviceExpense = serviceExpense;
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        double serviceDiscount = serviceExpense * Discount.getServiceDiscountRate(customer.getMembership());
        double productDiscount = productExpense * Discount.getProductDiscountRate();
        return serviceExpense - serviceDiscount + productExpense - productDiscount;
    }
}

public class BeautySaloon {
    public static void main(String[] args) {
        // Test program to exercise all the classes
        Customer customer1 = new Customer("Alice", "Premium");
        Visit visit1 = new Visit(customer1, 100.0, 50.0);
        System.out.println("Total expense for " + customer1.getName() + ": $" + visit1.getTotalExpense());

        Customer customer2 = new Customer("Bob", "Gold");
        Visit visit2 = new Visit(customer2, 100.0, 50.0);
        System.out.println("Total expense for " + customer2.getName() + ": $" + visit2.getTotalExpense());

        Customer customer3 = new Customer("Charlie", "Silver");
        Visit visit3 = new Visit(customer3, 100.0, 50.0);
        System.out.println("Total expense for " + customer3.getName() + ": $" + visit3.getTotalExpense());

        Customer customer4 = new Customer("David", "Basic");
        Visit visit4 = new Visit(customer4, 100.0, 50.0);
        System.out.println("Total expense for " + customer4.getName() + ": $" + visit4.getTotalExpense());
    }
}
