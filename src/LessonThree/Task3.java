package LessonThree;

public class Task3 {
    /*Создайте массив из 11 случайных целых чисел из отрезка [-1;1], выведите массив в консоль.
    Определите какой элемент встречается в массиве чаще всего и выведите информацию об этом в консоль.
    Если два каких-то элемента встречаются одинаковое количество раз, то не выводите ничего.
    */
    public static void main(String[] args) {


        int maximum = 2;
        int[] ints3 = new int[11];
        int minusOne = 0;
        int zero = 0;
        int one = 0;
        for (int i = 0; i < ints3.length; i++) {
            ints3[i] = random(maximum);
            if (ints3[i] == -1) {
                minusOne++;
            } else if (ints3[i] == 0) {
                zero++;
            } else if (ints3[i] == 1) {
                one++;
            }
            System.out.println("result " + ints3[i]);
        }

        if (minusOne > zero && minusOne > one) {
            System.out.println("Чаще всего встречается -1");
        } else if (zero > minusOne && zero > one) {
            System.out.println("Чаще всего встречается 0");
        } else if (one > minusOne && one > zero) {
            System.out.println("Чаще всего встречается 1");
        } else {
        }
    }

    static int random(int max) {
        return (int) (Math.random() * ++max) - 1;
    }

}






