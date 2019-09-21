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
 * Class CustomProcess that represents a process with a burst time and a unique 
 * ID
 * 
 * @author Stephen Fan
 *
 */
public class CustomProcess implements Comparable<CustomProcess> {
  //stores the id to be assigned to the next process
  private static int nextProcessId = 1; 
  // to be created
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution

  /**
   * Constructor for class CustomProcess
   * 
   * @param burstTime is the burst time of the process
   */
  public CustomProcess(int burstTime) {
    // set processID
    PROCESS_ID = nextProcessId;

    // increment processID
    nextProcessId++;

    // initialize burstTime
    this.burstTime = burstTime;
  }

  /**
   * compareTo compares two CustomProcesses and returns the one with a higher
   * priority
   * @return a number < 0 if this object has a shorter burst time or has an 
   * equal burst time and a lower processID. return a number > 0 if this object 
   * has a higher burst time or has an equal burst time and a higher processID 
   * return 0 if the other object is null or something went wrong since it 
   * should never return 0
   */
  public int compareTo(CustomProcess other) {
    // check if other object is null
    if (other == null) {
      return 0;
    }

    // check if this object's burst time is less than the other's
    if (this.burstTime < other.getBurstTime()) {
      return -1;
    } else if (this.burstTime > other.getBurstTime()) {
      return 1;
    } else {
      // checks if this object's processID is less than the other's
      if (this.PROCESS_ID < other.getProcessId()) {
        return -1;
      } else if (this.PROCESS_ID > other.getProcessId()) {
        return 1;
      }
      // returns 0 if something went wrong
      else {
        return 0;
      }
    }
  }

  /**
   * simple getter method for processID
   * 
   * @return processID is the processID of the CustomProcess
   */
  public int getProcessId() {
    return this.PROCESS_ID;
  }

  /**
   * simple getter method for burstTime
   * 
   * @return burstTime is the burstTime of the CustomProcess
   */
  public int getBurstTime() {
    return this.burstTime;
  }
}
