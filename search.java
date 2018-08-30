package algorithm;

import javax.xml.soap.Node;

public class search {
	int anEntry;
	int[] list;
//sequential search of array: 每次都看第一个等于不等于target， 等于就是true，不等于就first＋1
	public boolean contains(int anEntry){
		int numOfEntries = list.length;
		return search(0, numOfEntries -1, anEntry);
	}
	private boolean search(int first, int last, int desiredItem){
		boolean found;
		if(first > last)
			found = false;
		else if(desiredItem ==(list[first]))
			found = true;
		else 
			found = search(first + 1, last, desiredItem );
		return found;
	}
//binary search of a sorted array
	//o(1); o(logn); o(logn)
	public boolean contain(int anEntry){
		int numofEntries = list.length;
		return search(0, numofEntries -1, anEntry);
	}
	public boolean binarySearch(int[] list, int first, int last, int desiredItem){
		boolean found;
		int mid = first+ (last - first)/2;
		if( first > last){
			found = false;
		}
		else if (desiredItem == list[mid]){
			found = true;
		}
		else if(desiredItem > list[mid]){
			found = binarySearch(list, mid, last, desiredItem);
		}	
		else{
		    return binarySearch(list, first, mid, desiredItem);
		}
		return found;
		
	}
	
	
	
	//interative search an unsorted chain
	public boolean contain3(int anEntry){
		boolean found = false;
		Node firstNode = null;
		Node currentNode = firstNode;
		while(!found && (currentNode != null))
		{
			if(anEntry == currentNode.getNodeValue()){
			found = true;
			}
			else{
				currentNode = currentNode.getFirstChild();
			}
		}
		  return found;
	}
	
	//recursive sequential search of an unsorted chain(tail recursive)
	private boolean search(Node currentNode, int desiredItem){
		boolean found;
		if(currentNode == null){
			found = false;
		}
		else if (desiredItem == currentNode.getNodeValue()){
			found = true;
		}
		else 
			found = search(currentNode.getNextNode(), desiredItem);
	    return found;
  } 

    public boolean contain4(int anEntry){
    	return search(firstNode, anEntry);
    }
    
    //efficiency: best: o(1), worst: o(n), average: o(n)
    
    
   
    
    //sequential search of sorted chain
    public boolean contain5(int anEntry){
    	Node firstNode = null;
		Node currentNode = firstNode;
		while(( currentNode != null)&& (anEntry.compareTo(currentNode.getUserData()) > 0))
		{
			currentNode = currentNode.getNextNode();
		}//end while, not equal get the next one
		return (currentNode != null) && anEntry == (currentNode.getUserData());
    }//end contains, false if null or no equal value
    
    //binary search of sorted chain, random access is O(n), less efficient than sequential 
    //bc need to divide length in half and count nodes as traverse
    //not practical
    
    
    //sequential: need to have equalTo, can be unsorted, both o(1), o(n), o(n)
    //binary: need to have comparedTo, and the array must be sorted, o(1), o(logn), o(logn)
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
