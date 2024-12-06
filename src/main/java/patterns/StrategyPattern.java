package patterns;

// Strategy Pattern - (Policy Pattern)

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

interface ISortStrategy {
    List<Integer> sort(List<Integer> data);
}

class AscendingSortStrategy implements ISortStrategy {
    @Override
    public List<Integer> sort(List<Integer> data) {
        return data.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }
}

class DescendingSortStrategy implements ISortStrategy {
    @Override
    public List<Integer> sort(List<Integer> data) {
        return data.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}

class CustomSortStrategy implements ISortStrategy {
    @Override
    public List<Integer> sort(List<Integer> data) {
        //sort by event first odd next
        return data.stream()
                .sorted((a, b) -> {
                    if (a % 2 == 0 && b % 2 != 0) return -1;
                    if (a % 2 != 0 && b % 2 == 0) return 1;
                    return a - b;
                })
                .collect(Collectors.toList());
    }
}

class Sorter{
    public ISortStrategy strategy;

    public Sorter(ISortStrategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(ISortStrategy strategy){
        this.strategy = strategy;
    }

    public List<Integer> sort(List<Integer> data){
        return strategy.sort(data);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 2, 9, 1, 8, 3, 4, 7, 6);

        System.out.println(new Sorter(new AscendingSortStrategy()).sort(list));
        System.out.println(new Sorter(new DescendingSortStrategy()).sort(list));
        System.out.println(new Sorter(new CustomSortStrategy()).sort(list));
    }
}
