package readingLogsFiles;

import java.util.ArrayList;
import java.util.HashMap;

public class Tester {
    public static void main(String[] args) {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("data/weblog1_log");
//        la.printAll();
//        System.out.println(la.countUniqueIPs());
//        la.printAllHigherThanNum(400);
//        System.out.println(la.countUniqueIPsInRange(300, 399));
//        HashMap<String, Integer> hm = la.countVisitsPerIP();
//        System.out.println(la.mostNumberVisitsByIP(hm));
//        System.out.println(la.iPsMostVisits(hm));
//        la.fiind();
//        la.mostNumberVisitsByIP(hm);
//        System.out.println(la.iPsForDays());
        HashMap<String, ArrayList<String>> hm = la.iPsForDays();
        System.out.println(la.dayWithMostIPVisits(hm));
        System.out.println(la.iPsWithMostVisitsOnDay(hm, "Mar 17"));
    }
}
