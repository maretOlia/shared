package giraffe;

import giraffe.domain.GiraffeException;

/**
 * @author Olga Gushchyna
 * @version 0.0.1
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
