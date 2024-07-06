import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class ECA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter length n: ");
        int n = in.nextInt();
        System.out.print("How many steps?: ");
        int steps = in.nextInt();

        for (int i = 0; i < (int) Math.pow(2, n); i++) {
            String binaryString = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
            System.out.print(binaryString);

            for (int k = 0; k < steps; k++) {
                String newString = "";

                boolean f1 = '1' == binaryString.charAt(binaryString.length()-1), f2 = '1' == binaryString.charAt(0), f3 = '1' == binaryString.charAt(1);
                newString += f(f1, f2, f3);

                for (int j = 1; j < binaryString.length() - 1; j++) {
                    boolean v1 = '1' == binaryString.charAt(j-1), v2 = '1' == binaryString.charAt(j), v3 = '1' == binaryString.charAt(j+1);

                    newString += f(v1, v2, v3);
                }

                boolean l1 = '1' == binaryString.charAt(binaryString.length()-2), l2 = '1' == binaryString.charAt(binaryString.length()-1), l3 = '1' == binaryString.charAt(0);

                newString += f(l1, l2, l3);

                System.out.print(" ---> " + newString);
                binaryString = newString;
            }
            // System.out.print(" ---> " + binaryString);

            System.out.println();
        }
    }


    public static String f(boolean a, boolean b, boolean c) {
        if (a || b || c) {
            return "1";
        }
        return "0";
    }

    public void print(boolean[] array) {
        for (boolean b : array) {
            System.out.print(b + " ");
        }
        System.out.println();
    }
}