package community.krynet.compat;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public final class Network {

    private static final HttpClient CLIENT =
        HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(15))
            .followRedirects(
                HttpClient.Redirect.NORMAL
            )
            .build();

    private Network() {}

    public static HttpClient client() {
        Compat.requireInitialized();
        return CLIENT;
    }

    public static CompletableFuture<String> get(
        String url
    ) {
        Compat.requireInitialized();

        HttpRequest request;

        try {
            request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(30))
                .GET()
                .build();
        } catch (IllegalArgumentException exception) {
            return CompletableFuture.failedFuture(exception);
        }

        return CLIENT
            .sendAsync(
                request,
                HttpResponse.BodyHandlers.ofString()
            )
            .thenApply(HttpResponse::body);
    }

    public static CompletableFuture<HttpResponse<String>> request(
        HttpRequest request
    ) {
        Compat.requireInitialized();

        return CLIENT.sendAsync(
            request,
            HttpResponse.BodyHandlers.ofString()
        );
    }
}
