package Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class JSONClass {

    private final String jsonFilePath;

    public JSONClass(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }


    public String readJson(String key) {
        try {
            InputStream input = JSONClass.class.getClassLoader().getResourceAsStream(jsonFilePath);

            JSONObject jsonObject = (JSONObject) new JSONParser().parse(new InputStreamReader(Objects.requireNonNull(input)));

            if (jsonObject.get(key) == null) {
                throw new NullPointerException("Invalid JsonKey Entered");
            }
            return (String) jsonObject.get(key);

        } catch (IOException e) {
            throw new RuntimeException("JSONFile Not Found");
        } catch (ParseException e) {
            throw new RuntimeException("Cannot Parse JsonKey entered!");
        }
    }
}
