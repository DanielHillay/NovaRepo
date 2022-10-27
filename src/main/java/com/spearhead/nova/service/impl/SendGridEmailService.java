package com.spearhead.nova.service.impl;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.spearhead.nova.model.User;

@Service
public class SendGridEmailService {


    @Value("${sendGrid.api.key}")
    public String sendGridKey;

    @Value("${spring.mail.username}")
    private String EMAIL_SENDER;


    public void sendGridNotificationLogin(String OTP, String email) {


        try {
            String msg = "<p> Hello  </p>"
                    + "<p> For Security reason you're required to use the following One-Time Password to login </p>"
                    + "<p><b>" + OTP + "</b></p>" + "<br>"
                    +"<p> Note: This OTP will expire in 5 minutes";

            String subject = "NOVA OTP Verification";

            Content content = new Content("text/html", msg);

            sendEmail(EMAIL_SENDER, email, subject, content);

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendGridNotification(User user) {


        try {
            String msg = "<p> Hello  </p>"
                    + "<p> You are welcome to Nova </p>"
                    + "<p><b>" + user.getFirstName() + "</b></p>" + "<br>"
                    +"<p> Note: This is the name of the registered user";

            String subject = "NOVA Registration";

            Content content = new Content("text/html", msg);

            sendEmail(EMAIL_SENDER, user.getEmail(), subject, content);

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Response sendEmail(String from, String to, String subject, Content content) {
        Mail mail = new Mail(new Email(from), subject, new Email(to), content);
        //mail.setFrom(new Email("evansa@demandinc.ng"));
        Request request = new Request();

        Response response = null;


        SendGrid sendGridClient = new SendGrid(sendGridKey);
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response =  sendGridClient.api(request);
            System.out.println(response.getBody());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return response;
    }

}
