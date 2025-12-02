package Concurrent;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAPI {

    public static void main(String[] args) {

        // Filter even numbers from the list
//        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
//
//        List<Integer> collect = nums.stream().filter((i) -> i % 2==0).collect(Collectors.toList());
////        System.out.println(collect);
//
//
//
////        Q: Convert all the strings in a list to uppercase.
//        List<String> names = Arrays.asList("tushar", "shubham", "amit");
////        names.stream().map((a)->a.toUpperCase()).forEach(System.out::println);
//
//
//
////        Count how many elements are greater than 10.
//        List<Integer> list = Arrays.asList(5,12,7,20,14);
//        long count = list.stream().filter(i -> i > 10).count();
////        System.out.println(count);
//
//
//
////        Q: From a list of strings, find the first string that starts with “A”.
//        List<String> cities = Arrays.asList("Delhi","Agra","Mumbai","Aurangabad");
//
////        cities.stream().filter((i)->i.startsWith("A")).forEach(System.out::println);
//
//
////        Q: Sort a given list of integers in ascending order.
//        List<Integer> nums1 = Arrays.asList(5,1,9,3,7);
////        nums1.stream().sorted().forEach(System.out::println);
//
//
////        Q: Remove duplicate values from a list using Streams.
//        List<Integer> num2 = Arrays.asList(1,2,2,3,3,4,5);
////        num2.stream().distinct().forEach(System.out::println);
//
//
////        Q: Convert each string into its length.
//        List<String> words = Arrays.asList("Java","Stream","API");
////        words.stream().map(i->i.length()).forEach(System.out::println);
//
////        Q: Check using Streams: Is there any negative number?
//        List<Integer> nums3 = Arrays.asList(3,5,-7,4);
////        nums3.stream().filter(i->i<0).forEach(System.out::println);
//
////        Find the sum of all integers using Streams.
//        List<Integer> nums4 = Arrays.asList(1,2,3,4,5);
//        int sum = nums4.stream().mapToInt(i -> i.intValue()).sum();
////        System.out.println(sum);
//
//
////        : Convert a list of strings into a set using Streams.
//        List<String> names1 = Arrays.asList("a","b","a","c");
//        Set<String> collect1 = names1.stream().collect(Collectors.toSet());
////        System.out.println(collect1);
//
//
//        // Intermediate
//
//
////        Find the Second Highest Number
//
//        List<Integer> num = Arrays.asList(10, 20, 30, 40, 50);
//        Integer i = num.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElseThrow();
////        System.out.println(i);
//
//
////        Group Words by Their Length
//
//        List<String> word = Arrays.asList("java", "stream", "api", "code");
//        Map<Integer,List<String>> collect2 = word.stream().collect(Collectors.groupingBy(String::length));
////        System.out.println(collect2);
//
//
//
////        Count Occurrences of Each Word
//
//        List<String> name = Arrays.asList("aa","bb","aa","cc","bb","aa");
//        Map<String, Long> occurence = name.stream().collect(Collectors.groupingBy(s->s,Collectors.counting()));
////        System.out.println(occurence);
//
//
//
////        Q: Sort employees by salary in descending order using Streams.
//        List<Emp> list1 = Arrays.asList(new Emp("Tushar",100000),new Emp("Neeraj",15000));
//
//        List<Emp> collect3 = list1.stream().sorted((Comparator.comparingInt(Emp::getSalary).reversed())).collect(Collectors.toList());
////        System.out.println(collect3.get(0).getName());
//
//
//
////        Flatten it → [1,2,3,4] using flatMap.
//
//        List<List<Integer>> list2 = Arrays.asList(List.of(1,2), List.of(3,4));
////        list2.stream().flatMap(lisyt->lisyt.stream()).collect(Collectors.toList()).forEach(System.out::println);
//
////        Q: Output duplicates → 2,3.
//        List<Integer> findDuplicated = Arrays.asList(1,2,3,2,4,3,5);
//        Set<Integer> collect4 = findDuplicated.stream().filter(n -> Collections.frequency(findDuplicated, n) > 1).collect(Collectors.toSet());
////        System.out.println(collect4);
//
//
////        Sum of Salaries of Employees Having Salary > 50000
////
////        Use Streams filter, map, and reduce.
//
//
//        Integer collect5 = list1.stream().filter(a -> a.getSalary() > 50000).map(a->a.getSalary()).reduce(0,Integer::sum);
////        System.out.println(collect5);
//
//
//
////        Partition a List into Even and Odd**
//
//                List<Integer> num5 = Arrays.asList(1,2,3,4,5,6);
//        Map<Boolean, List<Integer>> collect6 = num5.stream().collect(Collectors.partitioningBy(i1 -> i1 % 2 == 0));
////        System.out.println(collect6);

        List<Emp> list1 = Arrays.asList(new Emp("Tushar",100000),new Emp("Neeraj",15000));
//
//        List<Emp> collect = list1.stream().sorted(Comparator.comparingInt(Emp::getSalary).reversed()).collect(Collectors.toList());
//
//        for(Emp e: collect){
//            System.out.println(e.getSalary());
//        }

//        Emp emp = list1.stream().sorted(Comparator.comparingInt(Emp::getSalary).reversed()).findFirst().orElseThrow();
//        System.out.println(emp.getSalary());

//        OptionalDouble sum = list1.stream().mapToInt(Emp::getSalary).average();
//        System.out.println(sum);



//        List<String> names = Arrays.asList("Tatta", "Sheru", "Amit");
//
//        String string = names.stream().collect(Collectors.joining(","));
//        System.out.println(string);



        String s = "banana";
        Stream<Character> characterStream = s.chars().mapToObj(c -> (char) c);

        Map<Character, Long> collect = characterStream.collect(Collectors.groupingBy(z -> z, Collectors.counting()));
        System.out.println(collect);


//        List<Integer> list = Arrays.asList(10, 20, 1, 12, 31, 14);
//        list.stream().map(i->i.toString()).filter(i->i.startsWith("1")).collect(Collectors.toList()).forEach(System.out::println);

    }

}


class Emp {
    String name;
    int salary;

    public Emp(String name ,int salary){
        this.name = name;
        this.salary=salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

