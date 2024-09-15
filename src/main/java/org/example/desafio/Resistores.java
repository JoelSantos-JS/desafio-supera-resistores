package org.example.desafio;


import java.util.HashMap;

public class Resistores {




    private static  final HashMap<Integer, String> colorMap = new HashMap<>();

    static  {
        colorMap.put(0, "preto");
        colorMap.put(1, "marrom");
        colorMap.put(2, "vermelho");
        colorMap.put(3, "laranja");
        colorMap.put(4, "amarelo");
        colorMap.put(5, "verde");
        colorMap.put(6, "azul");
        colorMap.put(7, "violeta");
        colorMap.put(8, "cinza");
        colorMap.put(9, "branco");

    }


    public static final String  convertValueInColor(String input) {
            input = input.replace(" ohms", "");



            double value;
            int multiplier = 0;


            if(input.contains("k")) {
                value = Double.parseDouble(input.replace("k", "")) * 1000;
            } else if (input.contains("M")) {
                value = Double.parseDouble(input.replace("M", "")) * 1_000_000;

            }else   {
                value = Double.parseDouble(input);
            }


            String valueStr = String.valueOf((int) value);

            int firstDigit = Character.getNumericValue(valueStr.charAt(0));
             int secondDigit = Character.getNumericValue(valueStr.charAt(0));


             multiplier = valueStr.length() -2;


             String firstColor = colorMap.get(firstDigit);
             String secondColor = colorMap.get(secondDigit);
             String multiplierColor = colorMap.get(multiplier);


             String toleranceColor = "dourado";




        return  String.format("%s %s %s %s", firstColor,secondColor,multiplierColor, toleranceColor);

    }


    public static void main(String[] args) {

        System.out.println(convertValueInColor("220 ohms"));
    }

}
