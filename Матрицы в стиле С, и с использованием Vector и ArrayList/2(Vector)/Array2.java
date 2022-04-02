/*Король Владислав, 2 курс 8 группа
    Vector

17.	Подсчитать количество столбцов заданной матрицы, которые составлены из попарно различных чисел.
 */
package com.company;

import java.util.*;


public class Array2 {
    private int dim_1;
    private int dim_2;
    private Vector<Vector<Integer>> matrix;
    private Vector<Integer> tmp;

    public void goRand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first dimension:");
        dim_1 = scanner.nextInt();
        System.out.println("Enter the second dimension:");
        dim_2 = scanner.nextInt();
        Random rnd = new Random();
        matrix = new Vector();
        tmp = new Vector();
        for (int i = 0; i < dim_1; i++) {
            for (int j = 0; j < dim_2; j++) {
                tmp.add(rnd.nextInt(20));
            }
            matrix.add(tmp);
            tmp = new Vector();
        }
    }

    public void output() {
        for (int i = 0; i < dim_1; i++) {
            for (int j = 0; j < dim_2; j++) {
                System.out.printf("%4d\t", matrix.get(i).get(j));
                System.out.print( " ");
            }
            System.out.println("");
        }
    }

    public void kolvo_diff_columns() {
        int count = 0;
        boolean different=true;

        for (int i = 0; i < dim_2; i++) {
            for (int j = 0; j < dim_1-1; j++) {
                for (int k = j + 1; k < dim_1; k++) {
                    if (matrix.get(j).get(i) == matrix.get(k).get(i))
                        different = false;
                }
            }

                if (different==true) {
                    count++;
                }
                different=true;
        }
        System.out.print("Количество столбцов, где все элементы попарно различны: "+count);
    }
}