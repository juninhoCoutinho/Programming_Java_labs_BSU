
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Students {
    private String surname;
    private String name;
    private String date;
    private ArrayList<Integer> marks;
    private double average;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDate() {
        return date;
    }

    public int getMarks(int i) {
        return marks.get(i);
    }
    public boolean correct(){
        for (int i = 0; i < marks.size(); i++) {

            if(marks.get(i) < 0 || marks.get(i)>10)
                return false;

        }
        return true;

    }

    public double getAverage() {
        return average;
    }

    public Students(String str){

        StringTokenizer st=new StringTokenizer(str," ");
        String token=st.nextToken();
        this.surname=token;
        token=st.nextToken();
        this.name=token;
        token=st.nextToken();
        this.date=token;
        token=st.nextToken();
        this.marks=new ArrayList<>();
        average=0;
        for (int i = 0; i < 4 ;i++) {

                marks.add(i,Integer.parseInt(token));
                average+=marks.get(i);

            if(i<3)
                token = st.nextToken();
        }
        average/=marks.size();

    }

    public void print(){
        System.out.print("Student: "+this.surname+" "+this.name+" "+this.date+" ");
        for (int i = 0; i < marks.size() ; i++) {
            System.out.print(marks.get(i)+" ");
        }
        System.out.print(" Average: "+average);
        System.out.println(" ");

    }
    public void filePrint(FileWriter fw) throws IOException {
        fw.write("Student: "+this.surname+" "+this.name+" "+this.date+" ");
        for (int i = 0; i < marks.size() ; i++) {
            fw.write(marks.get(i)+" ");
        }
        fw.write(" Average: "+average);
        fw.write(" \n");

    }



}
