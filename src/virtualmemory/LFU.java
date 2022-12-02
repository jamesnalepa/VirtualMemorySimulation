//JAMES NALEPA

package virtualmemory;

public class LFU {

	static public int[] threeFrames = new int[3];
	static public int[] fourFrames = new int[4];
	String[] strA;
	String[] strB;

	public LFU(String[] a, String[] b)
	{
		strA = a;
		strB = b;
	}

	public int runA()
	{
		int faults = 0;
		boolean noFault = false;

		System.out.println("\n---LFU---\n");

		for (int i = 2; i < strA.length; i++)		// ignore the first element as it is just the number of available frames
		{

			for (int j = 0; j < threeFrames.length; j++)
			{
				if (Integer.parseInt(strA[i]) == threeFrames[j])
				{
					noFault = true;
					break;										// No page fault (page is already in memory
				}
				else if (threeFrames[j] == 0)
				{
					threeFrames[j] = Integer.parseInt(strA[i]);	// Filling the empty frames at the beginning of program execution
					break;
				}
				else if (j == 2)									// if the desired page is not in memory
				{
					int min = 30;
					int minDist = 30;
					int targetIndex = 0;
					int[] occurences = new int[threeFrames.length];			// array to store the index of each occurence of a page in the string
					int[] distances = new int[threeFrames.length];
					
					for (int k = 0; k < threeFrames.length; k++)
					{
						int count = 0;
						for (int l = 2; l < i; l++)
						{
							if (threeFrames[k] == Integer.parseInt(strA[l]))
							{
								count++;
								distances[k] = i - l;
							}
						}
						occurences[k] = count;
					}
					
					for (int k = 0; k < occurences.length; k++)
					{
						if (occurences[k] < min && distances[k] < minDist)
						{
							min = occurences[k];
							minDist = distances[k];
							targetIndex = k;
						}
					}
					
					threeFrames[targetIndex] = Integer.parseInt(strA[i]);		// page fault

				}
			}
			if (noFault)
			{
				System.out.print(" " + strA[i] + " | \n");		// if no page fault --> print nothing
				noFault = false;
				continue;
			}
			System.out.print(" " + strA[i] + " | ");
			for (int o = 0; o < threeFrames.length; o++)			// print all 3 frames
			{
				System.out.print(threeFrames[o] + " ");
			}
			
			faults++;
			
			System.out.println(""); 
		}
		
		return faults;

	}

	public int runB()
	{
		int faults = 0;
		boolean noFault = false;

		System.out.println("\n---LFU---\n");

		for (int i = 2; i < strB.length; i++)		// ignore the first element as it is just the number of available frames
		{

			for (int j = 0; j < fourFrames.length; j++)
			{
				if (Integer.parseInt(strB[i]) == fourFrames[j])
				{
					noFault = true;
					break;										// No page fault (page is already in memory
				}
				else if (fourFrames[j] == 0)
				{
					fourFrames[j] = Integer.parseInt(strB[i]);	// Filling the empty frames at the beginning of program execution
					break;
				}
				else if (j == 3)									// if the desired page is not in memory
				{
					int min = 30;
					int minDist = 30;
					int targetIndex = 0;
					int[] occurences = new int[fourFrames.length];			// array to store the index of each occurence of a page in the string
					int[] distances = new int[fourFrames.length];
					
					for (int k = 0; k < fourFrames.length; k++)
					{
						int count = 0;
						for (int l = 2; l < i; l++)
						{
							if (fourFrames[k] == Integer.parseInt(strB[l]))
							{
								count++;
								distances[k] = i - l;
							}
						}
						occurences[k] = count;
					}
					
					for (int k = 0; k < occurences.length; k++)
					{
						if (occurences[k] < min && distances[k] < minDist)
						{
							min = occurences[k];
							minDist = distances[k];
							targetIndex = k;
						}
					}
					
					fourFrames[targetIndex] = Integer.parseInt(strB[i]);		// page fault

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