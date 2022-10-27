package uk.ac.acm.utils;

import java.util.Collection;

public class Utils {

	/**
	 * Checks if an object is null or if string is empty
	 * @param input
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Boolean IS_EMPTY(Object input) {
		if(input instanceof String) {
			return (((String) input).isEmpty() || ((String) input)== null);

		}else if(input instanceof Collection<?>) {
			
			if((Collection<Object>) input == null) 
				return true;
			if(((Collection<Object>) input).size() < 1 )
				return true;
			
			return ((Collection<Object>) input).isEmpty();
		}else {
			return (input == null);
		}
	}
}
