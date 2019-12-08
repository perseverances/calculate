package com.example.myfirsthelloapplication.utils;

import java.util.regex.Pattern;

/**
 * 进制转化工具类
 */
public class BinaryConversion {

    /**
     * 判断输入数字num，是不是对应message类型的
     *
     * @param num     需要判断的数字类型
     * @param message 数字对应的进制信息
     * @return 是否对应
     */
    public static boolean isTrueNum(String num, String message) {
        //message为二进制
        if ("二进制".equals(message)) {
            String numBinReg = "[0-1]*";
            return Pattern.matches(numBinReg, num);

        }
        //message为八进制
        else if ("八进制".equals(message)) {
            String numOctReg = "[0-7]*";
            return Pattern.matches(numOctReg, num);
        } else if ("十进制".equals(message)) {
            String numDecReg = "[0-9]*";
            return Pattern.matches(numDecReg, num);
        }
        //message为十六进制
        else if ("十六进制".equals(message)) {
            String numHexReg = "([0-7]|[A-F])*";
            return Pattern.matches(numHexReg, num);
        }
        return false;
    }

    /**
     * 进制转化入口函数
     *
     * @param current 当前进制
     * @param target  目标进制
     * @param value   数字
     * @return 转化后数字
     */
    public static String binConvers(String current, String target, String value) {
        String result = null;
        if (current.equals(target)) {
            result = value;
        } else if ("二进制".equals(current)) {
            switch (target) {
                case "八进制":
                    result = binToOct(value);
                    break;
                case "十进制":
                    result = binToDec(value);
                    break;
                case "十六进制":
                    result = binToHex(value);
                    break;
            }
        }
        else if ("八进制".equals(current)){
            switch (target){
                case "二进制":
                    result = octToBin(value);
                    break;
                case "十进制":
                    result = octToDec(value);
                    break;
                case "十六进制":
                    result = octToHex(value);
                    break;
            }
        }
        else if ("十进制".equals(current)){
            switch (target){
                case "二进制":
                    result = decToBin(value);
                    break;
                case "八进制":
                    result = decToOct(value);
                    break;
                case "十六进制" :
                    result = decToHex(value);
                    break;
            }
        }
        else if ("十六进制".equals(current)){
            switch (target){
                case "二进制":
                    result = hexToBin(value);
                    break;
                case "八进制":
                    result = hexToOct(value);
                case "十进制":
                    result = hexToDec(value);
            }
        }
        return result;
    }

    /**
     * 十进制转二进制
     *
     * @param value 十进制字符串
     * @return 二进制字符串
     */
    public static String decToBin(String value) {
        return Integer.toBinaryString(Integer.parseInt(value));
    }

    /**
     * 十进制转八进制
     *
     * @param value 十进制字符串
     * @return 八进制字符串
     */
    public static String decToOct(String value) {
        return Integer.toOctalString(Integer.parseInt(value));
    }

    /**
     * 十进制转十六进制
     *
     * @param value 十进制字符串
     * @return 十六进制字符串
     */
    public static String decToHex(String value) {
        return Integer.toHexString(Integer.parseInt(value));
    }

    /**
     * 二进制转十进制
     *
     * @param value 二进制字符串
     * @return 十进制字符串
     */
    public static String binToDec(String value) {
        return Integer.valueOf(value, 2).toString();
    }

    /**
     * 二进制转八进制
     *
     * @param value 二进制字符串
     * @return 八进制字符串
     */
    public static String binToOct(String value) {
        //首先将二进制转化为十进制
        String decResult = BinaryConversion.binToDec(value);
        //十进制转八进制
        return BinaryConversion.decToOct(decResult);
    }

    /**
     * 二进制转十六进制
     *
     * @param value 二进制字符串
     * @return 十六进制字符串
     */
    public static String binToHex(String value) {
        //首先将二进制转化为十进制
        String decResult = BinaryConversion.binToDec(value);
        //十进制转十六进制
        return BinaryConversion.decToHex(decResult);
    }

    /**
     * 八进制转十进制
     *
     * @param value 二进制字符串
     * @return 十进制字符串
     */
    public static String octToDec(String value) {
        return Integer.valueOf(value, 8).toString();
    }

    /**
     * 八进制转二进制
     *
     * @param value 八进制字符串
     * @return 二进制字符串
     */
    public static String octToBin(String value) {
        //首先将八进制转化为十进制
        String decResult = BinaryConversion.octToDec(value);
        //十进制转二进制
        return BinaryConversion.decToBin(decResult);
    }

    /**
     * 八进制转十六进制
     *
     * @param value 八进制字符串
     * @return 十六进制字符串
     */
    public static String octToHex(String value) {
        //首先将八进制转化为十进制
        String decResult = BinaryConversion.octToDec(value);
        //十进制转十六进制
        return BinaryConversion.decToHex(decResult);
    }

    /**
     * 十六进制转十进制
     *
     * @param value 十六进制字符串
     * @return 十进制字符串
     */
    public static String hexToDec(String value) {
        return Integer.valueOf(value, 16).toString();
    }

    /**
     * 十六进制转二进制
     *
     * @param value 十六进制字符串
     * @return 二进制字符串
     */
    public static String hexToBin(String value) {
        //首先将十六进制转化为十进制
        String decResult = BinaryConversion.hexToDec(value);
        //十进制转二进制
        return BinaryConversion.decToBin(decResult);
    }

    /**
     * 十六进制转八进制
     *
     * @param value 十六进制字符串
     * @return 八进制字符串
     */
    public static String hexToOct(String value) {
        //首先将十六进制转化为十进制
        String decResult = BinaryConversion.hexToDec(value);
        //十进制转二进制
        return BinaryConversion.decToOct(decResult);
    }
}
