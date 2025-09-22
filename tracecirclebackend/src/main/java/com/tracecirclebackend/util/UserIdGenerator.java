package com.tracecirclebackend.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserIdGenerator implements IdentifierGenerator {

    private static final String PREFIX = "USR-";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        try {
            // Use the field name from UserEntity (id), not userId
            String hql = "SELECT u.id FROM UserEntity u ORDER BY u.id DESC";

            @SuppressWarnings("unchecked")
            List<String> result = session.createQuery(hql).setMaxResults(1).list();

            if (result.isEmpty() || result.get(0) == null) {
                // First ID if no users exist
                return PREFIX + "0001";
            }

            // Extract numeric part and increment
            String lastId = result.get(0);
            int number = Integer.parseInt(lastId.substring(PREFIX.length()));
            number++;

            return String.format(PREFIX + "%04d", number);

        } catch (Exception e) {
            e.printStackTrace();
            // Fallback ID if query fails
            return PREFIX + "0001";
        }
    }
}
