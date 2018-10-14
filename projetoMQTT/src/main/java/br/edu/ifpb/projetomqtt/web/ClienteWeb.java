package br.edu.ifpb.projetomqtt.web;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2018, 11:24:10
 */
public class ClienteWeb {

    private String uri = "http://localhost:8080/projetoMQTT/api/lampada/";
    private Client client = ClientBuilder.newClient();
    private WebTarget root = client.target(uri);

    public int lerComando() {
        return root
                .request()
                .get(Integer.class);
        
    }

    void enviar(String comando) {
        root.path("comando").resolveTemplate("comando", comando)
                .request()
                .get(Integer.class);
    }
}

