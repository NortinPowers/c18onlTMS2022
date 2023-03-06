package by.tms.model;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Authenticator {

    private Map<String, String> authenticators;
}