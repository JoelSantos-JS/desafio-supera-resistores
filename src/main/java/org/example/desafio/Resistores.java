package org.example.desafio;


import java.util.HashMap;
import java.util.Map;

public class Resistores {




    private static final String[] colorMap = {"preto", "marrom", "vermelho", "laranja", "amarelo", "verde", "azul", "violeta", "cinza", "branco"};



    public static final String  convertValueInColor(String input) {
            input = input.replace(" ohms", "").trim();



            double value;



            if(input.contains("k")) {
                value = Double.parseDouble(input.replace("k", "")) * 1000;
            } else if (input.contains("M")) {
                value = Double.parseDouble(input.replace("M", "")) * 1_000_000;

            }else   {
                value = Double.parseDouble(input);
            }


            int intValue = (int) Math.round(value);

            String valueStr = String.valueOf(intValue);

            int firstDigit = Character.getNumericValue(valueStr.charAt(0));
             int secondDigit = (valueStr.length() > 1) ?  Character.getNumericValue(valueStr.charAt(1)) : 0;


            int  multiplier = valueStr.length() -2;


             if(multiplier < 0) {
                 multiplier = 0;
             }


             String firstColor = colorMap[firstDigit];
             String secondColor = colorMap[secondDigit];
             String multiplierColor = colorMap[multiplier];


             String toleranceColor = "dourado";




        return  String.format("%s %s %s %s", firstColor,secondColor,multiplierColor, toleranceColor);

    }


    public static void main(String[] args) {
        System.out.println(convertValueInColor("220 ohms"));
        System.out.println(convertValueInColor("2M ohms"));
        System.out.println(convertValueInColor("4.7k ohms"));
        System.out.println(convertValueInColor("10 ohms"));
        System.out.println(convertValueInColor("100 ohms"));
        System.out.println(convertValueInColor("330 ohms"));
        System.out.println(convertValueInColor("470 ohms"));
        System.out.println(convertValueInColor("680 ohms"));
        System.out.println(convertValueInColor("1k ohms"));
    }

}
