package com.point18.slg2d.common.constg

import com.point18.slg2d.lang.EnumConverter
import com.point18.slg2d.lang.buildValueMap

/**
 * 游戏中使用的错误码
 */
enum class ResultCode(val code: Int, val rtMsg: String) {

    UNKOWN_ERROR(-1, "未知错误"), // 注意，这个是无法解析错误码时才使用的默认值。正常逻辑中不要出现这个错误码

    SUCCESS(1, "成功"),
    PARAMETER_ERROR(2, "传递的参数不正确(用于协议内容错误,刷包协议)"),
    PARAMETER_CANT_PARSE_JSON(3, "传递的参数无法按照json解析"),

    NAME_LONG(4, "角色名太长"),
    OFFLINE(5, "对方不在线"),
    UNLAWFUL_NAME(6, "名字不合法"),
    GAG_TIME(7, "禁言中"),
    BE_BANNED(8, "封禁中"),
    IP_NONENTITY(9, "帐号不存在"),
    KEYWORDS(10, "关键词不允许"),

    // 通讯
    NO_XML_PROTO(11, "XML不存在模板"),
    NAME_NIL(12, "名字长度不够"),
    NAME_NONENTITY(13, "名字不存在"),
    IN_BLACK(14, "对方正在黑名单中，不能聊天"),
    USE_NAME(15, "名字已经被使用"),
    MSG_TYPE_ERROR(16, "无法从消息中解析出消息号"),
    NO_FRIEND_NOT_CHAT(17, "不是好友无法发送消息"),
    NO_PLAYER(18, "玩家不存在"),
    NO_PLAYER_BASIC_INFO_ERROR(19, "缺失玩家基本数据"),
    PLAYER_BUSY_ERROR(20, "玩家繁忙中"),

    // kafka连接
    GET_CONNECTION_FAILED(21, "连接无效"),

    CONN_ERR_FOR_DUANXIANCHONGLIAN(22, "断线重连失败，原因顶号冷却"),
    IN_OTHER_BLACK(23, "被对方拉黑了.无法发送消息给他"),

    ROUTINE_IS_RUN(25, "游戏区未关闭，无法执行此操作"),
    NO_FIND_DB_NAME(26, "未找到该删除的数据库名"),
    LONG_CONN_ERROR(27, "远程连接无法访问"),
    NO_FIND_TARGET_AREA_CONFIG(28, "找不到目标区对应的配置"),
    CANT_GET_DB_CONNECTION(29, "拿不到数据库连接"),


    // 登录
    SERVER_PLAYER_FULL(30, "所有服务器都达到人数上限"),
    HAS_NOT_LOGIN(31, "尚未登录"),
    ERROR_ACC_PWD(32, "错误的账号密码"),
    HAS_NOT_ENTER_GAME(33, "尚未进入游戏"),
    SIGN_ERROR(34, "登录令牌签名错误"),
    NAME_HAS_SPACE(35, "名称不能含有空格"),
    NAME_LENGTH_EXCEED(36, "名称超过规定长度"),
    NO_SIGN_KEY(37, "没有找到匹配的密钥"),
    SERVER_MAX_PLAYER(38, "服务器人数已满"),
    SESSION_NOT_FOUND(39, "登陆后找不到session"),
    NO_VALID_SERVER(40, "根据节点号找不到可用服务器"),
    NO_VALID_SERVER_BY_WORLDID(41, "根据客户端指定的世界ID找不到可用服务器"),
    // 创建城池

    CASTLE_DONT_EXISTED(42, "城池不存在"),
    NO_VALID_BORN_POS(43, "找不到可用的出生点"),
    NO_CITY_EXTEND(44, "扩建次数不足"),
    EXTEND_BEFORE(45, "该位置已经被扩建"),

    // 黑白名单提示
    BLACK_ROSTER(46, "用户在黑名单中"),
    WHITE_ROSTER(47, "服务器维护中，用户不在白名单中"),
    SERVER_OVER(48, "服务器关闭"),
    NOT_BORN_STATE_ERROR(49, "该州暂不支持出生"),

    // sdk相关 51-69
    USER_HAS_BAND_ERROR(51, "用户已经绑定过了"),
    CLINET_BIND_DEVICE_ERROR(52, "不可以通过该接口进行设备绑定"),
    NO_FIND_MOVE_SERVER_USER(53, "迁服的时候找不到玩家数据行"),
    BIND_ONSUCCESS_ERROR(54, "绑定账号返回了消息但是有错误"),
    BIND_ONFAILURE_ERROR(55, "绑定账号执行了onFailure"),
    BIND_NO_FIND_USER_ERROR(56, "绑定账号时找不到玩家在登录服上的数据"),
    BIND_TARGET_USER_ERROR(57, "要绑定到的第三方账号下已有角色"),
    QUICK_LOGIN_ERROR(58, "快速登录异常"),
    QUICK_LOGIN_TOKEN_ERROR(59, "快速登录令牌失效"),
    NO_FIND_MOVE_SERVER_USER_OLD_WORLD_INFO(60, "迁服的时候找不到玩家所在老区数据"),
    NO_MOVE_SERVER_TIME(61, "未到迁服时间"),
    CASTLE_BE_CLEAR_ERROR(62, "城池被清理"),
    LINE_UP_TOKEN_ERROR(63, "排队令牌检测失败"),
    EXIST_MOVE_SERVER_USER_NEW_WORLD_INFO(64, "迁服的时候玩家所在系统在新区已有数据"),
    LINE_UP_TOKEN_TIMEOUT_ERROR(65, "排队令牌已过期"),
    LINE_UP_TOKEN_TOLONG_ERROR(66, "排队令牌通过时间转型失败"),
    QUICK_LOGIN_PLAYER_NULL(67, "快速登录找不到玩家"),
    BIND_NOT_FOUND_ERROR(68, "该账号并未绑定目标平台"),
    BIND_OTHER_OPEN_ID_ERROR(69, "该账号绑定了目标平台的其它账号"),

    IS_IN_BLACK(70, "玩家已经在黑名单列表中"),
    ISNOT_BLACKPLAYER(71, "该玩家不在黑名单列表"),
    FRIEND_NO_BLACK(72, "好友不能加入黑名单"),
    IS_IN_OTHER_BLACK(73, "您已被对方拉入黑名单"),

    // 更换头像
    PHOTO_HERO_PROTO_ID_NOT_EXISTS(81, "背包中没有该武将卡"),
    PHOTO_HERO_PROTO_IS_EXPIRE(82, "当前头像已经是这个武将卡"),
    PHOTO_ID_LENGTH_EXCEED(83, "无法处理'玩家头像'参数"),
    PHOTO_NO_EXISTS(84, "头像不存在"),
    CHOOSE_LORD_ERROR(85, "不可以重复挑选领主"),
    PHOTO_IN_USE_ERROR(86, "头像在使用中"),
    PHOTO_EXISTS(87, "头像已经存在"),
    PICTURE_URL_BLANK(88, "头像url空"),

    // 好友
    OVER_MORE_LENGTH(89, "组名长度不符"),
    NO_MORE_FRIEND(90, "好友数量已达上限"),
    IS_FRIEND(91, "该玩家已存在好友列表中"),
    NOT_FRIEND(92, "该玩家不在你的好友列表中"),
    GROUP_NUM_MORE(93, "联系人分组数量已达上限"),
    NOT_FRIEND_GROUP(94, "该好友分组不存在"),
    IN_GROUP(95, "好友已经在聊天组中了"),
    GROUP_NO_MEMBER(96, "该群成员超出上限"),
    MAKE_FRIEND_ERR(97, "不能加自己为好友"),
    WAIT_TALK(98, "发言CD冷却中，稍后再试"),
    OTHER_HAVE_APPLY(99, "对方已申请加你好友，只需要同意"),
    CHECK_WORD_ERR(100, "含有非法屏蔽字"),
    APPLY_FRIEND_NOT_OPEN(101, "对方好友功能未开启"),
    APPLY_NO_MORE_FRIEND(102, "对方好友已满"),

    // 玩家名字检测 110 - 120
    PLAYER_NAME_ERROR(110, "玩家名字不合法"),
    PLAYER_NAME_IS_EXIST(111, "该名字已经被使用"),

    // 聊天相关 121-135
    NO_CHAT_ROOM(121, "未找到对应聊天室"),
    NO_AT_ROOM(122, "玩家不在当前聊天室"),
    HAVE_ROOM(123, "这个人已经在这个聊天室了"),
    ROOM_FULL(124, "群满人了"),
    OWNER_CAN_NOT_QUIT(125, "群主不能退群"),
    SAME_ROOM_NAME(126, "聊天群名相同"),
    NO_MORE_ROOM(127, "聊天群超出数量限制"),
    IN_HIS_BLACK_LIST(128, "在对方的黑名单中"),
    TARGET_NO_MORE_ROOM(129, "邀请目标聊天室已满"),
    NO_CHAT_PLAYER(130, "未找到对应的聊天玩家"),
    CHAT_COUNT_LIMIT(131, "聊天次数限制"),
    QUERY_CHAT_ERROR(132, "查询聊天异常"),
    WORLD_CHAT_MAX_ERROR(133, "世界聊天次数超出秒限制"),

    // 关系
    PLAYER_RELATION_FULL(150, "玩家关系数量已达上限"),
    ALLIANCE_RELATION_FULL(151, "联盟关系已达上限"),
    RELATION_NOT_EXIST(152, "关系不存在"),
    RELATION_EXIST(153, "关系已存在"),

    // 武将
    NO_HERO(200, "武将不存在"),
    HERO_IN_FORCE(201, "相同模板的武将已经在某部队中上阵"),
    NO_PROTO_HERO(202, "当前没有正在上阵的此武将模板"),
    HERO_POS_STATE_ERROR(203, "英雄状态不适用于进行当前操作"),
    HERO_AWAKE_ALREADY_MAX(211, "已经升到满阶"),
    HERO_AWAKE_UP_ING(212, "武将正在升阶中"),
    HERO_AWAKE_UP_LV_TOO_LOW(218, "英雄升阶时等级不够"),
    HERO_TRY_GET_REPEAT(219, "尝试获得已有的英雄"),
    HERO_SLG_SKILL_MAX_LEVEL(220, "该技能已经升到满级,不可以在升级"),
    HERO_NOT_MANUAL_SKILL_LV_UP(221, "该武将不可手动升级"),
    HERO_SKILL_LV_ACHIEVE_AWAKE_LIMIT(222, "技能等级已到达当前阶段上限"),

    HERO_AWAKE_SKILL_NO_UPGRADE(236, "英雄觉醒技能无法升级"),
    HERO_SLG_SKILL_LEVEL_MAX(237, "英雄slg技能已经满级"),
    HERO_UP_LACK_BUILDING(238, "英雄升级前置建筑等级不足"),
    HERO_BREAK_FAIL_OF_LEVEL(240, "英雄等级不足无法突破"),
    HERO_UP_FAIL_OF_BREAK(241, "英雄等级达到突破等级限制上限"),

    // 英雄料理食堂烹饪
    COOKING_QUEUE_NOT_FOUND(250, "找不到烹饪队列"),
    COOKING_BUSY(251, "已有烹饪队列"),
    COOKING_QUEUE_END(252, "烹饪队列已结束"),
    COOKING_QUEUE_NONE_FINISH(253, "烹饪队列暂无可领取食物"),
    COOKING_PRE_EFFECT_LACK(254, "餐桌未解锁"),
    COOKING_QUEUE_DISCARD_ITEM_NUM_OVERFLOW(255, "烹饪队列撤销料理数量溢出"),

    // 偷菜 300-320
    CABBAGE_FIELD_BUSY(300, "偷菜菜地繁忙无法种植"),
    CABBAGE_FIELD_FREE(301, "偷菜菜地尚未种植"),
    CABBAGE_ROLL_BUSY(302, "偷菜摇人CD未到"),
    CABBAGE_VIEW_DENY(303, "偷菜不能查看没摇到的人"),
    CABBAGE_STOLEN_DENY(304, "偷菜不能偷没摇到的人"),
    CABBAGE_STOLEN_ALREADY(305, "偷菜该地块已经投过了"),
    CABBAGE_STOLEN_CHANCE_LACK(306, "偷菜偷窃次数不足"),
    CABBAGE_ACTIVITY_NOT_OPEN(307, "偷菜不在活动期间"),
    CABBAGE_VIEW_DENY_CROSS_WORLD(308, "偷菜不能跨区查看玩家菜园"),
    CABBAGE_RARE_IS_NOT_OPEN(309, "偷菜高级奖励模块未开启"),

    MAP_PROTO_NOT_EXIST(506, "地图模板不存在"),
    HERO_STAR_NO_MAX(513, "英雄星数未满"),
    HERO_EXIST(514, "英雄已存在"),
    HERO_EXIST_REQUIRE_BEFORE_EXG_FRAGMENT(515, "无法兑换未招募的英雄的英雄碎片"),
    HERO_STAR_UP_FAIL_SELF_LACK(516, "英雄升星自身碎片不够"),
    HERO_QUALITY_ALREADY_MAX(517, "英雄品质已经最高级"),
    HERO_QUALITY_BLOCK_BY_LEVEL(518, "英雄升品质时等级不足"),
    HERO_QUALITY_UP_SELF_PROP_LACK(519, "英雄升品时自身碎片不足"),
    HERO_QUALITY_UP_OTH_PROP_LACK(520, "英雄升品时其他碎片不足"),
    HERO_QUALITY_UP_PROP_INVALID(521, "英雄升品时其他碎片品质不符合要求"),
    HERO_FRAG_EXCHANGE_DENY(522, "当前英雄无法使用万能碎片兑换自身碎片"),

    // 交易
    SAME_RESOURCE_TYPE(650, "同种资源类型 无法交易"),
    MORE_MAX(651, "超出资源上限"),
    LESS_RESOUCE(652, "资源不足"),
    RES_ERROR(653, "资源错误"),
    RES_QUICK_BUY_ERROR(654, "资源不支持快速购买"),

    // 部队数据错误
    NO_HERO_IN_FORCE_ERROR(670, "部队中无英雄"),
    HAVE_HERO_IN_FORCE_ERROR(671, "部队中有英雄"),
    HERO_IN_FORCE_OUT_OF_RANGE_ERROR(672, "英雄超出上限"),
    NO_SOLIDER_IN_FORCE_ERROR(673, "部队中无士兵"),
    HAVE_SOLIDER_IN_FORCE_ERROR(674, "部队中有士兵"),
    SOLIDER_IN_FORCE_OUT_OF_RANGE_ERROR(675, "士兵超出上限"),
    NO_ENOUGH_SOLIDER_IN_BARRACK_ERROR(676, "兵营中无足够的士兵"),


    // 标记
    MARK_NOT_ADD(701, "无法添加标记，标记已存在"),
    MARK_NOT_DEL(702, "无法删除标记，标记不存在"),
    MARK_ERR(703, "标记错误"),
    MARK_NUM_EXCEED(704, "标记数目已达上限"),

    // 竞技场
    JJC_FORCE_GRID_NOT_EXIST(740, "尚未配置的布阵"),
    JJC_FORCE_GRID_NO_HERO(741, "无效的武将卡"),
    JJC_FORCE_GRID_REPEAT_HERO(742, "武将重复上阵"),
    JJC_FORCE_GRID_REPEAT_FORCE(743, "部队重复配置"),
    JJC_FORCE_GRID_PLAN_NAME_ERROR(744, "布阵名称不合法"),
    JJC_FORCE_GRID_PLAN_NAME_NOT_ENOUGH(745, "布阵名称长度不足"),
    JJC_FORCE_GRID_PLAN_NAME_EXCEED(746, "布阵名称长度超过规定字数限制"),
    JJC_FORCE_GRID_PLAN_NUM_EXCEED(747, "布阵数量超过上限"),
    JJC_FORCE_GRID_FORCE_NUM_EXCEED(748, "部队数量超过上限"),
    JJC_FORCE_GRID_DEFENSE_FORCE_EXCEED(749, "防守布阵至少设置一个大营"),
    JJC_REWARD_ALREADY_DRAW(750, "奖励已经领取"),
    JJC_REWARD_MAX_RANK_FORBIDDEN(751, "最高排名条件不足"),
    JJC_REWARD_SCORE_FORBIDDEN(752, "积分条件不足"),
    JJC_REWARD_DIFFERENCE(753, "不是相同类型的奖励"),
    JJC_SHOP_BUY_HISTORY_FORBIDDEN(754, "无法购买的历史赛季商品"),
    JJC_SHOP_BUY_NOW_FORBIDDEN(755, "不能重复购买的商品"),
    JJC_SHOP_BUY_NOW_NOT_FOUND(756, "商店中没有这个商品"),
    JJC_WORLD_INFO_NOT_FOUND(757, "世界的竞技场信息找不到"),
    JJC_FIGHT_CD(760, "处于挑战CD中"),
    JJC_FIGHT_ERROR_NO_FIND_DEF_PLAYER(761, "挑战对手已经变化请刷新"),
    JJC_FIGHT_ERROR_NO_FIGHT_NUM(762, "挑战次数不足"),
    JJC_FIGHT_ERROR_ENOUGH_FIGHT_NUM(763, "挑战次数充足,无需购买"),
    JJC_FIGHT_ERROR_NO_CD(764, "当前不处于挑战CD中,无法清除"),
    JJC_SHOP_SQL_NOT_EXIST(765, "竞技场商店记录不存在"),
    JJC_SHOP_ITEM_NO_EXIST(766, "竞技场商店没有这个项目"),
    JJC_REWARD_ITEM_GOT(767, "竞技场已经领取过没有这个项目"),
    JJC_REFRESH_CHALLENGE_TOO_FAST(768, "刷新竞技场挑战对手频率太快"),
    JJC_FIGHT_TIME_OUT(769, "竞技场战斗超时"),
    JJC_FIGHT_NO_PLAN(770, "完成首次推图解锁竞技场"),
    JJC_FIGHT_TIME_OUT_A(771, "战斗超时,消息废弃"),

