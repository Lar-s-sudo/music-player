package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.Collection;
import es.uned.lsi.eped.DataStructures.*;

public class Player implements PlayerIF{
    TuneCollectionIF collection;
    RecentlyPlayed recentlyPlayed;
    PlayBackQueue playBackQueue;
    PlayListManager playListManager;

    /* Devuelve los identificadores de todas las listas de reproducción        */
    /* existentes                                                              */
    public Player(TuneCollectionIF T, int maxRecentlyplayed){
        collection = T;
        recentlyPlayed = new RecentlyPlayed(maxRecentlyplayed);
        playBackQueue = new PlayBackQueue();
        playListManager = new PlayListManager();
    }

    public ListIF<String> getPlayListIDs(){
        return playListManager.getIDs();
    }

    /* Devuelve el contenido de una lista de reproducción                      */
    public ListIF<Integer> getPlayListContent(String playListID){
        return playListManager.getPlayList(playListID).getPlayList();
    }

    /* Devuelve los identificadores de las canciones contenidas en la cola de  */
    public ListIF<Integer> getPlayBackQueue(){
        return playBackQueue.getContent();
    }

    /* Devuelve los identificadores de las últimas canciones reproducidas que  */
    public ListIF<Integer> getRecentlyPlayed(){
        return recentlyPlayed.getContent();
    }

    /* Crea una nueva lista de reproducción a partir de su identificador       */
    /* @pos     -si no existe una lista de reproducción con ese identificador, */
    /*          se crea                                                        */
    /*          -en caso contrario, no se hace nada                            */
    public void createPlayList(String playListID){
        if(!playListManager.contains(playListID)) {
            playListManager.createPlayList(playListID);
        }
    }

    /* Elimina una lista de reproducción del reproductor a partir de su        */
    /* identificador                                                           */
    /* @pos     -si existe una lista de reproducción con ese identificador, se */
    /*          elimina                                                        */
    /*          -en caso contrario, no se hace nada                            */
    public void removePlayList(String playListID){
        if(playListManager.contains(playListID)) {
            playListManager.removePlayList(playListID);
        }
    }

    /* Añade una lista de identificadores de canciones del repositorio a una   */
    /* lista de reproducción                                                   */
    /* @pre     -todos los elementos de la lista son identificadores de        */
    /*          canciones que existen dentro del repositorio                   */
    /* @pos     -si existe una lista de reproducción con ese identificador, se */
    /*          añaden a ella los identificadores contenidos en la lista       */
    /*          -en caso contrario, no se hace nada                            */
    public void addListOfTunesToPlayList(String playListID,ListIF<Integer> lT){
        if(playListManager.contains(playListID)) {
            playListManager.getPlayList(playListID).addListOfTunes(lT);
        }
    }

    /* Añade los identificadores de todas las canciones del repositorio que    */
    /* cumplan los criterios indicados a una lista de reproducción             */
    /* @pos     -si existe una lista de reproducción con ese identificador, se */
    /*          añaden a ella los identificadores de todas las canciones del   */
    /*          repositorio que cumplan todos los criterios indicados          */
    /*          -en caso contrario, no se hace nada                            */
    public void addSearchToPlayList(String playListID,
                                    String t, String a, String g, String al,
                                    int min_y, int max_y,
                                    int min_d, int max_d){

        if(playListManager.contains(playListID)) {
            List<Integer> lista = new List<Integer>();
            int pos =1;
            for(int i = 1; i <= collection.size(); i++) {
                Query q = new Query(t, a, g, al, min_y, max_y, min_d, max_d);
                if(collection.getTune(i).match(q)){
                    lista.insert(pos, i);
                    pos++;
                }
            }
            playListManager.getPlayList(playListID).addListOfTunes(lista);
        }
    }

    /* Elimina una canción de una lista de reproducción                        */
    /* @pos     -si existe una lista de reproducción con se identificador, se  */
    /*          elimina de dicha lista todas las apariciones del identificador */
    /*          de la canción del repositorio pasada como parámetro            */
    /*          -en caso contrario, no se hace nada                            */
    public void removeTuneFromPlayList(String playListID,int tuneID){
        if(playListManager.contains(playListID)) {
            playListManager.getPlayList(playListID).removeTune(tuneID);
        }
    }

    /* Añade una lista de identificadores de canciones del repositorio a la    */
    /* cola de reproducción                                                    */
    /* @pre     -todos los elementos de la lista son identificadores de        */
    /*          canciones que existen dentro del repositorio                   */
    /* @pos     se añaden a la cola de reproducción los identificadores de las */
    /*          canciones contenidos en la lista                               */
    public void addListOfTunesToPlayBackQueue(ListIF<Integer> lT){
        playBackQueue.addTunes(lT);
    }

    /* Añade los identificadores de todas las canciones del repositorio que    */
    /* cumplan los criterios indicados a la cola de reproducción               */
    /* @pos     se añaden a la cola de reproducción los identificadores de     */
    /*          todas las canciones del repositorio que cumplan todos los      */
    /*          criterios indicados                                            */
    public void addSearchToPlayBackQueue(String t, String a, String g, String al,
                                         int min_y, int max_y,
                                         int min_d, int max_d){
        Query q = new Query(t, a, g, al, min_y, max_y, min_d, max_d);
        List<Integer> lista = new List<Integer>();
        int pos = 1;
        for(int i = 1; i <= collection.size(); i++) {
            if(collection.getTune(i).match(q)){
                lista.insert(pos, i);
                pos++;
            }
        }
        playBackQueue.addTunes(lista);
    }

    /* Añade el contenido de una lista de reproducción a la cola de            */
    /* reproducción                                                            */
    /* @param   -una cadena de caracteres no vacía con el identificador de la  */
    /*          lista de reproducción cuyo contenido se desea añadir a la cola */
    /*          de reproducción                                                */
    /* @pos     -si existe una lista de reproducción con se identificador, se  */
    /*          añade su contenido a la cola de reproducción                   */
    /*          -en caso contrario, no se hace nada                            */
    public void addPlayListToPlayBackQueue(String playListID){
        if(playListManager.contains(playListID)) {
            ListIF lista = playListManager.getPlayList(playListID).getPlayList();
            playBackQueue.addTunes(lista);
        }
    }

    /* Vacía la cola de reproducción                                           */
    public void clearPlayBackQueue(){
        playBackQueue.clear();
    }

    /* Reproduce la siguiente canción en la cola de reproducción               */
    /* @pos     -si la cola de reproducción no es vacía, se elimina de ella el */
    /*          primer elemento, pasando éste a la estructura que almacena las */
    /*          últimas canciones reproducidas, sin sobrepasar su tamaño       */
    /*          máximo                                                         */
    /*          -en caso contrario, no se hace nada                            */
    public void play(){
        if(!playBackQueue.isEmpty()){
            recentlyPlayed.addTune(playBackQueue.getFirstTune());
            playBackQueue.extractFirstTune();
        }
    }
}
