
package argumentconverter;
 
import static org.junit.jupiter.api.Assertions.*;
 
import java.time.LocalDate;
 
 
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.converter.ConvertWith;

import org.junit.jupiter.params.provider.CsvSource;
 
class ExplicitConverterTestEx {
 
	/*

	We sometimes need to provide a custom and explicit converter for arguments.
 
	Suppose we want to convert strings with the yyyy/mm/dd format to LocalDate instances.
 
	First, we need to implement the ArgumentConverter interface:
 
    */

	/* this test will fail without explicit converted your string date should be in standard format of yyyy-mm-dd

	 *  if its in any other format than standard iso format, then it cannot be assigned as it is to LocalDate ref.

	 *  as parsing string date will give an exception, so you need explicit DateTimeFormatter to parse the

	 *  string(date) given in non-iso format.

          soln: use explicit ArgumentConverted class to parse and convert every parameter to expected localdate type.

	 */



//	@ParameterizedTest
//
//	@CsvSource({"2018/12/25,2018", "2019/02/11,2019"})
//
//	void getYear_ShouldWorkAsExpected(
//
//	 LocalDate date, int expected) {
//
//	    assertEquals(expected, date.getYear());
//
//	}

    


	//Then we should refer to the converter via the @ConvertWith annotation:

    //see the usage of @ConvertWith anno, it uses explicit argument converted to parse the date string given in non-iso format

	
	@ParameterizedTest

	@CsvSource({"2018/12/25,2018", "2019/02/11,2019"})

	void getYear_ShouldWorkAsExpectedFail(

	  LocalDate date, int expected) {

	    assertEquals(expected, date.getYear());

	}
	
	
	@ParameterizedTest

	@CsvSource({"2018/12/25,2018", "2019/02/11,2019"})

	void getYear_ShouldWorkAsExpected(

	  @ConvertWith(SlashyDateConverter.class) LocalDate date, int expected) {

	    assertEquals(expected, date.getYear());

	}
 
 
}

