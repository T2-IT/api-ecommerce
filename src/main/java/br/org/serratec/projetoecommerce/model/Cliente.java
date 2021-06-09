package br.org.serratec.projetoecommerce.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    private String email;

    @Column(name = "nome_usuario")
    private String usuario;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    private String senha;

    private String cpf;

    private String telefone;

    @Column(name = "data_nasc")
    private LocalDate dataNasc;

    
}
