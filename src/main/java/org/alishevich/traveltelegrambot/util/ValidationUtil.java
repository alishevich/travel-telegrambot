package org.alishevich.traveltelegrambot.util;


import org.alishevich.traveltelegrambot.entity.BaseEntity;
import org.alishevich.traveltelegrambot.exception.IllegalRequestDataException;
import org.alishevich.traveltelegrambot.exception.NotFoundException;

public class ValidationUtil {

    public static <T> T checkNotFoundWithId(T object, int id) {
        checkNotFoundWithId(object != null, id);
        return object;
    }

    public static void checkNotFoundWithId(boolean found, int id) {
        checkNotFound(found, "id=" + id);
    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + msg);
        }
    }

    public static void checkNew(BaseEntity object) {
        if (!object.isNew()) {
            throw new IllegalRequestDataException(object + " must be new (id=null)");
        }
    }

    public static void assureIdConsistent(BaseEntity object, int id) {
        if (object.isNew()) {
            object.setId(id);
        } else if (object.getId() != id) {
            throw new IllegalRequestDataException(object + " must be with id=" + id);
        }
    }
}

