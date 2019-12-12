package test;

import main.Solution_3;
import org.junit.Assert;
import org.junit.Test;

public class Solution_3Test {

    @Test()
    public void duplicate() {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int length = numbers.length;
        int[] duplication = new int[length];

        boolean res = Solution_3.duplicate(numbers, length, duplication);
        System.out.println(res);
        Assert.assertTrue(res);
    }
}