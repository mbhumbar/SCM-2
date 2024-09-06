package com.mbinfotechworld.SCM_2.helpers;

public class ResourcesNotFoundException extends RuntimeException {

    public ResourcesNotFoundException(String message) {
        super(message);
    }

    public ResourcesNotFoundException() {
        super("resourece not found");
    }

}
