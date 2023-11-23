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

    @Size(min = 5, message = "formato de email incorreto.")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Formato de email incorreto.")
    String email;

    @NotBlank @Size(min = 9, max = 12, message = "Telefone incorreto.")
    String telefone;

    @NotNull(message = "A data de nascimento não pode ser nula")
    @Past(message = "A data de nascimento deve estar no passado")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate nascimento;

    @NotBlank @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    private String senha;

}
