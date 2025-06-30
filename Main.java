package com.company;

import java.io.FileWriter; // Импорт для записи в файл
import java.io.IOException; // Импорт для обработки ошибок ввода/вывода
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        String ipRegex = "\\b((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}"
                + "(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\b";

        Pattern pattern = Pattern.compile(ipRegex);
        Matcher matcher = pattern.matcher(input);

        boolean found = false;
        StringBuilder results = new StringBuilder(); // Для накопления результатов
        
        // Собираем найденные IP-адреса
        while (matcher.find()) {
            results.append(matcher.group()).append("\n");
            found = true;
        }

        try {
            // Создаем FileWriter для записи в файл (файл создастся автоматически)
            FileWriter writer = new FileWriter("ip_addresses.txt");
            
            if (found) {
                // Если адреса найдены - записываем их в файл
                writer.write("Найденные IP-адреса:\n");
                writer.write(results.toString());
                System.out.println("Найденные IP-адреса:");
                System.out.print(results);
            } else {
                // Если адресов нет - записываем сообщение
                writer.write("Корректных IP-адресов не найдено.");
                System.out.println("Корректных IP-адресов не найдено.");
            }
            
            writer.close(); // Закрываем файл
            System.out.println("Результаты сохранены в файл: ip_addresses.txt");
            
        } catch (IOException e) {
            // Обработка ошибок при работе с файлом
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
