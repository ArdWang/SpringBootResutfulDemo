package com.ril.rilcompany.utils;

import java.util.Random;

/**
 * Classname RandomChar
 * Description 生成随机数字
 * Date 2019/6/5 17:59
 * Created by Administrator
 */
public class RandomChar {
    public static String getRandomChar(int length) {
        //生成随机字符串
        char[] chr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            buffer.append(chr[random.nextInt(20)]);
        }
        return buffer.toString();
    }
}
