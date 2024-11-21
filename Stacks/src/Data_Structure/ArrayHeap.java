package Data_Structure;

import Interface.HeapADT;

public class ArrayHeap<T> extends ArrayBinaryTree<T> implements HeapADT<T> {

    public ArrayHeap() 
   {
      super();
   }  

   public void addElement (T obj) 
   {
      if (size==size())
         expandCapacity();

      tree[size] = obj;
      size++;

      if (size>1)
         heapifyAdd();
   } 


   private void heapifyAdd()
   {
      T temp;

      int next = size - 1;
      while ((next != 0) && (((Comparable)tree[next]).compareTo(tree[(next-1)/2]) < 0))
      {
         temp = tree[next];
         tree[next] = tree[(next-1)/2];
         tree[(next-1)/2]= temp;
         next = (next-1)/2;
      }
   } 

   
   public T removeMin() throws EmptyCollectionException
   {
      
      if (isEmpty())
         throw new EmptyCollectionException("Empty Heap");

      T minElement = tree[0];

      tree[0] = tree[size-1];
      heapifyRemove();
      size--;
      return minElement;

   } 
   

   private void heapifyRemove()
   {
      T temp;
      int node = 0;
      int left = 1;
      int right = 2;
      int next;
      
      if ((tree[left] == null) && (tree[right] == null))
         next = size;
      else if (tree[left] == null)
         next = right;
      else if (tree[right] == null)
         next = left;
      else if (((Comparable)tree[left]).compareTo(tree[right]) < 0)
         next = left;
      else
         next = right;
      while ((next < size) && (((Comparable)tree[next]).compareTo(tree[node]) < 0))
         {
            temp = tree[node];
            tree[node] = tree[next];
            tree[next] = temp;
            node = next;
            left = 2*node+1;
            right = 2*(node+1);
            if ((tree[left] == null) && (tree[right] == null))
               next = size;
            else if (tree[left] == null)
               next = right;
            else if (tree[right] == null)
               next = left;
            else if (((Comparable)tree[left]).compareTo(tree[right]) < 0)
               next = left;
            else
               next = right;
         }
   } 


   public T findMin() throws EmptyCollectionException {

      if (isEmpty())
         throw new EmptyCollectionException ("Empty Heap");

      return tree[0];

   }

}  