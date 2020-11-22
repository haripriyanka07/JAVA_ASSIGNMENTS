package readingLogsFiles;

import edu.duke.FileResource;

//import java.lang.reflect.Array;
import java.util.*;

public class LogAnalyzer {
    private ArrayList<LogEntry> rec;
//    private ArrayList<String> uniqueIPs = new ArrayList<String>();
    public LogAnalyzer(){
        rec = new ArrayList<LogEntry>();
    }
    public void readFile(String filename){
        FileResource fr = new FileResource(filename);
        for(String s : fr.lines()){
            String[] str = s.split("\\s");
            LogEntry le = new LogEntry(str[0], str[3]+str[4], str[5]+str[6]+str[7], Integer.parseInt(str[8]), Integer.parseInt(str[9]));
            rec.add(le);
        }
    }
    public void printAll(){
        for(LogEntry le : rec){
            System.out.println(le);
        }
    }
    public int countUniqueIPs(){
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry le :rec){
            String ip = le.getIpAdderss();
            if(!uniqueIPs.contains(ip)){
                uniqueIPs.add(ip);
            }
        }
        return uniqueIPs.size();
    }
    public void printAllHigherThanNum(int num){
        for(LogEntry le :rec){
            if(le.getStatusCode() > num){
                System.out.println(le);
            }
        }
    }
    public int countUniqueIPsInRange(int low, int high){
        int count = 0;
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for(LogEntry le :rec){
            int code = le.getStatusCode();
            String ip = le.getIpAdderss();
            if(code >= low && code <= high){
                if(!uniqueIPs.contains(ip)){
                    uniqueIPs.add(ip);
                    count++;
                }
            }
        }
        return count;
    }
    public HashMap<String, Integer> countVisitsPerIP(){
        HashMap<String, Integer> hm = new HashMap<>();
        for(LogEntry le : rec){
            String ip = le.getIpAdderss();
//            System.out.println(ip +" "+ rec.contains(ip));
            if(!hm.containsKey(ip)){
                hm.put(ip, 1);
            }
            else{
                int val = hm.get(ip);
//                System.out.println(val);
                hm.put(ip, val+1);
            }
        }
        return hm;
    }
    public int mostNumberVisitsByIP(HashMap<String, Integer> hm){
        String ip = "";
        int val = 0;
        Iterator itr = hm.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry pair = (Map.Entry)itr.next();
            int getval = (int)pair.getValue();
            if(getval > val){
                val = getval;
                ip = (String)pair.getKey();
            }
        }
        return val;
    }
    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> hm){
        int maxVal = mostNumberVisitsByIP(hm);
        ArrayList<String> mostVisit = new ArrayList<>();
        Iterator itr = hm.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry pair = (Map.Entry)itr.next();
            if((int)pair.getValue() == maxVal){
                mostVisit.add((String)pair.getKey());
            }
        }
        return mostVisit;
    }
    public HashMap<String, ArrayList<String>> iPsForDays(){
//    public void fiind(){
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for(LogEntry le: rec){
            String str = le.getDate().replace("[", "");
            String [] date = str.split("/");
            String dateFormat = date[1]+" "+date[0];
            if(!hm.containsKey(dateFormat)){
                ArrayList<String> ipArray = new ArrayList<>();
                ipArray.add(le.getIpAdderss());
                hm.put(dateFormat, ipArray);
            }
            else {
                ArrayList<String> local = new ArrayList<>();
                local = hm.get(dateFormat);
                local.add(le.getIpAdderss());
                hm.replace(dateFormat, local);
            }
        }
        return hm;
    }
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> hm){
        Iterator itr = hm.entrySet().iterator();
        int size = 0;
        String date = "";
        while (itr.hasNext()) {
            Map.Entry pair = (Map.Entry) itr.next();
            List<String> lst = new ArrayList<String>((Collection<String>)pair.getValue());
            if(lst.size()>size){
                size = lst.size();
                date = (String)pair.getKey();
            }
        }
        return date;
    }
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> hm, String date){
        ArrayList<String> ip = new ArrayList<>();
        if(hm.containsKey(date)){
            ip = hm.get(date);
        }
        ArrayList<String> ips = new ArrayList<>();
        return ip;
    }

    public static void main(String[] args) {
        String str = "110.76.104.12 - - [30/Sep/2015:07:47:11 -0400] \"GET //favicon.ico HTTP/1.1\" 200 3426";
        String[] strl = str.split("\\s");

//        System.out.println(Arrays.toString(strl));
//        System.out.println(strl[5]+strl[6]+strl[7]);
    }
}
