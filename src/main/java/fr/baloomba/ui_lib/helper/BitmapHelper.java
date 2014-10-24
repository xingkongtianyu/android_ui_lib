package fr.baloomba.ui_lib.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

public class BitmapHelper {

    public static class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
        private final WeakReference<ImageView> mImageViewReference;
        private int data = 0;
        private Activity mActivity;
        private String mResource;

        public BitmapWorkerTask(Activity activity, ImageView imageView, String resource) {
            // Use a WeakReference to ensure the ImageView can be garbage collected
            mImageViewReference = new WeakReference<ImageView>(imageView);
            mActivity = activity;
            mResource = resource;
        }

        // Decode image in background.
        @Override
        protected Bitmap doInBackground(Integer... params) {
            return BitmapFactory.decodeStream(ZipResourceFileHelper.getInputStream(mActivity, mResource));
        }

        // Once complete, see if ImageView is still around and set bitmap.
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (mImageViewReference != null && bitmap != null) {
                final ImageView imageView = mImageViewReference.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }

}
