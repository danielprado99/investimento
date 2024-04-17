package br.insper.investimento.investimentos;

import br.insper.investimento.titulos.Titulos;
import br.insper.investimento.titulos.TitulosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InvestimentosController {


    @Autowired
    private InvestimentosService investimentosService;
    @PostMapping("/investimentos")
    public Investimentos salvarInvestimentos(@RequestBody Investimentos investimentos){
        return investimentosService.cadastrarInvestimentos(investimentos);
    }

    @GetMapping("/investimentos/{cpf}")
    public List<Investimentos> listarInvestimentos(@PathVariable String cpf){
        return investimentosService.listarInvestimentos(cpf);
    }

}
