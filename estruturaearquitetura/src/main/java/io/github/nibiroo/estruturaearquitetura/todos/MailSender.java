package io.github.nibiroo.estruturaearquitetura.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void enviar (String mensagem) {
        System.out.println("Enviado e-mail: "+mensagem);
    }
}
