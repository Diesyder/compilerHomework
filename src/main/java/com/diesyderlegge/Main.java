package com.diesyderlegge;

import java.util.Scanner;

/**
 * @author Diesyder
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("本程序可用于判断输入内容是否为小数。");
        System.out.print("请输入要判断的数值：");
        String input = scan.nextLine();

        // 获得判断状态
        String state = judgeNum(input, input.length());

        // 输出返还的状态
        System.out.print("判断结果：");
        if ("Integral".equals(state)) {
            System.out.println("输入的是整数");
        } else if ("Fractional".equals(state)) {
            System.out.println("输入的是小数");
        } else {
            System.out.println("输入的既不是整数也不是小数");
        }
    }

    public static String judgeNum(String num, int len) {
        String state = "start";
        for (int i = 0; i < len; i++) {
            switch (state) {
                // 开始时判断符号
                case "start" :
                    if (num.charAt(i) == '+' || num.charAt(i) == '-') {
                        state = "Integral";
                    } else if (num.charAt(i) >='0' && num.charAt(i) <='9') {
                        state = "Integral";
                    } else {
                        return "error";
                    }
                    break;
                // 不断判断是小数点还是整数还是其他数字
                case "Integral" :
                    if (num.charAt(i) >='0' && num.charAt(i) <='9') {
                        state = "Integral";
                    } else if (num.charAt(i) == '.') {
                        state = "Fractional";
                    } else {
                        return "error";
                    }
                    break;
                // 判断是否为小数还是不是数值
                case "Fractional" :
                    if (num.charAt(i) >='0' && num.charAt(i) <='9') {
                        state = "Fractional";
                    } else {
                        return "error";
                    }
                    break;
                default:
                    return "error";
            }
        }
        // 返回判断状态
        return state;
    }
}