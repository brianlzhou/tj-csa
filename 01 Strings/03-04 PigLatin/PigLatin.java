// Name:   
// Date: 
import java.lang.*;
import java.util.*;
import java.io.*;
public class PigLatin
{
   public static void main(String[] args) 
   {
      //part_1_using_pig();
      //part_2_using_piglatenizeFile();
      System.out.println(pigReverse("\"OnaldmcDay???\""));
      
      
      /*  extension only    */
      // String pigLatin = pig("What!?");
      // System.out.print(pigLatin + "\t\t" + pigReverse(pigLatin));   //Yahwta!?
      // pigLatin = pig("{(Hello!)}");
      // System.out.print("\n" + pigLatin + "\t\t" + pigReverse(pigLatin)); //{(Yaholle!)}
      // pigLatin = pig("\"McDonald???\"");
      // System.out.println("\n" + pigLatin + "  " + pigReverse(pigLatin));//"YaDcmdlano???"
   }

   public static void part_1_using_pig()
   {
      Scanner sc = new Scanner(System.in);
      while(true)
      {
         System.out.print("\nWhat word? ");
         String s = sc.next();
         if(s.equals("-1"))
         {
            System.out.println("Goodbye!"); 
            System.exit(0);
         }
         String p = pig(s);
         System.out.println( p );
      }		
   }

   public static final String punct = ",./;:'\"?<>[]{}|`~!@#$%^&*()";
   public static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
   public static final String vowels = "AEIOUaeiou";
   public static final String vowelsy = "AEIOUYaeiouy";
   public static String pig(String s)
   {
      if(s.length() == 0)
         return "";
      
      //remove and store the beginning punctuation
      int beginPunctIndex = s.length()-1;
      for(int i = 0; i<letters.length(); i++) {
         if(s.indexOf(letters.charAt(i)) < beginPunctIndex && s.indexOf(letters.charAt(i))>-1) {
            beginPunctIndex = s.indexOf(letters.charAt(i));
         }
      }
      String beginPunct = s.substring(0,beginPunctIndex);
                 
      //remove and store the ending punctuation 
      int endPunctIndex = 0;
      for(int i = 0; i<letters.length(); i++) {
         if(s.lastIndexOf(letters.charAt(i)) > endPunctIndex) {
            endPunctIndex = s.lastIndexOf(letters.charAt(i));
         }
      }
      String endPunct = s.substring(endPunctIndex+1);
        
      //START HERE with the basic case:
      //     find the index of the first vowel
      //     y is a vowel if it is not the first letter
      //     qu
      boolean fakeU = false;
      boolean hasVowel = false;
      String[] uExceptions = {"Qu", "qu", "QU", "qU"};
      s = s.substring(beginPunctIndex, endPunctIndex+1);
      int firstVowelIndex = s.length();
      
      for(int i = 0; i<vowels.length(); i++) {
         if(vowels.charAt(i) == s.charAt(0)) {
            return beginPunct + s + "way" + endPunct;
         }
      }
      
      if(s.length() == 1) {
         return "**** NO VOWEL ****";
      }
      first:
      for(int i = 1; i<s.length(); i++) {
         second:
         for(int k = 0; k<vowelsy.length(); k++) {
            if((vowelsy.charAt(k) == s.charAt(i)) && (firstVowelIndex > i)) {
               if(s.charAt(i) == 'u' || s.charAt(i) == 'U') {
                  if(s.charAt(i-1) == 'q' || s.charAt(i-1) == 'Q') {
                     break;
                  }
                  else{
                     firstVowelIndex = i;
                     hasVowel = true;
                  }
               }
               else{
                  firstVowelIndex = i;
                  hasVowel = true;
               }
            } 
         }
      }

      if (!hasVowel) {
         return "**** NO VOWEL ****";
      }
      
      //is the first letter capitalized?
      char firstLetter = s.charAt(0);
      boolean capitalized = Character.isUpperCase(firstLetter);
      
      //return the piglatinized word 
      String output;
      if(firstVowelIndex == 0) {
         return beginPunct + s + "way" + endPunct;
      }
      else {
         if(capitalized) {
            String e = s.substring(firstVowelIndex, firstVowelIndex+1);
            String f = s.substring(0,1);
            output = beginPunct + e.toUpperCase() + s.substring(firstVowelIndex+1) + f.toLowerCase() + s.substring(1,firstVowelIndex) + "ay" + endPunct;
            return output;
         }
         else {output = beginPunct + s.substring(firstVowelIndex) + s.substring(0,firstVowelIndex) + "ay" + endPunct;
            return output;
         }
      }
   }
   


