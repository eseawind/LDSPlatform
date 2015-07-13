/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leedarson.entities.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ouxiaodong
 */
public class EntityUtil {
    public static String objectToString(Object o) {
        return o==null || o.toString().isEmpty() ? null : o.toString();
    }
    public static Long objectToLong(Object o) {
        return o==null || o.toString().isEmpty() ? null : Long.valueOf(o.toString());
    }
    public static Short objectToShort(Object o) {
        return o==null || o.toString().isEmpty() ? null : Short.valueOf(o.toString());
    }
    public static BigDecimal objectToBigDecimal(Object o) {
        return o==null || o.toString().isEmpty() ? null : new BigDecimal(o.toString());
    }
    public static BigInteger objectToBigInteger(Object o) {
        return o == null || o.toString().isEmpty() ? null : new BigInteger(o.toString());
    }
    public static Date objectToDate(Object o) {
        Date date = null;
        if(o != null && !o.toString().isEmpty()) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                date = format.parse(o.toString());
            } catch (ParseException ex) {
                Logger.getLogger(EntityUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return date;
    }
    public static Boolean objectToBoolean(Object o) {
        boolean result = false;
        if(o != null && !o.toString().isEmpty()) {
            if(Integer.valueOf(o.toString()) > 0) {
                result = true;
            }
        }
        
        return result;
    }
    public static void main(String[]args) {
//        System.out.print(objectToBigDecimal("31.266667"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.println(format.parse(format.format(new Date()).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(EntityUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
