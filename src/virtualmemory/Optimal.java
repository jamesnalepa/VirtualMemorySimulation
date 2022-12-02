//JAMES NALEPA

package virtualmemory;

public class Optimal {

	static public int[] threeFrames = new int[3];
	static public int[] fourFrames = new int[4];
	String[] strA;
	String[] strB;

	public Optimal(String[] a, String[] b)
	{
		strA = a;
		strB = b;
	}

	public int runA()
	{
		int faults = 0;
		boolean noFault = false;

		System.out.println("\n---Optimal---\n");

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
					int[] occurences = new int[threeFrames.length];			// array to store the index of each occurence of a page in the string
					int targetIndex = 0;
					int latest = 0;								// integer to store the earliest occurence of the page in question
					for (int k = 0; k < threeFrames.length; k++)
					{
						for (int l = i; l < strA.length; l++)
						{
							if (Integer.parseInt(strA[l]) == threeFrames[k])
							{
								occurences[k] = l - 2;				// store each occurence of the page in the string
								break;
							}
							
							occurences[k] = strA.length;
						}
					}
					for (int k = 0; k < occurences.length; k++)
					{
						if (occurences[k] > latest)
						{
							latest = occurences[k];			// find the latest occurence
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

		System.out.println("\n---Optimal---\n");

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
					int[] occurences = new int[fourFrames.length];			// array to store the index of each occurence of a page in the string
					int targetIndex = 0;
					int latest = 0;								// integer to store the earliest occurence of the page in question
					for (int k = 0; k < fourFrames.length; k++)
					{
						for (int l = i; l < strB.length; l++)
						{
							if (Integer.parseInt(strB[l]) == fourFrames[k])
							{
								occurences[k] = l - 2;				// store each occurence of the page in the string
								break;
							}
							
							occurences[k] = strB.length;
						}
					}
					for (int k = 0; k < occurences.length; k++)
					{
						if (occurences[k] > latest)
						{
							latest = occurences[k];			// find the latest occurence
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

