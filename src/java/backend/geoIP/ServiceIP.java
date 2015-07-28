/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.geoIP;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ServiceIP {
    public String getCity(){
        Client client= ClientBuilder.newClient();
WebTarget service = client.target("http://www.telize.com/geoip");
        Location l = service.request(MediaType.APPLICATION_JSON).get(Location.class);
        return l.getCity();
    }
    
    public String getCountry(){
        Client client= ClientBuilder.newClient();
WebTarget service = client.target("http://www.telize.com/geoip");
        Location l = service.request(MediaType.APPLICATION_JSON).get(Location.class);
        return l.getCountry();
    }
    
    public String getContinent(){
        Client client= ClientBuilder.newClient();
WebTarget service = client.target("http://www.telize.com/geoip");
        Location l = service.request(MediaType.APPLICATION_JSON).get(Location.class);
        return l.getContinent_code();
    }
}
