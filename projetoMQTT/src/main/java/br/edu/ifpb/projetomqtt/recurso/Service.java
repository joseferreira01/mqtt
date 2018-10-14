/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetomqtt.recurso;

import ifpb.ads.mqtt.PublishMQTT;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 *
 * @author jose
 */
@Singleton
public class Service {
    private  String status;
    @EJB
    private PublishMQTT mQTT;

    public Service() {
        
    }

    public  String getStatus() {
        return status;
    }

    public  void setStatus(String status) {
        status = status;
    }

    @Override
    public String toString() {
        return status;
    }

  public  int ligarDesliga(String comando) {
      int retono =-1;
      if("ligar".equalsIgnoreCase(comando)){
          status="ligado";
          retono=1;
          this.mQTT.enviar(retono);
      }
      else   if("desligar".equalsIgnoreCase(comando)){
          status="desligado";
          retono=0;
           this.mQTT.enviar(retono);
      }
          status="comando não encontrado";
          
      return retono;
        
    }
    
    
    
}
