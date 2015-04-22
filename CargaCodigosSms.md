#Secuencia de carga de créditos mandando código alfanumérico a empresa de celulares.

- Se hace por medio de WebServices.
- La empresa de celulares deberá poseer una conexión a un Webservice que permita insertar y consultar datos de la base de clientes y productos.

Circuito:

1) El cliente ingresa un código, y manda el mensaje de texto.
2) La empresa posee una base de datos que permite matchear el cliente del site con su cliente abonado.
3) La aplicación de la empresa que recibe los datos, consume un WebService consultando la existencia de este cliente, y valida el código Alfanumérico.
4) Si está OK, consume nuevamente el Webservice insertando el registro correspondiente.
5) El usuario ya tiene cargado el crédito correspondiente.


Esto es a grandes rasgos. Es solamente una explicación porque esto no corre por cuenta nuestra (no nos vamos a meter a hacer un WS).