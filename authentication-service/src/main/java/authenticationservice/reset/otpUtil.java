package authenticationservice.reset;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class otpUtil {
    public String generateOtp() {
        Random random = new Random();
        int randomNumber = random.nextInt(999999);
        String output = Integer.toString(randomNumber);

        while (output.length() < 6) {
            output = "0" + output;
        }
        return output;
    }
}
