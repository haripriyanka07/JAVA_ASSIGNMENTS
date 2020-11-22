import java.util.Scanner;

public class ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a weight");
        try {
            InvalidWeightException iwe = new InvalidWeightException();
            iwe.throwExceptions(sc.nextInt());
        } catch (Exception e) {
            System.out.println("caught exception: " + e.getMessage());
        } finally {
            System.out.println("Inside finally ");
        }
    }
}

class ExceptionOne extends Exception {
    @Override
    public String getMessage() {
        return "It is greater than valid weight";
    }
}

class ExceptionTwo extends Exception {
    @Override
    public String getMessage() {
        return "It should not be multiple of 400";
    }
}

class ExceptionThree extends Exception {
    @Override
    public String getMessage() {
        return "It is less than valid weight";
    }
}

class InvalidWeightException {

    void throwExceptions(int weight) throws ExceptionOne, ExceptionTwo, ExceptionThree {
        if (weight  > 1000)
            throw new ExceptionOne();
        else if (weight % 400 == 0)
            throw new ExceptionTwo();
        else
            throw new ExceptionThree();
    }
}