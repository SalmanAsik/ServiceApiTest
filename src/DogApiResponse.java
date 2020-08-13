import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class DogApiResponse {
	private final String USER_AGENT="Mozilla/5.0";
	public String GetResponse() throws ClientProtocolException, IOException
	{
		StringBuffer result = new StringBuffer();
		HttpClient client = new DefaultHttpClient();
		//url for list all dog breeds
		String url = "https://dog.ceo/api/breeds/list/all";
		String retrieverBreed = "retriever";
		//Get request for url
		HttpGet request = new HttpGet(url);
		//Add header for request
		request.addHeader("User-Agent",USER_AGENT);
		//get response of the url request
		HttpResponse response = client.execute(request);
		//get response code
		int responseCode = response.getStatusLine().getStatusCode();
		System.out.println("Response Code: " + responseCode);
		try{
		if(responseCode == 200)
	    {
			System.out.println("Get Response is Successfull");
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while((line=reader.readLine())!=null)
			{
				result.append(line);
				System.out.println("Test Case1: Pass");
				//display results
				System.out.println(result.toString());
			}
		}
		if(result.toString().contains(retrieverBreed)) {
			System.out.println("Test Case2: Pass  Verify - retriever is within list");
		}
		return result.toString();
		}
		catch(Exception ex)
	    {
		result.append("Get Response Failed");
		return result.toString();
	    }
	}

	public String GetResponseforretriever() throws ClientProtocolException, IOException
	{
		StringBuffer result = new StringBuffer();
		HttpClient client = new DefaultHttpClient();
		//url for retriever breed list
		String url = "https://dog.ceo/api/breed/retriever/list";
		//Get request for url
		HttpGet request = new HttpGet(url);
		//Add header for request
		request.addHeader("User-Agent",USER_AGENT);
		//get response of the url request
		HttpResponse response = client.execute(request);
		//get response code
		int responseCode = response.getStatusLine().getStatusCode();
		System.out.println("Response Code: " + responseCode);
		try{
		if(responseCode == 200)
	    {
			System.out.println("Get Response is Successfull");
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while((line = reader.readLine())!=null)
			{
				result.append(line);
				System.out.println("Test Case3: Pass");
				//display results
				System.out.println(result.toString());
			}
		}
		return result.toString();
		}
		catch(Exception ex)
	    {
		result.append("Get Response Failed");
		return result.toString();
	    }
	}
	public String GetResponseforretrievergolden() throws ClientProtocolException, IOException
	{
		StringBuffer result = new StringBuffer();
		HttpClient client = new DefaultHttpClient();
		//url for golden retriever breed random images
		String url = "https://dog.ceo/api/breed/retriever/golden/images/random";
		//Get request for url
		HttpGet request = new HttpGet(url);
		//Add header for request
		request.addHeader("User-Agent",USER_AGENT);
		//get response of the url request
		HttpResponse response = client.execute(request);
		//get response code
		int responseCode = response.getStatusLine().getStatusCode();
		System.out.println("Response Code: " + responseCode);
		try{
		if(responseCode == 200)
	    {
			System.out.println("Get Response is Successfull");
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while((line = reader.readLine())!=null)
			{
				result.append(line);
				System.out.println("Test Case4: Pass");
				//display results
				System.out.println(result.toString());
			}
		}
		return result.toString();
		}
		catch(Exception ex)
	    {
		result.append("Get Response Failed");
		return result.toString();
	    }
	}
}