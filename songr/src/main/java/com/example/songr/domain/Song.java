package com.example.songr.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@JsonIgnoreProperties({"album"})
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    private String title;
    @NonNull
    private String length;
    @NonNull
    private int TrackNumber;

//    public Song( String title,  String length, int trackNumber) {
//        this.title = title;
//        this.length = length;
//        TrackNumber = trackNumber;
//
//    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @ManyToOne
    Album album;


}