    // 联盟随机商店
    ALLIANCE_RANDOM_SHOP_DENY(780, "联盟随机商店需要在联盟中才能购买"),
    ALLIANCE_RANDOM_SHOP_EXPIRE(781, "联盟随机商店信息过期"),
    ALLIANCE_RANDOM_SHOP_LIMIT_ARRIVE(782, "联盟随机商店限购次数已满"),
    ALLIANCE_RANDOM_SHOP_GRID_NOT_FOUND(783, "联盟随机商店格子不存在"),
    ALLIANCE_RANDOM_SHOP_COUNT_INVALID(784, "联盟随机商店购买数量无效"),
    ALLIANCE_RANDOM_SHOP_LIMIT_OVERFLOW(785, "联盟随机商店超出限购次数"),

    // 联盟
    ALLIANCE_ARGS_ERROR(800, "服务端接收到的参数不正确（参数个数不正确或必须项为空）"),
    ALLIANCE_NAME_ALREADY_EXISTED(801, "联盟名称已存在"),
    ALLIANCE_IDIP_CHANGE_WORD_ERROR(802, "联盟当前状态不允许修改文字信息"),
    ALLIANCE_IDIP_CLEAR_ACCOUNT_ERROR_BY_HAVE_ALLIANCE(803, "请先退出联盟再申请账号注销)"),
    ALLIANCE_IDIP_CLEAR_ACCOUNT_ERROR_BY_ALLIANCE_APPLY(804, "请先取消联盟申请再申请账号注销"),

    ALLIANCE_PLAYER_HAS_ALLIANCE(806, "玩家已加入联盟"),
    ALLIANCE_REQ_ALREADY_EXIST(807, "已申请加入该联盟"),
    ALLIANCE_POWER_NOT_ENOUGH(808, "战斗力未达到对方联盟要求"),
    ALLIANCE_SHORT_NAME_NOT_ALLOWED(810, "联盟简称不合法"),
    ALLIANCE_SHORT_NAME_ALREADY_EXIST(811, "联盟简称已存在"),
    ALLIANCE_NAME_LENGTH_NOT_ENOUGH(812, "联盟名称长度不足"),
    ALLIANCE_SHORT_NAME_NOT_ENOUGH(813, "联盟简称长度不足"),
    ALLIANCE_PLAYERS_EXCEED(814, "联盟人数已经达到招收人数上限"),
    ALLIANCE_NAME_ERROR(815, "联盟名称不合法"),
    ALLIANCE_NAME_LENGTH_EXCEED(816, "联盟名称超过规定字数限制"),
    ALLIANCE_DESCRIPTION_LENGTH_EXCEED(817, "联盟公告超过规定字数限制"),
    ALLIANCE_MARK_TITLE_LENGTH_EXCEED(818, "标题超过规定字数限制"),
    ALLIANCE_MARK_DESCRIPTION_LENGTH_EXCEED(819, "内容超过规定字数限制"),
    ALLIANCE_SHORT_NAME_LENGTH_EXCEED(820, "联盟简称超过规定字数限制"),
    ALLIANCE_JOIN_REQ_NOT_EXIST(821, "找不到玩家加入此联盟的请求"),
    ALLIANCE_ALLOWED_ALREADY_EXIST(822, "玩家已加入其他联盟"),
    ALLIANCE_MARK_TITLE_LENGTH_NOT_ENOUGH(823, "联盟标题长度不足"),
    ALLIANCE_MARK_DESCRIPTION_LENGTH_NOT_ENOUGH(824, "联盟内容长度不足"),
    ALLIANCE_QUERY_NOT_EXIST(825, "联盟不存在"),
    ALLIANCE_MANIFESTO_LENGTH_EXCEED(826, "联盟宣言超过规定字数限制"),
    ALLIANCE_MARK_COUNT_EXCEED(829, "联盟标记数量已达上限"),
    ALLIANCE_REMOVE_FORBIDDEN(831, "执行移除操作的玩家和被移除玩家不是同一联盟"),
    ALLIANCE_SET_POSITION_FORBIDDEN(832, "没有权限修改玩家在联盟中的职位失败"),
    ALLIANCE_SET_POSITION_EXCEED(833, "该职位玩家已达上限"),
    ALLIANCE_SET_DESCRIPTION_FORBIDDEN(834, "联盟公告中存在敏感字符"),
    ALLIANCE_QUIT_FORBIDDEN(841, "如果是盟主，则必须先进行禅让后，才可以退出联盟"),
    ALLIANCE_PLAYER_NO_JOIN(842, "玩家没有加入联盟"),
    ALLIANCE_BUILD_NOT_OK(843, "联盟建筑当前状态不支持此操作"),
    ALLIANCE_RESOURCE_NOT_ENOUGH(851, "玩家资源数量不足"),
    ALLIANCE_MARK_USED(860, "当前联盟标记已被使用"),
    ALLIANCE_MARK_SITED(861, "当前位置已被占用"),
    ALLIANCE_MARK_COUNT_LMT(862, "联盟标记已达上限"),
    ALLIANCE_FLAG_NOT_SET(863, "联盟旗帜没有发生改变"),
    ALLIANCE_FLAG_NOT_EXIST(864, "没有找到旗帜类型"),
    ALLIANCE_BUILD_CREATE_EFFECT_ERROR(865, "科技效果不足"),
    ALLIANCE_POSITION_RIGHT_FORBIDDEN(899, "权限表中找不到对应操作权限"),
    MEMBER_POS_MAX_ERROR(905, "该成员已达到职位数量上限"),
    ALLIANCE_POSITION_NO_ENERGH(907, "权限不足"),
    MEMBER_DISMISS_ALLIANCE_ERROR(908, "联盟成员数量不允许解散联盟"),
    IM_ERROR_NO_FIND_TIME(909, "弹劾失败,找不到该职位的弹劾时间"),
    IM_ERROR_TIME_NO_ENOUGH(910, "弹劾失败,弹劾时间不足"),
    INVITE_PLAYER_CD(911, "邀请玩家冷却中"),
    ALLIANCE_BUILD_NOT_LINK_ERROR(912, "联盟领地未相连"),
    ALLIANCE_CALENDAR_UNDERWAY_LMT(913, "联盟日程正在进行中的超上限"),
    ALLIANCE_CALENDAR_DELETE_ERROR(914, "联盟日程不可删除，自动加入的不可删除"),
    ALLIANCE_CALENDAR_NEW_ERROR(915, "联盟日程不可添加，已存在同类型自动加入的日程"),
    ALLIANCE_BUILD_INVITE_ERROR(916, "联盟建造邀请cd中"),
    ALLIANCE_COMPETITION_QUEST_REFRESH_ERROR(924, "联盟总动员专属任务进行中，不可刷新"),
    ALLIANCE_PERSONAL_QUEST_NO_NUM(925, "玩家联盟总动员专属任务次数不足"),
    ALLIANCE_COMPETITION_QUEST_STATUS_ERROR(926, "联盟总动员任务未领取或不存在"),
    NO_JOIN_ALLIANCE_COMPETITION(927, "玩家没有参与本次联盟总动员"),
    HAVE_ALLIANCE_COMPETITION_QUEST(928, "玩家当前已领联盟总动员任务"),
    ALLIANCE_COMPETITION_ALLIANCE_ERROR(929, "玩家本日联盟总动员的效力帮派与当前帮派不符"),
    ALLIANCE_COMPETITION_QUEST_NO_NUM(930, "玩家联盟总动员领取任务次数不足"),
    ALLIANCE_COMPETITION_QUEST_CAN_NO_GET(931, "玩家联盟总动员任务当前已进入刷新倒计时"),
    NO_HAVE_ALLIANCE_COMPETITION_QUEST(932, "玩家当前没有联盟总动员任务可以放弃"),
    ALLIANCE_COMPETITION_QUEST_STATE_NOT_REMOVE(933, "当前无任务"),
    ALLIANCE_COMPETITION_QUEST_NUM_ENOUGH(934, "任务次数还未使用完无需购买"),
    ALLIANCE_COMPETITION_QUEST_NOT_FINISH(935, "联盟总动员任务还未完成"),
    BUY_ALLIANCE_COMPETITION_QUEST_MAX(936, "联盟总动员购买任务次数已达上限"),
    GET_ALLIANCE_COMPETITION_REWARD_ERROR(937, "联盟总动员领取奖励的客户端数据异常"),
    GET_ALLIANCE_COMPETITION_NO_FIND_REWARD_ERROR(938, "联盟总动员领取奖励失败,已经领过或者没有该阶段奖励"),
    GET_ALLIANCE_COMPETITION_REWARD_NO_SCORE_ERROR(939, "联盟总动员领取奖励失败,积分不足"),
    PUBLIC_ACTIVITY_NO_OPEN_ERROR(940, "活动当前状态不允许此操作"),
    ALLIANCE_COMPETITION_TIME_OUT(941, "当前不处于总动员活动时间"),
    WONDER_DISMISS_ALLIANCE_ERROR(942, "联盟当前占领大奇观，无法解散"),
    PLAYER_JOIN_ALLIANCE_BUSY(945, "玩家正在尝试加入联盟中"),
    APPLY_ALLIANCE_MAX_ERROR(946, "当前申请联盟数已达上限"),
    ALLIANCE_BOSS_FIGHT_COUNT_ERROR(947, "联盟boss战斗次数不足"),
    ALLIANCE_BOSS_NOT_EXIST(948, "没有可以攻击的联盟boss"),
    ALLIANCE_BOSS_FIGHT_TIME_OVER(949, "联盟boss战斗时间已超时"),
    ALLIANCE_BAG_NUM_ERROR(950, "联盟仓库可兑换数量不足"),
    ALLIANCE_BAG_DONATE_QUA_ERROR(951, "道具品质不可低于联盟仓库捐献品质"),
    ALLIANCE_FIGHT_NO_JOIN_ERROR(952, "玩家当前未报名联盟战"),
    ALLIANCE_FIGHT_NOW_JOIN_ERROR(953, "玩家当前已报名联盟战"),
    ALLIANCE_FIGHT_ALLIANCE_NO_JOIN_ERROR(954, "联盟未报名,成员无法操作"),
    ALLIANCE_FIGHT_TIME_NO_OK_ERROR(955, "当前状态不允许操作参赛情况"),
    ALLIANCE_FIGHT_IN_FIGHT_ERROR(956, "当前正在战斗中"),
    ALLIANCE_FIGHT_HERO_USE_ERROR(957, "有武将已经出战过了"),
    ALLIANCE_FIGHT_NO_IN_FIGHT_ERROR(958, "当前不在联盟战斗中"),
    ALLIANCE_FIGHT_OPP_DIE_ERROR(959, "该目标已死亡"),
    ALLIANCE_FIGHT_STATE_ERROR(960, "战斗状态互斥"),
    ALLIANCE_FIGHT_MY_REWARD_SCORE_ERROR(961, "联盟战个人宝箱积分不足"),
    ALLIANCE_FIGHT_DISMISS_ERROR(962, "联盟战期间无法解散联盟"),
    ALLIANCE_BUILD_MAX_ERROR(963, "联盟建筑已达上限"),
    ALLIANCE_BUILD_BUILDING_MAX_ERROR(964, "联盟建筑同时建造数量已达上限"),
    ALLIANCE_BUILD_BUILDING_CONDITION_ERROR(965, "联盟建筑不满足前置条件"),
    ALLIANCE_BUILD_BUILDING_CD_ERROR(966, "联盟建筑建造CD中"),
    ALLIANCE_BUILD_SIZE_ERROR(967, "联盟建筑底座坐标被占用"),
    ALLIANCE_BUILD_SIZE_CONDITION_ERROR(968, "联盟建筑底座只能生成在我方领地内或无主地上"),
    ALLIANCE_BUILD_NO_ALLIANCE_ERROR(969, "未接壤其他联盟建筑"),
    ALLIANCE_BUILD_SOLIDER_MAX_ERROR(970, "联盟建筑驻守士兵数达到上限"),
    ALLIANCE_BUILD_DISMISS_ERROR(971, "尚存联盟建筑无法解散联盟"),
    ALLIANCE_BUILD_FIGHT_ERROR(972, "没有接壤地无法发起攻击"),
    ALLIANCE_BUILD_NO_FIRE_ERROR(973, "联盟建筑不在燃烧"),
    ALLIANCE_BUILD_XY_STATE_ERROR(974, "联盟建筑底座不能跨州"),
    ALLIANCE_CONVENE_CD_ERROR(975, "召集成员CD中"),
    ALLIANCE_CONVENE_CELL_ERROR(976, "必须在联盟生效领地上进行召集成员"),
    ALLIANCE_CONVENE_LEAVE_ERROR(977, "召集者已经离开坐标"),
    ALLIANCE_CONVENE_CELL_OK_ERROR(978, "召集者所在领地失效"),
    ALLIANCE_CONVENE_IN_CELL_ERROR(979, "已经在当前领地内"),
    ALLIANCE_PLAYER_CD_ERROR(980, "联盟回城冷却中"),
    ALLIANCE_PLAYER_NEAR_MANIN_PLAYER_ERROR(981, "已经在盟主附近"),
    ALLIANCE_CONVENE_NO_CELL_ERROR(982, "没有找到落脚点"),
    ALLIANCE_NO_RAND_NAME_ERROR(983, "占无可用随机联盟名"),
    ALLIANCE_MAIN_PLAYER_NO_ENTER_ERROR(984, "盟主长时间未上线"),
    ALLIANCE_APPLY_OFFICER_MAX_ERROR(985, "玩家已经有申请职位记录了"),
    ALLIANCE_POWER_NOT_ENOUGH_FOR_APPLY(986, "战斗力不足以申请职位"),
    ALLIANCE_FLAG_ADD_SOLIDER_STATE_ERROR(987, "联盟旗帜不需要增援"),
    ALLIANCE_FLAG_ADD_SOLIDER_ERROR(988, "联盟旗帜增援超过上限"),
    ALLIANCE_FLAG_ATK_SOLIDER_ERROR(989, "联盟旗帜进攻超过上限"),
    ALLIANCE_FLAG_ATK_STATE_ERROR(990, "维修状态不可以发起进攻"),
    ALLIANCE_FLAG_ATK_ALLIANCE_MORE_ERROR(991, "不可被多个联盟一起攻打"),
    ALLIANCE_FLAG_CAN_NOT_ADD_SOLIDER_ERROR(992, "不在可填兵状态"),
    ALLIANCE_BUILD_HUOYUEDU_ERROR(993, "活跃度不足"),
    ALLIANCE_BUILD_COUNT_ERROR(994, "当前联盟建筑耐久度不符合要求"),
    ALLIANCE_BUILD_TYPE_ERROR(995, "进行迁移的不是联盟据点"),
    ALLIANCE_SOLO_DISMISS_ERROR(996, "正在联盟战中无法解散联盟"),
    ALLIANCE_BOSS_FIGHT_CD_ERROR(997, "联盟boss战斗冷却中"),
    ALLIANCE_JOIN_STATE_ERROR(998, "只允许加入本族联盟或占领本族奇观的联盟"),
    ALLIANCE_INVITE_STATE_ERROR(999, "只可以邀请本族联盟或占领本族奇观的联盟"),

    // 英雄养成
    HERO_GROW_LV_ERROR(1000, "当前武将已升级"),
    HERO_GROW_ADV_LV_MAX(1001, "卡牌进阶等级已达上限"),
    HERO_GROW_CNT_NOT_ENOUGH(1002, "卡牌数量不足"),
    HERO_GROW_SKILL_MAX(1003, "技能已达最大等级"),
    HERO_GROW_HERO_LV_NOT_ENOUGH(1004, "武将等级不足"),
    HERO_LV_MAX(1005, "武将等级已达上限"),
    HERO_CARD_NOT_ENOUGH(1006, "道具数量不足"),
    HERO_EXP_NOT_ENOUGH(1007, "经验不足"),
    HERO_LV_ALREADY(1008, "武将已达到目标等级"),
    HERO_LV_CAN_NO_KING_LV_ERROR(1009, "武将等级不得超过君主等级"),
    HERO_LV_UP_BLOCKED_BY_RANK(1010, "英雄升级：需要升阶(亦突破)"),
    HERO_LV_UP_BLOCKED_BY_QUALITY(1011, "英雄升级：被品质太低阻止"),
    HERO_LV_UP_PROP_EXP_NOT_UPGRADE(1012, "英雄升级：当前经验道具所提供的经验，不够升一级"),

