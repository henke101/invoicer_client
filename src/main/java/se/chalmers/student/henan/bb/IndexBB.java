/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.student.henan.bb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.primefaces.json.JSONException;
import se.chalmers.student.henan.model.Invoice;


/**
 *
 * @author HenrikAndersson
 */

@Named("index")
@RequestScoped
public class IndexBB {
    
    private static final String BASE_URL = "http://localhost:9000";
    private static final String CLIENT = "chalmers";
    private List<Invoice> invoices;
    
    public IndexBB(){
    }
    
    public List<Invoice> getInvoices(){
        return invoices;
    }
    public void payInvoice(Long id){
        try{
            URL url = new URL(BASE_URL + "/invoices/" + id + "/paid");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.getInputStream();
        }
        catch (Exception e){
            Logger.getAnonymousLogger().log(Level.INFO, e.toString());
        }
    }
    
    @Inject
    public void createInvoicesFromJSON(){
        this.invoices = new ArrayList<Invoice>();
        try{
            JSONArray arr = readJSONArrayFromUrl(BASE_URL + "/invoices/" + CLIENT);
            Iterator i = arr.iterator();
            
            while(i.hasNext()){
                JSONObject o = (JSONObject) i.next();
                String dueDate = (String) o.get("dueDate");
                String invoiceDate = (String) o.get("invoiceDate");
                Long id = (Long) o.get("id");
                boolean paid = (Boolean) o.get("paid");
                JSONObject client = (JSONObject)o.get("client");
                String clientName = (String) client.get("name");
                double totalRate = (Double) o.get("totalRate");
                String title = (String) o.get("title");
                JSONObject bankAccount= (JSONObject)o.get("bankAccount");
                String accountType = (String) bankAccount.get("accountType");
                String accountNumber = (String) bankAccount.get("accountNumber");
                
                
                invoices.add(new Invoice(dueDate, invoiceDate, id, paid,
                        clientName, totalRate, title, accountType, accountNumber));
            }
        }
        catch (Exception e){
            Logger.getAnonymousLogger().log(Level.INFO, "FAIL{0}", e);
        }
    }
    
    private JSONArray readJSONArrayFromUrl(String urlString) throws IOException, JSONException, ParseException {
        String jsonString = retrieveJSONString(urlString);
        JSONArray jsonArray = (JSONArray)new JSONParser().parse(jsonString);
        return jsonArray;
    }
    
    private String retrieveJSONString(String urlString) throws MalformedURLException, IOException{
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String inputLine = readAll(in);
        
        return inputLine;
    }
    
    private String readAll(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int next;
        while ((next = reader.read()) != -1) {
            sb.append((char) next);
        }
        return sb.toString();
    }
}