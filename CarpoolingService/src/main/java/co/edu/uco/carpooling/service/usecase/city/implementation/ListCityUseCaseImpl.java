package co.edu.uco.carpooling.service.usecase.city.implementation;

import co.edu.uco.carpooling.dto.CityDTO;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.CityRepositoryPostgresSQL;
import co.edu.uco.carpooling.service.assembler.entity.implementation.CityEntityAssembler;
import co.edu.uco.carpooling.service.usecase.city.ListCityUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListCityUseCaseImpl implements ListCityUseCase {
    @Autowired
    private CityEntityAssembler cityEntityAssembler;
    @Autowired
    private CityRepositoryPostgresSQL cityRepository;

    @Override
    public List<CityDTO> execute(Optional<CityDTO> dto) {
        return cityRepository.findAll().stream().map(cityEntity -> cityEntityAssembler.assembleDTO(cityEntity)).toList();
    }
}
