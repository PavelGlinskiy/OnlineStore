package store.utility;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import domain.Category;
import org.apache.commons.lang3.StringEscapeUtils;
import store.Store;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MyHttpHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if("GET".equals(httpExchange.getRequestMethod())
                && httpExchange.getRequestURI().toString().equals("/products")
                && httpExchange.getPrincipal().getUsername().equals("user")) {
            String product = Store.storeMap.toString().replace("[", " ")
                    .replace("]", " ")
                    .replace(",", " ");
            outputOfProducts(product, httpExchange);

        }else if("GET".equals(httpExchange.getRequestMethod())
                && httpExchange.getRequestURI().toString().equals("/categories")
                && httpExchange.getPrincipal().getUsername().equals("user")){
            List<String> list = new ArrayList<>();
            for (Category category:Store.storeMap.keySet()) {
                list.add(category.getNameCategory());
            }
            String categories = list.toString().replace(",", " ");
            outputOfProducts(categories, httpExchange);

        } else if("POST".equals(httpExchange.getRequestMethod())
                && httpExchange.getRequestURI().toString().equals("/purchase")
                && httpExchange.getPrincipal().getUsername().equals("user")) {
            handlePostRequest(httpExchange);
        }
    }

    private void handlePostRequest(HttpExchange httpExchange) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = httpExchange.getRequestBody();
        int i;
        while ((i = inputStream.read()) != -1) {
            sb.append((char) i);
        }
        String product = sb.toString().replace("name", "").replace(":", "")
                .replace("\r","")
                .replace("\n","")
                .replace("{","")
                .replace("\"","")
                .replace("}","").trim();
        BuyProducts.purchase(product);
    }

    private void outputOfProducts(String product, HttpExchange httpExchange)  throws  IOException {
        OutputStream outputStream = httpExchange.getResponseBody();
        String htmlResponse = StringEscapeUtils.escapeHtml4(product);
        httpExchange.sendResponseHeaders(200, htmlResponse.length());
        outputStream.write(product.getBytes());
        outputStream.flush();
        outputStream.close();
    }

}