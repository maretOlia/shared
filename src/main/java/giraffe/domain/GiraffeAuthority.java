package giraffe.domain;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Olga Gushchyna
 * @version 0.0.1
 */
@Entity
@Table(name = "authority")
public class GiraffeAuthority extends GiraffeEntity<GiraffeAuthority> implements GrantedAuthority {

    @Column(nullable = false)
    @Enumerated
    private Role role;

    @ManyToMany
    private Set<User> users = Sets.newHashSet();

    public GiraffeAuthority() {
    }

    @Override
    public GiraffeAuthority self() {
        return this;
    }


    @Override
    public String getAuthority() {
        return role.getValue();
    }

    public Role getRole() {
        return role;
    }

    public GiraffeAuthority setRole(Role role) {
        this.role = role;
        return this;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GiraffeAuthority)) return false;
        if (!super.equals(o)) return false;

        GiraffeAuthority that = (GiraffeAuthority) o;

        return role == that.role;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    public enum Role {
        ADMIN("ROLE_ADMIN"), USER("ROLE_USER"), ANONIMOUS("ROLE_ANONYMOUS");

        private String value;

        Role(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
