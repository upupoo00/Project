package Java_0120;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 泛型：
 */
class MyArrayList{
    public int[] elem;
    public int usedSize;
}
public class TestDemo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("abcdef");
        collection.add("aabbc");
        System.out.println(collection);
        collection.clear();
        System.out.println(collection);
    }
}

