/*
Вычислить приближённое значение суммы бесконечного ряда.
Вычисления заканчивать, когда очередное слагаемое окажется
по модулю меньше заданного числа ε. Вид этого числа
определяется следующим условием:
ε=10^(-k), где k - натуральное число. Сравнить полученный
результат со значением, вычисленным через стандартные функции.
Вывести на консоль оба результата.
Ряд: 1/((1+x)^(1/2))=1-1*x/2+(1*3*x^2)/(2*4)-(1*3*5*x^3)/(2*4*6)..,x ∈ (-1,+1)
*/
package com.company;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;
import java.io.*;
import java.text.*;
import java.math.BigDecimal;
import java.util.concurrent.BlockingDeque;

public class Main {
    public static void main(String[] args) {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        try {
            System.out.println("Введите x ∈ (-1,+1): ");
            String line=br.readLine();
            BigDecimal ourNumber = new BigDecimal(line);
            System.out.println("Введите натуральное число k: ");
            String secondLine=br.readLine();
            BigInteger ourDegree = new BigInteger(secondLine);

            BigDecimal ten= new BigDecimal(10.0);


            BigDecimal e=new BigDecimal(1.0);
            for(int i=1; i<=ourDegree.doubleValue(); i++) {
                e=e.divide(ten);
            }
            BigDecimal currentMember = new BigDecimal(ourNumber.doubleValue());
            currentMember =currentMember.negate();

            BigDecimal sum= new BigDecimal(currentMember.doubleValue() );
            BigDecimal one= new BigDecimal(1);
            BigDecimal  k= new BigDecimal(1);

            while(currentMember.abs().compareTo(e)>0){

                currentMember=currentMember.multiply(ourNumber);
                currentMember=currentMember.multiply(k);
                k=k.add(one);
                currentMember=currentMember.divide(k,8,RoundingMode.HALF_UP);
                sum=sum.add(currentMember);
            }
            NumberFormat formatter=NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(9);
            System.out.println("Мой результат: ");
            System.out.println(sum);
            System.out.println("Результат путем стандартных функций");
            BigDecimal result = new BigDecimal(1.0);
            result=new BigDecimal(Math.log(1.0-ourNumber.doubleValue()));

            System.out.println(result);
        }
        catch (NumberFormatException e) {
            System.out.println("Не число");
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения с клавиатуры");
        }
    }
}