package com.example.BackendApp;

import com.example.BackendApp.models.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

@SpringBootApplication
public class BackendAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendAppApplication.class, args);
    }

}

@RestController
@CrossOrigin(value = "*")
@ComponentScan(basePackages = {"com.example.BackendApp"})
class Tester {
    @Autowired
    TravelRepository travelRepository;

    @RequestMapping(value = "/")
    public String xd() {
        return "WTF";
    }

    @RequestMapping(value = "/api/getItems", method = RequestMethod.GET)
    public List<TravelModel> getItems() {
        System.out.println(travelRepository.findAll().get(0).toString());
        return travelRepository.findAll();
    }

    @RequestMapping(value = "/api/getItem", method = RequestMethod.GET)
    public Optional<TravelModel> getTravelById(@RequestParam String id) {
        System.out.println(id + " no kurwa mać to nie dziła");
        return travelRepository.findById(id);
    }

    @RequestMapping(value = "/api/setItem", method = RequestMethod.GET)
    public String initItem() {
        TravelModel travel1 = new TravelModel("Travel Name",
                "Portugalia",
                "This is some desc",
                "2020-03-16",
                "2020-04-25",
                "Samolot",
                new HotelModel("Hotel Name", "Hotel Desc", 4),
                new ArrayList<>(Arrays.asList("Test attr", "Test attr 2", "Test attr 3", "Test attr 4")),
                4,
                2000,
                3
        );
        TravelModel travel3 = new TravelModel("Travel Name",
                "Poland",
                "This is some desc",
                "2020-03-20",
                "2020-04-18",
                "Samolot",
                new HotelModel("Hotel Name", "Hotel Desc", 4),
                new ArrayList<>(Arrays.asList("Test attr", "Test attr 2", "Test attr 3", "Test attr 4")),
                4,
                2000,
                4
        );
        TravelModel travel2 = new TravelModel("Travel Name",
                "Egipt",
                "This is some desc",
                "2020-03-25",
                "2020-04-01",
                "Samolot",
                new HotelModel("Hotel Name", "Hotel Desc", 4),
                new ArrayList<>(Arrays.asList("Test attr", "Test attr 2", "Test attr 3", "Test attr 4")),
                4,
                2000,
                6
        );
        travelRepository.insert(travel1);
        travelRepository.insert(travel2);
        travelRepository.insert(travel3);
        return "dodano nowe podróże";
    }

    @RequestMapping(value = "/api/createTravel", method = RequestMethod.POST)
    public CustomResponse createNewTravel(@RequestBody TravelModel travel) {
        return new CustomResponse("SUCCESS", "User succesfuly created", travel);
    }

    @RequestMapping(value = "/api/testImages", method = RequestMethod.POST)
    public ResponseEntity<Void> TestImages(@RequestParam MultipartFile[] files, @RequestParam String travel) {
		try {
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
//            TravelModel travelModel = mapper.readValue(travel, TravelModel.class);
//
//            travelRepository.insert(travelModel);
			for (MultipartFile file: files) {
				System.out.println(file.getOriginalFilename());
			}
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
    }

    @RequestMapping(value = "/api/test", method = RequestMethod.POST)
    public ResponseEntity<String> testPost(@RequestBody TravelModel tester) {
        try {
            travelRepository.insert(tester);
        } catch (Exception e) {
            return new ResponseEntity<>("Hello", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Travel Correctly added", HttpStatus.OK);
    }
}

interface TravelRepository extends MongoRepository<TravelModel, String> {
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
