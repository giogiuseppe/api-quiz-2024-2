package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.record.QuizDTO;
import application.record.QuizListDTO;
import application.service.QuizService;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    @Autowired
    private QuizService quizSrv;

    @GetMapping
    public Iterable<QuizListDTO> list() {
        return quizSrv.getAll();
    }

    @PostMapping
    public QuizDTO insert(@RequestBody QuizDTO quiz) {
        return quizSrv.insert(quiz);
    }
}
