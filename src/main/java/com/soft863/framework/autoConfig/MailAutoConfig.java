package com.soft863.framework.autoConfig;

import com.soft863.framework.Mail;
import com.soft863.framework.config.MailInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MailAutoConfig
 * @Author
 * @Date 2019/3/20 0020 18:34
 */
@Configuration
@EnableConfigurationProperties(MailInfo.class)
@ConditionalOnClass(Mail.class)
@ConditionalOnProperty(prefix = "blsf.mail", value = "enable", matchIfMissing = true)
public class MailAutoConfig {

    @Autowired
    private MailInfo mailInfo;

    /*@Bean
    @ConditionalOnMissingBean(Mail.class)
    public Mail mail(){
        Mail mail = new Mail();
        mail.setFromMail(mailInfo.getFromMail());
        mail.setFrompassword(mailInfo.getFrompassword());
        mail.setFromName(mailInfo.getFromName());
        mail.setToAddress(mailInfo.getToAddress());
        mail.setCcAddress(mailInfo.getCcAddress());
        mail.setSubject(mailInfo.getSubject());
        mail.setContent(mailInfo.getContent());
        mail.setImagePath(mailInfo.getImagePath());
        mail.setAttachFile(mailInfo.getAttachFile());
        mail.setAuthValidate(mailInfo.isAuthValidate());
        mail.setStarttlsEnable(mailInfo.isStarttlsEnable());
        mail.setStarttlsRequired(mailInfo.isStarttlsRequired());
        return mail;
    }*/

    @Bean
    @ConditionalOnMissingBean(Mail.class)
    public Mail mail() {
        Mail mail = new Mail();
        mail.setMailInfo(mailInfo);
        return mail;
    }

}
