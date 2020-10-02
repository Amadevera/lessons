package LessonThree;

//Создайте массив из чётных чисел [2;20] и выведите элементы массива в консоль в обратном порядке (20 18 16 ... 4 2)
public class Task2 {
    public static void main(String[] args) {

        int[] ints2 = new int[10];
        for (int i = 0; i < ints2.length; i++) {
            if (i != 0) {
                ints2[i] = (ints2[i - 1] + 2);
            } else {
                ints2[i] = 2;
            }
        }
        for (int i = (ints2.length - 1); i >= 0; i--) {
            System.out.println(ints2[i]);
        }
    }
}
