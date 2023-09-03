package co.edu.uco.carpooling.service.specification.implementation.route;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.RouteRepositoryPostgresSQL;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import co.edu.uco.crosscutting.util.UtilUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteExistDriverVehicleRouteActive extends CompositeSpecification<RouteDomain> {

    private static final String STATUS = "1874d41f-c258-46be-96bf-8a55a564804e";
    @Autowired
    private RouteRepositoryPostgresSQL routeRepository;
    @Override
    public boolean isSatisfyBy(RouteDomain object) {
        return isExist(object);
    }

    // TODO Revisar la query
    private boolean isExist(RouteDomain route) {
        try {
        List<RouteEntity> responses = routeRepository.findRouteEntitiesByDriverVehicleIdAndRouteStatusId(route.getDriverVehicle().getId(), UtilUUID.getStringToUUID(STATUS));
        responses.forEach(routeEntity -> System.out.println(routeEntity.toString()));
        if(responses.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("It is not possible to create another route until the current route is finished.");
        }
        return true;
        } catch (CarpoolingCustomException exception) {
            throw exception;
        } catch (Exception exception) {
            throw CarpoolingCustomException.build("An error occurred while trying to query driver information by vehicle.", exception.getMessage() , exception);
        }
    }
}
