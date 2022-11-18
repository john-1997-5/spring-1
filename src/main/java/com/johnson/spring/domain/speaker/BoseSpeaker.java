package com.johnson.spring.domain.speaker;

import com.johnson.spring.domain.song.Song;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BoseSpeaker implements Speaker{
    @Override
    public void makeSound(Song song) {
        log.info("-> Playing {} by {} with Bose speakers", song.getTitle(), song.getSingerName());
    }
}
