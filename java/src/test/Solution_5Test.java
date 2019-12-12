package test;

import main.Solution_5;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Solution_5Test {

    @Test
    void replaceSpace() {
        String str = "I am Wan Guishan!";
        String obj1 = "I%20am%20Wan%20Guishan!";
        String obj2 = Solution_5.replaceSpace(new StringBuffer(str));

        System.out.printf("before: %s\n", str);
        System.out.printf("after: %s", obj2);
        Assert.assertEquals(obj1, obj2);
    }
}