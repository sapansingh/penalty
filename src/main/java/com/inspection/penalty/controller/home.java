package com.inspection.penalty.controller;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpHeaders;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inspection.penalty.model.usersmodel;
import com.inspection.penalty.model.admin.Permissionmodel;
import com.inspection.penalty.model.admin.Userlistmodel;
import com.inspection.penalty.model.analytics.assignment;
import com.inspection.penalty.model.assets.Assetsmodel;
import com.inspection.penalty.model.ecrypt.Encrypt;
import com.inspection.penalty.model.ecrypt.Getclose;
import com.inspection.penalty.model.ecrypt.Getevent;
import com.inspection.penalty.model.ecrypt.Tokenrespo;
import com.inspection.penalty.model.penaltymodel.monthly;
import com.inspection.penalty.model.penaltymodel.panelty;
import com.inspection.penalty.model.penaltymodel.parameter;
import com.inspection.penalty.model.penaltymodel.vehicles;
import com.inspection.penalty.model.penaltymodel.year;
import com.inspection.penalty.service.Encrypesrb;
import com.inspection.penalty.service.ExcelExportService;
import com.inspection.penalty.service.assetsservice;
import com.inspection.penalty.service.paraservice;
import com.inspection.penalty.service.userauthservice;
import com.inspection.penalty.service.analytic.analtyc;
import com.inspection.penalty.service.rajcopwservice.VehicleService;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@CrossOrigin("*")
public class home {
    
    @Autowired
    private paraservice para;

    @Autowired
    private userauthservice authservice;
    
    @Autowired
    private assetsservice addservice;
    
    @Autowired
    private analtyc analtyc;
    @Autowired
    private Encrypesrb crypto;

    @Autowired
    private VehicleService vehicleservice;
   


        @Autowired
    private ExcelExportService excelExportService;

    @RequestMapping("/")
    @ResponseBody
    public List<parameter> requestMethodName() {
        List<parameter> param=para.penaltycal();

        return param;

    }

    @GetMapping("/assignment")
    public List<assignment> assignment(@RequestParam String start,@RequestParam String end) {
        return analtyc.getassignment(start,end);
    }


    String response;
    @GetMapping("/Tokengenerate")
    public CompletableFuture<String> getencrypt(@RequestParam String clientid,@RequestParam String secrete) {
        
      
        

        
        return vehicleservice.gettokken(clientid, secrete);
    }
    String respnsestring;
    @PostMapping("/updateVehicleRequest")
    public CompletableFuture<String> updateVehicleRequest(@RequestBody Getevent newgetevent) {
        
       return vehicleservice.updateVehicleRequestAsync(newgetevent);


    }


