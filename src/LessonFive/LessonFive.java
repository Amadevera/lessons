package LessonFive;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Objects;

public class LessonFive {
    public static void main(String[] args) {
/*      //char 1 16битный символ из unicode escape последовательность 16ричная система
        //от 0 до 65536 /от '\u0000' до '\uffff'
        //у символа есть номер и 16ричное представление в эскейп последовательности, к нему добавляем "\" и  "u"
        //можно задать */
        char char1 = 'J'; //символ
        char char2 = 74; //номер в таблице unicode
        //       char char3 = '\u0044'; //это всё один символ J в разныъ формах записи 16ричная эскейп последовательность
//        System.out.println(char1 + char2 + char3);
        // при мат операциях будут вести себя как инты вне зависимости от того, как мы чар записали
        System.out.println("\nСтроки"); // \n - перенос строки
        //строка - упорядоченная последоватедбность символов.
        // Объекты (ссылочный тип) класса String
        // можем задавать в двойных кавычках - предпочтительнее
        // или используя конструктор new String() - но этот способ крайне не желателен, он на крайний случай

        //строки уже созданные нельзя изменить, можно только создать новую на основе существующей,
        // но исходная строка останется неизменной в изначальном виде.
        // если речь о переводе строки в верхний регист или замене символа - на самом деле это создание новой строки на основе старой,
        // но старая останется неизменной
        //все строковые литералы, например System.out.println("Строки"); - это создание новой строки,
        // экземпляра String. потом объект просто уходит к сборщику мусора
        char[] jjdChars = {'\u004A', '\u004A', '\u0044'}; //создание через массив char
        String jjdString = new String(jjdChars);
        jjdString = "\u004A\u004A\u0044";
        System.out.println(jjdString); //строка из 3 сиволов, длина строки 3
        System.out.println(jjdString.length());

        char[] frogChars = {'\uD83D', '\uDC38'};//строку можно разобрать на символы или найти номер символа в строке, узнать его позицию
        String frogString = new String(frogChars); //символ в консоли 1, а чара два, элемента строки 2.
// Это значит, что один символ не вмещается в 16 бит и создаёт пару. 1 символ юникода может быть сформирован
// как 1 чаром, так и двумя (если не влез в 16 бит, тогда символ юникода представлен парой чаров
        frogString = "\uD83D\uDC38";
        System.out.println(frogString); //один символ из двух чаров
        System.out.println(frogString.length()); // 2
        System.out.println(frogString.codePoints().count()); //1 - этот метод корректно отобразит, что символ на самм деле 1

        //хранение строк до java 9(исключительно): миссив char[] в кодировке UTF-16
        //строка была представлена, как массив чаров. 1 чар был представлен 2 байтами
        //хранение строк начиная с java 9(включительно): компактные строки - массив byte[] + кодировка UTF-16 или LATIN1
        //теперь все строки внутри хранятся как массив байт
        //если символ должен занимать 2 байта, то UTF-16, а если нужно меньше, то LATIN1
        //String объявляем и кликаем правой кнопкой на стринг - можем почитать про
        //если мы строку разбираем на массив байтов, то дина строки будет равна дине массива, а если в UTF-16,
        // то будет разница - массив будет больше, чем длина строки в 2 раза
        //LATIN1 - для латиницы, UTF-16 для кириллицы, например, 2 байта.
        // иероглифы могут занимать больше (см выше про два чара на 1 символ)
        System.out.println("Пул строк");
        //пул строк находится в heap памяти.
        //пул строк - место где хранятся строки, они лежат отдельно от всего
        //он хранит только одну копию каждого строкового литерала - по одной копии каждой строки
        String string1 = "Строка"; //объявили ссылочную переменную типа стринг (объект) и присвоили ей значение "Строка"
        String string2 = "Строка"; //объявили ссылочную переменную типа стринг (объект) и присвоили ей значение "Строка"
        // на 57 в пул строк попала Строка, на 58 идёт обращение в пул строк, если такой литерал уже есть,
        // то новый создаваться не будет
        //здесь переменные string1 и string2 ссылаются на один объект в памяти. вторая "Строка", создаваться не будет
        String string3 = new String("Строка"); //при таком объявлении строка создаётся как самостоятельный объект,
        // вне пула строк, хранится в зоне, где и все объекты. каждый раз при таком объявлении создаётся новая "Строка"
        // занимает доп память
        //ссылочные типы мы  не сравниваем чере ==
        System.out.println(string1 == string2); //просто проверяем ссылки, ведут ли они на один объект. здесь - да.  true
        System.out.println(string1 == string3); //false - string3 ссылается на другой объект в памяти,
        // хоть он и выглядит так же. ссылкине равны
        //помещение строки в пул строк - интернирование
        System.out.println("Метод intern()");
        String internStr = string3.intern(); //метод взял объект, сравнил его с пулом строк, если находит там такой,
        // то вернёт ссылку на него (присвоит)
        System.out.println(string1 == internStr); //true если объекта ещё нет в пуле - добавит его в пул строк
        // и присвоит ссылку на него из пула, но объект вне пула не исчезнет никуда, так и будет занимать память
        System.out.println(string2 == internStr);//true
        System.out.println(string3 == internStr);//false
        /*при создании через  любой конструктор - создание вне пула строк (в куче - в heap), разные объекты каждый раз, даже если они одинаковые
        если чере "" то через пул строк
        интерн проверил объект, который его вызвал, пошёл в пул строк и поискал там идентичную объекту строку,
        если есть, то вернул ссылку на обхъект из пула строк, но объект вне пула не никуда не исчез при этом.
        если метод не нашёл в пуле идентичной строки, создал её в пуле и присвоил ссылку на него из пула
         */

        //Сравнение строк
        //метод equals();
        System.out.println("метод equals()");
        string1 = "Строка";
        string2 = "Строка";
        String string4 = new String("Строка");
        System.out.println(string1.equals(string4));
        System.out.println(string1.equals(string2));//true стравнивает объект. если объекты идентичны, вернёт true
        System.out.println("строка".equals(string1));//false так как учитывает ригистр. но вызов допустимый
        System.out.println(string1.equals(string3));//true
        System.out.println("строка".equalsIgnoreCase(string1));//true .equalsIgnoreCase() - игнорирует ригистр
        string1.equals("строка"); //допустимый вариант, но ХУЖЕ чем "строка".equals(string1).
        "строка".equals(string1);//лучше, но тоже не фонтан
        // но лучше избегать любого из таких вариантов и сохранять строку в нормально объявленную переменную.
        String nullString = null;
        System.out.println("строка".equals(string3));//false
        //       System.out.println(nullString.equals("строка"));// выдаст ошибку так как
        // метод пытается вызват "null", а у null нет метода equals,
        // ничего у null нет, никаких методов
        // а у null pointer Exception

        //с null можно испоьзовать класс Objects (вспомогательный класс для работы с объектами)
        //имеет методы для проверки на null

        //С null можно использовать:
        System.out.println(nullString == null); //true
        System.out.println(string1 != null); // только с null можно использовать == и != для сравнения с объектами
        System.out.println(null == null); //true
        System.out.println(Objects.nonNull(nullString));//false проверил переменную на не null,
        // вернёт true, если переменная не равна null
        System.out.println(Objects.isNull(nullString)); //true

        String[] animals = {"кот", "пёс", "гусь"};
        String[] animals2 = new String[animals.length * 2];
        int max = 2;
        for (int i = 0; i < animals2.length; i++) {

            animals2[i] = animals[(int) (Math.random() * animals.length)];
            System.out.println(animals2[i]);
        }
        System.out.println(Arrays.toString(animals2));
        //Соединение (конкатинация) строк. Вариант 1: +
        System.out.println(string1 + " " + string2); //на каждом + создаём новую, более полную строку

        // вариант 2: строка.concat( то, что присоединяем)
        String concatStr = (string1.concat(" ").concat(string2)); //каждый вызов concat создаёт новый объект в пуле строк

        //вариант 3: Sting.join(разделитель, строка1, строка2, сколько_хотим_строк);
        String newString = String.join(" ", string1, string2); //каждая строка - новый объект
        System.out.println(newString);
        //Буферизированные строки
        concatStr = " ";
        for (int i = 0; i < 10; i++) {//если конктинация строк происходит в цикле или
            concatStr += i + " "; // склейка большого кол-ва элемннтов нельзя пользоваться
            // ни одним из вариантов выше - слишком долго и ресурсоёмко
        }
        //StringBuilder и StringBuffer - делают одно и то же. их нужно исп в случаях выше - в циклах и при оч длинных склейках
        //StringBuilder - работает быстрее, но не является потокобезопасным - не используем в многопоточных средах
        //StringBuffer - работает медленнее, но потокобезопаснее
        StringBuilder sb = new StringBuilder(string1);
        //создаём экземпляр класса StringBuilder - создали объект типа StringBuilder
        sb.append(" :: ").append(string2); //и так сколько угодно строк. когда метод отработает,
        // он вернёт объект типа StringBuilder, а не строку
        //метод тоже создаёт новый объект, но обрубает все ссылки на старый объект
        concatStr = sb.toString(); //приводим к String
        System.out.println(concatStr); //метод System.out.println() внутри себя приводит к строке (неявно),
        // в этом случае можно не переводить до. не умеет только массивы приводить
            //Сравнение двух строк
        string1 = "Строка";
        string2 = "Строка";
        System.out.println();

        System.out.println(string1.compareTo(string2)); //0 - одинаковые
        // С == 1057, с == 1089
        System.out.println("строка".compareTo("Строка")); //32 - первое(вызывающее) больше поэтому положительное число.
        // сравнивает номера символов по таблице юникода и сравнивает их.
        // сами номера. результат - разница между первым и вторымрегистр важен
        System.out.println("Cтрока".compareTo("cтрока"));//-32 вызывающее меньше, поэтому отрицательное
        System.out.println("строка".compareToIgnoreCase("Строка")); //то же самое, но регистр не важен
//оба метода - посимвольное сравнение, находят первый мисматч и выдают его, прекращая на этом работу.

        //start / end
        string1 = "JJD";
        System.out.println(string1.startsWith("J")); //true передаём String, не char.
        //
        // Метод смотрит начинается ли вызывающая строка с указанного символа (в типе стринг). Регистр важен.
        //аналогичный метод проверяет заанчивается ли вызывающая строка указанным символом (в типе стринг). Регистр важен.
        System.out.println(string1.endsWith("J"));
        System.out.println(string1.startsWith("J", 2)); //метод перегружен.
        // можем передать номер символа с которого нужно начатьпроверку. по сути - является ли такой-то элемент таким-то символом
        //приведение к регистру
        string1 = string1.toLowerCase();//посимвольно меняет регистр всей строки и выдаёт
        // 1 новый объект (в пуле строк) - новую строку, убирая ссылки на старые
        string1 = string1.toUpperCase();//оба метода сами проверяют кодировку и то, составляют ли чары суррогатную пару.
        //нам об этом думать не надо. только строки, не чары

        //замена
        string1 = "JJD";
        string1 = string1.replace("J", "!"); //ищет в строке первый нужный элемент и заменяет его
        // не примнимает регулярное выражение, принимает только набор символов - строку
        System.out.println(string1);
        string1 = string1.replaceAll("J", "!");//принимает регулярное выражение и
        // заменяет по соответствию все указанные выражения на заданные
        System.out.println(string1);
        string1 = string1.replaceFirst("J", "!"); //принимает регулярное выражение,
        // находит первое соответствие и заменяет только его
        System.out.println(string1.contains("D"));//true/false - проверяет содержит ли строка указанный набор символов

        string1 = "Java Phyton";
       String[] srings = string1.split(" ");//принимает регулярное выражение (разделитель), идёт по массиву
        // по этому разделителю (в нашем случае это пробел), доходит до разделителя кидает элемент в массив,
        // идёт дальше до следующего разделителя.
        // и возвращает массив строк. В нашем примере будет массив с двумя элементами "Java", "Phyton"
        //разделитель вылетает, не помещается в элемент массива
        // Если не нашёл разделителя, то разобьёт посимвольно (каждый символ - отдельный элемент массива).
        System.out.println(Arrays.toString(srings));

        //убрать пробелы методы: trim / strip / stripLeading / stripTrailing
        //пробелы могут быть представлены разными символами из юникода,
        // в зав-ти от того, как выглядит пробел разные методы работают с ними поразному
        System.out.println("\u3000");// "  "
        System.out.println("\u0020");// " "
        //trim - убирает пространство, которое меньше или равно u0020 в таблице юникод. с первым пробелом не справится
        //strip - убирает любое пространство
        //stripLeading - убирает любое пространство в начале строки исключительно (отступ)
        //stripTrailing - убирает любое пространство в конце строки. не прокатит в строке с переносами

        //форматированные строки - ресурсоёмкая хрень. не стоит лишний раз использовать
        //System.out.printf("строка ", 1.14) - принимает 2 аргумента. второй аргумент добавится вместо первого
    }
}
//читать про регулярные выражения
//задачки выложить на гитхаб в свой(!) репозиторий, не в общий

//найти вхождение одной строки в другую - сколько раз одна строка встречается в другой "кот" "кот котик котофей" // 3 раза
//полиндром - решать как хотим. регистр не учитываем (приводим к ловер кейс.
//строку берём из консоли для задачки про первую заглавную букву, остальные - строчные

//задача про массивы - используем только массивы