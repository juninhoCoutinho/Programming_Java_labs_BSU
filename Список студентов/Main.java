import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws Exception {

            FileInputStream fis1 = new FileInputStream("test1.txt");
            Scanner sc1 = new Scanner(fis1);
                Test test1=new Test(sc1);
                
        FileInputStream fis2 = new FileInputStream("test2.txt");
        Scanner sc2 = new Scanner(fis2);
        Test test2=new Test(sc2);
        fis1.close();
        fis2.close();
        FileWriter fw=new FileWriter("Data.txt");
            try {


                test1.print();
                test1.del_incorrect();
                test2.del_incorrect();
                System.out.println("\n\n");
                test1.print();
                System.out.println("\n\n");
                test1.united(test2);
                test1.print();
                System.out.println("\n\n");
                test1.del_doubles();
                test1.print();
                System.out.println("\n\n");
                test1.sorting();
                test1.print();
                test1.filePrint(fw);

                fw.close();
            }catch (Exception  e){
                System.out.println("ERROR");
            }


        }



    }

