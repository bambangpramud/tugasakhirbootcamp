/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 12/2/2022  3:06 PM
Last Modified on 12/2/20223:06 PM
Version 1.0
*/



package com.bcafinance.core;

import com.bcafinance.configuration.ConfigProperties;
import com.bcafinance.handler.ResourceNotFoundException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class SMTPCore {

    Properties prop ;
    private Message message ;
    private Session session;
    private String strDestination;
    private StringBuilder sBuild ;
    private MimeBodyPart messageBodyPart;
    private Multipart multipart;

    public SMTPCore()
    {
        sBuild = new StringBuilder();
    }

    private Properties getTLSProp()
    {
        prop = new Properties();
        prop.put("mail.smtp.host", ConfigProperties.getEmailHost());
        prop.put("mail.smtp.port", ConfigProperties.getEmailPortTLS());
        prop.put("mail.smtp.auth", ConfigProperties.getEmailAuth());
        prop.put("mail.smtp.starttls.enable", ConfigProperties.getEmailStartTLSEnable());

        return prop;
    }

    private Properties getSSLProp()
    {
        prop = new Properties();
        prop.put("mail.smtp.host", ConfigProperties.getEmailHost());
        prop.put("mail.smtp.port", ConfigProperties.getEmailPortSSL());
        prop.put("mail.smtp.auth", ConfigProperties.getEmailAuth());
        prop.put("mail.smtp.socketFactory.port", ConfigProperties.getEmailStartTLSEnable());
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        return prop;
    }

    public boolean sendSimpleMail(String[] strMailTo, String strSubject, String strContentMessage, String strLayer) throws ResourceNotFoundException {
        Properties execProp ;
        try {

            if(strLayer.equals("SSL")) {
                execProp = getSSLProp();
            }
            else
            {
                execProp = getTLSProp();
            }

            sBuild.setLength(0);
            for(int i=0;i<strMailTo.length;i++)
            {
                sBuild.setLength(0);
                strDestination = sBuild.append(strMailTo[i]).toString();

                if(i != strMailTo.length-1)
                {
                    sBuild.setLength(0);
                    strDestination = sBuild.append(strDestination).append(",").toString();
                }

            }

            session = Session.getInstance(execProp,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(ConfigProperties.getEmailUserName(), ConfigProperties.getEmailPassword());
                        }
                    });

            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(ConfigProperties.getEmailUserName()));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(strDestination)
            );
            message.setSentDate(new Date());

            /*BODY OF MAIL*/
            message.setSubject(strSubject);
            message.setText(strContentMessage);

            Transport.send(message);
            System.out.println("Done");

        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }

        return true;
    }

    public boolean sendMailWithAttachment(String[] strMailTo, String strSubject, String strContentMessage,
                                          String strLayer, String[] attachFiles) throws ResourceNotFoundException {
        Properties execProp ;


        if(strLayer.equals("SSL")) {
            execProp = getSSLProp();
        }
        else
        {
            execProp = getTLSProp();
        }

        sBuild.setLength(0);
        for(int i=0;i<strMailTo.length;i++)
        {
            sBuild.setLength(0);
            strDestination = sBuild.append(strMailTo[i]).toString();

            if(i != strMailTo.length-1)
            {
                sBuild.setLength(0);
                strDestination = sBuild.append(strDestination).append(",").toString();
            }

        }
        session = Session.getInstance(execProp,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(ConfigProperties.getEmailUserName(), ConfigProperties.getEmailPassword());
                    }
                });


        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(ConfigProperties.getEmailUserName()));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(strDestination)
            );
            message.setSentDate(new Date());
            message.setSubject(strSubject);

            // creates message part
            messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(strContentMessage, "text/html");

            // creates multi-part
            multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // adds attachments
            if (attachFiles != null && attachFiles.length > 0) {
                for (String filePath : attachFiles) {
                    MimeBodyPart attachPart = new MimeBodyPart();

                    try {
                        attachPart.attachFile(filePath);
                    } catch (Exception ex) {
                        throw new Exception(ex.getMessage());
                    }
                    multipart.addBodyPart(attachPart);
                }
            }

            // sets the multi-part as e-mail's content
            message.setContent(multipart);

            // sends the e-mail
            Transport.send(message);

        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }

        return true;
    }
}