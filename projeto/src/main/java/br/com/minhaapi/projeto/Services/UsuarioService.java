package br.com.minhaapi.projeto.Services;

import br.com.minhaapi.projeto.repository.IUsuario;
import br.com.minhaapi.projeto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    public IUsuario usuarioRespository;

    public UsuarioService(IUsuario usuarioRespository){
        this.usuarioRespository = usuarioRespository;
    }

    public List<Usuario> listarUsuario(){
        List<Usuario> lista = usuarioRespository.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario){
        Usuario usuarioNovo = usuarioRespository.save(usuario);
        return usuarioNovo;
    }

    public Usuario atualizarUsuario(Usuario usuario){
        Usuario novoUsuario = usuarioRespository.save(usuario);
        return novoUsuario;
    }

    public void atualizarSenha(Integer id, String novaSenha) {
        usuarioRespository.atualizarSenhaUsuario(id, novaSenha);
    }

    public List<Usuario> tratarView() {
        List<Usuario> usuarios = usuarioRespository.buscarNicks();

        return usuarios.stream()
                .map(u -> {
                    Usuario usuario = new Usuario();
                    usuario.setNome(u.getNome());
                    usuario.setNickname(u.getNickname());
                    // Campos não desejados permanecem null
                    return usuario;
                })
                .collect(Collectors.toList());
    }

    public String tratarFunction(){
        Integer qtde = usuarioRespository.quantidadeUsuarios();
        return "a quantidade de usuarios cadastrados é: " + qtde;
    }

}