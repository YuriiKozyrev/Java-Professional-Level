package Java_Prof_Level.Lesson_1.BigTask;


public class Main {
    public static void main(String[] args) {

        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();

        box1.putFruitInToTheBox(new Apple());
        box1.putFruitInToTheBox(new Apple());
        box1.putFruitInToTheBox(new Apple());
//        box1.putFruitInToTheBox(new Apple());
//        box1.putFruitInToTheBox(new Orange());

        box2.putFruitInToTheBox(new Orange());
        box2.putFruitInToTheBox(new Orange());

        System.out.println(box1.getBoxWeight());
        System.out.println(box2.getBoxWeight());

        System.out.println(box1.compareBoxes(box2));
    }
}



