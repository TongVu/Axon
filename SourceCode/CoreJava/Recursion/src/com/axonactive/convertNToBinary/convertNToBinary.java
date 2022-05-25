package com.axonactive.convertNToBinary;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class convertNToBinary {
    public static String convertToBinary(int n, String bit){
        if(n == 0 )
            return bit;

        bit = bit.concat(Integer.toString(n%2));
        n /= 2;
        return convertToBinary(n, bit);
    }

    public static void binary(String reverseBinary, int charAt){
        if(charAt == 0){
            System.out.println(reverseBinary.charAt(charAt));
        }else{
            System.out.print(reverseBinary.charAt(charAt));
            charAt--;
            binary(reverseBinary, charAt);
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        n = input.nextInt();
        String reverseBinary = convertToBinary(n, "");
        binary(reverseBinary, reverseBinary.length() -1);

    }
}
