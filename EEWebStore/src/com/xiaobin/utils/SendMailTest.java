package com.xiaobin.utils;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class SendMailTest {

	public static void main(String[] args) throws AddressException, MessagingException {
		
		MailUtils.sendMail("xiaobin3@asiainfo.com","这是一封测试邮件");

	}
	
}
