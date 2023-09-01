package config;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import lombok.extern.slf4j.Slf4j;

/**
 * The type Entity audit listener.
 */
@Slf4j
public class EntityAuditListener {

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyOperation(Object object) {
        log.info(object.toString());
    }
}
