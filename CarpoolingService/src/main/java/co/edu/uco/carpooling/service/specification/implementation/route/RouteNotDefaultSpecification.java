package co.edu.uco.carpooling.service.specification.implementation.route;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilUUID;
import org.springframework.stereotype.Component;

@Component
public class RouteNotDefaultSpecification extends CompositeSpecification<RouteDomain> {
    @Override
    public boolean isSatisfyBy(RouteDomain object) {
        return isValid(object);
    }

    private boolean isValid(RouteDomain route) {
        if (UtilUUID.getUtilUUID().getStringFromUUID(route.getId()).length() != 36 || UtilUUID.getUtilUUID().getStringFromUUID(route.getId()).equals(UtilUUID.DEFAULT_UUID_STRING)) {
            throw CarpoolingCustomException.buildUserException("The id the route is default.");
        }
        if (UtilNumeric.getUtilNumeric().isLessOrEqualThan(route.getRouteCapacity(), UtilNumeric.ZERO)) {
            throw CarpoolingCustomException.buildUserException("The capacity must be greater than zero");
        }
        return true;
    }
}