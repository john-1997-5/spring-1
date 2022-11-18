package com.johnson.spring.domain.speaker;

import com.johnson.spring.domain.song.Song;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@Slf4j
public class SonySpeaker implements Speaker {
    @Override
    public void makeSound(Song song) {
        log.info("-> Playing {} by {} with Sony speakers", song.getTitle(), song.getSingerName());
    }
}
