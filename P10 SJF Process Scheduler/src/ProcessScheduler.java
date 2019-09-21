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

import java.util.Scanner;

/**
 * The ProcessScheduler class represents the data type for the main scheduler 
 * for our processes.
 * 
 * @author Stephen Fan
 *
 */
public class ProcessScheduler {
  private int currentTime; // stores the current time after the last run
  private int numProcessesRun; // stores the number of processes run so far
  private CustomProcessQueue queue; // this processing unit's custom process
                                    // queue

  /**
   * Constructor for class ProcessScheduler
   */
  public ProcessScheduler() {
    // initializes currentTime and numProcessesRun to 0
    currentTime = 0;
    numProcessesRun = 0;

    // initializes queue
    queue = new CustomProcessQueue();
  }

  /**
   * schedules a new CustomProcess and enqueues it into the queue
   * 
   * @param process is the new CustomProcess to enqueue
   */
  public void scheduleProcess(CustomProcess process) {
    queue.enqueue(process);
  }

  /**
   * runs all the CustomProcesses in the queue
   * 
   * @return a String that contains all the actions completed by the processor
   */
  public String run() {
    // initialize the String to a set String
    String str = "Starting " + queue.size() + " processes\n\n";
    int size = queue.size();

    // for every CustomProcess that must be run, add its corresponding Strings
    // to the initial String
    for (int i = 0; i < size; i++) {
      CustomProcess removedProcess = queue.dequeue();
      str +=
          "Time " + currentTime + " : Process ID " + 
          removedProcess.getProcessId() + " Starting.\n";

      // increment currentTime
      currentTime += removedProcess.getBurstTime();

      // increment numProcessesRun
      numProcessesRun++;
      str +=
          "Time " + currentTime + ": Process ID " 
          + removedProcess.getProcessId() + " Completed.\n";
    }

    // add the String that says all processes have been completed
    str += "\nTime " + currentTime + ": All scheduled processes completed.\n";

    return str;
  }

  /**
   * simple getter method for the numProcessesRun to help write test methods
   * 
   * @return numProcessesRun is the number of processes run
   */
  public int getNumProcessesRun() {
    return this.numProcessesRun;
  }

  /**
   * simple getter method for the currentTime to help write test methods
   * 
   * @return currentTime is the current time
   */
  public int getCurrentTime() {
    return this.currentTime;
  }

  /**
   * main method for running the ProcessScheduler
   * 
   * @param args no parameter needed
   */
  public static void main(String[] args) {
    // create new ProcessScheduler and Scanner
    ProcessScheduler schedule = new ProcessScheduler();
    Scanner scan = new Scanner(System.in);

    // creates variable to check if there is another command or to quit
    boolean next = true;

    System.out.println("==========   Welcome to the SJF Process Scheduler App " 
    + "  ========");

    // while there are more commands incoming
    while (next == true) {
      // print command list
      System.out.println("Enter command:");
      System.out.println("[schedule <burstTime>] or [s <burstTime>]");
      System.out.println("[run] or [r]");
      System.out.println("[quit] or [q]");

      // obtain user input and split into array of Strings
      String originalInput = scan.nextLine();
      String[] input = originalInput.split(" ");

      // checks which command the first String of input matches with
      // and runs its corresponding process
      if (input[0].equals("schedule") || input[0].equals("s")) {
        // checks that the second String of input is an integer
        try {
          Integer.parseInt(input[1]);
          if (Integer.parseInt(input[1]) <= 0) {
            System.out.println("WARNING: burst time MUST be greater than 0!\n");
          } else {
            CustomProcess newProcess = 
                new CustomProcess(Integer.parseInt(input[1]));
            schedule.scheduleProcess(newProcess);
            System.out.println("Process ID " + newProcess.getProcessId()
                + " scheduled. Burst Time = " 
                + newProcess.getBurstTime() + "\n");
          }
        } catch (NumberFormatException e) {
          // sets the boolean to false and prints out a warning if the
          // second String of input is not an integer
          System.out.println("WARNING: burst time MUST be an integer!\n");
        } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("WARNING: Please enter a valid command!\n");
        }
      }
      // if the input is r or run then it runs the ProcessScheduler
      else if (input[0].equals("r") || input[0].equals("run")) {
        System.out.println(schedule.run());
      }
      // if the input is q or quit then it quits the ProcessScheduler
      else if (input[0].equals("q") || input[0].equals("quit")) {
        System.out.println(
            schedule.getNumProcessesRun() + " processes run in " 
            + schedule.getCurrentTime()
            + " units of time!\n" + "Thank you for using our scheduler!\n" 
            + "Goodbye!\n");

        // exits the loop
        next = false;
      }
      // prints out a warning if the data was not one of the accepted types
      else {
        System.out.println("WARNING: Please enter a valid command!\n");
      }
    }

    // close scanner
    scan.close();
  }
}
