package com.exemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Equipe 02
 */

class UsuarioTest {
    private Usuario usuarioAtivo;
    private Usuario usuarioDesativado;

    @BeforeEach
    void setUp() {
        usuarioAtivo = new Usuario("Fulano Fulano");
        //Ativando usuário para teste
        usuarioAtivo.alteraStatus(true);
        
        usuarioDesativado = new Usuario("Beltrano Beltrano");
    }

    @Test
    @DisplayName("CT01: Autenticação de um usuário ativo com login e senha válidos")
    void testAutenticaCT01() {
        // Cenário
        String login = "fulano.fulano";
        String senha = "abc123";
        boolean resultadoEsperado = true;

        // Execução
        boolean resultadoAtual = usuarioAtivo.autentica(login, senha);

        // Verificação
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    @DisplayName("CT02: Autenticação de um usuário ativo com login inválido e senha válida")
    void testAutenticaCT02() {
        // Cenário
        String login = "fulano.beltrano";
        String senha = "abc123";
        boolean resultadoEsperado = false;

        // Execução
        boolean resultadoAtual = usuarioAtivo.autentica(login, senha);

        // Verificação
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    @DisplayName("CT03: Autenticação de um usuário ativo com login válido e senha inválida")
    void testAutenticaCT03() {
        // Cenário
        String login = "fulano.fulano";
        String senha = "teste";
        boolean resultadoEsperado = false;

        // Execução
        boolean resultadoAtual = usuarioAtivo.autentica(login, senha);

        // Verificação
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    @DisplayName("CT04: Autenticação de um usuário desativado com login e senha válidos")
    void testAutenticaCT04() {
        // Cenário
        String login = "beltrano.beltrano";
        String senha = "abc123";
        boolean resultadoEsperado = false;

        // Execução
        boolean resultadoAtual = usuarioDesativado.autentica(login, senha);

        // Verificação
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    @DisplayName("CT05: Autenticação de um usuário desativado com login inválido e senha inválida")
    void testAutenticaCT05() {
        // Cenário
        String login = "beltrano.fulano";
        String senha = "teste";
        boolean resultadoEsperado = false;

        // Execução
        boolean resultadoAtual = usuarioDesativado.autentica(login, senha);

        // Verificação
        assertEquals(resultadoEsperado, resultadoAtual);
    }
}
