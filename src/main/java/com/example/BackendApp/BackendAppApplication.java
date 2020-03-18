package com.example.BackendApp;

import com.example.BackendApp.models.HotelModel;
import com.example.BackendApp.models.TravelModel;
import org.apache.catalina.connector.Response;
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
	
	@RequestMapping(value = "/")
  public String xd() {
	  return "WTF";
  }

	@RequestMapping(value = "/api/getItems", method = RequestMethod.GET)
	@CrossOrigin
	public List<TravelModel> getItems() {
    System.out.println(travelRepository.findAll().get(0).toString());
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
		TravelModel travel1 = new TravelModel("Travel Name", 
      "Portugalia",
      "This is some desc",
      "2020-03-16",
      "2020-04-25",
      "Samolot",
        new HotelModel("Hotel Name", "Hotel Desc", 4),
        new ArrayList<>(Arrays.asList("Test attr", "Test attr 2", "Test attr 3", "Test attr 4")),
        new ArrayList<>(Arrays.asList("https://wallpaperaccess.com/full/469970.jpg", "https://www.portugal-live.net/images/rotator/251-physical-geography-a.jpg", "https://www.messagez.com/wp-content/gallery/portugal/best-of-algarve-portugal-photography-20-by-messagez-com_.jpg")),
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
      new ArrayList<>(Arrays.asList("https://dag08uxs564ub.cloudfront.net/images/Pieniny_mountains_in_Poland_-_view_on_Tatras.width-1200.jpg", "https://wallpaperaccess.com/full/370035.jpg", "https://jakubpolomski.com/wp-content/uploads/2018/01/Poland-Landscape-Photo-Jakub-Polomski-12BSK0012.jpg")),
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
      new ArrayList<>(Arrays.asList("https://ocdn.eu/pulscms-transforms/1/mn7k9kuTURBXy9hNjFiYjE2NS0yNjBhLTRiZGQtYmU5Ny1kNTU2MWExMGJjYzEuanBlZ5GVAs0DBwDDw4GhMAE", "https://dziendobry.tvn.pl/media/cache/content_cover/xgettyimages-531252132-jpg.jpg.pagespeed.ic.icMi4w-HJg.jpg", "https://media.wplm.pl/thumbs/NzIweDQ0Mi9jX2MvdV8xL2NjX2M5MWYwL3AvMjAxOS8xMi8yNi85NDgvNTMyLzYxMzYxYTNkY2Y0MDQ1MDBhYTQzM2NjMjVjM2JiOTUxLmpwZWc=.jpeg")),
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
	@CrossOrigin
	public CustomResponse createNewTravel(@RequestBody TravelModel travel) {
		return new CustomResponse("SUCCESS", "User succesfuly created", travel);
	}

  @RequestMapping(value = "/api/test", method = RequestMethod.POST)
  @CrossOrigin
  public CustomResponse testPost(@RequestBody TravelModel tester) {
    travelRepository.insert(tester);
    return new CustomResponse("SUCCESS", "User succesfuly created", tester);
  }
}

interface TravelRepository extends MongoRepository<TravelModel, String> {}

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
