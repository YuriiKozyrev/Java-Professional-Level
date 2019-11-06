package Java_Prof_Level.Lesson_6;

public class ArrayCheck2 {

    public boolean arrayContains (int[] arraySource){
        for (int value : arraySource) {
            if (value == 1 | value == 4) return true;
        }
        return false;
    }
}
