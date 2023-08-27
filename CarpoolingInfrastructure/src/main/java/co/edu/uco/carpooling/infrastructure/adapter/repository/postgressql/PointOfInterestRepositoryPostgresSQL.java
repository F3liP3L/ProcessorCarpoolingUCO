package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql;

import co.edu.uco.carpooling.entity.PointOfInterestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PointOfInterestRepositoryPostgresSQL extends JpaRepository<PointOfInterestEntity, UUID> {
}
