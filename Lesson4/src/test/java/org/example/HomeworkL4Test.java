package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HomeworkL4Test {

    @Test
    void getAlphabetTest() {
        Assertions.assertEquals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]", HomeworkL4.getAlphabet());
    }


}