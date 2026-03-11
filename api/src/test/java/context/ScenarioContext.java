package context;

import lombok.Data;
import models.User;
import org.springframework.stereotype.Component;
import io.cucumber.spring.ScenarioScope;

@Data
@Component
@ScenarioScope
public class ScenarioContext {
    private User createdUser;
    private User retrievedUser;
}