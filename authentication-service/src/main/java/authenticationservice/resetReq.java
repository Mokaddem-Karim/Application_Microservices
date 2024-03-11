package authenticationservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class resetReq {
    String email;
    String newPass;
}
