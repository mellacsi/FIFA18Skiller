// WS Implementation of the interface
import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(
        portName = "SommaWebServicePort",
        serviceName = "SommaWebService",
        targetNamespace = "http://www.supsi.ch",
        endpointInterface = "SommaWebService")
public class SommaWebServiceImpl implements SommaWebService {

    public int somma(int add1, int add2) {
        return add1 + add2;
    }

}