/**
 * Class to manage a dynamic stack structure
 * @author Joakim
 *
 */
public class Solution implements Stack<Object>{

	/* reference to top element of stack */
	private StackElement topElement;
	
	
	@Override
	public Stack<Object> push(Object newItem) {
		/* creates new stack element with the object */
		StackElement newElement = new StackElement(newItem);
		
		/* checks if the stack (top element reference) is not empty */
		if(!isEmpty())
			
			/* current stack becomes rest of stack with this new element on top */
			newElement.next = topElement;
		
		/* replace current stack with new stack */
		topElement = newElement;
		return this;
	}

	@Override
	public Object pop() {
		
		/* if stack is not empty */
		if(!isEmpty()){
			
			/* get the stack element data */
			Object data = topElement.data;
			
			/* removes first element, rest of stack becomes new stack */
			topElement = topElement.next;
			
			/* return this object data */
			return data;
		}
		
		/* if no data exists, throw exception */
		throw new IllegalArgumentException("No data in stack");
	}

	@Override
	public boolean contains(Object item) {
		
		/* while stack has elements */
		while(!isEmpty()){
			
			/* if current stack element reference equals the provided object, return true */
			if(topElement.data.equals(item)) return true;
			
			/* otherwise, removes top element, replace by rest of stack */
			else topElement = topElement.next;
		}
		
		/* if item was not found, return false */
		return false;
	}

	@Override
	public Object access(Object item) {
		
		/* while stack has elements */
		while(!isEmpty()){
			
			/* if top element in stack is equal to the input item */
			if(topElement.data.equals(item)){
				
				/* rest of stack becomes current stack */
				topElement = topElement.next;
				
				/* return this item */
				return item;
			}else{
				
				/* go through rest of stack */
				topElement = topElement.next;
			}
		}
		
		/* if stack did not contain item, throw exception */
		throw new IllegalArgumentException("Item not found in stack");
	}

	@Override
	public boolean isEmpty() {
		return topElement == null;
	}
	
	/**
	 * Element to be stored in the stack
	 * @author Joakim
	 *
	 */
	private class StackElement{
		
		/* object data in stack element */
		Object data;
		
		/* reference to next stack element */
		StackElement next;
		
		
		public StackElement(Object data){
			this.data = data;
		}
	}

}
