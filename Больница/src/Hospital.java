/* Система Больница. Пациенту назначается Врач, который делает ему назначения и выполняет эти назначения,
 Пациент может быть выписан по завершении лечения или иных обстоятельствах*/
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.*;

public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;

    class Patient implements  Serializable{
        private Date admission_date;
        private String name;


        private ArrayList<String> drugs=new ArrayList<>();

        private Doctor doctor;

        //private Date discharge_date;

        public Patient(){
            this.name="patient";
        }

        public Patient(String name, Date admission_date, Doctor doctor){
            this.name=name;
            this.admission_date=admission_date;
            this.doctor=doctor;
        }
        public String getName(){
            return name;
        }
        public void add_drug(String drug){
            drugs.add(drug);
        }

        public void print(){
            System.out.println(rb.getString("patient")+name+" "+rb.getString("registered")+admission_date+" "+rb.getString("his_doctor_is")+doctor.name);
            System.out.println(rb.getString("prescribed_drugs"));
            for (String s:drugs) {
                System.out.print(s+",");
            }
            System.out.println();
        }

        public void setDoctor(Doctor doctor){
            this.doctor=doctor;
        }


    }
    class Doctor implements Serializable{
        private String name;
        private ArrayList<Patient> patients;
        public Doctor(String name){
            this.name=name;
            this.patients=new ArrayList<>();
        }
        
        public void print(){
            System.out.println(rb.getString("doctor")+name+" "+rb.getString("have")+patients.size()+" "+rb.getString("patients"));
        }

        public String getName(){
            return name;
        }
        public void treat(String[] args, Scanner sc){

            for (Patient p:this.patients) {
                System.out.println(rb.getString("title_of_treat")+this.name+" "+rb.getString("for")+p.getName());

                String drug = sc.nextLine();
                StringTokenizer st= new StringTokenizer(drug," ,.:;!?");
                while (st.hasMoreTokens()) {
                    String token=st.nextToken();

                    if(p.drugs.contains(token))
                        p.drugs.remove(token);

                    if (p.drugs.size()==0)
                        discharge(p);
                }
            }
        }

        public void add_patient(Patient patient){
            this.patients.add(patient);

        }

        public void prescribe(String[] args, Scanner sc){

            for (Patient p:patients) {
                System.out.println(rb.getString("title_of_drug")+this.name+" "+rb.getString("for")+p.getName());

                String drug = sc.nextLine();
                StringTokenizer st= new StringTokenizer(drug," ,.:;!?");
                while(st.hasMoreTokens()) {
                    String token = st.nextToken();
                    p.add_drug(token);
                }
            }
        }
    }
    class Nurse implements Serializable{
        private String name;
        private ArrayList<Patient> patients;
        public Nurse(String name){
            this.name=name;

        }
        public void print(){
            System.out.println(rb.getString("nurse")+name+" "+rb.getString("have")+patients.size()+" "+rb.getString("patients"));
            for( Patient p:patients) {
                p.print();
            }
            System.out.println();
        }

        public String getName(){
            return name;
        }

        public void add_patient(Patient patient){
            this.patients.add(patient);

        }


    }


    private Locale locale;
    transient private ResourceBundle rb ;

    private ArrayList<Patient> patients= new ArrayList<>();
    private ArrayList<Doctor> doctors= new ArrayList<>();
    private ArrayList<Nurse> nurses= new ArrayList<>();

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public Patient get_patient(int index){
        return patients.get(index);
    }
    public  Doctor get_doctor(int index){
        return  doctors.get(index);
    }

    public void register(String[] args, Scanner sc) {
        //Scanner sc = new Scanner(System.in);
        //System.out.println(rb.getString("nickname_of_new_patient"));
        String nicname;
        int flag;
        do {
            flag = 0;
            nicname = sc.nextLine();
            for (Patient patient : patients) {
                if (patient.getName().compareTo(nicname) == 0)
                    flag++;
            }
            if (flag != 0)
                System.out.println(rb.getString("same_name"));
            else
                flag = 0;
        } while(flag != 0);

        int index=0;
        for (int i = 0; i < doctors.size(); i++) {
            if(doctors.get(i).patients.size()<=doctors.get(index).patients.size())
                index=i;
        }

       patients.add(0,new Patient(nicname, new Date(),doctors.get(index)));

        doctors.get(index).patients.add(patients.get(0));

        //show_menu(args);
    }



    public void discharge(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println(rb.getString("nickname_of_discharge"));
        String nicname=sc.nextLine();
        for (int i = 0; i <patients.size(); i++) {
            if(patients.get(i).getName().equals(nicname)) {
                patients.remove(i);
                break;
            }

        }
    }
    public void discharge(Patient p){

        for (int i = 0; i <patients.size(); i++) {
            if(patients.get(i).getName().equals(p.name)) {
                patients.remove(i);
                break;
            }

        }
    }

    public void add_nurse(String[] args, Scanner sc){
        System.out.println(rb.getString("name_new_nurse"));
        String nicname;
        int flag;
        do {
            flag = 0;
            nicname = sc.nextLine();
            for (Nurse nurse : nurses) {
                if (nurse.getName().compareTo(nicname) == 0)
                    flag++;
            }
            if (flag != 0)
                System.out.println(rb.getString("same_name"));
            else
                flag = 0;
        } while(flag != 0);



        this.nurses.add(0,new Nurse(nicname));

    }

    public void add_doctor(String[] args, Scanner sc){

        //System.out.println(rb.getString("name_new_doctor"));
        String nicname;
        int flag;
        do {
            flag = 0;
            nicname = sc.nextLine();
            for (Doctor doctor : doctors) {
                if (doctor.getName().compareTo(nicname) == 0)
                    flag++;
            }
            if (flag != 0)
                System.out.println(rb.getString("same_name"));
            else
                flag = 0;
        } while(flag != 0);
        
        
        
        this.doctors.add(0,new Doctor(nicname));

    }
    
    public void show_doctors(){
        System.out.println(rb.getString("list_of_doctors"));
        for (Doctor doctor:doctors) {
            doctor.print();            
        }
    }
    
    public void show_patients(){
        System.out.println(rb.getString("list_of_patients"));
        for (Patient patient:patients) {
            patient.print();
        }
        
        
    }

    public void show_menu(String[] args){
        int language;
        System.out.println("Enter 1(RUS),2(BLR), or 3(ENG) language");
        Scanner sc=new Scanner(System.in);
        language=Integer.parseInt(sc.nextLine());
        switch (language){
            case 1:
                locale=new Locale("rus","RU");
                break;
            case 2:
                locale=new Locale("blr","BY");
                break;
             default:
                 locale=new Locale("eng","GBR");

        }

        rb = ResourceBundle.getBundle("Interfa",locale);
    }

    public void  save(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("res.ser")))
            {
                oos.writeObject(this);
                System.out.println("File has been written");
            }
            catch(Exception ex){

                System.out.println("ERROR OF SERIALIZATION");
            }
    }


}
