package com.jzy.erpboot.system.common;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.UUID;

/**
 * @program: 0812erp
 * @author: shuke
 * @create: 2020-01-08 16:36
 **/

public class MD5Utils {


    /**
     * 生成uuid
     * @return
     */
    public static String createUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 加密
     * @param source
     * @param slat
     * @param hashIterations
     * @return
     */
    public static String md5(String source,String slat,Integer hashIterations){
        Md5Hash hash=new Md5Hash(source,slat,hashIterations);
        return hash.toString();
    }



}
