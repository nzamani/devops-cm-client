package sap.prd.cmintegration.cli;

public class ExitException extends CMCommandLineException {

    private static final long serialVersionUID = -3269137608207801150L;
    private final int exitCode;

    public ExitException(int exitCode) {
        this((String)null, exitCode);
    }

    public ExitException(String message, int exitCode) {
        this(message, null, exitCode);
    }

    public ExitException(Throwable cause, int exitCode) {
        this(null, cause, exitCode);
    }

    public ExitException(String message, Throwable cause, int exitCode) {
        super(message, cause);
        if(exitCode == 0)
            throw new RuntimeException("Cannot create ExitException for exit code 0. "
                    + "The cause contained in this exception is the original exception (if any) "
                    + "handed over to constructor of the ExitException.", cause);
        this.exitCode = exitCode;
    }

    public int getExitCode() {
        return exitCode;
    }
}