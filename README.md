<h1 align="center">📚 Challenge Literalura</h1>

<p align="center">
  <em>Aplicación de consulta de libros usando <b>Spring Boot</b>, <b>PostgreSQL</b> y la <b>API Gutendex</b></em>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/Spring_Boot-3-green?style=for-the-badge&logo=springboot" />
  <img src="https://img.shields.io/badge/PostgreSQL-15-blue?style=for-the-badge&logo=postgresql" />
  <img src="https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven" />
</p>

---

## ✨ Funcionalidades

✅ Buscar libros por título (usando la API Gutendex)  
✅ Guardar libros y autores en PostgreSQL  
✅ Listar libros y autores registrados  
✅ Consultar autores vivos en un año específico  
✅ Filtrar libros por idioma  
✅ Manejo de errores y validaciones de entrada  
✅ Evita duplicados en la base de datos  

---

## ⚙️ Tecnologías Utilizadas

- ☕ **Java 17**
- 🍃 **Spring Boot 3**
- 🐘 **PostgreSQL**
- 🛠️ **Maven**
- 🌐 **API Gutendex**
- 📦 **Spring Data JPA / Hibernate**

---

## 📦 Instalación y Ejecución

```bash
# 1. Clonar el repositorio
git clone https://github.com/tu-usuario/nombre-del-repositorio.git

# 2. Acceder al proyecto
cd nombre-del-repositorio

# 3. Configurar la base de datos en application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update

(Cambia tu_usuario y tu_contraseña por tus datos reales.
La base de datos literalura debe existir en PostgreSQL antes de ejecutar el programa.)

# 4. Ejecutar con Maven
mvn spring-boot:run
```

## 📖 Uso de la aplicación

Al ejecutar el programa, se muestra un menú interactivo en la consola:

```plaintext
=== MENÚ PRINCIPAL ===
1. Buscar libros por título
2. Listar libros registrados
3. Listar autores registrados
4. Listar autores vivos en un año
5. Listar libros por idioma
0. Salir
Seleccione una opción:
```

