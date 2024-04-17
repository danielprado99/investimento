package br.insper.investimento.investidor;

import br.insper.investimento.investimentos.Investimentos;
import br.insper.investimento.investimentos.InvestimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestidorService {

    @Autowired
    private InvestidorRepository investidorRepository;

    @Autowired
    private InvestimentosRepository investimentosRepository;

    public InvestidorService() {
    }

    public Investidor cadastrarInvestidor(Investidor investidor) {
        if (investidor.getPerfil().equals("CONSERVADOR") || investidor.getPerfil().equals("MODERADO") || investidor.getPerfil().equals("AGRESSIVO") ) {
            return (Investidor)this.investidorRepository.save(investidor) ;
        }
        else{
            throw new RuntimeException("Dados invalidos");
        }
    }


    public List<Investidor> listarInvestidor(String perfil){
        if (perfil != null){
            return investidorRepository.findByPerfil(perfil);
        }
        else{
            return investidorRepository.findAll();
        }
    }

    public void excluirInvestidor(Integer id){

        List<Investimentos> lista = investimentosRepository.findAll();
        for (Investimentos investimentos: lista){
            if(investimentos.getInvestidor().getId().equals(id)){
                throw new RuntimeException("Não é possível excluir um investidor que possui um investimento");
            }
        }
        investidorRepository.deleteById(id);
    }







}

