package algorithm;

import java.util.Arrays;

public class sort {
	/*
	 * function bubble_sort (array, length) {
	    var i, j;
	    for(i from 0 to length-1){
	        for(j from 0 to length-1-i){
	            if (array[j] > array[j+1])
	                swap(array[j], array[j+1])
	        }
	    }
	  
	    */
	public static void bubbleSort(int[] arrays){
		int temp = 0; 
		for(int i = 0; i < arrays.length-1; i++){ //compare pairs
			int flag = 0;  //mark initiation
			for(int j = 0; j < arrays.length-1-i; j++){
				if(arrays[j] > arrays[j+1]){
					temp = arrays[j];
					arrays[j] = arrays[j+1];
					arrays[j+1] = temp;
					flag=1; 
				}
			}
			if(flag == 0)
				break;
			//如果没发生交换 说明有序
		}
	}
	
//定义中间值，小于的放前面，大于的放后面, o(n logn) most of time, o(n^2) worst cases
//partition(array), quickSort(lefthalf), quickSort(righthalf)
	/*
	 * void quickSort(int a[], int left, int right){
	 * if(left > = right)
	 * return;
	 * define a pivot
	 * define i = left, j = right
	 * 寻找左边值大的
	 * while(arrays[i] < arrays[pivot])
	 * i++
	 * 
	 * 寻找右边值小的
	 * while(arrays[j] > arrays[pivot]
	 *  j--
	 * }
	 * 直到i和j cross
	 *
	 * swap a[i] and a[j];
	 * quickSort(a, left, j)
	 * quickSort(a, i, right);
	 * 	 
	 */
	public static void quickSort(int[] arrays, int left, int right){
		int i = left, j = right;
		int pivot = (left+right)/2;
		if(i >= j)
			return;
		while(i <= j){
		while(arrays[i] < arrays[pivot]){
			i++;	
		}
		while(arrays[j] > arrays[pivot]){
			j--;
		}
		if(i < j){
		   int t = arrays[i];
		   arrays[i] = arrays[j];
		   arrays[j] = t;
		   i++;
		   j--;
		}
		}
		quickSort(arrays, left, j);
		quickSort(arrays, i, right);
	}
	

	
	
	//insertion:假设第一个是sorted，对后面unsorted的每一个数，在sorted从后往前扫描 插入，inplace：把大于的排序好的往后挪
	//best O(n), worst O(n^2)
   public static void insertionSort(int[] arrays){
	   for(int i = 1; i < arrays.length; i++){
		   for(int j = i -1; j >=0; j--){
			   if(arrays[j] > arrays[j+1]){
				   int temp = arrays[j];
				   arrays[j] = arrays[j+1];
				   arrays[j+1] = temp;
			   }
		   }
	   }	   
	   }
	   
	   
	   //insert:找位置
	  
	   public static void insertionSort2(int[] arrays){
	   for(int i = 1; i < arrays.length; i++){   //unordered的index
		   //Move elements of arr[0..i-1], that are
	       //greater than key, to one position after their current position
		   int key = arrays[i];//记住此时key的值
		   for(int j = i-1; j >=0; j--){//对所有从0到i－1的值，和key比较，如果大，就向后顺位
			   if(arrays[j] > key){
			      arrays[j+1] = arrays[j];
			   }
			      else{
			    	  break;
			   }
			   arrays[j] = key;//把所有往后移动一位，overwrite此时的j，在空的地方插入key
		   	} 
	   	}
	   }
	   public static void insertionSort3(int[] arrays){
		   for(int i = 1; i < arrays.length; i++){   //unordered的index
			   //Move elements of arr[0..i-1], that are
		       //greater than key, to one position after their current position
			   int key = arrays[i];//记住此时key的值
			   int j = i-1;
			   while(j >=0 && arrays[j] > key){//对所有从0到i－1的值，和key比较，如果大，就向后顺位
				      arrays[j+1] = arrays[j];
				      j--;
		   }  
			   arrays[j] = key;//把所有往后移动一位，overwrite此时的j
		   }
	   }
	  
