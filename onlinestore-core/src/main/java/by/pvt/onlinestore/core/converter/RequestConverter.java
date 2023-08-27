package by.pvt.onlinestore.core.converter;

import com.google.common.base.Splitter;

import java.util.Map;

public class RequestConverter {
    public Map<String, String> stringRequestToMap(String stringRequest) {
        return Splitter.on('&').withKeyValueSeparator('=').split(stringRequest);
    }

}
