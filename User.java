public class User {
    private String imie;
    private String nazwisko;
    private String email;
    private String haslo;
    private boolean czyGosc;

    public User(String email) {
        this("", "", email, null);
        this.czyGosc = true;
    }

    public User(String imie, String nazwisko, String email, String haslo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.nazwisko = nazwisko;
        this.czyGosc = false;
    }

    public void aktualizujDoZarejestrowanegoUzytkownika(String imie, String nazwisko, String haslo) {
        if (czyGosc) {
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.haslo= haslo;
            this.czyGosc = false;
        } else {
            System.out.println("To nie jest konto gościa.");
        }
    }
}

