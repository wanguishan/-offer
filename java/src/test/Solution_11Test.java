package test;

import main.Solution_11;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import test.cherkers.MinNumberInRotateArrayChecker;

import java.util.stream.Stream;

class Solution_11Test {

    static Stream<int[]> inputProvider() {
        int[] array1 = {1, 0, 1, 1, 1};
        int[] array2 = {3, 4, 5, 1, 2};
        int[] array3 = {0};
        return Stream.of(array1, array2, array3);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void minNumberInRotateArray(int[] argument) {
        MinNumberInRotateArrayChecker minNumberInRotateArrayChecker = new MinNumberInRotateArrayChecker();

        int output = minNumberInRotateArrayChecker.minNumber(argument);
        int actualOutput = Solution_11.minNumberInRotateArray(argument);
        Assert.assertEquals(output, actualOutput);
    }
}