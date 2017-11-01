package com.fdmgroup.JCollegeAppProject.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.JCollegeAppProject.utilities.MailMail;

public class EmailTestRunner {

	
	public static void main( String[] args )
    {
    	ApplicationContext context =
             new ClassPathXmlApplicationContext();

    	MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("umar.wong@fdmgroup.com",
    		   "KamranAhmed.Adnan@fdmgroup.com",
    		   "Testing123",
    		   "Testing only \n\n Hello Spring Email Sender");

    }
	
	
	
	
	
	
	
	
	
	
}
