package com.test;

import java.math.BigDecimal;

/**
 * @auther liuyiming
 * @date 2021/6/28 20:29
 * @description
 */
public class Hex {
    public static String convertHexToString(String hex) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < hex.length() - 1; i += 2) {
            String output = hex.substring(i, (i + 2));
            int decimal = Integer.parseInt(output, 16);
            sb.append((char) decimal);
            temp.append(decimal);
        }
        return sb.toString();
    }

    /**
     * 26445a2034201e30373237323131383332203234
     * D/AikeActivity: getCallBackValue: 接受数据：322030201e303732373231313530382032333820
     * D/AikeActivity: getCallBackValue: 接受数据：30201e3037323732313135303220392030201e30
     * D/AikeActivity: getCallBackValue: 接受数据：343033313930373030203134372030201e063337
     * D/AikeActivity: getCallBackValue: 接受数据：3531320d
     * @param args
     */
//&DZ 3                    0727211508 238 0 0727211502 9 0 0403190700 147 0 51913
//&DZ 4 0727211832 242 0 0727211508 238 0 0727211502 9 0 0403190700 147 0 37512
    public static void main(String[] args) {
//        String str = "26445a2033201e30373237323131353038203233382030201e3037323732313135303220392030201e30343033313930373030203134372030201e0635313931330d";
//        String str = "203020";
//        String str = "26445a2034201e30373237323131383332203234322030201e30373237323131353038203233382030201e3037323732313135303220392030201e30343033313930373030203134372030201e0633373531320d";
//        String s = convertHexToString(str);

        String[] strs = new String[]{"26445a2034201e30373237323131383332203234","322030201e303732373231313530382032333820","30201e3037323732313135303220392030201e30","343033313930373030203134372030201e063337","3531320d","111"};
        String str = "";

        for (int i = 0; str.indexOf("0d")==-1; i++) {
            str +=strs[i];
        }
        System.out.println(str);

//        System.out.println(test(str));

    }

    public static String getresult(String str){

        String[] strs = str.split("203020"); //每组数据以203020

        if (strs[0].length()>60){
            //42 第一串大于42的情况下，重置测量
            throw new RuntimeException();
        }
        String[] split = strs[0].split("20");
        Integer num = Integer.parseInt(convertHexToString(split[3].trim()));
        BigDecimal bigDecimal = new BigDecimal(num / 18.0);
        double v = bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        return v+"";
    }


}