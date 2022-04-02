import java.util.Date;

public class Employee extends Entity{
    private String surname;
    private long table_number;
    private String category; //А,В,С,D,Pro
    private String birth_date;
    private String address;
    private int salary;
    private double tax_per_sale;


    public Employee(String s){
        String[] args = s.split(" ");
        surname = args[0];
       table_number= Long.parseLong(args[1]);

        category = args[2];
        birth_date = args[3];
        address = args[4];
        salary = Integer.parseInt(args[5]);
        tax_per_sale = Double.parseDouble(args[6]);
    }
    @Override
    public String toString1(){
        return "Фамилия " + surname + " табельный номер: " + table_number+ " Категория сотрудника: "
                +category+ " дата рождения : " + birth_date + " адрес: " + address+" заработок: "
                +salary+" процент с продаж: "+tax_per_sale*100+"%";
    }

    @Override
    public String toString2(){
        return  surname + " " + table_number+ " "
                +category+ " " + birth_date + " " + address+" "
                +salary+" "+tax_per_sale*100+"%";
    }
    @Override
    public boolean equals(Object o) {
        Employee diler = (Employee) o;
        return  surname.compareTo(diler.surname) == 0 && category.compareTo(diler.category) == 0
                && birth_date.compareTo(diler.birth_date) == 0 && address.compareTo(diler.address) == 0
        && tax_per_sale==diler.tax_per_sale && salary==diler.salary && table_number==diler.table_number;
    }

    public String getSurname() {
        return surname;
    }
}
