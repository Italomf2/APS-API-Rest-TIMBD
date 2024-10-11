package br.com.minhaapi.projeto.repository;

import br.com.minhaapi.projeto.model.LogOperacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogOperacao extends JpaRepository<LogOperacao, Integer> {
    // Métodos personalizados podem ser definidos aqui, se necessário
}
