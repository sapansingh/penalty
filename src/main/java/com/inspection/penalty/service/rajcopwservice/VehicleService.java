package com.inspection.penalty.service.rajcopwservice;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inspection.penalty.model.ecrypt.Encrypt;
import com.inspection.penalty.model.ecrypt.Getevent;
import com.inspection.penalty.model.ecrypt.Tokenrespo;
import com.inspection.penalty.service.Encrypesrb;

import java.util.concurrent.CompletableFuture;

@Service
public class VehicleService {

       @Autowired
    private Encrypesrb crypto;
    
    @Async
    public CompletableFuture<String> updateVehicleRequestAsync(Getevent newgetevent) {
        String respnsestring = null;
        String responseBody = null;
        Encrypt en = new Encrypt();
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost("https://police.rajasthan.gov.in/psa-cctns-master/v1/womenSafety/updateVehicleRequest");
            post.setHeader("Content-Type", "application/json");
            post.setHeader("ClientId", "EMRI_USER");
            post.setHeader("Authorization", "Bearer " + newgetevent.getJwtToken());

            // JSON data to send
            String iv = crypto.generateRandomIV();
            String encodediv = Base64.encodeBase64String(iv.getBytes());
            String originalString = "{\"agencyEventId\":\"" + newgetevent.getEventid() + "\",\"vehicleNumber\":\"" + newgetevent.getVehicle_no() + "\",\"driverNumber\":\"" + newgetevent.getMobile_no() + "\",\"dispatchGroup\":\"" + newgetevent.getDispg() + "\"}";

            String encryptedString = crypto.encrypt(originalString, iv, newgetevent.getKey());

            // Setting the JSON request body
            String json = "{\"v1\":\"" + encryptedString + "\",\"v2\":\"" + encodediv + "\"}";
            post.setEntity(new StringEntity(json));

            // Execute the HTTP request asynchronously
            try (CloseableHttpResponse response = client.execute(post)) {
                responseBody = EntityUtils.toString(response.getEntity());

                ObjectMapper objectMapper = new ObjectMapper();
                en = objectMapper.readValue(responseBody, Encrypt.class);

                String decodediv = new String(Base64.decodeBase64(en.getV2().getBytes()));
                String decryptedString = crypto.decrypt(en.getV1(), decodediv, newgetevent.getKey());
                respnsestring = decryptedString;
                System.out.println(respnsestring);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(respnsestring);
    }
    String response;
    @Async
    public CompletableFuture<String> gettokken(String clientid,String secrete){
          
        
         final String key="754A3c45wd658K09zt7E905443160621";
         String iv=crypto.generateRandomIV();
         System.out.println("IV : - " + iv);
         String encodediv = Base64.encodeBase64String(iv.getBytes());
         System.out.println("encodediv " + encodediv);
    
         String originalString = "{\"clientId\":\""+clientid+"\",\"clientSecret\":\""+secrete+"\"}";
         System.out.println("Original String to encrypt - " + originalString);
         String encryptedString =  crypto.encrypt(originalString, iv, key);
         Encrypt en=new Encrypt();
         String responseBody;
        
         System.out.println("dycrpt data");
         String decryptedStringd = crypto.decrypt(encryptedString, iv,key);
         System.out.println(decryptedStringd);

              try (CloseableHttpClient client = HttpClients.createDefault()) {
            // HttpPost post = new HttpPost("https://policetraining.rajasthan.gov.in/psa-auth/clientAppToken");
            String tokenurl="https://police.rajasthan.gov.in/psa-auth/clientAppToken";
            System.out.println(tokenurl);
            HttpPost post = new HttpPost(tokenurl);
            post.setHeader("Content-Type","application/json");
            post.setHeader("ClientId","EMRI_USER");

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

               } catch (Exception e) {
                   e.printStackTrace();
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Tokenrespo tr=new Tokenrespo();
     
        String v2 = en.getV2();
        String v1 = en.getV1();
        
                if(v2 != null && v1 != null){
        
                    String decodediv = new String(Base64.decodeBase64(en.getV2().getBytes()));
                    String decryptedString = crypto.decrypt(en.getV1(), decodediv,key);
                    
                        System.out.println(decryptedString);
               ObjectMapper objectMapper = new ObjectMapper();
                            try {
                               // Convert JSON string to Person object
                               tr = objectMapper.readValue(decryptedString, Tokenrespo.class);
                               response=tr.toString();

                               
    
                            if(tr.getJwtToken()!=""){
                                crypto.gettoken(tr.getAccessTokenExpiryTime(), tr.getJwtToken(), tr.getMessage(), tr.getRefreshTokenExpiryTime() ,tr.getStatus(),tr.getRefreshToken());
    
                            }
                       
                   } catch (Exception e) {
                       e.printStackTrace();
                   }

        }else{
            response="data api failed try again";
        }
      return null;

    }


}
