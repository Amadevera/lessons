package LesssonTwo;

public class Task4 {
    public static void main(String[] args) {
/* Задание 4
Написать код, который будет проверять попало ли случайно сгенерированное целое число из отрезка [10;500] в интервал (25;200) и выводить результат в консоль.
Примеры работы программы:
Число 345 не содержится в интервале (25;200)
Число 110 содержится в интервале (25;200)
*/
        int min = 10;
        int max = 500;

        max -= min;
        int random = (int) (Math.random() * ++max) + min;
        if (random > 25 && random < 200){
            System.out.println("Число " + random + " содержится в интервале (25;200)");
        }else{
            System.out.println("Число " + random + " не содержится в интервале (25;200)");
        }
    }
}
//    public static int rnd(int min, int max)
//    {
//        max -= min;
//        return (int) (Math.random() * ++max) + min;
//    }


