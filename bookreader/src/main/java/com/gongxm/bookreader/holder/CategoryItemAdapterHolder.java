package com.gongxm.bookreader.holder;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.activities.BookDetailActivity;
import com.gongxm.bookreader.bean.Book;
import com.gongxm.bookreader.bean.CategoryListItem;
import com.gongxm.bookreader.utils.AppConstants;
import com.gongxm.bookreader.utils.ImageUtils;
import com.gongxm.bookreader.utils.MainUtils;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/8/21 14:11
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/
public class CategoryItemAdapterHolder extends MyBaseHolder<CategoryListItem.Books> {
    private final ImageView item_iv;
    private final TextView item_title;
    private final TextView item_author;
    private final TextView item_desc;


    public CategoryItemAdapterHolder(View itemView) {
        super(itemView);
        item_iv = (ImageView) itemView.findViewById(R.id.item_iv);
        item_title = (TextView) itemView.findViewById(R.id.item_title);
        item_author = (TextView) itemView.findViewById(R.id.item_author);
        item_desc = (TextView) itemView.findViewById(R.id.item_desc);
    }

    @Override
    public void reflushView() {
        Book book = getData();
        String cover = book.getCover();
        if(!TextUtils.isEmpty(cover)){
            cover= AppConstants.BOOK_COVER_URL+cover;
            ImageUtils.loadImage(item_iv,cover);
        }
        item_title.setText(book.getTitle());
        item_author.setText(book.getAuthor());
        item_desc.setText(book.getShortIntro());
    }

    @Override
    public void onClick(View view) {
        Book book = getData();
        Intent intent=new Intent(MainUtils.getActivity(), BookDetailActivity.class);
        intent.putExtra("bookId", book.get_id());
        MainUtils.getActivity().startActivity(intent);
    }
}
