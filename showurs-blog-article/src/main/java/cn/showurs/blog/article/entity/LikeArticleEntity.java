package cn.showurs.blog.article.entity;

import javax.persistence.*;

/**
 * Created by CJ on 2019/1/28 14:30.
 */
@Entity
@Table(name = "like_article", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "article_id"})})
public class LikeArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id", nullable = false)
    private ArticleEntity article;
}
