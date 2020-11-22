import java.io.IOException;
import java.util.Scanner;

public class Assignment8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        try {
            ExceptionCheck ec = new ExceptionCheck();
            ec.exceptions(sc.nextInt());
        } catch (Exception ex) {
            System.out.println("Exception " + ex.getMessage());
        } finally {
            System.out.println("Finally");
        }
    }
}

class NegativeException extends Exception{
    @Override
    public String getMessage() {
        return "Number is less than zero that is negative.";
    }
}
class PositiveException extends Exception{
    @Override
    public String getMessage() {
        return "Number is greater than zero that is Positive.";
    }
}
class OverException extends Exception{
    @Override
    public String getMessage() {
        return "Number is over the limit";
    }
}
class ExceptionCheck{
    void exceptions(int number) throws NegativeException, PositiveException, OverException{
        if(number<0){
            throw new NegativeException();
        }
        else if(number==10){
            throw new OverException();
        }
        else
            throw new PositiveException();
    }
}

