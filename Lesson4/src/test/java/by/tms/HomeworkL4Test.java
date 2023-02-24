package by.tms;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HomeworkL4Test {

    @Test
    void getAlphabetTest() {
        Assertions.assertEquals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, " +
                                        "O, P, Q, R, S, T, U, V, W, X, Y, Z]", HomeworkL4.getAlphabet());
    }

    @Test
    void isAgreeTest() {
        Assertions.assertTrue(HomeworkL4.isAgree("Y"));
        Assertions.assertTrue(HomeworkL4.isAgree("y"));
        Assertions.assertFalse(HomeworkL4.isAgree("n"));
        Assertions.assertFalse(HomeworkL4.isAgree(""));
    }

    @Test
    void getMinValueTest() {
        List<Double> test1 = new ArrayList<>(List.of(2.0, 3.0, 5.2));
        Assertions.assertEquals(2.0, HomeworkL4.getMinValue(test1), 0.0);
        List<Double> test2 = new ArrayList<>(List.of(3.0, 1.0, 5.2));
        Assertions.assertEquals(1.0, HomeworkL4.getMinValue(test2), 0.0);
        Assertions.assertThrows(NullPointerException.class, () -> HomeworkL4.getMinValue(null));
    }

    @Test
    void getAlphabetSecondTest() {
        Assertions.assertEquals("[A, B, C, D, E, F, G, H, I, J, K, L, M," +
                                        " N, O, P, Q, R, S, T, U, V, W, X, Y, Z]", HomeworkL4.getAlphabet());
    }

    @Test
    void getAlphabetThird() {
        Assertions.assertEquals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N," +
                                        " O, P, Q, R, S, T, U, V, W, X, Y, Z]", HomeworkL4.getAlphabet());
    }
}