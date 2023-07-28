// Параллельные потоки. Parallel Stream

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5, 6);
        Optional<Integer> result = numbersStream.parallel().reduce((x, y)-> x*y);
        System.out.println(result.get()); // 720
        System.out.println();

        List<String> people = Arrays.asList("Tom","Bob", "Sam", "Kate", "Tim");

        System.out.println("Последовательный поток");
        people.stream().filter(p->p.length()==3).forEach(System.out::println);

        System.out.println("\nПараллельный поток");
        people.parallelStream().filter(p->p.length()==3).forEach(System.out::println);
        System.out.println();


        Stream<Integer> numbersStream2 = Stream.of(1, 2, 3, 4, 5, 6);
        Integer result2 = numbersStream2.parallel().reduce(1, (x,y)->x * y);
        System.out.println(result2); // 720
        System.out.println();


        List<String> people3 = Arrays.asList("Tom","Bob", "Sam", "Kate", "Tim");
        people3.parallelStream()
                .sorted()
                .forEachOrdered(s->System.out.println(s)); // упорядоченный, в алфавитном порядке
        System.out.println();


        List<String> people4 = Arrays.asList("Tom","Bob", "Sam", "Kate", "Tim");
        people4.parallelStream()
                .sorted()
                .unordered()
                .forEach(s->System.out.println(s)); // неупорядоченный
    }
}