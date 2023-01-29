package com.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @auther liuyiming
 * @date 2021/6/2 16:40
 * @description
 */
public class Test23333 {

    /**
     * onConnectionUpdated() - Device=C2:18:06:13:04:F2 interval=156 latency=0 timeout=1000 status=0
     * D/BlueToothActivity: onCharacteristicChanged: 接收数据
     * D/BlueToothActivity: 返回数据: 061f00e50706120f0c1a54c011
     * D/BlueToothActivity: onCharacteristicChanged: 解析数据：0.000003152
     */


    /**
     * 2021-06-18 15:03:58.742 4722-4761/com.sunshine.healthcheckup D/BlueToothActivity: onServicesDiscovered: 连接服务回调
     * 2021-06-18 15:03:58.742 4722-4761/com.sunshine.healthcheckup D/BluetoothGatt: setCharacteristicNotification() - uuid: 00002a18-0000-1000-8000-00805f9b34fb enable: true
     * 2021-06-18 15:03:58.760 4722-4761/com.sunshine.healthcheckup D/BlueToothActivity: onDescriptorWrite: 开启监听成功，可进行写入
     * 2021-06-18 15:03:58.824 4722-4761/com.sunshine.healthcheckup D/BluetoothGatt: onConnectionUpdated() - Device=C2:18:06:13:04:F2 interval=36 latency=0 timeout=500 status=0
     * 2021-06-18 15:04:01.062 4722-4761/com.sunshine.healthcheckup D/BluetoothGatt: onConnectionUpdated() - Device=C2:18:06:13:04:F2 interval=156 latency=0 timeout=1000 status=0
     * 2021-06-18 15:04:11.811 4722-4761/com.sunshine.healthcheckup D/BlueToothActivity: onCharacteristicChanged: 接收数据
     * 2021-06-18 15:04:11.812 4722-4761/com.sunshine.healthcheckup D/BlueToothActivity: 返回数据: 061e00e50706120f040153c011
     * 2021-06-18 15:04:11.813 4722-4761/com.sunshine.healthcheckup I/BlueToothActivity: yuwellGlucoseParsing: 血糖数据对应的十六进制字符串:3c50
     * 2021-06-18 15:04:11.815 4722-4761/com.sunshine.healthcheckup D/BlueToothActivity: onCharacteristicChanged: 解析数据：3.152E-7
     *
     * @param args
     * @throws ParseException
     */

    public static void main(String[] args) throws ParseException {


//        061300e5070602111f379ec011
//        String s = "0617 00e5 0706 0309 2222 b0c0 11";
//        String s = "c00e 5070 6120 e1a1 559c 011";
//        String s = "061d 00e5 0706 120e 2a31 5bc0 11";
//        String s = "061d00e50706120e2a315bc011";
//        String s = "061e00e50706120f040153c011";
//        String s = "061f00e50706120f0c1a54c011";
//        System.out.println(yuwellGlucoseParsing(s));


        /**
         *  getCallBackValue: 接受数据：26445a2031201e30383132323131323031203236
         *  getCallBackValue: 接受数据：382030201e0633333738320d
         *  getCallBackValue: 接受数据：26445a2031201e30383132323131323031203236
         * D/BluetoothAdapter: stopLeScan()
         * D/BluetoothAdapter: scan not started yet
         *  getCallBackValue: 接受数据：382030201e0633333738320d
         */

        /**
         * ity: getCallBackValue: 接受数据：26445a2031201e30383132323131323034203237
         * D/BluetoothAdapter: stopLeScan()
         * D/BluetoothAdapter: scan not started yet
         * D/BluetoothGatt: onSearchComplete() = Device=4C:E1:73:C1:31:73 Status=0
         *  onServicesDiscovered: 连接服务回调0
         * D/BluetoothGatt: setCharacteristicNotification() - uuid: 00004a5b-0000-1000-8000-00805f9b34fb enable: true
         *  onServicesDiscovered: 监听设置true
         * E/扫码结果分析: Cancelled
         * D/Tangniaobing2Activity: onActivityResult: resultCode34
         *     onActivityResult: requestCode34
         *  getCallBackValue: 接受数据：332030201e0635303032390d
         */
//        String s = convertHexToString("26445a2031201e30383132323131323031203236382030201e0633333738320d");
        String s = convertHexToString("26445a2031201e30383132323131323034203237332030201e0635303032390d");
        System.out.println(s);

    }

