import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Login {
    public boolean verifyLoginCredentials(String email, String pass){
        try {
            File f = new File("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\accounts.txt");
            Scanner s = new Scanner(f);
            while(s.hasNextLine()){
                String line = s.nextLine();
                String[] userCred = line.split(",");
                String em = userCred[7].trim();
                String pas = userCred[8].trim();
                if(em.equals(email) && pas.equals(pass)){
                    s.close();
                    return true;
                }
            }
            s.close();
            return false;
        }
        catch(FileNotFoundException e){
            System.out.println("File Not found");
        }
        return false;

    }
}
