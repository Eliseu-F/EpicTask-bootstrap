package br.senac.sp.epictask.model;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Task {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    Long id;
    @NotBlank @Size(min = 3, message = "Campo vazio. Mínimo 3 caracteres.")
    String nome;

    @Size(min = 19, message = "Formato de cartão incorreto.")
    @Pattern(regexp = "^\\d{4}-\\d{4}-\\d{4}-\\d{4}$", message = "Formato de cartão incorreto.")
    String nmrCartao;

    @NotBlank @Size(min = 9, max = 12, message = "Telefone incorreto.")
    String telefone;

    @NotNull(message = "O vencimento do cartão não pode estar vazio")
    @Past(message = "A data de nascimento deve estar no passado")
    @DateTimeFormat(pattern = "yyyy-MM")
    LocalDate nascimento;

    @NotBlank @Size(min = 6, message = "Senha incompleta")
    private String senha;

}
