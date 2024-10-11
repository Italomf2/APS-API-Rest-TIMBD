package br.com.minhaapi.projeto.controller;

import br.com.minhaapi.projeto.repository.IUsuario;
import br.com.minhaapi.projeto.Services.UsuarioService;
import br.com.minhaapi.projeto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController  {

    @Autowired
    private IUsuario dao;


    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuarios(){
        return ResponseEntity.status(200).body(service.listarUsuario());
    }

    @GetMapping("/nicks")
    public ResponseEntity<List<Usuario>> minhaView() {
        return ResponseEntity.status(200).body(service.tratarView());
    }

    @PutMapping("/{id}/senha")
    public ResponseEntity<Void> atualizarSenha(@PathVariable Integer id, @RequestBody String novaSenha) {
        service.atualizarSenha(id,novaSenha);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/total")
    public ResponseEntity<String> getTotalUsers() {
        return ResponseEntity.status(200).body(service.tratarFunction());
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(201).body(service.criarUsuario(usuario));
    }

    @PutMapping("/{id}/telefone")
    public ResponseEntity<Void> atualizarTelefone(@PathVariable Integer id, @RequestBody String novoTelefone) {
        dao.atualizarTelefone(id,novoTelefone);
        return ResponseEntity.status(204).build();
    }

    @PutMapping()
    public ResponseEntity<Usuario> modificarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(201).body(service.atualizarUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Integer id){
        dao.deleteById(id);
        return ResponseEntity.status(204).build();

    }


}
