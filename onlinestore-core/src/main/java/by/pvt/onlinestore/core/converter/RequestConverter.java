package by.pvt.onlinestore.core.converter;

import by.pvt.onlinestore.core.dto.user.UserRequestDTO;
import com.google.common.base.Splitter;

import java.util.Map;

public class RequestConverter{
    public Map<String,String> stringRequestToMap(String stringRequest){
        return Splitter.on('&').withKeyValueSeparator('=').split(stringRequest);
    }
//    public UserRequestDTO mapToUserRequestDTO (Map<String,String> bodyMap, UserRequestDTO userRequestDTO){
//        if(bodyMap.containsKey("entry")){
//            bo
//        }
//    }

}
