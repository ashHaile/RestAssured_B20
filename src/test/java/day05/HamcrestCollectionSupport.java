package day05;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestCollectionSupport {
    @Test
    public void testList() {
        List<Integer> numList = Arrays.asList(4, 6, 7, 9, 5, 88, 90);

        // use hamcrest matcher to test the size of this list
        assertThat(numList, hasSize(7));

        // assert that this list contain 9
        // numList.contains(9);  // this how e do in java

        assertThat(numList,hasItem(9));

        // assert that this list contains 9, 88

        assertThat(numList,hasItems(9,88));

        // assert that everyItems is list are more than 3
        // lambdaExpression : p->p>3 // this is how we do it in plan JAVA

        assertThat(numList,everyItem(greaterThan(3)));

        assertThat(numList,everyItem( is(greaterThan(3) ) ) ); //or we can do it this was

        List<String> allNames  = Arrays.asList("Rory Hogan", "Mariana","Olivia","Gulbadan","Ayxamgul","Kareem","Virginia","Tahir Zohra") ;
        assertThat(allNames , hasSize(8) );
        assertThat(allNames, hasItems("Virginia", "Ayxamgul", "Rory Hogan") );
        // check every items has letter has a
        assertThat(allNames , everyItem(   containsString("a")   )     );

        assertThat(allNames, everyItem(startsWith("a")));
        assertThat(allNames, everyItem(endsWith("a")));



    }
}