package br.com.minhaapi.projeto.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_operacoes")
public class LogOperacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "operacao", length = 50)
    private String operacao;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    // Construtores, getters e setters
    public LogOperacao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}