import java.util.Iterator;

/**
 * 284. Peeking Iterator
 * Medium---
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {

    private Integer peek;
    private Iterator<Integer> iterator;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.peek = iterator.next();
        this.iterator = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer r = peek;
        peek = iterator.hasNext() ? iterator.next() : null;
	    return r;
	}
	
	@Override
	public boolean hasNext() {
        return peek != null;
	}
}