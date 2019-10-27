package Java_Prof_Level.Lesson_3;

import java.io.*;

public class Task5 {

    public static void main(String[] args) throws IOException {
        File f = new File("IOTest/task5.txt");
        FileReader fr = new FileReader(f);

        char[] arr = new char[(int)f.length()];
        fr.read(arr, 0, (int)f.length());

        StringBuilder sb = new StringBuilder();
        sb.append(arr);
        sb.reverse();
        System.out.print(sb);

        fr.close();

    }
}
