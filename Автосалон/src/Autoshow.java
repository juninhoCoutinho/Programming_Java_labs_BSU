import java.io.IOException;
import java.io.Serializable;


public interface Autoshow extends Serializable {
        void read() throws IOException;
        void write() throws IOException;


        void searchCar();
        void addCar();
         void addDiler();

         void addOrder();


        void change(int param);
        void showCars();
        void showOrders();
        void showDilers();

     void deleteCar();


    void deleteDiler();


    void deleteOrder();
    }

