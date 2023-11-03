package util;

import com.google.gson.JsonElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
// TODO: Aggiungere campo "Description" da mandare alla risposta
public class HttpResponse {

    @NonNull
    private String statusReponse;

    @NonNull
    private String description;

    private JsonElement data;

    public HttpResponse(String statusReponse, JsonElement data) {
        this.statusReponse = statusReponse;
        this.data = data;
    }
}