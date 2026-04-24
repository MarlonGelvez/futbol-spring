# ⚽ Sistema de Clubes de Fútbol — Spring Boot + MongoDB

Proyecto que demuestra las relaciones entre entidades usando **Spring Data MongoDB** y `@DocumentReference`.

## Entidades y Relaciones

| Relación | Entidades |
|----------|-----------|
| @OneToOne | Club → Entrenador |
| @OneToMany | Club → Jugadores |
| @ManyToOne | Club → Asociacion |
| @ManyToMany | Club ↔ Competiciones |

## Endpoints disponibles

| Método | URL | Descripción |
|--------|-----|-------------|
| GET | /api/clubes | Listar todos los clubes |
| GET | /api/clubes/{id} | Obtener un club |
| POST | /api/clubes | Crear un club |
| PUT | /api/clubes/{id} | Actualizar un club |
| DELETE | /api/clubes/{id} | Eliminar un club |

*(Los mismos endpoints existen para `/api/entrenadores`, `/api/jugadores`, `/api/asociaciones`, `/api/competiciones`)*

## Cómo ejecutar

1. Tener MongoDB corriendo localmente en el puerto 27017 (o cambiar la URI en `application.properties`)
2. Abrir el proyecto en Spring Tool Suite
3. Ejecutar `ClubesApplication.java` como Spring Boot App

## Tecnologías

- Java 17
- Spring Boot 3.2.5
- Spring Data MongoDB
- Lombok
