package giraffe.domain;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Olga Gushchyna
 * @version 0.0.1
 */
@MappedSuperclass
abstract public class GiraffeEntity<T extends GiraffeEntity> implements Serializable {

    @Id
    @Column(nullable = false)
    protected String uuid = UUID.randomUUID().toString();

    @Column(nullable = false)
    protected Long timeCreated = System.currentTimeMillis(); // UTC time

    protected Long timeDeleted; // UTC time

    @Column(nullable = false)
    @Enumerated
    protected Status status = Status.ACTIVE;


    public enum Status {
        DELETED(0), ACTIVE(1);

        private int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public String getUuid() {
        return uuid;
    }

    public Long getTimeCreated() {
        return timeCreated;
    }

    public Long getTimeDeleted() {
        return timeDeleted;
    }

    public T setTimeDeleted(Long timeDeleted) {
        this.timeDeleted = timeDeleted;
        return self();
    }

    public Status getStatus() {
        return status;
    }

    abstract protected T self();

    public T setStatus(Status status) {
        this.status = status;
        return self();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GiraffeEntity)) return false;

        GiraffeEntity<?> that = (GiraffeEntity<?>) o;

        if (!uuid.equals(that.uuid)) return false;
        if (!timeCreated.equals(that.timeCreated)) return false;
        if (timeDeleted != null ? !timeDeleted.equals(that.timeDeleted) : that.timeDeleted != null) return false;

        return status == that.status;
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + timeCreated.hashCode();
        result = 31 * result + (timeDeleted != null ? timeDeleted.hashCode() : 0);
        result = 31 * result + status.hashCode();
        return result;
    }

}
