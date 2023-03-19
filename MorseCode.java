import java.util.Scanner; //Allow user input
import java.util.Arrays; //Allow arrays to be used
import java.io.IOException;
 
 public class MorseCode
 {

   static Scanner input = new Scanner(System.in); // Allow for user input
   static int userChoice; //Initialize userChoice
   static int numberOfCharacters;  //Initialize numberOfCharacters
   static String userInput =  ""; //Initialize userInput
   static char[] letter = { 'a', 'b', 'c', 'd', 'e', 'f',
                     'g', 'h', 'i', 'j', 'k', 'l',
                     'm', 'n', 'o', 'p', 'q', 'r',
                     's', 't', 'u', 'v', 'w', 'x',
                     'y', 'z', '1', '2', '3', '4',
                     '5', '6', '7', '8', '9', '0', ' '}; //Initialize letter array

   static String[] code = { ".-",   "-...", "-.-.", "-..",  ".",
                     "..-.", "--.",  "....", "..",   ".---",
                     "-.-",  ".-..", "--",   "-.",   "---",
                     ".--.", "--.-", ".-.",  "...",  "-",
                     "..-",  "...-", ".--",  "-..-", "-.--",
                     "--..", ".----",  "..---", "...--", "....-", 
                     ".....", "-....", "--...", "---..", "----.", 
                     "-----", ","};
   
   //Initialize code array

   public static void main( String [] args ) 
   {
      try{
         while( userChoice != 2 )  //while user does not select choice 2 they will be
         {			      // asked if they would like to translate a sentence

            System.out.println("\nDo you want to translate a sentence? Enter 1 if yes. Enter 2 if no.");

            userChoice = input.nextInt();  //take user input

            if (userChoice == 1) //if yes the program continues
            {
               translationSelection();
            }
            else if (userChoice == 2)
            {
               System.out.println("\n\n\tHave a great day!");
            }
            else if ((userChoice != 1) & (userChoice != 2)) //If not 1 or 2 they are
          		//told to reenter it
            {
               System.out.println("\nInvalid input. Please input either 1 or 2");        
            }
         }
      } catch (Exception e){System.out.println("ERROR! INVALID INPUT! MUST BE 1 OR 2");};
   } //end main()

   public static void translationSelection() //user chooses what they will translate
   {
      System.out.println("\n\nPlease type in an integer value for the option you are trying to perform. \n1) For English to Morse Code. \n2) For Morse Code to English.");
      int selection = input.nextInt(); //user integer choice

      if (selection == 1) //if 1 user translates english to morse code
      {
            englishToMorseCode(code, letter);
      }
      else if (selection == 2) //if 2 user translates morse code to english
      {
            morseCodeToEnglish();
      }
      else if ((selection != 1) & (selection != 2)) //else invalid message
      {
            System.out.println("\nInvalid input. Please input either 1 or 2");
            translationSelection();
      }
   }//end translationSelection()

   public static void englishToMorseCode(String[] code, char[] letter)
   {
      System.out.println("\n\nPlease type your message to be translated. \nWhen inputting Morse code, separate each letter/digit \nwith a single space and each word with a comma:\n");

      Scanner input1 = new Scanner(System.in); // Allow for user input
      userInput = input1.nextLine();

      userInput = userInput.toLowerCase(); //lower case all letters 

      numberOfCharacters = userInput.length(); //stores length of userInput

      StringBuilder morseCodeString = new StringBuilder(); //build new string

      System.out.println("\nMorse code of " + userInput + "is:");

      for (int i = 0; i < numberOfCharacters; i++) //run for loop on string
      {
         char character1 = userInput.charAt(i); //store each character

         for (int j = 0; j < letter.length; j++) //run all of letter
         {
            if (userInput.charAt(i) == letter[j]) //if char equals letter then the morse
            {  			       //code is saved for respective character

               morseCodeString.append(code[j] + " ");
               break;
            }
         }
      }
      String morseCode = morseCodeString.toString(); //save code as a string
      System.out.println(morseCode); //print morse code
   }//end englishToMorseCode(String[] code, char[] letter)

   public static void morseCodeToEnglish()
   {
      System.out.println("\n\nPlease type your message to be translated. \nWhen inputting Morse code, separate each letter/digit \nwith a single space and each word with a comma:\n");
      Scanner input1 = new Scanner(System.in); // Allow for user input
      userInput = input1.nextLine();

      String[] array = userInput.split(" "); //split each character up

      StringBuilder englishCodeString = new StringBuilder(); //build new string

      System.out.println("\nEnglish translation of " + userInput + "is:");

      for (int i = 0; i < array.length; i++) //run for loop through morse code
      {
         for (int j = 0; j < code.length; j++) //run for loop through code array
         {
            String character1 = "" + userInput.charAt(i);
            if (character1.compareTo(code[j]) == 0) //compare array to code array
            {
               englishCodeString.append(letter[j] + ""); //add letter to string
               break;
            }
         }
      }
      String englishCode = englishCodeString.toString();
      System.out.println(englishCode);
   }//end morseCodeToEnglish()
 }//end MorseCode class