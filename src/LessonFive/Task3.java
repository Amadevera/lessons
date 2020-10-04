package LessonFive;

import java.sql.SQLOutput;
import java.util.Arrays;

/*
Написать функцию, которая проверяет, является ли строка палиндромом.
Палиндром — это число, буквосочетание, слово или текст,
которые одинаково читаются по буквам или по словам как слева направо, так и справа налево.
Например, 202 - палиндром / fafaf - палиндром / а роза упала на лапу Азора - палиндром
 */
public class Task3 {
    public static void main(String[] args) {
        String palindrome = "Лев осовел";
        String palindromeWithoutSpace = palindrome.replace(" ", "");
        String reversedString = reverseString(palindromeWithoutSpace);
        System.out.println(palindrome + " палиндром? " + palindromeWithoutSpace.equalsIgnoreCase(reversedString));
    }
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}



//
//        String palindrome = "Лев осовелk";
//        String[] dividedPalindrome;
//        String palindrome2;
//        String palindromeWithoutSpace = palindrome.replace(" ", "");
//        boolean flag = false;
//
//        while (!flag) {
//            char randomChar = (char) ((int) (Math.random() * ++max) + min);
//            String randomSplit = Character.toString(randomChar);
//
////            if (!palindromeWithoutSpace.contains(randomSplit)) {
//
//                dividedPalindrome = palindromeWithoutSpace.split(randomSplit);
////            System.out.println(Arrays.toString(dividedPalindrome));
//                palindrome2 = dividedPalindrome[(dividedPalindrome.length - 1)];
//            System.out.println(dividedPalindrome[1]);
//                for (int i = (dividedPalindrome.length - 2); i >= 0; i--) {
//                    palindrome2 += dividedPalindrome[i];
//                }
//                System.out.println(palindrome + " + " + palindrome2 + " + " + palindromeWithoutSpace);
//                System.out.println(palindrome + " палиндром? " + palindromeWithoutSpace.equalsIgnoreCase(palindrome2));
//                flag = true;
////            } else {
////                break;
//            }
//
//        }
//    }
