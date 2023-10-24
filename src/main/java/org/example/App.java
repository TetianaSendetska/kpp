package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void run(){
        System.out.print("Введіть кількість ітеракцій:");
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while(true){
            try {
                count = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ви ввели неправильний символ, будь ласка спробуйте ще раз:");
                scanner.next();
            }
        }
        if(count <= 0) {
            System.out.println("Число повинно бути більше ніж 0");
        }
        else if(count <= 15) {
            HarmonicSeriesInt harmonicSeries = new HarmonicSeriesInt();
            System.out.println("Сума перших " + count + " членів гармонійного ряду: " + harmonicSeries.HarmonicSeries(count));
        }
        else {
            HarmonicSeriesBig harmonicSeries = new HarmonicSeriesBig();
            System.out.println("Сума перших " + count + " членів гармонійного ряду: " + harmonicSeries.HarmonicSeries(count));
        }
    }
}
