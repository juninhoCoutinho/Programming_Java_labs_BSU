/*
Вычислить приближённое значение суммы бесконечного ряда.
Вычисления заканчивать, когда очередное слагаемое окажется
по модулю меньше заданного числа ε. Вид этого числа
определяется следующим условием:
ε=10^(-k), где k - натуральное число. Сравнить полученный
результат со значением, вычисленным через стандартные функции.
Вывести на консоль оба результата.
Ряд: ln(1-x)=-x-x^2/2-x^3/3-..,x ∈ (-1,+1)
*/
package com.company;
import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;
import java.io.*;
import java.text.*;

public class Main {
    public  static double myPow(double x, int y) {
        double result=1;
        if(y>0){
            for(int i=1; i<=y; i++){
                result*=x;
            }
        }
        else if(y<0){

            result/=myPow(x,(-y));
        }
        else {
            result=1;
        }
        return result;
    }
    public static double myFunction(double x, double e){
        double y=(-x);
        double p=(-x);
        double k=2;
        while(Math.abs(p)>e)
        {
            p=p*x*(k-1)/k;
            y+=p;
            k+=1;
        }
        return y;
    }
    public static void main(String[] args) {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        try {
            System.out.println("Введите x ∈ [-1,+1): ");
            String line=br.readLine();
            double ourNumber = Double.parseDouble(line);
            System.out.println("Введите натуральное число k: ");
            String secondLine=br.readLine();
            int ourDegree = Integer.parseInt(secondLine);
            ourDegree = -ourDegree;
            double e = myPow(10, ourDegree);
            System.out.println("Результат через стандартные функции: ");
            double result = Math.log(1-ourNumber);
            NumberFormat formatter=NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(9);
            System.out.println(formatter.format(result));
            System.out.println("Мой результат: ");
            double myResult = myFunction(ourNumber, e);
            System.out.println(formatter.format(myResult));
        }
        catch (NumberFormatException e) {
            System.out.println("Не число");
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения с клавиатуры");
        }
    }
}