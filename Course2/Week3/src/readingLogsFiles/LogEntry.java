package readingLogsFiles;

import java.util.*;

public class LogEntry {
    private String ipAdderss;
    private String Date;
    private String request;
    private int statusCode;
    private int bytesReturned;

    public String getDate() {
        return Date;
    }

    public String getIpAdderss() {
        return ipAdderss;
    }



    public String getRequest() {
        return request;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public int getBytesReturned() {
        return bytesReturned;
    }

    public LogEntry(String ip, String date, String req, int code, int bytes){
     ipAdderss = ip;
     Date = date;
     request = req;
     statusCode = code;
     bytesReturned = bytes;
    }
    public String toString(){
        return ipAdderss + " " + Date + " " + request + " " + statusCode + " " + bytesReturned;
    }
}
