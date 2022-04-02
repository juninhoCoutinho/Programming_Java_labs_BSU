import java.util.Date;
import java.util.Scanner;

public class Order extends Entity{
    private String date_sale;
    private String model;
    private String saler_surname;
    private String car_number;
    private int mileage;

    private int cost;
    private double engine_volume;
    private String client_surname;

    public Order(String s){
        String[] args=s.split(" ");
        this.date_sale=args[0];
        this.model=args[1];
        this.saler_surname=args[2];
        this.car_number=args[3];
        this.mileage=Integer.parseInt(args[4]);

        this.cost=Integer.parseInt(args[5]);
        this.engine_volume=Double.parseDouble(args[6]);
        this.client_surname=args[7];


    }
    public Order(Car car, Employee diler,String s){

        String[] args=s.split(" ");

        this.date_sale=args[0];
        this.model=car.getModel();
        this.saler_surname=diler.getSurname();
        Integer i=new Integer((int)Math.random()*9000+1000);
        this.car_number=i.toString();
        this.mileage=car.getMileage();

        this.cost=car.getCost();
        this.engine_volume=car.getEngine_volume();
        this.client_surname=args[1];
    }

    @Override
    public String toString1(){
        return "Дата продажи: " + date_sale + " модель: " + model +
                " продавец: " + saler_surname + " номер автомобиля: " + car_number+ " пробег: " + mileage + " км " +
                 " цена: " + cost+ " евро объем двигателя: " + engine_volume
                + " фамилия покупателя: " + client_surname;
    }

    @Override
    public String toString2() {
        return date_sale + " " + model +
                " " + saler_surname + " " + car_number+ " " + mileage + " км" +
                " " + " " + cost+ " " + engine_volume+ " " + client_surname;
    }

    @Override
    public boolean equals(Object o) {
        Order order = (Order) o;
        return  date_sale.compareTo(order.date_sale) == 0 && model.compareTo(order.model) == 0
                && saler_surname.compareTo(order.saler_surname) == 0 && car_number.compareTo(order.car_number) == 0
                && client_surname.compareTo(order.client_surname) == 0
                && mileage==order.mileage && cost==order.cost && engine_volume==order.engine_volume;
    }

    public String getDate_sale() {
        return date_sale;
    }
}
