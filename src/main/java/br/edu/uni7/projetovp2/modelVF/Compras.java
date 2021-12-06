package br.edu.uni7.projetovp2.modelVF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.OneToMany;
import java.util.List;

@Document
public class Compras {

    @Id
    private String chaveNT;
    private int cpfCliente;

    @OneToMany
    private List<Produto> produtos;
    private Double valorCompra;

    public String getChaveNT() {
        return chaveNT;
    }

    public void setChaveNT(String chave) {
        this.chaveNT = chave;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(int cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
}
