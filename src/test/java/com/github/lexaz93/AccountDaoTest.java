package com.github.lexaz93;

import com.github.lexaz93.dao.AccountDao;
import com.github.lexaz93.model.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.lexaz93.dao.AccountDaoImpl.getInstance;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@DisplayName("DAO имеет:")
public class AccountDaoTest {
    private final AccountDao dao = getInstance();
    private final Account user = mock(Account.class);


    @Test
    @DisplayName("корректный метод readAll();")
    public void shouldHaveCorrectMethodReadAll() {
        assertEquals(dao.readAll().size(), 4);
    }

    @Test
    @DisplayName("корректный метод read();")
    public void shouldHaveCorrectMethodRead() {
        Account alex = new Account("alex", "qwer", "алексей", "путов", 19);

        assertEquals(dao.read("Alex"), alex);
    }

    @Test
    @DisplayName("корректный метод create();")
    public void shouldHaveCorrectMethodCreate() {
        Account masha = new Account("masha", "qwer", "маша", "безымяная", 36);

        dao.create(masha);
        dao.create(user);

        assertEquals(dao.readAll().size(), 6);
    }

    @Test
    @DisplayName("корректный метод update();")
    public void shouldHaveCorrectMethodUpdate() {
        Account alex = new Account("alex", "0987", "алекс", "шпутов", 18);

        dao.updatePassword(alex);

        assertEquals(dao.read("alex").getPassword(), "0987");
        assertEquals(dao.read("alex").getFirstName(), "алекс");
        assertEquals(dao.read("alex").getLastName(), "шпутов");
        assertEquals(dao.read("alex").getAge(), 18);
    }

    @Test
    @DisplayName("корректный метод delete();")
    public void shouldHaveCorrectMethodDelete() {
        Account alex = new Account("alex", "qwer", "алексей", "путов", 19);

        dao.delete(alex);

        assertEquals(dao.readAll().size(), 3);
    }
}
