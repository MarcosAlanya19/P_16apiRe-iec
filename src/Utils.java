import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.util.Scanner;

public class Utils {
    //function S / N
    public static boolean toTryAgain() {
        System.out.println(ANSI_WHITE + "\n¿Desea comprar algo mas?" + ANSI_WHITE);
        System.out.println("S / N");
        Scanner value = new Scanner(System.in);
        String response = value.next();
        return (response.equalsIgnoreCase("S"));
    }

    public static final String ANSI_WHITE = "\u001B[37m";

    public static String findDni(String dni) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        Request request = new Request.Builder()
                .url("https://api.apis.net.pe/v1/dni?numero=" + dni)
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
