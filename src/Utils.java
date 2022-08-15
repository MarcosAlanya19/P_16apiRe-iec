import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.util.Scanner;

public class Utils {
    // Bucle
    public static boolean toTryAgain() {
        String ANSI_WHITE = "\u001B[37m";
        System.out.println(ANSI_WHITE + "\n¿Desea comprar algo mas?" + ANSI_WHITE);
        System.out.println("S / N");
        Scanner value = new Scanner(System.in);
        String response = value.next();
        return (response.equalsIgnoreCase("S"));
    }
    // API REÑIEC
    public static String findRuc(String ruc) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        Request request = new Request.Builder()
                .url("https://api.apis.net.pe/v1/ruc?numero=" + ruc)
                .addHeader("Authorization", "Bearer apis-token-1.aTSI1U7KEuT-6bbbCguH-4Y8TI6KS73N")
                .build();
        Response response = client.newCall(request).execute();
        if (response.code() == 200) {
            assert response.body() != null;
            String jsonData = response.body().string();
            Gson gson = new Gson();
            ResponseApi entity = gson.fromJson(jsonData, ResponseApi.class);
            return entity.nombre;
        } else {
            return "EMPRESA NO REGISTRADA / PERSONA JURIDICA NO REGISTRADA";
        }
    }
    public static String findRucDir(String documento) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        Request request = new Request.Builder()
                .url("https://api.apis.net.pe/v1/ruc?numero=" + documento)
                .addHeader("Authorization", "Bearer apis-token-1.aTSI1U7KEuT-6bbbCguH-4Y8TI6KS73N")
                .build();
        Response response = client.newCall(request).execute();
        if (response.code() == 200) {
            assert response.body() != null;
            String jsonData = response.body().string();
            Gson gson = new Gson();
            ResponseApi entity = gson.fromJson(jsonData, ResponseApi.class);
            return entity.direccion;
        } else {
            return "NO SE ENCUENTRA DIRECCION";
        }

    }
    public static String findDni(String dni) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        Request request = new Request.Builder()
                .url("https://api.apis.net.pe/v1/dni?numero=" + dni)
//                .url("https://api.apis.net.pe/v1/ruc  ?numero=" + dni)
                .addHeader("Authorization", "Bearer apis-token-1.aTSI1U7KEuT-6bbbCguH-4Y8TI6KS73N")
                .build();
        Response response = client.newCall(request).execute();
        if (response.code() == 200) {
            assert response.body() != null;
            String jsonData = response.body().string();
            Gson gson = new Gson();
            ResponseApi entity = gson.fromJson(jsonData, ResponseApi.class);
            return entity.nombre;
        } else {
            return "PERSONA DESCONOCIDA";
        }
    }
}