    BUILDING_LV_NOT_ENOUGH(1056, "建筑等级不足"),
    HERO_LV_UP_SUMMON_BUILDING_LV_NOT_ENOUGH(1088, "英雄升级：召唤阵等级不足,需升级"),
    // 战斗与战报 1159-1299
    PICK_UP_RES_COUNT_LIMIT(1146, "拾取资源点次数到达上限"),
    FARM_RES_CASTLE_LV_LIMIT(1147, "采集主堡等级限制"),
    NO_THROUGH_ROAD(1148, "此路不通"),
    UNABLE_SCOUT_NPC(1149, "无法侦查npc"),
    MASS_FORCE_TOO_LESS(1150, "集结部队数量太少"),
    IN_SAME_ALLIANCE_GROUP(1151, "在同一联盟组中"),
    FORBID_AUTO_ATATION(1152, "禁止自动驻扎"),
    FORBID_ATTACK_OTHER_EXCLUSIVE_COMMON_BOSS(1153, "禁止攻击别人的专属魔物"),
    MASS_FORBID_REINFORCE(1154, "集结部队禁止变增援"),
    NO_SCOUT_TARGET(1200, "无侦查目标"),
    NO_FIGHT_BOSS(1201, "无战斗BOSS"),
    NO_FARM_RES(1202, "无采集资源"),
    HAVE_IN_FARM(1203, "正在采集中"),
    SAME_ALLIANCE_PLAYER_IN_FARM(1204, "同盟玩家正在采集中"),
    OTHER_ALLIANCE_PLAYER_IN_FARM(1205, "其他玩家正在采集中"),
    CELL_NOT_FREE(1206, "土地非空闲"),
    NOT_IN_SAME_ALLIANCE(1207, "不在同一联盟中"),
    IN_SAME_ALLIANCE(1208, "在同一联盟中"),
    NOTHING_ON_CELL(1209, "地块上为空"),
    MASS_CAN_NOT_JOIN(1210, "集结无法加入"),
    TRANSPORT_RES_UP_LIMIT(1211, "运输的资源超出上限"),
    REINFORCE_SOLIDER_UP_LIMIT(1212, "增援的士兵超出上限"),
    MASS_TARGET_ERROR(1213, "集结目标错误"),
    MASS_RELIC_NEED_LIANJINSUO(1214, "集结遗迹需要炼金所"),
    MASS_SOLIDER_UP_LIMIT(1215, "集结的士兵超出上限"),
    MASS_NEED_FIGHT_LOBBY(1216, "集结需要战争大厅"),
    MASS_NEED_IN_ALLIANCE(1217, "集结需要在联盟中"),
    HAVE_START_MASS(1218, "已发起过集结"),
    WALK_HAVE_FINISHED(1219, "行军已结束"),
    NOT_IN_SAME_MAP(1220, "不在一张地图上"),
    HAS_IN_WALK_HOME(1221, "已在回城中"),
    FORCE_NOT_STATIC(1222, "部队不是静止的"),
    UNABLE_OPERATE_GROUP(1223, "无权限操作行军组"),
    MASS_FORCE_UNABLE_SELF_HOME(1224, "集结部队无法自行撤退"),
    MASS_MMEMBER_UNABLE_SEND_HOME(1225, "无权遣返集结成员"),
    MAS_TARGET_CASTLE_TOO_LOW(1226, "集结玩家城堡等级过低"),
    FARM_QUEUE_UP_LIMIT(1227, "采集队列达到上限"),
    REINFORCE_REPEAT(1228, "重复增援"),
    HAVE_FORCE_FIGHT_BOSS(1229, "已有部队攻打魔物"),
    HAVE_FANZHENCHA_BUFF(1230, "对方处于反侦察中"),
    NO_SCOUT_RESEARCH(1231, "无可侦查科技"),
    NONE_CAN_SCOUT(1232, "木有课侦查的东西"),
    HAVE_DEF_COVER_BUFF_WHEN_FIGHT(1233, "攻击的时候，对方有罩子"),
    NO_STRONGHOLD(1234, "无据点"),
    NO_ATK_STRONGHOLD_COUNT(1235, "无攻击据点次数"),
    WONDER_IN_PEACE(1236, "奇观在和平状态中"),
    ONLY_ALLIANCE_CAN_OCCUPY_WONDER(1237, "只有联盟能占领奇观"),
    HAVE_OCCUPY_WONDER(1238, "已占领奇观"),
    NO_COMMAND_IN_WONDER(1239, "奇观中无指挥官"),
    NOT_OCCUPY_WONDER(1240, "未占领奇观"),
    NOT_COMMAND(1241, "不是奇观战指挥官"),
    REINFORCE_NOT_IN_WONDER(1242, "增援部队不在奇观中"),
    HAVE_DEF_COVER_BUFF_WHEN_SCOUT(1243, "侦查的时候，对方有罩子"),
    NO_SET_ARMY_PLAN(1244, "找不到阵型预设"),
    SELF_HAVE_START_MASS(1245, "自己已发起集结"),
    OVER_LIMIT_MASS(1246, "一个玩家被集结超过上限"),
    OVER_LIMIT_STATION(1247, "驻扎部队数量超过上限"),
    HAVE_ATK_COVER_BUFF_WHEN_FIGHT(1248, "攻击的时候，自身有罩子"),
    WALK_DISTANCE_LIMIT(1249, "超出行军距离上限"),
    NO_TARGET(1250, "目标不存在"),
    FORMATION_LOCKING(1251, "阵型未解锁"),
    HUNTER_BOSS_LV_LIMIT(1252, "猎杀魔物等级限制"),
    MASS_IN_RUNNING(1253, "集结部队正在行军中"),
    HAVE_DEF_COVER_BUFF_WHEN_FARM(1254, "采集的时候有罩子，无法撞矿"),
    CALL_BOSS_IN_PROTECT(1255, "召唤魔物在保护期内"),
    MASS_NOT_FOUND(1256, "集结已不存在"),
    HAVE_IN_MASS(1257, "已经在集结中"),
    SCOUT_WONDER_NEED_RESEARCH(1258, "侦查奇观等级不足"),
    BOSS_IN_DIE(1259, "BOSS还未复活"),
    WALK_GROUP_STATE_ERROR(1260, "行军组状态错误"),
    NO_FIGHT_TARGET(1261, "找不到战斗目标"),
    TARGET_IN_FIGHT(1262, "目标正在战斗中"),
    STATE_NO_LINK(1263, "州不联通"),
    ENEMY_SOLIDER_NOT_EXIST(1264, "贼兵已消失"),
    NO_HERO_IN_FREE(1265, "木有空闲中的英雄"),
    WONDER_OCCUPY_LIMIT(1266, "可占领的小奇观达到上限"),
    WALK_STATE_FAIL(1267, "当前状态不得行军"),
    POS_UNSTATION(1268, "目标点不得驻扎"),
    UNREACH_ACTION_TIME(1269, "未到可行动时间"),
    NO_MAP_BUFF(1270, "无buff点"),
    LINE_UN_ATK_OR_SCOUT(1277, "行军线不得攻击或侦查"),
    BOSS_HAVE_BE_KILLED_BY_SELF(1278, "魔物已被自己击杀"),
    BOSS_HAVE_BE_KILLED_BY_OTHER(1279, "魔物已被别人击杀"),
    HAVE_FORCE_IN_FARMING(1280, "有部队在采集中"),
    NO_FIGHT_FARMING_FORCE(1281, "无可战斗的采集部队"),
    FARM_NEED_BOSS_KILL(1282, "需要击杀魔物"),
    LESS_SOLIDER(1287, "预备兵不足"),
    WALK_QUEUE_UP_LIMIT(1288, "行军队列达到上限"),
    SOLDIER_CARRY_LIMIT(1289, "超过带兵量上限"),
    WALK_COMMOM_WITHOUT_ALLIANCE(1290, "打魔物要先加入联盟"),
    JOIN_OTHER_ALLIANCE_CANNOT_ATTACK_YANWU(1291, "活动期间加入新联盟后，不可再参与本次活动"),
    IN_FARM_PROTECT(1292, "在采集保护期间"),
    UNABLE_SET_NEED_SOLDIER(1293, "木有设置需要士兵的权限"),
    IN_FARM_PROTECT_ALLIANCE_LAND(1294, "处于联盟领地中采集，并且处于每日保护期"),
    NO_PROTO_WALK_BATTLE_VIEW(1295, "battleView没有配置相应行军类型"),

    // 任务 1300 -  1350
    TASK_HAD_REWARD(1300, "该奖励已领取"),
    NO_TASK(1301, "任务找不到"),
    TASK_STATE_ERROR(1302, "任务状态错误"),
    TASK_UNIT_FINAL_DENY_OF_PRE(1303, "章节其他任务未领取, 终极任务拒绝领奖"),
    FIGHT_VALUE_NO_ENOUGN_ERROR(1304, "战斗力不足"),
    CCT_NO_REG(1305, "任务类型未注册"),
    CCT_OVER_ERROR(1306, "中断cct检测,不是发生了错误,是没必要检测"),

    // 功能开启 1351 -  1399
    UI_CONDITION_ERROR(1351, "功能未开启"),
    UI_CONDITION_BUILD_LV_ERROR(1352, "建筑等级不足"),
    UI_CONDITION_VIPLV_ERROR(1358, "VIP等级不足"),
    UI_CONDITION_KINGLV_ERROR(1359, "君主等级不足"),
    UI_CONDITION_INSTANCE_ERROR(1360, "推图关卡不足"),
    UI_CONDITION_UNITTASK_ERROR(1361, "章节任务进度不足"),
    UI_CONDITION_MAINTASK_ERROR(1362, "主线任务进度不足"),
    UI_CONDITION_CHECK_POINT_ERROR(1363, "爬塔进度不足"),
    UI_CONDITION_BIG_INNER_CITY_ERROR(1364, "未占领PVE城池"),
    UI_CONDITION_ASSIST_MEMBER_ERROR(1365, "该盟友未解锁贸易站"),
    UI_CONDITION_TYPE_CHECK_EXECUTE_ERROR(1366, "UiCondition运行在非预期的服务器"), // 任务已领奖检测在wolrd执行了
    UI_FUNCTION_OPEN_ERROR(1367, "开服时间未到,功能未开启"),
    MODULE_WORLD_NO_OPEN_ERROR(1368, "模块未在world开启"),
    MODULE_HOME_NO_OPEN_ERROR(1369, "模块未在home开启"),

    // 缓存&模板
    NO_CACHE(1450, "找不到缓存"),
    NO_PROTO(1451, "找不到模板"),
    PROTO_ERROR(1452, "配置错误"),
    PROTO_DISABLED(1454, "模板/功能被禁用"), // 适用于直接屏蔽的功能,即玩家无论如何都不可以使用这个功能
    NOT_IMPLEMENT(1455, "暂未实现"),
    NOT_SUPPORT(1456, "不支持此操作"),
    NO_ACTIVITY_TYPE(1457, "找不到活动类型"),
    ARG_ATTACK_DENY(1458, "参数攻击被拒绝"),
    MSG_NO_RESPONSE(1459, "消息无响应"), // 出现此错误一般是消息号转发没有注册

    // 技能库功能  1500 - 1550
    SKILLUP_MAX_ERROR(1500, "该技能已升级到最高级"),

    // 装备养成功能  1551 - 1600
    NO_BUY_PROTO(1559, "找不到物品模板"),
    NO_EQUIP_ERROR(1560, "物品不存在"),
    EQUIP_NO_IN_BAG_ERROR(1561, "装备不在仓库内"),
    COMMON_TAOZHUANG_SANJIAN_ERROR(1576, "合成的散件不匹配"),
    ITEM_HECHENG_NO_EN_ERROR(1578, "合成道具不足"),
    ITEM_CAN_NO_SPLIT_ERROR(1579, "该物品无法分解"),
    KING_LV_UP_LIMIT(1580, "君主等级达到上限"),
    KING_BREAKTHROUGH_LV_LIMIT(1581, "飞升等级达到上限"),
    KING_BREAKTHROUGH_EXP_COUNT_LIMIT(1582, "修为兑换次数达到上限"),
    HERO_EXP_POOL_FULL(1583, "英雄经验池到达上限"),

    // 商城功能  1601-1650
    NO_FIND_SHOP_INFO(1601, "找不到玩家商城信息"),
    REFRESH_ALLIANCE_SHOP(1602, "马上请求联盟商城"),
    REFRESH_SHOP(1603, "马上请求黑市商城"),
    LIMIT_SHOP(1604, "限购上限"),
    OVER_TIME_SHOP(1605, "限购商品不在时间范围内"),
    SHOP_NO_INT(1606, "商品未开售"),
    NO_SHOP_ENTRY_TICKET(1607, "没有入场券"),
    NO_MSDK_OPENID(1608, "缺少msdkOpenid"),

    // 使用道具 1651 - 1700
    NO_ENOUGH_PROP_NUM(1651, "没有足够的数量使用"),
    NO_USE_EFFECT(1652, "找不到该使用类型的适配器"),
    TransferToMapServer(1653, "转发至地图服处理"),
    NO_MORE_MARK(1654, "收藏已达上限"),
    DECREE_MAX_ERROR(1655, "行动力已达上限"),
    PROTECT_DISABLE_WITH_PLAYER_IN_PRISON(1656, "监狱有人防护罩不可用"),
    NO_POS_FOR_CALL_RELIC(1657, "木有可召唤巢穴的位置"),
    HAVE_CALLED_RELIC(1658, "已召唤巢穴"),
    HAVE_CALLED_FESTIVAL_BOSS(1659, "已召唤七日boss"),
    NO_POS_FOR_CALL_FESTIVAL_BOSS(1660, "木有可召唤七日boss的位置"),

    // 群组错误码1701-1750
    ROOM_MASTER_ERR(1701, "群主不能被踢出群组"),
    NO_MORE_GROUP(1702, "群组创建已达上限"),
    NO_MORE_ALLIANCE_GROUP(1703, "团聊天组已存在"),
    NO_POWER(1704, "群组权限不足"),
    NO_POWER_ALLIANCE(1705, "联盟权限不足"),
    PERSON_CHAT_ALREADY_EXIST(1706, "私聊聊天室已创建"),

    // 新手引导错误码 1751-1800
    NOW_NO_IN_GUIDE(1751, "玩家不在新手引导状态"),

    // 充值礼包相关 (1800-1850)
    GIFT_PACKAGE_PROTO_ERROR(1800, "找不到礼包模板!"),
    GIFT_PACKAGE_TYPE_ERROR(1801, "未找到的礼包类型"),
    GIFT_PACKAGE_TYPE_ERROR2(1802, "无权购买礼包1"),
    GIFT_PACKAGE_TYPE_ERROR3(1803, "无权购买礼包2"),
    GIFT_PACKAGE_TYPE_ERROR4(1804, "无权购买礼包3"),
    GIFT_PACKAGE_TYPE_ERROR5(1805, "无权购买礼包4"),
    GIFT_PACKAGE_BUY_LIMIT_ERROR(1806, "已达到购买上限"),
    GIFT_PACKAGE_SUP_TIME_OVER_ERROR(1807, "限时礼包已消失"),
    GIFT_PACKAGE_HAS_WANT_ERROR(1808, "当前礼包已报备"),
    GIFT_PACKAGE_BUY_STEP_ERROR(1809, "无权购买当前档位礼包"),
    GIFT_PACKAGE_BUY_STEP_ERROR2(1810, "玩家已经买到最后一挡礼包了"),
    GIFT_PACKAGE_BUY_STEP_ERROR3(1811, "玩家无法跳档购买礼包"),
    GIFT_PACKAGE_NO_WANT_INFO_ERROR3(1812, "找不到记录无法清除报备"),
    GIFT_PACKAGE_GOP_NO_WANT_INFO_ERROR(1813, "无法实现GOP的礼包发送,因为没找到报备信息"),
    GIFT_PACKAGE_GOP_WANT_TIME_OVER_INFO_ERROR(1814, "无法实现GOP的礼包发送,因为报备信息已经超时"),
    GIFT_PACKAGE_BUY_CLUB_CARD_ERROR(1815, "当前已购买会员卡"),
    GIFT_PACKAGE_NO_ON_ERROR(1816, "商品未上架"),
    GIFT_PACKAGE_LV_UP_ERROR(1817, "该礼包已经被替代"),
    GIFT_PACKAGE_TIME_MIN_ERROR(1818, "该礼包已经过期"),
    GIFT_PACKAGE_TIME_MAX_ERROR(1819, "该礼包还没到出现时间"),
    GIFT_PACKAGE_MONEY_ERROR(1820, "支付异常,金额异常"),
    GIFT_PACKAGE_NEED_RMB_TYPE_ERROR(1821, "游戏内礼包商品无需拉起充值"),
    GIFT_PACKAGE_NEED_YXB_TYPE_ERROR(1822, "游戏内礼包商品无需拉起充值"),
    GIFT_PACKAGE_BUY_RAND_ERROR(1823, "无法购买没随到的礼包"),
    GIFT_PACKAGE_TEAM_SON_ERROR(1824, "已购买部分子礼包,无法购买礼包组合"),
    GIFT_PACKAGE_SON_TEAM_ERROR(1825, "已购买部分套餐礼包,无法购买子组合"),
    GIFT_PACKAGE_SHIP_ERROR(1826, "当前没有资格购买这个商船礼包"),
    GIFT_PACKAGE_GAME_ORDER_HAVE_ERROR(1827, "在home发货的时候根据发现这个游戏订单流水号已经执行过了"),
    GIFT_PACKAGE_MIDAS_ORDER_HAVE_ERROR(1828, "在home发货的时候根据发现这个米大师流水号已经执行过了"),
    GIFT_PACKAGE_GAME_LOGIN_ACTOR_ERROR(1829, "发货的时候LoginActor异常"),
    GIFT_PACKAGE_H5_ERROR(1830, "云游戏暂不支持，请下载完整版"),


    // 外交留言板 1851-1870
    PLAYER_WAIJIAO_MAX_NUM(1851, "本日个人外交次数已达上限"),
    ALLIANCE_WAIJIAO_MAX_NUM(1852, "本日联盟外交次数已达上限"),
    WAIJIAO_INFO_ERROR(1853, "外交内容不合法"),
    WAIJIAO_INFO_TOO_SHORT(1854, "外交内容长度不足"),
    WAIJIAO_INFO_TOO_LANG(1855, "外交内容超出上限"),
    WAIJIAO_REMOVE_ERROR(1856, "未找到要删除的留言"),

    // 推图错误码 1951-2000
    MISSION_ID_ERROR(1951, "推图关卡ID错误"),
    MISSION_MAX_ERROR(1952, "已经达到最后一关"),
    MISSION_FIGHT_RESULT_INCONFORMITY(1961, "战斗结果对比不一致"),
    MISSION_FIGHT_STATISTICS_INCONFORMITY(1962, "星数统计结果对比不一致"),

    // 1970-1979业务中最好不要用,因为战斗校验报错会返回197x错误码
    MISSION_BOSS_TIMES_FULL(1981, "精英关卡挑战次数已满"),
    MISSION_BOSS_WIPE_FULL_STAR_REQUIRE(1982, "扫荡精英关卡必须三星"),

