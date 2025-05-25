package com.exemplo;

public class Usuario {

    private static volatile int ultimoId = 0;
    private int idPessoa;
    private String nome;
    private String login;
    private String senha;
    private boolean status;

    public Usuario(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do usuário está incorreto.");
        }
        this.idPessoa = ++ultimoId;
        this.nome = nome;
        this.login = geraLogin(nome);
        this.senha = criptografaSenha("abc123");
        this.status = false;
    }

    public Usuario() {
    }

    public boolean alteraStatus(boolean status) {
        this.status = status;
        return this.status;
    }

    public String geraLogin(String nome) {
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do usuário está incorreto.");
        }
        String[] partesNome = nome.split(" ");
        return partesNome[0].toLowerCase() + "." + partesNome[partesNome.length - 1].toLowerCase();
    }

    private String criptografaSenha(String senha) {
        StringBuilder senhaCriptografada = new StringBuilder();
        for (int i = senha.length() - 1; i >= 0; i--) {
            char c = (char) (senha.charAt(i) - 10);
            senhaCriptografada.append(c);
        }
        return senhaCriptografada.toString();
    }

    public boolean autentica(String login, String senha) {
        if (!status) {
            return false;
        }
        return login.equals(this.login) && criptografaSenha(senha).equals(this.senha);
    }

    public boolean alteraSenha(String login, String senhaAtual, String novaSenha, String confirmaSenha) {
        if (autentica(login, senhaAtual)) {
            if (!validaSenha(novaSenha)) {
                throw new IllegalArgumentException("Nova senha fora do padrão.");
            }
            if (!novaSenha.equals(confirmaSenha)) {
                throw new IllegalArgumentException("Nova senha não confere com a senha de confirmação.");
            }
            this.senha = criptografaSenha(novaSenha);
            return true;
        }
        return false;
    }

    public boolean validaSenha(String senha) {
        boolean temLetra = false, temNumero = false;
        for (char c : senha.toCharArray()) {
            if (Character.isLetter(c)) temLetra = true;
            if (Character.isDigit(c)) temNumero = true;
        }
        return temLetra && temNumero;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Usuario:\n" +
                "idPessoa: " + idPessoa + "\n" +
                "Nome    : " + nome + "\n" +
                "Login   : " + login + "\n" +
                "Ativo   : " + status;
    }
}

