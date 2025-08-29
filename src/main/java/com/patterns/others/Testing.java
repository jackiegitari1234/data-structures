//package com.patterns.others;
//
//import java.util.function.Predicate;
//import java.util.stream.Stream;
//
//public class Testing {
//
//    record DistinctByLength(String str) {
//
//        @Override
//        public boolean equals(Object obj) {
//            return obj instanceof DistinctByLength(String other)
//                && str.length() == other.length();
//        }
//
//
//        @Override
//        public int hashCode() {
//            return str == null ? 0 : Integer.hashCode(str.length());
//        }
//
//    }
//
//    public static void main(String[] args) {
//
//
//        var result = Stream.of("foo", "bar", "baz", "quux")
//            .map(DistinctByLength::new)
//            .distinct()
//            .map(DistinctByLength::str)
//            .toList();
//
//
//
//        long numberOfWords =
//            Stream.of("the", "", "fox", "jumps", "over", "the", "", "dog")  // (1)
//                .filter(Predicate.not(String::isEmpty))
//                .count();
//        System.out.println(numberOfWords); // Output: 4
//    }
//}
