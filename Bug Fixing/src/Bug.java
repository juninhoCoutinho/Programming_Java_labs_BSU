import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bug implements Comparable<Bug>{
    private int bug_id;
    private String page;
    private String bug_title;
    private int priority_id;
    private Calendar report_date;


    public  Bug(Scanner sc){
        String[] s=sc.nextLine().split(";");
        this.bug_id=Integer.parseInt(s[0]);
        this.page= s[1];
        this.bug_title=s[2];
        this.priority_id=Integer.parseInt(s[3]);
        String[] d=s[4].split("\\.");
        int m=Integer.parseInt(d[1]);
        m-=1;
        this.report_date=new GregorianCalendar(Integer.parseInt(d[2]),m,Integer.parseInt(d[0]));


    }
    public Bug(Bug b){
        this.bug_id=b.bug_id;
        this.page= b.page;
        this.bug_title=b.bug_title;
        this.priority_id=b.priority_id;


        this.report_date=b.report_date;

    }

    public String getBug_title() {
        return bug_title;
    }

    public int getBug_id() {
        return bug_id;
    }

    public int getPriority_id() {
        return priority_id;
    }

    public  void print(){
        System.out.println("BUG: "+this.bug_title);
    }
    public  void file_print(FileWriter fw) throws IOException {
        fw.write(this.bug_title+"\n");
    }
    public  void file_print2(FileWriter fw) throws IOException {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        fw.write(this.bug_title+";"+formatForDateNow.format(this.report_date.getTime())+"\n");
    }

    public Calendar getReport_date() {
        return report_date;
    }

    @Override
    public int compareTo(Bug o) {
        if(this.getReport_date().getTime().before(o.getReport_date().getTime()))
            return -1;
        else if(this.getReport_date().getTime().after(o.getReport_date().getTime()))
            return 1;
        else
            return 0;
    }
}
