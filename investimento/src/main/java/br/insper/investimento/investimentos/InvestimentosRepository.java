package br.insper.investimento.investimentos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestimentosRepository extends JpaRepository<Investimentos, Integer> {
}
