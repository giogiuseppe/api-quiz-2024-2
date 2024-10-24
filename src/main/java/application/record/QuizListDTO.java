package application.record;

import application.model.Quiz;

public record QuizListDTO(long id, String titulo) {
    public QuizListDTO(Quiz quiz) {
        this(quiz.getId(), quiz.getTitulo());
    }
}
