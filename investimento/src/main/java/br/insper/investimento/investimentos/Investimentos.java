package br.insper.investimento.investimentos;

import br.insper.investimento.investidor.Investidor;
import br.insper.investimento.titulos.Titulos;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;

@Entity
public class Investimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Investidor investidor;

    @ManyToOne
    private Titulos titulo;

    private double valor;

    private LocalDateTime data;

    public Investimentos(){
    }
    public Investimentos(Investidor investidor, Titulos titulo, double valor, LocalDateTime data) {
        this.investidor = investidor;
        this.titulo = titulo;
        this.valor = valor;
        this.data = data;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public Titulos getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulos titulo) {
        this.titulo = titulo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
