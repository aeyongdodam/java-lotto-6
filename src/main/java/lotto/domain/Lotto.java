package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = sortNumbers(numbers);
        this.numbers = numbers;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getCorrectNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
    
    public List<Integer> getCurrentNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean isExist(int number) {
        return numbers.contains(number);
    }


}
