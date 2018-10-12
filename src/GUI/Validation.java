/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dipesh
 */
public class Validation {
    
    public static boolean isBookFormEmpty(String name,String isbn,String auth,String pubG){
        if(name.isEmpty() & isbn.isEmpty() & auth.isEmpty() & pubG.isEmpty()){
            AlertBox.display("Error", "Please fill in the form to continue");
            return true;
        }else{
            return false;
        }
        
    }
    
    public static boolean isEmailValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null)
            return false; 
            
        return pat.matcher(email).matches(); 
    } 
}
