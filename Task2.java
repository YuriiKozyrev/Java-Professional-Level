package Java_Prof_Level.Lesson_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Task2 {
    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter("IOTest/task2-result.txt", false);
            int x;

            ArrayList<InputStream> ali = new ArrayList<>();
            ali.add(new FileInputStream("IOTest/task2-1.txt"));
            ali.add(new FileInputStream("IOTest/task2-2.txt"));
            ali.add(new FileInputStream("IOTest/task2-3.txt"));
            ali.add(new FileInputStream("IOTest/task2-4.txt"));
            ali.add(new FileInputStream("IOTest/task2-5.txt"));

            SequenceInputStream in = new SequenceInputStream(Collections.enumeration(ali));

            while((x = in.read()) != -1){
                writer.write(x);
            }

            writer.close();
            in.close();
    }
}
