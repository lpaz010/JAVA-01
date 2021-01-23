package gc;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author pzliu
 * @date 2021/1/24
 */
public class OkHttpClientDemo {

    private static final String URL = "http://localhost:8801";
    private static final int TIME_OUT = 1000;
    private static final int CPU = Runtime.getRuntime().availableProcessors();
    private static final long RUN_SECONDS = CPU * 2;
    private static final int THREADS = CPU;

    public static void main(String[] args) {

        final long startMillis = System.currentTimeMillis();
        final long timeoutMillis = TimeUnit.SECONDS.toMillis(RUN_SECONDS);
        final long endMillis = startMillis + timeoutMillis;

        final OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        for (int i = 0; i < THREADS; i++) {
            executorService.execute(() -> {
                while (System.currentTimeMillis() < endMillis && !Thread.interrupted()) {
                    doGet(client);
                }
            });
        }

    }

    private static void doGet(OkHttpClient okHttpClient) {

        Call call = okHttpClient.newCall(new Request.Builder().url(URL).build());
        try (Response response = call.execute()) {
            System.out.printf("status:%s content:%s%n", response.isSuccessful(), response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
