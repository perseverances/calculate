package com.example.myfirsthelloapplication.utils;



import java.util.regex.Pattern;

/**
 * 单位换算工具类
 */
public class UnitConversion {

    /**
     * 判断是否能进行单位转化
     * @param current 当前单位
     * @param target 目标单位
     * @return 是否能转化
     */
    public static boolean canConversion(String current, String target) {
        if (current.equals(target)) {
            //单位一样，可以换算
            return true;
        }
        //当前单位为长度单位
        if (("cm".equals(current)) || ("m".equals(current)) || ("km".equals(current))) {
            //目标单位也为长度单位
            if (("cm".equals(target)) || ("m".equals(target)) || ("km".equals(target))) {
                return true;
            } else {
                return false;
            }
        }
        //当前单位为质量单位
        if (("g".equals(current)) || ("kg".equals(current)) || ("t".equals(current))) {
            //目标单位也为质量单位
            if (("g".equals(target)) || ("kg".equals(target)) || ("t".equals(target))) {
                return true;
            } else {
                return false;
            }
        }

        //当前单位为面积单位
        if (("cm²".equals(current)) || ("m²".equals(current)) || ("km²".equals(current))) {
            //目标单位也为面积单位
            if (("cm²".equals(target)) || ("m²".equals(target)) || ("km²".equals(target))) {
                return true;
            } else {
                return false;
            }
        }

        //当前单位为体积
        if (("cm³".equals(current)) || ("m³".equals(current)) || ("km³".equals(current))){
            //目标单位也为体积单位
            if (("cm³".equals(target)) || ("m³".equals(target)) || ("km³".equals(target))){
                return true;
            }
            else {
                return false;
            }
        }

        //目标单位为时间
        if (("h".equals(current)) || ("min".equals(current)) || ("sec".equals(current))){
            //目标单位也为体积单位
            if (("h".equals(target)) || ("min".equals(target)) || ("sec³".equals(target))){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    /**
     * 判断输入是否为数字
     * @param str 输入数字
     * @return 是否是数字
     */
    public static boolean isNum(String str) {
        String numRegex = "^\\d+(\\.\\d+)?$";   //数字的正则表达式
        return Pattern.matches(numRegex, str);
    }

    /**
     * 单位转化方法，返回转化完毕的字符串形式
     *
     * @param current 当前选择的单位
     * @param target  目标单位
     * @param num     当前需要转化的数
     * @return 转化过后的字符串形式
     */
    public static String conversion(String current, String target, String num) {
        String result =null;

        //单位一样直接原样输出
        if (current.equals(target)) {
            return num;
        }

        //需要转化的长度单位
        if (("cm".equals(current)) || ("m".equals(current)) || ("km".equals(current))) {
            //进入长度转化方法
            result = lengthConversion(current, target, num);
        } else if (("g".equals(current)) || ("kg".equals(current)) || ("t".equals(current))) {
            //进入重量转化方法
            result = weightConversion(current, target, num);
        }else if (("cm²".equals(target)) || ("m²".equals(target)) || ("km²".equals(target))){
            //进入面积转化方法
            result = areaConversion(current, target, num);

        }
        else if (("cm³".equals(current)) || ("m³".equals(current)) || ("km³".equals(current))){
            //进入提及转化方法
            result= volumeConversion(current, target, num);
        }
        else if (("h".equals(current)) || ("min".equals(current)) || ("sec".equals(current))){
            //进入时间转化方法
            result = timeConversion(current, target, num);
        }


        return result;
    }

    /**
     * 时间转化方法
     * @param current
     * @param target
     * @param num
     * @return
     */
    private static String timeConversion(String current, String target, String num) {
        String result = null;
        if ("sec".equals(current)){
            switch (target){
                case "min":
                    result = (Double.valueOf(num) /60)+"";
                    break;
                case "h":
                    result = (Double.valueOf(num)) / 60*60 +"";
            }
        }
        else if ("min".equals(current)){
            switch (target){
                case "sec":
                    result = (Double.valueOf(num) * 60)+"";
                case "km³":
                    result = (Double.valueOf(num) / 60)+"";
            }
        }
        else if ("h".equals(current)){
            switch (target){
                case  "min":
                    result =( Double.valueOf(num)* 60)+"";
                case "sec":
                    result = (Double.valueOf(num)* 60*60)+"";
            }
        }

        return result;
    }

    /**
     * 体积转化方法
     * @param current
     * @param target
     * @param num
     * @return
     */
    private static String volumeConversion(String current, String target, String num) {
        String result = null;
        if ("cm³".equals(current)){
            switch (target){
                case "m³":
                    result = (Double.valueOf(num) / Math.pow(10,6))+"";
                    break;
                case "km³":
                    result = (Double.valueOf(num)) / Math.pow(10,15)+"";
            }
        }
        else if ("m³".equals(current)){
            switch (target){
                case "cm³":
                    result = (Double.valueOf(num) * Math.pow(10,6))+"";
                case "km³":
                    result = (Double.valueOf(num) / Math.pow(10,9))+"";
            }
        }
        else if ("km³".equals(current)){
            switch (target){
                case  "cm³":
                    result =( Double.valueOf(num)* Math.pow(10,15))+"";
                case "m³":
                    result = (Double.valueOf(num)* Math.pow(10,9))+"";
            }
        }

        return result;
    }

    private static String areaConversion(String current, String target, String num) {
        String result = null;
        if ("cm²".equals(current)){
            switch (target){
                case "m²":
                    result = (Double.valueOf(num) / Math.pow(10,4))+"";
                    break;
                case "km²":
                    result = (Double.valueOf(num)) / Math.pow(10,10)+"";
             }
        }
        else if ("m²".equals(current)){
            switch (target){
                case "cm²":
                    result = (Double.valueOf(num) * Math.pow(10,4))+"";
                case "km²":
                    result = (Double.valueOf(num) / Math.pow(10,6))+"";
            }
        }
        else if ("km²".equals(current)){
            switch (target){
                case  "cm²":
                    result =( Double.valueOf(num)* Math.pow(10,10))+"";
                case "m²":
                    result = (Double.valueOf(num)* Math.pow(10,6))+"";
            }
        }

        return result;
    }

    /**
     * 重量转化方法
     *
     * @param current
     * @param target
     * @param num
     * @return
     */
    private static String weightConversion(String current, String target, String num) {
        String result = null;
        if ("g".equals(current)) {
            switch (target) {
                case "kg":
                    result = (Double.valueOf(num) / 1000) + "";
                    break;
                case "t":
                    result = (Double.valueOf(num) / Math.pow(10, 6)) + "";
                    break;
            }
        } else if ("kg".equals(current)) {
            switch (target) {
                case "g":
                    result = (Double.valueOf(num) * 1000) + "";
                    break;
                case "t":
                    result = (Double.valueOf(num) / 1000) + "";
                    break;
            }
        } else if ("t".equals(current)) {
            switch (target) {
                case "kg":
                    result = (Double.valueOf(num) * 1000) + "";
                    break;
                case "g":
                    result = (Double.valueOf(num) * Math.pow(10, 6)) + "";
                    break;
            }
        }
        return result;
    }

    /**
     * 长度转化
     *
     * @param current
     * @param target
     * @param num
     * @return
     */
    private static String lengthConversion(String current, String target, String num) {
        String result = null;
        //double med
        if ("cm".equals(current)) {
            switch (target) {
                case "m":
                    result = (Double.valueOf(num) / 100) + "";
                    break;
                case "km":
                    result = (Double.valueOf(num) / Math.pow(10, 5) + "");
                    break;
            }
        } else if ("m".equals(current)) {
            switch (target) {
                case "cm":
                    result = (Double.valueOf(num) * 100) + "";
                    break;
                case "km":
                    result = (Double.valueOf(num) / 1000) + "";
                    break;
            }
        } else if ("km".equals(current)) {
            switch (target) {
                case "cm":
                    result = ((Double.valueOf(num)) * Math.pow(10, 5)) + "";
                    break;
                case "m":
                    result = (Double.valueOf(num) * 1000) + "";
                    break;
            }
        }

        return result;
    }
}
