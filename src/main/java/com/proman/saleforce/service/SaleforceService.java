package com.proman.saleforce.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.payloads.request.saleforce.OrderRequest;
import com.payloads.response.saleforce.tokenResponse;
import com.proman.saleforce.model.Product;

import java.io.BufferedReader;
 
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.json.JSONException;

@Component
public class SaleforceService {
 
    static final String USERNAME     = "bacramo@gmail.com";
    static final String PASSWORD     = "Brian.1691998";
    static final String LOGINURL     = "https://login.salesforce.com";
    static final String GRANTSERVICE = "/services/oauth2/token?grant_type=password";
    static final String CLIENTID     = "3MVG91BJr_0ZDQ4ua596r74TmsP0wADM6in14QgqIYyR_7POEW6Fu5s61FcUP7wSw_YXFIE.HfbdVC4hqaNj5";
    static final String CLIENTSECRET = "46C1E4CA9046A9AE295C5B84F167BB1A03F3E74D7F3A36D3547680EC9C3D84D7";
    private static String REST_ENDPOINT = "/services/data" ;
    private static String API_VERSION = "/v48.0" ;
    private static String baseUri;
    private static Header oauthHeader;
    private static Header prettyPrintHeader = new BasicHeader("X-PrettyPrint", "1");
    private static String productId ;
    private static String privateUserURL;
    private List<Product> productList = new ArrayList<Product>();
    private static OrderRequest ordReq;
    // private static String productFirstName;
    // private static String productLastName;
    // private static String productCompany;

