package day01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberSequenceTest {

    @Test
    void NumberSequenceConstrucor1Test() {
        NumberSequence numberSequence = new NumberSequence(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertEquals(5.5, numberSequence.getAverage());
        assertEquals(Arrays.asList(5,6), numberSequence.closeToAverage(1));
    }

    @Test
    void NumberSequenceConstrucor2Test() {
        NumberSequence numberSequence = new NumberSequence(10,1,10);
        assertEquals(getAverage(numberSequence.getNumbers()), numberSequence.getAverage());
        assertTrue(minValue(numberSequence.getNumbers(),1));
        assertTrue(maxValue(numberSequence.getNumbers(),10));
    }

    double getAverage(List<Integer> numbers) {
        double summa = 0;
        for (int number: numbers) {
            summa += number;
        }
        return  summa/ numbers.size();
    }

    boolean minValue(List<Integer> numbers, int minimum) {
        for (int number: numbers) {
            if (number < minimum){
                return false;
            }
        }
        return true;
    }

    boolean maxValue(List<Integer> numbers, int maximum) {
        for (int number: numbers) {
            if (number > maximum){
                return false;
            }
        }
        return true;
    }
}