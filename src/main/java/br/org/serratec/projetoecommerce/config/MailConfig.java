package br.org.serratec.projetoecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
    
    @Autowired
    private JavaMailSender javaMailSender;

    public void confirmacaoCadastroCliente(String para, String assunto, String texto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("tdois.it@gmail.com");
        simpleMailMessage.setTo(para);
        simpleMailMessage.setSubject(assunto);
        simpleMailMessage.setText("");
        javaMailSender.send(simpleMailMessage);
    }

    public void exclusaoCadastroCliente(String para, String assunto, String texto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("tdois.it@gmail.com");
        simpleMailMessage.setTo(para);
        simpleMailMessage.setSubject(assunto);
        simpleMailMessage.setText("");
        javaMailSender.send(simpleMailMessage);
    }

    public void confirmacaoCompra(String para, String assunto, String texto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("tdois.it@gmail.com");
        simpleMailMessage.setTo(para);
        simpleMailMessage.setSubject(assunto);
        simpleMailMessage.setText("");
        javaMailSender.send(simpleMailMessage);
    }
}
