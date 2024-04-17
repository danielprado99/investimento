package br.insper.investimento.titulos;

import br.insper.investimento.investidor.Investidor;
import br.insper.investimento.investidor.InvestidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TitulosController {

    @Autowired
    private TitulosService titulosService;

    @PostMapping("/titulos")
    public Titulos salvarTitulos(@RequestBody Titulos titulos){
        return titulosService.cadastrarTitulos(titulos);
    }

    @DeleteMapping("/titulos/{id}")
    public void excluirInvestidor(@PathVariable Integer id){
        titulosService.excluirTitulos(id);
    }

    @GetMapping("/titulos")
    public List<Titulos> getTitulos(@RequestParam(required = false) String tipo) {
        return titulosService.listarTitulos(tipo);
    }

}
