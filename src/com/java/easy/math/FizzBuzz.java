//Write a program that outputs the string representation of numbers from 1 to n.
//
//        But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
//
//        Example:
//
//        n = 15,
//
//        Return:
//        [
//        "1",
//        "2",
//        "Fizz",
//        "4",
//        "Buzz",
//        "Fizz",
//        "7",
//        "8",
//        "Fizz",
//        "Buzz",
//        "11",
//        "Fizz",
//        "13",
//        "14",
//        "FizzBuzz"
//        ]

package com.java.easy.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FizzBuzz {

    public FizzBuzz(){}

    public List<String> fizzBuzz(int n) {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>(){
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };

        List<String> result = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            String str = "";

            for(Integer key: hashMap.keySet()){
                if (i % key == 0) {
                    str += hashMap.get(key);
                }
            }

            if(str.isEmpty()){
                str += Integer.toString(i);
            }

            result.add(str);
        }
        return  result;
    }
}
