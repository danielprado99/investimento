package br.insper.investimento.titulos;

import br.insper.investimento.investidor.Investidor;
import br.insper.investimento.investidor.InvestidorRepository;
import br.insper.investimento.investimentos.Investimentos;
import br.insper.investimento.investimentos.InvestimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitulosService {

    @Autowired
    private TitulosRepository titulosRepository;

    @Autowired
    private InvestimentosRepository investimentosRepository;
    public TitulosService() {
    }

    public Titulos cadastrarTitulos(Titulos titulos) {
        if (titulos.getTipo().equals("RF") || titulos.getTipo().equals("Ação") || titulos.getTipo().equals("FI") ) {
            return (Titulos)this.titulosRepository.save(titulos) ;
        }
        else{
            throw new RuntimeException("Dados invalidos");
        }
    }

    public void excluirTitulos(Integer id){
        List<Investimentos> lista = investimentosRepository.findAll();
        for (Investimentos investimentos: lista){
            if(investimentos.getTitulo().getId().equals(id)){
                throw new RuntimeException("Não é possível excluir um título que possui um investidor");
            }
        }

        titulosRepository.deleteById(id);
    }


    public List<Titulos> listarTitulos(String tipo){
        if (tipo != null){
            return titulosRepository.findByTipo(tipo);
        }
        else{
            return titulosRepository.findAll();
        }
    }

}