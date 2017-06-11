package br.uva.findcheap.model;

public class Produto {

    String tipo;
    String marca;
    String nome;
    String qtde;

    public Produto(String tipo, String marca, String nome, String qtde) {
        this.tipo = tipo;
        this.marca = marca;
        this.nome = nome;
        this.qtde = qtde;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getQtde() { return qtde; }
    public void setQtde(String qtde) { this.qtde = qtde; }

    @Override
    public String toString() {
        String produto;
        produto = "Tipo: " + tipo + "\n";
        produto += "Marca: " + marca + "\n";
        produto += "Qtde: " + qtde + "\n";
        return produto;
    }

}
