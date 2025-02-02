package foi.air.szokpt.reports.util;

import foi.air.szokpt.reports.clients.TokenValidationClient;
import foi.air.szokpt.reports.exceptions.TokenValidationException;
import org.springframework.stereotype.Component;

@Component
public class Authorizer {
    private final TokenValidationClient tokenValidationClient;

    public Authorizer(TokenValidationClient tokenValidationClient){
        this.tokenValidationClient = tokenValidationClient;
    }

    public void verifyToken(String authenticationHeader){
        if(tokenValidationClient.validateToken(authenticationHeader) == null){
            throw new TokenValidationException();
        }

    }
}
