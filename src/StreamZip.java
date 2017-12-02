import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class StreamZip {
    static Stream zip(Stream firstStream, Stream secondStream) {
        Iterator firstIterator = firstStream.iterator();
        Iterator secondIterator = secondStream.iterator();

        Iterator zipIterator = new Iterator() {
            boolean iteratorFlag = true;
            @Override
            public boolean hasNext() {
                if(iteratorFlag)
                    return firstIterator.hasNext();
                else
                    return secondIterator.hasNext();
            }

            @Override
            public Object next() {
                iteratorFlag = !iteratorFlag;
                if (iteratorFlag)
                    return secondIterator.next();
                else
                    return firstIterator.next();
            }
        };
        Iterable iterable = ()-> zipIterator;

        return StreamSupport.stream(iterable.spliterator(), false);
    }
}