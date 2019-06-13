import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

//Napisati program koji kreira file 100brojeva.txt ukoliko takav file vec ne postoji. 
//Upisati 100 nasumicno generisanih cijelih brojeva u file koristeci se text I/O klasom po vašem izboru. 
//Cijeli brojevi trebaju biti odvojeni jednim spaceom u fileu. 
//Ucitati podatke iz filea i ispisati ih na konzoli u rastucem redosljedu.

public class MainIOFile2 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = new Scanner(System.in);

		File file = new File("100numbers.txt");
		int[] array = new int[100];

		if (file.exists()) {

			System.out.println("\nFile " + file.getName() + " alredy exists!");
			Scanner input1 = new Scanner(new FileReader(file));

			while (input1.hasNextLine()) {
				String string = input1.nextLine();
				for (int i = 0; i < 100; i++) {
						String[] parts = string.split(" ");
						String parts1 = parts[i];
						array[i] = Integer.parseInt(parts1);
						System.out.println(array[i] + " ");
					}
				}
			
			Arrays.sort(array);
			int counter = 0;
			System.out.println("\n100 random numbers in file/array sorted by ascending order:  ");
			for (int j = 0; j < 100; j++) {
				if (counter == 10) {
					counter = 0;
					j--;
					System.out.println();

				} else {
					System.out.print(array[j] + " ");
					counter++;
				}
			}
			input1.close();

		} else {

			file = new File("100numbers.txt");
			PrintWriter output = new PrintWriter(file);

			for (int i = 0; i < 100; i++) {
				int number = (int) (Math.random() * 1000);
				output.print(number + " ");
			}
			output.close();

			Scanner input2 = new Scanner(new FileReader(file));
			while (input2.hasNextLine()) {
				String string = input2.nextLine();
				for (int i = 0; i < 100; i++) {
					String[] parts = string.split(" ");
					String parts1 = parts[i];
					array[i] = Integer.parseInt(parts1);
				}
			}
			Arrays.sort(array);
			int counter = 0;
			System.out.println("\n100 random numbers in file/array sorted by ascending order:  ");
			for (int j = 0; j < 100; j++) {
				if (counter == 10) {
					counter = 0;
					j--;
					System.out.println();
				} else {
					System.out.print(array[j] + " ");
					counter++;
				}
			}
			input2.close();
		}
		input.close();
	}

}
