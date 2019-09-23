package project;

import collection.*;

public class Project1 {
    public static void test() {
        MySet fibonacciNumSet = new MySet();
        MySet primeNumSet = new MySet();

        int a = 0, b = 1;
        for (int i = 0; i < 20; i++) {
            fibonacciNumSet.insert(a);
            int sum = a + b;
            a = b;
            b = sum;
        }
        System.out.println("The fibonacci set: \n " + fibonacciNumSet);

        int i = 2;
        while (primeNumSet.cardinality() < 30) {
            if (isPrimeNumber(i)) {
                primeNumSet.insert(i);
            }
            i++;
        }
        System.out.println("The prime set: \n " + primeNumSet);

        MySet sym = fibonacciNumSet.symmetricDifference(primeNumSet);

        System.out.println("The sym set: \n " + sym);

        System.out.println("The union set: \n " + fibonacciNumSet.union(primeNumSet));

        System.out.println("The intersection set: \n " + fibonacciNumSet.intersection(primeNumSet));

        System.out.println("The power set: \n " + fibonacciNumSet.intersection(primeNumSet).powerSet());
    }

    private static boolean isPrimeNumber(int x) {
        boolean isPrimeNumber = true;

        if (x < 2) {
            isPrimeNumber = false;
        } else {
            for (int i = 2; i <= x / 2; i++) {
                if (x % i == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }
        }

        return isPrimeNumber;
    }
}