    @PostMapping("/caseupdate")
    public String Closecase(@RequestBody  Getclose newgetevent) {
        //TODO: process POST request

           //TODO: process POST request
           final String key=newgetevent.getKey();

           System.out.println(key);
           String iv=crypto.generateRandomIV();
           System.out.println("IV : - " + iv);
           String encodediv = Base64.encodeBase64String(iv.getBytes());
           System.out.println("encodediv " + encodediv);
      
   
           String originalString = "{\"agencyEventId\":\""+newgetevent.getEventid()+"\",\"dispatchGroup\":\""+newgetevent.getDispg()+"\"}";
          // String originalString = "{\"agencyEventId\":\"5kw9r\",\"vehicleNumber\":\""+newgetevent.getVehicle_no()+"\"}";
   
           System.out.println("Original String to encrypt - " + originalString);
           String encryptedString =  crypto.encrypt(originalString, iv, key);
           Encrypt en=new Encrypt();
           // String responseBody;
        System.out.println(encryptedString);
           System.out.println("dycrpt data");
           String decryptedStringd = crypto.decrypt(encryptedString, iv,key);
           System.out.println(decryptedStringd);
   
           //String originalStringd = "{\"v1\":\""+encryptedString+"\",\"v2\":\""+encodediv+"\"}";
   
               String responseBody;
   
           try (CloseableHttpClient client = HttpClients.createDefault()) {
               HttpPost post = new HttpPost("https://police.rajasthan.gov.in/psa-cctns-master/v1/womenSafety/closeVehicleRequest");
               post.setHeader("Content-Type","application/json");
               post.setHeader("ClientId","EMRI_USER");
               post.setHeader("Authorization","Bearer "+newgetevent.getJwtToken()+"");
               // JSON data to send
               String json = "{\"v1\":\""+encryptedString+"\",\"v2\":\""+encodediv+"\"}";
               post.setEntity(new StringEntity(json));
                   System.out.println(json);
               try (CloseableHttpResponse response = client.execute(post)) {
                   System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
                    responseBody = EntityUtils.toString(response.getEntity());
                   System.out.println("Response Body: " + responseBody);
   
                   ObjectMapper objectMapper = new ObjectMapper();
                   try {
                      // Convert JSON string to Person object
                       en = objectMapper.readValue(responseBody, Encrypt.class);
                      System.out.println("v1: " + en.getV1());
                      System.out.println("v2: " + en.getV2());
   
                      String decodediv = new String(Base64.decodeBase64(en.getV2().getBytes()));
                      String decryptedString = crypto.decrypt(en.getV1(), decodediv,key);
   
                      System.out.println(decryptedString);
                      respnsestring=decryptedString;
                  } catch (Exception e) {
                      e.printStackTrace();
                  }
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
   
        
        return respnsestring;
    }
    
    
    @GetMapping("/getpermision")
    public List<Permissionmodel> permision() {
        return authservice.getpermisioin();
    }
    

    @PostMapping("/addassets")
public int Addassets(@RequestBody Assetsmodel formdata) {
       int status= addservice.addassetsnew(formdata);
    
   
    return status;
}

@GetMapping("/assetsdata")
public List<Assetsmodel> getassets() {
    return addservice.getassets();
}

    @RequestMapping("/parameter")
    @ResponseBody
    public List<parameter> parameter() {
        List<parameter> param=para.penaltycal();
        return param;
    }
    @CrossOrigin("*")
    @PostMapping("/registerUser")
    public int Register(@RequestParam String firstname,@RequestParam String lastname,@RequestParam String rollid,@RequestParam String isactive,@RequestParam(required = false) String user_id,@RequestParam(required = false) String password,@RequestParam(required = false) String josn) {

        System.out.println(josn);
        return authservice.registerUser(firstname,lastname,rollid,isactive,user_id, password,josn);
    }

    @PostMapping("/registerUserUpdate")
    public int RegisterUpdate(@RequestParam String firstname,@RequestParam String lastname,@RequestParam String rollid,@RequestParam String isactive,@RequestParam(required = false) String user_id,@RequestParam(required = false) String password,@RequestParam(required = false) String josn) {

        System.out.println(josn);
        return authservice.registerUserupdate(firstname,lastname,rollid,isactive,user_id, password,josn);
    }
    @GetMapping("/getuserdata")
    public List<Userlistmodel> getuserdata() {
        return authservice.getuserdata();
    }
    
    @GetMapping("/getuserdatauserid")
    public List<Userlistmodel> getuserdata(@RequestParam String user_id) {
        return authservice.getuserdatawithparam(user_id);
    }
    
    @CrossOrigin("*")
    @PostMapping("/Login")
    public List<usersmodel> Login(@RequestBody usersmodel usersmodel) {

        String username=usersmodel.getUserid();
        System.out.println(username);
        return authservice.Login(usersmodel);
    }
    
    @RequestMapping("/vehicle")
    @ResponseBody
    public List<vehicles> vehiclelist() {
        return para.vehiclelist();
    }
    @RequestMapping("/penaltymeter")
    @ResponseBody
    public List<panelty> penaltymet() {
       
        List<panelty> newpen=para.penaltymeter();

        para.monthlyupdate();
      //  para.y();
        return newpen;
    }
    @GetMapping("/monthly")
    public int getpen() {
      return  para.monthlyupdate();
    }
    @GetMapping("/getmonthlydata")
    public List<monthly> getMethodName() {
    

       return para.getmonthlydata();

    }

    @GetMapping("/yearly")
    public List<year> yeardata() {
        return para.getyear();
    }

    @GetMapping("/export")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        // Example data list, replace with your actual data source
      
      
        excelExportService.exportToExcel( para.excelexpr(), response);



    }
    // @RequestMapping("/assignmentexport")
    // public void assignmentexport(HttpServletResponse response) throws IOException {
    //     // Example data list, replace with your actual data source
      
      
    //     assignmentexport.exportToExcel(analtyc2.getassignment(), response);



    // }
//this Recording download service 
       @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile(@RequestParam String fileUrl,@RequestParam String filename) {
        try {
            // Create a new HttpClient with a connection timeout
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            // Build the HttpRequest for the given file URL
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(fileUrl))
                    .timeout(Duration.ofMinutes(1))
                    .GET()
                    .build();

            // Send the request and handle the response
            HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

            // Check if the response status is OK (200)
            if (response.statusCode() == 200) {
                // Read the response body (the file content)
                byte[] fileContent = StreamUtils.copyToByteArray(response.body());

                // Set the appropriate headers to suggest a file download
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+filename+"-file.wav\"");
                headers.add(HttpHeaders.CONTENT_TYPE, "audio/wav");
                return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
            } else {
                // Return the response status if not OK
                return new ResponseEntity<>(HttpStatus.valueOf(response.statusCode()));
            }
        } catch (Exception e) {
            // Handle errors, e.g., connection issues, URL issues
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    



}
