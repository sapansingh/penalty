package com.inspection.penalty.controller;

import java.io.IOException;
import java.io.InputStream;

import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.Permission;
import java.time.Duration;

import java.util.List;
import org.springframework.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inspection.penalty.model.usersmodel;
import com.inspection.penalty.model.admin.Permissionmodel;
import com.inspection.penalty.model.analytics.assignment;
import com.inspection.penalty.model.assets.Assetsmodel;

import com.inspection.penalty.model.penaltymodel.monthly;
import com.inspection.penalty.model.penaltymodel.panelty;
import com.inspection.penalty.model.penaltymodel.parameter;
import com.inspection.penalty.model.penaltymodel.vehicles;
import com.inspection.penalty.model.penaltymodel.year;

import com.inspection.penalty.service.ExcelExportService;
import com.inspection.penalty.service.assetsservice;
import com.inspection.penalty.service.paraservice;
import com.inspection.penalty.service.userauthservice;
import com.inspection.penalty.service.analytic.analtyc;
import com.inspection.penalty.service.export.Assignmentexport;

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
