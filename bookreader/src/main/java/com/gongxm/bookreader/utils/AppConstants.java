package com.gongxm.bookreader.utils;

/**
 * Created by gongxm on 2016/7/19.
 */

public class AppConstants {

//	public static final String BASE_URL="http://gongxm.jd-app.com";//主域名
//	public static final String MENU_URL=BASE_URL+"/servlet/getMenus"; //菜单地址
//	public static final String LIST_URL=BASE_URL+"/servlet/AppGetImgList";//图片组列表地址
//	public static final String USER_INFO_URL=BASE_URL+"/servlet/UploadUserInfo";//记录用户信息的地址

        /*****调试使用*****/
//	public static String BASE_URL="http://192.168.173.1:8080/photosite";//主域名

        //通用编码
        public static final String ENCODING="UTF-8";

        //返回码
        public static final String SUCCESS="0";
        public static final String FAIL="1";

        public static final String USER_INFO_URL = null;//上传用户信息接口


        public static final int LIMIT_COUNT=50;//每次加载书籍信息最大数量

        //网络请求接口
        public static final String RANK_URL="http://api.zhuishushenqi.com/recommend/footer/book";//推荐

        public static final String CATEGORY_URL = "http://api.zhuishushenqi.com/cats/lv2/statistics";//分类信息

        //书籍分类列表
        public static final String CATEGORY_ITEM_URL = "http://api.zhuishushenqi.com/book/by-categories?gender=genderType&type=typeName&major=category&minor=&start=startIndex&limit=limitCount";
        //书籍详细信息
        public static final String BOOK_DETAIL_URL = "http://api.zhuishushenqi.com/book/";

        //封面加载链接
        public static final String BOOK_COVER_URL = "http://statics.zhuishushenqi.com";
        //搜索接口
        public static final String BOOK_SEARCH_URL = "http://api.zhuishushenqi.com/book/fuzzy-search?query=";

        //周榜
        public static final String BOOK_WEEK_URL = "http://api.zhuishushenqi.com/ranking/54d42d92321052167dfb75e3";

       // 月榜:
       public static final String BOOK_MONTH_URL = "http://api.zhuishushenqi.com/ranking/564d820bc319238a644fb408";

       // 总榜:
       public static final String BOOK_TOTAL_URL = "http://api.zhuishushenqi.com/ranking/564d8494fe996c25652644d2";

        //获取书籍网站所有来源:
        public static final String BOOK_SRC_URL = "http://api.zhuishushenqi.com/ctoc?view=summary&book=";

        //获取书籍网站所有来源:
        public static final String BOOK_CHAPTER_URL = "http://api.zhuishushenqi.com/ctoc/id?view=chapters";


}
