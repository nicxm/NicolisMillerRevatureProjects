import java.util.Arrays;

public class Stack {

	  private int lastItem = 0;
	  private int[] items = new int[0];

	  // add items to the stack
	  public void push(int newItem) {
		  int index = items.length; // get current length to store as index
		  System.out.println("The array length is: " + index);

		  items = new int[items.length + 1]; // increase the array by 1
		  System.out.println("items after extending the length by 1: " + Arrays.toString(items));

		  items[index] = newItem; // store the value in the index
		  System.out.println("items after storing the new value: "+ Arrays.toString(items));

		  lastItem = newItem; // update lastItem
		  System.out.println("The last item: " + lastItem);
	  }

	  // remove items from the stack
	  public int pop() {
		  int tempItem = lastItem; //store the last item into a variable
		  
		   //copy a new array but remove last item
		   int[] newArray = new int[items.length-1];

		   for(int i = 0; i < newArray.length; i++){
		     newArray[i] = items[i];
		  }

		   items = newArray; //update the items array
		   lastItem = items[items.length-1]; //update lastItem

		   //return our ‘popped' element
		   return tempItem;
	  }

	  // view last item
	  public int peek() {
		  
		  
	    return 0;
	  }
	  
	}