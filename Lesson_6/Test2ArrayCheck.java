package Java_Prof_Level.Lesson_6;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test2ArrayCheck {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {true, new int[] {1, 2, 3, 4, 5, 6, 4, 1, 2, 3}},
                {true, new int[] {1, 2, 3, 4}},
                {false, new int[] {0, 2, 3, 0}},
                {false, new int[] {0, 2, 3, 8, 5, 6, 9, 5, 2, 3}},
        });
    }

    ArrayCheck2 arrayCheck2;
    boolean result;
    int [] inputArray;
    public Test2ArrayCheck(boolean result, int[] inputArray){
        this.result = result;
        this.inputArray = inputArray;
    }

    @Before
    public void init(){
        arrayCheck2 = new ArrayCheck2();
    }

    @Test
    public void testTest2ArrayCheck() {
        Assert.assertEquals(result, arrayCheck2.arrayContains(inputArray));
    }

}
