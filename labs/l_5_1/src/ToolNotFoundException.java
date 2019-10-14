/**
 * ToolNotFoundException
 */
public class ToolNotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -6005657935487313100L;

    /**
     * 
     */
    public ToolNotFoundException() {
    }

    /**
     * @param message
     */
    public ToolNotFoundException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public ToolNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ToolNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public ToolNotFoundException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
    
}