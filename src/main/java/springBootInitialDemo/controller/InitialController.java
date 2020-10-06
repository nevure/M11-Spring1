package springBootInitialDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springBootInitialDemo.dto.UserResponseDto;
import springBootInitialDemo.service.IUserService;

@RestController
@RequestMapping("/v1")
public class InitialController {

    private final IUserService userService;

    @Autowired
    public InitialController(IUserService userService){
        this.userService = userService;
    }

    /**
     * Mapeamos la raíz para mostrar un mensaje Hello World
     * @return String
     */
    @GetMapping("")
    public String hola() {
    	return "HELLO WORLD";
    }
    
    /**
     * Mapeamos la raíz cuando recibe un parámetro
     * @param nom recibe un nombre por path en la url
     * @return
     */
    @GetMapping("/{nom}")
    public String holaNom(@PathVariable(name="nom") String nom) {
    	return "Hello "+nom;
    }
    @GetMapping("/test")
    public String helloGradle() {
        return "Hello Gradle!";
    }

    //@PutMapping(value ="", consumes = {"application/json"})
    @GetMapping("/user/{uuid}")
    public ResponseEntity<UserResponseDto> updatePrescription(
            @PathVariable(name="uuid") String user) throws Exception {


        UserResponseDto userResponseDto = userService.getUser("pp");

        System.out.println(userResponseDto.getName());
        System.out.println(userResponseDto.getSurname());
        System.out.println(userResponseDto.getGender());

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);

    }


}
