import java.io.FileWriter;
import java.util.Scanner;

public class Pair {
    private int bug_id;
    private int qa_id;

    public int getQa_id() {
        return qa_id;
    }

    public int getBug_id() {
        return bug_id;
    }

    public Pair(Scanner sc){
        String[] s=sc.nextLine().split(";");
        this.bug_id=Integer.parseInt(s[0]);
        this.qa_id=Integer.parseInt(s[1]);

    }

}
