package br.com.minhaapi.projeto.repository;

import br.com.minhaapi.projeto.model.Usuario;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuario extends JpaRepository<Usuario, Integer> {
    // Método para buscar os nomes e nicknames da view usando a entidade Usuario
    @Query(value = "SELECT u FROM Usuario u WHERE u.nickname IS NOT NULL")
    List<Usuario> buscarNicks();

    /*
    a function que criei no banco tem o seguinte script sql:
    CREATE OR REPLACE FUNCTION quantidadeusuarios()
        RETURNS INTEGER AS $$
        BEGIN
        RETURN (SELECT COUNT(*) FROM usuario);
    END;
    $$ LANGUAGE plpgsql;
     */
    @Query(value = "SELECT quantidadeusuarios()", nativeQuery = true)
    Integer quantidadeUsuarios();

    /*
    a função PL/pgsql que criei no banco tem o seguinte script sql:
        CREATE OR REPLACE FUNCTION atualizarTelefone(p_id INTEGER,p_telefone VARCHAR)
        RETURNS VOID AS $$
        BEGIN
            UPDATE usuario
            SET telefone = p_telefone
            WHERE id = p_id;
        END;
        $$ LANGUAGE plpgsql;
     */

    @Query (value = "SELECT atualizarTelefone(:id, :telefone)", nativeQuery = true)
    void atualizarTelefone(@Param("id") Integer id, @Param("telefone") String telefone);

    @Modifying
    @Transactional
    @Query(value = "CALL atualizarSenha(:id, :senha)", nativeQuery = true)
    void atualizarSenhaUsuario(@Param("id") Integer id, @Param("senha") String senha);

}
