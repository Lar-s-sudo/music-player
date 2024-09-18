package es.uned.lsi.eped.pract2023_2024;
import es.uned.lsi.eped.DataStructures.*;

public class Query implements QueryIF{
    private String title;
    private String author;
    private String genre;
    private String album;
    private int min_year;
    private int max_year;
    private int min_duration;
    private int max_duration;

    public Query(String title, String author, String genre, String album, int min_year, int max_year, int min_duration, int max_duration){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.album = album;
        this.min_year = min_year;
        this.max_year = max_year;
        this.min_duration = min_duration;
        this.max_duration = max_duration;
    }

    /* Devuelve el criterio título                                             */
    /* @return  -una cadena de caracteres con el título de la canción buscada  */
    public String getTitle(){
        return title;
    }

    /* Devuelve el criterio autor                                              */
    /* @return  -una cadena de caracteres con el autor de la canción buscada   */
    public String getAuthor(){
        return author;
    }

    /* Devuelve el criterio género                                             */
    /* @return  -una cadena de caracteres con el género de la canción buscada  */
    public String getGenre(){
        return genre;
    }

    /* Devuelve el criterio álbum                                              */
    /* @return  --una cadena de caracteres con el álbum al que pertenece la    */
    /*          canción buscada                                                */
    public String getAlbum(){
        return album;
    }

    /* Devuelve el criterio año mínimo                                         */
    /* @return  -un entero con el primer año del intervalo en el que se grabó  */
    /*          la canción a buscar                                            */
    public int getMin_year(){
        return min_year;
    }

    /* Devuelve el criterio año máximo                                         */
    /* @return  -un entero con el último año del intervalo en el que se grabó  */
    /*          la canción a buscar                                            */
    public int getMax_year(){
        return max_year;
    }

    /* Devuelve el criterio duración mínima                                    */
    /* @return  -un entero con la duración mínima de la canción a buscar       */
    public int getMin_duration(){
        return min_duration;
    }

    /* Devuelve el criterio duración máxima                                    */
    /* @return  -un entero con la duración máxima de la canción a buscar       */
    public int getMax_duration(){
        return max_duration;
    }
}



