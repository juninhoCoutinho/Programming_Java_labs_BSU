import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Input input= new Input();
        FileReader fr= new FileReader("Commands.txt");
        Scanner sc=new Scanner(fr);
        while(sc.hasNextLine()){
            String command= sc.nextLine();
            switch(command){
                case "print":
                    input.print();
                    break;
                case "del":
                    input.del();
                    break;
                case "backspace":
                    input.backspace();
                    break;
                case "ctrl_down":
                    input.ctrl_down();
                    break;
                case "ins":
                    input.ins();
                    break;
                case "ctrl_left":
                    input.ctrl_left();
                    break;
                case "ctrl_right":
                    input.ctrl_right();
                    break;
                case "ctrl_up":
                    input.ctrl_up();
                    break;
                case "check_cursor":
                    input.check_cursor();
                    break;
                case "enter":
                    input.enter();
                    break;
                case "file_print":
                    input.file_print();
                    break;
                    default:
                        ArrayList<String> arrgs=new ArrayList<>();
                        StringTokenizer st= new StringTokenizer(command," ");
                        int i=0;
                        while(st.hasMoreTokens()) {
                            String token = st.nextToken();
                            arrgs.add(i,token);
                            i++;
                        }
                        if(arrgs.get(0).equals("go_to")) {
                            if(arrgs.size()==3)
                                input.go_to(Integer.parseInt(arrgs.get(1)), Integer.parseInt(arrgs.get(2)));
                            if(arrgs.size()==4)
                                input.go_to(Integer.parseInt(arrgs.get(1)), Integer.parseInt(arrgs.get(2)),"1$");

                        }
                        else{
                            StringBuffer sb=new StringBuffer();
                            for (int j = 0; j < arrgs.size(); j++) {
                                sb.append(arrgs.get(j));
                            }
                            input.change(sb);
                        }

            }
        }

        /*input.go_to(0,0);
        input.ctrl_down();

        input.print();
        input.go_to(1,6);
        input.ctrl_up();
        input.print();

        input.file_print();*/

    }
}
