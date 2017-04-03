package giraffe.domain;

/**
 * Custom Giraffe exceptions codes:
 * <ul>
 * <li>1100 - 1190: Security issues with authorization/authentication</li>
 * <li>1200 - 1290: User management</li>
 * <li>1300 - 1390: Simple Task Management</li>
 * <li>1400 - 1490: Complex Task Management</li> *
 * </ul>
 *
 * @author Olga Gushchyna
 * @version 0.0.1
 */
abstract public class GiraffeException extends Exception {

    public GiraffeException(String message) {
        super(message);
    }

    abstract public Integer getErrorCode();


    public static class UnableToValidateSocialUserInformation extends GiraffeException {

        public UnableToValidateSocialUserInformation() {
            super("Unable to validate social user information. External authentication server is not responding or information sent by external server is not full");
        }

        @Override
        public Integer getErrorCode() {
            return 1100;
        }
    }


    public static class ErrorResponse {

        private int errorCode;

        private String message;


        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