    public tokenResponse token() {
        HttpClient httpclient = HttpClientBuilder.create().build();

        // Assemble the login request URL
        String loginURL = LOGINURL + GRANTSERVICE + "&client_id=" + CLIENTID + "&client_secret=" + CLIENTSECRET
                + "&username=" + USERNAME + "&password=" + PASSWORD;

        // Login requests must be POSTs
        HttpPost httpPost = new HttpPost(loginURL);
        HttpResponse response = null;

        try {
            // Execute the login POST request
            response = httpclient.execute(httpPost);
        } catch (ClientProtocolException cpException) {
            cpException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        // verify response is HTTP OK
        final int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            System.out.println("Error authenticating to Force.com: " + statusCode);
            // Error is in EntityUtils.toString(response.getEntity())
            return null;
        }

        String getResult = null;
        try {
            getResult = EntityUtils.toString(response.getEntity());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        JSONObject jsonObject = null;
        String loginAccessToken = null;
        String loginInstanceUrl = null;

        try {
            jsonObject = (JSONObject) new JSONTokener(getResult).nextValue();
            loginAccessToken = jsonObject.getString("access_token");
            loginInstanceUrl = jsonObject.getString("instance_url");
            privateUserURL = loginInstanceUrl;
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
        tokenResponse res = new tokenResponse(loginAccessToken, privateUserURL);
        return res;
    }

    public ResponseEntity<?> updateOrderRequest(OrderRequest orderRequest) {
        ordReq = orderRequest;
        authen("createOrder");
        return null;
    }

    public List<Product> authen(String function) {
        HttpClient httpclient = HttpClientBuilder.create().build();

        // Assemble the login request URL
        String loginURL = LOGINURL + GRANTSERVICE + "&client_id=" + CLIENTID + "&client_secret=" + CLIENTSECRET
                + "&username=" + USERNAME + "&password=" + PASSWORD;

        // Login requests must be POSTs
        HttpPost httpPost = new HttpPost(loginURL);
        HttpResponse response = null;

        try {
            // Execute the login POST request
            response = httpclient.execute(httpPost);
        } catch (ClientProtocolException cpException) {
            cpException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        // verify response is HTTP OK
        final int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            System.out.println("Error authenticating to Force.com: " + statusCode);
            // Error is in EntityUtils.toString(response.getEntity())
            return null;
        }

        String getResult = null;
        try {
            getResult = EntityUtils.toString(response.getEntity());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        JSONObject jsonObject = null;
        String loginAccessToken = null;
        String loginInstanceUrl = null;

        try {
            jsonObject = (JSONObject) new JSONTokener(getResult).nextValue();
            loginAccessToken = jsonObject.getString("access_token");
            loginInstanceUrl = jsonObject.getString("instance_url");
            privateUserURL = loginInstanceUrl;
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }

        baseUri = loginInstanceUrl + REST_ENDPOINT + API_VERSION;
        oauthHeader = new BasicHeader("Authorization", "OAuth " + loginAccessToken);
        System.out.println("oauthHeader1: " + oauthHeader);
        System.out.println("\n" + response.getStatusLine());
        System.out.println("Successful login");
        System.out.println("instance URL: " + loginInstanceUrl);
        System.out.println("access token/session ID: " + loginAccessToken);
        System.out.println("baseUri: " + baseUri);

        // Run codes to query, isnert, update and delete records in Salesforce using
        // REST API
        // queryProducts();
        // createProducts();
        // updateProducts();
        // deleteProducts();
        switch (function) {
            case "get":
                queryProducts();
                break;
            case "createOrder":
                createOrder();
                break;
            default:
                // code block
        }
        // release connection
        httpPost.releaseConnection();
        return productList;
    }

    // Query Products using REST HttpGet
    public void queryProducts() {
        productList = new ArrayList<Product>();
        System.out.println("\n_______________ Product QUERY _______________");
        try {

            // Set up the HTTP objects needed to make the request.
            HttpClient httpClient = HttpClientBuilder.create().build();

            // String uri = baseUri +
            // "/query?q=Select+Id+,+FirstName+,+LastName+,+Company+From+Product+Limit+5";
            String uri = baseUri + "/query?q=Select+Id+From+Product2";
            System.out.println("Query URL: " + uri);
            HttpGet httpGet = new HttpGet(uri);
            System.out.println("oauthHeader2: " + oauthHeader);
            httpGet.addHeader(oauthHeader);
            httpGet.addHeader(prettyPrintHeader);

            // Make the request.
            HttpResponse response = httpClient.execute(httpGet);

            // Process the result
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String response_string = EntityUtils.toString(response.getEntity());
                try {
                    JSONObject json = new JSONObject(response_string);
                    // System.out.println("JSON result of Query:\n" + json.toString(1));
                    JSONArray j = json.getJSONArray("records");
                    for (int i = 0; i < j.length(); i++) {
                        productId = json.getJSONArray("records").getJSONObject(i).getString("Id");
                        // productFirstName =
                        // json.getJSONArray("records").getJSONObject(i).getString("FirstName");
                        // productLastName =
                        // json.getJSONArray("records").getJSONObject(i).getString("LastName");
                        // productCompany =
                        // json.getJSONArray("records").getJSONObject(i).getString("Company");
                        // System.out.println("Product record is: " + i + ". " + productId + " " +
                        // productFirstName + " " + productLastName + "(" + productCompany + ")");
                        // System.out.println("Product record is: " + i + productId);
                        String productURL = json.getJSONArray("records").getJSONObject(i).getJSONObject("attributes")
                                .getString("url");
                        queryAProduct(productURL);
                    }

                } catch (JSONException je) {
                    je.printStackTrace();
                }
            } else {
                System.out.println("Query was unsuccessful. Status code returned is " + statusCode);
                System.out.println("An error has occured. Http status: " + response.getStatusLine().getStatusCode());
                System.out.println(getBody(response.getEntity().getContent()));
                System.exit(-1);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }

    public void queryAProduct(String productURL) {
        System.out.println("\n______SPECIFIC Product QUERY ______");
        System.out.println(productURL);
        try {

            // Set up the HTTP objects needed to make the request.
            HttpClient httpClient = HttpClientBuilder.create().build();
            String uri = privateUserURL + productURL;
            HttpGet httpGet = new HttpGet(uri);
            httpGet.addHeader(oauthHeader);
            httpGet.addHeader(prettyPrintHeader);
            // Make the request.
            HttpResponse response = httpClient.execute(httpGet);
            // Process the result
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String response_string = EntityUtils.toString(response.getEntity());
                try {
                    JSONObject json = new JSONObject(response_string);
                    Product currentProduct = new Product(json.get("Id").toString(), json.get("Name").toString(),
                            json.get("Color__c").toString(), json.get("CreatedDate").toString(),
                            json.get("Type__c").toString(), json.getInt("Price__c"), json.get("image__c").toString(), 1,
                            json.get("Brand__c").toString());
                    productList.add(currentProduct);
                } catch (JSONException je) {
                    je.printStackTrace();
                }
            } else {
                System.out.println("Query was unsuccessful. Status code returned is " + statusCode);
                System.out.println("An error has occured. Http status: " + response.getStatusLine().getStatusCode());
                System.out.println(getBody(response.getEntity().getContent()));
                System.exit(-1);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }

    public static void createOrder() {
        System.out.println("\n_______________ Product INSERT _______________");

        String uri = baseUri + "/sobjects/OvOrder__c/";
        try {

            // create the JSON object containing the new product details.
            JSONObject order = new JSONObject();
            order.put("Account__c", ordReq.getAccount__c());
            order.put("Billing_address__c", ordReq.getBilling_address__c());
            order.put("Product__c", ordReq.getProduct__c());
            order.put("Quantity__c", ordReq.getQuantity__c());
            order.put("Shipping_address__c", ordReq.getShipping_address__c());
            order.put("status__c", ordReq.getStatus__c());
 
            System.out.println("JSON for order record to be inserted:\n" + order.toString(1));
 
            //Construct the objects needed for the request
            HttpClient httpClient = HttpClientBuilder.create().build();
 
            HttpPost httpPost = new HttpPost(uri);
            httpPost.addHeader(oauthHeader);
            httpPost.addHeader(prettyPrintHeader);
            // The message we are going to post
            StringEntity body = new StringEntity(order.toString(1));
            body.setContentType("application/json");
            httpPost.setEntity(body);
 
            //Make the request
            HttpResponse response = httpClient.execute(httpPost);
 
            //Process the results
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 201) {
                String response_string = EntityUtils.toString(response.getEntity());
                JSONObject json = new JSONObject(response_string);
                // Store the retrieved order id to use when we update the order.
                // orderId = json.getString("id");
                System.out.println(json);
            } else {
                System.out.println("Insertion unsuccessful. Status code returned is " + statusCode);
            }
        } catch (JSONException e) {
            System.out.println("Issue creating JSON or processing results");
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }
    // Create Products using REST HttpPost
    public static void createProducts() {
        System.out.println("\n_______________ Product INSERT _______________");
 
        String uri = baseUri + "/sobjects/Product/";
        try {
 
            //create the JSON object containing the new order details.
            JSONObject product = new JSONObject();
            product.put("FirstName", "REST API");
            product.put("LastName", "Product");
            product.put("Company", "asagarwal.com");
 
            System.out.println("JSON for product record to be inserted:\n" + product.toString(1));
 
            //Construct the objects needed for the request
            HttpClient httpClient = HttpClientBuilder.create().build();
 
            HttpPost httpPost = new HttpPost(uri);
            httpPost.addHeader(oauthHeader);
            httpPost.addHeader(prettyPrintHeader);
            // The message we are going to post
            StringEntity body = new StringEntity(product.toString(1));
            body.setContentType("application/json");
            httpPost.setEntity(body);
 
            //Make the request
            HttpResponse response = httpClient.execute(httpPost);
 
            //Process the results
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 201) {
                String response_string = EntityUtils.toString(response.getEntity());
                JSONObject json = new JSONObject(response_string);
                // Store the retrieved product id to use when we update the product.
                productId = json.getString("id");
                System.out.println("New Product id from response: " + productId);
            } else {
                System.out.println("Insertion unsuccessful. Status code returned is " + statusCode);
            }
        } catch (JSONException e) {
            System.out.println("Issue creating JSON or processing results");
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }
 
    // Update Products using REST HttpPatch. We have to create the HTTPPatch, as it does not exist in the standard library
    // Since the PATCH method was only recently standardized and is not yet implemented in Apache HttpClient
    public static void updateProducts() {
        System.out.println("\n_______________ Product UPDATE _______________");
 
        //Notice, the id for the record to update is part of the URI, not part of the JSON
        String uri = baseUri + "/sobjects/Product/" + productId;
        try {
            //Create the JSON object containing the updated product last name
            //and the id of the product we are updating.
            JSONObject product = new JSONObject();
            product.put("LastName", "Product --UPDATED");
            System.out.println("JSON for update of product record:\n" + product.toString(1));
 
            //Set up the objects necessary to make the request.
            //DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpClient httpClient = HttpClientBuilder.create().build();
 
            HttpPatch httpPatch = new HttpPatch(uri);
            httpPatch.addHeader(oauthHeader);
            httpPatch.addHeader(prettyPrintHeader);
            StringEntity body = new StringEntity(product.toString(1));
            body.setContentType("application/json");
            httpPatch.setEntity(body);
 
            //Make the request
            HttpResponse response = httpClient.execute(httpPatch);
 
            //Process the response
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 204) {
                System.out.println("Updated the product successfully.");
            } else {
                System.out.println("Product update NOT successfully. Status code is " + statusCode);
            }
        } catch (JSONException e) {
            System.out.println("Issue creating JSON or processing results");
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }
 
    // Extend the Apache HttpPost method to implement an HttpPatch
    private static class HttpPatch extends HttpPost {
        public HttpPatch(String uri) {
            super(uri);
        }
 
        public String getMethod() {
            return "PATCH";
        }
    }
 
    // Update Products using REST HttpDelete (We have to create the HTTPDelete, as it does not exist in the standard library.)
    public static void deleteProducts() {
        System.out.println("\n_______________ Product DELETE _______________");
 
        //Notice, the id for the record to update is part of the URI, not part of the JSON
        String uri = baseUri + "/sobjects/Product/" + productId;
        try {
            //Set up the objects necessary to make the request.
            HttpClient httpClient = HttpClientBuilder.create().build();
 
            HttpDelete httpDelete = new HttpDelete(uri);
            httpDelete.addHeader(oauthHeader);
            httpDelete.addHeader(prettyPrintHeader);
 
            //Make the request
            HttpResponse response = httpClient.execute(httpDelete);
 
            //Process the response
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 204) {
                System.out.println("Deleted the product successfully.");
            } else {
                System.out.println("Product delete NOT successful. Status code is " + statusCode);
            }
        } catch (JSONException e) {
            System.out.println("Issue creating JSON or processing results");
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }
 
    private static String getBody(InputStream inputStream) {
        String result = "";
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(inputStream)
            );
            String inputLine;
            while ( (inputLine = in.readLine() ) != null ) {
                result += inputLine;
                result += "\n";
            }
            in.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return result;
    }
}