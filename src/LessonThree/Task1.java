package LessonThree;
//Заполните массив на N элементов случайным целыми числами и выведете максимальное, минимальное и среднее значение

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {


        int max = 20;
        int[] ints1 = new int[random(max)];

        for (int i = 0; i < ints1.length; i++) {
            ints1[i] = random(max);
        }
        Arrays.sort(ints1);
        double arithmaticMean = 0.0;
        int intsMax = ints1[(ints1.length - 1)];
        int intsMin = ints1[0];
        for (int elem : ints1) {
            arithmaticMean += elem;
        }
        arithmaticMean /= ints1.length;
        System.out.println("Min = " + intsMin + ", Max = " + intsMax + ", среднее арифметическое = " + arithmaticMean);

    }

    static int random(int max) {
        return (int) (Math.random() * ++max);
    }
}
