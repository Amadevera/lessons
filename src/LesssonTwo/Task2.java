package LesssonTwo;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
//Задание 2
//Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8 16 32 64 128 ….
        int count = 0;
        int sequence = 1;
        while (count < 20) {
            sequence = sequence * 2;
            System.out.println(sequence);
            count++;
        }



    }

}
