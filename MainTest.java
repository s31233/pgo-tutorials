import static org.junit.jupiter.api.Assertions.*;

class MainTest {
   @org.junit.jupiter.api.Test
    void calculatePriceDlaCzwartku() {
        Person a = new Person(18,false );
        assertEquals(0,Main.calculatePrice(a, "czwartek"));
    }
    @org.junit.jupiter.api.Test
    void calculatePriceDlaWarszawy() {
        Person b = new Person(25, true);
        assertEquals(36,Main.calculatePrice(b,"Poniedzialek"));
    }
    @org.junit.jupiter.api.Test
    void calculatePricePonizej18powyzej10() {
        Person a = new Person(14,false);
        assertEquals(20,Main.calculatePrice(a,"Poniedzialek"));
    }

}