   public static void part_2_using_piglatenizeFile() 
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("input filename including .txt: ");
      String fileNameIn = sc.next();
      System.out.print("output filename including .txt: ");
      String fileNameOut = sc.next();
      piglatenizeFile( fileNameIn, fileNameOut );
      System.out.println("Piglatin done!");
   }

/****************************** 
*  piglatinizes each word in each line of the input file
*    precondition:  both fileNames include .txt
*    postcondition:  output a piglatinized .txt file 
******************************/
   public static void piglatenizeFile(String fileNameIn, String fileNameOut) 
   {
      Scanner infile = null;
      try
      {
         infile = new Scanner(new File(fileNameIn));  
         
      }
      catch(IOException e)
      {
         System.out.println("oops");
         System.exit(0);   
      }
   
      PrintWriter outfile = null;
      try
      {
         outfile = new PrintWriter(new FileWriter(fileNameOut));
         while (infile.hasNextLine()) {
            String sentence = infile.nextLine();
            String[] words = sentence.split(" ");
            for (int i = 0; i<words.length; i++) {
               words[i] = pig(words[i]);
               if(i != words.length-1) {
                  outfile.write(words[i] + " ");
               }
               else {
                  outfile.write(words[i]);
               }
            }
            outfile.write("\n");
         }
      }
      catch(IOException e)
      {
         System.out.println("File not created");
         System.exit(0);
      }
   	//process each word in each line
      
      
      
   
      outfile.close();
      infile.close();
   }
   
   /** EXTENSION: Output each PigLatin word in reverse, preserving before-and-after 
       punctuation.  
   */
   public static String pigReverse(String s)
   {
      if(s.length() == 0)
         return "";
      
      //remove and store the beginning punctuation
      int beginPunctIndex = s.length()-1;
      for(int i = 0; i<letters.length(); i++) {
         if(s.indexOf(letters.charAt(i)) < beginPunctIndex && s.indexOf(letters.charAt(i))>-1) {
            beginPunctIndex = s.indexOf(letters.charAt(i));
         }
      }
      String beginPunct = s.substring(0,beginPunctIndex);
                 
      //remove and store the ending punctuation 
      int endPunctIndex = 0;
      for(int i = 0; i<letters.length(); i++) {
         if(s.lastIndexOf(letters.charAt(i)) > endPunctIndex) {
            endPunctIndex = s.lastIndexOf(letters.charAt(i));
         }
      }
      String endPunct = s.substring(endPunctIndex+1);
              
      s = s.substring(beginPunctIndex, endPunctIndex+1);
      //is the first letter capitalized?
      char firstLetter = s.charAt(0);
      boolean capitalized = Character.isUpperCase(firstLetter);
      
      //return the piglatinized word 
      if(capitalized) {
         String e = s.substring(s.length()-1);
         String f = s.substring(0,1);
         String output = beginPunct + e.toUpperCase();
         for(int i = s.length()-2; i>0; i--) {
            String m = s.substring(i, i+1);
            output = output + m;
         }
         output = output + f.toLowerCase() + endPunct;
         return output;
      }
      else {
         String output = beginPunct;
         for(int i = s.length()-1; i>-1; i--) {
            String m = s.substring(i, i+1);
            output = output + m;
         }
         output = output + endPunct;
         return output;
      }
   }
}
