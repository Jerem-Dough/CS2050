public class Album {
    private String Title;
    private String Artist;
    private String Genre;
    private int Songs;

    public Album(){
        Title = "Renaissance";
        Artist = "Beyonce";
        Genre = "Easy Listening";
        Songs = 10;
    }
    public Album(String Title, String Artist, String Genre, int Songs) {
        this.Title = Title;
        this.Artist = Artist;
        this.Genre = Genre;
        this.Songs = Songs;
    }
    public void setTitle(String Title){
        this.Title = Title;
    }
    public void setArtist(String Artist){
        this.Artist = Artist;
    }
    public void setGenre(String Genre){
        this.Genre = Genre;
    }
    public void setSongs(int Songs){
        this.Songs = Songs;
    }
    public String getTitle(){
        return Title;
    }
    public String getArtist(){
        return Artist;
    }
    public String getGenre(){
        return Genre;
    }
    public int getSongs(){
        return Songs;
    }
    public String toString(){
        return "Title: "+Title+"\nArtist: "+Artist+"\nGenre: "+Genre+"\nSongs: "+Songs;
    }
}
