package main.test;

import main.User;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

class UserTest {
    @Test
    void add() {
        Bag<User> hashBag = new HashBag<>();
        User user = new User("Igor", 32);
        hashBag.add(user);
        assertThat(hashBag, hasItem(user));
    }

    @Test
    void addAll() {
        Bag<User> hashBag = new HashBag<>();
        List<User> list = new ArrayList<>();
        User user = new User("Slava", 35);
        User user1 = new User("Sergei", 35);
        list.add(user1);
        list.add(user);
        hashBag.addAll(list);
        assertThat(hashBag, hasItems(user, user1));
    }

    @Test
    void remove() {
        Bag<User> usersBag = new HashBag<>();
        User user = new User("Andrei", 35);
        usersBag.add(user);
        usersBag.remove(user);
        assertThat(usersBag, empty());
    }

    @Test
    void removeAll() {
        Bag<User> hashBag = new HashBag<>();
        List<User> list = new ArrayList<>();
        User user = new User("Vasya", 35);
        User user1 = new User("Vladimir", 35);
        list.add(user1);
        list.add(user);
        hashBag.removeAll(list);
        assertThat(hashBag.isEmpty(), is(true));
    }

    @Test
    void checkSize() {
        HashBag<User> userHashBag = new HashBag<>();
        User user = new User("Sasha", 23);
        userHashBag.add(user);
        assertThat(userHashBag, hasSize(1));
    }

    @Test
    void contains() {
        HashBag<User> userHashBag = new HashBag<>();
        User user = new User("Egor", 23);
        assertThat(userHashBag.contains(user), is(false));
    }

    @Test
    void equals() {
        HashBag<User> userHashBag = new HashBag<>();
        User user = new User("Andrei", 23);
        userHashBag.add(user);
        assertThat(userHashBag.equals(user), is(false));
    }

    @Test
    void toArray() {
        User user = new User("Volodya", 33);
        HashBag<User> hashBag = new HashBag<>();
        hashBag.add(user);
        List<User> users = new ArrayList<>();
        users.addAll(hashBag);
        Object[] lists = users.toArray();
        assertThat(lists, hasItemInArray(user));
    }

    @Test
    void retainAll() {
        User user1 = new User("Alex", 33);
        User user2 = new User("Petya", 33);
        User user3 = new User("Gosha", 33);
        HashBag<User> hashBag = new HashBag<>();
        List<User> list = new ArrayList<>();
        hashBag.add(user1);
        hashBag.add(user3);
        list.add(user3);
        list.add(user1);
        list.add(user2);
        list.retainAll(hashBag);
        assertThat(list, is(not(hasItem(user2))));

    }

    @Test
    void objectToString() {
        User user = new User("Vitya", 15);
        Bag<User> hashBag = new HashBag<>();
        hashBag.add(user);
        String convertToString = hashBag.toString();
        assertThat(convertToString, isA(String.class));

    }

    @Test
    void clear() {
        User user = new User("Alexey", 15);
        Bag<User> hashBag = new HashBag<>();
        hashBag.add(user);
        hashBag.clear();
        assertThat(hashBag, emptyIterable());
    }

    @Test
    void iterator() {
        Bag<User> hashBag = new HashBag<>();
        User user = new User("Olga", 20);
        hashBag.add(user);
        Iterator<User> iterator = hashBag.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        assertThat(hashBag, hasSize(0));
    }

    @Test
    void secondIterator() {
        User user = new User("Boris", 26);
        Bag<User> hashBag = new HashBag<>();
        hashBag.add(user);
        Iterator<User> iterator = hashBag.iterator();
        iterator.hasNext();
        assertThat(hashBag, is(not(empty())));
    }
}
