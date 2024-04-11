class Product {
    private String nazwa;
    private double cena;
    private String kodProduktu;
    private int liczbaSztuk;

    public Product(String nazwa, double cena, String kodProduktu) {
        this(nazwa, cena, kodProduktu, 0);
    }

    public Product(String nazwa, double cena, String kodProduktu, int liczbaSztuk) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.kodProduktu = kodProduktu;
        this.liczbaSztuk = liczbaSztuk;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setLiczbaSztuk(int liczbaSztuk) {
        if (liczbaSztuk >= 0) {
            this.liczbaSztuk = liczbaSztuk;
        } else {
            System.out.println("Liczba sztuk nie może być mniejsza od 0.");
        }
    }

    @Override
    public String toString() {
        return "Nazwa: " + nazwa + ", Cena: " + cena + ", Kod produktu: " + kodProduktu + ", Liczba sztuk: " + liczbaSztuk;
    }
}