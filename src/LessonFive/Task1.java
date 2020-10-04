package LessonFive;

import java.util.Arrays;
import java.util.Scanner;

/*
Заполнить массив
Задать массив на N слов.
В цикле считывать с консоли слова (scanner.nextLine()), и добавлять их в массив
(добавлять новое слово в массив можно только, если в нем его еще нет).
В итоге в массиве будут только уникальные слова.
Выход их программы по слову exit (его в массив не добавлять) или если массив заполнен
Перед завершением программы, вывести получившийся массив в консоль

 */
public class Task1 {
    public static void main(String[] args) {
        int min = 2;
        int max = 10;
        max -= min;
        int random = (int) (Math.random() * ++max) + min;
        String[] strings = new String[random];
        Scanner scanner = new Scanner(System.in);

        firstBlock:
        {
            for (int i = 0; i < strings.length; i++) {
                boolean flag = false;
                System.out.println("Введите слово");
                String word = (scanner.nextLine()).intern();

                if (word.equals("exit")) {
                    break firstBlock;
                } else {
                    for (int j = 0; j < strings.length; j++) {
                        if (word.equals(strings[j])) {
                            flag = false;
                            break;
                        } else {
                            flag = true;
                        }

                    }
                }
                if (flag) {
                    strings[i] = word;
                } else {
                    i--;
                }


            }

        }
        System.out.println(Arrays.toString(strings));
    }
}
