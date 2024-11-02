# Parcial-Desarrollo-De-Software

 Nombre: Camila Villarreal
 Legajo:45390
 Curso: 3K09

 Arquitectura del sistema:

 ![image](https://github.com/user-attachments/assets/a8e8d323-b3a4-4aab-993f-65e72484eae9)



 Instrucciones:
 1. Descague el proyecto y dirijase a la parte de Parcial-Desarrollo-De-Software/api-rest/src/main/java/com/APIREST/
 2. Abra y ejecute el programa ApiRestAplication.java
 3. Instale H2 e ingrese los siguientes datos:
 ![image](https://github.com/user-attachments/assets/6311ac17-89a1-453f-a668-e26d9eef4f0e)

Puede observar Las tablas existentes del programa UNA VEZ YA EJECUTADO:
![image](https://github.com/user-attachments/assets/4c1c59b1-9b4f-4de7-8ca5-e65c1298e904)


4. Ingrese a Postman y a continuación:
  a. Coloque la dirección de puerto en pantalla de la imagen y Seleccione POST
![image](https://github.com/user-attachments/assets/a6622360-44f9-4134-b503-9f102c0bd1f9)

  b. Dirijase en la parte de Body e ingrese:

{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

Al tratarse de un ejemplo correcto, se encontrará con el mensaje OK

  c. Ahora ingrese:

{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CDDCTA","TCACTG"]
}

Al tratarse de un ejemplo incorrecto, se encontrará con el mensaje FORBIDDEN

![image](https://github.com/user-attachments/assets/ae172262-aadc-4055-b4f3-dd60f2c0ed89)

![image](https://github.com/user-attachments/assets/441543c3-86b6-4056-b50b-ef212a1d7863)



d. Finalmente ingrese dirección de puerto en pantalla y Seleccione GET

![image](https://github.com/user-attachments/assets/9dcad06e-baf0-4368-9785-d75efa934496)

5. En la parte Parcial-Desarrollo-De-Software/api-rest/src/test/java/com/APIREST/Services/
6. Abra y ejecute el programa ADNControllerTest.java
7. Haga click en Run para ver los 3 test a ejecutar y el resultado al final
![image](https://github.com/user-attachments/assets/e788b648-96f6-47f2-8b82-5a8e56a859dc)

¡Muchas gracias por descargar y ver este proyecto! C:

