package by.pvt.onlinestore.core.dto.user;

import by.pvt.onlinestore.core.domain.Role;

import java.util.Objects;

public class UserResponseDTO {
    private Long id;
    private String name;
    private String surname;
    private String login;
    private String fullName;
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponseDTO that = (UserResponseDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(login, that.login) && Objects.equals(fullName, that.fullName) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, login, fullName, role);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserResponseDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
