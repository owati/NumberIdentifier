import java.util.*;
import java.lang.String;
import java.io.File;
import java.io.FileNotFoundException;



public class Numbers {
    public static void main (String args[]) {
        List<String> mtn = new ArrayList<String>(Arrays.asList("0703", "0706", "0803", "0806","0810", "0813", "0814", "0816", "0903", "0906", "0913", "0916", "07025", "07026", "0704"));
        List<String> airtel = new ArrayList<String>(Arrays.asList("0701", "0708", "0802", "0808", "0812", "0901", "0902", "0904", "0907", "0912"));
        List<String> glo = new ArrayList<String>(Arrays.asList("0705", "0805", "0807", "0811", "0815" , "0905", "0915"));
        List<String> nineMob = new ArrayList<String>(Arrays.asList("0809", "0817", "0818", "0909", "0908"));
        String mtel = "0804";

        int[] collation = {0,0,0,0,0}; // for mtn , airtel, glo, 9mobile, mtel

        try {
            Scanner fileRead = new Scanner(new File("PhoneNumbers.txt"));

            while(fileRead.hasNextLine()) {
                String number = fileRead.nextLine();
                String firstFour = number.substring(0,4);
                String firstFive = number.substring(0,5);

                if(mtn.contains(firstFour) || mtn.contains(firstFive)) collation[0]++;
                else if(airtel.contains(firstFour)) collation[1]++;
                else if (glo.contains(firstFour)) collation[2]++;
                else if (nineMob.contains(firstFour)) collation[3]++;
                else if(firstFour.equals(mtel)) collation[4]++;
               // System.out.println(number.substring(0,4));
            }
 
            System.out.println("SUMMARY REPORT..");
            System.out.println("MTN      -> " + collation[0]);
            System.out.println("AIRTEL   -> " + collation[1]);
            System.out.println("GLOBACOM -> " + collation[2]);
            System.out.println("9MOBILE  -> " + collation[3]);
            System.out.println("MTEL     -> " + collation[4]);

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
    }
}