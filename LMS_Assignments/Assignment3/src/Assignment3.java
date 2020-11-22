import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assignment3 {
    public static Float median(String host){
        Runtime rt = Runtime.getRuntime();
        String command = "ping "+ host + " -c 10";
        Float value = 0.0f;
        try{
            Process process = rt.exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String output = "";
            List<Float> packets = new ArrayList<Float>();
            while((output = input.readLine()) != null){
//                System.out.println(output);
                int time = output.indexOf("time=");
                if(time > 0){
                    packets.add(Float.parseFloat(output.substring(time+5, output.lastIndexOf("ms")-1)));
                }
            }
            int size = packets.size();
            if(size == 0){
                System.out.println("Host address unreachable or does not exist");
                System.exit(0);
            }
            Collections.sort(packets);
            if(size % 2 ==0){
                value = ((Float)packets.get(size/2) + (Float)packets.get(size/2-1))/2;
            }
            else{
                value = (Float)packets.get(size/2);
            }
        }
        catch (Exception ex){
            System.out.println("Host address unreachable or does not exist");
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a host address");
        String address = br.readLine();
        System.out.println(median(address));
    }
}
