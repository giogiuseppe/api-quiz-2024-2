package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Categoria;
import application.record.CategoriaDTO;
import application.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository caterogiaRepo;

    public Iterable<CategoriaDTO> findAll() {
        return caterogiaRepo.findAll();
    }

    public CategoriaDTO insert(CategoriaDTO categoria) {
        Categoria nova = caterogiaRepo.save(new Categoria(categoria));
        return new CategoriaDTO(nova);
    }

}
