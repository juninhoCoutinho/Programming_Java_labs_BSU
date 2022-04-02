import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("res.ser"))) {

            AShow aShow = (AShow) ois.readObject();
            System.out.println("Deserialization is OK");

        /*AShow aShow=new AShow();
        aShow.read();*/
            aShow.showCars();
            aShow.showDilers();
            aShow.showOrders();
            aShow.addOrder1();
            aShow.searchCar();
            aShow.change(1);

            aShow.deleteCar();

            aShow.showOrders();
            aShow.write();
            aShow.save();
        }
        catch (Exception ex) {
            System.out.println("ERROR OF DESERIALIZATION");
        }


    }
}
