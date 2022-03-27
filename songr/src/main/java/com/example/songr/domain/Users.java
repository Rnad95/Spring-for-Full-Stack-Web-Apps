package com.example.songr.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    @NonNull
    private String username;
    @NonNull
    private String hashedPassword;

    @OneToMany(mappedBy = "users")
    public Set<Post> posts;

    public void setUser(Post post){
        posts.add(post);

    }
}
