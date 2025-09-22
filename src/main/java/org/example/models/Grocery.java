package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();


    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("Lütfen bir işlem seçininz:");
            System.out.println(" 0 : Çıkış ");
            System.out.println(" 1 : Ürün ekle ");
            System.out.println(" 2 : Ürün çıkar");
            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 0:
                    System.out.println("Programdan çıkılıyor...");
                    running=false;
                    break;

                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz .");
                    String addingItems =scanner.nextLine();
                    addItems(addingItems);
                    printSorted();
                    break;

                case 2:
                    System.out.println("Çıkarılmasını istediğiniz elemanları giriniz.");
                    String removingItems = scanner.nextLine();
                    removeItems(removingItems);
                    printSorted();
                    break;

                default:
                    System.out.println("Geçersiz seçim! Lütfen 0, 1 veya 2 girin.");

            }

        }
        scanner.close();
    }

        public static void addItems(String input) {
            String[] items = input.split("\\s*,\\s*");
            for (String item : items) {
                if (!elemanKontrol(item)){
                    groceryList.add(item);
                    System.out.println("listeye eklendi");
                }else {
                    System.out.println(item + " zaten listede var!");
                }
            }
            Collections.sort(groceryList);
        }

        public  static  void  removeItems(String input) {
            String[] items =  input.split("\\s*,\\s*");
            for (String item : items) {
                if (elemanKontrol(item)) {
                    groceryList.remove(item);
                    System.out.println("Listeden çıkarıldı");
                } else {
                    System.out.println(item + " listede bulunamadı!");
                }
            }
            Collections.sort(groceryList);
        }

        public static boolean elemanKontrol(String product) {
            return groceryList.contains(product);
        }

        public static void printSorted() {
            Collections.sort(groceryList);
            System.out.println( "Güncel liste : "+ groceryList);
        }
}