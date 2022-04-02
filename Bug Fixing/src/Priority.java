import java.util.Scanner;

public class Priority {
    private int priority_id;
    private String priority_name;

    public String getPriority_name() {
        return priority_name;
    }

    public int getPriority_id() {
        return priority_id;
    }

    public Priority(Scanner sc){
        String[] s=sc.nextLine().split(";");
        this.priority_id=Integer.parseInt(s[0]);
        this.priority_name= s[1];

    }
}
