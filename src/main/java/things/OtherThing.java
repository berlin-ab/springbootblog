package things;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtherThing {

    @Autowired
    Thing thing;

    public String toString() {
        return thing.toString();
    }
}
