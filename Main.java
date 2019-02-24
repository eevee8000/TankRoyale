package codes;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <h1>Tank Royale</h>
 * The tank royale main class runs at the begining of the program and construct the main objects to be used 
 * the run the game. This class contains the central while loop which is used to run the game as well as a
 * random number generator to spawn the tanks in random locations.
 * 
 * @author Team 7
 * @version 0.1
 * @since 2019-02-19
 */

public class Main {
	
	/**
	 * When the program runs it prompts the user to select a map, generates that map, tracks user input, 
	 * randomly spawns/generatse two tanks/players, and keeps track of which players turn it is. 
	 * The while loop acts as a central while loop that runs until the game ends tracking and changes that happen.
	 * Within the while loop each player makes a single command using the provided command list and after each command
	 * the loop with redraw the map to make that command. The game ends when the while 
	 * loop ends, i.e, when a tank dies. When the game ends the system will output an appropriate message 
	 * indicating which player won. 
	 * @param args unused in this version of the game
	 * @exception FileNotFoundException when designated file fails to open
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		Map map = new Map("src/resources/maze.txt");
		
		Tank tank1 = new Tank(5, 3);
		Tank tank2 = new Tank(5, 5);
		map.randomSpawn(tank1);
		map.randomSpawn(tank2);
		
		int turn = 1;

		while (tank1.isAlive() && tank2.isAlive()) {
			System.out.println("Commands: \"MOVEUP\", \"MOVEDOWN\", \"MOVERIGHT\", \"MOVELEFT\",");
			System.out.println("          \"SHOOTUP\", \"SHOOTDOWN\", \"SHOOTRIGHT\", \"SHOOTLEFT\"");
			map.display();
			System.out.println("Tank " + turn + "\'s turn: ");
			
			//TODO Check for valid input
			String userCommand1 = input.nextLine().toUpperCase();
			//String userCommand2 = input.nextLine().toUpperCase();
			
			System.out.println("\n");
			if (turn == 1) {
				tank1.performCommand(userCommand1, map, tank2);
				//tank1.performCommand(userCommand2, map, tank2);
				turn = 2;
			}
			else if (turn == 2) {
				tank2.performCommand(userCommand1, map, tank1);
				//tank2.performCommand(userCommand2, map, tank1);
				turn = 1;
			}
		}
		
		if (tank1.isAlive() &&  !tank2.isAlive()) {
			System.out.println("CONGRATULATIONS TANK 1 WON THE GAME!");
		}
		else if (!tank1.isAlive() &&  tank2.isAlive()) {
			System.out.println("CONGRATULATIONS TANK 2 WON THE GAME!");
		}
		
		
		input.close();
	}

	/**
	 * This method generates a random integer between a given min and max value
	 * @param min the minimum value for the random integer
	 * @param max the maximum value for the random integer
	 * @return returns the randomly generated number
	 */
	
    public static int rng(int min, int max){ //Random Number Generator
        if (min > max){ //Argument Error Trap
            int temp = min;
            min = max;
            max = temp;
        }
        int number = (int)(Math.random()*(max - min + 1) + min);
        return number;
    }
}