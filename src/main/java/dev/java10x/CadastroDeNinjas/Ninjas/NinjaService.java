package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
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
    public NinjaDto criarNinja(NinjaDto ninjaDto) {
        NinjaModel ninja = ninjaMapper.map(ninjaDto);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Deletar o ninja - Tem que ser void
    public void deletarNinja(Long id) {
        this.ninjaRepository.deleteById(id);
    }

    // Atualizar Ninja (PUT)
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaModel) {
        if(this.ninjaRepository.existsById(id)) {
            ninjaModel.setId(id);
            return ninjaRepository.save(ninjaModel);
        }
        return null;
    }
}
