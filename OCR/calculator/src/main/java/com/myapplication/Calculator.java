package com.myapplication;

public class Calculator {
    public int add(int a, int b) {
        return (a + b);
    }

    public int multiply(int a, int b) {
        if (a==0 || b==0) {
            return 0;
        }

        boolean estNegatif = false;
        if (a<0) {
            a=-a;
            estNegatif= !estNegatif;
        }
        if (b<0) {
            b=-b;
            estNegatif= !estNegatif;
        }

        if (a == 666) {
            if (b == 666) {
                System.out.println("cette partie de code n'est pas testée !");
            }
        }

        int resultat;

        resultat = accumulateAdd(a,b,0);

        if (estNegatif) {
            resultat=-resultat;
        }

        return resultat;

    }

    private int accumulateAdd(int a,int b, int cumul) {
        if (b>0) {
            b = b - 1;
            return a + accumulateAdd(a,b,0);
        }
        return cumul;
    }
}
