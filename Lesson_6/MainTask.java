package Java_Prof_Level.Lesson_6;

import java.util.Arrays;


public class MainTask {
    public static void main(String[] args) {

        int[] arraySource = {0,1,2,4,3,0,9,5,0};

        ArrayCheck1 arrayCheck1 = new ArrayCheck1();
        ArrayCheck2 arrayCheck2 = new ArrayCheck2();

        System.out.println("Исходный массив:" + Arrays.toString(arraySource));
        System.out.println("Получившийся массив: " + Arrays.toString(arrayCheck1.arrayAfterLastFour(arraySource)));

        System.out.println("Массив содержит 1 или 4: "+ arrayCheck2.arrayContains(arraySource));
    }


}
