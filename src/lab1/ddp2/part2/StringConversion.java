package lab1.ddp2.part2;

import java.util.Scanner;

public class StringConversion {
    public static void main(String[] args)
    {
        String value1 = "12345";
        int intValue = Integer.parseInt(value1);
        System.out.println("intValue = " + intValue);
        String value2 = "12.345";
        double doubleValue = Double.parseDouble(value2);
        System.out.println("doubleValue = " + doubleValue);
        String value3 = "9876543210";
        long longValue = Long.parseLong(value3);
        System.out.println("longValue = " + longValue);
        String value4 = "321";
        short shortValue = Short.parseShort(value4);
        System.out.println("shortValue = " + shortValue);
        String value5 = "-28";
        byte byteValue = Byte.parseByte(value5);
        System.out.println("byteValue = " + byteValue);
        String value6 = "-45.237";
        float floatValue = Float.parseFloat(value6);
        System.out.println("floatValue = " + floatValue);
        String value7 = "3BABE";
        int hexValue = Integer.parseInt(value7, 16);
        System.out.println("hexValue = " + hexValue);
        String value8 = "11001";
        int binValue = Integer.parseInt(value8, 2);
        System.out.println("binValue = " + binValue);
    }
}
