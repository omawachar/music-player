package musicplayer;

public class Song {
    String title;
    double duration;

    public Song(String title, double duration){
        this.title=title;
        this.duration=duration;
    }
    public Song(){

    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {      //simply it will returns all contains in the class
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
