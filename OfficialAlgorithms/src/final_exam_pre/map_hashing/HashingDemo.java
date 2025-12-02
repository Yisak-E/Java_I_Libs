package final_exam_pre.map_hashing;

import java.util.*;

public class HashingDemo {
    public static void main(String[] args) {
        MyHashTable<String, Integer> name_age = new MyHashTable<>(10);

    }

}

class MyHashTable<K,V>{

    private static class Entry<K,V>{
        K key;
        V value;
        public Entry(){}
        public Entry(K key,V value){
                this.key=key;
                this.value=value;
        }

        @Override
        public String toString(){
            return key+":"+value;
        }
    }

    private LinkedList<Entry<K,V>>[] array;
    private int size;

    public MyHashTable(int tableSize){
           if(tableSize<=0){
               tableSize=13;
           }
           array = (LinkedList<Entry<K,V>>[])new LinkedList[tableSize];
           size = 0;
           for(int i=0;i<tableSize;i++){
               array[i] = new LinkedList<>();
           }
    }

    // hashing : int
    public int hash(K key){
        return Math.abs(key.hashCode()) %array.length;
    }


    //insert item : void
    public void insert(K key,V value){
        int index = hash(key);
        for(Entry<K,V> e:array[index]){
            if(e.key.equals(key)){
                e.value = value;
                return;
            }
        }
        array[index].add(new Entry<>(key,value));
        size++;
    }

    //remove item -> boolean

    public boolean removeItem(K key){
        int index = hash(key);
        Iterator<Entry<K,V>> it = array[index].listIterator();
        while(it.hasNext()){
            Entry<K,V> e = it.next();
            if(e.key.equals(key)){
                it.remove();
                size--;
                return true;
            }
        }
        return false;
    }

    //get item by key
    public V getItemByKey(K key){
        int index = hash(key);
        for(Entry<K,V> e:array[index]){
            if(e.key.equals(key)){
                return e.value;
            }
        }
        return null;
    }

    //contains key
    public boolean containsKey(K key){
        V value = getItemByKey(key);
        return (value != null);
    }

    //get or default
    public V getOrDefault(K key, V defaultValue){
        V value = getItemByKey(key);
        return (value != null) ? value : defaultValue;
    }

    //put if absent
    public void putIfAbsent(K key,V value){
        if(!containsKey(key)){
            insert(key, value);
        }
    }

    //is empty
    public boolean isEmpty(){
        return size == 0;
    }

    //clear
    public void clear(){
        for (LinkedList<Entry<K, V>> bucket : array) {
            bucket.clear();
        }
        size = 0;
    }


    // key set
    public Set<K> keySet(){
        Set<K> set = new HashSet<>();
        for (LinkedList<Entry<K, V>> bucket : array) {
            for(Entry<K, V> e:bucket){
                set.add(e.key);
            }
        }
        return set;
    }


    //value set
    public List<V> values(){
        List<V> list = new ArrayList<>();
        for (LinkedList<Entry<K, V>> bucket : array) {
            for(Entry<K, V> e:bucket){
                list.add(e.value);
            }
        }
        return list;
    }

    //entry set
    public List<Map.Entry<K, V>> entrySet(){
        List<Map.Entry<K, V>> entries = new ArrayList<>();
        for (LinkedList<Entry<K, V>> bucket : array) {
            for(Entry<K, V> e:bucket){
                entries.add(new AbstractMap.SimpleEntry<>(e.key, e.value));
            }
        }
        return entries;
    }


}
