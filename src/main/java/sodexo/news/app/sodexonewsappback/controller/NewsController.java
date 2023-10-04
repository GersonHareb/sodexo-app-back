package sodexo.news.app.sodexonewsappback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sodexo.news.app.sodexonewsappback.entity.Noticia;
import sodexo.news.app.sodexonewsappback.service.NewsService;

import java.util.List;

@RestController
@RequestMapping("/api/noticias")
@CrossOrigin(origins = "http://localhost:4200")
public class NewsController {
    @Autowired
    private NewsService ns;

    @GetMapping
    public ResponseEntity<List<Noticia>> getFavorites(){
        List<Noticia> noticias = ns.getFavorites();
        return new ResponseEntity<>(noticias, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<Noticia> agregarFavorito(@RequestBody Noticia noticia){
        Noticia favoritoGuardado = ns.saveFavorite(noticia);
        System.out.println(noticia);
        return new ResponseEntity<>(favoritoGuardado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarFavorito(@PathVariable int id){
        ns.deleteFavorite(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Noticia>> buscarNoticiasPorTitulo(@RequestParam("title") String palabraClave) {
        List<Noticia> noticias = ns.buscarNoticia(palabraClave);
        System.out.println("noticias: " + noticias);
        return new ResponseEntity<>(noticias, HttpStatus.OK);
    }
}
