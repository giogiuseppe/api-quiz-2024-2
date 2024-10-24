package application.model;

import java.util.Set;

import application.record.QuizDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quizzes")
@Getter
@Setter
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(nullable = false)
    public String titulo;

    @ManyToMany
    @JoinTable(name = "quizzes_possuem_questoes",
        joinColumns = @JoinColumn(name="id_quiz"),
        inverseJoinColumns = @JoinColumn(name="id_questao"))
    public Set<Questao> questoes;

    public Quiz(QuizDTO quiz) {
        this.id = quiz.id();
        this.titulo = quiz.titulo();
        this.questoes = quiz.questoes();
    }
}
