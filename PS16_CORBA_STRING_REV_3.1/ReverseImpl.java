import ReverseModule.ReversePOA;

public class ReverseImpl extends ReversePOA {
    @Override
    public String reverse_string(String s) {
        return "Server Send " + new StringBuilder(s).reverse().toString();
    }
}
