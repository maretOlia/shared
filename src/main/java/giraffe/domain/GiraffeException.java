package giraffe.domain;

/**
 * @author Guschcyna Olga
 * @version 1.0.0
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
            return 1300;
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
