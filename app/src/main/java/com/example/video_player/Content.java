package com.example.video_player;

import android.net.Uri;

public class Content {

    private static final String MP4_BUNNY = "file:///android_asset/song_four.mp4";
    private static final String MP4_TOS = "file:///android_asset/song_one.mp4";
    private static final String MP4_COSMOS = "file:///android_asset/song_seven.mp4";

    static final String[] ITEMS = { MP4_TOS, MP4_BUNNY, MP4_COSMOS };

    public static class Media {
        public final int index;
        public final Uri mediaUri;

        public Media(int index, Uri mediaUri) {
            this.index = index;
            this.mediaUri = mediaUri;
        }

        static Media getItem(int index) {
            return new Media(index, Uri.parse(ITEMS[index % ITEMS.length]));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Media)) return false;

            Media media = (Media) o;

            if (index != media.index) return false;
            return mediaUri.equals(media.mediaUri);
        }

        @Override
        public int hashCode() {
            int result = index;
            result = 31 * result + mediaUri.hashCode();
            return result;
        }
    }
}
