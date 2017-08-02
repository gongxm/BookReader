package com.gongxm.bookreader.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

/**
 *=============================
 *
 * 版本：1.0
 *
 * 作者：gongxm
 *
 * 时间：2015-1-16 下午5:43:10
 *
 * 修正：
 *
 * 版权所有：gongxm
 *
 * 描述：
 * 		网络工具，判断网络状态
 *=============================
 */

public class NetUtils {

    /**
     * 判断是否连接网络
     * @param context
     * @return
     */
    public static boolean isConnected(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        return networkInfo!=null&&networkInfo.isConnected();
    }

	/*	46000 中国移动 (GSM)
		46001 中国联通 (GSM)
		46002 中国移动 (TD-S)
		46007 中国移动 (TD-S)
		46003 中国电信(CDMA)
		46005 中国电信 (CDMA)
		46006 中国联通 (WCDMA)
		46010 联通Femto家庭基站
		46011 中国电信 (FDD-LTE)
		46020 铁通GSM-R
		46060 移动TD家庭基站
	 */

    /**
     * 根据服务代码判断运营商
     * @param operator
     * @return
     */
    public static String getOperator(String operator){
        if(TextUtils.isEmpty(operator)){
            return "未知运营商";
        }
        else if(operator.equals("46000")){
            return "中国移动 (GSM)";
        }else if(operator.equals("46001")){
            return "中国联通 (GSM)";
        }else if(operator.equals("46002")||operator.equals("46007")){
            return "中国移动 (TD-S)";
        }else if(operator.equals("46003")||operator.equals("46005")){
            return "中国电信(CDMA)";
        }else if(operator.equals("46006")){
            return " 中国联通 (WCDMA)";
        }else if(operator.equals("46010")){
            return "联通Femto家庭基站";
        }else if(operator.equals("46011")){
            return "中国电信 (FDD-LTE)";
        }else if(operator.equals("46020")){
            return "铁通(GSM-R)";
        }else if(operator.equals("46060")){
            return "移动TD家庭基站";
        }
        return "未知运营商";
    }
}
