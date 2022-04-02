import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fr1=new FileReader("input1.txt");
        Scanner sc1= new Scanner(fr1);
        ArrayList<Bug> bugs=new ArrayList<>();
        while(sc1.hasNextLine())
            bugs.add(new Bug(sc1));

        FileReader fr4=new FileReader("input4.txt");
        Scanner sc4= new Scanner(fr4);
        ArrayList<Priority> priorities=new ArrayList<>();
        while(sc4.hasNextLine())
            priorities.add(new Priority(sc4));

        FileReader fr5=new FileReader("input5.txt");
        Scanner sc5= new Scanner(fr5);
        String priority=sc5.nextLine();
        int p_id=0;
        for (Priority item:priorities) {
            if(priority.equals(item.getPriority_name()))
               p_id =item.getPriority_id();

        }




        FileWriter fileWriter1= new FileWriter("output1.txt");
        for (Bug item: bugs) {
            if(item.getPriority_id()==p_id)
            item.file_print(fileWriter1);
        }
        fileWriter1.close();



        FileReader fr6=new FileReader("input6.txt");
        Scanner sc6= new Scanner(fr6);
        int qa_id=Integer.parseInt(sc6.nextLine());
        System.out.println(qa_id);


        FileReader fr3=new FileReader("input3.txt");
        Scanner sc3= new Scanner(fr3);
        ArrayList<Pair> pairs=new ArrayList<>();
        while(sc3.hasNextLine()) {
            Pair pair=new Pair(sc3);
            if (pair.getQa_id() == qa_id)
                pairs.add(pair);
        }

        FileWriter fileWriter3= new FileWriter("output3.txt");
        ArrayList<Bug> bugs2=new ArrayList<>();
        for (Pair item: pairs) {
            System.out.println(item.getBug_id());
            for (Bug b: bugs) {
                if(item.getBug_id()==b.getBug_id()) {
                    System.out.println(b.getBug_title());
                    b.file_print(fileWriter3);
                    bugs2.add(b);
                }
            }
        }
        fileWriter3.close();

        Date now_date=new Date();
        Collections.sort(bugs2,Collections.reverseOrder());
        for(Bug item:bugs2){
            System.out.println(item.getReport_date().getTime());
        }
        FileWriter fw4=new FileWriter("output4.txt");
        for(Bug item:bugs2){
            item.file_print2(fw4);
        }
        fw4.close();

        for (int i = 0; i <bugs.size() ; i++) {
            for (int j = i; j <bugs.size() ; j++) {
                if(bugs.get(i).getPriority_id()>bugs.get(j).getPriority_id()){
                    Bug tmp=new Bug(bugs.get(i));
                    bugs.set(i,bugs.get(j));
                    bugs.set(j,tmp);
                }
            }

        }
        FileWriter fw2=new FileWriter("output2.txt");
        for(Bug item:bugs){
            item.file_print(fw2);
        }
        fw2.close();












    }
}
