package model;

public interface Account {

        String getName();
        String getUser();
        String getPass();
        String getEmail();
        String getAddress();
        String getTitle();
        // account type of account
        String getType();

        void setName(String name);
        void setUser(String username);
        void setPass(String password);
        void setEmail(String email);
        void setAddress(String homeAddress);
        void setTitle(String title);

}
