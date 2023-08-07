package co.edu.uco.crosscutting.util;

import java.util.Date;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

public class UtilDate {
    private static final UtilDate INSTANCE = new UtilDate();

    public static UtilDate getUtilDate() {
        return INSTANCE;
    }

    public boolean isNull(Date date) {
        return getUtilObject().isNull(date);
    }

    public Date getDefaultIsNull(Date value) {
        return getUtilObject().getDefaultIsNull(value, new Date());
    }

    public boolean isBetween(Date date, Date init, Date end) {
        return (date.after(init) && date.before(end));
    }

    public boolean isBetweenIncludingInit(Date date, Date init, Date end) {
        return (isBetween(date, init, end) || date.equals(init));
    }

    public boolean isBetweenIncludingEnd(Date date, Date init, Date end) {
        return (isBetween(date, init, end) || date.equals(end));
    }

    public boolean isBetweenIncludingRanges(Date date, Date init, Date end) {
        return (isBetweenIncludingEnd(date, init, end) || isBetweenIncludingInit(date, init, end));
    }
}