    // 科技研发 + 快速使用物品错误码 2001-2050
    RESEARCH_CODITION_ERROR(2001, "研发条件不足"),
    RESEARCH_DUILIE_ERROR(2002, "研发队列不足"),
    CANCEL_RESEARCH_NO_IN_ERROR(2003, "该科技不在研发中"),
    CANCEL_RESEARCH_IN_ERROR(2004, "该科技正在研发中"),
    QUICK_PROPS_ERROR(2005, "加速道具错误"),
    QUICK_PROPS_MAX_ERROR(2006, "允许溢出时加速道具溢出错误"),
    USE_PROPS_ACTION_NO_FOUND(2007, "找不到物品使用策略"),
    SEND_ALLIANCE_HELP_ERROR(2008, "登记信息不匹配"),
    SEND_ALLIANCE_HELP_TYPE_ERROR(2009, "类型无效"),
    GO_ALLIANCE_HELP_NO_SAME_ERROR(2010, "无法帮助非本帮成员"),
    GO_ALLIANCE_HELP_NO_IN_ERROR(2011, "玩家不在研发中无法帮助其加速"),
    GO_ALLIANCE_HELP_HAVE_ERROR(2012, "你已经帮此玩家加速过了"),
    GO_ALLIANCE_HELP_HAS_ERROR(2013, "你已经申请过帮助了"),
    GO_ALLIANCE_HELP_MYSELF_ERROR(2014, "无法帮助自己"),
    GO_ALLIANCE_HELP_MAX_NUM_ERROR(2015, "帮助次数已达上限"),
    GO_ALLIANCE_HELP_NO_SAME_SERVER_ERROR(2016, "无法帮助迁服的玩家"),
    USE_PROP_ACTION_DENY_MULTIPLE(2017, "道具使用方法拒接一次多个"),
    USE_PROP_ACTION_DENY_MIX(2018, "道具使用方法拒绝多个模板的道具混用"),
    USE_PROP_ACTION_RANDOM_LIMIT(2019, "道具使用时有随机流程限制单次个数限制"),
    USE_PROP_ACTION_GET_UNSTACK_LIMIT(2020, "道具使用时获得了不可堆叠的道具导致单次限制1个"),
    QUICK_PROPS_MAX_ERROR2(2021, "不允许溢出时加速道具溢出错误2"),

    // 兵营,配兵,伤兵营 2051-2100
    MAKE_SOLIDER_CONDITION_ERROR(2051, "造兵前置条件不足"),
    BARRACK_SLG_BUSY(2052, "兵营繁忙"),
    BARRACK_SLG_FREE(2053, "兵营不存在目标队列"),
    GO_ALL_RES_ERROR(2054, "计算总消耗出错"),
    BARRACK_SLG_MAKE_OR_UP_ONCE_OVERFLOW(2055, "单次训练兵数量超上限"),
    BARRACK_SLG_SOLDIER_SRC_LACK(2056, "原始士兵数量不足"), // (仅限士兵升阶使用,出征不要用这个错误码)
    BARRACK_SLG_WOUNDED_SOLDIER_LACK(2057, "治疗伤兵数超出现存伤兵上限"),
    BARRACK_SLG_ALREADY_CURING(2058, "已存在治疗队列"),
    BARRACK_SLG_CURING_FAIL_OF_HOSPITAL(2060, "所有医院正在升级无法开始治疗伤兵"),
    BARRACK_SLG_WOUNDED_DISMISS_FAIL_OF_CURING(2062, "伤兵医疗中不支持遣散伤兵"),
    BARRACK_SLG_WOUNDED_EMPTY(2063, "没有伤兵"),
    BARRACK_SLG_NOT_OPEN(2064, "士兵没有投放"),
    NO_FIRE_ON(2065, "城墙没有着火"),
    WALL_REPAIRE_TIME_ERR(2066, "城墙修理时间未到"),
    WALL_DEURABILITY(2067, "城墙耐久度已满"),
    CASTLE_DEF_HERO_MUST_EXIST(2072, "守城英雄至少留1个"),

    // 遗迹(新行军结构)错误码 2201-2250
    WALK_NUM_TOO_MORE(2201, "行军部队数超过规定上限"),
    NO_FIND_RELIC_INFO(2202, "找不到遗迹数据"),
    RELIC_CLOSE(2203, "遗迹关闭中"),
    RELIC_CHOUBEI_TIME_ERROR(2204, "筹备时间错误"),
    GOTO_NO_RELIC_CHOUBEI_TIME(2205, "目标地不在筹备遗迹中"),
    RELIC_PLAYER_NUM_MAX_ERROR(2206, "参加遗迹人数已经达到上限"),
    NO_RELIC_MEMBER(2207, "没有该成员,无法遣返"),
    NO_FIND_RELIC_WALK(2208, "找不到参加遗迹的行军"),
    NO_FIND_RELIC_FIGHT_INFO(2209, "找不到遗迹战报"),
    NO_FIND_TIME_BOX_INDEX(2210, "找不到时光之盒槽位"),
    NO_FIND_TIME_BOX(2211, "槽位内找不到时光之盒"),
    TIME_BOX_IN_STUDY(2212, "时光之盒正在研究中"),
    TIME_BOX_STUDY_OVER(2213, "时光之盒已经研究结束"),
    TIME_BOX_GET_REWARD_ERROR(2214, "时光之盒还未研究结束"),
    TIME_BOX_QUEUE_ERROR(2215, "时光之盒研究队列不足"),
    FORCE_IN_RELIC(2216, "已经有部队在参加遗迹中"),
    WALK_GROUP_NOT_EXIST(2217, "行军组不存在"),
    FIGHT_INFO_NOT_FOUND(2218, "找不到战报"),
    RELIC_LV_LIMIT_ERROR(2219, "可攻打遗迹等级不足"),
    FIGHT_REPORT_UN_SHARE(2220, "战报不可分享"),
    RELIC_CAN_NOT_SINGLE_ATK(2221, "遗迹不可单人攻击"),
    FIGHT_INFO_ERROR(2222, "战报信息错误"),
    FLATLANDS_LIMIT(2223, "平原未解锁"),
    OASIS_LIMIT(2224, "绿洲未解锁"),
    NOT_IN_SAME_ALLIANCE_CANNOT_MASS_SUMMON(2225, "不在同联盟，无法集结圣女"),
    NO_SUMMON(2226, "圣女不存在"),
    ALREADY_WALK_SUMMON(2227, "已有行军在攻击"),
    ALREADY_DRAW_REWARD(2228, "点赞奖励已经领取"),

    // vip 2251-2270
    VIP_TIME_CARD_ERROR(2251, "vip时间卡错误"),
    VIP_EXP_CARD_ERROR(2252, "vip经验卡错误"),
    VIP_LEVEL_UP_LIMIT(2253, "vip等级已经达到上限"),
    VIP_NORMAL_GIFT_BUY(2254, "vip普通特权礼包已经购买过"),
    VIP_LEVEL_LIMIT_OF_POWER(2255, "战力不足，无法升级"),

    // 自动打野 2291-2310
    NOT_BEGIN_AUTO_FIGHT(2291, "还未设置自动打野，不可取消"),
    ALREADY_BEGIN_AUTO_FIGHT(2292, "不可重复设置自动打野"),
    NO_AUTO_POWER(2293, "权限不足"),
    ENERGY_NOT_ENOUGH(2294, "行动力不足"),
    COMMON_BOSS_LIMIT(2295, "不可选择到高于该玩家已经解锁的最高等级黑暗军"),
    FORCE_NUM_LIMIT(2296, "队列限制"),
    BEGIN_AUTO_BUFF_LIMIT(2297, "buff限制不可触发"),

    // 迁服2401-2450
    MOVE_CITY_ERROR_JOIN_MASS(2400, "正在参与集结，不得进行迁城"),
    MOVE_CITY_POS_ERROR(2401, "坐标不可迁移"),
    NO_CAN_MOVE_POS(2402, "无可迁城的位置"),
    FORCE_RUNNING_OUTSIDE(2403, "有部队在外行军"),
    MOVE_NEW_AREA_ERROR(2404, "无法迁入未出保的新服"),
    MOVE_NEW_AREA_LACK_CONDITION(2405, "迁服条件不足"),
    BATTLE_SERVER_NO_OPEN(2406, "战斗服务器未开放"),
    BATTLE_SERVER_OPEN_FORBID(2407, "战斗服务器开放时间禁止迁服"),
    SERVER_NOT_IN_OVERLORD_TERRITORY(2408, "本服务器不属于正在开放的霸主疆域"),
    MOVE_SERVER_HAS_TARGET_PLAYER_ERROR(2409, "目标服已经存在账号"),
    ALWAYSTEST_SERVER_MOVE_ERROR(2410, "永测服玩家无法外迁"),
    ALWAYSTEST_SERVER_BE_MOVE_ERROR(2411, "无法迁入永测服"),
    ALWAYS_TEST_MODULE_ERROR(2412, "世界不支持该玩法"),
    MOVE_SERVER_BUSY_ERROR(2413, "玩家正在科研或者建造中,无法迁服"),
    MOVE_SERVER_FAIL_OF_HERO_PRISONED(2414, "玩家有英雄被抓,无法迁服"),
    MOVE_SERVER_FAIL_OF_PRISONER(2415, "玩家监狱中有人,无法迁服"),
    MOVE_SERVER_FAIL_OF_HERO_TRAIN(2416, "英雄食堂中好友在自己这训练或自己在好友那训练,无法迁服"),
    MOVE_SERVER_FAIL_OF_TRUST(2417, "自己正在被托管/正在托管好友,无法迁服"),
    MOVE_SERVER_ALLIANCE_ERROR(2418, "新手迁服跨州必须无联盟"),
    MOVE_STATE_NO_INFO_ERROR(2419, "未找到迁州查询数据"),
    MOVE_STATE_INFO_TIME_OUT_ERROR(2420, "迁州查询数据已过期"),

    // 商船错误码  2451 - 2470
    MER_NO_COUNT_LIMIT(2451, "该物品已被兑换"),
    MER_BUY_LIMIT(2455, "兑换次数不足"),
    MER_VIP_LIMIT(2456, "vip等级不够"),
    MER_FORCE_REFRESH_RUN_OUT(2457, "刷新次数用尽"),
    MER_FRIEND_LIMIT(2458, "好感度未满"),

    // 银行错误码  2471 - 2500
    BANK_MONEY_ERROR(2471, "投资金额不符合要求"),
    BANK_HAVE_ERROR(2472, "当前已有投资项"),
    BANK_NO_HAVE_ERROR(2473, "当前没有投资项"),
    BANK_NO_TIME_OVER_ERROR(2474, "还未到领取时间"),
    BANK_TIME_OVER_ERROR(2475, "已经到达领取时间"),
    BANK_ACCELERATE_ERROR(2476, "投资的时间不足"),
    BANK_BUILD_LV_ERROR(2477, "建筑最高等级不足"),

    // 藏兵错误码 2501-2520
    MAIN_HERO_NOT_IN_CITY(2501, "领主不在城内"),
    NO_SUCH_SOLIDER_IN_CITY(2502, "城内木有如此数量士兵"),
    HAVE_CAVE_FORCE_GROUP(2503, "已有部队在藏兵中"),
    NO_CAVE_FORCE_GROUP(2504, "木有部队在藏兵中"),
    NO_IN_CAVE(2505, "无藏兵"),

    // BOSS错误码 2521 - 2530
    SUMMON_ALLIANCE_BOSS_XY_ERROR(2521, "该坐标无法放置BOSS"),
    BOSS_AREA_NOT_EXIST(2522, "BOSS区域不存在"),
    BOSS_LOCK(2523, "BOSS处于锁定状态，尚不能攻击"),
    NOT_ON_BOSS_AREA(2524, "不在BOSS所在区域"),
    CALL_BOSS_SOLIDER_NUM_ERROR(2525, "携带士兵数不是规定数量"),
    CALL_BOSS_FIGHT_COUNT_ERROR(2526, "攻打次数达到上限"),

    // 运输请求错误码 2531-2540
    HAVE_PUBLISH_TRANSPORT_REQUEST(2531, "已发布运输请求"),

    // buff 2541 - 2550
    NO_DEF_BECAUSE_WALK_EFFECT(2541, "无法使用保护罩因为有战争狂热"),
    NO_DEF_BECAUSE_SNOW_COVER(2542, "在雪地上无法使用保护罩"),
    NO_DEF_BECAUSE_WONDER_COVER(2543, "在黑土地上无法使用保护罩"),

    // CP爬塔2570-2579
    CP_TOWER_SWEEP_DENY(2571, "CP爬塔当前关卡未满星不能扫荡"),
    CP_TOWER_PRE_LEVEL_LACK(2572, "CP爬塔前置关卡未通过"),
    CP_TOWER_LEVEL_ALREADY_PASS(2573, "CP爬塔关卡已通过"),
    CP_TOWER_SPECIAL_ENERGY_LACK(2574, "CP爬塔特殊体力不足"),
    CP_TOWER_PRE_HERO_LACK(2575, "CP爬塔英雄英雄前置条件不满足"),
    CP_TOWER_ELITE_PRE_TOWER_LACK(2576, "CP爬塔精英塔前置塔最后1关未通关"),
    CP_TOWER_ELITE_TOWER_TODAY_TIMES_FULL(2577, "CP爬塔精英爬塔挑战次数已满"),
    CP_TOWER_QUICK_AFK_FULL(2578, "CP爬塔快速挂机次数已满"),
    CP_TOWER_BUILDING_LACK(2579, "CP爬塔建筑等级不足"),

    // 城堡皮肤错误码 2580 - 2590
    SKIN_NO_HAVE_ERROR(2580, "找不到皮肤"),
    SKIN_MAX_STAR_ERROR(2581, "满星"),
    SKIN_USE_NUM_ERROR(2582, "数量不在范围内"),
    SKIN_HAVE_ERROR(2583, "已有皮肤"),
    SKIN_IN_USE_ERROR(2584, "皮肤在使用中"),
    SKIN_HAVE_EXIST(2585, "皮肤已存在"),
    SKIN_TIME_STRING_ERROR(2586, "体验皮肤无法强化"),
    SKIN_DELETE_ERROR(2587, "皮肤无法删除"),
    SKIN_CANNOT_BUY_ERROR(2588, "不可购买当前皮肤"),
    SKIN_OVER_SIZE(2589, "超过使用的最大数量"),
    SKIN_IN_CRITICAL_PERIOD(2590, "皮肤到期临界点"),

    // 在线礼包错误码 2591 - 2600
    ONLINE_GIFT_TIME_ERROR(2591, "还未到领奖时间"),
    ONLINE_GIFT_OVER_ERROR(2592, "本日任务已经全部领取结束"),
    ONLINE_GIFT_RESVO_ERROR(2593, "掉落出来的奖励错误"),
    HUOYUEDU_TIME_OUT_ERROR(2594, "活跃度任务已过期"),
    HUOYUEDU_TIME_ERROR(2595, "还未到刷新时间"),

    // 成就功能 2631 - 2635
    ACHIEVEMENT_NOT_FINISH(2631, "成就未完成或奖励已领取"),

    // 官职功能 2636-2655
    UNABLE_SET_SUCH_OFFICE(2636, "无法设置该类官职"),
    LIMIT_TO_SET_OFFICE(2637, "没有权限设置国家官职"),
    NO_OFFICE_TO_CANCEL(2638, "木有官职可取消"),
    LIMIT_TO_AWARD_ALLIANCE(2639, "木有权限大赏三军"),
    AWARD_NUM_LIMIT(2640, "奖励人数限制"),
    HAVE_AWARDED(2641, "已给奖励"),
    WONDER_NOT_PEACE(2642, "奇观不在和平状态"),
    LIMIT_TO_OPEN_COUNTRY_BUFF(2643, "木有权限开启全国buff"),
    WHOLE_COUNTRY_BUFF_IN_ACTIVE(2644, "全国Buff生效中"),
    WHOLE_COUNTRY_BUFF_IN_COOL(2645, "全国Buff冷却中"),
    FREE_WORLD_ACCESS_DENY(2646, "无权大赦天下"),
    FREE_WORLD_TIMES_RUN_OUT(2647, "大赦天下次数用尽"),
    LIMIT_TO_EDITOR_NOTICE(2648, "木有权限编辑公告"),
    COUNTRY_NOTICE_NOT_ENOUGH(2649, "公告长度不足"),
    COUNTRY_NOTICE_EXCEED(2650, "公告长度超过规定字数限制"),
    NO_COUNTRY_NOTICE(2651, "无公告信息"),
    WONDER_IN_WAR(2652, "奇观争夺战未结束"),
    COUNTRY_NOTICE_IN_COOL(2653, "王国公告冷却中"),
    WONDER_NOT_EXIST(2654, "奇观不存在"),
    SET_OFFECT_ERROR_FOR_COUNTRY(2655, "不能给建国联盟的盟主上任何buff"),

