public class TestDayOne {
  public static void main(String[] args) {
    int barrier = 10;
    String sentence = "Kelas Reguler Java Batch 29, Running...";
    int[] arrInt = new int[10];

    arrInt[0] = 1;
    arrInt[1] = 2;
    arrInt[2] = 3;
    arrInt[3] = 4;
    arrInt[4] = 5;
    arrInt[5] = 6;
    arrInt[6] = 7;
    arrInt[7] = 8;
    arrInt[8] = 9;
    arrInt[9] = 10;

    System.out.println("Element at index 0: " + arrInt[0]);
    System.out.println("Element at index 1: " + arrInt[1]);
    System.out.println("Element at index 2: " + arrInt[2]);
    System.out.println("Element at index 3: " + arrInt[3]);
    System.out.println("Element at index 4: " + arrInt[4]);
    System.out.println("Element at index 5: " + arrInt[5]);
    System.out.println("Element at index 6: " + arrInt[6]);
    System.out.println("Element at index 7: " + arrInt[7]);
    System.out.println("Element at index 8: " + arrInt[8]);
    System.out.println("Element at index 9: " + arrInt[9]);

    int angka5 = 5;
    angka5 += 2;
    System.out.println("Operator +: " + angka5);
    angka5 -= 2;
    System.out.println("Operator -: " + angka5);
    angka5 *= 2;
    System.out.println("Operator *: " + angka5); 
    angka5 /= 2;
    System.out.println("Operator /: " + angka5); 
    angka5 %= 2;
    System.out.println("Operator %: " + angka5); 

    System.out.println("Element at index 4 Post Increment: " + arrInt[4]++); 
    System.out.println("Element at index 4 Pre Increment: " + ++arrInt[4]); 

    int x1 = 1;
    int x2 = 2;
    // dan (&&)
    // atau (||)
    if ((x1 == 1) && (x2 == 2)){
      System.out.println("x1 is 1 AND x2 is 2");
    } 

    if ((x1 == 1) || (x2 == 1)){
      System.out.println("x1 is 1 OR x2 is 1");
    }

    int y1 = 7;
    int y2 = 3;

    boolean myCondition = y1 == y2 && true;
    System.out.println(myCondition);

    myCondition = y1 == y2 && false;
    System.out.println(myCondition);

    myCondition = !(y1 == y2);
    System.out.println(myCondition);

    int[][] arrayInt = {
      {1,2,3}, // [0, 0] [0, 1] [0, 2]
      {4,5,6} // [1, 0], [1, 1] [1, 2]
    };
    String[][] names = {
      {"Mr. ", "Mrs. ", "Ms. "},
      {"Smith", "Jones", "Betty"}
    };

    System.out.println(names[0][0] + names[1][0]);
    System.out.println(names[0][1] + names[1][1]);
    System.out.println(names[0][2] + names[1][2]);

    boolean isActive = true;
    float ipk = 3.9f;
    float durasiPendidikan = 4;

    if (!isActive) {
      System.out.println("Tidak Aktif");
    } else {
      System.out.println("Aktif");
    }

    if (ipk > 3.9) {
      System.out.println("Mendapatkan beasiswa 100%");
    } else if (ipk > 3.5) {
      System.out.println("Mendapatkan beasiswa 80%");
    } else {
      System.out.println("Tidak mendapatkan beasiswa");
    }

    int month = 8;
    String monthName;
    switch (month) {
      case 1:
        monthName = "Bulan Januari";
        System.out.println();
        break;
    
      case 2:
        monthName = "Bulan Februari";
        System.out.println(monthName);
        break;
    
      case 3:
        monthName = "Bulan Maret";
        System.out.println(monthName);
        break;
    
      case 4:
        monthName = "Bulan April";
        System.out.println(monthName);
        break;
    
      case 5:
        monthName = "Bulan Mei";
        System.out.println(monthName);
        break;
    
      case 6:
        monthName = "Bulan Juni";
        System.out.println(monthName);
        break;
    
      case 7:
        monthName = "Bulan Juli";
        System.out.println(monthName);
        break;
    
      case 8:
        monthName = "Bulan Agustus";
        System.out.println(monthName);
        break;
    
      case 9:
        monthName = "Bulan September";
        System.out.println(monthName);
        break;
    
      case 10:
        monthName = "Bulan Oktober";
        System.out.println(monthName);
        break;
    
      case 11:
        monthName = "Bulan November";
        System.out.println(monthName);
        break;
    
      case 12:
        monthName = "Bulan Desember";
        System.out.println(monthName);
        break;
    
      default:
        monthName = "Invalid Month";
        System.out.println(monthName);
        break;
    }

    int counter = 1;
    while (counter < 10) {
      System.out.println("Counter while: " + counter);
      counter++;
    }

    counter = 1;
    do {
      System.out.println("Counter do-while: " + counter);
      counter++;
    } while (counter < 10);

    counter = 1;
    for (int i = 1; i < 10; i++) {
      System.out.println("Counter for: " + i);
    }

    int[] listAngka = {5, 2, 9, 16, 78};
    for (int i : listAngka){
      System.out.println("Counter for-enhanced: " + i);
    }

    // for (int i = 1; i < barrier; i++){
    //   if(i % 2 == 0) {
    //     System.out.println(i);
    //   } else {
    //     System.out.println(sentence);
    //   }
      
    // }

    // System.out.println(sentence); // bagian ini untuk ....
    //System.out.println(true);
    /* */
    // COMMENT SINGLE ROW
    calculation();
  }
  
  // method void
  public static void calculation() {
    System.out.println(luas(2, 5));
    System.out.println(keliling(8));

    int[] arrValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    for (int i = 0; i < arrValue.length; i++) {
      if (checkOddorEven(i, "Even")) {
        System.out.println(i);
      }
    }
  }

  public static boolean checkOddorEven (int value, String type){
    if (type == "Odd") {
      return value % 2 == 1;
    } else {
      return value % 2 == 0;
    }
  }

  // method non void
  // 1/2 * a * t -> luas
  // s + s + s -> keliling
  public static float luas(int alas, int tinggi) {
    float result = 0.5f * alas * tinggi;
    return result;
  }

  public static int keliling(int sisi) {
    int result = sisi + sisi + sisi;
    return result;
  }

  /*
   * Method Display  
   * @param display1 int
   * @param ....
   */
  public void display () {
    
  }
}
