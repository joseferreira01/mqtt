package br.edu.ifpb.projetomqtt.web;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2018, 11:17:49
 */
@Named
@RequestScoped
public class Controlador {

   

    private ClienteWeb service = new ClienteWeb();
    @PostConstruct
public void init(){
    carregar();
}
    private String status;
    private String comando;

    public String carregar() {
        int retono = service.lerComando();
        if(retono==1)
            status ="ligado";
            status ="desligado";
       
        return null;
    }
    public String enviar(){
        service.enviar(comando);
        return null;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
}
