package com.soft863.framework.Util;

/**
 * @Auther: Song Kun
 * @Date: 2019/3/14 11:46
 * @Description:
 */
public class MailUtil {

    //确认发件人于思邮箱的 SMTP 服务器地址
    public String getSMTP(String myEmailAccount) {
        String myEmailSMTPHost = "";
        String[] split = myEmailAccount.split("@");
        if (split[1].equals("qq.com")) {
            myEmailSMTPHost = "smtp.qq.com";
        } else if (split[1].equals("163.com")) {
            myEmailSMTPHost = "smtp.163.com";
        } else if (split[1].equals("126.com")) {
            myEmailSMTPHost = "smtp.126.com";
        }

        return myEmailSMTPHost;
    }


}
