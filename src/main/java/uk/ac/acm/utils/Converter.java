package uk.ac.acm.utils;

import java.io.IOException;

public interface Converter<From,To> {
    To convert(From param);

    To convertFromObject(Object from) throws IOException;
}
