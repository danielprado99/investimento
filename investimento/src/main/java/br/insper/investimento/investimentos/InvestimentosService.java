package br.insper.investimento.investimentos;

import br.insper.investimento.investidor.Investidor;
import br.insper.investimento.investidor.InvestidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvestimentosService {

    @Autowired
    private InvestimentosRepository investimentosRepository;

    @Autowired
    private InvestidorRepository investidorRepository;


    public InvestimentosService() {
    }

    public Investimentos cadastrarInvestimentos(Investimentos investimentos) {
        List<Investimentos> lista = investimentosRepository.findAll();
        if (investimentos.getInvestidor().getPerfil().equals("CONSERVADOR")){
            if(investimentos.getTitulo().getTipo().equals("Ação")){
                throw new RuntimeException("Dados invalidos");
            }
        }
        else if (investimentos.getInvestidor().getPerfil().equals("MODERADO")){
            int qntAcao = 0;
            int qntTil = 0;
            for (Investimentos investimentos1 : lista){
                if (investimentos1.getInvestidor().getCpf().equals(investimentos.getInvestidor().getCpf())){
                    if (investimentos1.getTitulo().getTipo().equals("Ação")){
                        qntAcao ++;
                    }
                    qntTil ++;
                }
            }
            double proporcao = (qntAcao + 1) / qntTil;
            if(proporcao > 0.5){
                throw new RuntimeException("Dados invalidos");
            }
        }
        return (Investimentos)this.investimentosRepository.save(investimentos) ;
    }

    public List<Investimentos> listarInvestimentos(String cpf){
        List<Investidor> listaInvestidor = investidorRepository.findAll();
        for (Investidor investidor: listaInvestidor){
            if(investidor.getCpf().equals(cpf)){
                List<Investimentos> lista = investimentosRepository.findAll();
                List<Investimentos> listacpf = new ArrayList<>();
                for (Investimentos investimento: lista){
                    if (investimento.getInvestidor().getCpf().equals(cpf)){
                        listacpf.add(investimento);
                    }
                }
                return listacpf;
            }
        }
        throw new RuntimeException("CPF inválido");
    }

}
