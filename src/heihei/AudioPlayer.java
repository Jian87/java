/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heihei;

import java.util.HashMap;
import java.util.Map;
import org.newdawn.slick.Sound;
import org.newdawn.slick.Music;

/**
 *
 * @author lixua
 */
public class AudioPlayer {
    public static Map<String, Sound> soundMap = new HashMap<>();
    public static Map<String, Music> musicMap = new HashMap<>();
    
    public static void init(){
        try{
            soundMap.put("menu_sound", new Sound("Audio/backgroud_sound.ogg"));
            musicMap.put("music", new Music("Audio/play_music.ogg"));
        }catch(SlickException e) {
            e.printStackTrace();
        }
    }
    
    public static Sound getSound(String key) {
        return soundMap.get(key);
    }
    
    public static Music getMusic(String key) {
        return musicMap.get(key);
    }
}
