# Closet Mis-Match API

API REST sencilla para gestionar prendas de ropa desde una interfaz web en el proyecto **Closet Mis-Match**.

## Tecnologías

- Java 17
- Spring Boot
- HTML, CSS, JavaScript
- Bootstrap 5

## Estructura del Proyecto

closet-api/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/ClosetApiApplication.java
│   │   └── java/com/example/demo/Prenda.java
│   │   └── resources/
│       ├── static/
│       │   ├── fotos/
│       │   └── styles.css
│       └── templates/
│           └── index.html
├── README.md
└── pom.xml
```

La web estará accesible en:  
[http://localhost:8080](http://localhost:8080)

---

## Endpoints de la API

GET  `/api/prendas`  Lista todas las prendas   
POST  `/api/prendas`  `{ "nombre": "...", "tipo": "...", "temporada": "..." }` Crea una nueva prenda  
PUT  `/api/prendas/{id}`  `{ "nombre": "...", "tipo": "...", "temporada": "..." }` Modifica una prenda por su ID 
DELETE '/api/prendas/{id}`   Elimina una prenda por su ID 
