package pl.utp.edu.pralki.exceptions;

import java.io.Serializable;
import java.util.logging.Logger;

public class ObjectInDatabaseException extends Exception implements Serializable {
    private static final Logger log = Logger.getLogger(ObjectInDatabaseException.class.getName());

    public ObjectInDatabaseException() {
        log.info("Obiekt o podanych parametrach jest już w bazie danych!");
    }
}
