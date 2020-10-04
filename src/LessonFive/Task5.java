package LessonFive;

import java.util.Arrays;

//Найдите самое длинное слово в предложении, при условии, что в предложении все слова разной длины
//Например, в "в предложении все слова разной длины" самое длинное слово "предложении"
public class Task5 {
    public static void main(String[] args) {
        String sentence = "в предложении  все слова разной длины";
        sentence = sentence.replace(",", "");
        sentence = sentence.replace(".", "");
        sentence = sentence.replace("?", "");
        sentence = sentence.replace("!", "");
        sentence = sentence.replace(":", "");

        String[] array = sentence.split(" ");
        int[] lengthArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            lengthArray[i] = array[i].length();
        }
        Arrays.sort(lengthArray);
        int max = lengthArray[lengthArray.length - 1];

        for (int i = 0; i < array.length; i++) {
            if (array[i].length() == max) {
                System.out.println("Самое длинное слово: " + array[i]);
            } //else {
           // }

        }
    }
}

/*        for (int i = 0; i < array.length; i++) {
            firstBlock: for (int j = 0; j < array.length; j++) {
                if (array[i].length() > array[j].length()) {
                    break;
                }else {
                    break firstBlock;
            }
        }
System.out.println(sentence.length());
*/

