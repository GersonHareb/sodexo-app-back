package sodexo.news.app.sodexonewsappback.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sodexo.news.app.sodexonewsappback.entity.Noticia;
import sodexo.news.app.sodexonewsappback.service.NewsService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NewsControllerTest {

    @InjectMocks
    private NewsController newsController;

    @Mock
    private NewsService newsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFavorites() {
        // Arrange
        List<Noticia> noticias = Arrays.asList(new Noticia(), new Noticia());
        when(newsService.getFavorites()).thenReturn(noticias);

        // Act
        ResponseEntity<List<Noticia>> response = newsController.getFavorites();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(noticias, response.getBody());
    }

    @Test
    public void testAgregarFavorito() {
        // Arrange
        Noticia noticia = new Noticia();
        when(newsService.saveFavorite(noticia)).thenReturn(noticia);

        // Act
        ResponseEntity<Noticia> response = newsController.agregarFavorito(noticia);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(noticia, response.getBody());
    }

    @Test
    public void testEliminarFavorito() {
        // Arrange
        int id = 1;

        // Act
        ResponseEntity<?> response = newsController.eliminarFavorito(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(newsService, times(1)).deleteFavorite(id);
    }
}
