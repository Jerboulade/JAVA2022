package be.technifutur.java.timairport.demo;

import be.technifutur.java.timairport.demo.DemoForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {
    // RESTapi big concept:
    // --------------------
    // - client/server
    // - stateless
    // - code on demand
    // - bonne utilisation des methods

    // Récupérable depuis la requête HTTP:
    // -----------------------------------
    // - URL/URI: chemin
    //      - variable de chemin: segment de l'URI dont on a laissé le choix de la valeur
    //      - parametre: (ex: http://localhost:8080/machin/truc?param=value)
    // - method: type de requête envoyée, determine l'action attendue:
    //      GET:    récupérer une/plusieurs ressource.s
    //      POST:   envoyer/créer un ressource
    //      PUT:    remplacer un ressource (modifier intégralement)
    //      PATCH:  modifier partiellement une ressource
    //      DELETE: supprimer une ressources
    // - headers: meta-data sur la requête (map of key->multi-value) -> content-type, cookies, ...
    // - body: contenu de la requête

    // Dans la réponse HTTP:
    // ---------------------
    // - status: code représentant succès/échec de la requête (404, 500)
    // - headers: méta-data de la réponse (représentation du type de donné)
    // - body: contenu de la réponse


    // Ce qui se trouve dans l'URL
    @GetMapping("/url/{var:[A-Z]{1,3}}")
    public void displayUrlInfo( @PathVariable("var") String variable, @RequestParam int param ){
        System.out.println(variable); // variable de chemin {var}
        System.out.println(param); // valeur du parametre param
    }

    // 'consumes' vérifie la valeur du header "content-type" de la requête
    // (valeur par défaut : "application/json")
    @PostMapping(value = "/body", consumes = "application/json")
    public void  displayBody( @RequestBody @Valid DemoForm body ){
        System.out.println(body);
    }

    @GetMapping("/header")
    public void displayHeader(@RequestHeader String accept){
        System.out.println(accept);
    }

    @GetMapping("/params/all")
    public void displayAllParam(@RequestParam Map<String, String> params){
        params.forEach((key, value) -> System.out.printf("%s : %s\n", key, value));
    }

    /*
    @GetMapping("/header/all")
    public void displayAllHeader(@RequestHeader MultiValueMap<String, String> headers){
        headers.forEach((key, value) -> System.out.printf("%s : %s\n", key, value));
    }
    */

    @GetMapping("/header/all")
    public void displayAllHeader(@RequestHeader HttpHeaders headers){
        headers.forEach((key, value) -> System.out.printf("%s : %s\n", key, value));
    }

    @GetMapping("/other")
    public void displayRequest(HttpServletRequest requests){
        System.out.println(requests.getRequestURI());
        System.out.println(requests.getRequestURL());
        System.out.println(requests.getMethod());
    }

    // Différence @Controller & @RestController
    // ----------------------------------------
    // @RestController = @Controller + @RequestBody(in param field)
    // Body - return type
    // Status
    // Headers

    // 'produces' donne une valeur au header "content-type" de la réponse
    @GetMapping(value = "/response/basic", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)

    // @ResponseBody : pas nécessaire car @RestController
    public String createBasicResponse(){
        return """
                <!doctype html>
                       <html lang="en">
                       <head>
                           <meta charset="UTF-8">
                           <meta name="viewport"
                                 content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
                           <meta http-equiv="X-UA-Compatible" content="ie=edge">
                           <title>Document</title>
                       </head>
                       <body>
                       <p>Hello from Postman</p>
                       </body>
                       </html>
                """;
    }

    @GetMapping("/response/detailed")
    public ResponseEntity<String> createDetailedResponse(){
        // passer par un builder
        /*
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>("ma réponse", headers, HttpStatus.OK);
        */

        // ou passer par un constructeur
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body("my response");
    }
}
