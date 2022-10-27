package uk.ac.acm.utils;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ObjectConverter<From,To> implements Converter<From, To> {

    private Class<To> type;

    @Override
    /**
     * takes an object and convert it to another object
     */
    public To convert(From from) {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        objectMapper.setDateFormat(df);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        
        return objectMapper.convertValue(from, getType());
    }
    /**
     * takes an object and convert it to another object
     */
    @Override
    public To convertFromObject(Object from) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        objectMapper.setDateFormat(df);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        return objectMapper.readValue(from.toString(), getType());
    }


}
