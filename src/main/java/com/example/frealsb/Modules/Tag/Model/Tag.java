package com.example.frealsb.Modules.Tag.Model;

import com.example.frealsb.Common.AbstractEntity;
import com.example.frealsb.Modules.Post.Model.Post;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Tag extends AbstractEntity {
    @Column(length = 30, nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Collection<Post> posts = new ArrayList<>();
}
