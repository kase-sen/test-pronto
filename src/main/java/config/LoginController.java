package config;


import com.pronto.library.dto.LoginInputData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/auth")
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {


    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> authRequest(@RequestBody LoginInputData authRequestDto) {
        var userRegistrationResponse = authService.authRequest(authRequestDto);
        return new ResponseEntity<>(userRegistrationResponse, HttpStatus.OK);
    }


}
