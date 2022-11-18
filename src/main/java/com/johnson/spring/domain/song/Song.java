package com.johnson.spring.domain.song;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class Song {
    private String title;
    private String singerName;
    public Song() {
        this.title = "Billie Jean";
        this.singerName = "Michael Jackson";
    }
}