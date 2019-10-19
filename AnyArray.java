package Java_Prof_Level.Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnyArray<T> {
    private T[] array;

    public AnyArray(T[] array){
        this.array = array;
    }

    public void showArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " , ");
        }
    }

    public void changeElementsArray(int firstChangeNumber, int secondChangeNumber){
        T buffer;
        buffer = array[firstChangeNumber];
        array[firstChangeNumber] = array[secondChangeNumber];
        array[secondChangeNumber] = buffer;
        showArray();
    }

    public void transformationToArrayList(){
        List<T> destinationArrayList = new ArrayList<>(Arrays.asList(array));
        System.out.println("Получившийся ArrayList: " + destinationArrayList);
    }
}

class Task1{
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Double[] dblArray = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0};
        String[] strArray = {"a", "b", "c", "d", "e", "f", "g", "h"};

        AnyArray<Integer> integerArray = new AnyArray<>(intArray);
        AnyArray<Double> doubleArray = new AnyArray<>(dblArray);
        AnyArray<String> stringArray = new AnyArray<>(strArray);

//        integerArray.showArray();
        doubleArray.showArray();

        doubleArray.changeElementsArray(0,1);
//        stringArray.changeElementsArray(0,5);

        doubleArray.transformationToArrayList();
    }
}
