package foi.air.szokpt.reports.exceptions;

public class TokenValidationException extends RuntimeException {
    public TokenValidationException() {
        super("Token is invalid or expired");
    }
}
