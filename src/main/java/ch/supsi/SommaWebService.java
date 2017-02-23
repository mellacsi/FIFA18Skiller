package ch.supsi;
// WS Interface, ASO Course Example LS Feb 2017
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.supsi.ch")
public interface SommaWebService {

    public int somma(int add1, int add2);

}