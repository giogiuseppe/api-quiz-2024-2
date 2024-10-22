package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Questao;
import application.record.QuestaoDTO;
import application.repository.QuestaoRepository;

@Service
public class QuestaoService {
    @Autowired
    private QuestaoRepository questaoRepo;

    public Iterable<QuestaoDTO> findAll() {
        return questaoRepo.findAll().stream().map(QuestaoDTO::new).toList();
    }

    public QuestaoDTO insert(QuestaoDTO questao) {
        Questao novo = new Questao(questao);
        Questao retorno = questaoRepo.save(novo);
        QuestaoDTO resposta = new QuestaoDTO(retorno);

        return resposta;

        //return new QuestaoDTO(questaoRepo.save(new Questao(questao)));
    }

    public void deleteById(long id){
        if(!questaoRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Questão Não Encontrada"
            );
        }
        questaoRepo.deleteById(id);
    }
}
