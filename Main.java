package MrCalculatron01;

class Main {
    static Convertron convert = new Convertron();
    /////////////////////////0////1////2////3///////////////////////////////////////////////////////////////////////////
    static String[] impl = {"+", "-", "/", "*"};///Массив с символами операций
    /// Массив из корого берется значение под определенным индексом
    static String[] implSplit = {"\\+", "-", "/", "\\*"}; /// сплит не может передать просто + или просто *, следует их экранировать -  \\
    static int rES;
    static String result;

    public static String calc(String input) {


        int fate = -1;  /// Будущий индекс введенной операции

        for (int i = 0; i < impl.length; i++) {
            if (input.contains(impl[i])) {
                fate = i; /// будущий индекс найденного знака
                break;
            }
        }
        if (fate == -1) {
            System.out.println("Неверно введено выражение.");
            System.exit(0);
        }


        ///делим строчку по символу в массиве implSplit под индексом найденного знака [fate] и помещаем эти два значения в массив chis под индексами 0 и 1
        String[] chis = input.split(implSplit[fate]);
        for (int i = 0; i < impl.length; i++) {
            if (chis.length >2||chis.length >2||chis[0].contains(impl[i])||chis[1].contains(impl[i])) {
                System.out.println("Выражение должно состоять из 2х операндов, 1 оператора."); 
                System.exit(0);
            }
        }

        if (convert.isRoman(chis[0]) == convert.isRoman(chis[1])) {
            int x, y;
            ///Определяем, какие это числа
            boolean isRoman = convert.isRoman(chis[0]);
            /// если римские
            if (isRoman) {
                ///помещаем два числа из массива в переменные х и у, перед этим конвертируя в арабские числа.

                x = convert.vA(chis[0]);
                y = convert.vA(chis[1]);
                if (x>10||x<1||y>10||y<1){
                    System.out.println("Переменные строго от 1 до 10");
                    System.exit(0);
                }
                switch (impl[fate]) {
                    case "+":
                        rES = x + y;
/// т.к мы работаем с римскими числами, ответ следует перевести из арабской системы счисления в римскую
                        result = convert.vR(rES);
                        break;
                    case "-":
                        rES = x - y;
                        result = convert.vR(rES);
                        break;
                    case "*":
                        rES = x * y;
                        result = convert.vR(rES);
                        break;
                    case "/":
                        rES = x / y;
                        result = convert.vR(rES);
                        break;
                }

                /// Если арабские
            } else {
                /// помещаем два числа из массива в переменные х и у преобразуя их в из строк в инт.
                x = Integer.parseInt(chis[0]);
                y = Integer.parseInt(chis[1]);
                if (x>10||x<1||y>10||y<1){
                    System.out.println("Переменные строго от 1 до 10");
                    System.exit(0);
                }

                switch (impl[fate]) {
                    case "+":
                        rES= x + y;

 /// т.к вернуть мы должны String, переводим арабское целое число в строчное значение.
                        result = Integer.toString(rES);
                        break;
                    case "-":
                        rES = x - y;
                        result = Integer.toString(rES);
                        break;
                    case "*":
                        rES = x * y;
                        result = Integer.toString(rES);
                        break;
                    case "/":
                        rES = x / y;
                        result = Integer.toString(rES);
                        break;
                }
                System.out.println(x);
                System.out.println(y);
                System.out.println(chis[2]);
            }

        }else{
            System.out.println("Числа должны находиться в 1 системе счисления)");
            System.exit(0);
        }

        System.out.println("о т в е т : " + result);
        return result;
    }
    }


