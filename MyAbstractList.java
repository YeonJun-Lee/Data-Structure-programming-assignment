/**
 *  Midterm2
 *  Abstract class that implements MyList
 *  CS108-4
 *  4/18/20
 *  @author  YeonJun Lee
 */
public abstract class MyAbstractList<E> implements MyList<E> {

	protected int size;
	
	public MyAbstractList() {
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

}