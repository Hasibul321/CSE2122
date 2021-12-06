import java.io.*;
import java.text.*;
import java.util.*;

//import javax.lang.model.util.ElementScanner14;
public class StudentList

     {
		
	    public static void main(String[] args) 
		{
           Constant cons = new Constant();
          //Object class is created for replacing string literals .
           if(args.length !=1)
	           {
		   			System.out.println(cons.no_args);
		
		       }

		    else if(args[0].equals("a")) 
			   {
			        System.out.println(cons.dataload );	//calling constant class using object		
			    try 
			       {
			            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
			            String readline = reader.readLine();
			            String names[] = readline.split(",");	

			for(String name : names) 
 							{
				 				 System.out.println(name); //displaying students list from student.txt file
							}
				} 
			        catch (Exception exception)
				{

				} 
			       System.out.println( cons.loaded);
		    }
		    else if(args[0].equals("r")) //this function is using for displaying random name
		    	{
			       System.out.println( cons.dataload);			
					try 
						{
			      			 BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
			      			 String readline = reader.readLine();
			       			//System.out.println(r);
			      			 String names[] = readline.split(",");	
			      			 Random random = new Random();
				  			 int value = Math.abs( random.nextInt()%names.length);
				   System.out.println(names[value]);
						} 
					catch (Exception exception)
						{

						} 
			       System.out.println(cons.loaded);			
		    	}
		    else if(args[0].contains("+")) //this function adds anther name on the list
				{
			       System.out.println(cons.dataload);			
					try
						{
			        		BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true));
			       		    String argument = args[0].substring(1);
	               		    Date date = new Date();
	               		    String date_format = "dd/mm/yyyy-hh:mm:ss a";
	                		DateFormat dateFormat = new SimpleDateFormat(date_format);
	                		String datefunction = dateFormat.format(date);
			        		writer.write(", "+argument+"\nList last updated on "+datefunction);
			        		writer.close();
				} 
					catch (Exception exception)
						{

						}
							
			        System.out.println( cons.loaded);	
		   	    }
		    else if(args[0].contains("?")) //this is used for serching a name from the list
		    	{
			        System.out.println(cons.dataload);			
					try 
						{
			        		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
			        		String readline = reader.readLine();
			        		String names[] = readline.split(", ");	
			        		boolean done = false;
			        		String arguments = args[0].substring(1);
			for(int index = 0; index<names.length && !done; index++) 
				{
				if(names[index].equals(arguments))
				 	{
					System.out.println(cons.found);
						done=true;
				 	}
				}
				} 
					catch (Exception exception)
					{

					} 
			        System.out.println(cons.loaded);				
		    		}
		    else if(args[0].contains("c")) 
		    	{
			        System.out.println(cons.dataload);			
					try 
						{
			       			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
			       			String words = reader.readLine();
			        		char character[] = words.toCharArray();			
			        		boolean in_word = false;
			        		int count=0;
			for(char c:character) 
						{
							if(c ==' ') 
								{
									if (!in_word) 
										{	
										count++; in_word =true;	
									    }
							else 
								{ 
									    in_word=false;
								}			
						}
				}
			        System.out.println(count + " word(s) found " + character.length);
			} 
					catch (Exception exception)
						{

						} 
			        System.out.println( cons.loaded);				
		    }
	         				else  //this is used for in case of giving invalid arguments
	        					{
		           					 System.out.println(cons.invalid);
	       					    }
	    }
    }