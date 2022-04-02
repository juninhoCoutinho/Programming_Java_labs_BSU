import java.io.*;

import java.util.*;

public class AShow implements Autoshow {
    private static final long serialVersionUID = 1L;
    private HashMap<Integer, Car> cars = new HashMap<>();
    private HashMap <Integer, Employee> dilers = new HashMap<>();
    private HashMap <Integer, Order> orders = new HashMap<>();


    public void read() throws IOException{
        FileReader fr1=new FileReader("cars.txt");
        Scanner sc1=new Scanner(fr1);

        while (sc1.hasNextLine()){
            cars.put(cars.size()+1,new Car(sc1.nextLine()));
        }
        FileReader fr2=new FileReader("dilers.txt");
        Scanner sc2=new Scanner(fr2);

        while (sc2.hasNext()){

            dilers.put(dilers.size()+1,new Employee(sc2.nextLine()));
        }

    }
    public void write() throws IOException{
        FileWriter fw=new FileWriter("output.txt");


            fw.write("Cars list: \n");
            for (Car temp : cars.values()) {
                fw.write(temp.toString1()+"\n");
            }

            fw.write("Dilers list: \n");
            for (Employee temp: dilers.values()) {
                fw.write(temp.toString1()+"\n");
            }


            fw.write("Orders list: \n");
            for (Order temp: orders.values()) {
                fw.write(temp.toString1()+"\n");
            }
            fw.close();


    }






