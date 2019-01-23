package webapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;


public class getAllHotels {
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	  public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONArray json = new JSONArray(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }
	  
	  public List<String> gethotels() throws IOException, JSONException
	  {
		  JSONArray json = readJsonFromUrl("https://raw.githubusercontent.com/apigee/DevJam/master/Resources/hotels-data.json");
		  List<String> allhotels = new ArrayList<>();
		  for(int i=0;i<json.length();i++)
		  {
			  allhotels.add(json.getJSONObject(i).getString("name"));
		  }
		  return allhotels;
	  }

}
