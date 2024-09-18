package es.uned.lsi.eped.pract2023_2024;
import es.uned.lsi.eped.DataStructures.*;



public class PlayListManager implements PlayListManagerIF{
    private List<PlayList> playlists;
    private List<String> idPlaylist;

    public PlayListManager(){
        playlists = new List<PlayList>();
        idPlaylist = new List<String>();
    }

    /* Comprueba si existe una lista de reproducción dado su identificador     */
    public boolean contains(String playListID){
        return idPlaylist.contains(playListID);
    }

    /* Devuelve la lista de reproducción asociada a un identificador           */

    public PlayListIF getPlayList(String playListID){
        boolean encontrado = false;
        PlayList p = null;
        for(int i = idPlaylist.size(); i>0 && !encontrado; i--){
            if(idPlaylist.get(i).equals(playListID)){
                p = playlists.get(i);
                encontrado = true;
            }
        }
        return p;
    }

    /*
    *   public PlayListIF getPlayList2(String playListID){
        IteratorIF<String> it;
        int pos;

        pos = 0;
        it = idPlaylist.iterator();
        while(it.hasNext()){ // damos por hecho que lo va a encontrar
            if(it.getNext().equals(playListID)){
                return playlists.get(pos);
            }
            else {
                pos++;
            }
        }

    }
    * */

    /* Devuelve una lista con todos los identificadores de las listas de       */
    /* reproducción existentes                                                 */
    public ListIF<String> getIDs(){
        return idPlaylist;
    }

    /* Crea una nueva lista de reproducción vacía y la asocia a un nuevo       */
    /* identificador                                                           */
    public void createPlayList(String playListID){
        playlists.insert(idPlaylist.size()+1 , new PlayList());
        idPlaylist.insert(idPlaylist.size()+1 , playListID);
    }

    /* Elimina una lista de reproducción asociada a un identificador           */
    /* @param   -una cadena de caracteres no vacía con el identificador de la  */
    public void removePlayList(String playListID){
        int i;
        boolean encontrado = false;
        for(i = 1; i<idPlaylist.size()+1 && !encontrado; i++){
            if(idPlaylist.get(i).equals(playListID)) {
                encontrado = true;
            }
        }
        playlists.remove(i-1);
        idPlaylist.remove(i-1);

    }


}