    public void save() throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("res.ser")))
        {
            oos.writeObject(this);
            System.out.println("Serialization");
        }
        catch(Exception ex){

            System.out.println("ERROR OF SERIALIZATION");
        }
    }

    public void searchCar(){
        System.out.println("Enter model of car");
        Scanner sc= new Scanner(System.in);
        String m=sc.nextLine();
        ArrayList<Car> findedCars=new ArrayList<>();
        for (Map.Entry<Integer,Car> entry : cars.entrySet()) {
            if (entry.getValue().getModel().compareTo(m)==0) {
                findedCars.add(entry.getValue());
            }
        }
        for (Car c:findedCars) {
            System.out.println(c.toString1());
        }

    }
    public void searchDiler(){
        System.out.println("Enter Surname of diler");
        Scanner sc= new Scanner(System.in);
        String m=sc.nextLine();
        ArrayList<Employee> findedDilers=new ArrayList<>();
        for (Map.Entry<Integer,Employee> entry : dilers.entrySet()) {
            if (entry.getValue().getSurname().compareTo(m)==0) {
                findedDilers.add(entry.getValue());
            }
        }
        for (Employee c:findedDilers) {
            System.out.println(c.toString1());
        }

    }
    public void searchOrder(){
        System.out.println("Enter date of sale");
        Scanner sc= new Scanner(System.in);
        String m=sc.nextLine();
        ArrayList<Order> findedOrders=new ArrayList<>();
        for (Map.Entry<Integer,Order> entry : orders.entrySet()) {
            if (entry.getValue().getDate_sale().compareTo(m)==0) {
                findedOrders.add(entry.getValue());
            }
        }
        for (Order c:findedOrders) {
            System.out.println(c.toString1());
        }

    }
    public void addCar(){
        System.out.println("Enter model, cost, mileage and engine_volume: ");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        if(!cars.values().contains(new Car(data))){
            cars.put(cars.size()+1, new Car(data));
            System.out.println(" Car added successfully!");
        }
        else System.out.println("Wrong input or car already exists!");
    }
    public void addDiler(){
        System.out.println("Enter surname, table_number, category, birth_date, address, salary and tax_per_sale;");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        if(!dilers.values().contains(new Employee(data))){
            dilers.put(dilers.size()+1, new Employee(data));
            System.out.println("Diler Added successfully!");
        }
        else System.out.println("Wrong input or diler already exists!");
    }
    public void addOrder(){
        System.out.println("Enter date_sale, model, saler_surname, car_number, mileage, cost, volume, client_surname: ");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        if(!orders.values().contains(new Order(data))){
            orders.put(orders.size()+1, new Order(data));
            System.out.println(" Order added successfully!");
        }
        else System.out.println("Wrong input or Order already exists!");
    }
    public void addOrder1(){
        System.out.println("Enter date_sale, client_surname: ");
        Scanner sc = new Scanner(System.in);
        ArrayList<Car> choosed_cars=new ArrayList<>();
        String data = sc.nextLine();



        System.out.println("Enter model: ");
        Scanner sc1 = new Scanner(System.in);
        String choosed_model = sc.nextLine();


        for (Map.Entry<Integer,Car> entry : cars.entrySet()) {
            if(entry.getValue().getModel().equals(choosed_model))
                choosed_cars.add(entry.getValue());

        }

        int i=0;
        if(choosed_cars.size()>1){
            System.out.println("Выберите номер комплектации от 0:");
            for (Car c:choosed_cars ) {
                System.out.println(c.toString1());
            }

            Scanner sc3=new Scanner(System.in);
            i=Integer.parseInt(sc3.next());
        }
        int diler_number=(int)(Math.random()*dilers.size());


        if(!orders.values().contains(new Order(choosed_cars.get(i),dilers.get(diler_number),data))){
            orders.put(orders.size()+1, new Order(choosed_cars.get(i),dilers.get(diler_number),data));
            System.out.println(" Order added successfully!");
        }
        else System.out.println("Wrong input or Order already exists!");
    }
    public void deleteCar(){
        System.out.println("Enter model, cost, mileage and engine_volume: ");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        int key=-1;

        for (Map.Entry<Integer,Car> entry : cars.entrySet()) {
                    if (entry.getValue().equals(new Car(data))) {
                        key=entry.getKey();
                    }
        }
        if(key>0) {
            cars.remove(key, new Car(data));
            System.out.println("Deleted successfully!");
        }
        else System.out.println("Wrong input or car already deleted!");
    }


    public void deleteDiler(){
        System.out.println("Enter surname, table_number, category, birth_date, address, salary and tax_per_sale;");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        int key=-1;

        for (Map.Entry<Integer,Employee> entry : dilers.entrySet()) {
            if (entry.getValue().equals(new Employee(data))) {
                key=entry.getKey();
            }
        }
        if(key>0) {
            dilers.remove(key, new Employee(data));
            System.out.println("Deleted successfully!");
        }
        else System.out.println("Wrong input or Diler already deleted!");
    }


    public void deleteOrder(){
        System.out.println("Enter date_sale, model, saler_surname, car_number, mileage, cost, volume, client_surname: ");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        int key=-1;

        for (Map.Entry<Integer,Order> entry : orders.entrySet()) {
            if (entry.getValue().equals(new Order(data))) {
                key=entry.getKey();
            }
        }
        if(key>0) {
            orders.remove(key, new Order(data));
            System.out.println("Deleted successfully!");
        }
        else System.out.println("Wrong input or Order already deleted!");
    }
    public void change(int param) {
        switch (param) {
            case (1):
                System.out.println("Enter model, cost, mileage and engine_volume: ");
                Scanner scd = new Scanner(System.in);
                String datad = scd.nextLine();

                System.out.println("Enter new data: ");
                String datadn = scd.nextLine();
                    int key=-1;
                    for (Map.Entry<Integer,Car> entry : cars.entrySet()) {
                        if (entry.getValue().equals(new Car(datad))) {
                            key=entry.getKey();
                        }
                    }
                    if(key>0) {
                        cars.remove(key, new Car(datad));
                        cars.put(key, new Car(datadn));
                        System.out.println("Changed successfully!");
                    }
                    else System.out.println("Wrong input or car already deleted!");

                    break;
            case(2):
                System.out.println("Enter surname, table_number, category, birth_date, address, salary and tax_per_sale;");
                Scanner scd2 = new Scanner(System.in);
                String datad2 = scd2.nextLine();

                System.out.println("Enter new data: ");
                String datadn2 = scd2.nextLine();
                int key2=-1;
                for (Map.Entry<Integer,Employee> entry : dilers.entrySet()) {
                    if (entry.getValue().equals(new Employee(datad2))) {
                        key=entry.getKey();
                    }
                }
                if(key2>0) {
                    dilers.remove(key2, new Employee(datad2));
                    dilers.put(key2, new Employee(datadn2));
                    System.out.println("Changed successfully!");
                }
                else
                    System.out.println("Wrong input or diler already deleted!");
                break;
            case(3):
                System.out.println("Enter date_sale, model, saler_surname, car_number, mileage, cost, volume, client_surname: ");
                Scanner scd3 = new Scanner(System.in);
                String datad3 = scd3.nextLine();

                System.out.println("Enter new data: ");
                String datadn3 = scd3.nextLine();
                int key3=-1;
                for (Map.Entry<Integer,Order> entry : orders.entrySet()) {
                    if (entry.getValue().equals(new Order(datad3))) {
                        key3=entry.getKey();
                    }
                }
                if(key3>0) {
                    orders.remove(key3, new Order(datad3));
                    orders.put(key3, new Order(datadn3));
                    System.out.println("Changed successfully!");
                }
                else
                    System.out.println("Wrong input or order already deleted!");
                break;
        }
    }
    public void showCars() {

        System.out.println("Cars list: ");
        for (Car temp : cars.values()) {
            System.out.println(temp.toString1());
        }
    }
    public void showDilers() {

                System.out.println("Dilers list: ");
                for (Employee temp: dilers.values()) {
                    System.out.println(temp.toString1());
                }

    }
    public void showOrders() {

        System.out.println("Orders list: ");
        for (Order temp: orders.values()) {
            System.out.println(temp.toString1());
        }

    }

}
