


import java.util.Vector;
import com.company.Array3;

public class Main {

        public static void main(String[] args) {
            try {


                System.out.println(" ");

                Array3 matrix_1 = new Array3();
                Array3 matrix_2 = new Array3();



                matrix_1.goRand();
                System.out.println("matrix 1");
                matrix_1.output();


                matrix_2.goRand();
                if(matrix_1.getDim_1()!=matrix_2.getDim_1())
                    throw new Exception("ERROR");
                System.out.println("matrix 2");
                matrix_2.output();
                matrix_1.multiply(matrix_2);
                System.out.println("RESULT");
                matrix_1.output();
            }
            catch (Exception ex){
                System.out.println("!!!Количество строк во второй матрице не совпадает с количеством строк в первой матрице, что делает их умножение невозможным");
            }

        }
    }


