package split_wise;

import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class User {
    public final Pattern EMAIL_PATTERN_REGEX = Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    private final String id;
    private final String email;

    public User(String email) {
        Objects.requireNonNull(email, "Email can't be null");

        if (!EMAIL_PATTERN_REGEX.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email provided");
        }

        this.id = UUID.randomUUID().toString();
        this.email = email;
    }

    public String getId(){
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        User other = (User) obj;
        return Objects.equals(id, other.id) && Objects.equals(email, other.email);
    }

    @Override
    public int hashCode() {
        int prime = 17;
        int res = 31;

        res = res * prime + (id != null ? id.hashCode() : 0);
        res = res * prime + (email != null ? email.hashCode() : 0);

        return res;
    }

    @Override
    public String toString() {
        return "User{" +
                "EMAIL_PATTERN_REGEX=" + EMAIL_PATTERN_REGEX +
                ", id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}