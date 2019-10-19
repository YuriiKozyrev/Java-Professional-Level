package Java_Prof_Level.Lesson_1.BigTask;
import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> boxList;

    public Box(){
        boxList = new ArrayList<T>();
    }

    public void putFruitInToTheBox(T fruit) {
        boxList.add(fruit);
    }

    public float getBoxWeight() {
        return boxList.get(0).getWeight() * boxList.size();
    }

    public boolean compareBoxes(Box boxForCompare){
        return Math.abs(this.getBoxWeight() - boxForCompare.getBoxWeight()) == 0;
    }
}