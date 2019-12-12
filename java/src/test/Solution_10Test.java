package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import test.cherkers.FibonacciChecker;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class Solution_10Test {

    private int input;
    private int output;

    public Solution_10Test(int input, int output) {
        this.input = input;
        this.output = output;
    }

    @Parameters
    public static Collection date() {
        Object[][] data = {
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3},
                {5, 5},
                {6, 8},
        };
        return Arrays.asList(data);
    }

    @Test
    public void fibonacci_1() {
        System.out.println("input: " + input + "; output: " + output);
        FibonacciChecker fibonacciChecker = new FibonacciChecker();
        int actualOutput = fibonacciChecker.Fabonacci(input);
        Assert.assertEquals(output, actualOutput);
    }

    @Test
    public void fibonacci_2() {
        FibonacciChecker fibonacciChecker = new FibonacciChecker();
        int actualOutput = fibonacciChecker.Fabonacci(input);
        Assert.assertEquals(output, actualOutput);
    }

}