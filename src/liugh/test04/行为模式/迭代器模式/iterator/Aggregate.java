package liugh.test04.行为模式.迭代器模式.iterator;

/**
 * 聚集接口
 * 
 * @author liu yuning
 *
 * @param <T>
 */
public interface Aggregate<T> {

    public Iterator<T> createIterator();
}
