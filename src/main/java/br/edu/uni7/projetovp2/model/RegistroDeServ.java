package br.edu.uni7.projetovp2.model;

public class RegistroDeServ {
    private Integer idReg;
    private String identificador;
    private float custo;
    private float vendaPecas;
    private float precoTotal;

    public RegistroDeServ(){

    }

    public RegistroDeServ(String identificador, float custo, float precoTotal) {
        this.identificador = identificador;
        this.custo = custo;
        this.precoTotal = precoTotal;
        vendaPecas = custo + precoTotal;
    }

    public Integer getIdReg() {
        return idReg;
    }

    public void setIdReg(Integer idReg) {
        this.idReg = idReg;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public float getVendaPecas() {
        return vendaPecas;
    }

    public void setVendaPecas(float vendaPecas) {
        this.vendaPecas = vendaPecas;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }
}


