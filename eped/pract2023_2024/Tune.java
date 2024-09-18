package es.uned.lsi.eped.pract2023_2024;

public class Tune implements TuneIF{
    private String title;
    private String author;
    private String genre;
    private String album;
    private int year;
    private int duration;
    // private Query query;


    public Tune(String title, String author, String genre, String album, int year, int duration){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.album = album;
        this.year = year;
        this.duration = duration;
        //Query query = new Query();
    }


    /* Dado un objeto QueryIF conteniendo unos criterios de búsqueda, devuelve */
    /* un valor de verdad indicando si la canción los cumple o no los cumple   */
    public boolean match(QueryIF q){
        if(q.getTitle() == " " || q.getTitle().equals(title)){
            if(q.getAuthor() == " " || q.getAuthor().equals(author)){
                if(q.getGenre() == " " || q.getAlbum().equals(genre)){
                    if (q.getMin_year() == -1 || q.getMin_year() <= year){
                        if(q.getMax_year() == -1 || q.getMax_year() >= year) {
                            if(q.getMin_duration() == -1 || q.getMin_duration() <= duration){
                                if(q.getMax_duration() == -1 || q.getMax_duration() >= duration){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

}
