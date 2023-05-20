package com.example.demo;
import org.apache.coyote.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import org.json.simple.JSONObject;

@SpringBootApplication
@RestController
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@CrossOrigin(origins = "*")
	@PutMapping("/abc")
	public JSONObject handlePutRequest(@RequestBody JSONObject requestData) {
        Date currentDate = new Date();
		JSONObject jo = new JSONObject();
        jo.put("startTime", currentDate);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        jo.put("USER", requestData.get("user"));
        currentDate = new Date();
        jo.put("endTime", currentDate);
        return jo;
	}

    @CrossOrigin(origins = "*")
    @PostMapping("/abc")
    public JSONObject handlePostRequest(@RequestBody JSONObject requestData) {
        Date currentDate = new Date();
        JSONObject jo = new JSONObject();
        jo.put("startTime", currentDate);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        jo.put("USER", requestData.get("user"));
        currentDate = new Date();
        jo.put("endTime", currentDate);
        return jo;
    }

}