package com.example.demo.Mail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

@Controller
public class MailController {

//    @Autowired
//    JavaMailSender mailSender;


    @GetMapping("/forgot")
    public String ForgotPassPage()
    {
        return "forgot";
    }

    @PostMapping("/forgot")
    public String GetPass(HttpServletRequest request)
    {

        String username = "daylataikhoanguiemail@gmail.com";
        String password = "nmwawbjhihmeebkj";

        // Get system properties
        Properties properties = new Properties();

        // Setup mail server
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");


        Session session = Session.getInstance(properties,new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        try {
            String email = request.getParameter("email");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(email)
            );
            message.setSubject("YOUR PASSWORD");
            message.setText("pass");
            Transport.send(message);

        }catch (Exception e)
        {
            System.out.println(e);
        }



        return "redirect:/forgot";
    }
}
