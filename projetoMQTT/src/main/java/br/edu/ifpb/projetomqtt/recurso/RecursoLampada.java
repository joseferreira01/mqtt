/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetomqtt.recurso;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jose
 */
@Stateless
@Path("lampada")
@Produces(MediaType.APPLICATION_JSON)
public class RecursoLampada {
    
    private Service service = new Service();
    @GET
    public Response todos() {

 return Response.ok() //200
                .entity(service.getStatus())
                .build();


    }

    // ../vendas/1323
    @GET
    @Path("{comando}")
    public Response comando(
            @PathParam("comando") String comando) {

        int retono = service.ligarDesliga(comando);
        if (retono== -1) {
            return Response.noContent().build();
        }
        System.err.println("serviço "+retono);
        return Response.ok() //200
                .entity(retono)
                .build();

    }
}
