package org.example.corejava;

import java.util.HashMap;
import java.util.Map;

public class FractionToString {
    public static void main(String[] args) {
        System.out.println(fractionToString(1, 2));
        System.out.println(fractionToString(1, -2));
        System.out.println(fractionToString(50, 22));
    }

    public static String fractionToString(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();


        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);


        result.append(num / denom);
        num %= denom;

        if (num == 0) return result.toString();

        result.append(".");


        Map<Long, Integer> map = new HashMap<>();
        map.put(num, result.length());

        while (num != 0) {
            num *= 10;
            result.append(num / denom);
            num %= denom;


            if (map.containsKey(num)) {
                int index = map.get(num);
                result.insert(index, "(");
                result.append(")");
                return result.toString();
            }

            map.put(num, result.length());
        }

        return result.toString();
    }
}
