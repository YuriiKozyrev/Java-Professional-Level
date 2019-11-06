package Java_Prof_Level.Lesson_6;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test1ArrayCheck {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {new int[] {1, 2, 3}, new int[] {1, 2, 3, 4, 5, 6, 4, 1, 2, 3}},
                {new int[] {1, 2, 3}, new int[] {1, 2, 3, 4, 5, 6, 4, 1, 2, 3}},
                {new int[] {1, 2, 3}, new int[] {1, 2, 3, 4, 5, 6, 4, 1, 2, 3}},
                {new int[] {1, 2, 3}, new int[] {1, 2, 3, 4, 5, 6, 4, 1, 2, 3}},
        });
    }

    private ArrayCheck1 arrayCheck1;
    private int [] result;
    private int [] inputArray;
    public Test1ArrayCheck(int[] result, int[] inputArray){
        this.result = result;
        this.inputArray = inputArray;
    }

    @Before
    public void init(){
        arrayCheck1 = new ArrayCheck1();
    }

    @Test
    public void testTest1ArrayCheck() {
        Assert.assertArrayEquals(result, arrayCheck1.arrayAfterLastFour(inputArray));
    }


}
