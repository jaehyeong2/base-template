package jjfactory.template.sns.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CodeTest {

    @Test
    void enumTest(){
        List<Code> codeList = new LinkedList<>();
        Stream<Code> sorted = codeList.stream().sorted();
        System.out.println("sorted = " + sorted);

    }

    @Test
    void setAndList(){
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        list.add("hi1");
        list.add("hi2");

        set.add("hi1");
        set.add("hi2");

        Assertions.assertThat(list.size()).isEqualTo(set.size());
    }

}