## 🔍 Ejemplo de ejecuciones
📌 Opción 1: Buscar libros por título
```
Ingrese el título del libro: Don Quijote
✅ Libro "Don Quijote" registrado exitosamente.
```
Si el libro ya está registrado:
```
Ingrese el título del libro: Don Quijote
⚠️ El libro "Don Quijote" ya está registrado en la base de datos.
```
📌 Opción 2: Lista de libros almacenados
```
=== 📚 LISTA DE LIBROS ALMACENADOS === 
📘 Don Quijote (es)
📘 La Odisea (es)
📘 La Divina Comedia (es)
📘 La Principessa Belgiojoso: Da memorie mondane inedite o rare e da archivii segreti di Stato (it)
📘 La metamorfosis, o, El asno de oro (es)
📘 Hamlet, Prince of Denmark (en)
📘 El crimen y el castigo (es)
📘 Moby Dick; Or, The Whale (en)
📘 La légende dorée: traduite du latin d'après les plus anciens manuscrits, avec une introduction, des notes, et un index alphabétique (fr)
📘 Amor y llanto : $b colección de leyendas históricas originales (es)
📘 Vida De Lazarillo De Tormes Y De Sus Fortunas Y Adversidades (es)
📘 A history of the Peninsular War, Vol. 5, Oct. 1811-Aug. 31, 1812 : $b Valencia, Ciudad Rodrigo, Badajoz, Salamanca, Madrid (en)
📘 Amor Crioulo: vida argentina (pt)
📘 Pride and Prejudice (en)
📘 Della peste e della pubblica amministrazione sanitaria (it)
📘 Madame Bovary (en)
📘 Studies in the Psychology of Sex, Volume 1: The Evolution of Modesty; The Phenomena of Sexual Periodicity; Auto-Erotism (en)
```
📌 Opción 3: Lista de autores registrados
```
=== 👩‍💼 LISTA DE AUTORES REGISTRADOS === 
👤 Cervantes Saavedra, Miguel de (Nacimiento: 1547, Muerte: 1616)
👤 Homer (Nacimiento: -750, Muerte: -650)
👤 Dante Alighieri (Nacimiento: 1265, Muerte: 1321)
👤 Barbiera, Raffaello (Nacimiento: 1851, Muerte: 1934)
👤 Apuleius (Nacimiento: null, Muerte: null)
👤 Shakespeare, William (Nacimiento: 1564, Muerte: 1616)
👤 Dostoyevsky, Fyodor (Nacimiento: 1821, Muerte: 1881)
👤 Melville, Herman (Nacimiento: 1819, Muerte: 1891)
👤 Jacobus, de Voragine (Nacimiento: null, Muerte: 1298)
👤 Sinués de Marco, María del Pilar (Nacimiento: 1835, Muerte: 1893)
👤 Anonymous (Nacimiento: null, Muerte: null)
👤 Oman, Charles (Nacimiento: 1860, Muerte: 1946)
👤 Botelho, Abel Acácio de Almeida (Nacimiento: 1856, Muerte: 1917)
👤 Holden, Horace (Nacimiento: 1810, Muerte: null)
👤 Austen, Jane (Nacimiento: 1775, Muerte: 1817)
👤 Frari, A. A. (Angelo Antonio) (Nacimiento: 1780, Muerte: 1865)
👤 Flaubert, Gustave (Nacimiento: 1821, Muerte: 1880)
👤 Ellis, Havelock (Nacimiento: 1859, Muerte: 1939)
```
📌 Opción 4: Autores vivos en un año específico digitado por el usuario
```
Ingrese el año: 1852
=== 📅 LISTA DE AUTORES VIVOS EN EL AÑO 1852 === 
👤 Barbiera, Raffaello
👤 Dostoyevsky, Fyodor
👤 Melville, Herman
👤 Sinués de Marco, María del Pilar
👤 Holden, Horace
👤 Frari, A. A. (Angelo Antonio)
👤 Flaubert, Gustave
```
📌 Opción 5: Lista de libros por idioma
```
Ingrese el idioma (ej: 'en', 'es', 'fr'): es
=== 🌍 LISTA DE LIBROS ESCRITOS EN EL IDIOMA es === 
📘 Don Quijote
📘 La Odisea
📘 La Divina Comedia
📘 La metamorfosis, o, El asno de oro
📘 El crimen y el castigo
📘 Amor y llanto : $b colección de leyendas históricas originales
📘 Vida De Lazarillo De Tormes Y De Sus Fortunas Y Adversidades
```

## ✅ Conclusiones

Este proyecto me permitió aplicar de manera práctica los conceptos fundamentales del desarrollo backend con **Java** y **Spring Boot**. Durante el proceso, reforcé conocimientos en:

- El consumo de **APIs externas** para obtener información dinámica (en este caso, de Gutendex).
- La persistencia de datos usando **Spring Data JPA** y **PostgreSQL**.
- La importancia de manejar **excepciones** y validar entradas para mejorar la experiencia del usuario.
- La creación de un menú interactivo en consola para que el programa sea más amigable.
- Cómo configurar y estructurar una aplicación en capas, separando la lógica en paquetes `service`, `repository`, `model`, `DTO` y `principal`.

Además, comprendí lo relevante que es trabajar con **bases de datos relacionales** y garantizar la consistencia de la información mediante restricciones adecuadas (por ejemplo, evitar duplicados o manejar correctamente las claves primarias).

En conclusión, este proyecto no solo me ayudó a cumplir con los requisitos del curso, sino que también me dio la oportunidad de experimentar con mejoras adicionales que enriquecieron la aplicación, haciéndola más robusta y cercana a un caso real de uso.



👨‍💻 Autor:
<p>Proyecto desarrollado por Jorge Cuervo para el curso de Backend de Alura Latam.</p>









