//http://mitsuruog.github.io/what-mqtt/
// docker run -ti -p 1883:1883 -p 9001:9001 toke/mosquitto
var mqtt    = require('mqtt');
 var client  = mqtt.connect('ws://iot.eclipse.org:80/ws');
//var client  = mqtt.connect('ws://localhost:9001');
var  flagEnviar = true;


var iv = setInterval( 
    function() {
      if(flagEnviar==1){
        var randInt = Math.floor(Math.random()*100);
        client.publish('sensor/lampada', ''+1);
        console.log('msg:','desligado');
      }
      else if(flagEnviar==0){ client.publish('sensor/lampada', ''+0);
      console.log('msg:','ligado');
    }
    }, 2000 
  );

client.on('connect', function () {
  client.subscribe('atuador/lampada');
});

client.on('message', function (topic, message) {
  console.log("recebendo: ",message.toString());
  flagEnviar  = message.toString();
});