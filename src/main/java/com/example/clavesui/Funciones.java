package com.example.clavesui;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Funciones {
    public  static  int esNumero(String string){

        int intValor;

        if(string == null || string.equals("")){
            System.out.println("No numero ");
            return  0;
        }
        try{
            intValor = Integer.parseInt(string);
            return 1;
        }catch (NumberFormatException e){
            System.out.println("No es un numero ");
            return 0;
        }

    }

    static int fSemilla(int dato){

        Calendar calendario = new GregorianCalendar();
        int minuto = calendario.get(Calendar.MINUTE);
        int segundo = calendario.get(Calendar.SECOND);

        int semilla = minuto + segundo+ (int) Math.floor(Math.random()*dato);
        semilla = semilla %dato;

        return semilla;
    }


    public static String KeyGenerator(int lCadena) {


        String clave = "";
        Contrasena contrasena = new Contrasena("", 13);
        char[] mayusculas = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] minusculas = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] signo = {'!','"','#','$','%','&', '(',')','*','+', ',','-','.','/', ':',';','<','=','>','?','@', '[',']','^','_', '{','|','}','~'};
        char[] numero = {'0','1','2','3','4','5','6','7','8','9'};

        int longitudClave;
        int grupo;
        int numeroCaracter;
        String letra;

        longitudClave = lCadena;

        for(int i = 1; i <= longitudClave; i++){

            grupo = fSemilla(4);
            switch(grupo){
                case 0 -> {
                    numeroCaracter = fSemilla(26);
                    letra = String.valueOf((mayusculas[numeroCaracter]));
                    clave = clave.concat(letra);
                }
                case 1 -> {
                    numeroCaracter = fSemilla(26);
                    letra = String.valueOf((minusculas[numeroCaracter]));
                    clave = clave.concat(letra);
                }
                case 2 -> {
                    numeroCaracter = fSemilla(29);
                    letra = String.valueOf((signo[numeroCaracter]));
                    clave = clave.concat(letra);
                }
                case 3 -> {
                    numeroCaracter = fSemilla(10);
                    letra = String.valueOf((numero[numeroCaracter]));
                    clave = clave.concat(letra);
                }
                default -> {
                }
            }//switch

        }//for

        contrasena.setContrasena(clave);
        System.out.println(contrasena.getContrasena());

        return contrasena.getContrasena();
    }

}
