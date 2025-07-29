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

# 4. Ejecutar con Maven
mvn spring-boot:run
