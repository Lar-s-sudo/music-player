package es.uned.lsi.eped.pract2023_2024;
import es.uned.lsi.eped.DataStructures.*;



public class PlayBackQueue implements PlayBackQueueIF{

    private Queue<Integer> identificadores;

    public PlayBackQueue(){
        this.identificadores = new Queue<Integer>();
    }

    /* Devuelve una lista con los identificadores de las canciones contenidas  */
    public ListIF<Integer> getContent(){
        int pos = 1;
        List<Integer> lista = new List<Integer>();
        IteratorIF<Integer> iterator = this.identificadores.iterator();
        while(iterator.hasNext()){
            lista.insert(pos, iterator.getNext());
            pos++;
        }
        return lista;
    }

    /* Devuelve un booleano indicando si la cola de reproducción es vacía o no */
    public boolean isEmpty(){
        return this.identificadores.isEmpty();
    }

    /* Devuelve un entero con el identificador de la primera canción que está  */
    public int getFirstTune(){
        return this.identificadores.getFirst();
    }

    /* Extrae la primera canción que se encuentre en la cola de reproducción   */
    public void extractFirstTune(){
        this.identificadores.dequeue();
    }

    /* Añade una lista de identificadores de canciones a la cola de            */
    public void addTunes(ListIF<Integer> lT){
        IteratorIF<Integer> it = lT.iterator();
        while(it.hasNext()){
            int tune = it.getNext();
            identificadores.enqueue(tune);
        }
    }

    /* Vacía el contenido de la cola de reproducción                           */
    public void clear(){
        this.identificadores.clear();
    }



}
