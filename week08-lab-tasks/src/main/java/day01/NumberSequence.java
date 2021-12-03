package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSequence {
    private List<Integer> numbers;
    private double average;

    public NumberSequence(List<Integer> numbers) {
        this.numbers = numbers;
        countAverage();
    }

    public NumberSequence(int numberOfNumbers, int minimumValue, int maximumValue) {
        numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i< numberOfNumbers; i++) {
            numbers.add(random.nextInt(minimumValue, maximumValue));
        }
        countAverage();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public double getAverage() {
        return average;
    }

    private void countAverage() {
        int summa = 0;
        for (int number: numbers){
            summa += number;
        }
        average = (double)summa/numbers.size();
    }

    public List<Integer> closeToAverage(int value){
        List<Integer> result = new ArrayList<>();
        for (int number: numbers) {
            if (Math.abs(number-average) <= value){
                result.add(number);
            }
        }
        return result;
    }
}