    // 内城功能 2670-2700
    INNER_CITY_LOCK(2670, "前置条件未达到要求，不可建造"),
    INNER_CITY_NOT_FIND_BUILDING(2671, "内城建筑未找到"),
    INNER_CITY_STATE_ERROR(2672, "内城建筑状态错误"),
    INNER_CITY_QUEUE_ERROR(2673, "内城建筑队列已满"),
    INNER_CITY_EXIST_BUILDING(2674, "坑位上有内城建筑了"),
    INNER_CITY_MAP_LAYOUT_EDIT_FOUND_LOCK_IN_DIY(2675, "布局 -- 编辑时发现diy区域有未解锁的建筑"),
    INNER_CITY_CAN_NOT_BUILD(2676, "坑位上不能造该建筑"),
    INNER_CITY_CAN_NOT_DESTROY(2677, "坑位上不能拆除"),
    INNER_CITY_CAN_NOT_MOVE_TO_SELF(2678, "不能移动到自身坑位上"),
    INNER_CITY_AREA_LOCK(2679, "区域未解锁"),
    INNER_CITY_AREA_UNLOCK(2680, "区域已解锁"),
    INNER_CITY_MAP_EXCEED_DIY_RANGE_ERROR(2681, "坐标超出内城diy可用区域"),
    INNER_CITY_DECORATION_CREATE_REQUIRE_PROP_USE(2682, "装饰建筑建造要求曾经使用过建筑道具"),
    INNER_CITY_RES_STORAGE_LIMIT(2683, "资源存储达到上限"),
    INNER_CITY_UNLOCK_FAIL_OF_PRE_PVE(2684, "前置pve城池未占领建筑无法解锁"),
    INNER_CITY_FATIGUE_OVER_FLOW(2685, "建筑工人疲劳值溢出不可升级建筑"),
    INNER_CITY_NUM_ALREADY_MAX(2686, "建筑数量超上限"),
    INNER_CITY_OBJ_NOT_FOUND_ON_MAP(2687, "在地图上找不到对应的建筑"),
    INNER_CITY_MAP_POS_INVALID(2688, "超出地图坐标范围"),
    INNER_CITY_MAP_MULTI_POS_DECORATION_BAT_DENY(2689, "战地超出1格的装饰建筑不可批量处理"),
    INNER_CITY_MAP_OBJ_DENY_MOVE(2690, "建筑不可移动"),
    INNER_CITY_MAP_LAYOUT_FULL(2691, "建筑布局数量已满"),
    INNER_CITY_MAP_LAYOUT_NOT_FOUND(2692, "建筑布局不存在"),
    INNER_CITY_MAP_LAYOUT_LACK_BUILDING(2693, "建筑布局缺失功能建筑"),
    INNER_CITY_MAP_LAYOUT_SITE_BLOCK(2695, "地块上有阻挡(仅编辑布局时)"),
    INNER_CITY_ADD_QUEUE_ERROR(2696, "建造时间不允许小于内城临时队列剩余时间"),
    INNER_CITY_DO_NOT_GEN_RES(2697, "当前建筑不产出资源"),
    INNER_CITY_ACCUMULATE_TIME_ALL_LACK(2698, "所有建筑累积时间均小于最小可领取时间"),
    INNER_VITY_SLG_CURING_PREVENT_HOSPITAL_UPGRADE(2700, "医院正在治疗伤兵无法升级"),

    // 推图功能 2701 - 2720
    INSTANCE_STAR_BOX_HAVE_ERROR(2701, "该宝箱已领取"),
    INSTANCE_STAR_BOX_NO_ENOUGH_ERROR(2702, "还未获得目标星数"),
    INSTANCE_STENGTH_BUY_NUM_ERROR(2703, "购买体力次数达到上限"),
    INSTANCE_PROTO_ERROR(2704, "推图模板找不到"),
    INSTANCE_MONSTER_ERROR(2705, "推图怪物找不到"),
    INSTANCE_STAR_ERROR(2706, "推图星级信息找不到"),
    INSTANCE_INSTANCE_UNIT_ERROR(2707, "推图章节找不到"),
    ELIMINATE_FIGHT_PB_ERROR(2708, "找不到战斗报备数据"),
    ELIMINATE_FIGHT_ITEM_NUM_ERROR(2709, "检测道具是否正常的时候发现客户端传来的时候使用数量不为0"),
    ELIMINATE_FIGHT_ITEM_NUM_MAX_ERROR(2710, "检测道具是否正常的时候发现客户端传来的时候数量超限"),
    ELIMINATE_FIGHT_ITEM_NUM_MORE_ERROR(2711, "检测道具是否正常的时候发现客户端传来的ID重复"),
    INSTANCE_LOCK(2712, "关卡未解锁"),
    INSTANCE_CHANCE_LIMIT(2713, "次数已达上限"),
    INSTANCE_TIME_LIMIT(2714, "关卡已经关闭"),
    INSTANCE_FIGHT_TYPE_ERROR(2716, "推图战斗类型错误"),
    INSTANCE_REPEATED_ERROR(2717, "推图关卡不可重复挑战"),
    INSTANCE_UNIT_LOCK_ERROR(2718, "推图关卡章节解锁条件未达到"),

    // 魔物功能 2721 - 2750
    MONSTER_NOT_EXIST(2721, "魔物不存在"),
    NO_CELL_CAN_CALL_BOSS(2723, "木有可以召唤魔物的地块"),

    // 挑战功能 2751 - 2760
    ACTIVITY_RANK_TIME_OVER(2751, "挑战排行已过期"),
    ACTIVITY_REWARDED(2752, "挑战奖励已领取"),
    ALLIANCE_TIME_NO_IN_CALL_BOSS(2753, "当前不在召唤之日时间内"),
    ALLIANCE_TIME_NO_IN_CALL_RELIC(2754, "当前不在巢穴之日时间内"),

    // 抽卡 (2781-2790)
    LOTTERY_OUT_OF_DATE(2781, "抽卡活动过期"),
    HAVE_GET_LOTTERY_COUNT_REWARD(2782, "已领取过活动次数奖励"),
    LOTTERY_COUNT_NO_ENOUGH(2783, "抽奖次数不够"),
    RECEIVE_LOTTERY_NUM_EMPTY(2784, "领取未达到对应阶段次数"),
    RECEIVE_LOTTERY_RECEIVE_REPEAT(2785, "领取重复"),
    RECEIVE_LOTTERY_REWARD_EMPTY(2786, "没有对应阶段的奖励"),
    LOTTERY_LIMIT_HIT(2787, "招募次数已达到上限"),
    LOTTERY_REWARD_USE_SCORE_NOT_ENOUGH(2788, "抽将积分奖励兑换积分不足"),

    // 图书馆 (2791 - 2800)
    NO_SESSION_LIBRARY(2791, "找不到图书馆缓存"),
    NUM_ERROR(2792, "数值错误"),

    // 聊天 (2801-2810)
    CHAT_MSG_ERR(2801, "内容含有屏蔽内容"),
    CHAT_MSG_LENGTH_OVER(2802, "内容长度不符合范围"),
    CHAT_MSG_CANNOT_ASSIST(2803, "聊天内容不可以点赞"),

    // 黑名单 (2811-2820)
    BLACK_IS_EXIST(2811, "存在名单中"),
    BLACK_IS_NOT_EXIST(2812, "不存在黑名单中"),

    // 赌场 (2831-2840)
    NO_PLAYERS(2831, "无中奖人数"),
    CASINO_ERROR(2832, "赌场配置出错"),
    CASINO_TYPE_ERROR(2833, "没有该赌场"),

    // 迁城 (2841-2850)
    MOVE_CITY_LV_LIMIT(2841, "未达到迁城到该土地的等级"),
    UNABLE_MOVE_CITY_FOR_IN_MASS(2842, "发起集结中无法迁城"),
    UNABLE_RAN_MOVE_CITY_FOR_IN_ATK(2843, "在被进攻中，无法随机迁城"),
    UNABLE_MOVE_CITY_FOR_FOG_LOCK(2844, "中心迷雾未解锁，无法迁城"),

    // 玩家设置(2851-2860)
    CANT_FIND_PLAYER_SETTING(2851, "无法找到玩家设置"),

    // 领主 (2861-2880)
    LORD_TALENT_SKILL_IN_CD(2861, "领主天赋技能cd中"),
    LORD_TALENT_SKILL_LOCK(2862, "领主天赋未解锁"),
    LORD_TALENT_POINT_LACK(2863, "领主天赋点不足"),
    LORD_TALENT_PAGE_EFFECT_LACK(2864, "领主天赋页效果不足"),
    LORD_TALENT_NO_TARGET_FORCE(2865, "领主天赋技能紧急召回无可召回的部队"),
    LORD_TALENT_HOME_ERROR(2866, "领主天赋HOME内部异常"),
    LORD_TALENT_WORLD_ERROR(2867, "领主天赋WORLD内部异常"),
    LORD_TALENT_HANDLE_ERROR(2868, "领主天赋没有注册策略"),

    // 部队预设 2881 - 2890
    FORCE_PLAN_NUM_LIMIT(2881, "部队预设数量限制"),
    FORCE_PLAN_NOT_FOUND(2882, "部队预设找不到"),

    // 迁服 (3000 - 3020)
    MOVE_SERVER_PLAYER_EXIST_ERROR(3000, "玩家迁服数据已存在"),
    MOVE_SERVER_XY_EXIST_ERROR(3001, "目标点已经被占去"),
    MOVE_SERVER_ENTITY_ERROR(3002, "必要的entity获取不到"),
    MOVE_SERVER_TRACE_ERROR(3003, "迁服中途找不到玩家的迁服痕迹数据了!"),
    MOVE_SERVER_PLAYER_ERROR(3004, "迁服中途找不到玩家的数据了!"),
    MOVE_SERVER_PLAYER_MYTARGET_ERROR(3005, "迁服中途找不到玩家的myTarget数据了!"),
    MOVE_SERVER_TARGET_SERVER_ERROR(3006, "迁服中途找不到目标服的配置数据了!"),
    MOVE_SERVER_HEART_MAXERROR(3007, "迁服心跳重试次数达到上限!"),
    MOVE_SERVER_RANK_TO_INT_ERROR(3008, "迁服的时候rank转型int失败!"),

    // 礼包(3021-3030)
    GIFTBAG_LAST_GIFTBAG_BUY_COUNT_NOENOUGH(3021, "上一档位礼包购买次数不足"),
    GIFTBAG_BUY_COUNT_MAX(3022, "礼包购买次数最大"),
    GIFTBAG_NOT_OPEN(3023, "礼包未开放"),
    GIFTBAG_MONTH_CARD_ACTIVE(3024, "月卡有效，暂不能购买"),
    MONTH_CARD_INVALID(3025, "月卡失效"),
    MONTH_CARD_IS_RECVED(3026, "今日月卡已经领取过"),
    TRIGGER_GIFTBAG_IS_OVERDUE(3027, "触发礼包已过期"),
    TRIGGER_GIFTBAG_NOT_EXIST(3028, "触发礼包不存在"),

    // 开服活动(3031-3059)
    ACTIVITY_OPEN_SERVER_TIME_LIMIT(3031, "开服活动活动时间限制"),
    GROWTH_FUND_VIP_LIMIT(3032, "成长基金vip等级限制"),
    GROWTH_FUND_OWN(3033, "已经购买过成长基金"),
    PURCHASE_BUY_LIMIT(3034, "已经购买该活动礼包"),
    PURCHASE_VIP_LIMIT(3035, "活动礼包vip等级限制"),
    ACTIVITY_OPEN_SERVER_CLOSE(3036, "开服活动活未开启"),
    ACTIVITY_OPEN_SERVER_REWARD_TIME_LIMIT(3037, "开服活动奖励领取时间限制"),
    ACTIVITY_OPEN_SERVER_REWARD_OWN(3038, "开服活动奖励已领取"),
    NO_ACTIVITY_OPEN_SERVER_REWARD(3039, "未达到领取条件"),
    NOT_COMMON_SERVER(3040, "非普通服务器"),
    PURCHASE_ACTIVITY_NO_STEP(3041, "自定义活动没有这一档奖励"),
    PURCHASE_ACTIVITY_STEP_ERROR(3042, "自定义活动领取阶段奖励条件未达到"),
    PURCHASE_ACTIVITY_STEP_MORE_ERROR(3043, "自定义活动该阶段奖励已经领过"),
    PURCHASE_ACTIVITY_ITEM_BUY_ERROR(3044, "自定义活动该钻石礼包已经买过了"),
    PURCHASE_ACTIVITY_PAY_GIFT_BUY_ERROR(3045, "自定义活动该付费礼包已经买过了"),
    ACTIVITY_LOGIN_CONDITION_ERROR(3046, "拍脸图登录前置条件未达到"),
    ACTIVITY_LOGIN_REWARD_REPEATED(3047, "拍脸图登录奖励领取重复"),
    ACTIVITY_LOGIN_ORDER_ERROR(3048, "拍脸图登录奖励领取次序错误"),
    ACTIVITY_LOGIN_TODAY_REWARD(3049, "拍脸图登录奖励领取今日已经领取"),
    SHIP_PAY_GIFT_BUY_ERROR(3050, "没有购买此商船礼包的资格"),
    ACTIVITY_NOT_OPEN(3051, "活动没有开启"),
    ACTIVITY_OPEN_ERROR(3052, "活动开启类型不匹配"),
    ACTIVITY_NOT_OPEN_CACHE(3053, "活动没有开启"),
    ACTIVITY_COUNT_ERROR(3054, "活动次数限制"),
    INVEST_PAY_GIFT_BUY_ERROR(3055, "该投资礼包已经购买过了"),
    INVEST_PAY_GIFT_BUY_ERROR2(3056, "该投资礼包解析异常"),

    // 世界奇观跨服战(3061-3080)
    LIMIT_TO_SET_WORLD_WONDER_OFFICE(3061, "没有权限设置跨服官职"),
    SET_WORLD_WONDER_OFFICE_MAIN_TYPE_ERROR(3062, "设置跨服官职类型错误"),
    SET_WORLD_WONDER_OFFICE_NO_OFFICE(3063, "对方无官职"),
    SET_WORLD_WONDER_OFFICE_NO_ALLIANCE(3064, "必须加入联盟以后才可以册封官职"),
    LIMIT_TO_SEND_WORLD_WONDER_AWARD(3065, "没有权限发送世界奇观奖励"),
    SEND_WORLD_WONDER_AWARD_COUNT_MAX(3066, "没有权限发送世界奇观奖励"),
    SEND_WORLD_WONDER_AWARD_HAVE_PLAYER(3067, "该玩家已经发放过奖励"),
    SEND_WORLD_WONDER_AWARD_HAVE_COUNTRY(3068, "该国家已经发放过奖励"),
    SEND_WORLD_WONDER_AWARD_HAVE_AWARD(3069, "该奖已经发放过"),
    DISMISS_PLAYER_NO_FOUND_POS(3070, "遣返玩家在原服务器未找到空闲位置"),
    WORLD_WONDER_OPEN_FORBID_JJC(3071, "跨服战期间不允许使用竞技场"),
    LIMIT_TO_GET_WORLD_WONDER_RECORDS(3072, "没有权限查看发送的世界奇观奖励"),

    // 活动条件(3081-3100)
    UNDESIGNED_ACTIVITY_TYPE(3081, "未定义的活动类型"),
    UNDESIGNED_ACTIVITY_CONDITION(3082, "未定义的活动条件"),
    ACTIVITY_CONDITION_VALUE_ERROR(3083, "活动条件值错误"),

    // MGR消息(3081-3100)
    MGR_SYS_MAIL_MSG_ERROR(3084, "系统邮件模板错误，获取不到可用lan"),
    RELOAD_CONFIG_ERROR(3085, "重载配置异常"),
    DRAW_TENCENT_MONEY_MAIL_TYPE_ERROR(3086, "一级货币邮件领取失败 邮件类型异常"),
    DRAW_TENCENT_MONEY_MAIL_COUNT_ERROR(3087, "一级货币邮件领取失败 数量转型异常"),
    MGR_GM_CMD_TEXT_PARSE_WRONG(3088, "mgr gmCmd 文本解析错误"),
    MGR_GM_CMD_DEAL_LOSE(3089, "找不到gmCmd的执行策略"),
    MGR_GM_CMD_PROCESS_ERR(3090, "gmCmd的目标进程有误"),

    // 犒赏令活动(3101 - 3130)
    APPRECIATION_NO_GOIN(3101, "该犒赏令未开启"),
    APPRECIATION_NO_HAVE(3102, "玩家该犒赏令未开启"),
    APPRECIATION_SCORE_ERROR(3103, "犒赏令积分不足"),
    APPRECIATION_REWARD_HAVE_ERROR(3104, "犒赏令奖励已经领过"),
    APPRECIATION_PAY_REWARD_ERROR(3105, "还未充值犒赏令升级版"),
    APPRECIATION_PAY_HAVE_ERROR(3106, "已经购买过这个犒赏令了"),
    CABBAGE_LV_MAX_ERROR(3107, "种菜奖励已经升阶过了"),

    // 累积充值奖励(3131 - 3150)
    TOTAL_PAY_REWARD_HAS_GOT(3131, "累充奖励已被领取"),
    TOTAL_PAY_REWARD_TIME_LIMIT(3132, "累充奖励尚且无法领取"),

    // 至高领主活动错误码(3151,3200)
    NO_LORD_ACTIVITY(3151, "找不到至高领主活动信息"),
    NO_LORD_ACTIVITY_RECORD(3152, "找不到至高领主活动记录信息"),
    LESS_LORD_ACTIVITY_SCORE(3153, "至高领主活动积分不足"),
    RECEIVED_LORD_ACTIVITY_SCORE_REWARD(3154, "已领取至高领主活动积分奖励"),

    // 礼品码3161-3170
    GIFT_KEY_NOT_EXIST(3161, "不存在的礼品码"),
    GIFT_KEY_WITH_WRONG_TIME(3163, "该礼包码无效或已过期"),
    GIFT_KEY_IS_DREW(3164, "该礼包码已被使用"),
    GIFT_KEY_CFG_NOT_EXIST(3166, "无法找到礼品码配置"),
    GIFT_KEY_NUM_LIMIT(3168, "兑换次数已超限额"),
    GIFT_KEY_GROUP_NOT_EXIST(3169, "无法找到同组礼品码"),
    GIFT_KEY_GROUP_REPEAT(3170, "您已经领取过同类型礼品码"),

    @Deprecated("废弃")
    GIFT_KEY_USER_NUM_LIMIT(3165, "兑换人数已超过限制"),

