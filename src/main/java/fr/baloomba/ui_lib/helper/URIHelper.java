package fr.baloomba.ui_lib.helper;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.FileNotFoundException;

public class URIHelper {

    public static Bitmap getBitmapFromUri(Activity activity, Uri uri) {
        Bitmap orgImage = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(activity.getApplicationContext().getContentResolver()
                    .openInputStream(uri), null, options);
            int minValue = (options.outHeight <= options.outWidth) ? options.outHeight :
                    options.outWidth;
            options = new BitmapFactory.Options();
            options.inSampleSize = 1;
            for (;((minValue / (options.inSampleSize + 1)) > 524);) {
                options.inSampleSize += 1;
            }
            options.inJustDecodeBounds = false;
            options.inPurgeable = true;
            orgImage = BitmapFactory.decodeStream(activity.getApplicationContext()
                    .getContentResolver().openInputStream(uri), null, options);
        } catch (FileNotFoundException e) {
            LogHelper.log(LogHelper.ERROR, e.getMessage());
        }
        return orgImage;
    }

    public static String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = { MediaStore.Images.Media.DATA };
            cursor = context.getContentResolver().query(contentUri,  proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

}
