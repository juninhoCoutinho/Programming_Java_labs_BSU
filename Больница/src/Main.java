import java.io.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("res.ser"))) {
            Hospital hospital = (Hospital) ois.readObject();
            System.out.println("Deserialization is OK");*/

                FileReader fr=new FileReader("input.txt");
                Scanner sc= new Scanner(fr);
                Hospital hospital=new Hospital();
                 hospital.show_menu(args);


                for (int i = 0; i < 3; i++) {
                    hospital.add_doctor(args,sc);
                }
                for (int i = 0; i < 7; i++) {
                    hospital.register(args,sc);
                }
                sc.close();
            FileReader fr1=new FileReader("treats.txt");
            Scanner sc1=new Scanner(fr1);

                for (int i = 0; i <hospital.getDoctors().size() ; i++) {
                    hospital.get_doctor(i).prescribe( args, sc1);
                }

                hospital.show_doctors();
                hospital.show_patients();
                for(int i=0;i<hospital.getDoctors().size();i++){
                    hospital.get_doctor(i).treat(args,new Scanner(System.in));
                }
            hospital.show_menu(args);
            hospital.show_patients();
            hospital.discharge(args);
            hospital.show_patients();
            hospital.save();
        /*} catch (Exception ex) {
            System.out.println("ERROR OF DESERIALIZATION");
        }*/

    }
}











