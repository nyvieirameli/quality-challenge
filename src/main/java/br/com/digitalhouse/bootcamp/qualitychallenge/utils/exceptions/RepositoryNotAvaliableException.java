package br.com.digitalhouse.bootcamp.qualitychallenge.utils.exceptions;

public class RepositoryNotAvaliableException extends RuntimeException {

    public RepositoryNotAvaliableException(String database_unavailable) {
        super(database_unavailable);
    }
}
