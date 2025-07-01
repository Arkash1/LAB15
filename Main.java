import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите ip-адреса через пробел: ");
        Scanner in = new Scanner(System.in);
        String ips = in.nextLine();
        String[] Ips = ips.split(" ");
        try(FileWriter ipsFile = new FileWriter("Text.txt")){
            for (String ip: Ips) {
                if (ip.matches("(\\b([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\b")){
                    ipsFile.write(ip + " - Корректный ip-адрес\n");
                }
                else {
                    ipsFile.write(ip + " - Некорректный ip-адрес\n");
                }
            }
            System.out.print("Ip-адреса перенесены в файл");
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
