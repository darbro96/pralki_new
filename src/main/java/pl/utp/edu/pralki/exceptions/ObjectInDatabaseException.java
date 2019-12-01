package pl.utp.edu.pralki.exceptions;

import java.util.logging.Logger;

public class ObjectInDatabaseException extends Exception {
    private Logger log = Logger.getLogger(getClass().getName());

    public ObjectInDatabaseException() {
        log.info("Obiekt o podanych parametrach jest już w bazie danych!");
    }
}
