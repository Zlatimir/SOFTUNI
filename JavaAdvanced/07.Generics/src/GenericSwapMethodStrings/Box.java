package GenericSwapMethodStrings;

/**
 * Created by Zlatimir Ivanov on 14.1.2021 г..
 */

public class Box<T> {
    private T data;

    public Box(T data){
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data.getClass().getName() + ": " + this.data;
    }
}
