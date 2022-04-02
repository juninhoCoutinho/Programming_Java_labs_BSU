/*Король Владислав, 2 курс 8 группа

Задание 3(матрицы в стиле С)

3. Выведите номера столбцов, все элементы, которых четны.
Для каждого столбца с  отрицательным  элементом  на главной диагонали
вывести его номер и сумму всех элементов этого столбца.

 */
        package com.company;


import java.util.Comparator;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Arrays1{
    public static void main(String[] args) {
        Random random = new Random();

        Scanner in = new Scanner(System.in);

        System.out.println("Input n and m");
        int n = in.nextInt();
        int m = in.nextInt();
        int matrix[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = random.nextInt(10)-5;
                //System.out.print(matrix[i][j] +"    ");
                System.out.printf("%4d\t", matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        boolean isEven=true;
        System.out.print("Номера столбцов, где все элементы четны: ");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(Math.abs(matrix[j][i])%2==1)
                    isEven=false;

            }
            if(isEven==true)
                System.out.print(i+1+" ");
            isEven=true;

        }
        System.out.println();
        System.out.println("=======================================================");
        try {
            System.out.println("Номера столбцов, где на главной диагонали элемент отрицательный: ");
            if(m!=n)
                throw new Exception("ERROR");
            int M = Math.min(m, n);
            for (int i = 0; i < M; i++) {
                if (matrix[i][i] < 0) {
                    int sumColumn = 0;
                    for (int j = 0; j < n; j++) {
                        sumColumn += matrix[j][i];

                    }
                    System.out.println((i + 1) + " ,сумма=" + sumColumn);
                    sumColumn = 0;
                }
            }
        }
        catch (Exception ex){
            System.out.println("Неквадратная матрица!");
        }

    }
}