import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj wiek:");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj dzień tygodnia:");
        String day = scanner.nextLine();

        System.out.println("Czy mieszkasz w Warszawie? (tak/nie)");
        String isWarsawInput = scanner.nextLine();
        boolean isWarsaw = isWarsawInput.equalsIgnoreCase("tak");

        Person person = new Person(age, isWarsaw);


        double ticketPrice = calculateTicketPrice(person, day);

        System.out.println("Dane klienta:");
        System.out.println("Wiek: " + person.getAge());
        System.out.println("Mieszkaniec Warszawy: " + (person.isWarsaw() ? "Tak" : "Nie"));
        System.out.println("Cena biletu po zniżce: " + ticketPrice + " zł");
    }

    public static double calculateTicketPrice(Person person, String day) {
        double basePrice = 40.0;
        double discount = 0.0;

        if (person.getAge() < 10 || day.equalsIgnoreCase("czwartek")) {
            discount += basePrice;
        } else if (person.getAge() <= 18) {
            discount += basePrice * 0.5;
        }

        if (person.isWarsaw()) {
            discount += basePrice * 0.1;
        }

        return basePrice - discount;
    }
}