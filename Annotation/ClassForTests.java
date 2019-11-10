package Java_Prof_Level.Lesson_7.Annotation;

public class ClassForTests {

    @Test(priority = 2)
    public void Method2(){
        System.out.println("Тестирование Method2");
    }

    @AfterSuite
    public void EndMethod(){
        System.out.println("Завершение тестирования");
    }

    @Test(priority = 3)
    public void Method3(){
        System.out.println("Тестирование Method3");
    }

    @BeforeSuite
    public void StartMethod(){
        System.out.println("Подготовка к тестированию");
    }

    @Test (priority = 1)
    public void Method1(){
        System.out.println("Тестирование Method1");
    }

//    @BeforeSuite
//    public void StartMethod2(){
//        System.out.println("Подготовка к тестированию2");
//    }

}