    @Deprecated("废弃")
    GIFT_KEY_WITH_WRONG_COUNTRY(3162, "您所在的国家不符合领取条件"),

    @Deprecated("废弃")
    GIFT_KEY_USER_NUM_LIMIT_IN_BATCH(3167, "该组兑换码人数已超过限制"),

    // 内城建筑 3180-3189
    INNER_CITY_BUILDING_LOCK_BY_MONSTER_PRE(3180, "拦路怪未击败无法修复建筑"),
    INNER_EXTEND_QUEUE_TIME_BUY_ERROR(3181, "临时队列充足,无需购买时间"),
    INNER_EXTEND_QUEUE_COUNT_BUY_ERROR(3182, "永久队列充足,无需购买临时队列"),
    INNER_CITY_PRE_ELIMINATE_NOT_PASS(3183, "内城建筑三消未通过"),

    // 英雄训练营 (3211-3220)
    HERO_TRAIN_CAMP_GRID_IN_CD(3211, "英雄训练营格子cd中"),
    HERO_TRAIN_CAMP_HERO_LESS(3212, "英雄数量太少"),
    HERO_TRAIN_CAMP_LOCK_HERO(3213, "英雄在训练营格子上无法操作"),
    HERO_TRAIN_CAMP_MIRROR_LOCK(3214, "英雄训练营镜像无法重置"),

    // PVE玩法(3231-3260)
    PVE_ROB_AUTO_BATTLE_ERROR(3240, "Pve拦路怪自动战斗类型错误"), // 自动的发给了非自动或者非自动发给了自动,消息发错了
    CITY_HERO_NO_ENERGY_ERROR(3246, "PVE行动力不足"),
    FIGHT_ROB_KILLED_ERROR(3253, "该盗贼已经击杀过"),
    PVE_QUICK_PASS_DENY(3255, "战力不足以快速通关"),
    ROB_CLOUD_LOCK(3260, "拦路怪迷雾未解锁"),

    // npc城池(3261-3270)
    NPC_CASTLE_NOT_EXIST(3261, "npc城池不存在"),
    NPC_CASTLE_CAN_NOT_ATK(3262, "npc城池不可攻击"),
    NPC_CASTLE_NOT_OCCUPY(3263, "npc城池未占领"),
    NPC_CASTLE_HERO_LIMIT(3264, "npc城池可容纳英雄数量限制"),
    NPC_CASTLE_QUERY_LIMIT(3265, "npc城池无查看权限"),
    CASTLE_DEF_HERO_NEED(3266, "必须有城池防守英雄"),

    // pve城池 3271-3280
    CITY_LV_BLOCK_BY_CASTLE_LV(3271, "主堡等级不足无法升级"),
    CITY_LV_BLOCK_BY_PRE_CITY_LV(3272, "前置城池等级不足无法升级"),

    // 新版采集(3301-3350)
    WALK_LINE_NOT_FOUND(3301, "行军线找不到"),
    FORCE_NOT_FOUND(3302, "部队找不到"),
    INVALID_HELP_SPEED_UP_WALK(3303, "无效的帮助加速行军类型"),
    HAVE_HELP_SPEED_UP_WALK(3304, "已帮助加速行军"),
    WALK_SPEED_UP_HELP_LIMIT(3305, "行军帮助加速次数上限"),
    WALK_IN_ROB(3306, "行军被打劫中"),
    WALK_IN_ROB_PROTECT(3307, "行军在打劫保护器内"),
    WALK_BE_ROB_COUNT_LIMIT(3308, "行军被打劫次数达到上限"),
    WALK_ROB_COUNT_LIMIT(3309, "行军打劫次数达到上限"),
    NO_TARGET_HELP_WALK(3310, "木有可帮助的联盟/好友"),
    HAVE_THANKED_RES_HELP(3311, "以感谢帮助"),
    WALK_NO_ENOUGH_SOLIDER(3312, "出去的兵不够"),
    WALK_GROUP_RUN_TYPE_ERROR(3313, "行军类型错误"),
    WALK_GROUP_SAME_ERROR(3314, "行军类型目标重复"),

    // 活动副本(3351-3370)
    QUERY_ACTIVITY_BATTLE_ERR(3351, "活动副本开启表参数不匹配"),
    TIMEOUT_ACTIVITY_BATTLE_ERR(3352, "活动副本不在时间范围内"),
    BEGIN_ACTIVITY_BATTLE_ERR(3353, "活动副本战斗不在时间范围内"),
    BEGIN_ACTIVITY_BATTLE_UNIT_ERR(3354, "该困难等级的副本未开启"),
    BEGIN_ACTIVITY_BATTLE_GRADE_ERR(3355, "上一关卡没有挑战"),
    BEGIN_ACTIVITY_BATTLE_LESS_STRENGTH(3356, "体力不足"),

    // 关卡(3371-3390)
    WORLD_CHECK_POINT_NOT_EXIST(3371, "关卡不存在"),
    WORLD_CHECK_POINT_CAN_NOT_ATK(3372, "关卡不可攻击"),
    HAVE_OCCUPY_WORLD_CHECK_POINT(3373, "已占领关卡"),
    ONLY_ALLIANCE_CAN_OCCUPY_WORLD_CHECK_POINT(3374, "需要有联盟才能占领关卡"),
    NOT_OCCUPY_WORLD_CHECK_POINT(3375, "未占领关卡"),

    // 联盟建筑(3391-3400)
    ONLY_ALLIANCE_CAN_OCCUPY_ALLIANCE_BUILD(3391, "有联盟才能占领联盟建筑"),
    ALLIANCE_LV_ERROR(3392, "联盟等级不足"),
    ALLIANCE_EFFECT_IN_LVUP(3393, "联盟科技正在升级中,无法捐献"),
    ALLIANCE_EFFECT_EXP_MAX(3394, "联盟科技值已达上限"),
    ALLIANCE_EFFECT_DONATE_NO(3395, "捐献次数不足"),
    ALLIANCE_EFFECT_SKILL_EXP_MAX(3396, "科技技能点已达上限"),
    ALLIANCE_EFFECT_SKILL_CD(3397, "科技技能冷却中"),
    ALLIANCE_EFFECT_SKILL_NUM_ERROR(3398, "科技技能点数不足"),
    ALLIANCE_FIRE_CD_ERROR(3399, "灭火CD中"),
    ALLIANCE_BUILD_FORCE_MAX_ERROR(3400, "当前已经有我的增援部队"),

    // 资源矿(3401-3410)
    RES_NOT_EXIST(3401, "资源矿不存在"),
    NOT_IN_ATK_TIME(3402, "不在攻击时间内"),
    NOT_OCCUPY_RES(3403, "未占领资源矿"),
    ONLY_ALLIANCE_CAN_OCCUPY_RES(3404, "需要有联盟才能占领资源矿"),
    HAVE_OCCUPY_RES(3405, "已占领资源矿"),

    // 旗帜(3411-3420)
    NOT_REVENGE_TARGET(3411, "您已失去修改对方旗帜的权力"),
    FLAG_HAS_LOCKED(3412, "您的旗帜已被锁定，无法修改"),
    FLAG_LENGTH_WRONG(3413, "旗帜内容的长度不符"),
    FLAG_TIME_WRONG(3414, "修改太频繁，请稍后再试"),

    // 迁城(3421-3430)
    NOT_IN_NEW_HAND(3421, "不在新手期内"),
    NO_NEW_HAND_MOVE_COUNT(3422, "无新手迁城次数"),
    POS_UNABLE_MOVE(3423, "无法迁城到目标点"),
    ON_ALLIANCE_BUILD(3424, "在联盟领地上"),
    NOT_ON_ALLIANCE_BUILD(3425, "不在联盟领地上"),
    NO_OK_XY(3426, "无可用坐标"),
    WORLD_X_Y_INVALID(3427, "玩家主堡坐标无效"),
    NO_OK_XY_ON_ALIANCE_AREA(3428, "联盟领地上无可用坐标"),

    // 每日三消活动 3431 - 3450
    DAY_ELIMINATE_HOME_INFO_ERROR(3431, "玩家没有三消挑战赛活动数据"),
    DAY_ELIMINATE_TRICE_INFO_ERROR(3432, "三消挑战券不足"),
    DAY_ELIMINATE_BEGIN_FIGHT_TIME_ERROR(3434, "当前阶段不允许开始战斗"),
    DAY_ELIMINATE_END_FIGHT_TIME_ERROR(3435, "当前阶段不允许结算战斗"),
    DAY_ELIMINATE_CLOSE_ERROR(3436, "三消挑战活动未开启"),
    DAY_ELIMINATE_HISTORY_NOT_FIND_ERROR(3437, "找不到这届名人堂数据"),
    DAY_ELIMINATE_SHOP_NOT_FIND_ERROR(3438, "商品不是该主堡等级产出"),
    DAY_ELIMINATE_SHOP_LIMIT_ERROR(3439, "商品购买数量达到上限"),

    // 道具合成 3440-3449当前版本和之前提交的版本重复了
    EXCHANGE_REQ_EMPTY_ERROR(3440, "请求参数为空"),
    EXCHANGE_PARAM_ERROE(3441, "道具参数格式不对"),
    EXCHANGE_NUM_NOT_DIVIDE_ERROR(3442, "合成基数无法整除道具数量"),
    EXCHANGE_ITEM_TYPE_ERROR(3443, "道具合成编号类型不符合合成"),
    EXCHANGE_PROP_TYPE_DENY(3444, "存在道具不可合成"),

    // 天下大势 3461-3470
    WORLD_ACTIVITY_NOT_BALANCE(3461, "天下大势未结算"),
    WORLD_ACTIVITY_REWARDED(3462, "已领取天下大势奖励"),
    WORLD_ACTIVITY_IN_CAN_REWARD(3463, "不在天下大势可领奖名单内"),
    WORLD_ACTIVITY_NOT_REACH(3464, "天下大势未达成"),
    WORLD_ACTIVITY_DENY_YOUNG(3465, "天下大势结算早于玩家出生时间"),

    // 头像框 3471 - 3480
    PHOTO_FRAME_EXISTS(3471, "头像框已经存在"),
    PHOTO_FRAME_NO_EXISTS(3472, "头像框不存在"),

    // 联盟成员援助 3481 - 3490
    WALK_ASSIST_UP_LMT(3481, "超过最大可运输上限"),
    WALK_ASSIST_NO_PLAYER(3482, "找不到目标玩家"),
    WALK_ASSIST_NO_ALLIANCE(3483, "不在同一联盟"),
    WALK_ASSIST_NO_IDENTICAL_PLAYER(3484, "identical目标与当前玩家不一致"),
    WALK_ASSIST_RES_EMPTY(3485, "援助未携带资源"),
    WALK_ASSIST_ACCEPT_LMT(3486, "援助方以达到今日最大值"),
    WALK_ASSIST_RES_ERROR(3487, "援助资源类型错误"),

    // PVE Cloud 4000-4010
    RES_SINGLE_CLOUD_LOCKED(4000, "PVE迷雾未解锁"),
    PVE_CLOUD_UNLOCKED(4001, "PVE迷雾已解锁"),
    PVE_RES_SINGLE_NOT_EXIST(4002, "单点资源未刷新"),
    PVE_RES_SINGLE_CONDITION_MONSTER_FAIL(4003, "单点资源拾取条件之拦路怪未击败"),
    PVE_RES_SINGLE_PICK_UP_ALREADY(4004, "单点资源(不可刷新)已被拾取)"),
    PVE_CLOUD_UNLOCK_FAIL_OF_LORD_POWER_LACK(4005, "领主战力不足无法解锁迷雾"),
    PVE_CLOUD_AREA_BLOCK(4006, "cloudArea条件不满足"),
    PVE_RES_SINGLE_CONDITION_RES_FAIL(4007, "前置资源点未拾取"),
    PVE_RES_SINGLE_CONDITION_DENY_DIRECT_RES(4008, "资源点配置了条件扣费或者条件奖励拒绝首次发-1白嫖奖励"),
    PVE_RES_SINGLE_EXPIRED(4009, "资源点过期了"),
    PVE_CLOUD_AREA_EITHER_CONDITION_NO_SUIT(4010, "迷雾解锁或条件没有1个满足"),


    // 联盟战 4011 - 4050
    ALLIANCE_SOLO_TIME_ERROR(4011, "联盟战CD中"),
    ALLIANCE_SOLO_BUSY_ERROR(4012, "我方已经在联盟战中"),
    ALLIANCE_SOLO_DEF_BUSY_ERROR(4013, "对方已经在联盟战中"),
    ALLIANCE_SOLO_NO_PAY_ERROR(4014, "玩家没有资格进行联盟战"),
    ALLIANCE_SOLO_NO_INFO_ERROR(4015, "联盟不在联盟战中"),
    ALLIANCE_SOLO_NO_IN_FIGHT_TIME_ERROR(4016, "已经过了战斗时间段"),
    ALLIANCE_SOLO_OPP_IN_FIGHT_ERROR(4017, "该玩家正在被战斗中"),
    ALLIANCE_SOLO_OPP_DIE_ERROR(4018, "该玩家已阵亡"),
    ALLIANCE_SOLO_NO_FIGHT_COUNT_ERROR(4019, "玩家战斗次数不足"),
    ALLIANCE_SOLO_NO_ONE_ERROR(4020, "无人可参战"),
    ALLIANCE_EFFECT_FIRST_MAX(4021, "联盟科技优先级设置已达上限"),

    // api禁用 4071 - 4080
    API_FORBID_CHAT(4071, "聊天功能被禁止"),
    API_FORBID_SOCIETY(4072, "社交功能被禁止"),
    API_FORBID_TEXT(4073, "文本修改功能被禁止"),
    API_FORBID_RANK(4074, "排行榜功能被禁止"),
    API_FORBID_PHOTO(4075, "平台头像功能被禁止"),

    // npc城池 4081-4100
    NPC_CITY_FORBID_FIGHT(4081, "Npc城池正在免战中"),
    NPC_CITY_BE_OCCUPIED(4082, "已占领npc城池"),
    NPC_CITY_NOT_OCCUPYING(4083, "npc城池未在占领中"),
    NPC_CITY_NOT_BELONG_SELF(4084, "npc城池还不属于自己联盟"),
    NPC_CITY_OCCUPYING_BY_OTHER(4085, "npc城池被其他联盟占领中"),
    NPC_CITY_OCCUPYING_BY_SELF(4086, "npc城池自己联盟占领中"),
    NPC_CITY_OCCUPY_LIMIT_FOR_NUM(4087, "npc城池数量占领上限"),
    NPC_CITY_OCCUPY_LIMIT_FOR_EFFECT(4088, "同类型npc城池占领达到上限"),
    NPC_CITY_HAVE_IN_GIVE_UP(4089, "npc城池正在舍弃中"),
    NPC_CITY_NOT_IN_GIVE_UP(4090, "npc城池不在舍弃中"),

    // 联盟建筑 4101-4200
    ALLIANCE_BUILD_NOT_OCCUPYING(4101, "联盟建筑未占领"),
    ALLIANCE_MILITARY_PLACE_HAVE_OCCUPY(4102, "军事设施已被己方占领"),
    ALLIANCE_MILITARY_PLACE_OCCUPYING_BY_ENEMY(4103, "军事设施已被敌方占领"),
    ALLIANCE_MILITARY_PLACE_NOT_OCCUPYING(4104, "军事设施未被占领"),
    ALLIANCE_MILITARY_PLACE_MUST_ON_FLAG(4105, "军事设施只能建造在旗帜上"),
    ALLIANCE_FLAG_HAVE_MILITARY_PLACE(4106, "旗帜上已有军事设施"),
    ALLIANCE_MILITARY_PLACE_IN__TEAR_DOWN(4107, "军事设施正在被拆除中"),
    ALLIANCE_MILITARY_PLACE_NOT_IN__TEAR_DOWN(4108, "军事设施不在被拆除中"),
    ALLIANCE_MILITARY_PLACE_FORCE_FULL(4109, "军事设施中部队已满"),
    ALLIANCE_BUILD_NOT_EXIST(4110, "联盟建筑不存在"),
    ALLIANCE_BUILD_STATUS_ERROR(4111, "联盟建筑状态不处于稳定中"),

    // 开服战力排行 5000-5019
    RANK_ACTIVITY_INDEX_ERROR(5000, "索引异常"),
    RANK_ACTIVITY_ACTIVITY_REPEAT(5001, "活动重复"),
    RANK_ACTIVITY_ACTIVITY_STAGE_REPEAT(5002, "活动阶段重复"),
    RANK_ACTIVITY_ACTIVITY_END(5003, "活动已结束"),
    RANK_ACTIVITY_ACTIVITY_STAGE_END(5004, "活动阶段已结束"),
    RANK_ACTIVITY_ACTIVITY_INVALID(5005, "活动状态无效(被异常锁定)"),
    RANK_ACTIVITY_ACTIVITY_STAGE_INVALID(5006, "活动阶段状态无效(被异常锁定)"),
    RANK_ACTIVITY_ACTIVITY_STAGE_GIFT_USE_OUT(5007, "活动阶段礼包限购次数已满"),
    RANK_ACTIVITY_OR_STAGE_NOT_FOUND(5008, "活动或者活动阶段不存在"),

