import ReverseModule.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.CosNaming.*;

public class ReverseServer {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            ReverseImpl rImpl = new ReverseImpl();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(rImpl);
            Reverse href = ReverseHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            NameComponent path[] = ncRef.to_name("Reverse");
            ncRef.rebind(path, href);

            System.out.println("Server ready and waiting...");
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
