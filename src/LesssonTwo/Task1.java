package LesssonTwo;

import java.util.Scanner;

/*  Задание 1
Пользователь! загадывает число в диапазоне от [1 до 100], программа пытается его угадать
(используйте метод бинарного поиска - деление отрезка на 2).
Программа может задавать пользователю вопросы:
Число равно X? / Число больше X? / Число меньше X? и в зависимоти от ответа пользователя принимать решения.
PS: вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА
*/

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int usersNumber = 0;
        int usersAnswer;
        int crosspoint = 100;
        int crosspoint2 = 50;
        int crosspoint3 = 50;
        int crosspoint4 = 50;
        int interval = 50;

        System.out.println("Пожалуйста, загадайте целое число в интервале от 1 до 100");
        System.out.println("Число больше или равно " + crosspoint2 + "? Для ответа, пожалуйста, используйте числа: 0 - НЕТ и 1 - ДА");
        usersAnswer = scanner.nextInt();

        while (usersNumber != 1) {
            while (interval > 1 ) {
                if (usersAnswer == 0) {
                    if (crosspoint > crosspoint2) {
                        crosspoint3 = (crosspoint - crosspoint2) / 2;
                        crosspoint4 = crosspoint2 - crosspoint3;
                    } else if (crosspoint < crosspoint2) {
                        crosspoint3 = (crosspoint2 - crosspoint) / 2;
                        crosspoint4 = crosspoint2 - crosspoint3;
                    }
                } else if (usersAnswer == 1) {
                    if (crosspoint > crosspoint2) {
                        crosspoint3 = (crosspoint - crosspoint2) / 2;
                        crosspoint4 = crosspoint2 + crosspoint3;
                    } else if (crosspoint < crosspoint2) {
                        crosspoint3 = (crosspoint2 - crosspoint) / 2;
                        crosspoint4 = crosspoint2 + crosspoint3;
                    }
                }
                interval = crosspoint3;
                crosspoint = crosspoint2;
                crosspoint2 = crosspoint4;
                System.out.println("Число больше или равно " + crosspoint4 + "? Для ответа, пожалуйста, используйте числа: 0 - НЕТ и 1 - ДА");
                usersAnswer = scanner.nextInt();
            }
            if (usersAnswer == 0) {
                System.out.println("Число равно " + (--crosspoint4) + "? Для ответа, пожалуйста, используйте числа: 0 - НЕТ и 1 - ДА");
                usersNumber = scanner.nextInt();
            } else if (usersAnswer == 1) {
                System.out.println("Число равно " + (crosspoint4++) + "? Для ответа, пожалуйста, используйте числа: 0 - НЕТ и 1 - ДА");
                usersNumber = scanner.nextInt();
            }
        }
        System.out.println("Число угадано!");
    }
}