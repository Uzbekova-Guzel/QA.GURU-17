package basicsjava;

public class DataTypes {

    public static void main(String[] args) {

        //ПРИМИТИВНЫЕ ТИПЫ ДАННЫХ В JAVA:
        //1) Целые числа - byte, short, int, long
        byte byteVar = 121; //8 бит, от -128 до 127
        short shortVar = 32134; //16 бит, от -32768 до 32767
        int intVar = 1212121; //32 бит, от -2147483648 до 2147483647
        long longVar = 12121212121L; //64 бит, от -9223372036854775808L до 9223372036854775807L
        //1.1) Символьный - char
        char charVar = 'e'; //16 бит, беззнаковое целое число, представляющее собой символ UTF-16 (буквы и цифры)
        //2) Числа с плавающей точкой (иначе вещественные) - float, double
        float floatVar = 2.1f; //32 бит, от 1.4e-45f до 3.4e+38f
        double doubleVar = 2.1; //64 бит, от 4.9e-324 до 1.7e+308
        //3) Логический - boolean
        boolean booleanVar = true;  //8(в массивах), 32(не в массивах используется int), true или false

        //МАТЕМАТИЧЕСКИЕ И ЛОГИЧЕСКИЕ ОПЕРАТОРЫ В JAVA:
        System.out.println(byteVar + shortVar);
        System.out.println(intVar - longVar);
        System.out.println(intVar / floatVar);
        System.out.println(intVar % doubleVar);
        System.out.println(intVar += 10);
        System.out.println(intVar == longVar);
        System.out.println(intVar != longVar);
        System.out.println(intVar > longVar);
        System.out.println(intVar >= longVar);
        System.out.println(intVar < longVar);
        System.out.println(intVar <= longVar);

        //ПЕРЕПОЛНЕНИЯ ПРИ ВЫЧИСЛЕНИЯХ
        System.out.println((byte) (byteVar + 1));
        System.out.println((short) (shortVar + longVar));

        //ВЫЧИСЛЕНИЯ КОМБИНАЦИЙ ТИПОВ ДАННЫХ (int и double)
        System.out.println("int + double = "+ (intVar + doubleVar));
        System.out.println("int - double = "+ (intVar - doubleVar));
        System.out.println("int / double = "+ (intVar / doubleVar));

    }
}
