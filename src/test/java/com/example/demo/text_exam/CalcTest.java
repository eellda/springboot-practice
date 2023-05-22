package com.example.demo.text_exam;

import com.example.demo.test_exam.Calc;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CalcTest {
    private Calc calc = new Calc();

    @Test
    void addTest() {
        int actual = calc.add(1, 2);
        int expected = 3;

        assertThat(actual, is(expected)); // 실제값과 기댓값 비교
    }

    @Test
    void multipleTest() {
        int actual = calc.multiple(1, 2);
        int expected = 2;

        assertThat(actual, is(expected));
    }
}
