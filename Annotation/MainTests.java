package Java_Prof_Level.Lesson_7.Annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainTests {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        start(ClassForTests.class);
    }


    public static void start(Class testClass) throws InvocationTargetException, IllegalAccessException {
        int i = 0;
        int j = 0;

        ClassForTests cft = new ClassForTests();
        Method[] methods = testClass.getDeclaredMethods();
        List<Method> list = new ArrayList<>();

        for (Method m: methods) {
            if (m.isAnnotationPresent(Test.class)) {
                list.add(m);
            }
        }

        list.sort(new Comparator<Method>() {
            @Override
            public int compare(Method m1, Method m2) {
                return m1.getAnnotation(Test.class).priority() - m2.getAnnotation(Test.class).priority();
            }
        });

        for(Method m: methods){
            if(m.isAnnotationPresent(BeforeSuite.class)){
                i++;
                try {
                    if(i > 1) throw new RuntimeException("Может быть только одна аннотация @BeforeSuite");
                    else list.add(0,m);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }

        for(Method m: methods){
            if(m.isAnnotationPresent(AfterSuite.class)){
                j++;
                try{
                    if (j > 1) throw new RuntimeException("Может быть только одна аннотация @AfterSuite");
                    else list.add(m);
                } catch (RuntimeException e){
                    e.printStackTrace();
                }
            }
        }

        for(Method m: list){
            m.invoke(cft);
        }
    }
}
