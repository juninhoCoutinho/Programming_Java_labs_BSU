/*Король Владислав 2 курс 8 группа

3.	Строки текстового файла input.txt состоят из слов, разделенных одним или несколькими пробелами.
 Перед первым, а также после последнего слова строки пробелы могут отсутствовать.
 Требуется определить строки, содержащие максимальное количество слов.
 Если таких строк несколько, найти первые 5. Результат вывести на консоль в форме, удобной для чтения.

        */
import java.io.*;
import java.util.ArrayList;

import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) {
        try {

            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader("input.txt");
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            ArrayList<String> arrayList=new ArrayList<>();
            System.out.println("Исходный файл: ");
            int numWordsMax=0;
            while (line != null) {
                System.out.println(line);
                StringTokenizer st = new StringTokenizer(line," ");
                int numWords = 0;

                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    numWords++;
                }
                if(numWords>numWordsMax){
                    arrayList.clear();
                    arrayList.add(line);
                    numWordsMax=numWords;
                }
                else if(numWords==numWordsMax){
                    arrayList.add(line);
                }
                

                line = reader.readLine();
            }
            int i=0;
            System.out.println("\n\nResult: ");
            while(i<5 && i<arrayList.size()){
                System.out.println(arrayList.get(i));
                i++;
            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
