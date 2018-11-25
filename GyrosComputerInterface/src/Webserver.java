import com.sun.net.httpserver.*;
import processing.core.PVector;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.HashMap;

public class Webserver {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/gyroscope", new MyHandler());
        server.setExecutor(null);
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            Map <String,String>parms = Webserver.queryToMap(t.getRequestURI().getQuery());
            String response = "<h1>X:" + parms.get("x") + "<br>Y:" + parms.get("y") + "</h1>";
            int x = Integer.parseInt(parms.get("x"));
            int y = Integer.parseInt(parms.get("y"))
            PVector vector = new PVector(x,y);

            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    public static Map<String, String> queryToMap(String query){
        Map<String, String> result = new HashMap<String, String>();
        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length>1) {
                result.put(pair[0], pair[1]);
            }else{
                result.put(pair[0], "");
            }
        }
        return result;
    }

}
