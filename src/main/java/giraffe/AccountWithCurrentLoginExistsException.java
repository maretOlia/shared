package giraffe;

import giraffe.domain.GiraffeException;

/**
 * @author Guschcyna Olga
 * @version 1.0.0
 */
public class AccountWithCurrentLoginExistsException extends GiraffeException {

    public AccountWithCurrentLoginExistsException(String login) {
        super("Account with login " + login + " already exists");
    }

    @Override
    public Integer getErrorCode() {
        return 1100;
    }
}
