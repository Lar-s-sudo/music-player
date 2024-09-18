package es.uned.lsi.eped.pract2023_2024;
import es.uned.lsi.eped.DataStructures.*;
public class RecentlyPlayed implements RecentlyPlayedIF{
    private int max_size;
    private Stack<Integer> recientes;

    public RecentlyPlayed(int max_size){
        this.max_size = max_size;
        recientes = new Stack<>();
    }

    /* Devuelve los identificadores de las últimas canciones reproducidas en   */
    /* el orden inverso al que fueron reproducidas                             */
    public ListIF<Integer> getContent(){
        int pos = 1;
        List<Integer> lista = new List<Integer>();
        IteratorIF<Integer> iterator = this.recientes.iterator();
        while(iterator.hasNext()){
            lista.insert(pos, iterator.getNext());
            pos++;
        }
        return lista;
    }

    /* Añade la última canción reproducida                                     */
    /* @param   -un entero con el identificador de la última canción           */
    /*          reproducida                                                    */
    public void addTune(int tuneID){
        if(recientes.size() < max_size){
            recientes.push(tuneID);
        }
    }
}

