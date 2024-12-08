package com.patterns.problems;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class ProblemsApplication {

    public static void main(String[] args) throws IOException {

//        SpringApplication.run(ProblemsApplication.class, args);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        System.out.println("return : " +testMethod(s));

    }

    public static String testMethod(String string) {

        List<String> nn = new ArrayList<>();
        nn.add("yy3");
        nn.add("yy2");
        nn.add("dd3");
        nn.add("dd");
        System.out.println("ff : " + nn);
        Collections.sort(nn);
        System.out.println("ff : " + nn);
        System.out.println("string : " + string);
        return string;
    }


    }
