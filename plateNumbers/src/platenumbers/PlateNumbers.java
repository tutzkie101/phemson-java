/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platenumbers;

/**
 *
 * @author b
 */
public class PlateNumbers 
{

    /**
     * @param args the command line arguments
     */
    
    private String standardLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public PlateNumbers()
    {
        
        String plateNumberStart = "AAA0000";
        incrementNumbers(plateNumberStart);
    }//end of function
    
    public static void main(String[] args) 
    {
        
        PlateNumbers pn = new PlateNumbers();
        
    }//end of main
    
    private void incrementNumbers(String plate)
    {
        int[] letloc = new int[3];
        int numbers = Integer.parseInt(plate.substring(3, 6));
        
        for(int i=0;i<letloc.length;i++)
        {
            letloc[i] = standardLetters.indexOf(plate.charAt(i));
        }//end of for loop
        
        while(letloc.toString()!="ZZZ" && numbers!=9999)
        {
            
            while(numbers<9999)
            {
                numbers++;  
                showPlate(letloc,numbers);
            }//end of while loop
            numbers = 0;
            
            if(letloc[2]<standardLetters.length())
                letloc[2]++;
            else if(letloc[1]<standardLetters.length())
            {
                letloc[2]=0;
                letloc[1]++;
            }else if(letloc[0]<standardLetters.length())
            {
                letloc[2]= letloc[1]=0;
                letloc[0]++;
            }//end of if else
            
            showPlate(letloc,numbers);
            
        }//end of while loop
        
    }//end of function incrementBumber
    
    
    private void showPlate(int[] let,int num)
    {
        String letters = ""+ standardLetters.charAt(let[0])+ standardLetters.charAt(let[1])+ standardLetters.charAt(let[2]);
        String numbers = Integer.toString(num);
        while(numbers.length()<4)
        {
            String temp = "0"+numbers;
            numbers = temp;
        }//end of while loop
        
        
        System.out.print(letters+"-"+numbers+"\n");
    }//end of function
    
}//end of class
