package store.utility;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpPrincipal;
import com.sun.net.httpserver.Authenticator;

public class Auth extends Authenticator {
    @Override
    public Result authenticate(HttpExchange httpExchange) {
        String url = httpExchange.getRequestURI().toString();
        if ("/products".equals(url)
                || "/categories".equals(url)
                || "/purchase".equals(url))
            return new Success(new HttpPrincipal("user", "password"));
        else{
            return new Failure(403);
        }
    }
}
