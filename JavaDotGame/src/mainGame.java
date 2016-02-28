
import java.util.*;

public class mainGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean done = true;
		
		System.out.print("Player 1 name: ");
		String player1 = in.nextLine();
		System.out.print("Player 2 name: ");
		String player2 = in.nextLine();
		while(player2.equals(player1))
		{
			System.out.println("Invalid names pick different names\n");
			System.out.print("Player 1 name: ");
			player1 = in.nextLine();
			System.out.print("Player 2 name: ");
			player2 = in.nextLine();
		}
		System.out.print("Player 1 character: ");
		String player1char = in.nextLine();
		System.out.print("Player 2 character: ");
		String player2char = in.nextLine();
		while(player2char.equals(player1char))
		{
			System.out.println("Invalid Characters pick different characters\n");
			System.out.print("Player 1 character: ");
			player1char = in.nextLine();
			System.out.print("Player 2 character: ");
			player2char = in.nextLine();
		}
		String[][] sunDial = createArray(in);
		printArray(sunDial);
		String player1score = player1.substring(0, 1).toUpperCase();
		String player2score = player2.substring(0, 1).toUpperCase();
		if (player2score.equals(player1score))
		{
			player2score = player2score.toLowerCase();
		}
		int alternator = 1;
		String change;
		String score;
		while(done)
		{
			if(alternator%2!=0)
			{
				System.out.println("Player 1 turn!");
				score = player1score;
				change = player1char;
			}
			else
			{
				System.out.println("Player 2 turn");
				score = player2score;
				change = player2char;
			}
			sunDial = changeArray(sunDial, change, in);
			sunDial = changer(sunDial, change, score);
			done = gameOver(sunDial);
			printArray(sunDial);
			alternator++;
			while(!done)
			{
				winner(sunDial,player1score,player2score,player1,player2);
				break;
			}
		}
		
	}
	public static String[][] createArray(Scanner in)
	{
		System.out.print("How large(odds only): ");
		int size = in.nextInt()+1;
		String[][] arey = new String[size][size];
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<(size); j++)
			{
				
				if(i==0)
				{
					arey[i][j]=Integer.toString(j);
				}
				else if (j==0)
				{
					arey[i][j]=Integer.toString(i);
				}
				else if(i%2==0)
				{	
					if(j%2!=0)
					{
						arey[i][j]="|";
					}
					else
					{
						arey[i][j]=" ";
					}
				}
				else
				{
					if(j%2==0)
					{
						arey[i][j]="-";
					}
					else
					{
						arey[i][j]="*";
					}
				}
			}
		}
		return arey;
	}
	public static void printArray(String[][] sunDial)
	{
		for(int i=0; i<sunDial.length; i++)
		{
			for(int j=0; j<sunDial.length; j++)
			{
				
				System.out.printf("%-3s",sunDial[i][j]);
			}
			System.out.println();
		}
	}
	public static String[][] changeArray(String[][] sunDial, String change, Scanner in)
	{
		System.out.print("change x value: ");
		int x = in.nextInt();
		System.out.print("change y value: ");
		int y = in.nextInt();
		while((x%2!=0)&&(y%2!=0))
		{
			System.out.println("Not valid inputs\n");
			System.out.print("change x value: ");
			x = in.nextInt();
			System.out.print("change y value: ");
			y = in.nextInt();
		}
		if(!(sunDial[y][x].equals("-")||sunDial[y][x].equals("|")))
		{
			System.out.println("Spot already taken\n");
			System.out.print("change x value: ");
			x = in.nextInt();
			System.out.print("change y value: ");
			y = in.nextInt();
		}
		sunDial[y][x]=change;
		return sunDial;
	}
	public static String[][] changer(String[][] sunDial, String change, String score)
	{
		for(int i=1; i<sunDial.length-1; i++)
		{
			for(int j=1; j<sunDial.length-1; j++)
			{
				if(sunDial[i+1][j].equals(change)&&sunDial[i-1][j].equals(change)
				&&sunDial[i][j+1].equals(change)&&sunDial[i][j-1].equals(change))
				{
					sunDial[i][j]=score;
				}
			}
		}
		return sunDial;
	}
	public static boolean gameOver(String[][] sunDial)
	{
		boolean done = false;
		for(int i=0; i<sunDial.length; i++)
		{
			for(int j=0; j<(sunDial.length); j++)
			{
				if(sunDial[i][j].equals("-")||sunDial[i][j].equals("|"))
				{
					done = true;
				}
			}
		}
		return done;	
	}
	public static void winner(String[][] sunDial, String char1, String char2, String player1, String player2)
	{
		int hits4p1 = 0;
		int hits4p2 = 0;
		for(int i=0; i<sunDial.length; i++)
		{
			for(int j=0; j<(sunDial.length); j++)
			{
				if(sunDial[i][j].equals(char1))
				{
					hits4p1++;
				}
				if(sunDial[i][j].equals(char2))
				{
					hits4p2++;
				}
			}
		}
		if (hits4p1>hits4p2)
		{
			System.out.print(player1+" had "+hits4p1+" spaces while " + player2
					+ " had " +hits4p2+ "spaces/n" + player1 +" wins!");
		}
		else if (hits4p2>hits4p1)
		{
			System.out.print(player2+" had "+hits4p2+" spaces while " + player1
					+ " had " +hits4p1+ " spaces\n" + player2 +" wins!");
		}
		else
		{
			System.out.print("tie");
		}
	}
}