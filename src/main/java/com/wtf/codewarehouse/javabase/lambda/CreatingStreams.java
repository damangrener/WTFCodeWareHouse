package com.wtf.codewarehouse.javabase.lambda;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatingStreams {

    public static <T> void show(String title, Stream<T> stream){
        final int SIZE=10;
        List<T> firstElements=stream.limit(SIZE+1).collect(Collectors.toList());
        System.out.println(title+": ");
        for (int i = 0; i <firstElements.size() ; i++) {
            if(i>0) System.out.println(", ");
            if(i<SIZE) System.out.println(firstElements.get(i));
            else System.out.println("...");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String contents="aeck,jdcj,nrec,iazzv,b";

        Stream<String> words=Stream.of(contents.split(","));
        show("words",words);

        //产生一个元素为给定值的流
        Stream<String> song=Stream.of("12","aaa","bbb");
        show("song",song);

        //产生一个空流
        Stream<String> silence=Stream.empty();
        show("silence",silence);

        //产生一个无限流
        Stream<String> echos=Stream.generate(()->"Echo");
        show("echos",echos);

        Stream<Double> randoms=Stream.generate(Math::random);
        show("randoms",randoms);

        Stream<BigInteger> integers=Stream.iterate(BigInteger.ONE,n->n.add(BigInteger.ONE));
        show("integers",integers);
    }

}
