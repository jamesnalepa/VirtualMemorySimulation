//JAMES NALEPA

package virtualmemory;

public class FIFO {

	static public int[] threeFrames = new int[3];
	static public int[] fourFrames = new int[4];
	String[] strA;
	String[] strB;

	public FIFO(String[] a, String[] b)
	{
		strA = a;
		strB = b;
	}

	public int runA()
	{
		int faults = 0;
		int[] fullTimes = new int[3];				// array of timers to keep track of when a frame is swapped
		boolean noFault = false;

		System.out.println("\n---FIFO---\n");

		for (int i = 2; i < strA.length; i++)		// ignore the first element as it is just the number of available frames
		{

			for (int j = 0; j < threeFrames.length; j++)
			{
				if (Integer.parseInt(strA[i]) == threeFrames[j])
				{
					for (int k = 0; k < fullTimes.length; k++)
					{
						fullTimes[k]++;
					}
					noFault = true;
					break;										// No page fault (page is already in memory
				}
				else if (threeFrames[j] == 0)
				{
					threeFrames[j] = Integer.parseInt(strA[i]);	// Filling the empty frames at the beginning of program execution
					for (int k = 0; k < fullTimes.length; k++)
					{
						fullTimes[k]++;
					}
					fullTimes[j] = 0;
					break;
				}
				else if (j == 2)									// if the desired page is not in memory
				{
					int max = 0;
					int index = 0;
					for (int k = 0; k < fullTimes.length; k++)
					{
						if (fullTimes[k] > max)
						{
							max = fullTimes[k];
							index = k;
						}
					}
					threeFrames[index] = Integer.parseInt(strA[i]);
					for (int k = 0; k < fullTimes.length; k++)
					{
						fullTimes[k]++;
					}
					fullTimes[index] = 0; 
				}
			}
			if (noFault)
			{
				System.out.print(" " + strA[i] + " | \n");		// if no page fault --> print nothing
				noFault = false;
				continue;
			}
			System.out.print(" " + strA[i] + " | ");
			
			faults++;
			
			for (int o = 0; o < threeFrames.length; o++)			// print all 3 frames
			{
				System.out.print(threeFrames[o] + " ");
			}
			System.out.println(""); 
		}
		
		return faults;
		
	}

	public int runB()
	{
		int faults = 0;
		int[] fullTimes = new int[4];				// array of timers to keep track of when a frame is swapped
		boolean noFault = false;

		System.out.println("\n---FIFO---\n");

		for (int i = 2; i < strB.length; i++)		// ignore the first element as it is just the number of available frames
		{

			for (int j = 0; j < fourFrames.length; j++)
			{
				if (Integer.parseInt(strB[i]) == fourFrames[j])
				{
					for (int k = 0; k < fullTimes.length; k++)
					{
						fullTimes[k]++;
					}
					noFault = true;
					break;										// No page fault (page is already in memory
				}
				else if (fourFrames[j] == 0)
				{
					fourFrames[j] = Integer.parseInt(strB[i]);	// Filling the empty frames at the beginning of program execution
					for (int k = 0; k < fullTimes.length; k++)
					{
						fullTimes[k]++;
					}
					fullTimes[j] = 0;
					break;
				}
				else if (j == 3)									// if the desired page is not in memory
				{
					int max = 0;
					int index = 0;
					for (int k = 0; k < fullTimes.length; k++)
					{
						if (fullTimes[k] > max)
						{
							max = fullTimes[k];
							index = k;
						}
					}
					fourFrames[index] = Integer.parseInt(strB[i]);
					for (int k = 0; k < fullTimes.length; k++)
					{
						fullTimes[k]++;
					}
					fullTimes[index] = 0; 
				}
			}
			if (noFault)
			{
				System.out.print(" " + strB[i] + " | \n");		// if no page fault --> print nothing
				noFault = false;
				continue;
			}
			System.out.print(" " + strB[i] + " | ");
			for (int o = 0; o < fourFrames.length; o++)			// print all 3 frames
			{
				System.out.print(fourFrames[o] + " ");
			}
			
			faults++;
			
			System.out.println(""); 
		}
		
		return faults;


	}

}
