# CRUD usando los principios reactivos y webflux

Proyecto realizado en Spring Boot con las siguientes dependencias:

* Spring Data Reactive MondoDB
* Spring Reactive Web
* Sprig Boot Dev Tools

![](src/main/resources/img/springInitializer.png)

CRUD con Spring Boot y MongoDB usando los principios reactivos y webflux,
donde usamos el modelo de un trabajador, con los atributos :

* id
* nombre
* edad
* activo

Sobre los cuales podemos trabajar con los metodos de :

* Post - guardar : /trabajador
* Delete - borrar  : /borrar/{id}
* Delete - borrar Todos : /borrartodos
* Put - actualizar : /actualizar/{id}
* Get - listar Todos : /trabajadores
* Get - listar por Id : /listarid/{id}
* Get - ver trabajadores activos : /activos

URL del despliegue : https://crudreactivafuncional-production.up.railway.app/trabajadores