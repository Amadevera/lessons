package LessonThree;

import java.util.Arrays;

public class Metods {
    public static void main(String[] args) {
        int[] ints1 = new int[]{-5, 80, 0, 200, 44};
        int[] ints2 = new int[]{5, 80, 0, 200, 44};
        int compare = Arrays.compare(ints1, ints2);
        int compareUn = Arrays.compareUnsigned(ints1, ints2);

        System.out.println(compare);
        System.out.println(compareUn);

//Returns: the value 0 if the first and second array are equal and contain the same elements in the same order;
// a value less than 0 if the first array is lexicographically less than the second array;
// and a value greater than 0 if the first array is lexicographically greater than the second array
    }
}

//что такое преффикс массива?! If the two arrays, over the specified ranges, share a common prefix

/*  Arrays.mismatch(a, b);
    int i = Arrays.mismatch(a, b); - Скажи мне, где вы расходитесь.

Сравнивает два массива по элементам от 0-го индекса (включительно) до первого несовпадения.
Или до конца длинны более короткого массива (включительно).
Возвращает индекс элемента на котором массивы расходятся. Или -1, если несовпадений не найдено.
Finds and returns the index of the first mismatch between two arrays, otherwise return -1 if no mismatch is found.
he index will be in the range of 0 (inclusive) up to the length (inclusive) of the smaller array.
*/
/*
        Arrays.compare(a, b);
        int compareResult = Arrays.compare(ints1, ints2);
*/

/*
        Arrays.compareUnsigned(a, b);
        int compareResult = Arrays.compareUnsigned(ints1, ints2);
Сравнивает лексикографически* два массива, обрабатывает элемнты как беззнаковые.
Если массивы равны, возвращает 0, если первый (из переданных массивов) меньше второго, вовращает -1,
если меньше второй, возвращает 1.
Значение null всегда рассматривается, как меньшее, чем  non-null.
Два массива со значениями элементов null будут равны.  (Two null array references are considered equal.)

if (a == null || b == null)
            return a == null ? -1 : 1;
public static int compareUnsigned(int[] a, int[] b) {
        if (a == b)
            return 0;
        if (a == null || b == null)
            return a == null ? -1 : 1;

        int i = ArraysSupport.mismatch(a, b,
                                       Math.min(a.length, b.length));
        if (i >= 0) {
            return Integer.compareUnsigned(a[i], b[i]);
        }

        return a.length - b.length;
    }

    *Лексикографическое сравнение - это сравнение "как в словаре" или "как в телефонном справочнике" - по алфавиту.
     Если первые буквы совпали, сравниваются вторые, если вторые совпали - третьи, и так далее.
        **Символ А предшествует символу В (А<В), если первые m символов слов совпадают,
          а m+1 символ слова А меньше (относительно заданного порядка, алфавитного, например) m+1 символа слова b,
          то оно считается предшевствующим. Если первые m символов слов совпадают, после чего слово a кончается,
          то оно также считается предшествующим b (т.е. отсутствующий символ меньше любого символа).
"abc" == "abc" //true
"123" == "123" //true
"123" < "124" //true
"0999999" < "123" //true
"123" < "3" //true
"12" < "123" //true
"123" < "1234" //true


 */

