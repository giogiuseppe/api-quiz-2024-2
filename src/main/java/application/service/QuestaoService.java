package application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Categoria;
import application.model.Questao;
import application.record.QuestaoDTO;
import application.repository.CategoriaRepository;
import application.repository.QuestaoRepository;

@Service
public class QuestaoService {
    @Autowired
    private QuestaoRepository questaoRepo;
    @Autowired
    private CategoriaRepository categoriaRepo;

    public Iterable<QuestaoDTO> findAll() {
        return questaoRepo.findAll().stream().map(QuestaoDTO::new).toList();
    }

    public QuestaoDTO insert(QuestaoDTO questao) {
        if(!categoriaRepo.existsById(questao.categoria().id())) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Categoria não Encontrada"
            );
        }
        Questao novo = new Questao(questao);
        Questao retorno = questaoRepo.save(novo);
        QuestaoDTO resposta = new QuestaoDTO(retorno);

        return resposta;

        //return new QuestaoDTO(questaoRepo.save(new Questao(questao)));
    }

    public QuestaoDTO update(long id, QuestaoDTO questao) {
        Optional<Questao> resultado = questaoRepo.findById(id);
        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Questão não encontrada"  
            );
        }
        if(!categoriaRepo.existsById(questao.categoria().id())) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Categoria não Encontrada"
            );
        }
        resultado.get().setEnunciado(questao.enunciado());
        resultado.get().setCategoria(new Categoria(questao.categoria()));

        Questao retorno = questaoRepo.save(resultado.get());
        QuestaoDTO resposta = new QuestaoDTO(retorno);
        return resposta;
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
