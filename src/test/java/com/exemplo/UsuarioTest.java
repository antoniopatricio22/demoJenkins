package com.exemplo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void testUsuarioMaiorDeIdade() {
        Usuario usuario = new Usuario("João", 20);
        assertTrue(usuario.isMaiorDeIdade());
    }

    @Test
    public void testUsuarioMenorDeIdade() {
        Usuario usuario = new Usuario("Maria", 15);
        assertFalse(usuario.isMaiorDeIdade());
    }
}