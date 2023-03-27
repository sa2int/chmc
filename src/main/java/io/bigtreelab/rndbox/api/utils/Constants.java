package io.bigtreelab.rndbox.api.utils;

public final class Constants {

	public static final String TIME_ZONE_BASE_STRING = "Asia/Shanghai";

	public static final Long ATTENDANCE_EVENT_ID = 10000L;

	public static final Long LOTTETY_CATEGORY_ID = 10004L; // 제일복권 카테고리 아이디

    public static final String	STRING_BLANK	= " ";
    public static final String	STRING_NO	    = "N";
    public static final String	STRING_YES	    = "Y";
    public static final Integer	INTEGER_ZERO = 0;
    public static final Long	SYSTEM_USER= 99999999L; //시스템유저아이디
    public static final String	USER_ROLE= "ROLE_USER"; //API를 사용하는 APP 유저 권한 
    
	public static final Integer LIMIT_NUMBER_RECOMMEND = 6; // 조회건수 8건

	public static final Integer LIMIT_NUMBER_SPECIAL = 6; // 조회건수 8건

	public static final Integer LIMIT_NUMBER_HOT_PRODUCT = 12; // 조회건수 12건

    public static final String PRODUCT_TYPE_BLINDBOX = "B";

    public static final Integer	EXCLUSIVE_ZONE_DURATION_MINUTES = 3; //3분
    
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final Integer USER_INVENTORY_STORAGE_DAY = 10; // 10일

	public static final Integer TIME_LIMIT_DAYS = 3; // 3일. 시간임박 기준일

	public static final String PRIZE_FIRST_REWARD = "First"; // 제일복권 First 상

	public static final String PRIZE_LAST_REWARD = "Last"; // 제일복권 Last 상

	public static final String PRIZE_W_REWARD = "W"; // 제일복권 W 상

	public static final Long LOTTERY_REWARD_APP_ALARM_ID = 10000L; // 제일복권 인앱 메세지 템플릿 번호

	public static final Long APP_ALARM_ID_COMPLETE_ORDER = 10011L; // 제일복권 인앱 메세지 템플릿 번호

	public static final String APP_ALARM_REWARD_TITLE = "星运赏中奖通知";

	public static final String APP_ALARM_REWARD_MESSAGE = "恭喜您，您在【{displayProductName}】星运赏场次中，获得了{prizeCode}赏{prizeName}，已将物品放入您的“我的物品”内，请您查收，我们将免费为您保管10天哦，物品即将于{storageDate}过期，在此特别提醒您，到期的物品将会被系统自动回收，回收后将转换成相应的星币退回到“我的中心”中，请您尽快处理噢~ ";

	public static final String APP_ALARM_BUYING_TITLE = "系统通知"; // 제일복권 인앱 메세지 템플릿 번호

	public static final String APP_ALARM_BUYING_MESSAGE = "您于{createdDate}成功购买【{displayProductName}】，已经到达“我的物品”内，请您查收，我们将免费为您保管10天哦，物品即将于{storageDate}过期，在此特别提醒您，到期的物品将会被系统自动回收，回收后将转换成相应的星币退回到“我的中心”中，请您尽快处理噢~"; // 제일복권 인앱 메세지 템플릿 번호

	public static final String ALARM_LINK_TITLE_Inventory = "【我的物品】";

	public static final String ALARM_LINK_TITLE_MyPage = "【个人中心】";

	public static final String ALARM_LINK_URL_TYPE_INVENTORY  = "Inventory";

	public static final String ALARM_LINK_URL_TYPE_MYPAGE  = "Mypage";

	public static final String REQUEST_WITHDRAW_IN_INVENTORY = "Request withdraw in inventory";

	public static final String APP_ALARM_NEW_USER_TITLE = "活动通知";

	public static final String APP_ALARM_NEW_USER_CONTENTS = "欢迎您加入星运盒！我们已经把 {message} 赠送给您，您可以在个人中心查询到！";

}
