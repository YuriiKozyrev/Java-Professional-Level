package Java_Prof_Level.Lesson_3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) throws IOException {

        int pageVolume = 1800;

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер требуемой страницы: ");
        int pageNumber = sc.nextInt();

        byte[] arr = new byte[pageVolume];

        RandomAccessFile raf = new RandomAccessFile(("IOTest/task3.txt"), "r");

        raf.seek((pageNumber - 1) * pageVolume);
        raf.read(arr);
        System.out.println(new String(arr));

        raf.close();
        sc.close();
    }
}