package Automation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.testng.annotations.Test;

@Test
public class CandidateAssignment {

	static HashMap<String, ArrayList<String>> mysong = new HashMap<String, ArrayList<String>>();

	// creating playlists for songs
	public static void createplaylist(String user, ArrayList<String> songs) {
		mysong.put(user, songs);
	}

	// creating songs details and iterating one by one
	public static ArrayList<String> CreateSongs(String[] song) {

		ArrayList<String> songs = new ArrayList<String>();
		for (int i = 0; i < song.length; i++) {

			songs.add(song[i]);
		}
		return songs;
	}

	// calling user and songs by inputting from the user through main function
	public static void playsong(String user, String songplay) {

		if (mysong.containsKey(user)) {

			if (mysong.get(user).contains(songplay)) {
				mysong.get(user).remove(songplay);
				mysong.get(user).add(songplay);
			}

			else {
				mysong.get(user).remove(0);
				mysong.get(user).add(songplay);
			}
			System.out.println(mysong);
		} else {
			System.out.println("Sorry no user found");
		}
	}

	public static void main(String[] args) {

		Scanner userinput = new Scanner(System.in);
		System.out.println("Enter the user in the first line and Enter the songlist in the second line\n");
		// for example
		// Bala is an username to be entered in the firstline of the console
		// Enter the playlist of song [ S1 , S2, S3 ] to be entered in the secondline of the console
		String user = userinput.next();
		Scanner songinput = new Scanner(System.in);
		String[] song = songinput.next().split(",");
		createplaylist(user, CreateSongs(song));
		System.out.println(user + " " + "is having playlist as : " + mysong);
		System.out.println("\nWhen Song4 is played\n");
		playsong(user, "S4");
		System.out.println("\nWhen Song2 is played\n");
		playsong(user, "S2");
		System.out.println("\nWhen Song1 is played\n");
		playsong(user, "S1");

	}

}

