/*Король Владислав 2 курс 8 группа

3. Строка состоит из слов. За один просмотр символов строки найти все слова,
начинающиеся с гласных букв,  и занести их в новую строку,заменяя первую
букву каждого слова на прописную. Слова в исходной строке разделяются
некоторым множеством разделителей. Слова в новой строке должны разделяться ровно одним пробелом.


 */
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            String str = br.readLine();
            String vowels="aeyuioAEYUIOуеёаыяоиюэУЁЕЫАОЭЯИЮ";
            StringBuffer sb= new StringBuffer();
            System.out.println("Исходная строка: "+str);
            StringTokenizer st= new StringTokenizer(str," \t.,;:?!%'\n");
            while (st.hasMoreTokens()){
                String token=st.nextToken();
                if (vowels.indexOf(token.charAt(0))!=-1) {
                    sb.append(token.substring(0,1).toUpperCase()+token.substring(1,token.length())+" ");

                }

            }
            System.out.println("Result: "+sb.toString());
        } catch (IOException e) {
            System.out.println("Ошибка чтения с клавиатуры");

        }

    }
}
