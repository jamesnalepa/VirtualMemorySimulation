//JAMES NALEPA

package virtualmemory;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class VirtualMemory {
	
	static String INPUT_FILE_NAME = "input";
	static String inputStr;
	static public int[] threeFrames = new int[3];
	static public int[] fourFrames = new int[4];
	
	int counter = 0;

	public static void main(String[] args) throws IOException {
		
		  Scanner fileIn = null;
	      try 
	      {
	          fileIn = new Scanner(new FileInputStream(INPUT_FILE_NAME));
	      } 
	      catch (FileNotFoundException e) 
	      {
	          System.out.println("Input file "+INPUT_FILE_NAME+" not found. ");
	          System.exit(1);
	      }
	      
	      while (fileIn.hasNextLine())
	      {
	    	  inputStr = inputStr + " " + fileIn.nextLine();
	      }
	      
	      String[] st = inputStr.split("-1");
	      
	      
	      String[] strA = st[0].split(" ");
	      String[] strB = st[1].split(" ");
	      
	      FIFO fifo = new FIFO(strA, strB);
	      LRU lru = new LRU(strA, strB);
	      LFU lfu = new LFU(strA, strB);
	      Optimal opt = new Optimal(strA, strB);
	      
	      System.out.println("\n----- 3 FRAMES -----");
	      
	      System.out.println( "\nUsing 3 Frames: " + fifo.runA() + " Faults");
	      System.out.println( "\nUsing 3 Frames: " + lru.runA() + " Faults");
	      System.out.println( "\nUsing 3 Frames: " + lfu.runA() + " Faults");
	      System.out.println( "\nUsing 3 Frames: " + opt.runA() + " Faults");
	      
	      System.out.println("\n----- 4 FRAMES -----");
	      
	      System.out.println( "\nUsing 4 Frames: " + fifo.runB() + " Faults");
	      System.out.println( "\nUsing 4 Frames: " + lru.runB() + " Faults");
	      System.out.println( "\nUsing 4 Frames: " + lfu.runB() + " Faults");
	      System.out.println( "\nUsing 4 Frames: " + opt.runB() + " Faults");

	      
		
	}

}
