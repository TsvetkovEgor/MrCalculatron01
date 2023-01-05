package MrCalculatron01;

import java.util.HashMap;
import java.util.TreeMap;

class Convertron {
    HashMap<Character, Integer> R = new HashMap<>();
    TreeMap<Integer, String> A = new TreeMap<>();
    public Convertron() {
        R.put('I', 1);
        R.put('V', 5);
        R.put('X', 10);
        R.put('L', 50);
        R.put('C', 100);
        R.put('D', 500);
        R.put('M', 1000);

        A.put(1000, "M");
        A.put(900, "CM");
        A.put(500, "D");
        A.put(400, "CD");
        A.put(100, "C");
        A.put(90, "XC");
        A.put(50, "L");
        A.put(40, "XL");
        A.put(10, "X");
        A.put(9, "IX");
        A.put(5, "V");
        A.put(4, "IV");
        A.put(1, "I");
    }
     public boolean isRoman(String number){
         return R.containsKey(number.charAt(0));
     }


public int vA (String chislo){
    int indexLast = chislo.length()-1;
    char[] mass = chislo.toCharArray();
    int a;
    int res = R.get(mass[indexLast]);

    for(int i = indexLast -1; i>=0;i--){
        a = R.get(mass[i]);
        int b = R.get(mass[i+1]);
        if (a< b){
            res = res - a;
        }else{
            res = res + a;
        }
    }
    return res;
}

     public String vR(int chislo) {
         String roman="";
         /// Проверяем ответ на отриц. начение
         if (chislo<0){
                 System.out.println("У римского числа не может быть отрицательного значения. ");
                 System.exit(0);
         }
         int aKey;
         do {
             aKey = A.floorKey(chislo);/// ищем наиболее близкий к значению полученного ответа ключ <------|
             roman = roman + A.get(aKey);/// Добавляем в строку римское значение, полученное по ключу      |
             chislo = chislo - aKey;/// Вычитаем значение, которое уже вычислили, и и перевели в римск.--->|
         } while (chislo != 0);
         return roman;
     }
}
