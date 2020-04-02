package com.tuts.prakash.retrofittutorial.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.tuts.prakash.retrofittutorial.R;
import com.tuts.prakash.retrofittutorial.model.RetroPhoto;

import java.util.List;

public class PhotoAdapter extends BaseQuickAdapter<RetroPhoto, BaseViewHolder> {
    private Context mContext;

    public PhotoAdapter(int layoutResId, List<RetroPhoto> data, Context context) {
        super(layoutResId, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, RetroPhoto retroPhoto) {
        baseViewHolder.setText(R.id.title, retroPhoto.getTitle());
        Picasso.Builder builder = new Picasso.Builder(mContext);
        builder.downloader(new OkHttp3Downloader(mContext));
        builder.build().load(retroPhoto.getThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into((ImageView) baseViewHolder.getView(R.id.coverImage));
    }
}
