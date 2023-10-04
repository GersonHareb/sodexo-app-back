package sodexo.news.app.sodexonewsappback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sodexo.news.app.sodexonewsappback.entity.Noticia;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<Noticia, Integer> {
    List<Noticia> findByTitleContainingIgnoreCase(String palabraClave);
}
