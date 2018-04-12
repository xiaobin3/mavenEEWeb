package com.xiaobin.httpServletResponse.utils;

import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * @Author: xiaobin3
 * @Description:
 * @Date: Created in 16:15 2018/4/12
 * @Modified by:
 */
public class FileUtil {

    public static String fileNameEncoderUtil(String agent,String fileName)  throws IOException {
        //根据不同浏览器进行不同的编码
        String filenameEncoder = "";
        if (agent.contains("MSIE")) {
            // IE浏览器
            filenameEncoder = URLEncoder.encode(fileName, "utf-8");
            filenameEncoder = filenameEncoder.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filenameEncoder = "=?utf-8?B?"
                    + base64Encoder.encode(fileName.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filenameEncoder = URLEncoder.encode(fileName, "utf-8");
        }
        return filenameEncoder;
    }
}
