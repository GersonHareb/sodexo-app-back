package sodexo.news.app.sodexonewsappback.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sodexo.news.app.sodexonewsappback.entity.Noticia;
import sodexo.news.app.sodexonewsappback.repositories.NewsRepository;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;

public class NewsServiceTest {

    @InjectMocks
    private NewsService newsService;

    @Mock
    private NewsRepository newsRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFavorites() {
        // Arrange
        List<Noticia> noticias = new ArrayList<>();
        noticias.add(new Noticia());
        noticias.add(new Noticia());

        when(newsRepository.findAll()).thenReturn(noticias);

        // Act
        List<Noticia> result = newsService.getFavorites();

        // Assert
        Assertions.assertEquals(noticias.size(), result.size());
        verify(newsRepository, times(1)).findAll();
    }

    @Test
    public void testSaveFavorite() {
        // Arrange
        Noticia noticia = new Noticia();

        when(newsRepository.save(noticia)).thenReturn(noticia);

        // Act
        Noticia result = newsService.saveFavorite(noticia);

        // Assert
        Assertions.assertEquals(noticia, result);
        verify(newsRepository, times(1)).save(noticia);
    }

    @Test
    public void testDeleteFavorite() {
        // Arrange
        int id = 1;

        // Act
        newsService.deleteFavorite(id);

        // Assert
        verify(newsRepository, times(1)).deleteById(id);
    }
}
