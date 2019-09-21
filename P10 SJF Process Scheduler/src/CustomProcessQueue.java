//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P10 SJF Process Scheduler
// Files: WaitingQueueADT.java, CustomProcess.java,
// CustomProcessQueue.java, ProcessScheduler.java,
// ProcessSchedulerTests.java
// Course: CS300, Fall 2018
//
// Author: Stephen Fan
// Email: sfan54@wisc.edu
// Lecturer's Name: Alexi Brooks
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * Class CustomProcessQueue that represents a queue of CustomProcesses It is in 
 * the form of a min-heap
 * 
 * @author Stephen Fan
 *
 */
public class CustomProcessQueue implements WaitingQueueADT<CustomProcess> {
  //the initial capacity of the heap
  private static final int INITIAL_CAPACITY = 20; 
  
  //array-based min heap storing the data. This is an oversize array
  private CustomProcess[] heap; 
  
  //number of CustomProcesses present in this CustomProcessQueue
  private int size; 

  /**
   * Constructor for class CustomProcessQueue
   */
  public CustomProcessQueue() {
    // initializes the min-heap to an array of CustomProcesses of size 20
    heap = new CustomProcess[INITIAL_CAPACITY];

    // initializes the size of the heap to 0
    size = 0;
  }

  @Override
  /**
   * enqueues a new CustomProcess object into the min-heap
   */
  public void enqueue(CustomProcess newObject) {
    // inserts a newObject in the priority queue
    // increments size
    size++;

    // increases the size of the min-heap array if necessary
    if (size >= heap.length) {
      CustomProcess[] biggerHeap = new CustomProcess[heap.length * 2];
      for (int i = 0; i < heap.length; i++) {
        biggerHeap[i] = heap[i];
      }
      heap = biggerHeap;
    }

    // adds the new object to the heap
    heap[size] = newObject;

    // calls minHeapPercolateUp to keep the min-heap in order
    minHeapPercolateUp(size);
  }

  @Override
  /**
   * dequeue method to remove the object with the highest priority from the 
   * min-heap
   */
  public CustomProcess dequeue() {
    // removes and returns the item with the highest priority
    // checks if the min-heap is empty and returns null if that is the case
    if (this.isEmpty() == true) {
      return null;
    }

    // removes the CustomProcess with the highest priority
    // sets the root node of the min-heap to the last CustomProcess in the heap
    CustomProcess removedProcess = heap[1];
    heap[1] = heap[size];

    // sets the last CustomProcess in the heap to null
    heap[size] = null;

    // decrements size
    size--;

    // calls minHeapPercolateDown to keep the min-heap in order
    minHeapPercolateDown(1);

    return removedProcess;
  }

  @Override
  /**
   * peek method that returns the CustomProcess with the highest priority in 
   * the min-heap
   */
  public CustomProcess peek() {
    // returns without removing the item with the highest priority
    // checks if the min-heap is empty and returns null if it is
    if (this.isEmpty() == true) {
      return null;
    }

    // otherwise returns the first CustomProcess in the min-heap
    return heap[1];
  }

  @Override
  /**
   * returns size of the waiting queue
   */
  public int size() {
    // returns size of the waiting queue
    return this.size;
  }

  @Override
  /**
   * checks if the waiting queue is empty
   */
  public boolean isEmpty() {
    // checks if the waiting queue is empty
    if (this.size == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * simple getter method for accessing the heap to be used in a test method
   * 
   * @return the min-heap of CustomProcesses
   */
  public CustomProcess[] getHeap() {
    return this.heap;
  }

  /**
   * Recursive method that percolates a CustomProcess up a min-heap so that the
   * heap stays in order
   * 
   * @param index is the index of the CustomProcess that needs to be percolated 
   * up and is potentially in the wrong location
   */
  private void minHeapPercolateUp(int index) {
    // if index is 1 then there is no need to percolate up any further
    if (index != 1) {
      // compare the priority of the index to the priority of its parent
      if (heap[index].compareTo(heap[index / 2]) < 0) {
        // swap them if necessary
        CustomProcess parent = heap[index / 2];
        heap[index / 2] = heap[index];
        heap[index] = parent;

        // continue to percolate until array is sorted
        minHeapPercolateUp(index / 2);
      }
    }
  }

  /**
   * Recursive method that percolates a CustomProcess down a min-heap so that 
   * the heap stays in order
   * 
   * @param index is the index of the CustomProcess that needs to be percolated 
   * down and is potentially in the wrong location
   */
  private void minHeapPercolateDown(int index) {
    // checks that the index has at least one child
    if (2 * index > size) {
      return;
    }

    // create variable to hold the index of the smaller child
    int smallerChildIndex = index;

    // comparing between root and left child
    if (heap[index].compareTo(heap[2 * index]) > 0) {
      smallerChildIndex = 2 * index;
    }

    // comparing between left child and right child
    if (heap[smallerChildIndex].compareTo(heap[2 * index + 1]) > 0) {
      smallerChildIndex = 2 * index + 1;
    }

    // if the smaller child index is the same as index then do nothing
    // array is already sorted
    if (smallerChildIndex == index) {
      return;
    } else {
      // swap the old root with its smaller child
      CustomProcess oldroot = heap[index];
      heap[index] = heap[smallerChildIndex];
      heap[smallerChildIndex] = oldroot;

      // continue to percolate until array is sorted
      minHeapPercolateDown(smallerChildIndex);
    }

  }
}
