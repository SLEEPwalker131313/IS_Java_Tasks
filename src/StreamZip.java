import java.util.stream.Stream;
import java.util.ArrayList;

class StreamZip {
    static Stream zip(Stream firstStream, Stream secondStream) {
        Zipilder<Object> zip = new Zipilder<>();
        Object[] firstList = firstStream.toArray();
        Object[] secondList = secondStream.toArray();
        for (int i = 0; i < Math.min(firstList.length, secondList.length); ++i) {
            zip.add(firstList[i]);
            zip.add(secondList[i]);
        }
        return zip.build();
    }
}

class Zipilder<T> implements Stream.Builder<T> {
    private ArrayList<T> container = null;

    public Stream<T> build() {
        return container.stream();
    }

    public void accept(T elem) {
        if(container == null)
            container = new ArrayList<T>();
        if (elem != null)
            container.add(elem);
    }

    public Stream.Builder<T> add(T obj) {
        this.accept(obj);
        return this;
    }
}
