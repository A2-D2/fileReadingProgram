package com.AbhinavMaddukuri;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class file_Reading_Program {

    public static void main(String[] args) {

        String line = "";
        Scanner keyboard = new Scanner (System.in); // This line of code is for the user to input the filename via the Keyboard
        System.out.print("Enter the file name:");
        String filename = keyboard.nextLine(); // The keyboard stores what was entered into the variable " filename "

        Scanner fileReader = null; // The file is null as nothing has been typed in yet
        String pound = "\u00A3";

        try
        {
            File fileobject = new File (filename);
            fileReader = new Scanner (fileobject);
            System.out.print("\nThe file "+ filename + "\n"+ "containns the following lines:");
            System.out.println("\n====================================================================================================");

            while(fileReader.hasNext())
            {

                line = fileReader.nextLine();
                String [] textdata = line.split("-"); // Creating an array called textdata and stating the delimiter

                if(textdata.length==6)
                {
                    textdata[0]=textdata[0].trim();
                    textdata[1]=textdata[1].trim();
                    textdata[2]=textdata[2].trim();
                    textdata[3]=textdata[3].trim();
                    textdata[4]=textdata[4].trim();
                    textdata[5]=textdata[5].trim();

                    if(textdata[0]==null || textdata[0].equals(""))

                        System.out.println("Title:" + "Title Is Missing");

                    else
                        System.out.println("Title:" + textdata[0]);


                    if(textdata[1]==null || textdata[1].equals(""))

                        System.out.println("Author:" + "Author Is Missing");

                    else

                        System.out.println("Author:" + textdata[1]);


                    if(textdata[2]==null || textdata[2].equals(""))

                        System.out.println("Publisher:" + "Publisher Is Missing");

                    else

                        System.out.println("Publisher:" + textdata[2]);

                    if(textdata[3]==null || textdata[3].equals(""))

                        System.out.println("Price:" + "Price Is Missing");

                    else

                    {
                        boolean test=true;
                        try
                        {
                            double price = Double.parseDouble(textdata[3]);
                        }

                        catch(NumberFormatException e)

                        {
                            test = false;
                        }


                        if(test)
                            System.out.println("Price:" + pound + textdata[3]);

                        else

                            System.out.println("Price:" + "Incorrect Price Format");
                    }


                    if(textdata[4]==null || textdata[4].equals(""))
                            System.out.println("Pages:" + "Missing Page Number");

                    else {

                        boolean test2 = true;

                        try
                        {
                            int Pages = Integer.parseInt(textdata[4]);
                        }
                        catch(NumberFormatException e)
                        {
                            test2 = false;
                        }
                        if(test2)

                            System.out.println("Pages:" + textdata[4]);
                        else
                            System.out.println("pages:" + "Incorrect Page Number Format");
                    }

                    if(textdata[5]==null ||  textdata[5].equals(""))

                        System.out.println("ISBN:" + "Missing ISBN");

                    else
                        System.out.println("ISBN:" + textdata[5]);
                        System.out.println("----------------------------------------------------------------------");
                }
                else
                {
                    System.out.println("Incorrect number of separators");
                    System.out.println(line);
                    System.out.println("------------------------------------------------------------------");
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error - This file doesn't exist");
        }
        keyboard.close();
    }
}









