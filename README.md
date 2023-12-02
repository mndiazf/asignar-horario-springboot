# Agenda Web de disponibilidad de horario de medicos 📅 BACK-END
Aplicación basada en **Angular v 16.2**, **Spring Boot v3.1.5** y **PostgreSQL v16** que proporciona la funcionalidad de generar disponibilidad de horario de atencion de medicos segun fecha y hora por fecha.

## Descripción 🔍

Aplicación web integral para la gestión de disponibilidad de citas médicas, centrándose en la generación y visualización de la disponibilidad de horarios de atención de médicos. La plataforma permitirá a los usuarios, buscar médicos según especialidad, y generar horarios de atencion de los medicos de manera eficiente.

## 🚀 Tecnologías y Dependencias

### Tecnologías principales

- **JDK 17**
- **Spring Boot**: v3.1.5
- **Base de datos**: PostgreSQL v16
- **Administrador de base de datos**: pgAdmin (versión: latest)
- **Docker**: V4.20

### Arquitectura de la aplicacion en la nube AWS - HOSTINGER

![diagrama funcionalidad(1)](https://github.com/mndiazf/agendaWeb/assets/110750463/863a7f38-4fd7-42f9-8ae3-6dc6b457fa59)

### Estado de las aplicaciones en la nube:

FRONT-END en HOSTINGER: <img src="https://github.com/mndiazf/asignar-horario-springboot/assets/110750463/66a879f0-1fe1-4be4-9456-f066f3920c31" alt="Texto Alternativo" width="40"/> 

BACK-END en AWS:   <img src="https://github.com/mndiazf/asignar-horario-springboot/assets/110750463/3182133b-3d41-49e7-bed4-c65c1cf5d055" alt="Texto Alternativo" width="40"/> 


### Dependencias de Maven

```xml
<!-- 
  1. Spring Boot Starter Data JPA:
     - Proporciona configuraciones predeterminadas para la persistencia de datos con JPA.
-->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- 
  2. Spring Boot Docker Compose:
     - Proporciona soporte para ejecutar la aplicación en Docker Compose.
-->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-docker-compose</artifactId>
  <scope>runtime</scope>
  <optional>true</optional>
</dependency>

<!-- 
  3. Spring Boot Starter Web:
     - Proporciona configuraciones predeterminadas para construir aplicaciones web.
-->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- 
  4. PostgreSQL Driver:
     - Proporciona el controlador JDBC para PostgreSQL, necesario para la integración con bases de datos PostgreSQL.
-->
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <scope>runtime</scope>
</dependency>

<!-- 
  5. Spring Boot Starter Validation:
     - Proporciona configuraciones predeterminadas para la validación de datos en Spring Boot.
-->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<!-- 
  6. Project Lombok:
     - Biblioteca que ayuda a reducir la verbosidad del código Java, proporcionando anotaciones para generar automáticamente métodos del código fuente.
-->
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <optional>true</optional>
</dependency>

<!-- 
  7. Spring Boot Starter Test:
     - Proporciona configuraciones predeterminadas para realizar pruebas en aplicaciones Spring Boot.
-->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
```

## Funcionalidades 📐

### Llamar todas las especialidades del medico

**Endpoint**: `http://localhost:8080/api/especialidades/todas`  
**Método**: `GET`

![imagen](https://github.com/mndiazf/asignar-horario-springboot/assets/110750463/e24f07e8-7ec5-4a02-a891-365fb6f2148e)


### Generar horario

**Endpoint**: `http://localhost:8080/api/horarios-trabajo/generarHorario`  
**Método**: `POST`

![imagen](https://github.com/mndiazf/asignar-horario-springboot/assets/110750463/7f406251-ab43-442b-a581-fad7a87b714e)

### Modificar horario 

**Endpoint**: `http://localhost:8080/api/horarios-trabajo/modificarHorario/{id}`  
**Método**: `PUT`

![imagen](https://github.com/mndiazf/asignar-horario-springboot/assets/110750463/ced4ccd7-ce00-417c-a64e-ef07a15cccf9)


### Guardar hora segun fecha

**Endpoint**: `http://localhost:8080/api/horarios-trabajo/guardarHora`  
**Método**: `POST`

![imagen](https://github.com/mndiazf/asignar-horario-springboot/assets/110750463/d55ce65f-c579-4b60-9353-ad2b1b2de956)


### Modificar hora

**Endpoint**: `http://localhost:8080/api/horarios-trabajo/modificarHora/{id}`  
**Método**: `PUT`

![imagen](https://github.com/mndiazf/asignar-horario-springboot/assets/110750463/ad1856d9-7066-493c-8393-869b05e2fa8d)

### Borrar horario de trabajo

**Endpoint**: `http://localhost:8080/api/horarios-trabajo/borrarHorario/{idHorarioTrabajo}`  
**Método**: `DELETE`

![imagen](https://github.com/mndiazf/asignar-horario-springboot/assets/110750463/f610d7a4-3da3-4235-bd55-93135ee6f8a4)

### Borrar hora

**Endpoint**: `http://localhost:8080/api/horarios-trabajo/borrarHora/{idHora}`  
**Método**: `DELETE`

![imagen](https://github.com/mndiazf/asignar-horario-springboot/assets/110750463/2f1d3763-1791-4814-9373-8310cb53162d)

### Obtener fechas por id de medico

**Endpoint**: `http://localhost:8080/api/horarios-trabajo/fechas/{medicoId}`  
**Método**: `GET`

![imagen](https://github.com/mndiazf/asignar-horario-springboot/assets/110750463/6826b97a-927d-438c-b673-67ce6f26b174)

### Obtener horas por id de horario trabajo

**Endpoint**: `http://localhost:8080/api/horarios-trabajo/horas/{idHorarioTrabajo}`  
**Método**: `GET`

![imagen](https://github.com/mndiazf/asignar-horario-springboot/assets/110750463/ef51f9bc-a524-482e-8e61-34e8a30abfbb)

### Buscar medico por especialidad

**Endpoint**: `http://localhost:8080/medicos/por-especialidad/{idEspecialidad}`  
**Método**: `GET`

![imagen](https://github.com/mndiazf/asignar-horario-springboot/assets/110750463/37047bc7-61fc-4911-a4ac-1abd63ada0cf)

### Buscar medico por nombre y apellido

**Endpoint**: `http://localhost:8080/medicos/buscar`  
**Método**: `GET`

![imagen](https://github.com/mndiazf/asignar-horario-springboot/assets/110750463/ff01a576-1cae-4368-8f09-24844339d561)

### Obtener medico por id

**Endpoint**: `http://localhost:8080/medicos/{id}`  
**Método**: `GET`

![imagen](https://github.com/mndiazf/asignar-horario-springboot/assets/110750463/0f760efa-9592-459a-a431-1a18096d610d)



# Instalación y Uso de manera local⚙️

**Clonar el repositorio:**

```bash
git clone https://github.com/mndiazf/asignar-horario-springboot
```

**Navegar al directorio del proyecto:**

```bash
cd asignar-horario-springboot
```

**Instalar las dependencias:**

```bash
mvn install
```

**Ejecutar la aplicación:**

```bash
mvn spring-boot:run
```


## Desarrollador del Proyecto

<table>
    <tr>
        <td><img src="https://github.com/mndiazf/insert-image-spring-boot/assets/110750463/79e9fe0e-a55c-4b68-9e86-2929d9e24683" width="100"></td>
        <td>
            <strong>Nombre:</strong> Manolo Diaz  :pencil2:<br>
            <strong>Correo:</strong> mn.diaz.f@gmail.com  :envelope:<br>
            <strong>LinkedIn:</strong> https://www.linkedin.com/in/manolo-diaz-fernandez-215567224/  :briefcase:<br>
            <strong>GitHub:</strong> https://github.com/mndiazf  :octocat:
        </td>
    </tr>
</table>
