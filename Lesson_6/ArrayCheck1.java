package Java_Prof_Level.Lesson_6;

public class ArrayCheck1 {

    public  int[] arrayAfterLastFour (int[] arraySource){
        int lastFourNumber = 0;
        int[] arrayForReturn = new int[0];

        for (int i = 0; i < arraySource.length; i++) {
            if(arraySource[i] == 4) {
                lastFourNumber = i;
            }
        }

        try{
            if(lastFourNumber == 0) {
                throw new RuntimeException("Массив не содержит числа 4");
            }
            else{
                arrayForReturn = new int[arraySource.length - lastFourNumber - 1];
                System.arraycopy(arraySource, (lastFourNumber + 1), arrayForReturn,  0, arrayForReturn.length);
            }

        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }

        return arrayForReturn;
    }
}
