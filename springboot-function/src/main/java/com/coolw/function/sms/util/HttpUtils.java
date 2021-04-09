package com.coolw.function.sms.util;

import com.coolw.function.sms.config.MDYConfig;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Classname HttpUtils
 * @Description
 * @Date 2021/4/9 16:15
 * @Author lw
 */
public class HttpUtils {

    /**
     * 构造通用参数timestamp、sig和respDataType
     */
    public static String createCommonParam() {
        // 时间戳
        long timestamp = System.currentTimeMillis();
        // 签名
        String sig = DigestUtils.md5Hex(MDYConfig.ACCOUNT_SID + MDYConfig.AUTH_TOKEN + timestamp);
        return "&timestamp=" + timestamp + "&sig=" + sig + "&respDataType=" + MDYConfig.RESP_DATA_TYPE;
    }

    /**
     * post请求
     *
     * @param url  功能和操作
     * @param body 要post的数据
     */
    public static String post(String url, String body) {
        System.out.println("body:" + System.lineSeparator() + body);

        String result = "";
        try {
            OutputStreamWriter out = null;
            BufferedReader in = null;
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();

            // 设置连接参数
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(20000);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 提交数据
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(body);
            out.flush();

            // 读取返回数据
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = "";
            boolean firstLine = true; // 读第一行不加换行符
            while ((line = in.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                } else {
                    result += System.lineSeparator();
                }
                result += line;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 回调测试工具方法
     */
    public static String postHuiDiao(String url, String body) {
        String result = "";
        try {
            OutputStreamWriter out = null;
            BufferedReader in = null;
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();

            // 设置连接参数
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(20000);

            // 提交数据
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(body);
            out.flush();

            // 读取返回数据
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = "";
            boolean firstLine = true; // 读第一行不加换行符
            while ((line = in.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                } else {
                    result += System.lineSeparator();
                }
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
