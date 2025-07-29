package com.alura.cursos.challenge_literalura_app_libros.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase );
}
