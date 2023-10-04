package sodexo.news.app.sodexonewsappback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sodexo.news.app.sodexonewsappback.entity.Noticia;
import sodexo.news.app.sodexonewsappback.repositories.NewsRepository;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsRepository nr;

    public List<Noticia> getFavorites(){
        return nr.findAll();
    }

    public Noticia saveFavorite(Noticia noticia){
        return nr.save(noticia);
    }

    public void deleteFavorite(int id){
        nr.deleteById(id);
    }

    public List<Noticia> buscarNoticia(String palabraClave) {
        return nr.findByTitleContainingIgnoreCase(palabraClave);
    }
}
