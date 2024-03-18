package collection.treemap;

import java.util.Comparator;

public class CustomCompare implements Comparator<String>{  //String as key is of type String

	@Override
	public int compare(String existingObj, String newObj) {
		if (existingObj.length() < newObj.length())
			return -1;
		else if (existingObj.length() > newObj.length())
			return +1;
		else
			return 0;
	}

}
