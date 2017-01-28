package com.samistine.school.java3.lab.auth;

import com.samistine.school.java3.lab.UserAccount;
import com.samistine.school.java3.lab.auth.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import javax.persistence.Tuple;

/**
 *
 * @author Samuel
 */
public class Authenticate {

    static class UserPass {
        String username;
        String password;
        UserPass(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    static final List<UserPass> accounts = new ArrayList<>();
    static {
        accounts.add(new UserPass("1", "password"));
        accounts.add(new UserPass("2", "password"));
        accounts.add(new UserPass("3", "password"));
        accounts.add(new UserPass("4", "password"));

    }

    public static Result login(String username, String password) {
        Optional<UserPass> anAccount = accounts.stream().filter((UserPass account) -> {
            return account.username.equals(username) && account.password.equals(password);
        }).findAny();

        if (anAccount.isPresent()) {
            return new ImplResult(true, new UserAccount(username));
        } else {
            return RESULT_FAILURE;
        }
    }

    static final ImplResult RESULT_FAILURE = new ImplResult(false, null);

    static class ImplResult implements Result {
        final boolean success;
        final UserAccount account;
        public ImplResult(boolean success, UserAccount account) {
            this.success = success;
            this.account = account;
        }
        @Override
        public boolean succeeded() {
            return success;
        }
        @Override
        public boolean failed() {
            return !success;
        }
        @Override
        public UserAccount account() {
            return account;
        }
    }

}
