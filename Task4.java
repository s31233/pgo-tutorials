import java.util.Scanner;

class Task4 {
    int[] numbers = new int[10];
    Scanner scanner = new Scanner(System.in);

    public int readNumber() throws NegativeNumberException {
        int number = scanner.nextInt();
        if (number < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed");
        }
        return number;
    }

    public void fillArray() {
        for (int i = 0; i < numbers.length; i++) {
            try {
                numbers[i] = readNumber();
            } catch (NegativeNumberException e) {
                numbers[i] = 0;
                System.out.println(e.getMessage());
            }
        }
    }
}
