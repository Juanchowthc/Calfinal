package com.example.calculadora20;

public class Potencia {

    public static long potencia(long base, long exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente == 1) {
            return base;
        } else {
            return multiplicar(base, potencia(base, exponente - 1));
        }
    }

    private static long multiplicar(long a, long b) {
        if (b == 0) {
            return 0;
        } else {
            return sumar(a, multiplicar(a, b - 1));
        }
    }

    private static long sumar(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return sumar(a + 1, b - 1);
        }
    }
}

