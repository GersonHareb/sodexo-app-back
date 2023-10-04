package sodexo.news.app.sodexonewsappback.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "noticias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Noticia {
    @Id
    private int id;
    private String title;
    @Column(length = 1000)
    private String summary;
    private String image_url;
    private String url;
    private String published_at;
}
