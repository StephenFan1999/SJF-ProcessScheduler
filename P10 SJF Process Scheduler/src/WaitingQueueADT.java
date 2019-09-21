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
 * Interface for WaitingQueueADT that extends Comparable Has 5 methods that 
 * need to be overridden
 * 
 * @author Stephen Fan
 *
 * @param <T> is a class that implements Comparable
 */
public interface WaitingQueueADT<T extends Comparable<T>> {

  /**
   * enqueues an object in the priority queue
   * 
   * @param newObject is the object to enqueue
   */
  public void enqueue(T newObject); // inserts a newObject in the priority queue

  /**
   * removes and returns the item with the highest priority
   * 
   * @return returns the object dequeued
   */
  public T dequeue(); // removes and returns the item with the highest priority

  /**
   * returns without removing the item with the highest priority
   * 
   * @return returns the object with the highest priority in the heap
   */
  public T peek(); // returns without removing the item with the highest 
                   // priority

  /**
   * returns size of the waiting queue
   * 
   * @return returns size of the waiting queue
   */
  public int size(); // returns size of the waiting queue

  /**
   * checks if the waiting queue is empty
   * 
   * @return true if the waiting queue is empty and false otherwise
   */
  public boolean isEmpty(); // checks if the waiting queue is empty
}
