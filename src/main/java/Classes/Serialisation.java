package Classes;
// (Contrl + F) Changer 'Object' par votre classe

import java.io.* ;

public class Serialisation
{

    private static final String filename = "sauvegarde" ;

	  public static void putObject( Paradise object )
    {
  		try
  		{
        FileOutputStream file = new FileOutputStream( filename );
  			ObjectOutputStream out = new ObjectOutputStream( file );
  			
  			out.writeObject( object );
  			
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

			Paradise  Object = null ;
			Paradise object = (Paradise) in.readObject();

		  	in.close();
		  	file.close();
    
		  	System.out.println("Deserialisation\t[OK]");
    			
          	return object ;
    
		}
    	catch(IOException ex)
    	{ System.out.println("Deserialisation\t[NOK][IOException]"); }
    	catch(ClassNotFoundException ex)
    	{ System.out.println("Deserialisation\t[OK][ClassNotFoundException]"); }
            
        return null ;
      
    }


}
