package br.insper.investimento.investidor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvestidorController {

    @Autowired
    private InvestidorService investidorService;

    @PostMapping("/investidor")
    public Investidor salvarInvestidor(@RequestBody Investidor investidor){
        return investidorService.cadastrarInvestidor(investidor);
    }

    @GetMapping("/investidor")
    public List<Investidor> getInvestidores(@RequestParam(required = false) String perfil) {
        return investidorService.listarInvestidor(perfil);
    }


    @DeleteMapping("/investidor/{id}")
    public void excluirInvestidor(@PathVariable Integer id){
        investidorService.excluirInvestidor(id);
    }



}
