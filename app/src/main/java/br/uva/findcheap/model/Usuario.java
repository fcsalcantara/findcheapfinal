package br.uva.findcheap.model;

public class Usuario {

    private String nome;
    private String email;
    private String cpf;
    private String senha;

    public Usuario() { }

    public Usuario(String nome, String email, String cpf, String senha) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    @Override
    public String toString() { return this.nome; }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Usuario) {
            Usuario usuario = (Usuario) object;
            return this.email.equalsIgnoreCase(usuario.getEmail())
                    && this.senha.equalsIgnoreCase(usuario.getSenha());
        } else {
            return false;
        }
    }

}
