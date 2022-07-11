package com.lis.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class NumberUtil {

        /**
         * 保留小数点
         * @param d
         * @return
         */
        public static double formatDouble(double d,int Scale) {
            return new BigDecimal(d).setScale(Scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        }



        /**
         * 元 转 分 -- 保证精度准确
         * @param price
         * @return
         */
        public static int yuanToFen(double price){
            return (int) Double.parseDouble(BigDecimal.valueOf(price).multiply(new BigDecimal(100)).toString());
        }

        /**
         * 元转分，确保price保留两位有效数字
         * @return
         */
        public static int changeY2F(double price) {
            DecimalFormat df = new DecimalFormat("#.00");
            price = Double.valueOf(df.format(price));
            int money = (int)(price * 100);
            return money;
        }

        /**
         * 分转元，转换为bigDecimal在toString
         * @return
         */
        public static double changeF2Y(int price) {
            return BigDecimal.valueOf(Double.valueOf(price * 1.0)).divide(new BigDecimal(100)).doubleValue();
        }

        public static double changeFL2YDouble(long price) {
            return BigDecimal.valueOf(Double.valueOf(price * 1.0)).divide(new BigDecimal(100)).doubleValue();
        }

        /**
         * 分(long)转元(double)，转换为bigDecimal在toString
         * @return
         */
        public static String changeFL2Y(double price, int scale) {
            DecimalFormat df = new DecimalFormat("0.00");

            return df.format(BigDecimal.valueOf(Double.valueOf(price * 1.0)).divide(new BigDecimal(100)).doubleValue());
        }

        public static double changeF2Y(double price) {
            return BigDecimal.valueOf(Double.valueOf(price * 1.0)).divide(new BigDecimal(100)).doubleValue();
        }

        public static BigDecimal changeF2Y2(int price) {
            BigDecimal fen = new BigDecimal(price);
            return fen.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
        }

        /**
         * @Description 分转元
         * @param price
         * @return java.lang.String
         * @Date 2020-04-16 14:27
         */
        public static String translateF2Y (Integer price) {
            if(price != null){
                DecimalFormat df = new DecimalFormat("0.00");
                return df.format(BigDecimal.valueOf(Double.valueOf(price * 1.0)).divide(new BigDecimal(100)).doubleValue());
            }else {
                return "0.00";
            }
        }
    }

