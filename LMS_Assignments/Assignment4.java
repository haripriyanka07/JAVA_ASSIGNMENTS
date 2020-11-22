import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Assignment4 {

    public static void dateRange(Date signUp, Date current){
        Calendar cal = Calendar.getInstance();
        cal.setTime(current);
        int currentYear = cal.get(Calendar.YEAR);
        cal.setTime(signUp);
        cal.set(Calendar.YEAR, currentYear);
        cal.add(Calendar.DATE, 30);
        Date maxDate = cal.getTime();
        cal.add(Calendar.DATE, -60);
        Date minDate = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        if(minDate.getTime() <= current.getTime() && maxDate.getTime() >= current.getTime()){
            System.out.println(dateFormat.format(minDate)+" "+dateFormat.format(current));
        }
        else if(current.getTime() >= maxDate.getTime()){
            System.out.println(dateFormat.format(minDate)+" "+dateFormat.format(maxDate));
        }
        else{
            System.out.println("No range");
        }
    }

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter input range");
        int range = sc.nextInt();
        String[] input = new String[range];
        sc.nextLine();
        System.out.println("enter singup date and current date");
        for(int i=0;i<range;i++){
            input[i] = sc.nextLine();
        }
        sc.close();
        for (int i=0;i<range;i++) {
            String[] date = input[i].split(" ");
            Date signup = new SimpleDateFormat("dd-MM-yyyy").parse(date[0]);
            Date current = new SimpleDateFormat("dd-MM-yyyy").parse(date[1]);
            if (signup.after(current)){
                System.out.println("No range");
                continue;
            }
            dateRange(signup, current);
        }

    }
}
