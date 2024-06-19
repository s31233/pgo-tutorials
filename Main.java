
//zadanie 2
public class Main {
    public static void main(String[] args) {
        Cat mruczek = new Cat("Mruczek");
        mruczek.start();
        System.out.println(mruczek.getType());
        mruczek.stop();
    }
}

//klasa abstrakcyjna Animal
abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String getType();

    public String getName() {
        return name;
    }
}

//Klasa Cat dziedzicząca klase Animal
class Cat extends Animal implements Moveable {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void start() {
        System.out.println("Cat starts!");
    }

    @Override
    public void stop() {
        System.out.println("Cat stopped!");
    }

    @Override
    public String getType() {
        return "Cat";
    }
}

//Interfejs Moveable
interface Moveable {
    void start();
    void stop();
}