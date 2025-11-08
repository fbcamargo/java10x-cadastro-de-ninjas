package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return this.ninjaRepository.findAll();
    }

    // Detalhes de um ninja
    public NinjaModel procurarNinja(Long id) {
        Optional<NinjaModel> ninjaModel = this.ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    // Criar um ninja
    public NinjaModel criarNinja(NinjaModel ninjaModel) {
        return this.ninjaRepository.save(ninjaModel);
    }
}
