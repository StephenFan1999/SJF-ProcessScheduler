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
 * test class for ProcessScheduler
 * 
 * @author Stephen Fan
 *
 */
public class ProcessSchedulerTests {
  /**
   * test method for enqueue method in CustomProcessQueue
   * 
   * @return true if the test pass and false otherwise
   */
  public static boolean testEnqueueCustomProcessQueue() {
    // checks the correctness of the enqueue
    // operation implemented in the CustomProcessQueue class
    boolean passed = true;

    // creates queue and 5 custom processes
    CustomProcessQueue queue = new CustomProcessQueue();
    CustomProcess process1 = new CustomProcess(3);
    CustomProcess process2 = new CustomProcess(2);
    CustomProcess process3 = new CustomProcess(4);
    CustomProcess process4 = new CustomProcess(10);
    CustomProcess process5 = new CustomProcess(12);

    // enqueues processes
    queue.enqueue(process1);
    queue.enqueue(process2);
    queue.enqueue(process3);
    queue.enqueue(process4);
    queue.enqueue(process5);

    // creates array
    CustomProcess[] array = queue.getHeap();

    // checks each burst time of the values in the array
    if (array[1].getBurstTime() != 2) {
      passed = false;
    }
    if (array[2].getBurstTime() != 3) {
      passed = false;
    }
    if (array[3].getBurstTime() != 4) {
      passed = false;
    }
    if (array[4].getBurstTime() != 10) {
      passed = false;
    }
    if (array[5].getBurstTime() != 12) {
      passed = false;
    }

    return passed;
  }

  /**
   * test method for peek method in CustomProcessQueue
   * 
   * @return true if the test pass and false otherwise
   */
  public static boolean testPeekCustomProcessQueue() {
    boolean passed = true;

    // creates queue and 5 custom processes
    CustomProcessQueue queue = new CustomProcessQueue();
    CustomProcess process1 = new CustomProcess(3);
    CustomProcess process2 = new CustomProcess(2);
    CustomProcess process3 = new CustomProcess(4);
    CustomProcess process4 = new CustomProcess(10);
    CustomProcess process5 = new CustomProcess(12);

    // enqueues a process and peeks to make sure the process with the highest
    // priority is on top
    queue.enqueue(process1);
    if (queue.peek().getBurstTime() != 3) {
      passed = false;
    }

    // enqueues a process and peeks to make sure the process with the highest
    // priority is on top
    queue.enqueue(process2);
    if (queue.peek().getBurstTime() != 2) {
      passed = false;
    }

    // enqueues a process and peeks to make sure the process with the highest
    // priority is on top
    queue.enqueue(process3);
    if (queue.peek().getBurstTime() != 2) {
      passed = false;
    }

    // enqueues a process and peeks to make sure the process with the highest
    // priority is on top
    queue.enqueue(process4);
    if (queue.peek().getBurstTime() != 2) {
      passed = false;
    }

    // enqueues a process and peeks to make sure the process with the highest
    // priority is on top
    queue.enqueue(process5);
    if (queue.peek().getBurstTime() != 2) {
      passed = false;
    }

    // checks if the queue is the proper size
    if (queue.size() != 5) {
      passed = false;
    }

    return passed;
  }

  /**
   * test method for dequeue method in CustomProcessQueue
   * 
   * @return true if the test pass and false otherwise
   */
  public static boolean testDequeueCustomProcessQueue() {
    // checks the correctness of the dequeue
    // operation implemented in the CustomProcessQueue class
    boolean passed = true;

    // creates a queue and adds 5 new processes to it
    CustomProcessQueue queue = new CustomProcessQueue();
    CustomProcess process1 = new CustomProcess(1);
    CustomProcess process2 = new CustomProcess(2);
    CustomProcess process3 = new CustomProcess(4);
    CustomProcess process4 = new CustomProcess(3);
    CustomProcess process5 = new CustomProcess(10);

    // enqueues all 5 processes
    queue.enqueue(process1);
    queue.enqueue(process2);
    queue.enqueue(process3);
    queue.enqueue(process4);
    queue.enqueue(process5);

    // dequeues each process 1 by 1 and checks to see if the dequeued process
    // is the one with the highest priority
    if (!queue.dequeue().equals(process1)) {
      passed = false;
    }
    if (!queue.dequeue().equals(process2)) {
      passed = false;
    }
    if (!queue.dequeue().equals(process4)) {
      passed = false;
    }
    if (!queue.dequeue().equals(process3)) {
      passed = false;
    }
    if (!queue.dequeue().equals(process5)) {
      passed = false;
    }

    return passed;
  }

  /**
   * test method for isEmpty method in CustomProcessQueue
   * 
   * @return true if the test pass and false otherwise
   */
  public static boolean testIsEmptyCustomProcessQueue() {
    boolean passed = true;

    // creates a new queue and 5 processes
    CustomProcessQueue queue = new CustomProcessQueue();
    CustomProcess process1 = new CustomProcess(3);
    CustomProcess process2 = new CustomProcess(2);
    CustomProcess process3 = new CustomProcess(4);
    CustomProcess process4 = new CustomProcess(10);
    CustomProcess process5 = new CustomProcess(12);

    // enqueues all 5 processes
    queue.enqueue(process1);
    queue.enqueue(process2);
    queue.enqueue(process3);
    queue.enqueue(process4);
    queue.enqueue(process5);

    // checks if the queue is empty which it should not be
    if (queue.isEmpty() == true) {
      passed = false;
    }

    // dequeues all 5 processes
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();

    // checks if the queue is empty which is should be
    if (queue.isEmpty() == false) {
      passed = false;
    }

    return passed;
  }
  
  /**
   * main method to run tests
   * 
   * @param args no arguments needed
   */
  public static void main(String[] args) {
    System.out.println(
        "testEnqueueCustomProcessQueue() has returned: " 
        + testEnqueueCustomProcessQueue());
    System.out.println(
        "testDequeueCustomProcessQueue() has returned: " 
        + testDequeueCustomProcessQueue());
    System.out
        .println("testPeekCustomProcessQueue() has returned: " 
        + testPeekCustomProcessQueue());
    System.out.println(
        "testIsEmptyCustomProcessQueue() has returned: " 
        + testIsEmptyCustomProcessQueue());
  }
}
