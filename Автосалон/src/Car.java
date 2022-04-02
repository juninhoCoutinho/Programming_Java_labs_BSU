import java.util.StringTokenizer;

public class Car extends  Entity{
    private String model;
    private int cost;
    private  int mileage;
    private double engine_volume;

    public Car(String s){
        String[] args=s.split(" ");
        this.model=args[0];
        this.cost=Integer.parseInt(args[1]);
        this.mileage=Integer.parseInt(args[2]);
        this.engine_volume=Double.parseDouble(args[3]);

    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public double getEngine_volume() {
        return engine_volume;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString1(){
        return "Марка " + model + " цена: " + cost + " евро " + " пробег : "
                + mileage + "км  объем двигателя: " + engine_volume;
    }

    @Override
    public String toString2(){
        return  model + " "+cost + " " + mileage + " " + engine_volume;
    }

    @Override
    public boolean equals(Object o) {
        Car car = (Car) o;
        return  model.compareTo(car.model) == 0 && cost==car.cost &&
                mileage==car.mileage && engine_volume==car.engine_volume;
    }







}
