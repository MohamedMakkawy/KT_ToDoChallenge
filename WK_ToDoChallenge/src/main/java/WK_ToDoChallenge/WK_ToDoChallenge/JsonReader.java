package WK_ToDoChallenge.WK_ToDoChallenge;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

	public static JSONObject jsonReader (String fileName)
	{
	     JSONParser parser = new JSONParser();
	     JSONObject jsonObject = new JSONObject();

	        try (Reader reader = new FileReader(fileName)) {

	            jsonObject = (JSONObject) parser.parse(reader);
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return jsonObject;
	    }
	
}

