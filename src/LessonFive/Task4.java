package LessonFive;
//Заменить все буквы в слове на строчные, а первую букву на заглавную
//Например, дано hello, получаем Hello / дано HeLLO, получаем Hello
public class Task4 {
    public static void main(String[] args) {
        String originalString = "hello";

        originalString = originalString.toLowerCase();
        char[] cahrArray = originalString.toCharArray();
        String finalString = (Character.toString(cahrArray[0])).toUpperCase();

        for (int i = 1; i < cahrArray.length; i++) {
            finalString += Character.toString(cahrArray[i]);
        }
        System.out.println(finalString);
    }
}
