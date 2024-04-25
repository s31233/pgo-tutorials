import java.util.ArrayList;
import java.util.List;

public class Koszyk {
    private List<Product> listaProduktow;
    private User uzytkownik;

    public Koszyk() {
        this(new ArrayList<>(), null);
    }
    public Koszyk(User uzytkownik) {
        this(new ArrayList<>(), uzytkownik);
    }
    public Koszyk(User uzytkownik, List<Product> listaProduktow) {
        this.listaProduktow =listaProduktow;
        this.uzytkownik = uzytkownik;
    }
    public void dodajProdukt(Product produkt) {
        if (produkt.getLiczbaSztuk() > 0) {
            listaProduktow.add(produkt);
            produkt.setLiczbaSztuk(produkt.getLiczbaSztuk() - 1);
        } else {
            System.out.println("Nie ma wystarczającej liczby sztuk tego produktu.");
        }
    }
    public void usunProdukt(Product produkt) {
        listaProduktow.remove(produkt);
        produkt.setLiczbaSztuk(produkt.getLiczbaSztuk() + 1);
    }
    public double obliczCene() {
        double cena = 0;
        for (Product produkt : listaProduktow) {
            cena += produkt.getCena();
        }
        return cena;
    }
    public void zaplac() {
        double cena = obliczCene();
        System.out.println("Cena do zapłaty: " + cena);
    }
    public List<Product> getListaProduktow() {
        return listaProduktow;
    }
    public void setListaProduktow(List<Product> listaProduktow) {
        this.listaProduktow = listaProduktow;
    }
    public User getUzytkownik() {
        return uzytkownik;
    }
    public void setUzytkownik(User uzytkownik) {
        this.uzytkownik = uzytkownik;
    }
}
