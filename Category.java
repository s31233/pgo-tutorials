import java.util.ArrayList;
import java.util.List;

public class Category {
    private String nazwaKategorii;
    private List<Product> listaProduktow;

    public Category() {
        this("", new ArrayList<>());
    }
    public Category(String nazwaKategorii){
        this(nazwaKategorii, new ArrayList<>());
    }
    public Category(String nazwaKategorii, List<Product> listaProduktow) {
        this.nazwaKategorii = nazwaKategorii;
        this.listaProduktow = listaProduktow;
    }
    public void dodajProdukt(Product produkt) {
        listaProduktow.add(produkt);
    }
    public void usunProdukt (Product produkt) {
        listaProduktow.remove(produkt);
    }
    public String getNazwaKategorii(){
        return nazwaKategorii;
    }
    public void setNazwaKategorii(String nazwaKategorii){
        this.nazwaKategorii = nazwaKategorii;
    }
    public List<Product> getListaProduktow(){
        return listaProduktow;
    }
    public void setListaProduktow(List<Product>  listaProduktow) {
        this.listaProduktow = listaProduktow;
    }
}