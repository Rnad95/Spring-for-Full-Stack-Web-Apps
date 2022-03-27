package com.example.songr.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int postId;
//    private int userId;
    private String textContent;

    public Post() {
    }

    public Post(String textContent) {
        this.textContent = textContent;
    }

    @ManyToOne
    @JoinTable(
            name = "posts",
            joinColumns = @JoinColumn(name = "postId"),
            inverseJoinColumns = @JoinColumn(name = "UserId")

    )
    Users users;


}

