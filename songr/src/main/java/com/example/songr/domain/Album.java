package com.example.songr.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;

@Entity
public class Album {
    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String artist;
    private int count;
    private String length;
    private String imageUrl;

    public Album() {
    }

    public Album(String title, String artist, int count, String length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.count = count;
        this.length = length+" sec";
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getCount() {
        return count;
    }

    public String getLength() {
        return length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", count=" + count +
                ", length='" + length + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
