public class Main {
    public static void main(String[] args) {
        try {
            // Tworzenie pociągu
            Train train = new Train("T001", "WP133", 300.5f, 20000, 2022);

            // Tworzenie wagonów
            Wagon solidWagon = new SolidWagon("W001", 100, 5000);
            Wagon liquidWagon = new LiquidWagon("W002", 200, 7000);
            Wagon tempControlledWagon = new TemperatureControlledWagon("W003", 150, 6000);
            Wagon dangerousWagon = new DangerousWagon("W004", 120, 8000);

            // Dodawanie wagonów do pociągu
            train.addWagon(solidWagon);
            train.addWagon(liquidWagon);
            train.addWagon(tempControlledWagon);
            train.addWagon(dangerousWagon);

            // Załadowywanie towarów do wagonów
            train.loadCargo("W001", 4000, false, false); // Załaduj 4000 kg stałego towaru do SolidWagon
            train.loadCargo("W002", 5000, true, false);  // Załaduj 5000 kg ciekłego towaru do LiquidWagon
            train.loadCargo("W003", 3000, false, false); // Załaduj 3000 kg stałego towaru wymagającego temperatury do TemperatureControlledWagon
            train.loadCargo("W004", 6000, false, true);  // Załaduj 6000 kg niebezpiecznego towaru do DangerousWagon

            // Próba załadowania niezgodnego towaru
            try {
                train.loadCargo("W003", 1000, true, false); // Błąd: Liquid towar do TemperatureControlledWagon
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // Usuwanie wagonu z pociągu
            Wagon removedWagon = train.removeWagon("W002");
            if (removedWagon != null) {
                System.out.println("Wagon " + removedWagon.getId() + " został odłączony.");
            } else {
                System.out.println("Wagon nie znaleziony.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