	   //mergeSort o(n logn)
	   /*code:
	    mergeSort(a, tempArray, first last) //sorts entries a[first] through a[last] recursively
	    
	    if(first < last)
	    {
	    mid= (first+last)/2
	    mergeSort(a, tempArray, first, mid)
	    mergeSort(a, tempArray, mid+1, last)
	    }
	    
	    merge(a, tempArray, first, mid, last)
	    begin1 = first
	    end1 = mid
	    begin2 = mid+1
	    end2 = last
	    
	    //while both subarrays are not empty, compare two entries; copy smalller one into the temp array
	     index = 0;
	     while((begin1 <= end1) and (begin2 <= end2))
	     {
	     	if (a[begin1] <= a[begin2])
	     	{
	     		tempArray[index] = a[begin1]
	     		begin1++
	     	}
	     else
	     	{	
	     		tempArray[index] = a[begin2]
	     		begin2++
	     	}
	      index++
	     }
	    //copy remaining entries from other subarray to tempArray
	     //copy entries from tempArray to array a
	    */
	   
	     //sort左边，sort右边，merge左右
		  // mergeSort(lefthalf), mergeSort(righthalf), merge(lefthalf, righthalf)
		   public static void mergeSort(int[]a, int left, int right, int[]sorted){
			   if(left >= right)
				   return;
			   int mid = (left + right)/2;
			    merge(a, left, mid, right, sorted);
			    mergeSort(a, left, mid, sorted);
			    mergeSort(a, mid+1, right, sorted);
			    
		   }

	private static void merge(int[] a, int left, int mid, int right, int[] sorted) {
		int i = left, j = mid + 1, k = 0;//i left beginning index, j right beginning inde, k is the beginning of sorted 
		while(i <= mid && j <= right){
			   
				 if(a[i] <= a[j]){
				    sorted[k] = a[i] ;
				  i++;
				 }
				 else{
				   sorted[k] = a[j] ;
				  j++;
			  	 }
			   k++;
			}
		   
		   while( i <= mid  ){
				   sorted[k++] = a[i++] ;
		   } 
		   while(j <= right){
			      sorted[k++] = a[j++];
		   }
		   for(int l = 0; l < k; l++){
			   a[l + left] = sorted[l];
		   }

	}

	   
	  // selection,找到最小的放第一个，找第二小的放在sorted array最后一位，sorted array在前面，unsorted在后面
		/*for (int i = 0; i < arrays.length; i++)
		 * get the first of sorted array as the minimal, minimal = array[min];
		 * for unsorted array
		 * if(unsorted[j] < minimal){
		 * min = j; minimal = sorted[min];keep update unsorted minimal
		 * j++;
		 * }
		 * swap the unsorted minimal and the first of sorted array;
		 * or move every one of sorted array back for one position, insert minimal into the first position
		 * 
		 */
		
		/*第一趟找到最小数1的细节
	   当前数组是| 6 | 2 | 4 | 1 | 5 | 9 |
	   先把6取出来,让它扮演最小数
	   当前最小数6与其它数一一进行比较,发现更小数就交换角色
	   当前最小数6与2比较,发现更小数,交换角色,此时最小数是2,接下来2与剩余数字比较
	   当前最小数2与4比较,不动
	   当前最小数2与1比较,发现更小数,交换角色,此时最小数是1,接下来1与剩余数字比较
	   当前最小数1与5比较,不动
	   当前最小数1与9比较,不动,到达末尾
	   当前最小数1与当前首位数字进行位置交换,如下所示
	   交换前:| 6 | 2 | 4 | 1 | 5 | 9 |
	   交换后:| 1 | 2 | 4 | 6 | 5 | 9 |
		*/
		public static void selectionSort(int[] arrays){
			for (int i = 0; i < arrays.length; i++){
				int min = i, key = arrays[i];
				for(int j = i+1; j < arrays.length; j++){
					if(arrays[j] < key){
						key = arrays[j];
						min = j;
					}
				}
				//swap
				int temp = arrays[i];
				arrays[i] = arrays[min];
				arrays[min] = temp;
			}		
	}	

   
	public static void selectionSort2(int[] arrays){
		for (int i = 0; i < arrays.length; i++){
			for(int j = i+1; j < arrays.length; j++){
				if(arrays[i] > arrays[j]){
					int temp = arrays[i];
					arrays[i] = arrays[j];
					arrays[j] = temp;
				}
			}	
		}
	}
	
}
   
  

   
   
   







