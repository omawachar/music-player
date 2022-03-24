package musicplayer;

import java.util.ListIterator;
import java.util.*;

public class Main
{
    private static ArrayList<Album> albums= new ArrayList<>();
    public static void main(String[] args)
    {

        Album album=new Album(" Album1","AC/DC");

        album.addSong("TNT",4.5);
        album.addSong("Highway to hell",3.5);
        album.addSong("ThunderStruck",5.0);
        albums.add(album);

         album =new Album("Album2","Eminem");

        album.addSong("Rap god",4.5);
        album.addSong("Not Affraid",3.5);
        album.addSong("Lose yourself",4.5);
        album.addSong("Ring Ring",5.5);

        albums.add(album);

        LinkedList<Song> playList_1 =new LinkedList<>();

        albums.get(0).addToPlayList("TNT",playList_1);
        albums.get(0).addToPlayList("Highway to hell",playList_1);
        albums.get(1).addToPlayList("Rap god",playList_1);
        albums.get(1).addToPlayList("Lose yourself",playList_1);

        play(playList_1);
    }

    private  static void play(LinkedList<Song> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quite = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("This playList have no song");
        } else {
            System.out.println("Now Playing song is " +listIterator.next().toString());
            prinrMenu();
        }

        while (!quite)
        {
            int action =sc.nextInt();
            sc.nextLine();

            switch(action){

                case 0 :
                    System.out.println("PlayList complete ");
                    quite=true;
                    break;

                case 1 :
                   if(forward=false)
                   {
                           if(listIterator.hasNext())
                           {
                           listIterator.next();
                           }
                            forward=true;
                   }
                   if(listIterator.hasNext())
                   {
                       System.out.println("Now playing " + listIterator.next().toString());
                   }
                   else
                   {
                       System.out.println("No song available , reached to the end of the list");
                       forward=false;
                   }
                   break;

                case 2 :
                    if(forward=true)
                    {
                        if(listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }
                    else{
                        System.out.println("We are at the first song  ");
                        forward=false;
                    }
                    break;

                case 3 :
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward=false;
                        }
                        else{
                            System.out.println("Now we are at  the start of the list");
                        }
                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward=true;
                        }else{
                            System.out.println("We have reached to the end of the list");
                        }
                    }
                    break;

                case 4 :
                    printList(playList);
                    break;

                case 5 :
                    prinrMenu();
                    break;

                case 6 :
                    if (playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                        }
                        else{
                            if(listIterator.hasPrevious())
                            System.out.println("Now playing " + listIterator.previous().toString());
                        }
                    }

            }
        }
    }
    private static  void prinrMenu(){
        System.out.println("Available options\n press ");
        System.out.println("0 - to quite\n" +
                           " 1 - to play next song\n" +
                           "2 - to play previous song\n" +
                           "3 - to replay the current song\n" +
                           "4 - List of all songs\n" +
                           "5 - print all available options\n"+
                           "6 - delete current song ");
    }

    private static  void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("---------------");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("---------------");
    }

}
