package tech.itpark.itpark2021.lesson28.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersUtil {

    public static char[] enterPassword() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        return sc.nextLine().toCharArray();
    }

    public static String enterLocation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите путь до файла: ");
        return sc.nextLine();
    }

    public static String enterFileName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Укажите название вашего архива(с расщирением.zip): ");
        String extension = sc.nextLine();
        int index = extension.indexOf('.');
        return index == -1 ? extension + ".zip" : extension;
    }

    public static List<File> enterFilesLocation() {
        Scanner sc = new Scanner(System.in);
        List<File> locations = new ArrayList<>();
        do {
            System.out.print("Укажите расположение файла: ");
            File location = new File(sc.nextLine());
            if (location.isFile()) {
                locations.add(location);
            }
            System.out.println("Нажмите 'q' для остановки ввода, для продолжения любой символ.");
        } while (!sc.nextLine().equals("q"));
        return locations;
    }
}
