package Classes.sauvegarde;
// (Contrl + F) Changer 'Object' par votre classe

import Classes.hotel.Paradise;

import java.io.* ;

public class Serialisation
{

    private static final String filename = "sauvegarde" ;

	  public static void putObject( Paradise paradise )
    {
  		try
  		{
        	FileOutputStream file = new FileOutputStream( filename, false );
  			ObjectOutputStream out = new ObjectOutputStream( file );
  			
  			out.writeObject( paradise );
  			
  			out.close();
  			file.close();
  			
  			System.out.println("Serialisation\t[OK]");
  		}
  		catch(IOException ex)
  		{ System.out.println("Serialisation\t[NOK][IOException]"); }
          
    }

    public static Paradise getObject()
    {
        try
		{
    			
			FileInputStream file = new FileInputStream( filename );
			ObjectInputStream in = new ObjectInputStream( file );

			Paradise paradise = (Paradise) in.readObject();

		  	in.close();
		  	file.close();
    
		  	System.out.println("Deserialisation\t[OK]");
    			
          	return paradise ;
    
		}
    	catch(IOException ex)
    	{ System.out.println("Deserialisation\t[NOK][IOException]"); }
    	catch(ClassNotFoundException ex)
    	{ System.out.println("Deserialisation\t[OK][ClassNotFoundException]"); }
            
        return null ;
      
    }


}
