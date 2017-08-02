package com.gongxm.bookreader.utils;

import android.widget.ImageView;

import com.gongxm.bookreader.R;

import org.xutils.image.ImageOptions;
import org.xutils.x;

/**
 * Created by gongxm on 2016/8/5.
 */

public class ImageUtils {
    static ImageOptions options = new ImageOptions.Builder().setLoadingDrawableId(R.mipmap.book_cover_default).setFailureDrawableId(R.mipmap.book_cover_default).build();

    /**
     * 使用默认加载图片和加载失败图片
     * @param iv
     * @param url
     */
    public static void loadImage(ImageView iv, String url) {
        x.image().bind(iv, url, options);
    }

    /**
     * 可以指定加载图片和加载失败图片
     * @param iv
     * @param url
     * @param defaultImage
     * @param loadFailureImage
     */
    public static void loadImage(ImageView iv, String url, int defaultImage, int loadFailureImage) {
        ImageOptions opt = new ImageOptions.Builder().setLoadingDrawableId(defaultImage).setFailureDrawableId(loadFailureImage).build();
        x.image().bind(iv, url, opt);
    }

}
