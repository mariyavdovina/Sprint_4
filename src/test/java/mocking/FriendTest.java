package mocking;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FriendTest {

    @Mock // добавь аннотацию
    List<String> list;

    @Test
    public void friendsTest() {
        Friend friend = new Friend(list);// создай объект класса Friend
        Mockito.when(friend.getFriendsCount()).thenReturn(100); // создай стаб
        System.out.print(friend.getFriendsCount());
        Assert.assertEquals(100, friend.getFriendsCount());
    }
}