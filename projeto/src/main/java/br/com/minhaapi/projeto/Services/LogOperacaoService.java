package br.com.minhaapi.projeto.service;

import br.com.minhaapi.projeto.model.LogOperacao;
import br.com.minhaapi.projeto.repository.ILogOperacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogOperacaoService {
    @Autowired
    private ILogOperacao logOperacaoRepository;

    public List<LogOperacao> listarLogs() {
        return logOperacaoRepository.findAll();
    }
}
