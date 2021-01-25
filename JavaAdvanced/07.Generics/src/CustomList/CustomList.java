package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zlatimir Ivanov on 14.1.2021 г..
 */

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList(){
        this.list = new ArrayList<>();
    }

    public  void add(T element){
        this.list.add(element);
    }

    public T remove(int index){
        validateIndex(index);
        return this.list.remove(index);
    }

    private void validateIndex(int index) {
        if (index < 0 || index > this.list.size()){
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for size " + this.list.size());
        }
    }


    public boolean contains(T element){
        if (this.list.contains(element)){
            return true;
        }
        return false;
    }

    public void swap(int first, int second){
        validateIndex(first);
        validateIndex(second);

        T tempFirst = this.list.get(first);
        T tempSecond = this.list.get(second);
        this.list.remove(first);
        this.list.add(first, tempSecond);
        this.list.remove(second);
        this.list.add(second, tempFirst);
    }

    public int countGreaterThan(T element){
        int count = 0;
        for (T t : list) {
            if (t.compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }

    public T getMax(){
        return Collections.max(this.list);
    }

    public T getMin(){
        return Collections.min(this.list);
    }

    public void print(){
        for (T t : list) {
            System.out.println(t);
        }
    }
}
