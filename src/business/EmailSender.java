/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 * Class in charge of sending emails
 * @author erick
 */
public class EmailSender {
    
    /*
     * TODO: implement
     * Sends email with message
     * @param toEmail email of the recipient
     * message message to sen
    */
    public static void sendEmail(String toEmail, String message) {
        /*
        String to = toEmail;

        String from = "erickcsh@gmail.com";

        String host = "localhost";

        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", host);


        try{
           MimeMessage message = new MimeMessage(message);

           message.setFrom(new InternetAddress(from));

           message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

           message.setSubject("This is the Subject Line!");

           message.setText("This is actual message");

           Transport.send(message);
           System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
           mex.printStackTrace();
        }
        */
    }
    
}
