package web;

import backend.Dice;
import spark.Request;
import spark.Spark;
import spark.Spark.*;

import java.util.Set;

import static spark.Spark.get;
import static spark.Spark.*;

public class DiceRoller {

    public static void main(String[] args) {



        get("/test", (request, response) -> {
            // Show something

            String returned = "";

            // returned += request.splat().length;

            Set<String> set = request.attributes();
            for (String str : set) returned += "\n"+str;


            returned += "\n"+request.attributes();             // the attributes list
            returned += "\n"+request.attribute("foo");         // value of foo attribute
            //returned += "\n"+request.attribute("A", "V");      // sets value of attribute A to V
            returned += "\n"+request.body();                   // request body sent by the client
            returned += "\n"+request.bodyAsBytes();            // request body as bytes
            returned += "\n"+request.contentLength();          // length of request body
            returned += "\n"+request.contentType();            // content type of request.body
            returned += "\n"+request.contextPath();            // the context path, e.g. "/hello"
            returned += "\n"+request.cookies();                // request cookies sent by the client
            returned += "\n"+request.headers();                // the HTTP header list
            returned += "\n"+request.headers("BAR");           // value of BAR header
            returned += "\n"+request.host();                   // the host, e.g. "example.com"
            returned += "\n"+request.ip();                     // client IP address
            returned += "\n"+request.params("foo");            // value of foo path parameter
            returned += "\n"+request.params();                 // map with all parameters
            returned += "\n"+request.pathInfo();               // the path info
            returned += "\n"+request.port();                   // the server port
            returned += "\n"+request.protocol();               // the protocol, e.g. HTTP/1.1
            returned += "\n"+request.queryMap();               // the query map
            returned += "\n"+request.queryMap("foo");          // query map for a certain parameter
            returned += "\n"+request.queryParams();            // the query param list
            returned += "\n"+request.queryParams("FOO");       // value of FOO query param
            returned += "\n"+request.queryParamsValues("FOO");  // all values of FOO query param
            returned += "\n"+request.raw();                    // raw request handed in by Jetty
            returned += "\n"+request.requestMethod();          // The HTTP method (GET, ..etc)
            returned += "\n"+request.scheme();                 // "http"
            returned += "\n"+request.servletPath();            // the servlet path, e.g. /result.jsp
            returned += "\n"+request.session();                // session management
            returned += "\n"+request.splat();                  // splat (*) parameters
            returned += "\n"+request.uri();                    // the uri, e.g. "http://example.com/foo"
            returned += "\n"+request.url();                    // the url. e.g. "http://example.com/foo"
            returned += "\n"+request.userAgent();              // user agent

            /* returned += "\n"+response.body();               // get response content
                             response.body("Hello");        // sets content to Hello
                            response.header("FOO", "bar"); // sets header FOO with value bar
             returned += "\n"+response.raw();                // raw response handed in by Jetty
                            //response.redirect("/example"); // browser redirect to /example
             returned += "\n"+response.status();             // get the response status
                            // response.status(401);          // set status code to 401
             returned += "\n"+response.type();               // get the content type
                             response.type("text/xml");     // set content type to text/xml*/

            return returned;
        });

        /*post("/", (request, response) -> {
            // Create something
        });

        put("/", (request, response) -> {
            // Update something
        });

        delete("/", (request, response) -> {
            // Annihilate something
        });

        options("/", (request, response) -> {
            // Appease something
        });*/




    }
}
