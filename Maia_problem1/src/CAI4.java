import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {
	public static void main(String args[]) {
		quiz();
	}
	public static void quiz() {
		int result;
		int input;
		int number1;
		int number2;
		int genSize;
		int score = 0;
		boolean answer = false;
		while(true) {
			System.out.println("Enter difficulty level from 1 to 4:");
			input = readResponse();
			if(input == 1) {
				genSize = 10;
				break;
			}
			if(input == 2) {
				genSize = 100;
				break;
			}
			if(input == 3) {
				genSize = 1000;
				break;
			}
			if(input == 4) {
				genSize = 10000;
				break;
			}
			if (input < 1 || input > 4) {
				System.out.println("Invalid choice.");
			}
		}
		for(int i = 0; i < 10; i++) {
			number1= numberGen(genSize);
			number2= numberGen(genSize);
			result = number1*number2;
			askQuestion(number1, number2);
			input = readResponse();
			
			answer = isAnswerCorrect(input, result, number1, number2, answer);
			if (answer == true) {
				score++;
				answer = false;
			}
		}
		score = score*10;
		displayCompletitionMessage(score);
		System.out.println("Do you want to solve another question set?");
		System.out.println("1 - yes");
		System.out.println("0 - no");
		input = readResponse();
		if (input == 1) {
			quiz();
		}
	}
	// done
	public static int numberGen(int genSize) {
		SecureRandom random = new SecureRandom();
		int number = random.nextInt(genSize);
		return number;
		
	}
	// done
	public static void askQuestion(int number1,int number2){
		System.out.println("How much is " + number1 + " times " + number2 + "?");
	}
	// done
	public static int readResponse(){
		Scanner userInput = new Scanner (System.in);
		int input = userInput.nextInt();
		return input;
	}
	// done
	public static boolean isAnswerCorrect(int input, int result, int number1, int number2, boolean answer){
		if (input == result) {
			answer = displayCorrectResponse(input, result, answer);
				}
		if (input != result) {
		 displayIncorrectResponse(input,number1, number2);
		}
		return answer;
		
	}
	public static boolean displayCorrectResponse(int input, int result, boolean answer){
		int compliment = numberGen(4);
		switch(compliment) {
		case 0: System.out.println("Very good!");
		break;
		case 1: System.out.println("Excellent!");
		break;
		case 2: System.out.println("Nice work!");
		break;
		case 3: System.out.println("Keep up the good work!");
		break;
		}
		
		System.out.println("You answered "+ input + ", the correct answer is "+ result);
		answer = true;
		return answer;
	}
	public static void displayIncorrectResponse(int input, int number1, int number2){
		int correction = numberGen(4);
		
		switch(correction) {
		case 0: System.out.println("No. Please try again.");
		break;
		case 1: System.out.println("Wrong. Try once more.");
		break;
		case 2: System.out.println("Don’t give up!");
		break;
		case 3: System.out.println("No. Keep trying.");
		break;
		}
		
		System.out.println(input + " is not the correct answer.");
	}
	public static void displayCompletitionMessage(int score) {
		System.out.println("Your score is: " + score +"%");
		if(score > 75) {
		System.out.println("Congratulations, you are ready to go to the next level!");
		}
		if(score < 75) {
			System.out.println("Please ask your teacher for extra help.");
		}
	}
}