    // 雷达 5020 - 5039
    RADDAR_NOT_OPEN(5020, "雷达功能尚未开启"),
    RADAR_LIGHT_HOUSE_NOT_FOUND(5021, "找不到其他州的灯塔"),
    RADAR_DENY_WALK_RUN_TYPE(5022, "不支持的行军类型"),
    RADAR_TASK_NOT_FOUND(5023, "雷达任务找不到"),
    RADAR_STRATEGY_PRE_FAIL_RESPOINT(5025, "雷达搜索策略资源点根据主堡等级找不到可拾取的模板"),
    RADAR_LV_MAX_ERROR(5026, "雷达已达最大等级"),
    RADAR_LV_PRE_CDT_ERROR(5027, "雷达升级前置条件不满足"),
    RADAR_TASK_TYPE_ERROR(5028, "雷达任务不匹配"),
    RADAR_MONSTER_ELIMINATE_ERROR(5029, "雷达任务怪物类型错误"),
    RADAR_TASK_PICK_ERROR(5030, "雷达捡兵任务不存在"),
    RADAR_REFRESH_COUNT_ERROR(5031, "雷达刷新次数不足"),
    RADAR_REMAIN_COUNT_ERROR1(5032, "雷达任务奖励没有领取完"),
    RADAR_REMAIN_COUNT_ERROR2(5033, "雷达剩余任务没有完成"),
    RADAR_TASK_NOT_REMAIN(5034, "雷达没有剩余任务可以做了"),
    RADAR_TASK_NOT_EXIST(5035, "雷达任务不存在, 已经完成或者被删除"),
    RADAR_TASK_OVERDUE(5036, "雷达任务已经过期"),

    // pvp地图迷雾 5070-5089
    CANT_CHECK_REGION(5076, "无法检测连通性"),
    CHECK_REGION_ERROR(5077, "非连通区域"),
    PHOTO_PROP_RECYCLING(5082, "头像道具被回收"),
    FRAME_PROP_RECYCLING(5083, "头像框道具被回收"),
    SKIN_RECYCLING(5085, "主堡皮肤被回收"),
    LORD_SKIN_RECYCLING(5086, "玩家皮肤被回收"),

    // 区域检测 5091-5100
    REGION_NOT_LINK_STATE(5091, "玩家所在出生洲不可达此高级洲"),
    REGION_NO_MOVE_CITY_SAFE(5092, "其他出生州的玩家主堡不可迁入该安全区"),
    REGION_NO_ALLI_BUILD_SAFE(5093, "其他出生州的联盟的联盟建筑不可在该安全区建造"),
    REGION_NO_WALK_PVP_SAFE(5094, "其他出生州的玩家不可派遣任何部队至安全区"),
    REGION_NO_MOVE_CITY_PK(5095, "他出生州的玩家主堡不可迁入该PK区"),
    REGION_NO_ALLI_BUILD_PK(5096, "其他出生州的联盟的联盟建筑不可在该PK区建造"),
    REGION_BORN_STATE_NO_STATUS(5097, "前往其他出生洲的非状态区域"),

    // 地块搜索5101 ~ 5110
    SEARCH_CELL_EMPTY(5101, "查找不到该类地块"),
    SEARCH_CELL_NO_FREE_NEAR_OPEN(5102, "主堡附近且在视野内找不到空地无法刷新魔物"),

    // 夺宝奇兵5111 ~ 5120
    ACT_TURN_TABLE_CLOSED(5111, "夺宝奇兵活动未开启"),
    ACT_TURN_TABLE_CACHE_ERROR(5112, "夺宝奇兵活动数据找不到"),
    ACT_TURN_TABLE_COUNT_LMT(5113, "卡片全部抽完，需刷新"),
    ACT_TURN_TABLE_PLAY_REPEAT(5114, "这个位置的抽过了"),
    ACT_TURN_TABLE_REFRESH_LMT(5115, "刷新已达上限"),
    ACT_TURN_TABLE_LOTTERY_LMT(5116, "lottery没有达到turntable前置要求"),
    ACT_TURN_TABLE_COUNT_LMT2(5117, "lottery次数不足"),
    ACT_TURN_TABLE_REPLACE_EMPTY(5118, "lottery没有选择奖池"),
    ACT_TURN_TABLE_REPLACE_ERROR(5119, "lottery奖池中找不到掉落id"),

    // 冲榜活动5121~5130
    ACT_PARTPOINT_CLOSED(5121, "活动未开启"),
    ACT_PARTPOINT_NO_CACHE(5122, "冲榜活动找不到玩家记录"),
    ACT_PARTPOINT_REWARD_REPEAT(5123, "冲榜活动此奖励已经领取"),
    ACT_PARTPOINT_REWARD_ERROR(5124, "冲榜活动此奖励postion传递错误"),
    ACT_PARTPOINT_REWARD_CDT(5125, "冲榜活动此奖励完成条件不足"),
    ACT_PARTPOINT_REWARD_ALLIANCE(5126, "冲榜活动此奖励需要联盟"),
    ACT_PARTPOINT_REWARD_ALLIANCE_TIME(5127, "冲榜活动此奖励达成时间低于加入联盟时间"),
    ACT_MITTARY_SCORE_CLOSED(5128, "军事备战活动关闭"),
    ACT_MITTARY_SCORE_POOR(5129, "军事备战活动积分不足"),
    ACT_MITTARY_SCORE_REPEATED(5130, "军事备战活动阶段奖励重复领取"),

    // 平判之乱5131-5140
    ARMY_ACTIVITY_OPEN_TIME_ERROR(5131, "时间不允许开启平判之乱"),

    // 联盟调整 5141-5150
    ACT_ALLIANCE_RECRUIT_CD(5141, "联盟招募冷却中"),
    ACT_ALLIANCE_RECRUIT_TIMES(5142, "联盟次数传递异常"),
    ACT_ALLIANCE_THUMBS_UP_REPEATED(5143, "联盟点赞，该聊天已被点赞"),
    ACT_ALLIANCE_THUMBS_UP_MINE(5144, "联盟点赞，不可给自己点赞"),


    // 联盟boss 5150-5170
    NEW_BOSS_NO_AREA(5150, "没有演武场"),
    NEW_BOSS_IS_OPEN(5151, "boss已开启"),
    NEW_BOSS_FAIL(5152, "boss入库失败"),
    NEW_BOSS_DICT_ERR(5153, "xml数据错误"),
    NEW_BOSS_OPEN_CD(5154, "boss开启cd中"),
    NEW_BOSS_OVER_PRETIME(5155, "超过最大预约时间"),
    CANNOT_CREATE_YANWU_BUILD(5156, "建造演武场时间未到"),
    OPENTIME_IN_CD_LIMIT(5158, "预约时间在cd时间之内"),
    NEW_BOSS_MAX_DONATE(5159, "已达到最大捐献"),

    DESTROY_BUILD_CANNOT_OPEN(5160, "演武场拆除中，不可以开启boss"),
    BOSS_OPEN_CANNOT_DESTROY_BUILD(5161, "boss开启中，不可以拆除演武场"),
    ALLIANCE_WORLD_WONDER_NO_IN_APPLY(5162, "当前不在奇观战报名期间"),
    ALLIANCE_WORLD_WONDER_APPLY_MAX(5163, "主动报名个数已达到上限"),
    ALLIANCE_WORLD_WONDER_APPLY_MEMBER_NUM_ERROR(5164, "未达到报名所需人数"),
    ALLIANCE_WORLD_WONDER_APPLY_ERROR(5165, "未报名"),
    NEWBOSS_DICCICULTY_OR_LV_ERROR(5166, "难度或等级不对"),
    NEWBOSS_NO_BUILDING_ERROR(5167, "boss对应的建筑不存在"),
    ALLIANCE_WORLD_WONDER_REWARD_NO_ENPUGH_ERROR(5168, "没有足够的礼物发送了"),
    ALLIANCE_WORLD_WONDER_REWARD_MAX_ERROR(5169, "超过给单个玩家的分配上限值"),
    LAST_BOSS_IS_NOT_DEAD(5170, "上一个boss还没死"),
    NO_CHARGE_BUFF(5171, "buff数量不足"),
    ALLIANCE_BIG_WORLD_WONDER_NO_IN_APPLY(5172, "大奇观未开启"),
    ALLIANCE_WORLD_WONDER_NOT_CANCEL_APPLY(5173, "自动报名的奇观无法取消报名"),
    NEW_BOSS_NOT_OPEN(5174, "boss未开启"),

    // 神庙 5175-5195
    HIERON_IN_PEACE(5175, "神庙在保护状态"),
    HIERON_NOT_OPEN(5176, "神庙未开启"),
    ONLY_ALLIANCE_CAN_OCCUPY_HIERON(5177, "只有联盟才能占领神庙"),
    HAVE_OCCUPY_HIERON(5178, "已经被联盟占领"),
    HIERON_HAVE_NO_SOILDER(5179, "神庙中没有不对"),

    ALLIANCE_MAIN_PLAYER_CANNOT_TP_ALLIANCE_MOVE(5180, "盟主不可以联盟传送"),
    CANNOT_MOVE_CITY_FOR_MASS(5181, "集结时不可以迁城"),
    CANNOT_MOVE_CITY_FORCE_OUTSIDE(5182, "有部队在外面时不可以迁城"),

    // map 5196-5205
    MAP_AREA_BELONG_ERROR(5196, "根据坐标没找到对应所属区域"),

    // 资源点天降鸿运
    RES_POINT_TAKE_MULTI_NOT_EXIST(5206, "资源点天降鸿运不存在"),

    CANNOT_MASS_NORMALMONSTER(5213, "先把中怪对应的小怪打死"),
    CANNOT_MASS_BOSS(5214, "先把小怪和中怪物打死"),
    BEGIN_FIGHT_ERR(5218, "开始战斗时传入的参数错误"),
    MAIN_PLAYER_CAN_KICK(5219, "队长才能踢人和解散"),
    CANNOT_SLG_SMALL_MONSTER(5224, "不能slg小怪"),

    // 神庙拜访(5230 -5240)
    RECEIVE_TIME_NOT_ARRIVE(5231, "领取任务时间未到"),
    RECEIVE_COUNT_LIMIT(5232, "领取任务次数超上线"),
    VISIT_QUEST_ERR(5233, "数据错误"),
    INFORMATION_REFRESH_LIMIT(5234, "情报刷新时间未到"),
    ALREADY_RECEIVE_TASK(5235, "任务已领取"),
    NOT_RECEIVE_TASK(5236, "没有领取任务"),
    ALREADY_RECEIVE_INFOMATION(5237, "已经领过了情报"),
    CANNOT_SUBMIT_TASK(5238, "情报还在沙盘，无法交任务"),

    // 日月王城错误码(5250-5270)
    CAPITAL_BATTLE_HAVE_OFFICER(5250, "已经有职位了"),
    CAPITAL_BATTLE_SET_KING_TIME_OVER(5251, "已经过了设置国王的时间了"),
    CAPITAL_BATTLE_OFFICER_STEP_ERROR(5252, "操作权限不足"),
    CAPITAL_BATTLE_SKILL_CD_ERROR(5253, "日月王城技能CD未到"),
    CAPITAL_BATTLE_SKILL_COUNT_ERROR(5254, "日月王城技能达到次数上限"),
    CAPITAL_BATTLE_KING_MONEY_ERROR(5255, "国王币不足"),
    CAPITAL_BATTLE_NO_GIFT_ERROR(5256, "日月王城礼包已经送完"),
    CAPITAL_BATTLE_HAVE_GIFT_ERROR(5257, "日月王城礼包已经送给过该玩家"),
    CAPITAL_BATTLE_BUFF_NO_WALK_ERROR(5258, "被上了国王禁锢 无法对其他玩家/建筑发起进攻或参与集结"),
    CAPITAL_BATTLE_DIOSMISS_ERROR(5259, "联盟是日月王城主人并且当前正在选国王期间不允许解散联盟"),
    CAPITAL_BATTLE_OFFICER_CD_ERROR(5260, "日月王城职位操作冷却中"),
    CAPITAL_BATTLE_OFFICER_MORE_ERROR(5261, "该玩家已经有职位"),
    CAPITAL_BATTLE_ONLY_FIGHT_ONE_ERROR(5262, "玩家一次只能参与一座王城相关建筑的玩法"),

    // 平台能力(5271-5279)
    PLATFORM_ABILITY_ERROR(5271, "平台能力功能封禁"),

    // 聊天气泡 5280-5289
    CHAT_BUBBLE_NOT_EXIST(5280, "聊天气泡不存在"),
    CHAT_BUBBLE_EXIST(5281, "已有此聊天气泡"),

    // 邮件 5290-5295
    MAIL_ATTACH_NUM_ERROR(5290, "邮件附件道具异常"),
    MAIL_NOT_FOUND(5291, "邮件找不到"),
    MAIL_HAVE_DELETED(5293, "邮件已删除"),

    // 在线活动 5296-5299
    ONLINE_HERO_NOT_OPEN(5296, "不在活动范围内"),
    ONLINE_HERO_DATA_ERR(5297, "领取失败"),
    ONLINE_HERO_CANNOT_REWARD(5298, "暂且不能领奖"),

    // 联盟宝藏 5300-5320
    ALLIANCE_TREASURE_JOIN_TIME_ERRPR(5300, "加入联盟时间不足 无法挖掘或者帮助"),
    ALLIANCE_TREASURE_WORK_COUNT_ERRPR(5301, "今日挖掘次数不足"),
    ALLIANCE_TREASURE_NO_ERRPR(5302, "找不到宝藏数据"),
    ALLIANCE_TREASURE_NO_FIND_ERRPR(5303, "找不到被操作的宝藏数据"),
    ALLIANCE_TREASURE_STATE_ERRPR(5304, "宝藏状态错误"),
    ALLIANCE_TREASURE_HAVE_HELP_ERRPR(5305, "宝藏已经被其他玩家帮助过了"),
    ALLIANCE_TREASURE_QUICK_ERRPR(5306, "无法加速不是你帮助的宝藏"),
    ALLIANCE_HELP_MAX_ERRPR(5307, "无法同时帮助多个宝藏"),
    ALLIANCE_WORD_NEED_CLEAR_ERRPR(5308, "领取掉了你的宝藏之后才可以继续挖掘"),
    ALLIANCE_TREASURE_REWARD_TIME_ERRPR(5309, "宝藏还无法领取"),
    ALLIANCE_TREASURE_NO_HELP_ERRPR(5310, "宝藏没有人帮助已失效"),
    ALLIANCE_TREASURE_REWARD_OVER_ERRPR(5311, "宝藏已被领取"),
    ALLIANCE_TREASURE_HELP_COUNT_ERRPR(5312, "今日宝藏帮助次数不足"),
    ALLIANCE_JOIN_CD_ERRPR(5313, "加入联盟CD中"),

    // 龙族宝藏（新版推图） 5320-5339
    EXPEDITION_PRE_ERROR(5338, "远征--前置关卡的条件不满足"),
    EXPEDITION_LV_ERROR(5339, "远征--当前关卡不可选择, 同一层只能打一个"),
    EXPEDITION_LV_REPEATED_ERROR(5340, "远征--当前关卡已经打过了"),

    // 条件解锁 5340-5349
    UNLOCK_CONDITION_BUILD_LV(5342, "前置条件--建筑等级不足"),
    UNLOCK_CONDITION_LORD_LV(5343, "前置条件--领主等级不足"),
    UNLOCK_CONDITION_TASK(5344, "前置条件--章节不足"),
    UNLOCK_CONDITION_HERO_LV(5345, "前置条件--英雄等级不足"),
    UNLOCK_CONDITION_EXPEDITION(5346, "前置条件--远征层数不足"),
    UNLOCK_CONDITION_VIP_LV(5347, "前置条件--vip等级不足"),
    UNLOCK_CONDITION_CP_TOWER(5348, "前置条件--龙塔关卡不足"),
    UNLOCK_CONDITION_OPEN_SERVER(5349, "前置条件--开服天数不满足"),

    // 英雄委任
    HERO_APPOINT_BUSY(5400, "当前英雄已在其他位置被委任"),
    HERO_APPOINT_SAME(5401, "当前英雄已在此位置被委任,无需重复操作"),
    HERO_APPOINT_DENY(5402, "当前英雄无法委任在此位置"),
    HERO_APPOINT_FUNC(5403, "当前委任位置没有投放"),

    // 内城区域错误码5450 ~ 5479
    INNER_CITY_AREA_ALREADY_CLEAN(5450, "内城区域已净化"),
    INNER_CITY_AREA_PRE_NOT_CLEAN(5451, "内城区域前置区域未净化"),
    INNER_CITY_AREA_CLOUD_AREA_LEFT(5455, "内城区域迷雾未全部清理"),
    INNER_CITY_AREA_NOT_UNLOCK(5456, "内城区域未解锁"),
    INNER_CITY_AREA_NOT_CLEAN(5457, "内城区域未净化"),
    PVE_RANDOM_EVENT_NOT_DRAW(5458, "Pve随机事件未拾取"),
    PVE_RES_SINGLE_WAR_EITHER_NO_SUIT(5459, "Pve资源点前置或条件全部不满足"),
    PVE_IN_CITY_BUILDING_WAR_LACK(5460, "内城建筑三消战斗未通过"),


    // 内城区域错误码5480 ~ 5490
    ACT_SIGN_CLOSED(5480, "签到活动未开启"),

    // 领主装备 5500-5549
    LORD_EQUIP_MODULE_LOCK(5500, "领主装备功能未开启"),
    LORD_EQUIP_CLASS_LOCK(5501, "领主装备套装未开启"),
    LORD_EQUIP_POSITION_LOCK(5502, "领主装备部位未开启"),
    LORD_EQUIP_PRE_CDT_ERROR(5503, "领主装备升级的前置条件没有达到"),
    LORD_EQUIP_LV_TOUCH_LORD_LV(5504, "领主装备锻造等级不能超出领主等级"),
    LORD_EQUIP_STRENGTH_LV_TOUCH_LV(5505, "领主装备强化等级不能超过锻造等级"),
    LORD_EQUIP_STRENGTH_NONE(5506, "领主装备强化未获得对应装备"),
    LORD_EQUIP_UP_NOT_OPENING_TIME(5507,"该等级领主装备未到达开启时间，无法强化"),
    LORD_EQUIP_BADGE_UP_NOT_OPENING_TIME(5508,"该等级领主装备徽章未到达开启时间，无法强化"),

