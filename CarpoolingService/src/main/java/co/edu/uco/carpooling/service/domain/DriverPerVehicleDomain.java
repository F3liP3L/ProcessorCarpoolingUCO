package co.edu.uco.carpooling.service.domain;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;

public class DriverPerVehicleDomain {

    private UUID id;
    private String name;
    private String nameVehicle;

    public UUID getId() {
        return id;
    }

    public DriverPerVehicleDomain() {
        setId(UtilUUID.getUtilUUID().getNewUUID());
        setName(EMPTY);
        setNameVehicle(EMPTY);
    }

    public DriverPerVehicleDomain(UUID id, String name, String nameVehicle) {
        setId(id);
        setName(name);
        setNameVehicle(nameVehicle);
    }

    public void setId(UUID id) {
        this.id = UtilObject.getUtilObject().getDefaultIsNull(id, UtilUUID.getUtilUUID().getNewUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = getUtilText().getDefault(name);
    }

    public String getNameVehicle() {
        return nameVehicle;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = getUtilText().getDefault(nameVehicle);
    }

    public static final DriverPerVehicleDomain build() {
        return new DriverPerVehicleDomain();
    }

    public static final DriverPerVehicleDomain build(final UUID id, final String name, final String nameVehicle) {
        return new DriverPerVehicleDomain(id, name, nameVehicle);
    }
}