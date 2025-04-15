import java.util.Scanner;

class Subscriber {
    private long phoneNumber;
    private String name;
    private int hireCharge;
    private int unitsConsumed;
    private double billAmount;

    public Subscriber(long phoneNumber, String name, int unitsConsumed) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.unitsConsumed = unitsConsumed;
        if(unitsConsumed <= 150){
            this.hireCharge = 300;
        }
        else{
            this.hireCharge = 500;
        }
        this.billAmount = 0.0;
    }

    public void calc() {
        if (unitsConsumed <= 100) {
            billAmount = hireCharge + unitsConsumed * 1.0;
        } else if (unitsConsumed <= 200) {
            billAmount = hireCharge + (100 * 1.0) + (unitsConsumed - 100) * 1.50;
        } else {
            billAmount = hireCharge + (100 * 1.0) + (100 * 1.50) + (unitsConsumed - 200) * 2.0;
        }
    }

    public void display() {
        System.out.println("========================================");
        System.out.println("              TELEPHONE BILL            ");
        System.out.println("========================================");
        System.out.printf("Phone Number        : " + phoneNumber + "\n");
        System.out.printf("Subscriber Name     : " + name + "\n");
        System.out.printf("Units Consumed      : " + unitsConsumed + " units" + "\n");
        System.out.printf("Hire Charge         : Rs. " + hireCharge + "\n");
        System.out.printf("Total Bill Amount   : Rs. " + billAmount + "\n");
        System.out.println("========================================");
    }
}

public class TelephoneBillGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Phone Number: ");
        long phoneNumber = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Subscriber Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Units Consumed: ");
        int unitsConsumed = sc.nextInt();

        Subscriber subscriber = new Subscriber(phoneNumber, name, unitsConsumed);

        subscriber.calc();
        subscriber.display();
    }
}
