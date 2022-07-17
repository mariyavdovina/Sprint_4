package mocking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class ArrayListTest {

    @Mock
    ArrayList<String> list;

    @Test
    public void test() {
        list.add("1");
        list.add("2");
        list.add("3");
        Mockito.verify(list,Mockito.times(3)).add(Mockito.any());
    }
}