# CheckJobs 🧠💼

Aplicación backend en Java desarrollada con Spring Boot para gestión de ofertas de empleo, usuarios y validación con OpenAI.

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- OpenAI API
- Maven
- Docker (opcional)
- Lombok

## 📁 Estructura del proyecto
src
├── main
│ ├── java
│ │ └── com.jobs.checkjobs
│ │ ├── controller
│ │ ├── dto
│ │ ├── model
│ │ ├── repository
│ │ ├── service
│ │ └── CheckjobsApplication.java
│ └── resources
│ ├── application.properties
│ └── data.sql (opcional)
└── test

## ⚙️ Configuración

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/jidorta/checkjobs.git
   cd checkjobs

   Configurar variable de entorno para la API de OpenAI:

export OPENAI_API_KEY=tu_clave_aquí

application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/checkjobs
spring.datasource.username=postgres
spring.datasource.password=1234

./mvnw spring-boot:run

Integración con OpenAI
La app valida ciertos datos usando la API de OpenAI para ofrecer respuestas inteligentes, por ejemplo:

Validación de descripciones de ofertas

Recomendaciones automáticas

📦 Endpoints REST
Método	Ruta	Descripción
GET	/api/jobs	Lista todas las ofertas
POST	/api/jobs	Crea una nueva oferta
...	...	Por completar según avance

