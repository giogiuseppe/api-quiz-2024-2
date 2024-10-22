package application.record;

import application.model.Questao;

public record QuestaoDTO(long id, String enunciado, CategoriaDTO categoria) {
    public QuestaoDTO(Questao questao) {
        this(questao.getId(), questao.getEnunciado(), new CategoriaDTO(questao.getCategoria()));
    }
}
