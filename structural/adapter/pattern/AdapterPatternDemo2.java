package structural.adapter.pattern;

/*
어댑터 패턴
어댑터 패턴은 호환되지 않는 두 인터페이스 간의 브리지 역할을 합니다. 이 유형의 디자인 패턴은 이 패턴이 두 개의 독립적인 인터페이스 기능을 결합하기 때문에 구조적 패턴에 속합니다.

이 패턴에는 독립적이거나 호환되지 않는 인터페이스의 기능을 결합하는 단일 클래스가 포함됩니다. 실생활의 예는 메모리 카드와 노트북 사이의 어댑터 역할을 하는 카드 리더기의 경우일 수 있습니다. 노트북을 통해 메모리 카드를 읽을 수 있도록 메모리 카드를 카드 판독기에 연결하고 카드 판독기를 노트북에 연결합니다.

오디오 플레이어 장치가 mp3 파일만 재생할 수 있고 vlc 및 mp4 파일을 재생할 수 있는 고급 오디오 플레이어를 사용하려는 다음 예제를 통해 어댑터 패턴의 사용을 시연하고 있습니다.

구현
인터페이스 MediaPlayer 인터페이스와 MediaPlayer 인터페이스를 구현 하는 구체적인 클래스 AudioPlayer 가 있습니다. AudioPlayer 는 기본적으로 mp3 형식의 오디오 파일을 재생할 수 있습니다.

다른 인터페이스 AdvancedMediaPlayer 와 AdvancedMediaPlayer 인터페이스를 구현하는 구체적인 클래스가 있습니다. 이 클래스는 vlc 및 mp4 형식 파일을 재생할 수 있습니다.

AudioPlayer 가 다른 형식도 재생 하도록 만들고 싶습니다 . 이를 달성하기 위해 MediaPlayer 인터페이스 를 구현하고 AdvancedMediaPlayer 개체를 사용하여 필요한 형식을 재생 하는 어댑터 클래스 MediaAdapter 를 만들었습니다.

AudioPlayer 는 원하는 형식을 재생할 수 있는 실제 클래스를 모르고 원하는 오디오 유형을 전달 하는 어댑터 클래스 MediaAdapter 를 사용합니다. AdapterPatternDemo , 데모 클래스는 AudioPlayer 클래스를 사용하여 다양한 형식을 재생합니다.
 */

public class AdapterPatternDemo2 {
    public static void main(String...args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}

interface MediaPlayer {
    public void play(String audioType, String fileName);
}

interface AdvancedMediaPlayer {
    public void playVlc(String fileName);
    public void playMp4(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
       System.out.println("Playing vlc file. Name: "+fileName); 
    }

    @Override
    public void playMp4(String fileName) {
    }

}

class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
    }

    @Override
    public void playMp4(String fileName) {
       System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}

class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer = new VlcPlayer();
        } else if(audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }



    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(fileName);
        } else if(audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}

class AudioPlayer implements MediaPlayer {

    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        
        if(audioType.equalsIgnoreCase("mp3")){
        //inbuilt support to play mp3 music files
            System.out.println("Playing mp3 file. Name: " +fileName);
        } else if(audioType.equalsIgnoreCase("vlc")
                    || audioType.equalsIgnoreCase("mp4")
                ){
        //mediaAdapter is providing support to play other file formats
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
        
    }

}
