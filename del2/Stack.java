package se.oneagency.trainee.part2;

public interface Stack<T> {
	
	/**
	 * Pushes a new object to the top of the stack
	 * and returns the stack object reference
	 * @param newItem object to the pushed to the stack
	 * @return reference to this stack
	 */
    Stack<T> push(T newItem);

    /**
     * Pops the top element of stack if exists, otherwise throws an exception
     * @return top object in stack
     */
    T pop();

    /**
     * Checks if the object item exists in the stack
     * @param item to check
     * @return true if exists, false otherwise
     */
    boolean contains(T item);

    /**
     * Accesses the object item in the stack and returns it if exists.
     * Throws an exception if not exists. 
     * @param item to access
     * @return item if exists
     */
    T access(T item);

    /**
     * Checks if the stack is empty
     * @return
     */
    boolean isEmpty();
}