    // 幸运折扣 5550 ~ 5599
    LUCKY_DISCOUNT_ACTIVITY_NOT_OPEN(5550, "幸运折扣活动未开启"),
    LUCKY_DISCOUNT_ACTIVITY_MULTIPLE_OPEN(5551, "幸运折扣活动同时开了多个"),
    LUCKY_DISCOUNT_DATA_EXPIRE(5552, "幸运折扣活动数据过期"),
    LUCKY_DISCOUNT_DATA_EXPIRE2(5553, "幸运折扣活动数据不在刷新有效期"),
    LUCKY_DISCOUNT_BUY_NOT_FOUND(5554, "幸运折扣购买的商品不存在"),
    LUCKY_DISCOUNT_BUY_ALREADY(5555, "幸运折扣商品已购买"),

    // 迷宫 5600-5620
    LABYRINTH_INIT_ERROR(5600, "迷宫奖池初始化错误"),
    LABYRINTH_MAX_FLOOR(5601, "迷宫奖池已到顶层，不能再roll"),
    LABYRINTH_ALREADY_ROLL(5602, "已经roll过，不能再roll"),
    LABYRINTH_AUTO_ERR(5603, "一键失败"),

    // 七日三消 5621 - 5630
    FESTIVAL_BOSS_ERR(5621, "七日boss不存在"),
    FESTIVAL_BOSS_ENERGY_NOT_ENOUGH(5622, "七日boss三消体力不足"),
    FESTIVAL_BOSS_ATK_NUM_NOT_ENOUGH(5623, "七日boss三消攻击次数不足"),

    // 荣耀战场 5631 - 5649
    BATTLE_FIELD_PERSON_APPLY_TIME_ERR(5631, "个人报名时间味道"),
    BATTLE_FIELD_PERSON_NO_ALLIANCE(5632, "玩家不在联盟内"),
    JOIN_ALLIANCE_TIME_ERR(5633, "报名期之前未加入联盟，无法报名本次荣耀战场"),
    CASTLE_LV_ERR(5634, "主堡等级不够，无法个人报名"),

    // 联盟超级矿 5650-5659
    ALLIANCE_MINE_BUILD_COUNT_ERROR(5651, "联盟超级矿次数不足"),
    ALLIANCE_MINE_HUOYUE_ERROR(5652, "联盟活跃度不足"),
    ALLIANCE_MINE_TARGET_ERROR(5654, "联盟不一致"),
    ALLIANCE_MINE_GROUP_ERROR(5655, "联盟超级矿已经有自己的部队在采集了"),
    ALLIANCE_MINE_BUILD_LMT_ERROR(5656, "联盟超级矿可建造数量已达上限"),

    // 队列 5700-5739
    QUEUE_NOT_EXIST(5700, "队列不存在"),
    QUEUE_NOT_AVAILABLE(5701, "暂无可用队列"),

    // 盟主征途 5740 - 5759
    ALCE_LEADER_JOURNEY_NOT_OPEN(5740, "盟主征途资格不满足"),
    ALCE_LEADER_JOURNEY_DRAW_REPEAT(5741, "盟主征途重复领取大奖"),
    ALCE_LEADER_JOURNEY_DRAW_TASK_MISS(5742, "盟主征途领取大奖时有任务不是已领取状态"),

    // 英雄推荐 5760 - 5769
    HERO_RECOMMEND_ELI_BOX_ALREADY_DRAW(5760, "英雄推荐三消宝箱已领取"),
    HERO_RECOMMEND_SLG_BOX_ALREADY_DRAW(5761, "英雄推荐slg宝箱已领取"),

    // 铁匠铺 5770 ~ 5779
    SMITHY_EXCHANGE_SPLIT_DENY_COMPOUNT(5770, "铁匠铺目标道具不支持合成"),
    SMITHY_EXCHANGE_SPLIT_DENY_SPLIT(5771, "铁匠铺目标道具不支持分解"),

    // 兵营 5780 ~ 5849
    BARRACKS_QUICK_CALC_COST_RES_TYPE_BEYOND(5780, "兵营快速征兵的资源消耗存在不支持的类型"),
    BARRACKS_QUICK_CALC_FILL_RES_ERR(5781, "兵营快速征兵补齐资源时出现未知的逻辑错误导致计算资源卡扣除方案失败"),
    BARRACKS_QUICK_CALC_FILL_TIME_ERR(5782, "兵营快速征兵计算加速时出现未知的逻辑错误导致计算道具扣除方案失败"),
    BARRACKS_QUICK_CALC_BAG_PROP_RES_USE_GET_ERR_1(5783, "兵营快速征兵计算资源卡资源遇到useGet配置种类不是1"),
    BARRACKS_QUICK_CALC_BAG_PROP_RES_USE_GET_ERR_2(5784, "兵营快速征兵计算资源卡资源遇到useGet配置种类超出支持范围"),
    BARRACKS_QUICK_CALC_HAVE_RES_ERR(5785, "兵营快速征兵计算身上已有资源时出现资源类型转换不存在"),
    BARRACKS_QUICK_CALC_SPEED_TIME_OVERFLOW(5786, "兵营快速征兵计算加速时数据溢出"),
    BARRACKS_QUICK_MAKE_DENY_WHILE_WELCOME(5787, "兵营快速造兵在新手次数未用掉时不可用"),
    BARRACKS_QUICK_TIME_LACK(5788, "兵营快速征兵加速不足"),
    BARRACKS_QUICK_RES_LACK(5789, "兵营快速征兵特定资源类型不足"),
    BARRACKS_QUICK_EXPECT_TIME_PROPS_CHANGE(5790, "兵营快速征兵加速道具方案发生变更需重新请求查询"),
    BARRACKS_QUICK_EXPECT_RES_PROPS_CHANGE(5791, "兵营快速征兵资源道具扣除方案发生变更需重新请求查询"),
    BARRACKS_REFUGE_CANCEL_CD(5792,"避难所召回处于CD中"),
    BARRACK_REFUGING_ALREADY(5793, "避难所已存在兵团,需要等避难结束或主动召回后再操作避难"),

    // 英雄一键升级 5890~5919
    HERO_ONE_KEY_UP_NO_EXP(5890, "英雄一键升级身上既无经验池也无经验道具"),
    HERO_ONE_KEY_UP_NO_CAN(5892, "英雄一键升级当前既无法升级也无法突破"),
    HERO_ONE_KEY_UP_LOGIC_FAIL(5893, "英雄一键升级模拟升级出错"),
    HERO_ONE_KEY_UP_COST_EXP_FAST_FAIL_OF_LACK(5894, "英雄一键升级经验计算不足"),
    HERO_ONE_KEY_UP_COST_EXP_FAST_DENY_NULL(5895, "英雄一键升级经验计算空值"),
    HERO_ONE_KEY_UP_COST_EXP_LOGIC_FAIL(5896, "英雄一键升级经验计算出错"),
    HERO_ONE_KEY_UP_NOT_EXPECT_LV(5897, "英雄一键升级等级非预期"),
    HERO_ONE_KEY_UP_NOT_EXPECT_BREAK_LV(5898, "英雄一键升级突破等级非预期"),
    HERO_ONE_KEY_UP_NOT_EXPECT_ELI_SKILL(5899, "英雄一键升级三消技能非预期"),
    HERO_ONE_KEY_UP_NOT_EXPECT_COST_EXP(5900, "英雄一键升级经验消耗非预期"),
    HERO_ONE_KEY_UP_NOT_EXPECT_BREAK_PROPS(5901, "英雄一键升级突破道具消耗非预期"),
    HERO_ONE_KEY_UP_NOT_EXPECT_EXP_PROPS(5902, "英雄一键升级经验道具消耗非预期"),
    HERO_ONE_KEY_UP_NOT_EXPECT_BACK_EXP(5903, "英雄一键升级返还经验非预期"),

    // 联盟补给 5920~5929
    ALLIANCE_SUPPLY_NOT_SUPPORT(5921, "联盟补给--该资源类型暂不支持"),
    ALLIANCE_SUPPLY_RES_NOT_IDLE(5922, "联盟补给--该补给处于cd中"),
    ALLIANCE_SUPPLY_RES_CANNOT_RECEIVE(5923, "联盟补给--没有资源可以领取"),
    ALLIANCE_SUPPLY_RES_GIE_ERROR(5924, "联盟补给--当前状态不可以被赠予, 已过期"),
    ALLIANCE_SUPPLY_RES_GIE_ERROR2(5925, "联盟补给--当前状态不可以被赠予， 对方可接收数量为0"),
    ALLIANCE_SUPPLY_RES_REQUEST_ERROR(5926, "联盟补给--发起请求没有效果"),

    // 联盟BOSS斗兽场 5931~5945
    ALLIANCE_COLOSSEUM_BUILD_ERROR(5931, "联盟斗兽场——建造开服时间没达到"),
    ALLIANCE_COLOSSEUM_BUILD2_ERROR(5932, "联盟斗兽场——没有前置建筑"),
    ALLIANCE_COLOSSEUM_STRATEGY_ERROR(5933, "策略错误"),
    ALLIANCE_COLOSSEUM_DONATE_MAX(5934, "联盟斗兽场--已达可捐献最大值"),
    ALLIANCE_COLOSSEUM_OPEN_ERROR(5935, "联盟斗兽场--已经有预约或者打开的boss了"),
    ALLIANCE_COLOSSEUM_BOSS_CD_ERROR(5936, "联盟斗兽场--处于cd中"),
    ALLIANCE_COLOSSEUM_BOSS_LV_ERROR(5937, "联盟斗兽场--前置击杀等级不足"),
    ALLIANCE_COLOSSEUM_BOSS_FIGHT_ERROR(5938, "联盟斗兽场--boss状态不对"),
    ALLIANCE_COLOSSEUM_JOIN_TIME_ERROR(5939, "联盟斗兽场--入盟时间不足"),
    ALLIANCE_COLOSSEUM_TIME_ERROR2(5940, "联盟斗兽场--预约时间不对"),
    ALLIANCE_COLOSSEUM_BUILD_REMOVE_ERROR(5941, "联盟斗兽场--当前建筑不可以拆除"),
    ALLIANCE_COLOSSEUM_START_MASS_ERROR(5942, "联盟斗兽场--集结时间大于boss小时时间"),

    // 恐龙 5946-5960
    DINOSAURS_STATE_ERRO(5946, "恐龙状态异常,无法更改其状态"),
    DINOSAURS_NOT_IN_BREED(5947, "恐龙状态异常,不处于圈养中"),

    // 日志查询错误码
    QUERY_LOG_SERVER_ERR(9000, "查询过程中出现错误"),
    QUERY_LOG_AT_START_TIME_ERR(9001, "日志开始时间格式错误(YYYY-MM-DD HH:MM:SS)"),
    QUERY_LOG_AT_END_TIME_ERR(9002, "日志结束时间格式错误(YYYY-MM-DD HH:MM:SS)"),
    QUERY_LOG_START_END_TIME_ERR(9003, "日志开始时间不能大于结束时间"),
    QUERY_LOG_ARGS_NOT_INTEGER(9004, "参数不能转换成整数类型"),
    QUERY_LOG_ARGS_PAGE_ERR(9005, "查询参数【当前页】错误"),
    QUERY_LOG_ARGS_COUNT_ERR(9006, "查询参数【每页显示记录数】错误"),

    SERVER_INTERNAL_ERR(9999, "服务端错误（多数可能是因为panic产生的不好发现的错误）"),

    GM_MSG_AT_ERROR_STATE(10001, "GM消息发送在错误的状态"),
    GM_CMD_NO_PERMISSON(10002, "GM权限不足"),

    PROCESS_ERROR_PROTO_INIT_FAILED(10010, "模板初始化失败"),
    PROCESS_ERROR_DB_INIT_FAILED(10011, "数据库初始化失败"),
    PROCESS_ERROR_LOG_CONNECT_INIT_FAILED(10012, "日志服连接初始化失败"),
    PROCESS_ERROR_DC_INIT_FAILED(10013, "数据中心连接失败"),
    PROCESS_ERROR_EXIST_AREAS_START_FAILED(10014, "初始游戏区启动失败"),
    PROCESS_ERROR_GENERATE_TABLE_FINISHED(10015, "数据库表重建结束（这个不是错误，但生产环境绝对不能出现这个！）"),
    PROCESS_ERROR_RPC_PORT_CANT_BIND(10016, "RPC端口无法绑定"),
    PROCESS_ERROR_ETCD_CANT_ACCESS(10017, "etcd无法访问"),
    PROCESS_ERROR_NO_VALID_RPC_SERVICE(10018, "无法找到可用的rpc服务"),
    PROCESS_ERROR_CANT_ACCESS_RPC_SERVICE(10019, "无法访问目标rpc服务"),
    PROCESS_ERROR_RPC_RT_FAILED(10020, "rpc返回失败"),
    PROCESS_ERROR_RPC_REG_ERROR(10021, "rpc服务注册失败"),
    PROCESS_ERROR_MSG_CONSUME_INIT_FAILED(10022, "消息消费初始化失败"),
    PROCESS_ERROR_MSG_PRODUCE_INIT_FAILED(10023, "消息生产初始化失败"),
    PROCESS_ERROR_RPC_EXCEPTION(10024, "服务不可用"),
    PROCESS_ERROR_BATTLE_SERVICE_ERROR(10025, "战斗服务BattleService不可用"),
    PROCESS_ERROR_RPC_KEEP_ALIVE_ERROR(10026, "rpc服务续约失败"),
    PROCESS_ERROR_BATTLE_SERVICE_CHANNEL_ERROR(10027, "战斗服务Channel不可用"),

    ADD_NEW_AREA_PARAM_ERROR(11000, "加区参数错误"),
    ADD_NEW_AREA_DB_ERROR(11001, "加区无法连接数据库"),
    ADD_NEW_AREA_CODE_VERSION_ERROR(11002, "加区代码版本错误"),
    ADD_NEW_AREA_CREATE_TABLE_ERROR(11003, "加区创建表错误"),
    ADD_NEW_AREA_DB_EXIST(11004, "加区，目标数据库已经存在"),
    FETCH_AREA_BASE_ERROR(11005, "不存在的AreaId"),

    SWITCH_M_AREA_NOT_RUNNING(11100, "切换维护状态时，发现游戏区尚未运行"),

    STOP_AREA_NOT_RUNNING(11200, "关停游戏区时，发现游戏区尚未运行"),
    STOP_AREA_CLOSE_TIME_OUT(11201, "关服超时"),

    HEART_OVER_AT_HOME(11301, "心跳已经在Home提前结束"),

    FUNCTION_BANNED(12000, "功能被禁用"),

    REDIS_INIT_FAILED(13000, "Redis初始化失败"),

    ASK_ERROR1(14000, "目标服务器异常--ERR报错"),
    WHILE_CANT_STOP(14001, "死循环"),
    DEAL_BUT_NO_PLAYER(14002, "执行，但没有找到玩家"),
    DEAL_BUT_NO_SESSION(14003, "执行，但没有找到会话"),
    DEAL_BUT_SERVER_NOT_RUNNING(14004, "执行，但服务器尚未准备好"),
    PRE_CREATE_PLAYER_ALL_USED(14005, "预创建角色全部用完了"),
    PRE_CREATE_PLAYER_NOT_FOUND(14006, "预创建角色找不到"),
    CLIENT_VERSION_TOO_LOW(14007, "客户端版本过低"),

    // 登录服错误码
    LOGIN_USER_NOT_FOUND(20001, "找不到账号"),
    LOGIN_PLAYER_NOT_FOUND(20002, "找不到账号下的角色"),

    REALM_SDK_ERROR(20007, "登录SDK验证失败"),
    REALM_SDK_ACCESS_TOKEN_CHECK_ERROR(20008, "令牌验证失败"),
    REALM_SDK_TOKEN_OVER_TIME(20009, "访问令牌过期"),

    REALM_SDK_TOKEN_HTTP_FAILED(20016, "无法完成令牌验证"),
    PAY_HANDLER_NOT_FOUND(20017, "服务端未注册该支付类型"),
    PAY_PARSE_PARAM_ERROR(20018, "传入参数错误"),
    PAY_ORDER_STATUS_ERROR(20019, "订单状态错误"),
    PAY_SIGN_KEY_NOT_FOUND(20020, "找不到指定签名验证类型的密钥"),
    PAY_SIGN_NOT_MATCH(20021, "签名不匹配"),
    PAY_GOOGLE_ACCESS_TOKEN_ERROR(20022, "服务端访问谷歌平台失败"),
    PAY_GOOGLE_PURCHASE_NOT_FOUND(20023, "找不到谷歌订单"),
    PAY_GOOGLE_PURCHASE_STATE_ERROR(20024, "谷歌订单状态异常"),

    LOGIN_NO_INFO_BY_AREA_AND_PARTITION(20081, "登录服收到的登录请求找不到区服数据了"),
    GATE_NO_INFO_BY_AREA_AND_PARTITION(20082, "网关服收到的登录请求找不到区服数据了"),

    TENCENT_UGC_CHANGENAME_COUNT_MAX_ERROR(20089, "ugc操作昵称修改太过频繁"),
    TENCENT_UGC_CHANGEPHOTO_COUNT_MAX_ERROR(20090, "ugc操作头像修改太过频繁"),
    TENCENT_UGC_ADDFRIEND_COUNT_MAX_ERROR(20091, "ugc操作添加好友太过频繁"),
    TENCENT_UGC_WORLDCHAT_COUNT_MAX_ERROR(20092, "ugc操作世界重复发言太过频繁"),
    ;

    // 聊天服错误码

    companion object : EnumConverter<Int, ResultCode>(buildValueMap(ResultCode::code)) {

        fun fromCode(value: Int): ResultCode {
            val msgType = fromValue(value)
            if (msgType == null) {
                return UNKOWN_ERROR
            }
            return msgType
        }
    }
}
