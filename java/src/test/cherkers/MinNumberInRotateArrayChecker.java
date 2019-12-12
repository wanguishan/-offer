package test.cherkers;

import java.util.Arrays;

/**
 * @author wanguishan
 * @date 2019年12月12日13:19:23
 */
public class MinNumberInRotateArrayChecker {
    public int minNumber(int[] array) {
        return Arrays.stream(array).min().getAsInt();
    }
}
