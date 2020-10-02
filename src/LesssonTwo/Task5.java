package LesssonTwo;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
/* Задание 5
Задача на синтаксис switch. Дана целочисленная переменная (номер билета от пользователя):
если ее значение 111, 222 или 333 сообщить пользователю, что он получит "Книгу",
если ее значение 444 или 555 сообщить пользователю, что он получит "Телефон",
если ее значение 777 сообщить пользователю, что он получит "Ноутбук".
В остальных случаях сообщить, что приза нет.
*/
        System.out.println("Введите номер билета");
        Scanner scanner = new Scanner(System.in);
        int ticket = scanner.nextInt();

        switch (ticket){
            case 111:
            case 222:
            case 333:
                System.out.println("Вы получаете книгу!");
                break;

            case 444:
            case 555:
                System.out.println("Вы получаете телефон!");
                break;

            case 777:
                System.out.println("Вы получаете ноутбук!");
                break;

            default:
                System.out.println("Приза не будет");
                break;
        }
    }
}
