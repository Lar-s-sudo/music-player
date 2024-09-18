package es.uned.lsi.eped.pract2023_2024;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.*;


/* Representación de una lista de reproducción                               */
public class PlayList implements PlayListIF{
    private List<Integer> playlist;
    public PlayList(){
        playlist = new List<Integer>();
    }
    /* Devuelve la lista de identificadores de canciones de la lista de        */

    public ListIF<Integer> getPlayList(){
        return playlist;
    }

    /* Añade una lista de identificadores de canciones a la lista de           */
    /* reproducción                                                            */
    public void addListOfTunes(ListIF<Integer> lT){
        int pos = 1;
        if(playlist == null){
            pos = 1;
        }else{
            pos = playlist.size() + 1;
        }
        IteratorIF<Integer> it = lT.iterator();
        while(it.hasNext()) {
            int tune = it.getNext();
            playlist.insert(pos, tune);
            pos++;
        }
    }

    /* Elimina todas las apariciones de un identificador de canción de la      */
    /* lista de reproducción                                                   */
    public void removeTune(int tuneID){
        for(int i = playlist.size(); i >= 1; i--){
            if(playlist.get(i) == tuneID){
                playlist.remove(i);
            }
        }
    }

}


