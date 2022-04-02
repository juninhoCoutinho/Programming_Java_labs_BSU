import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Test {
    private ArrayList<Students> arrayList;
    private double averages;

    public Test(Scanner sc){
        arrayList=new ArrayList<>();
        int i = -1;
        averages=0;
        while (sc.hasNextLine()) {
            Students tmp= new Students(sc.nextLine());

            i++;
            arrayList.add(i, tmp);
            averages+=tmp.getAverage();

        }
        averages/=arrayList.size();
    }

    public void print(){
        for (int j = 0; j < arrayList.size(); j++) {
            arrayList.get(j).print();
        }
        DecimalFormat f = new DecimalFormat("##.000");

        System.out.print("Average of all: ");
        System.out.println(f.format(averages));
    }

    public void del_incorrect(){
        for (int i = 0; i < arrayList.size(); i++) {
            if(!arrayList.get(i).correct()){
               arrayList.remove(i);
               i--;
            }

        }
    }
    public void united(Test test2){
        for (int i = 0; i < test2.arrayList.size(); i++) {
            if(!this.arrayList.contains(test2.arrayList.get(i))){
                this.arrayList.add(test2.arrayList.get(i));
            }
        }
    }
    public void del_doubles(){
        for (int i = 0; i <arrayList.size() ; i++) {
            for (int j = i+1; j < arrayList.size(); j++) {
                if(arrayList.get(i).getSurname().equals(arrayList.get(j).getSurname()) &&
                        arrayList.get(i).getName().equals(arrayList.get(j).getName()) &&
                        arrayList.get(i).getDate().equals(arrayList.get(j).getDate() )){
                    arrayList.remove(j);
                }

            }

        }
    }
    public void sorting(){
        Collections.sort(arrayList, new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                return o1.getSurname().charAt(0)-o2.getSurname().charAt(0);
            }
        });
    }
    public void filePrint(FileWriter fw)throws IOException {
        for (int j = 0; j < arrayList.size(); j++) {
            arrayList.get(j).filePrint(fw);
        }
        DecimalFormat f = new DecimalFormat("##.000");

        fw.write("Average of all: ");
        fw.write(f.format(averages)+"\n");

    }



}
