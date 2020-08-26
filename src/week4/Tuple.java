package week4;

public class Tuple<K,V> {
    public final K key;
    public final V value;
    public Tuple(K key,V value){
        this.key = key;
        this.value = value;
    }
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
    public Tuple getTuple(){
        Tuple<K,V> t = new Tuple(this.key,this.value);
        return t;
    }
}
