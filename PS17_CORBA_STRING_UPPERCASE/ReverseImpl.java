import ReverseModule.ReversePOA; 
import java.lang.String; 

class ReverseImpl extends ReversePOA
{
	ReverseImpl()
	{
		super();
		System.out.println("Reverse Object Created");
	}

	public String reverse_string(String name) 
	{
		StringBuffer str=new StringBuffer(name); 
		str.reverse();
		// return (("Server Send "+str));
		return name.toUpperCase();
	}
}

/*
 * -------------------------------------------------------------------

Terminal 1 (Server):

idlj -fall ReverseModule.idl
javac *.java ReverseModule/*.java
orbd -ORBInitialPort 1056&
java ReverseServer -ORBInitialPort 1056& 
-------------------------------------------------------------------

Terminal 2 (Client):

java ReverseClient -ORBInitialPort 1056 -ORBInitialHost localhost
-------------------------------------------------------------------
 */