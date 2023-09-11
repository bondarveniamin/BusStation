import model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        //окружение: джава, ввод-вывод в консоль, запуск через метод main
        //задача: Написать сервис по расчету стоимости покупки билетов в кассе автовокзала.
        //У нас есть 3 маршрута автобусов с разной стоимостью и разным кол-вом посадочных мест.
        //При покупке необходимо предусмотреть возможность выбора маршрута, ввода кол-ва покупаемых билетов, ввод ФИО пассажира(-ов).
        //Завершается процесс оплаты выводом конечной суммы к оплате.

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> routOne = new ArrayList<>();
        List<Person> routTwo = new ArrayList<>();
        List<Person> routThree = new ArrayList<>();
        int countRoutOne = RouteEnum.ROUTE_ONE.getCount();
        int countRoutTwo = RouteEnum.ROUTE_TWO.getCount();
        int countRoutThree = RouteEnum.ROUTE_THREE.getCount();

        do {
            System.out.println("Выберите маршрут цифрой: 1, 2 или 3");
            int rout = Integer.parseInt(reader.readLine());
            System.out.println("Введите количество билетов цифрой");
            int count = Integer.parseInt(reader.readLine());
            if (rout == RouteEnum.ROUTE_ONE.getNumber() && (countRoutOne - count) >= 0) {
                countRoutOne = countRoutOne - count;
                routOne.add(createPerson(reader));
                System.out.printf("Стоимость билета: %s руб.%n", count * RouteEnum.ROUTE_ONE.getCost());
            } else if (rout == RouteEnum.ROUTE_TWO.getNumber() && (countRoutTwo - count) >= 0) {
                countRoutTwo = countRoutTwo - count;
                routTwo.add(createPerson(reader));
                System.out.printf("Стоимость билета: %s руб%n", count * RouteEnum.ROUTE_TWO.getCost());
            } else if (rout == RouteEnum.ROUTE_THREE.getNumber() && (countRoutThree - count) >= 0) {
                countRoutThree = countRoutTwo - count;
                routThree.add(createPerson(reader));
                System.out.printf("Стоимость билета: %s руб%n", count * RouteEnum.ROUTE_THREE.getCost());
            } else System.out.println("Запрошенного количества билетов нет в кассе");
            System.out.println("Если Вы хотите выйти из программы введите: да");
        } while (!Objects.equals(reader.readLine(), "да"));
        showPerson(routOne, routTwo, routThree);
    }

    public static Person createPerson(BufferedReader reader) throws IOException {
        System.out.println("Введите имя");
        String firstName = reader.readLine();
        System.out.println("Введите фамилию");
        String lastName = reader.readLine();
        System.out.println("Введите отчество");
        String middleName = reader.readLine();
        return new Person(firstName, lastName, middleName);
    }

    public static void showPerson(List<Person> routOne, List<Person> routTwo, List<Person> routThree) {
        System.out.println(RouteEnum.ROUTE_ONE.getDescription());
        routOne.forEach(System.out::println);
        System.out.println(RouteEnum.ROUTE_TWO.getDescription());
        routTwo.forEach(System.out::println);
        System.out.println(RouteEnum.ROUTE_THREE.getDescription());
        routThree.forEach(System.out::println);
    }
}