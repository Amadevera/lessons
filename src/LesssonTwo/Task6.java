package LesssonTwo;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
/* Задание 6
Программа загадывает число в диапазоне [1;9]
Пользователь вводит число с клавиатуры
Программа в зависимости от введенного числа выводит в консоль следующее:
"загаданное число больше"
"загаданное число меньше"
"Вы угадали" (программа завершает работу)
если введен 0, выводит "выход из программы" (программа завершает работу)
*/

        int min = 1;
        int max = 9;

        max -= min;
        int random = (int) (Math.random() * ++max) + min;

        System.out.println("Введите целое число от 1 до 9");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        while (number != random)
        if (number == 0) {
            System.out.println("выход из программы");
            break;
        }else if (number < random){
            System.out.println("Загаданное число больше");
            System.out.println("Введите другое целое число от 1 до 9");
            number = scanner.nextInt();
        }else if (number > random){
            System.out.println("Загаданное число меньше");
            System.out.println("Введите другое целое число от 1 до 9");
            number = scanner.nextInt();
        }
        System.out.println("Вы угадали");
    }
}
//    public static int rnd(int min, int max)
//    {
//        max -= min;
//        return (int) (Math.random() * ++max) + min;
//    }

//подкорректировать