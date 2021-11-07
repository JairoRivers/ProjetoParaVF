package br.edu.uni7.projetovp2.model;

public class ControleEst {
    private Integer id;
    private String identificador;
    private String nome;
    private String fabricante;
    private int quantidade;
    private float preco;

    public ControleEst (){

    }

    public ControleEst(String identificador, String nome, String fabricante, int quantidade, float preco){
        this.identificador = identificador;
        this.nome = nome;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
