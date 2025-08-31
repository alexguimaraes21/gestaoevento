package br.com.cgtecnologia.gestaoevento.infrastructure.adapters.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "tb_eventos")
@Entity
public class EventoJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nm_evento")
    private String nome;
    @Column(name = "ds_evento")
    private String descricao;
    @Column(name = "dh_evento")
    private LocalDateTime dataEvento;
    @Column(name = "ds_local")
    private String local;
    @Column(name = "vl_capacidade")
    private int capacidade;
    @Column(name = "sn_ativo")
    private boolean ativo;
}
