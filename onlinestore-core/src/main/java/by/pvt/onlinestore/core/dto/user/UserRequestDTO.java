package by.pvt.onlinestore.core.dto.user;

import by.pvt.onlinestore.core.domain.Role;

import java.util.Objects;

public class UserRequestDTO {
    private String name;
    private String surname;
    private String login;
    private String password;
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRequestDTO that = (UserRequestDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(login, that.login) && Objects.equals(password, that.password) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, login, password, role);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserRequestDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
