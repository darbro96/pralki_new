package pl.utp.edu.pralki.exceptions;

public class ObjectInDatabaseException extends Exception {
    public ObjectInDatabaseException()
    {
        System.out.println("Obiekt o podanych parametrach jest już w bazie danych!");
    }
}