    /**
     * D/BlueToothActivity: onCharacteristicChanged: newString数据：���*1[�
     * 返回数据: 061d00e50706120e2a315bc011
     * D/BlueToothActivity: onCharacteristicChanged: 解析数据：31.52
     * E/扫码结果分析: Cancelled
     * D/Tangniaobing2Activity: onActivityResult: resultCode33
     */

//
//    public static String yuwellGlucoseParsing(String res) {
//        //先获取对应血糖数据的十六进制字符串
//        String str = formatYuwell(res.substring(20, 24));
//
//        //转16进制进行计算
//        String preStr = str.substring(0, 1);
//        String postStr = str.substring(1, 4);
//        int pre = Integer.parseInt(preStr, 16);
//        int post = Integer.parseInt(postStr, 16);
//        BigDecimal postB = new BigDecimal(post);
//        BigDecimal multiply = postB.multiply(new BigDecimal(10 * 10 * 10));
//        double pow = Math.pow(10, 16 - pre);
//        BigDecimal preB = new BigDecimal(pow);
//        BigDecimal divide = multiply.divide(preB);
//
//        return divide.toString();
//    }
//
//
//    public static String formatYuwell(String res) {
//        String[] strs = res.split("");
//
//        String temp = strs[0];
//
//        strs[0] = strs[2];
//        strs[2] = temp;
//        temp = strs[1];
//        strs[1] = strs[3];
//        strs[3] = temp;
//
//        String str = strs[0];
//        for (int i = 1; i < strs.length; i++) {
//            str += strs[i];
//        }
//
//        return str;
//    }
//

    //
    public static String yuwellGlucoseParsing(String res) {
        try {
            String str = formatYuwell(res.substring(20, 24));

            String preStr = str.substring(0, 1);
            String postStr = str.substring(1, 4);
            int pre = Integer.parseInt(preStr, 16);
            int post = Integer.parseInt(postStr, 16);
            BigDecimal postB = new BigDecimal(post);
            BigDecimal multiply = postB.multiply(new BigDecimal(10 * 10 * 10));
            double pow = Math.pow(10, 16 - pre);
            BigDecimal preB = new BigDecimal(pow);
            BigDecimal divide = multiply.divide(preB);
            return divide.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "解析失败,请手动输入或者重新测量！";
        }
    }

    public static String formatYuwell(String res) {
        System.out.println(res.length());
        String[] strs = res.split("");
        String str = "";

        if (strs.length == 5) {
            //0 1234 3 4 1 2
            str = strs[3] + strs[4] + strs[1] + strs[2];
        } else if (strs.length == 4) {
            //0123 2 3 0 1
            str = strs[2] + strs[3] + strs[0] + strs[1];
        }
        return str;
    }

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

     *  接受数据res：26445a2031201e30383132323131323339203239
     *  接受数据result：
     *  接受数据boolear：true
     *  接受数据res：302030201e0632393331320d
     *  接受数据result：26445a2031201e30383132323131323339203239
     *  接受数据boolear：true
     *  接受数据res：26445a2031201e30383132323131323339203239
     *  接受数据result：26445a2031201e30383132323131323339203239302030201e0632393331320d
     *  接受数据boolear：false
     * D/BluetoothAdapter: stopLeScan()
     * D/BluetoothAdapter: scan not started yet
     *  接受数据res：302030201e0632393331320d
     *     接受数据result：26445a2031201e30383132323131323339203239302030201e0632393331320d
     *     接受数据boolear：false
     */

    /**
     *  onConnectionStateChange: 连接状态回调
     * E/AikeActivity: onConnectionStateChange: 设备连接上 开始扫描服务
     * D/BluetoothGatt: discoverServices() - device: 4C:E1:73:C1:31:73
     *  接受数据res：26445a2031201e30383132323131323430203238
     *     接受数据result：
     *     接受数据boolear：true
     * D/BluetoothGatt: onSearchComplete() = Device=4C:E1:73:C1:31:73 Status=0
     *  onServicesDiscovered: 连接服务回调0
     * D/BluetoothGatt: setCharacteristicNotification() - uuid: 00004a5b-0000-1000-8000-00805f9b34fb enable: true
     *  onServicesDiscovered: 监听设置true
     *  接受数据res：332030201e0631303532360d
     *  接受数据res：332030201e0631303532360d
     *  接受数据result：26445a2031201e30383132323131323339203239302030201e0632393331320d
     *  接受数据result：26445a2031201e30383132323131323430203238
     *  接受数据boolear：false
     *  接受数据boolear：true
     */

}

