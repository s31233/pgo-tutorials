import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tworzenie kont użytkowników
        User guest1 = new User("guest1@gmail.com");
        User guest2 = new User("guest2@gmail.com");
        User user1 = new User("Ania", "Kowal", "ania.kowal@example.com", "password123");

        // Aktualizacja konta gościa do użytkownika
        guest1.aktualizujDoZarejestrowanegoUzytkownika("Kasia", "Kowal", "password456");

        // Tworzenie produktów
        Product product1 = new Product("Laptop", 1500.00, "ABC123");
        Product product2 = new Product("Telefon", 800.00, "DEF456", 5);
        Product product3 = new Product("Glosnik", 100.00, "GHI789");

        // Zmiana ceny produktu
        product1.setCena(1600.00);

        // Ustawienie liczby sztuk na 5
        product3.setLiczbaSztuk(5);

        // Wyświetlenie informacji o produktach
        System.out.println("Informacje o produktach:");
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);

        // Tworzenie kategorii
        Category elektronika = new Category("Elektronika");
        Category ubrania = new Category("Ubrania");
        Category mainCategory= new Category();

        // Dodawanie produktów do kategorii
        elektronika.dodajProdukt(product1);
        ubrania.dodajProdukt(product2);

        // Tworzenie koszyków
        Koszyk koszyk1 = new Koszyk(guest1);
        Koszyk koszyk2 = new Koszyk(guest1, List.of(product3));

        // Dodawanie produktów do koszyków
        koszyk1.dodajProdukt(product1);
        koszyk2.dodajProdukt(product2);
        koszyk2.dodajProdukt(product3);

        koszyk2.usunProdukt(product2);

        koszyk1.zaplac();
        koszyk2.zaplac();
    }
}