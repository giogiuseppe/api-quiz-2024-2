package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Quiz;
import application.record.QuizDTO;
import application.record.QuizListDTO;
import application.repository.QuizRepository;

@Service
public class QuizService {
    @Autowired
    public QuizRepository quizRepo;

    public Iterable<QuizListDTO> getAll() {
        return quizRepo.findAll().stream().map(QuizListDTO::new).toList();
    }

    public QuizDTO insert(QuizDTO quiz) {
        return new QuizDTO(quizRepo.save(new Quiz(quiz)));
    }
}
