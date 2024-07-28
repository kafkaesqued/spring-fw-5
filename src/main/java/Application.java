import com.ps.service.SpeakerService;
import com.ps.service.SpeakerServiceImpl;

public class Application {

    public static void main(String[] args) {
        SpeakerService service = new SpeakerServiceImpl();
        System.out.println(service.findAll().get(0).getLastName());
    }
}
