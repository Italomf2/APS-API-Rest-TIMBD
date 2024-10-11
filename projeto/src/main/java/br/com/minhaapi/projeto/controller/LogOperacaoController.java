package br.com.minhaapi.projeto.controller;

import br.com.minhaapi.projeto.model.LogOperacao;
import br.com.minhaapi.projeto.service.LogOperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogOperacaoController {
    @Autowired
    private LogOperacaoService logOperacaoService;

    @GetMapping
    public ResponseEntity<List<LogOperacao>> listarLogs() {
        List<LogOperacao> logs = logOperacaoService.listarLogs();
        return ResponseEntity.ok(logs);
    }
}
