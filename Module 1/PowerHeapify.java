/*
Forage Walmart - Task 1
Task 1 Requirements: 
- The heap must satisfy the heap property.
- Every parent node in the heap must have 2^x children.
- The value of x must be a parameter of the heap’s constructor.
- The heap must implement an insert method.
- The heap must implement a pop max method.
- The heap must be implemented in Java.
- The heap must be performant.
- You must use a more descriptive variable name than x in your implementation.
*/

public class PowerHeapify {
        private int[] heap;
        private int size;
    
        /* 
         * Constructor to initialize an empty max heap
         * with given maximum size/maxSize
         */
        public PowerHeapify(int maxSize) {
            //"this" keywordmeans self-instantiation
            this.heap = new int[maxSize+1];
            this.heap[0] = Integer.MAX_VALUE;
            this.size = 0;
        }
        //Method 1: Exchanging/Swapping Nodes
        private void exchange(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
        //Method 2: Removing top element from heap by swapping (Heapify Down).
        private void heapifyDown(int k) {
            int greatest = k; //declaring position of parent
            int leftIdx = 2*k; //declaring position of left index
            int rightIdx = 2*k + 1; //declaring position of right index
            int exp = 2;
    
            if (leftIdx <= heap.length && heap[leftIdx] > heap[greatest]){ //if left index is greater than root, then the left index is the root
                greatest = leftIdx;
                leftIdx = (int)(Math.pow(leftIdx, exp));
            }
    
            if (rightIdx <= heap.length && heap[rightIdx] > heap[greatest]) {//if right index is greater than root, then the right index is the root
                greatest = rightIdx;
                rightIdx = (int)(Math.pow(leftIdx, exp));
            } 
    
            if (greatest != k) { //if the root is not the greatest, then sift down
                exchange(k, greatest);
                heapifyDown(greatest);
            }
        }
        
        //Method 3: Function to swap node until it reaches root or satisfies heap property (Heapify Up).
        private void heapifyUp(int k) { 
            while (heap[k] > heap[k/2]) {
                exchange(k , k/2);
                k = k/2;
            }
        }

     
        //Method 4: Utility Function to print and display the heap
        private void print(){
            for (int i = 1; i <= size/2; i++) {
                System.out.printf("Root: %d, C: %d, C: %d %s", heap[i], heap[i*2], heap[i*2+1], System.lineSeparator());
                System.out.printf("Root: %d, C: %d, C: %d %s", (int)(Math.pow(heap[i], 2)), (int)(Math.pow(heap[i*2], 2)), (int)(Math.pow((heap[i*2+1]), 2)), System.lineSeparator());
            }
        }
        
        //Method 5: Function to isnert new element
        public void insert(int x) {
            heap[++size] = x;
            heapifyUp(size);
        }
        
        //Method 6: Function to remove the top element
        public int pop() {
            int head = heap[1];
            heap[1] = heap[size--];
            heapifyDown(1);
    
            return head;
        }
    
        public int peek() {
            return heap[1];
        }
    
        //Main Driver
        public static void main(String[] args) {
            PowerHeapify maxHeap = new PowerHeapify(5);
            maxHeap.insert(30);
            maxHeap.insert(100);
            maxHeap.insert(70);
            maxHeap.insert(20);
            maxHeap.insert(90);
    
            maxHeap.print();
    
        }
    }

