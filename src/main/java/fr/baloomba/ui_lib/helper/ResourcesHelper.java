package fr.baloomba.ui_lib.helper;

import android.app.Application;

public class ResourcesHelper {

    public static int getDrawableResource(Application application, String name) {
        return application.getResources().getIdentifier(name, "drawable",
                application.getPackageName());
    }

}
