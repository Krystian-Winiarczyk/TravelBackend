package com.example.BackendApp;

import com.example.BackendApp.models.TravelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BackendAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendAppApplication.class, args);
	}

}

@RestController
class Tester {
	@Autowired
	TravelRepository travelRepository;

	@RequestMapping(value = "/api/getItems", method = RequestMethod.GET)
	@CrossOrigin
	public List<TravelModel> getItems() {
		return travelRepository.findAll();
	}

	@RequestMapping(value = "/api/getItem", method = RequestMethod.GET)
	@CrossOrigin
	public Optional<TravelModel> getTravelById(@RequestParam String id) {
		System.out.println(id + " no kurwa mać to nie dziła");
		return travelRepository.findById(id);
	}

	@RequestMapping(value = "/api/setItem", method = RequestMethod.GET)
	@CrossOrigin
	public String initItem() {
		TravelModel travel1 = new TravelModel("Travel Name", "Poland", "This is some desc", "2020.12.11", "2020.12.25", "Hotel name", "Airplane",
				new ArrayList<>(Arrays.asList("Atuty 1", "Atuty 2")), new ArrayList<>(Arrays.asList("Zdjecie 1", "Zdjecie 2"))
		);
		travelRepository.insert(travel1);
		return "dodano nowe podróże";
	}

	@RequestMapping(value = "/api/createTravel", method = RequestMethod.POST)
	@CrossOrigin
	public CustomResponse createNewTravel(@RequestBody LoginForm loginForm) {
		System.out.println(loginForm.getUsername());
		return new CustomResponse("SUCCESS", "User succesfuly created", loginForm);
	}
}

interface TravelRepository extends MongoRepository<TravelModel, String> {}

class LoginForm {
	private String username;
	private String password;
	// ...

	public LoginForm(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

class CustomResponse {
	private String responseType;
	private String reponseMessage;
	private Object responseData;

	public CustomResponse(String responseType, String reponseMessage, Object responseData) {
		this.responseType = responseType;
		this.reponseMessage = reponseMessage;
		this.responseData = responseData;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getReponseMessage() {
		return reponseMessage;
	}

	public void setReponseMessage(String reponseMessage) {
		this.reponseMessage = reponseMessage;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
}