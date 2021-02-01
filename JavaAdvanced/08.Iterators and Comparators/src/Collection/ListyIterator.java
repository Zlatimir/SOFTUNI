package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Zlatimir Ivanov on 29.1.2021 г..
 */

public class ListyIterator implements Iterable{
    private List<String> list;
    private int index;

    public ListyIterator(){
        this.list = new ArrayList<>();
        this.index = 0;
    }

    public void add(String string){
        this.list.add(string);
    }

    public boolean move(){
        if (index < list.size() - 1){
            index ++;
            return true;
        }
        return false;
    }

    public boolean hasNext(){
        if (index == list.size() - 1){
            return false;
        }
        return true;
    }

    public void print(){
        if (list.size() == 0){
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(list.get(index));
        }
    }

    @Override
    public Iterator iterator() {
        Iterator<String> iterator = list.iterator();
        return iterator;
    }

    @Override
    public void forEach(Consumer action) {

    }
}
