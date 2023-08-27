package co.edu.uco.carpooling.service.usecase;

import java.util.List;
import java.util.Optional;

public interface UseCaseList<D> {
    List<D> execute(Optional<D> dto);

}