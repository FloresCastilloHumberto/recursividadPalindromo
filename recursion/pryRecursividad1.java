/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad1.recursion;

/**
 *
 * @author Humberto Flores Castillo
 */

public class pryRecursividad1 {
    private String esPalindromo(String palabra){
        // 1. Validación de entrada nula
        if (palabra == null) {
            return "No es palindromo";
        }

        // 2. Normalización: minúsculas y sin espacios
        palabra = palabra.toLowerCase().replaceAll("\\s+", "");

        // 3. Caso borde: cadenas vacías o de 1 carácter son palíndromos por definición
        if (palabra.length() <= 1) {
            return "Es palindromo";
        }

        // 4. Llamada al método auxiliar recursivo
        // Evaluación recursiva traducida con operador ternario
        return esPalindromoAux(palabra, 0, palabra.length() - 1)? "Es palindromo" : "No es palindromo";
    }

    private boolean esPalindromoAux(String palabra, int inicio, int fin) {
        // 1. Caso base: si los índices se cruzaron o igualaron, es palíndromo
        if (inicio >= fin) {
            return true;
        }

        // 2. Si las letras de los extremos no coinciden, no es palíndromo
        if (palabra.charAt(inicio) != palabra.charAt(fin)) {
            return false;
        }

        // 3. Paso recursivo: evaluamos el siguiente par de letras hacia el centro
        return esPalindromoAux(palabra, inicio + 1, fin - 1);
    }
    
    
    
    // Aquí van los métodos esPalindromo y esPalindromoAux
    public static void main(String[] args) {
        pryRecursividad1 verificador = new pryRecursividad1();
        System.out.println("--- PRUEBAS DE PALINDROMOS ---");
        
        // 1. Palabras palíndromas válidas
        System.out.println("reconocer -> " + verificador.esPalindromo("reconocer")); // true
        System.out.println("Radar (mayusculas) -> " + verificador.esPalindromo("Radar")); // true
        System.out.println("Anita lava la tina (frase) -> " + verificador.esPalindromo("Anita lava la tina")); // true

        // 2. Palabras NO palíndromas
        System.out.println("estructura -> " + verificador.esPalindromo("estructura")); // false
        System.out.println("java -> " + verificador.esPalindromo("java")); // false

        // 3. Casos borde y especiales
        System.out.println("Cadena vacia \"\" -> " + verificador.esPalindromo("")); // true
        System.out.println("Un caracter \"a\" -> " + verificador.esPalindromo("a")); // true
        System.out.println("Entrada null -> " + verificador.esPalindromo(null)); // false
    }
}