package test;

import main.Solution_10;
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

    public Solution_10Test(int input) {
        this.input = input;
    }

    @Parameters
    public static Collection date() {
        Object[] data = {0, 1, 3, 6, 15, 39};
        return Arrays.asList(data);
    }

    @Test
    public void fibonacci_1() {
        FibonacciChecker fibonacciChecker = new FibonacciChecker();
        int output = fibonacciChecker.Fabonacci(input);
        int actualOutput = Solution_10.Fibonacci_1(input);
        System.out.println("input: " + input + ";\toutput: " + output + ";\tactualOutput: " + actualOutput);
        Assert.assertEquals(output, actualOutput);
    }

    @Test
    public void fibonacci_2() {
        FibonacciChecker fibonacciChecker = new FibonacciChecker();
        int output = fibonacciChecker.Fabonacci(input);
        int actualOutput = Solution_10.Fibonacci_2(input);
        Assert.assertEquals(output, actualOutput);
    }

}