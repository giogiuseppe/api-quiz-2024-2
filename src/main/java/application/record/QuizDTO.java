package application.record;

import java.util.Set;

import application.model.Questao;
import application.model.Quiz;

public record QuizDTO(long id, String titulo, Set<Questao> questoes) {
    public QuizDTO(Quiz quiz) {
        this(quiz.getId(), quiz.getTitulo(), quiz.getQuestoes());
    }
}
