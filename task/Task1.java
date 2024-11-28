package task;

import java.util.Scanner;

public class Task1 {
  public static void main(String[] args) {
    displayCalculation();
  }

  /*
   * Menampilkan hasil perhitungan Faktorial
   */
  public static void displayCalculation () {
    Scanner input = new Scanner(System.in);
  
    // Input angka dari pengguna
    System.out.println("Masukkan angka: ");
    int number = input.nextInt();

    // Menampilkan proses dan hasil perhitungan faktorial
    System.out.println("Proses: " + factorialProcess(number));
    System.out.println("Faktorial dari " + number + " (" + number + "!)" + " adalah: " + factorial(number));
  }

  /*
   * Faktorial adalah
   * Hasil Perkalian bilangan itu sendiri dikalikan dengan bilangan itu dikurangi dengan satu, hingga mencapai angka 1
   * RUMUS : 
   * n! = n x (n-1) x ... x 1
   */
  public static int factorial (int num) {
    int factorial = 0;
    for (int i = num; i >= 1; i--) { // num = 5
      if (i == num) {
        factorial = i;
      } else {
        factorial *= i;
      }
      // i = 5
      // factorial = 5
      // factorial = factorial * i
      // i = 4
      // 5 * 4 = 20
      // i = 3
      // 20 * 3 = 60
      // i = 2
      // 60 * 2 = 120
      // i = 1
      // 120 * 1 = 120
    }
    return factorial;
  }

  /*
   * Mengetahui proses Factorial
   */
  public static String factorialProcess (int num) {
    String process = "";
    for (int i = num; i >= 1; i--) {
      if (i == num) {
        process = String.valueOf(i);
      } else {
        process = process + " * " + i;
      }
      // i = 5, num = 5
      // process = 5 
      // i = 4
      // process = 5 * 4
      // i = 3
      // process = 5 * 4 * 3
      // i = 2
      // process = 5 * 4 * 3 * 2
      // i = 1
      // process = 5 * 4 * 3 * 2 * 1
    }
    return process;
  }
}