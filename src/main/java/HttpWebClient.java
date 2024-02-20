import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;

public class HttpWebClient {
    public InputStream getData(String endpoint) throws IOException {
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        return connection.getInputStream();
    }
}
