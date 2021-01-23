package gc;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Apache HttpClient demo
 * 参考优秀同学xpboy68
 *
 * @author
 * @date 2021/1/24
 */
public class HttpClientDemo {
    private static final String URL = "http://localhost:8801";
    private static final int TIME_OUT = 1000;
    private static final int CPU = Runtime.getRuntime().availableProcessors();
    private static final long RUN_SECONDS = CPU * 2;
    private static final int THREADS = CPU;

    public static void main(String[] args) {

        final RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(TIME_OUT)
                .setConnectTimeout(TIME_OUT).build();

        long startMillis = System.currentTimeMillis();
        long timeoutMillis = TimeUnit.SECONDS.toMillis(RUN_SECONDS);
        long endMillis = startMillis + timeoutMillis;

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        for (int i = 0; i < THREADS; i++) {
            executorService.execute(() -> {
                try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                    while (System.currentTimeMillis() < endMillis && !Thread.interrupted()) {
                        doGet(httpClient, requestConfig);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void doGet(CloseableHttpClient httpClient, RequestConfig requestConfig) {
        HttpGet httpGet = new HttpGet(URL);
        httpGet.setConfig(requestConfig);
        try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
            System.out.printf("status:%s\ncontent:%s%n", httpResponse.getStatusLine(), EntityUtils.toString(httpResponse.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
