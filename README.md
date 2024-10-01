
1. EDWARD CAMILO SANCHEZ NOVOA - 202113020
2. ESTEBAN HERNANDEZ - 202316637
3. SEBASTIAN MALDONADO - 202311840



INSTRUCCIONES README 
1. Introducción
¿Qué aprenderá?
Al finalizar este tutorial el estudiante estará en capacidad de ejecutar el documento 
¿Qué necesita?
Para realizar esta prueba ud debe:
1.	Tener una conexión a internet.
2.	Un equipo con sistema operativo Windows 10 u 11.
3.	Manejo básico de la consola de comandos.
4.	Tener instalado git.
5.	Tener clonado el repositorio.
6.	Tener Oracle y postman activos.



2. Descargar Oracle, Visual Studio Code:
Para poder manipular la base de datos ud debe tener en cuenta el funcionamiento de la base de datos. 
Ejecute el instalador y deje las opciones por defecto.



3. Clonar el repositorio y crear la Imagen
Clone el repositorio con el siguiente comando:

https://github.com/Camilo2816/ProyectoSISTRANS.git
Activelo en Visual Studio Code para poder acceder al código de la base de datos. Una vez lo haga, debería verse a algo parecido así:

 

Una vez lo haga, debe ingresar a la pestaña Spring y realizar una inspección de la funcionalidad del programa, si sale todo correcto debería verse así:
 




4. Verificar la ejecución del backend
Para confirmar el correcto funcionamiento de la aplicación abra la siguiente url desde un navegador:
http://localhost:8080/api/



Una vez cumpla con esto, puede tener el código base del código para poder accionar lo demás



5. Entrar a la base de datos de Oracle

Ingrese los siguientes datos para poder accionar el sistema en Oracle 
spring.datasource.url=jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD
spring.datasource.username=ISIS2304A27202420
spring.datasource.password=SrFSChbQxm


Ingrese los datos de Url, el usuario y la contraseña en Oracle para poder ingresar a la base de datos. 


Una vez lo haga, debe aparecer exactamente esto:
 
Con esto podrá acceder al portafolio de tablas de la base de datos y con esto lograr ejecutar los cambios.
