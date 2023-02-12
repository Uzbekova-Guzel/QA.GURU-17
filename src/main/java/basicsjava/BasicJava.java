//package basicsjava;
//
//import Human.Human;
//
//import java.util.*;
//
//public class BasicJava {
//    public static void main(String[] args) {
//
//        //Массивы
//        int[] array0 = {100, 150, -1, 90};
//        int[] array1 = {389, 34, -53, 35};
//        String[] arrayStr = new String[] {"Vasya", "Dima"};
//        int[][]array2 = {array0, array1};
//        int[][]array3 = {array0, array1};
//        int[][][]array4 = {array2, array3};
//
//        //Замена значения в массиве
//        array0[2] = 43543;
//
//        System.out.println(array0[0]);
//        System.out.println(array0.length);
//
//        //Цикл for
//        for (int i = 0; i < array0.length; i++) {
//            System.out.println(array0[i]);
//        }
//
//        //Цикл for наоборот
//        for (int i = array0.length - 1; i >= 0; i--) {
//            System.out.println(array0[i]);
//        }
//
//
//        //Цикл While
//        int index = 0;
//        while (index < array0.length) {
//            System.out.println(array0[index]);
//            index++;
//        }
//
//        boolean done = false;
//        while (!false) {
//            //что-то ищем
//            if (нашли) {
//                done = true;
//            }
//        }
//
//        // цикл do while
//        do {
//
//        } while (!false);
//
//        // Цикл foreach
//        for (int var : array0) {
//            System.out.println(var);
//        }
//
//        //Выход из цикла 0
//        for (int i = 0; i < array0.length; i++) {
//            if (array0[i] == -1) {
//                System.out.println("Радуемся, нашли: " + array0[i]);
//                break;
//            }
//        }
//
//        //Выход из цикла 1
//        for (int i = 0; i < array0.length; i++) {
//            if (array0[i] == -1) {
//                continue;
//            }
//            //Сложное вычисление
//            System.out.println("Радуемся, нашли: " + array0[i]);
//        }
//
//        //Выход из цикла 2
//        public static void someMethod() {
//            for (int i = 0; i < array0.length; i++) {
//                if (array0[i] == -1) {
//                    return;
//                }
//                //Сложное вычисление
//                System.out.println("Радуемся, нашли: " + array0[i]);
//                break;
//            }
//        }
//
//        //КОЛЛЕКЦИИ
//
//        //List
//        List<String> stringList = new ArrayList<>();
//        stringList.add("Dima");
//        stringList.addAll(Arrays.asList("Petr", "Ivan"));
//        stringList.get(0);
//        stringList.remove("Petr");
//        stringList.indexOf("Petr");
//        stringList.stream()
//                .filter(s -> s.equals("Petr"))
//                .map(s -> s.toUpperCase());
//
//        List<Integer> integerList = new ArrayList<>();
//        integerList.add(12);
//        integerList.addAll(Arrays.asList(42, 34));
//        integerList.get(0);
//        integerList.remove(42);
//        integerList.indexOf(34);
//        integerList.stream()
//                .filter(s -> s.equals(32));
//
//        for (int var : integerList) { //unboxing
//            System.out.println(var);
//        }
//
//        for (int i = stringList.size() - 1; i >= 0; i--) {
//            System.out.println(stringList.get(i));
//        }
//
//        //Set - хранит только уникальные значения
//        Set<Integer> stringSet = new HashSet<>();
//        stringSet.add(1);
//        stringSet.add(10);
//
//        //Map - хранит ключ, значение.
//        Map<String, Integer> aMap = new HashMap<>();
//
//        Map<Integer, Human> aMap = new HashMap<>();
//        aMap.put(23453465, new Human("Dima",33, "M"));
//        aMap.put(34545455, new Human("Masha", 23, "W"));
//        aMap.put(23455445, new Human("Petr", 45, "M"));
//
//
//        Set<Integer> passportNumbers = aMap.keySet(); //список всех ключей
//        Collection<Human> humans = aMap.values();
//        Set<Map.Entry<Integer, Human>> entrySet = aMap.entrySet(); //Entry - пара
//
//        for (Map.Entry<Integer, Human> entry : entrySet) {
//            if (entry.getKey() == 23455445) {
//                System.out.println("Нашли Петра: " + entry.getValue().getName());
//            }
//
//        }
//
//
//        //Класс - это описание того, что из себя будет представлять наша струртура данных и какое у нее будет поведение
//        //Объект - непосредтсвенно созданные в памяти данные, соответсвующий вот этой описанной структуре класса,
//        //для которых нужно вызывать методы через виртуальную таблицу методов

//    }
//}
