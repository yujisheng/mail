package com.soft863.framework.config;

import com.soft863.framework.Util.MailUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * @Auther: Song Kun
 * @Date: 2019/3/15 10:30
 * @Description: 邮件发送实体类
 */
@ConfigurationProperties(prefix = "blsf.mail")
public class MailInfo {
    /**
     * 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
     */
    private String fromMail;
    private String frompassword;
    /**
     * 发件人名称
     */
    private String fromName;
    /**
     * 收件人邮箱（替换为自己知道的有效邮箱）
     */
    private String[] toAddress;
    /**
     * 抄送人邮箱
     */
    private String[] ccAddress;
    /**
     * 邮件主题/标题
     */
    private String subject;
    /**
     * 邮件文本内容
     */
    private String content;
    /**
     * 附件的本地存储位置
     */
    private String[] attachFile;
    /**
     * 图片的本地存储位置
     */
    private String[] imagePath;
    /**
     * 是否需要身份验证
     */
    private boolean authValidate = true;
    /**
     * 是否提供SSL链接
     */
    private boolean starttlsEnable = true;
    private boolean starttlsRequired = true;

    public String getFromMail() {
        return fromMail;
    }

    public void setFromMail(String fromMail) {
        this.fromMail = fromMail;
    }

    public String getFrompassword() {
        return frompassword;
    }

    public void setFrompassword(String frompassword) {
        this.frompassword = frompassword;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String[] getToAddress() {
        return toAddress;
    }

    public void setToAddress(String[] toAddress) {
        this.toAddress = toAddress;
    }

    public String[] getCcAddress() {
        return ccAddress;
    }

    public void setCcAddress(String[] ccAddress) {
        this.ccAddress = ccAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getAttachFile() {
        return attachFile;
    }

    public void setAttachFile(String[] attachFile) {
        this.attachFile = attachFile;
    }

    public String[] getImagePath() {
        return imagePath;
    }

    public void setImagePath(String[] imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isAuthValidate() {
        return authValidate;
    }

    public void setAuthValidate(boolean authValidate) {
        this.authValidate = authValidate;
    }

    public boolean isStarttlsEnable() {
        return starttlsEnable;
    }

    public void setStarttlsEnable(boolean starttlsEnable) {
        this.starttlsEnable = starttlsEnable;
    }

    public boolean isStarttlsRequired() {
        return starttlsRequired;
    }

    public void setStarttlsRequired(boolean starttlsRequired) {
        this.starttlsRequired = starttlsRequired;
    }

    /**
     * 创建参数配置, 用于连接邮件服务器的参数配置
     *
     * @return
     */
    public Properties getProperties() {
        Properties p = new Properties();
        p.put("mail.smtp.host", new MailUtil().getSMTP(fromMail));
        // p.put("mail.smtp.port", "465");
        p.put("mail.smtp.auth", authValidate ? "true" : "false");
        p.put("mail.transport.protocol", "smtp");
        /**
         * 使用的协议（JavaMail规范要求）
         */
        p.put("mail.smtp.starttls.enable", "true");
        /**
         * 开启SSL
         */
        p.put("mail.smtp.starttls.required", "true");
        return p;
    }


}
