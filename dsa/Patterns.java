package dsa;

public class Patterns {

    public static void printPattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void printPattern2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void printPattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void printPattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void printPattern5(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printPattern6(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void printPattern7(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) System.out.print(" ");
            for (int j = 0; j < 2 * i + 1; j++) System.out.print("*");
            for (int j = 0; j < n - i - 1; j++) System.out.print(" ");

            System.out.println();
        }
    }

    public static void printPattern8(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) System.out.print(" ");
            for (int j = 0; j < 2 * n - (2 * i + 1); j++) System.out.print("*");
            for (int j = 0; j < i; j++) System.out.print(" ");

            System.out.println();
        }
    }

    public static void printPattern9(int n) {
        printPattern7(n);
        printPattern8(n);
    }

    public static void printPattern10(int n) {
        for (int i = 1; i < 2 * n - 1; i++) {

            int stars = i > n ? 2 * n - i : i;

            for (int j = 1; j < stars; j++) System.out.print("*");

            System.out.println();
        }
    }

    public static void printPattern11(int n) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) System.out.print(j % 2);
            System.out.println();
        }
    }

    public static void printPattern12(int n) {
        int spaces = 2 * (n - 1);

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) System.out.print(j);
            for (int j = 1; j <= spaces; j++) System.out.print(" ");
            for (int j = i; j >= 1; j--) System.out.print(j);

            spaces -= 2;
            System.out.println();
        }

    }

    public static void printPattern13(int n) {
        int num = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }

    public static void printPattern14(int n) {
        for (int i = 0; i < n; i++) {
            for (char ch = 'A'; ch <= 'A' + i; ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void printPattern15(int n) {
        for (int i = 0; i < n; i++) {
            for (char ch = 'A'; ch <= 'A' + (n - i - 1); ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void printPattern16(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) ((int) ('A' + i)) + " ");
            }
            System.out.println();
        }
    }

    public static void printPattern17(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            char ch = 'A';
            int breakpoint = (2 * i + 1) / 2;

            for (int j = 1; j <= 2 * i + 1; j++) {
                System.out.print(ch);
                if (j <= breakpoint) ch++;
                else ch--;
            }

            System.out.println();
        }
    }

    public static void printPattern18(int n) {
        for (int i = 0; i < n; i++) {
            for(char ch =(char)(int)('A'+n-1-i);ch<=(char)(int)('A'+n-1);ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    static void printPattern19(int N) {
        int iniS = 0;
        for (int i = 0; i < N; i++) {

            for (int j = 1; j <= N - i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < iniS; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= N - i; j++) {
                System.out.print("*");
            }

            iniS += 2;

            System.out.println();
        }

        iniS = 2 * N - 2;
        for (int i = 1; i <= N; i++) {

            //for printing the stars in the row.
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            //for printing the spaces in the row.
            for (int j = 0; j < iniS; j++) {
                System.out.print(" ");
            }

            //for printing the stars in the row.
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // The spaces decrease by 2 every time we hit a new row.
            iniS -= 2;

            // As soon as the letters for each iteration are printed, we move to the
            // next row and give a line break otherwise all letters
            // would get printed in 1 line.
            System.out.println();
        }

    }

    public static void main(String[] args) {
        //Pattern 01
        printPattern1(6);

        //Pattern 02
        printPattern2(6);

        //Pattern 03
        printPattern3(6);

        //Pattern 04
        printPattern4(6);

        //Pattern 05
        printPattern5(6);

        //Pattern 06
        printPattern6(6);

        //Pattern 07
        printPattern7(6);

        //Pattern 08
        printPattern8(6);

        //Pattern 09
        printPattern9(6);

        //Pattern 10
        printPattern10(6);

        //Pattern 11
        printPattern11(6);

        //Pattern 12
        printPattern12(6);

        //Pattern 13
        printPattern13(6);

        //Pattern 14
        printPattern14(6);

        //Pattern 15
        printPattern15(6);

        //Pattern 16
        printPattern16(6);

        //Pattern 17
        printPattern17(6);

        //Pattern 18
        printPattern18(6);

        //Pattern 19
        printPattern19(6);
    }
}
