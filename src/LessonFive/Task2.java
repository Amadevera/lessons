package LessonFive;

import java.util.Arrays;
import java.util.Scanner;

//Найти количество вхождений одной строки в другую.
//Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза
public class Task2 {
    public static void main(String[] args) {
        String firstString = "кот";
        String secondString = "котя, коток, котёнок, коткот";

        int result = secondString.length() - (secondString.replace(firstString, "").length());
        result = result / firstString.length();
        System.out.println(result);
    }
}
