package com.error404;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Main {

    public void tester(){
        FileResource fr = new FileResource("data/exportdata.csv");
        CSVParser parser = fr.getCSVParser();
//        System.out.println(countryInfo(parser, "Nauru"));
//        listExportersTwoProducts(parser, "fish", "nuts");
//        System.out.println(numberOfExporters(parser, "gold"));
        bigExporters(parser, "$999,999,999");
    }

    public String countryInfo(CSVParser parser, String country){
        for (CSVRecord record : parser){
            String countries = record.get("Country");
            if(countries.contains(country)) {
                String expo = record.get("Exports");
                String coun = record.get("Value (dollars)");
                String str = country+": "+expo + ": " + coun;
                return str;
            }
        }
        return "NOT FOUND";
    }
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for (CSVRecord record : parser){
            String export = record.get("Exports");
            if(export.contains(exportItem1) && export.contains(exportItem2)) {
                String coun = record.get("Country");
                System.out.println(coun);
            }
        }
    }
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for (CSVRecord record : parser){
            String export = record.get("Exports");
            if(export.contains(exportItem)) {
                count++;
            }
        }
        return count;
    }

    public void bigExporters(CSVParser parser, String amount){
        int len = amount.length();
//        System.out.println(len);
        for (CSVRecord record : parser){
            String country = record.get("Country");
            String value = record.get("Value (dollars)");
//            System.out.println(value.length());
            if(value.length() > len){
                System.out.println(country+" "+value);
            }

        }
    }

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.tester();
    }
}
