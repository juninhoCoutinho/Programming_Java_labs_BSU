import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Input extends Correct implements Output{

    private FileReader fr;
    private ArrayList<StringBuffer> strings;
    private FileWriter fw;
    private int num_string;
    private int num_char;
    private boolean insert_mode=true;

    public Input() throws IOException {

        fr =new FileReader("Text.txt");
        fw=new FileWriter("Result.txt");
        Scanner sc=new Scanner(fr);
        strings=new ArrayList<>();
        while (sc.hasNextLine()){
            StringBuffer sb=new StringBuffer(sc.nextLine());
            strings.add(strings.size(),sb);

        }
        num_char=0;
        num_string=0;



    }

    public ArrayList<StringBuffer> getStrings() {
        return strings;
    }

    public boolean isInsert_mode() {
        return insert_mode;
    }

    public void print(){
        System.out.println(strings.get(num_string).substring(num_char));
        for (int i = num_string+1; i < strings.size(); i++) {
            System.out.println(strings.get(i).toString());
        }
        System.out.println();

    }
    public void file_print() throws IOException {
        fw.write(strings.get(num_string).substring(num_char)+"\n");
        for (int i = num_string+1; i < strings.size(); i++) {
            fw.write(strings.get(i).toString()+"\n");
        }
        fw.write("\n");
        fw.close();

    }

    @Override
    public void go_to(int n, int m) {
        if(n>strings.size())
            num_string=strings.size()-1;
        else
            num_string=n;
        if(m>strings.get(num_string).length()-1){
            num_char=strings.get(num_string).length();
        }
        else
            num_char=m;

    }
    public void go_to(int n, int m,String s) {
        if(n>strings.size())
            num_string=strings.size()-1;
        else
            num_string=n;
        if(m>strings.get(num_string).length()-1){
            num_char=strings.get(num_string).length();
        }
        else
            num_char=m;

        strings.get(num_string).insert(num_char,s);

    }
    public void check_cursor(){
        strings.get(num_string).insert(num_char,"1$");

    }


    @Override
    public void right() {
        if (num_char != strings.get(num_string).length() - 1)
            num_char += 1;
        strings.get(num_string).insert(num_char,"2$");
    }
    public void left() {
        if (num_char != 0)
            num_char -= 1;
        strings.get(num_string).insert(num_char,"2$");
    }

    @Override
    public void up() {
        if(num_string!=0)
            num_string-=1;
        strings.get(num_string).insert(num_char,"2$");
    }

    @Override
    public void down() {
        if(num_string!=strings.size()-1)
            num_string+=1;
        strings.get(num_string).insert(num_char,"2$");
    }

    @Override
    public void ctrl_down() {
        if(num_string!=strings.size()-1) {
            num_string += 1;
            num_char=0;
        }
        strings.get(num_string).insert(num_char,"4$");
    }

    @Override
    public void ctrl_up() {
        if(num_string!=0) {
            num_string -= 1;
            num_char=0;
        }
        strings.get(num_string).insert(num_char,"4$");
    }

    @Override
    public void ctrl_left() {
        int i=num_char;
        String delim=" \\;:,.!?/|";
        do {
            i -= 1;
        } while(delim.indexOf(strings.get(num_string).charAt(i))==-1 && i!=0);
        do {
            i -= 1;
        } while(delim.indexOf(strings.get(num_string).charAt(i))==-1 && i!=0);
        i+=1;

        num_char=i;
        strings.get(num_string).insert(num_char,"3$");
    }
    public void backspace(){
        if(num_char!=0) {
            strings.get(num_string).deleteCharAt(num_char - 1);
            num_char -= 1;
        }
    }
    public void del(){

        strings.get(num_string).deleteCharAt(num_char);
        if(num_char==strings.get(num_string).length())
            num_char-=1;
    }
    public void enter(){
        StringBuffer sb= new StringBuffer();
        sb.append(strings.get(num_string).substring(num_char));
        strings.add(num_string+1,sb);

        strings.get(num_string).delete(num_char,strings.get(num_string).length());
        num_string+=1;
        num_char=0;
    }
    public void ins( ){
        insert_mode=!insert_mode;
    }
    public void change(StringBuffer sb){
        if(insert_mode){
            strings.get(num_string).insert(num_char,sb.toString());
            num_char+=sb.length();
        }
        else{
            strings.get(num_string).replace(num_char,num_char+sb.length(),sb.toString());
        }
    }



}

