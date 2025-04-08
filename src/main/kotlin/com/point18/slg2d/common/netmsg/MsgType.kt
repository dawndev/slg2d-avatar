package com.point18.slg2d.common.netmsg

import com.google.protobuf.MessageLite
import com.point18.slg2d.lang.EnumConverter
import com.point18.slg2d.lang.buildValueMap
import pb4client.*

// 找到消息号，才能根据消息号进行编码和解码
enum class MsgType(val msgType: Int, val req: MessageLite?, val resp: MessageLite) {

    // --- 机器人专用消息号
    Connected(10000, null, LoginRt.getDefaultInstance()),
    Disconnected(10001, null, LoginRt.getDefaultInstance()),
    CLUSTER_ARRAY(10021, null, LoginRt.getDefaultInstance()), // 获取集群信息
    CLUSTER_SELECT(10022, null, LoginRt.getDefaultInstance()), // 选择服务器
    ROBOT_IDLE(10023, null, LoginRt.getDefaultInstance()), // 空闲
    // --- 机器人专用消息号

    Unknown_Msg_20001(20001, null, LoginRt.getDefaultInstance()),

    Login_1(1, Login.getDefaultInstance(), LoginRt.getDefaultInstance()), // 发送登录消息，包括账号和密码
    MakeCity_2(2, MakeCity.getDefaultInstance(), MakeCityRt.getDefaultInstance()), // 创建城池
    EnterGame_4(4, EnterGame.getDefaultInstance(), EnterGameRt.getDefaultInstance()), // 进入游戏
    EnterGameHome_5(5, EnterGameHome.getDefaultInstance(), EnterGameHomeRt.getDefaultInstance()),  // 登录玩家服
    CheckWord_6(6, CheckWord.getDefaultInstance(), CheckWordRt.getDefaultInstance()), // 检测屏蔽字
    LoginSDKBindInfo_7(7, LoginSDKBindInfo.getDefaultInstance(), LoginSDKBindInfoRt.getDefaultInstance()), // 登录SDK绑定信息
    LoginSDKBinding_8(8, LoginSDKBinding.getDefaultInstance(), LoginSDKBindingRt.getDefaultInstance()), // 绑定登录SDK
    ClearPaySuccessNotice_9(9, ClearPaySuccessNotice.getDefaultInstance(), ClearPaySuccessNoticeRt.getDefaultInstance()),  // 已打点，清除支付成功通知

    // important 协议号14 WebLogin / WebLoginRt 的相关对象有其他地方调用，不要用
    Walk_15(15, Walk.getDefaultInstance(), WalkRt.getDefaultInstance()), // 部队行军
    PersonalPower_17(17, PersonalPower.getDefaultInstance(), PersonalPowerRt.getDefaultInstance()), // 查询个人势力

    WalkScout_18(18, WalkScout.getDefaultInstance(), WalkScoutRt.getDefaultInstance()), // 侦查

    AddMark_19(19, AddMark.getDefaultInstance(), AddMarkRt.getDefaultInstance()), // 添加土地收藏
    DelMark_20(20, DelMark.getDefaultInstance(), DelMarkRt.getDefaultInstance()), // 删除土地收藏
    ServerTime_21(21, FetchServerTime.getDefaultInstance(), FetchServerTimeRt.getDefaultInstance()), // 服务器时间
    SearchMapCell_24(24, SearchMapCell.getDefaultInstance(), SearchMapCellRt.getDefaultInstance()), // 找离我最近的指定等级的地块
    FetchVersion_25(25, FetchVersion.getDefaultInstance(), FetchVersionRt.getDefaultInstance()), // 获取配置版本信息
    CheckPlayerName_26(26, CheckPlayerName.getDefaultInstance(), CheckPlayerNameRt.getDefaultInstance()), // 实时检测改名
    ChangePlayerName_27(27, ChangePlayerName.getDefaultInstance(), ChangePlayerNameRt.getDefaultInstance()), // 改名
    BatchPlayerSimpleInfoQuery_29(
        29,
        BatchPlayerSimpleInfoQuery.getDefaultInstance(),
        BatchPlayerSimpleInfoQueryRt.getDefaultInstance()
    ),
    VipShipQuery_30(30, VipShipQuery.getDefaultInstance(), VipShipQueryRt.getDefaultInstance()), // VIP商店商品查询
    VipShipExchange_31(31, VipShipExchange.getDefaultInstance(), VipShipExchangeRt.getDefaultInstance()), // VIP商店商品兑换

    MerchantShipQuery_32(32, MerchantShipQuery.getDefaultInstance(), MerchantShipQueryRt.getDefaultInstance()), // 商船查询
    MerchantShipExchange_33(
        33,
        MerchantShipExchange.getDefaultInstance(),
        MerchantShipExchangeRt.getDefaultInstance()
    ), // 商船兑换

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    ShowMap_40(40, ShowMap.getDefaultInstance(), ShowMapRt.getDefaultInstance()), // 大地图外观显示
    QueryCastleDefInfo_41(
        41,
        QueryCastleDefInfo.getDefaultInstance(),
        QueryCastleDefInfoRt.getDefaultInstance()
    ), // 查守城英雄
    SetCastleDef_42(42, SetCastleDef.getDefaultInstance(), SetCastleDefRt.getDefaultInstance()),    // 设置守城部队
    ChangeSkin_45(45, ChangeSkin.getDefaultInstance(), ChangeSkinRt.getDefaultInstance()), // 切换城堡皮肤
    BuySkin_47(47, BuySkin.getDefaultInstance(), BuySkinRt.getDefaultInstance()), // 购买城堡皮肤

    CreateInnerCity_50(50, CreateInnerCity.getDefaultInstance(), CreateInnerCityRt.getDefaultInstance()), // 新建内城建筑
    UnlockInnerCity_51(51, UnlockInnerCity.getDefaultInstance(), UnlockInnerCityRt.getDefaultInstance()), // 解锁内城建筑
    UpInnerCity_52(52, UpInnerCity.getDefaultInstance(), UpInnerCityRt.getDefaultInstance()), // 升级内城建筑
    CancelUpInnerCity_53(
        53,
        CancelUpInnerCity.getDefaultInstance(),
        CancelUpInnerCityRt.getDefaultInstance()
    ), // 取消内城建筑升级
    QuickBuyExtendsQueue_54(
        54,
        QuickBuyExtendsQueue.getDefaultInstance(),
        QuickBuyExtendsQueueRt.getDefaultInstance()
    ), // 快速购买临时队列时长

    CancelDestroyInnerCity_55(
        55,
        CancelDestroyInnerCity.getDefaultInstance(),
        CancelDestroyInnerCityRt.getDefaultInstance()
    ), // 取消拆除内城建筑
    CollectBuildingRes_58(
        58,
        CollectBuildingRes.getDefaultInstance(),
        CollectBuildingResRt.getDefaultInstance()
    ),// 收集建筑资源

    RefreshMerchantShipAtOnce_60(
        60,
        RefreshMerchantShipAtOnce.getDefaultInstance(),
        RefreshMerchantShipAtOnceRt.getDefaultInstance()
    ), // 立即刷新云游商人
    CreateInnerCityDecorationObj_61(
        61,
        CreateInnerCityDecorationObj.getDefaultInstance(),
        CreateInnerCityDecorationObjRt.getDefaultInstance()
    ),  // 建造内城装饰性建筑
    DestroyInnerCityDecorationObj_62(
        62,
        DestroyInnerCityDecorationObj.getDefaultInstance(),
        DestroyInnerCityDecorationObjRt.getDefaultInstance()
    ), // 拆除内城装饰性建筑
    MoveInnerCityBuilding_63(
        63,
        MoveInnerCityBuilding.getDefaultInstance(),
        MoveInnerCityBuildingRt.getDefaultInstance()
    ), // 移动内城建筑
    MoveInnerCityDecorationObj_65(
        65,
        MoveInnerCityDecorationObj.getDefaultInstance(),
        MoveInnerCityDecorationObjRt.getDefaultInstance()
    ), // 移动内城装饰性建筑
    QueryLayout_66(
        66,
        QueryLayout.getDefaultInstance(),
        QueryLayoutRt.getDefaultInstance()
    ), // 查询布局
    CopyLayout_67(
        67,
        CopyLayout.getDefaultInstance(),
        CopyLayoutRt.getDefaultInstance()
    ), // 复制布局
    EditLayout_68(
        68,
        EditLayout.getDefaultInstance(),
        EditLayoutRt.getDefaultInstance()
    ), // 编辑布局
    ApplyLayout_69(
        69,
        ApplyLayout.getDefaultInstance(),
        ApplyLayoutRt.getDefaultInstance()
    ), // 应用布局
    InnerCityDecorationObjDistribute_70(
        70,
        InnerCityDecorationObjDistribute.getDefaultInstance(),
        InnerCityDecorationObjDistributeRt.getDefaultInstance()
    ), // 装饰建筑直接放进当前布局
    InnerCityDecorationObjPackUp_71(
        71,
        InnerCityDecorationObjPackUp.getDefaultInstance(),
        InnerCityDecorationObjPackUpRt.getDefaultInstance()
    ),
    LayoutFunctionOpen_72(
        72,
        LayoutFunctionOpen.getDefaultInstance(),
        LayoutFunctionOpenRt.getDefaultInstance()
    ), //布局功能开启
    HeroAppointAppoint_81(
        81,
        HeroAppointAppoint.getDefaultInstance(),
        HeroAppointAppointRt.getDefaultInstance()
    ), // 英雄委任委任
    HeroAppointAutoAppoint_82(
        82,
        HeroAppointAutoAppoint.getDefaultInstance(),
        HeroAppointAutoAppointRt.getDefaultInstance()
    ), // 英雄委任一键委任
    LuckyDiscountShopQuery_90(
        90,
        LuckyDiscountShopQuery.getDefaultInstance(),
        LuckyDiscountShopQueryRt.getDefaultInstance()
    ), // 幸运折扣商店查询
    LuckyDiscountShopRefresh_91(
        91,
        LuckyDiscountShopRefresh.getDefaultInstance(),
        LuckyDiscountShopRefreshRt.getDefaultInstance()
    ), // 幸运折扣商店刷新
    LuckyDiscountShopBuy_92(
        92,
        LuckyDiscountShopBuy.getDefaultInstance(),
        LuckyDiscountShopBuyRt.getDefaultInstance()
    ), // 幸运折扣商店购买
    QuerySpecialReportInfo_102(
        102,
        QuerySpecialReportInfo.getDefaultInstance(),
        QuerySpecialReportInfoRt.getDefaultInstance()
    ), // 详细战报请求
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    TestSlgFight_103(103, TestSlgFight.getDefaultInstance(), TestSlgFightRt.getDefaultInstance()), // 测试战斗
    GetDetailFightInfo_104(
        104,
        GetDetailFightInfo.getDefaultInstance(),
        GetDetailFightInfoRt.getDefaultInstance()
    ), // 详细战报请求
    GetHeroFightReport_105(
        105,
        GetHeroFightReport.getDefaultInstance(),
        GetHeroFightReportRt.getDefaultInstance()
    ), // 获取英雄战战报记录（测试用）

    ChatFightInfoDetail_106(
        106,
        GetShareBattle.getDefaultInstance(),
        GetShareBattleRt.getDefaultInstance()
    ), // 获取聊天时的战报分享的详细信息

    ChangeWorldWatch_108(108, ChangeWorldWatch.getDefaultInstance(), ChangeWorldWatchRt.getDefaultInstance()), // 切换世界视野
    GetAllServerInfo_109(109, GetAllServerInfo.getDefaultInstance(), GetAllServerInfoRt.getDefaultInstance()), // 查找所有世界
    QueryCell_111(111, QueryCell.getDefaultInstance(), QueryCellRt.getDefaultInstance()), // 查询地块
    QueryAllianceWalkLine_112(
        112,
        QueryAllianceWalkLine.getDefaultInstance(),
        QueryAllianceWalkLineRt.getDefaultInstance()
    ), // 查询联盟行军线
    GetTaskReward_113(113, GetTaskReward.getDefaultInstance(), GetTaskRewardRt.getDefaultInstance()), // 领取任务奖励
    TaskGossipFinish_114(114, TaskGossipFinish.getDefaultInstance(), TaskGossipFinishRt.getDefaultInstance()), // 八卦任务完成
    GuideFin_119(119, GuideFin.getDefaultInstance(), GuideFinRt.getDefaultInstance()), // 新手引导完成一步
    GetUnitTaskReward_120(
        120,
        GetUnitTaskReward.getDefaultInstance(),
        GetUnitTaskRewardRt.getDefaultInstance()
    ), // 领取章节任务奖励

    StoryStepChange_121(121, StoryStepChange.getDefaultInstance(), StoryStepChangeRt.getDefaultInstance()), // 剧情引导变化

    AllianceUnitTaskQuery_130(
        130,
        AllianceUnitTaskQuery.getDefaultInstance(),
        AllianceUnitTaskQueryRt.getDefaultInstance()
    ),

    AllianceJourneyDraw_140(
        140,
        AllianceJourneyDraw.getDefaultInstance(),
        AllianceJourneyDrawRt.getDefaultInstance()
    ), // 盟主征途大奖领取

    EnterOperation_150(150, EnterOperation.getDefaultInstance(), EnterOperationRt.getDefaultInstance()),
    OperationExcavate_151(151, OperationExcavate.getDefaultInstance(), OperationExcavateRt.getDefaultInstance()),
    OperationExhibitionWarehouseOpt_152(152, OperationExhibitionWarehouseOpt.getDefaultInstance(), OperationExhibitionWarehouseOptRt.getDefaultInstance()),
    OperationSoilLayerQuery_153(153, OperationSoilLayerQuery.getDefaultInstance(), OperationSoilLayerQueryRt.getDefaultInstance()),
    OperationLabour_154(154, OperationLabour.getDefaultInstance(), OperationLabourRt.getDefaultInstance()),
    OperationMuseumInfoQuery_155(155, OperationMuseumInfoQuery.getDefaultInstance(), OperationMuseumInfoQueryRt.getDefaultInstance()),
    OperationMuseumOpt_156(156, OperationMuseumOpt.getDefaultInstance(), OperationMuseumOptRt.getDefaultInstance()),
    OperationExcavateBalance_158(158, OperationExcavateBalance.getDefaultInstance(), OperationExcavateBalanceRt.getDefaultInstance()),
    OperationExcavateContract_159(159, OperationExcavateContract.getDefaultInstance(), OperationExcavateContractRt.getDefaultInstance()),
    OperationBookOpt_160(160, OperationBookOpt.getDefaultInstance(), OperationBookOptRt.getDefaultInstance()),
    OperationBeginnerGuide_161(161, OperationBeginnerGuide.getDefaultInstance(), OperationBeginnerGuideRt.getDefaultInstance()),
    OperationDirectExcavateOpen_162(162, OperationDirectExcavateOpen.getDefaultInstance(), OperationDirectExcavateOpenRt.getDefaultInstance()),
    OperationDirectExcavateBalance_163(163, OperationDirectExcavateBalance.getDefaultInstance(), OperationDirectExcavateBalanceRt.getDefaultInstance()),
    OperationMissionTrigger_164(164, OperationMissionTrigger.getDefaultInstance(), OperationMissionTriggerRt.getDefaultInstance()),
    OperationTransportTeam_165(165, OperationTransportTeam.getDefaultInstance(), OperationTransportTeamRt.getDefaultInstance()),
    OperationTransportSlot_166(166, OperationTransportSlot.getDefaultInstance(), OperationTransportSlotRt.getDefaultInstance()),
    OperationUseProp_167(167, OperationUseProp.getDefaultInstance(), OperationUsePropRt.getDefaultInstance()),

    ItemCompound_183(183, ItemCompound.getDefaultInstance(), ItemCompoundRt.getDefaultInstance()), // 合成道具

    PlayerTagSet_200(200, PlayerTagSet.getDefaultInstance(), PlayerTagSetRt.getDefaultInstance()), // 设置玩家标签
    AllianceTagSet_201(201, AllianceTagSet.getDefaultInstance(), AllianceTagSetRt.getDefaultInstance()), // 设置联盟标签

    TimedPackageQuery_240(
        240,
        TimedPackageQuery.getDefaultInstance(),
        TimedPackageQueryRt.getDefaultInstance()
    ),  // 定时礼包查询
    TimedPackageDraw_241(
        241,
        TimedPackageDraw.getDefaultInstance(),
        TimedPackageDrawRt.getDefaultInstance()
    ), // 定时礼包领取
    ReadAllChatMsg_295(295, ReadAllChatMsg.getDefaultInstance(), ReadAllChatMsgRt.getDefaultInstance()),
    DelStrangerChat_296(296, DelStrangerChat.getDefaultInstance(), DelStrangerChatRt.getDefaultInstance()),
    OpenNewChatWindow_297(297, OpenNewChatWindow.getDefaultInstance(), OpenNewChatWindowRt.getDefaultInstance()),
    ChangeChatWindow_298(298, ChangeChatWindow.getDefaultInstance(), ChangeChatWindowRt.getDefaultInstance()),
    ChangeRoomInfo_299(299, ChangeRoomInfo.getDefaultInstance(), ChangeRoomInfoRt.getDefaultInstance()), // 修改聊天室信息
    Chat_300(300, SendChat.getDefaultInstance(), SendChatRt.getDefaultInstance()), // 发送聊天
    SendChat_301(301, SendChatMsg.getDefaultInstance(), SendChatMsgRt.getDefaultInstance()), // 发送聊天
    CreateScopeMsg_304(304, GetChatRoom.getDefaultInstance(), GetChatRoomRt.getDefaultInstance()), // 生成聊天室

    NoSessionQuery_302(302, NoSessionQuery.getDefaultInstance(), NoSessionQueryRt.getDefaultInstance()),

    AppointRoomOwner_309(309, ChatRoomAppoint.getDefaultInstance(), ChatRoomAppointRt.getDefaultInstance()), // 群主转让
    QuitChatRoom_312(312, QuitChatRoom.getDefaultInstance(), QuitChatRoomRt.getDefaultInstance()), // 退出群组聊天（彻底的离开聊天室）

    QueryGroupMembers_314(
        314,
        QueryGroupMembers.getDefaultInstance(),
        QueryGroupMembersRt.getDefaultInstance()
    ), // 查询群组聊天室成员

    AddGroupChatMember_315(
        315,
        AddGroupChatMember.getDefaultInstance(),
        AddGroupChatMemberRt.getDefaultInstance()
    ), // 向群组聊天室中增加聊天成员
    DelGroupChatMember_316(
        316,
        DelGroupChatMember.getDefaultInstance(),
        DelGroupChatMemberRt.getDefaultInstance()
    ), // 删除讨论组人员
    DelGroupChat_317(317, DelGroupChat.getDefaultInstance(), DelGroupChatRt.getDefaultInstance()), // 删除讨论组
    GetChatInfo_319(319, GetChatInfo.getDefaultInstance(), GetChatInfoRt.getDefaultInstance()), // 获取聊天内容
    GetLastChatInfo_320(320, GetLastChatInfo.getDefaultInstance(), GetLastChatInfoRt.getDefaultInstance()), // 获取最新聊天记录

    InBlack_321(321, InBlack.getDefaultInstance(), InBlackRt.getDefaultInstance()), // 拉入黑名单
    OffBlack_322(322, OffBlack.getDefaultInstance(), OffBlackRt.getDefaultInstance()), // 移除黑名单

    AssistAllianceChat_323(
        323,
        AssistAllianceChat.getDefaultInstance(),
        AssistAllianceChatRt.getDefaultInstance()
    ),// 点赞联盟聊天

    MoveCity_360(360, MoveCity.getDefaultInstance(), MoveCityRt.getDefaultInstance()), // 迁城

    ClearPlayerEnterGame_361(
        361,
        ClearPlayerEnterGame.getDefaultInstance(),
        ClearPlayerEnterGameRt.getDefaultInstance()
    ), // 被清理的玩家重新上线安排坐标
    QueryMoveCity_362(362, QueryMoveCity.getDefaultInstance(), QueryMoveCityRt.getDefaultInstance()), // 查询迁城

    // 邮件
    AllMails_450(450, AllMails.getDefaultInstance(), AllMailsRt.getDefaultInstance()), // 邮件列表查询
    ReadMail_451(451, ReadMail.getDefaultInstance(), ReadMailRt.getDefaultInstance()), // 阅读邮件
    ReadAllMail_452(452, ReadAllMail.getDefaultInstance(), ReadAllMailRt.getDefaultInstance()),// 一键已读
    DrawMail_453(453, DrawMail.getDefaultInstance(), DrawMailRt.getDefaultInstance()), // 邮件领取附件
    DrawAllMail_454(454, DrawAllMail.getDefaultInstance(), DrawAllMailRt.getDefaultInstance()),// 一键领取
    DelMail_455(455, DelMail.getDefaultInstance(), DelMailRt.getDefaultInstance()), // 删除邮件
    BatchDelMail_456(456, BatchDelMail.getDefaultInstance(), BatchDelMailRt.getDefaultInstance()),// 批量删除邮件
    SignMail_457(457, MailSign.getDefaultInstance(), MailSignRt.getDefaultInstance()), // 收藏邮件
    SendAllianceMail_458(458, SendAllianceMail.getDefaultInstance(), SendAllianceMailRt.getDefaultInstance()), // 发送联盟邮件
    QueryMailNumInfo_459(459, QueryMailNumInfo.getDefaultInstance(), QueryMailNumInfoRt.getDefaultInstance()), // 查询邮件数量
    UnSignMail_460(460, MailUnSign.getDefaultInstance(), MailUnSignRt.getDefaultInstance()), // 取消收藏邮件

    QueryAllianceRankFirst_500(
        500,
        QueryAllianceRankFirst.getDefaultInstance(),
        QueryAllianceRankFirstRt.getDefaultInstance()
    ), // 查询联盟排行榜首页
    QueryRankFirst_501(501, QueryRankFirst.getDefaultInstance(), QueryRankFirstRt.getDefaultInstance()), // 查询排行榜首页
    QueryRank_502(502, QueryRank.getDefaultInstance(), QueryRankRt.getDefaultInstance()), // 查询排行
    QueryOpenServerFightValueRank_503(
        503,
        QueryOpenServerFightValueRank.getDefaultInstance(),
        QueryOpenServerFightValueRankRt.getDefaultInstance()
    ),  // 开服战力排行排行榜查询
    QueryOpenServerFightValueDropBag_504(
        504,
        QueryOpenServerFightValueDropBag.getDefaultInstance(),
        QueryOpenServerFightValueDropBagRt.getDefaultInstance()
    ), // 开服战力排行已购礼包查询
    BuyOpenServerFightValueDropBag_505(
        505,
        BuyOpenServerFightValueDropBag.getDefaultInstance(),
        BuyOpenServerFightValueDropBagRt.getDefaultInstance()
    ), // 开服战力排行礼包购买
    QuerySlgDetailOnRank_506(
        506,
        QuerySlgDetailOnRank.getDefaultInstance(),
        QuerySlgDetailOnRankRt.getDefaultInstance()
    ), // 排行榜中的slg战斗信息
    QueryBattlefieldRankFirst_507(507, QueryBattlefieldRankFirst.getDefaultInstance(), QueryBattlefieldRankFirstRt.getDefaultInstance()),
    QueryBattlefieldPersonalRank_508(508, QueryBattlefieldPersonalRank.getDefaultInstance(), QueryBattlefieldPersonalRankRt.getDefaultInstance()),
    QueryBattlefieldAllianceRank_509(509, QueryBattlefieldAllianceRank.getDefaultInstance(), QueryBattlefieldAllianceRankRt.getDefaultInstance()),
    SignQuery_510(
        510,
        SignQuery.getDefaultInstance(),
        SignQueryRt.getDefaultInstance()
    ), // 签到查询

    SignActive_511(
        511,
        SignActive.getDefaultInstance(),
        SignActiveRt.getDefaultInstance()
    ),// 签到

    SignDrawBox_512(
        512,
        SignDrawBox.getDefaultInstance(),
        SignDrawBoxRt.getDefaultInstance()
    ),// 领取累计签到宝箱
    QueryPurchaseActivityLimitRank_513(
        513,
        QueryPurchaseActivityLimitRank.getDefaultInstance(),
        QueryPurchaseActivityLimitRankRt.getDefaultInstance()
    ), //查询活动限定的排行
    RebirthPalaceQuery_610(  // 大圣堂查询
        610,
        RebirthPalaceQuery.getDefaultInstance(),
        RebirthPalaceQueryRt.getDefaultInstance()
    ),

    RebirthPalaceFreeRebirth_611( // 大圣堂免费复活士兵
        611,
        RebirthPalaceFreeRebirth.getDefaultInstance(),
        RebirthPalaceFreeRebirthRt.getDefaultInstance()
    ),

    RebirthPalaceRebirth_612( // 大圣堂付费复活士兵
        612,
        RebirthPalaceRebirth.getDefaultInstance(),
        RebirthPalaceRebirthRt.getDefaultInstance()
    ),

    HeroTrainCampQuery_620(
        620,
        HeroTrainCampQuery.getDefaultInstance(),
        HeroTrainCampQueryRt.getDefaultInstance()
    ), // 英雄训练营查询

    HeroTrainCampGridOccupyOrRelease_621(
        621,
        HeroTrainCampGridOccupyOrRelease.getDefaultInstance(),
        HeroTrainCampGridOccupyOrReleaseRt.getDefaultInstance()
    ), // 英雄训练营格子占用或释放

    HeroTrainCampGridCdClear_622(
        622,
        HeroTrainCampGridCdClear.getDefaultInstance(),
        HeroTrainCampGridCdClearRt.getDefaultInstance()
    ), // 英雄训练营格子cd清除

    HeroRecommendBoxDraw_640(
        640,
        HeroRecommendBoxDraw.getDefaultInstance(),
        HeroRecommendBoxDrawRt.getDefaultInstance()
    ), // 英雄推荐宝箱领取

    // 帅土武将玩法
    HeroCompound_670(670, HeroCompound.getDefaultInstance(), HeroCompoundRt.getDefaultInstance()), // 武将合成

    // 查询好友申请
    QueryFriendApply_699(699, QueryFriendApply.getDefaultInstance(), QueryFriendApplyRt.getDefaultInstance()),

    // 查询好友信息
    QueryFriend_700(700, QueryFriend.getDefaultInstance(), QueryFriendRt.getDefaultInstance()),
    MakeFriend_701(701, MakeFriend.getDefaultInstance(), MakeFriendRt.getDefaultInstance()), // 加好友
    RemoveFriend_702(702, RemoveFriend.getDefaultInstance(), RemoveFriendRt.getDefaultInstance()), // 删除好友
    QueryPlayerByName_709(
        709,
        QueryPlayerByName.getDefaultInstance(),
        QueryPlayerByNameRt.getDefaultInstance()
    ), // 查询玩家
    HandleFriendApply_710(
        710,
        HandleFriendApply.getDefaultInstance(),
        HandleFriendApplyRt.getDefaultInstance()
    ), // 忽略别人的添加好友请求

    SurpriseActivityQuery_731(731, SurpriseActivityQuery.getDefaultInstance(), SurpriseActivityQueryRt.getDefaultInstance()),
    SurpriseActivityOpt_732(732, SurpriseActivityOpt.getDefaultInstance(), SurpriseActivityOptRt.getDefaultInstance()),

    // 获取每天vip奖励
    GainVipDayReward_740(
        740,
        GainVipReward.getDefaultInstance(),
        GainVipRewardRt.getDefaultInstance()
    ),

    // 购买普通VIP特权礼包
    BuyNormalVipGift_741(
        741,
        BuyNormalVipGift.getDefaultInstance(),
        BuyNormalVipGiftRt.getDefaultInstance()
    ),
    UpVipLevel_742(742, UpVipLevel.getDefaultInstance(), UpVipLevelRt.getDefaultInstance()), // vip升级
    RewardVipDayRewardDeal_743(
        743,
        RewardVipDayReward.getDefaultInstance(),
        RewardVipDayRewardRt.getDefaultInstance()
    ), // 领取每日VIP经验
    DisappearTalentOpt_751(751, DisappearTalentOpt.getDefaultInstance(), DisappearTalentOptRt.getDefaultInstance()),
    DisappearBuildingQuery_752(752, DisappearBuildingQuery.getDefaultInstance(), DisappearBuildingQueryRt.getDefaultInstance()),
    DisappearBuildingOpt_753(753, DisappearBuildingOpt.getDefaultInstance(), DisappearBuildingOptRt.getDefaultInstance()),

    RadarSearchOpen_781(781, RadarSearchOpen.getDefaultInstance(), RadarSearchOpenRt.getDefaultInstance()), // 雷达搜索
    RadarTaskVerify_782(782, RadarTaskVerify.getDefaultInstance(), RadarTaskVerifyRt.getDefaultInstance()), // 雷达任务验证

    RadarTaskDraw_785(
        785,
        RadarTaskDraw.getDefaultInstance(),
        RadarTaskDrawRt.getDefaultInstance()
    ), // 领取雷达任务奖励

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    RadarStrengthTaskDraw_787(
        787,
        RadarStrengthTaskDraw.getDefaultInstance(),
        RadarStrengthTaskDrawRt.getDefaultInstance()
    ), // 领取雷达示例验证任务奖励
    RadarUpgrade_788(788, RadarUpgrade.getDefaultInstance(), RadarUpgradeRt.getDefaultInstance()),
    RadarTaskComplete_789(789, RadarTaskComplete.getDefaultInstance(), RadarTaskCompleteRt.getDefaultInstance()),
    RadarDoubleRewardChangeSwitch_790(
        790,
        RadarDoubleRewardChangeSwitch.getDefaultInstance(),
        RadarDoubleRewardChangeSwitchRt.getDefaultInstance()
    ),//雷达双倍任务奖励开关

    GetFossilHunterData_791(791, GetFossilHunterData.getDefaultInstance(), GetFossilHunterDataRt.getDefaultInstance()),
    ReceiveFossilHunterReward_792(
        792,
        ReceiveFossilHunterReward.getDefaultInstance(),
        ReceiveFossilHunterRewardRt.getDefaultInstance()
    ),
    FossilHunterUnlockGroup_793(
        793,
        FossilHunterUnlockGroup.getDefaultInstance(),
        FossilHunterUnlockGroupRt.getDefaultInstance()
    ),

    SlotBet_794(794, SlotBet.getDefaultInstance(), SlotBetRt.getDefaultInstance()), // 扭蛋轰隆隆抽奖
    SlotActivityQuery_795(
        795,
        SlotActivityQuery.getDefaultInstance(),
        SlotActivityQueryRt.getDefaultInstance()
    ),  // 扭蛋轰隆隆活动查询
    SlotShopBuy_796(796, SlotShopBuy.getDefaultInstance(), SlotShopBuyRt.getDefaultInstance()), // 扭蛋轰隆隆商店购买
    ReceiveSlotShareReward_797(
        797,
        ReceiveSlotShareReward.getDefaultInstance(),
        ReceiveSlotShareRewardRt.getDefaultInstance()
    ), // 扭蛋轰隆隆领取瓜分奖励
    RadarTaskSweep_798(798, RadarTaskSweep.getDefaultInstance(), RadarTaskSweepRt.getDefaultInstance()),//雷达扫荡
    GetRadarDoubleRewardInfo_799(
        799,
        GetRadarDoubleRewardInfo.getDefaultInstance(),
        GetRadarDoubleRewardInfoRt.getDefaultInstance()
    ),//雷达双倍奖励信息

    AllianceCreate_802(802, AllianceCreate.getDefaultInstance(), AllianceCreateRt.getDefaultInstance()), // 联盟创建

    QueryAllianceRandName_803(
        803,
        QueryAllianceRandName.getDefaultInstance(),
        QueryAllianceRandNameRt.getDefaultInstance()
    ), // 随机名字
    AllianceJoinById_804(
        804,
        AllianceJoinById.getDefaultInstance(),
        AllianceJoinByIdRt.getDefaultInstance()
    ), // 根据联盟ID申请加入联盟
    AllianceJoinCancel_805(
        805,
        AllianceJoinCancel.getDefaultInstance(),
        AllianceJoinCancelRt.getDefaultInstance()
    ), // 玩家取消加入联盟申请
    AllianceDealJoinReq_806(
        806,
        AllianceDealJoinReq.getDefaultInstance(),
        AllianceDealJoinReqRt.getDefaultInstance()
    ), // 处理玩家加入联盟申请
    SetPowerLimit_807(
        807,
        AllianceSetPowerLimit.getDefaultInstance(),
        AllianceSetPowerLimitRt.getDefaultInstance()
    ), // 设置允许申请联盟的势力最低值
    AllianceQueryList_808(
        808,
        AllianceQueryList.getDefaultInstance(),
        AllianceQueryListRt.getDefaultInstance()
    ), // 查询可加入联盟列表
    AllianceQueryInfo_809(
        809,
        AllianceQueryInfo.getDefaultInstance(),
        AllianceQueryInfoRt.getDefaultInstance()
    ), // 查询联盟概要信息
    AllianceQueryReqList_810(
        810,
        AllianceQueryReqList.getDefaultInstance(),
        AllianceQueryReqListRt.getDefaultInstance()
    ), // 查询申请加入联盟的玩家信息
    AllianceQuit_811(811, AllianceQuit.getDefaultInstance(), AllianceQuitRt.getDefaultInstance()), // 玩家主动退出联盟
    AllianceRemovePlayer_812(
        812,
        AllianceRemovePlayer.getDefaultInstance(),
        AllianceRemovePlayerRt.getDefaultInstance()
    ), // 从联盟中剔除玩家
    AllianceSetDescpt_813(
        813,
        AllianceSetDescpt.getDefaultInstance(),
        AllianceSetDescptRt.getDefaultInstance()
    ), // 修改联盟公告
    AllianceSetPos_814(814, AllianceSetPos.getDefaultInstance(), AllianceSetPosRt.getDefaultInstance()), // 任命玩家在联盟中职位

    AllianceBeInvite_815(
        815,
        AllianceBeInvite.getDefaultInstance(),
        AllianceBeInviteRt.getDefaultInstance()
    ), // 接受邀请加入联盟

    AllianceQueryPlayer_816(
        816,
        AllianceQueryPlayer.getDefaultInstance(),
        AllianceQueryPlayerRt.getDefaultInstance()
    ), // 查询联盟成员信息
    AllianceDismiss_817(817, AllianceDismiss.getDefaultInstance(), AllianceDismissRt.getDefaultInstance()), // 联盟解散
    AllianceTp_818(818, AllianceTp.getDefaultInstance(), AllianceTpRt.getDefaultInstance()), // 联盟回城请求界面
    SetAllianceFollow_819(
        819,
        SetAllianceFollow.getDefaultInstance(),
        SetAllianceFollowRt.getDefaultInstance()
    ), // 设置跟随状态 不用传参数来 直接取反
    AllianceQueryLog_820(820, AllianceQueryLog.getDefaultInstance(), AllianceQueryLogRt.getDefaultInstance()), // 查询联盟日志
    QueryAllianceDescptHistory_821(821, QueryAllianceDescptHistory.getDefaultInstance(), QueryAllianceDescptHistoryRt.getDefaultInstance()),

    AllianceSetApplyPower_822(
        822,
        AllianceSetApplyPower.getDefaultInstance(),
        AllianceSetApplyPowerRt.getDefaultInstance()
    ), // 设置联盟官员申请战斗力
    ApplyAllianceOfficer_823(
        823,
        ApplyAllianceOfficer.getDefaultInstance(),
        ApplyAllianceOfficerRt.getDefaultInstance()
    ), // 申请成为联盟官员
    QueryApplyAllianceOfficer_824(
        824,
        QueryApplyAllianceOfficer.getDefaultInstance(),
        QueryApplyAllianceOfficerRt.getDefaultInstance()
    ), // 查询申请成为联盟官员列表

    CreateAllianceCheckAllianceName_825(
        825,
        CheckAllianceName.getDefaultInstance(),
        CheckAllianceNameRt.getDefaultInstance()
    ), // 检测联盟名是否可用
    DeleteApplyAllianceOfficer_826(
        826,
        DeleteApplyAllianceOfficer.getDefaultInstance(),
        DeleteApplyAllianceOfficerRt.getDefaultInstance()
    ), // 删除一条申请职位记录

    ReceivePayLifetimeCardReward_827(
        827,
        ReceivePayLifetimeCardReward.getDefaultInstance(),
        ReceivePayLifetimeCardRewardRt.getDefaultInstance()
    ), // 领取终身卡奖励

    AllianceRecallPos_835(
        835,
        AllianceRecallPos.getDefaultInstance(),
        AllianceRecallPosRt.getDefaultInstance()
    ), // 罢免玩家帮派职位
    AlliancePropertyWaive_836(836, AlliancePropertyWaive.getDefaultInstance(), AlliancePropertyWaiveRt.getDefaultInstance()),
    AllianceSetFlag_837(837, AllianceSetFlag.getDefaultInstance(), AllianceSetFlagRt.getDefaultInstance()), // 设置联盟旗帜
    QueryApplyAllianceList_838(
        838,
        QueryApplyAllianceList.getDefaultInstance(),
        QueryApplyAllianceListRt.getDefaultInstance()
    ), // 查询已申请联盟列表

    QueryAllianceActivity_839(
        839,
        QueryAllianceActivity.getDefaultInstance(),
        QueryAllianceActivityRt.getDefaultInstance()
    ), // 查询已申请联盟列表

    CleanrAllianceApplyList_840(
        840,
        CleanrAllianceApplyList.getDefaultInstance(),
        CleanrAllianceApplyListRt.getDefaultInstance()
    ), // 检测是否拥有联盟 并且清除他的申请记录 用于进入销号冷静期

    //根据条件筛选出一个符合条件的联盟信息
    GetRecommendationAllianceInfo_841(
        841,
        GetRecommendationAllianceInfo.getDefaultInstance(),
        GetRecommendationAllianceInfoRt.getDefaultInstance()
    ),
    //联盟福利支援礼包846-850
    //购买联盟福利支援礼包
    BuyAllianceGiftSupportBox_846(
        846,
        BuyAllianceGiftSupportBox.getDefaultInstance(),
        BuyAllianceGiftSupportBoxRt.getDefaultInstance()
    ),
    //联盟福利支援礼包信息查询
    QueryAllianceGiftSupportBoxInfo_847(
        847,
        QueryAllianceGiftSupportBoxInfo.getDefaultInstance(),
        QueryAllianceGiftSupportBoxInfoRt.getDefaultInstance()
    ),

    // 设置联盟自动踢人条件
    SetAllianceAutoRemovePlayer_848(
        848,
        SetAllianceAutoRemovePlayer.getDefaultInstance(),
        SetAllianceAutoRemovePlayerRt.getDefaultInstance()
    ),

    AllianceOpenWaijiao_895(
        895,
        AllianceOpenWaijiao.getDefaultInstance(),
        AllianceOpenWaijiaoRt.getDefaultInstance()
    ), // 打开联盟外交界面
    WriteAllianceWaijiao_896(
        896,
        WriteAllianceWaijiao.getDefaultInstance(),
        WriteAllianceWaijiaoRt.getDefaultInstance()
    ), // 写联盟外交
    AllianceNickName_897(897, AllianceNickName.getDefaultInstance(), AllianceNickNameRt.getDefaultInstance()), // 设置联盟昵称
    AllianceSetName_898(
        898,
        SetAllianceName.getDefaultInstance(),
        SetAllianceNameRt.getDefaultInstance()
    ), // 设置联盟名称或者简称
    AllianceImpeach_899(899, AllianceImpeach.getDefaultInstance(), AllianceImpeachRt.getDefaultInstance()), // 弹劾盟主
    AllianceInvite_900(900, AllianceInvite.getDefaultInstance(), AllianceInviteRt.getDefaultInstance()), // 邀请玩家加入联盟
    AllianceGiftOpen_901(
        901,
        AllianceGiftOpen.getDefaultInstance(),
        AllianceGiftOpenRt.getDefaultInstance()
    ), // 联盟礼物主界面

    AllianceGiftGet_902(
        902,
        AllianceGiftGet.getDefaultInstance(),
        AllianceGiftGetRt.getDefaultInstance()
    ),
    AllianceBigGiftOpen_903(
        903,
        AllianceBigGiftOpen.getDefaultInstance(),
        AllianceBigGiftOpenRt.getDefaultInstance()
    ),
    AllianceGiftDelete_904(
        904,
        AllianceGiftDelete.getDefaultInstance(),
        AllianceGiftDeleteRt.getDefaultInstance()
    ),
    OpenAllianceCompetitionMain_906(
        906,
        OpenAllianceCompetitionMain.getDefaultInstance(),
        OpenAllianceCompetitionMainRt.getDefaultInstance()
    ), // 打开联盟总动员主界面
    OpenAllianceCompetitionReward_907(
        907,
        OpenAllianceCompetitionReward.getDefaultInstance(),
        OpenAllianceCompetitionRewardRt.getDefaultInstance()
    ), // 打开联盟总动员领取奖励界面
    GetAllianceCompetitionQuest_908(
        908,
        GetAllianceCompetitionQuest.getDefaultInstance(),
        GetAllianceCompetitionQuestRt.getDefaultInstance()
    ), // 领取联盟总动员任务
    RemoveAllianceCompetitionQuest_909(
        909,
        RemoveAllianceCompetitionQuest.getDefaultInstance(),
        RemoveAllianceCompetitionQuestRt.getDefaultInstance()
    ), // 删除联盟总动员任务
    BuyAllianceCompetitionQuest_910(
        910,
        BuyAllianceCompetitionQuest.getDefaultInstance(),
        BuyAllianceCompetitionQuestRt.getDefaultInstance()
    ), // 购买联盟总动员任务
    RewardAllianceCompetitionQuest_911(
        911,
        RewardAllianceCompetitionQuest.getDefaultInstance(),
        RewardAllianceCompetitionQuestRt.getDefaultInstance()
    ), // 领取任务奖励
    CancelAllianceCompetitionQuest_912(
        912,
        CancelAllianceCompetitionQuest.getDefaultInstance(),
        CancelAllianceCompetitionQuestRt.getDefaultInstance()
    ), // 有权限的人取消掉任务
    GetAllianceCompetitionReward_913(
        913,
        GetAllianceCompetitionReward.getDefaultInstance(),
        GetAllianceCompetitionRewardRt.getDefaultInstance()
    ), // 领取联盟总动员阶段奖励
    OpenAfterAllianceCompetition_914(
        914,
        OpenAfterAllianceCompetition.getDefaultInstance(),
        OpenAfterAllianceCompetitionRt.getDefaultInstance()
    ), // 活动结束打开界面
    QueryInAllianceRank_915(
        915,
        QueryInAllianceRank.getDefaultInstance(),
        QueryInAllianceRankRt.getDefaultInstance()
    ), // 查询联盟内部数据排行榜
    QueryAllianceRank_916(
        916,
        QueryAllianceRank.getDefaultInstance(),
        QueryAllianceRankRt.getDefaultInstance()
    ), // 查询联盟排行榜
    QueryAllianceFirstRank_917(
        917,
        QueryInAllianceFirstRank.getDefaultInstance(),
        QueryInAllianceFirstRankRt.getDefaultInstance()
    ), // 查询联盟排行榜首页
    QueryOccupyWonder_918(
        918,
        QueryOccupyWonder.getDefaultInstance(),
        QueryOccupyWonderRt.getDefaultInstance()
    ), // 查询占领的奇观
    RemoveAllianceWaijiao_919(
        919,
        RemoveAllianceWaijiao.getDefaultInstance(),
        RemoveAllianceWaijiaoRt.getDefaultInstance()
    ), // 删除联盟留言
    ExchangeKingExp_924(
        924,
        ExchangeKingExp.getDefaultInstance(),
        ExchangeKingExpRt.getDefaultInstance()
    ), // 道具兑换成领主经验

    OpenAllianceBag_925(
        925,
        OpenAllianceBag.getDefaultInstance(),
        OpenAllianceBagRt.getDefaultInstance()
    ), // 打开联盟仓库

    DonateAllianceBag_926(
        926,
        DonateAllianceBag.getDefaultInstance(),
        DonateAllianceBagRt.getDefaultInstance()
    ), // 捐献东西给联盟仓库

    ExchangeAllianceBag_927(
        927,
        ExchangeAllianceBag.getDefaultInstance(),
        ExchangeAllianceBagRt.getDefaultInstance()
    ), // 从联盟仓库兑换东西

    ChangeAllianceBagSet_928(
        928,
        ChangeAllianceBagSet.getDefaultInstance(),
        ChangeAllianceBagSetRt.getDefaultInstance()
    ), // 修改联盟仓库捐献要求

    QueryJjcAllRank_930(
        930,
        QueryJjcAllRank.getDefaultInstance(),
        QueryJjcAllRankRt.getDefaultInstance()
    ), // 打开联盟boss界面

    QueryAllianceEffect_931(
        931,
        QueryAllianceEffect.getDefaultInstance(),
        QueryAllianceEffectRt.getDefaultInstance()
    ), // 查询联盟科技主界面

    AllianceEffectLvUp_932(
        932,
        AllianceEffectLvUp.getDefaultInstance(),
        AllianceEffectLvUpRt.getDefaultInstance()
    ), // 升级联盟科技

    AllianceDonate_933(
        933,
        AllianceDonate.getDefaultInstance(),
        AllianceDonateRt.getDefaultInstance()
    ), // 捐献联盟科技

    AllianceEffectFirstSet_934(
        934,
        AllianceEffectFirstSet.getDefaultInstance(),
        AllianceEffectFirstSetRt.getDefaultInstance()
    ), // 捐献联盟科技

    UseAllianceEffect_935(
        935,
        UseAllianceEffect.getDefaultInstance(),
        UseAllianceEffectRt.getDefaultInstance()
    ), // 使用联盟科技技能

    GetAllianceCompetitionOwnQuest_936(
        936,
        GetAllianceCompetitionOwnQuest.getDefaultInstance(),
        GetAllianceCompetitionOwnQuestRt.getDefaultInstance()
    ),

    RemoveAllianceCompetitionOwnQuest_937(
        937,
        RemoveAllianceCompetitionOwnQuest.getDefaultInstance(),
        RemoveAllianceCompetitionOwnQuestRt.getDefaultInstance()
    ),

    RewardAllianceCompetitionOwnQuest_938(
        938,
        RewardAllianceCompetitionOwnQuest.getDefaultInstance(),
        RewardAllianceCompetitionOwnQuestRt.getDefaultInstance()
    ),

    RefreshAllianceCompetitionOwnQuest_939(
        939,
        RefreshAllianceCompetitionOwnQuest.getDefaultInstance(),
        RefreshAllianceCompetitionOwnQuestRt.getDefaultInstance()
    ),

    QueryAllianceCompetitionTask_940(
        940,
        QueryAllianceCompetitionTask.getDefaultInstance(),
        QueryAllianceCompetitionTaskRt.getDefaultInstance()
    ),

    ReceiveAllAllianceCmpttReward_943(
        943,
        ReceiveAllAllianceCmpttReward.getDefaultInstance(),
        ReceiveAllAllianceCmpttRewardRt.getDefaultInstance()
    ),

    RefreshAllianceCompetitionQuest_944(
        944,
        RefreshAllianceCompetitionQuest.getDefaultInstance(),
        RefreshAllianceCompetitionQuestRt.getDefaultInstance()
    ),
    AllianceSpeakProcess_945(
        945,
        AllianceSpeakProcess.getDefaultInstance(),
        AllianceSpeakProcessRt.getDefaultInstance()
    ),
    QueryAllianceCompetitionRank_952(
        952,
        QueryAllianceCompetitionRank.getDefaultInstance(),
        QueryAllianceCompetitionRankRt.getDefaultInstance()
    ),
    QueryDinosaurHuntingEffect_953(
        953,
        QueryDinosaurHuntingEffect.getDefaultInstance(),
        QueryDinosaurHuntingEffectRt.getDefaultInstance()
    ),

    BeginEliminateFight_1000(
        1000,
        BeginEliminateFight.getDefaultInstance(),
        BeginEliminateFightRt.getDefaultInstance()
    ),
    EndEliminateFight_1001(1001, EndEliminateFight.getDefaultInstance(), EndEliminateFightRt.getDefaultInstance()),

    UpdateMainHero_1006(1006, UpdateMainHero.getDefaultInstance(), UpdateMainHeroRt.getDefaultInstance()), // 更换领主
    QueryHeroCarryNum_1007(1007, QueryHeroCarryNum.getDefaultInstance(), QueryHeroCarryNumRt.getDefaultInstance()),
    QueryHeroPower_1008(1008, QueryHeroPower.getDefaultInstance(), QueryHeroPowerRt.getDefaultInstance()),

    // (英雄无敌版)武将养成 1011-1020
    HeroLvUp_1011(1011, InvincibleHeroLvUp.getDefaultInstance(), InvincibleHeroLvUpRt.getDefaultInstance()), // 武将升级
    HeroStarLvUp_1012(
        1012,
        InvincibleHeroStarLvUp.getDefaultInstance(),
        InvincibleHeroStarLvUpRt.getDefaultInstance()
    ), // 武将升星
    HeroSuperUp_1013(
        1013,
        InvincibleHeroSuperUp.getDefaultInstance(),
        InvincibleHeroSuperUpRt.getDefaultInstance()
    ), // 武将进阶
    HeroFragmentExchange_1014(
        1014,
        HeroFragmentExchange.getDefaultInstance(),
        HeroFragmentExchangeRt.getDefaultInstance()
    ), // 英雄万能碎片兑换
    HeroOneKyUpQuery_1015(
        1015,
        HeroOneKyUpQuery.getDefaultInstance(),
        HeroOneKyUpQueryRt.getDefaultInstance()
    ), // 英雄一键升级查询
    HeroOneKyUpApply_1016(
        1016,
        HeroOneKyUpApply.getDefaultInstance(),
        HeroOneKyUpApplyRt.getDefaultInstance()
    ), // 英雄一键升级应用
    HeroGetStarLvUp_1019(
        1019,
        InvincibleHeroGetStarLvUp.getDefaultInstance(),
        InvincibleHeroGetStarLvUpRt.getDefaultInstance()
    ), // 武将兵团升级
    HeroReset_1021(
        1021,
        InvincibleHeroReset.getDefaultInstance(),
        InvincibleHeroResetRt.getDefaultInstance()
    ),  // 英雄重置
    InvincibleHeroPreviewSpending_1022(
        1022,
        InvincibleHeroPreviewSpending.getDefaultInstance(),
        InvincibleHeroPreviewSpendingRt.getDefaultInstance()
    ),
    HeroFragmentHistoryQuery_1023(
        1023,
        HeroFragmentHistoryQuery.getDefaultInstance(),
        HeroFragmentHistoryQueryRt.getDefaultInstance()
    ),
    ViewHeroPrisoned_1024(
        1024,
        ViewHeroPrisoned.getDefaultInstance(),
        ViewHeroPrisonedRt.getDefaultInstance()
    ),
    HeroBreakLvUp_1027(
        1027,
        HeroBreakLvUp.getDefaultInstance(),
        HeroBreakLvUpRt.getDefaultInstance()
    ),

    //英雄技能手动升级
    HeroSlgSkillLvUp_1028(1028, HeroSlgSkillLvUp.getDefaultInstance(), HeroSlgSkillLvUpRt.getDefaultInstance()),
    //英雄消耗道具升级预览
    HeroLvUpgradePreview_1029(
        1029,
        HeroLvUpgradePreview.getDefaultInstance(),
        HeroLvUpgradePreviewRt.getDefaultInstance()
    ),

    //英雄消耗道具升级
    HeroLvUpgrade_1030(1030, HeroLvUpgrade.getDefaultInstance(), HeroLvUpgradeRt.getDefaultInstance()),

    //链接英雄
    LinkHero_1031(1031, LinkHero.getDefaultInstance(), LinkHeroRt.getDefaultInstance()),
    //链接英雄断开
    BreakLinkHero_1032(1032, BreakLinkHero.getDefaultInstance(), BreakLinkHeroRt.getDefaultInstance()),
    //链接英雄万能碎片兑换
    LinkHeroFragmentExchange_1033(
        1033,
        LinkHeroFragmentExchange.getDefaultInstance(),
        LinkHeroFragmentExchangeRt.getDefaultInstance()
    ),
    //链接英雄升星
    LinkHeroStarLvUp_1034(1034, LinkHeroStarLvUp.getDefaultInstance(), LinkHeroStarLvUpRt.getDefaultInstance()),

    // 科技 1051-1060
    ResearchLvUp_1051(1051, ResearchLvUp.getDefaultInstance(), ResearchLvUpRt.getDefaultInstance()), // 升级科技
    CancelResearchLvUp_1052(
        1052,
        CancelResearchLvUp.getDefaultInstance(),
        CancelResearchLvUpRt.getDefaultInstance()
    ), // 取消升级科技

    // 查询科技信息
    QueryResearch_1053(1053, QueryResearch.getDefaultInstance(), QueryResearchRt.getDefaultInstance()),

    // 快速使用 1061-1070
    ClearTime_1061(1061, ClearTime.getDefaultInstance(), ClearTimeRt.getDefaultInstance()), // 秒加速
    BuyResShop_1062(1062, BuyResShop.getDefaultInstance(), BuyResShopRt.getDefaultInstance()), // 购买resShop表中物品
    UseProp_1063(1063, UseProp.getDefaultInstance(), UsePropRt.getDefaultInstance()), // 使用道具
    BuyAndUseProp_1064(1064, BuyAndUseProp.getDefaultInstance(), BuyAndUsePropRt.getDefaultInstance()), // 购买并使用道具
    DiamondConsumep_1065(1065, DiamondConsume.getDefaultInstance(), DiamondConsumeRt.getDefaultInstance()),
    SmithyExchangeSplit_1066(1066, SmithyExchangeSplit.getDefaultInstance(), SmithyExchangeSplitRt.getDefaultInstance()),

    // 联盟帮助 1071-1079
    OpenAllianceHelp_1071(
        1071,
        OpenAllianceHelp.getDefaultInstance(),
        OpenAllianceHelpRt.getDefaultInstance()
    ), // 打开联盟帮助
    SendAllianceHelp_1072(
        1072,
        SendAllianceHelp.getDefaultInstance(),
        SendAllianceHelpRt.getDefaultInstance()
    ), // 登记帮助信息
    GoAllianceHelp_1073(1073, GoAllianceHelp.getDefaultInstance(), GoAllianceHelpRt.getDefaultInstance()), // 帮助

    // 偷菜 1080 - 1090
    CabbageQuery_1080(
        1080,
        CabbageQuery.getDefaultInstance(),
        CabbageQueryRt.getDefaultInstance()
    ), // 偷菜查询自己的数据
    CabbagePlant_1081(
        1081,
        CabbagePlant.getDefaultInstance(),
        CabbagePlantRt.getDefaultInstance()
    ), // 偷菜种菜
    CabbageHarvest_1082(
        1082,
        CabbageHarvest.getDefaultInstance(),
        CabbageHarvestRt.getDefaultInstance()
    ), // 偷菜收菜
    CabbageViewOther_1083(
        1083,
        CabbageViewOther.getDefaultInstance(),
        CabbageViewOtherRt.getDefaultInstance()
    ), // 偷菜查看其他玩家
    CabbageRollTarget_1084(
        1084,
        CabbageRollTarget.getDefaultInstance(),
        CabbageRollTargetRt.getDefaultInstance()
    ), // 偷菜摇人
    CabbageStealTarget_1085(
        1085,
        CabbageStealTarget.getDefaultInstance(),
        CabbageStealTargetRt.getDefaultInstance()
    ), // 偷菜盗窃
    CabbageDrawLvReward_1086(
        1086,
        CabbageDrawLvReward.getDefaultInstance(),
        CabbageDrawLvRewardRt.getDefaultInstance()
    ), // 偷菜等级奖励领取
    CabbageBuyExp_1087(
        1087,
        CabbageBuyExp.getDefaultInstance(),
        CabbageBuyExpRt.getDefaultInstance()
    ), // 偷菜购买经验

    // 君主功能 1211-1250
    QueryKingInfo_1216(1216, QueryKingInfo.getDefaultInstance(), QueryKingInfoRt.getDefaultInstance()), // 查询君主信息

    LordEquipUp_1240(1240, LordEquipUp.getDefaultInstance(), LordEquipUpRt.getDefaultInstance()), // 领主装备锻造/升级
    LordEquipStoneUp_1241(
        1241,
        LordEquipStoneUp.getDefaultInstance(),
        LordEquipStoneUpRt.getDefaultInstance()
    ), // 领主装备宝石锻造/升级
    LordTalentUp_1242(1242, LordTalentUp.getDefaultInstance(), LordTalentUpRt.getDefaultInstance()), // 领主天赋升级
    LordTalentReset_1243(1243, LordTalentReset.getDefaultInstance(), LordTalentResetRt.getDefaultInstance()), // 领主天赋重置
    LordTalentPageSwitch_1244(
        1244,
        LordTalentPageSwitch.getDefaultInstance(),
        LordTalentPageSwitchRt.getDefaultInstance()
    ), // 领主天赋页切换
    LordTalentSkillExecute_1245(
        1245,
        LordTalentSkillExecute.getDefaultInstance(),
        LordTalentSkillExecuteRt.getDefaultInstance()
    ), // 领主天赋技能释放
    LordEquipClassSwitch_1246(
        1246,
        LordEquipClassSwitch.getDefaultInstance(),
        LordEquipClassSwitchRt.getDefaultInstance()
    ), // 领主装备类型(套装)切换
    LordEquipStrength_1247(
        1247,
        LordEquipStrength.getDefaultInstance(),
        LordEquipStrengthRt.getDefaultInstance()
    ), // 领主装备强化
    //领主等级一键升级预览
    LordOneClickLvUpgradePreview_1248(
        1248,
        LordOneClickLvUpgradePreview.getDefaultInstance(),
        LordOneClickLvUpgradePreviewRt.getDefaultInstance()
    ),

    //领主等级一键升级应用
    LordOneClickLvUpgrade_1249(1249, LordOneClickLvUpgrade.getDefaultInstance(), LordOneClickLvUpgradeRt.getDefaultInstance()),

    // 战斗相关 1251-1299
    WatchWalkGroup_1251(1251, WatchWalkGroup.getDefaultInstance(), WatchWalkGroupRt.getDefaultInstance()),  // 查看行军组
    QueryWalkLineDetailInfo_1252(
        1252,
        QueryWalkLineDetailInfo.getDefaultInstance(),
        QueryWalkLineDetailInfoRt.getDefaultInstance()
    ),
    GoBackHome_1253(1253, GoBackHome.getDefaultInstance(), GoBackHomeRt.getDefaultInstance()), // 召回部队
    StartMass_1254(1254, StartMass.getDefaultInstance(), StartMassRt.getDefaultInstance()), // 发起集结
    CancelMass_1255(1255, CancelMass.getDefaultInstance(), CancelMassRt.getDefaultInstance()),  // 取消集结
    QueryAllianceMassInfo_1256(
        1256,
        QueryAllianceMassInfo.getDefaultInstance(),
        QueryAllianceMassInfoRt.getDefaultInstance()
    ), // 查询集结信息
    SetForceOrder_1257(1257, SetForceOrder.getDefaultInstance(), SetForceOrderRt.getDefaultInstance()), // 设置部队顺序
    QueryAllianceMemberPos_1258(
        1258,
        QueryAllianceMemberPos.getDefaultInstance(),
        QueryAllianceMemberPosRt.getDefaultInstance()
    ), // 查询联盟成员坐标
    SendMassMemberHome_1259(
        1259,
        SendMassMemberHome.getDefaultInstance(),
        SendMassMemberHomeRt.getDefaultInstance()
    ), // 集结成员遣返回家
    SendReinforcePlayerHome_1260(
        1260,
        SendReinforcePlayerHome.getDefaultInstance(),
        SendReinforcePlayerHomeRt.getDefaultInstance()
    ),   // 遣返增援玩家
    QueryWarnInfo_1261(1261, QueryWarnInfo.getDefaultInstance(), QueryWarnInfoRt.getDefaultInstance()), // 查询预警信息
    QueryReinforceSoldierInfo_1262(
        1262,
        QueryReinforceSoldierInfo.getDefaultInstance(),
        QueryReinforceSoldierInfoRt.getDefaultInstance()
    ), // 查询增援容量
    CheckCanMass_1263(1263, CheckCanMass.getDefaultInstance(), CheckCanMassRt.getDefaultInstance()),    // 检测目标点能否集结
    QueryMassInfo_1264(1264, QueryMassInfo.getDefaultInstance(), QueryMassInfoRt.getDefaultInstance()), // 查询集结兵量
    QueryReinforceForceNum_1265(
        1265,
        QueryReinforceForceNum.getDefaultInstance(),
        QueryReinforceForceNumRt.getDefaultInstance()
    ), // 查找增援部队数量
    SetArmyPlan_1266(1266, SetArmyPlan.getDefaultInstance(), SetArmyPlanRt.getDefaultInstance()), // 设置英雄战部队预设
    GetArmyPlan_1267(1267, GetArmyPlan.getDefaultInstance(), GetArmyPlanRt.getDefaultInstance()), // 获取英雄战部队预设

    CheckAllianceArea_1268(
        1268,
        CheckAllianceArea.getDefaultInstance(),
        CheckAllianceAreaRt.getDefaultInstance()
    ), // 检测是否自己的联盟领地

    // Cp爬塔 1280 - 1299
    CpTowerCheckDailyReward_1280(1280, CpTowerCheckDailyReward.getDefaultInstance(), CpTowerCheckDailyRewardRt.getDefaultInstance()), // Cp查询每日奖励
    CpTowerAcceptDailyReward_1281(1281, CpTowerAcceptDailyReward.getDefaultInstance(), CpTowerAcceptDailyRewardRt.getDefaultInstance()), // Cp领取每日奖励
    CpTowerCheckHangUpReward_1282(1282, CpTowerCheckHangUpReward.getDefaultInstance(), CpTowerCheckHangUpRewardRt.getDefaultInstance()), // Cp爬塔查看挂机奖励
    CpTowerAcceptHangUpReward_1283(1283, CpTowerAcceptHangUpReward.getDefaultInstance(), CpTowerAcceptHangUpRewardRt.getDefaultInstance() ), // Cp爬塔领取挂机奖励
    CheckCpTower_1290(1290, CheckCpTower.getDefaultInstance(), CheckCpTowerRt.getDefaultInstance()), // Cp爬塔信息查询
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    CpTowerStartFight_1291(
        1291,
        CpTowerStartFight.getDefaultInstance(),
        CpTowerStartFightRt.getDefaultInstance()
    ),// Cp爬塔开始战斗
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    CpTowerFinishFight_1292(
        1292,
        CpTowerFinishFight.getDefaultInstance(),
        CpTowerFinishFightRt.getDefaultInstance()
    ), // Cp爬塔战斗结算
    CpTowerQuickPass_1293(
        1293,
        CpTowerQuickPass.getDefaultInstance(),
        CpTowerQuickPassRt.getDefaultInstance()
    ), // Cp爬塔一键通关
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    CpTowerDrawOutputRes_1294(
        1294,
        CpTowerDrawOutputRes.getDefaultInstance(),
        CpTowerDrawOutputResRt.getDefaultInstance()
    ), // Cp爬塔挂机奖励领取
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    CpTowerDrawStarReward_1295(
        1295,
        CpTowerDrawStarReward.getDefaultInstance(),
        CpTowerDrawStarRewardRt.getDefaultInstance()
    ), // Cp爬塔累积星级奖励领取
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    CpTowerSweep_1296(
        1296,
        CpTowerSweep.getDefaultInstance(),
        CpTowerSweepRt.getDefaultInstance()
    ), // Cp爬塔满星扫荡
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    CpQuickAfk_1297(
        1297,
        CpQuickAfk.getDefaultInstance(),
        CpQuickAfkRt.getDefaultInstance()
    ), // 爬塔快速挂机

    // 迁服 1300 - 1310
    MoveServer_1300(1300, MoveServer.getDefaultInstance(), MoveServerRt.getDefaultInstance()), //  迁服
    InitPlayerSessionAfterMoveServer_1301(
        1301,
        InitPlayerSessionAfterMoveServer.getDefaultInstance(),
        InitPlayerSessionAfterMoveServerRt.getDefaultInstance()
    ), //  迁服成功初始化数据
    AllServerInfo_1302(1302, AllServerInfo.getDefaultInstance(), AllServerInfoRt.getDefaultInstance()), //  迁服列表
    MoveServerCost_1303(
        1303,
        MoveServerCost.getDefaultInstance(),
        MoveServerCostRt.getDefaultInstance()
    ), //  请求我的战斗力在即将迁往的目标服务器上的排名

    FindChangeServers_1304(
        1304,
        FindChangeServers.getDefaultInstance(),
        FindChangeServersRt.getDefaultInstance()
    ), //  查看所有可前往的服务器信息

    ChangePlayer_1305(
        1305,
        ChangePlayer.getDefaultInstance(),
        ChangePlayerRt.getDefaultInstance()
    ), // 转服

    FindAllRoles_1306(1306, FindAllRoles.getDefaultInstance(), FindAllRolesRt.getDefaultInstance()), // 查找所有角色

    // 商店 1311 - 1319
    ShopTotalBuy_1311(1311, BuyShopTotal.getDefaultInstance(), BuyShopTotalRt.getDefaultInstance()), // 商店购买物品
    ShopLimitTotalBuy_1312(
        1312,
        BuyLimitShopTotal.getDefaultInstance(),
        BuyLimitShopTotalRt.getDefaultInstance()
    ), // 商店购买物品
    AllianceShopQuery_1313(
        1313,
        AllianceShopQuery.getDefaultInstance(),
        AllianceShopQueryRt.getDefaultInstance()
    ), // 联盟随机商店查询
    AllianceShopBuyDay_1314(
        1314,
        AllianceShopBuyDay.getDefaultInstance(),
        AllianceShopBuyDayRt.getDefaultInstance()
    ), // 联盟随机商店每日购买
    PersonalShopQuery_1316(
        1316,
        PersonalShopQuery.getDefaultInstance(),
        PersonalShopQueryRt.getDefaultInstance()
    ),
    PersonalShopExchange_1317(
        1317,
        PersonalShopExchange.getDefaultInstance(),
        PersonalShopExchangeRt.getDefaultInstance()
    ),
    WxGiftCenter_1318(
        1318,
        WxGiftCenter.getDefaultInstance(),
        WxGiftCenterRt.getDefaultInstance()
    ),

    EliminateRandomEventAtkStart_1351(
        1351,
        EliminateRandomEventAtkStart.getDefaultInstance(),
        EliminateRandomEventAtkStartRt.getDefaultInstance()
    ), // 内城随机事件三消战斗开始
    EliminateRandomEventAtkFinsh_1352(
        1352,
        EliminateRandomEventAtkFinish.getDefaultInstance(),
        EliminateRandomEventAtkFinishRt.getDefaultInstance(),
    ), // 内城随机事件三消战斗结束
    SlgRandomEventAtkStart_1353(
        1353,
        SlgRandomEventAtkStart.getDefaultInstance(),
        SlgRandomEventAtkStartRt.getDefaultInstance()
    ), // 内城随机事件三消战斗
    RandomEventFortuneRoll_1354(
        1354,
        RandomEventFortuneRoll.getDefaultInstance(),
        RandomEventFortuneRollRt.getDefaultInstance()
    ), // 内城随机事件摇天降鸿运倍率
    RandomEventFortuneDraw_1355(
        1355,
        RandomEventFortuneDraw.getDefaultInstance(),
        RandomEventFortuneDrawRt.getDefaultInstance()
    ), // 内城随机事件领取天降鸿运奖励

    // 英雄部件操作 装备 脱下
    HeroComponentOpt_1356(
        1356,
        HeroComponentOpt.getDefaultInstance(),
        HeroComponentOptRt.getDefaultInstance()
    ),

    // 英雄部件升级 强化 重铸
    HeroComponentLvUp_1357(
        1357,
        HeroComponentLvUp.getDefaultInstance(),
        HeroComponentLvUpRt.getDefaultInstance()
    ),

    // 获取捕鱼的数据
    QueryDinoFishingData_1358(
        1358,
        QueryDinoFishingData.getDefaultInstance(),
        QueryDinoFishingDataRt.getDefaultInstance()
    ),

    //  捕鱼领奖
    ReceiveDinoFishingReward_1359(
        1359,
        ReceiveDinoFishingReward.getDefaultInstance(),
        ReceiveDinoFishingRewardRt.getDefaultInstance()
    ),

    //  捕鱼活动数据
    QueryDinoFishingActivityData_1360(
        1360,
        QueryDinoFishingActivityData.getDefaultInstance(),
        QueryDinoFishingActivityDataRt.getDefaultInstance()
    ),

    //  获取量子实验室数据
    QueryQuantumLaboratoryData_1361(
        1361,
        QueryQuantumLaboratoryData.getDefaultInstance(),
        QueryQuantumLaboratoryDataRt.getDefaultInstance()
    ),

    //  获取量子实验室数据
    QuantumLaboratoryTransform_1362(
        1362,
        QuantumLaboratoryTransform.getDefaultInstance(),
        QuantumLaboratoryTransformRt.getDefaultInstance()
    ),

    //  获取量子实验室数据
    ReceiveQuantumLaboratoryRangeReward_1363(
        1363,
        ReceiveQuantumLaboratoryRangeReward.getDefaultInstance(),
        ReceiveQuantumLaboratoryRangeRewardRt.getDefaultInstance()
    ),
    HeroGearLvUp_1364(1364, HeroGearLvUp.getDefaultInstance(), HeroGearLvUpRt.getDefaultInstance()),
    HeroGearEquip_1365(1365, HeroGearEquip.getDefaultInstance(), HeroGearEquipRt.getDefaultInstance()),
    QueryHeroGear_1366(1366, QueryHeroGear.getDefaultInstance(), QueryHeroGearRt.getDefaultInstance()),

    // 在线礼包消息号 1401 - 1410
    GetOnlineReward_1401(1401, GetOnlineReward.getDefaultInstance(), GetOnlineRewardRt.getDefaultInstance()), // 领取在线礼包
    OpenOnlineReward_1402(
        1402, OpenOnlineReward.getDefaultInstance(), OpenOnlineRewardRt.getDefaultInstance()
    ), // 打开在线礼包

    RefHuoyueduTask_1403(
        1403,
        RefHuoyueduTask.getDefaultInstance(),
        RefHuoyueduTaskRt.getDefaultInstance()
    ), // 请求刷新活跃度任务
    GetHuoyueduReward_1404(
        1404,
        GetHuoyueduReward.getDefaultInstance(),
        GetHuoyueduRewardRt.getDefaultInstance()
    ), // 领取活跃度档位奖励

    GetAppreciationReward_1405(
        1405,
        GetAppreciationReward.getDefaultInstance(),
        GetAppreciationRewardRt.getDefaultInstance()
    ), // 领取犒赏令档位奖励

    GetTotalPayReward_1406(
        1406,
        GetTotalPayReward.getDefaultInstance(),
        GetTotalPayRewardRt.getDefaultInstance()
    ), // 领取累充奖励

    // 军事备战奖励(循环活跃度)
    QueryMillitaryScore_1407(
        1407,
        QueryMillitaryScore.getDefaultInstance(),
        QueryMillitaryScoreRt.getDefaultInstance()
    ),
    GetMillitaryStepReward_1408(
        1408,
        GetMillitaryStepReward.getDefaultInstance(),
        GetMillitaryStepRewardRt.getDefaultInstance()
    ),
    GetTimintReward_1409(
        1409,
        GetTimintReward.getDefaultInstance(),
        GetTimintRewardRt.getDefaultInstance()
    ),
    UnlockAppreciationStep_1410(
        1410,
        UnlockAppreciationStep.getDefaultInstance(),
        UnlockAppreciationStepRt.getDefaultInstance()
    ), // 犒赏令解锁档位奖励

    GetMonthReward_1424(
        1424,
        GetMonthReward.getDefaultInstance(),
        GetMonthRewardRt.getDefaultInstance()
    ),// 领取月卡每日奖励

    GetClubCardInfos_1425(
        1425,
        GetClubCardInfos.getDefaultInstance(),
        GetClubCardInfosRt.getDefaultInstance()
    ),// 获取玩家拥有和可购买的礼品信息

    // 巨龙探索：1430-1440,1433-1436挂机
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    ClimbTowerQueryInfos_1430(
        1430,
        ClimbTowerQueryInfos.getDefaultInstance(),
        ClimbTowerQueryInfosRt.getDefaultInstance()
    ), // 爬塔信息查询

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    ClimbTowerBattleStart_1431(
        1431,
        ClimbTowerBattleStart.getDefaultInstance(),
        ClimbTowerBattleStartRt.getDefaultInstance()
    ), // 爬塔三消战斗开始
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    ClimbTowerBattleEnd_1432(
        1432,
        ClimbTowerBattleEnd.getDefaultInstance(),
        ClimbTowerBattleEndRt.getDefaultInstance()
    ),// 爬塔三消战斗结束
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    AfkQueryOrSetBattleArray_1433(
        1433, AfkQueryOrSetBattleArray.getDefaultInstance(),
        AfkQueryOrSetBattleArrayRt.getDefaultInstance()
    ), // 挂机阵容查询或者设置
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    AfkQueryAllRewards_1434(
        1434,
        AfkQueryAllRewards.getDefaultInstance(),
        AfkQueryAllRewardsRt.getDefaultInstance()
    ), // 查询挂机全部奖励
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    AfkGetReward_1435(
        1435,
        AfkGetReward.getDefaultInstance(),
        AfkGetRewardRt.getDefaultInstance()

    ), // 挂机奖励领取
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    AfkQueryOrSetLevel_1436(
        1436,
        AfkQueryOrSetLevel.getDefaultInstance(),
        AfkQueryOrSetLevelRt.getDefaultInstance()
    ),// 查询或设置挂机关卡
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    ClimbTowerChapterRewardGet_1438(
        1438,
        ClimbTowerChapterRewardGet.getDefaultInstance(),
        ClimbTowerChapterRewardGetRt.getDefaultInstance()
    ),// 爬塔层奖励领取

    // 成就消息 1451 - 1454
    GetPurchaseActivityStepReward_1452(
        1452,
        GetPurchaseActivityStepReward.getDefaultInstance(),
        GetPurchaseActivityStepRewardRt.getDefaultInstance()
    ), // 领取自定义活动的阶段奖励

    BuyPurchaseActivity_1453(
        1453,
        BuyPurchaseActivity.getDefaultInstance(),
        BuyPurchaseActivityRt.getDefaultInstance()
    ), // 领取自定义活动的阶段奖励

    GetPurchaseActivityFreeReward_1454(
        1454,
        GetPurchaseActivityFreeReward.getDefaultInstance(),
        GetPurchaseActivityFreeRewardRt.getDefaultInstance()
    ), // 领取自定义活动每日免费礼包

    // 国王官职消息 1455 - 1469
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    SetCountryPosition_1455(
        1455,
        SetCountryPosition.getDefaultInstance(),
        SetCountryPositionRt.getDefaultInstance()
    ), // 设置国家官职
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    AwardAlliance_1456(1456, AwardAlliance.getDefaultInstance(), AwardAllianceRt.getDefaultInstance()), // 赏赐
    GetGiftTypesFreeReward_1457(
        1457,
        GetGiftTypesFreeReward.getDefaultInstance(),
        GetGiftTypesFreeRewardRt.getDefaultInstance()
    ),

    SendNoticeToLeaderOfAlliance_1460(
        1460,
        SendNoticeToLeaderOfAlliance.getDefaultInstance(),
        SendNoticeToLeaderOfAllianceRt.getDefaultInstance()
    ), // 发送公告给盟主
    QueryFameHall_1464(
        1464,
        QueryFameHall.getDefaultInstance(),
        QueryFameHallRt.getDefaultInstance()
    ), // 查询名人堂
    QueryWonderForce_1465(
        1465,
        QueryWonderForce.getDefaultInstance(),
        QueryWonderForceRt.getDefaultInstance()
    ), // 查询奇观部队信息

    // 放弃奇观
    GiveUpWonder_1467(1467, GiveUpWonder.getDefaultInstance(), GiveUpWonderRt.getDefaultInstance()),

    EliminateFightError_1478(
        1478,
        EliminateFightError.getDefaultInstance(),
        EliminateFightErrorRt.getDefaultInstance()
    ), // 三消战斗

    // 魔物消息 1489-1510

    // 补充体力
    SupplyEnergy_1494(
        1494,
        SupplyEnergy.getDefaultInstance(),
        SupplyEnergyRt.getDefaultInstance()
    ),

    // 料理食堂 1500-1509
    CookingInfoQuery_1500(
        1500,
        CookingInfoQuery.getDefaultInstance(),
        CookingInfoQueryRt.getDefaultInstance()
    ), // 查询食堂餐桌情况
    CookingStart_1501(
        1501,
        CookingStart.getDefaultInstance(),
        CookingStartRt.getDefaultInstance()
    ), // 开始烹饪
    CookingDraw_1502(
        1502,
        CookingDraw.getDefaultInstance(),
        CookingDrawRt.getDefaultInstance()
    ), // 领取烹饪好的食品(需要至少1个可领取)
    CookingAdjust_1503(
        1503,
        CookingAdjust.getDefaultInstance(),
        CookingAdjustRt.getDefaultInstance()
    ), // 增减原料(需要当前队列至少1个没有好)

    // 城墙
    QueryWallInfo_1540(1540, QueryWallInfo.getDefaultInstance(), QueryWallInfoRt.getDefaultInstance()),
    RepairWall_1541(1541, RepairWall.getDefaultInstance(), RepairWallRt.getDefaultInstance()),
    WallFireFight_1542(1542, WallFireFight.getDefaultInstance(), QueryWallInfoRt.getDefaultInstance()),
    WallStatisticsDataQuery_1543(
        1543,
        WallStatisticsDataQuery.getDefaultInstance(),
        WallStatisticsDataQueryRt.getDefaultInstance()
    ),

    // 1545~1555 抽卡
    QueryLottery_1545(1545, QueryLottery.getDefaultInstance(), QueryLotteryRt.getDefaultInstance()),
    PlayLottery_1546(1546, PlayLottery.getDefaultInstance(), PlayLotteryRt.getDefaultInstance()),
    PlayLotteryByWeight_1547(
        1547,
        PlayLotteryByWeight.getDefaultInstance(),
        PlayLotteryByWeightRt.getDefaultInstance()
    ),
    ReceiveLotteryReachProp_1550(
        1550,
        ReceiveLotteryReachProp.getDefaultInstance(),
        ReceiveLotteryReachPropRt.getDefaultInstance()
    ),
    //领取抽将积分奖励
    PlayLotteryScoreReward_1551(
        1551,
        PlayLotteryScoreReward.getDefaultInstance(),
        PlayLotteryScoreRewardRt.getDefaultInstance()
    ),

    // 活动抽卡type=17(权重)
    PlayActivityLotteryByWeight_1552(
        1552,
        PlayActivityLotteryByWeight.getDefaultInstance(),
        PlayActivityLotteryByWeightRt.getDefaultInstance()
    ),


    // 奇观争夺战活动
    QueryWonderInfo_1571(1571, QueryWonderInfo.getDefaultInstance(), QueryWonderInfoRt.getDefaultInstance()),
    QueryWonderRank_1572(1572, QueryWonderRank.getDefaultInstance(), QueryWonderRankRt.getDefaultInstance()),
    QueryWonderKillRank_1573(1573, QueryWonderKillRank.getDefaultInstance(), QueryWonderKillRankRt.getDefaultInstance()),
    QueryWonderStatistics_1574(1574, QueryWonderStatistics.getDefaultInstance(), QueryWonderStatisticsRt.getDefaultInstance()),

    // 查询他人信息
    OtherPersonalPower_1576(1576, OtherPersonalPower.getDefaultInstance(), OtherPersonalPowerRt.getDefaultInstance()),

    // 游戏设置
    GetNoticeSetting_1580(1580, GetNoticeSetting.getDefaultInstance(), GetNoticeSettingRt.getDefaultInstance()),
    ChangeNoticeSetting_1581(
        1581,
        ChangeNoticeSetting.getDefaultInstance(),
        ChangeNoticeSettingRt.getDefaultInstance()
    ),

    // 开服活动
    GetResetLoginGift_1584(1584, GetResetLoginGift.getDefaultInstance(), GetResetLoginGiftRt.getDefaultInstance()),
    GetLoginGift_1585(1585, GetLoginGift.getDefaultInstance(), GetLoginGiftRt.getDefaultInstance()),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    BuyGrowthFund_1586(1586, BuyGrowthFund.getDefaultInstance(), BuyGrowthFundRt.getDefaultInstance()),
    GetLoginAutoGift_1587(1587, GetLoginAutoGift.getDefaultInstance(), GetLoginAutoGiftRt.getDefaultInstance()),
    BuyPurchase_1588(1588, BuyPurchase.getDefaultInstance(), BuyPurchaseRt.getDefaultInstance()),
    GetHomeActivityReward_1589(
        1589,
        GetHomeActivityReward.getDefaultInstance(),
        GetHomeActivityRewardRt.getDefaultInstance()
    ),
    QueryDailyReward_1590(1590, QueryDailyReward.getDefaultInstance(), QueryDailyRewardRt.getDefaultInstance()),
    ReceiveDailyReward_1591(1591, ReceiveDailyReward.getDefaultInstance(), ReceiveDailyRewardRt.getDefaultInstance()),

    // 修改语言
    ChangePlayerLan_1604(1604, ChangePlayerLan.getDefaultInstance(), ChangePlayerLanRt.getDefaultInstance()),

    // 查询标记信息
    QueryMark_1606(1606, QueryMark.getDefaultInstance(), QueryMarkRt.getDefaultInstance()),

    // 查询buff信息
    QueryBuff_1612(1612, QueryBuff.getDefaultInstance(), QueryBuffRt.getDefaultInstance()),

    // 查询任务
    QueryTask_1615(1615, QueryTask.getDefaultInstance(), QueryTaskRt.getDefaultInstance()),

    // 查询任务(批量)
    BatchQueryTask_1616(1616, BatchQueryTask.getDefaultInstance(), BatchQueryTaskRt.getDefaultInstance()),

    // 刷新活动任务
    RefreshActivityTask_1617(1617, RefreshActivityTask.getDefaultInstance(), RefreshActivityTaskRt.getDefaultInstance()),

    // 探测屋在线奖励
    ReceiveRadarOnlineReward_1618(1618, ReceiveRadarOnlineReward.getDefaultInstance(), ReceiveRadarOnlineRewardRt.getDefaultInstance()),

    // 查询皮肤
    QuerySkin_1619(1619, QuerySkin.getDefaultInstance(), QuerySkinRt.getDefaultInstance()),

    // 修改头像
    QueryPhoto_1621(1621, QueryPhoto.getDefaultInstance(), QueryPhotoRt.getDefaultInstance()),

    // 修改头像
    ChangePhoto_1622(1622, ChangePhoto.getDefaultInstance(), ChangePhotoRt.getDefaultInstance()),

    // 查询头像
    BuyPhoto_1623(1623, BuyPhoto.getDefaultInstance(), BuyPhotoRt.getDefaultInstance()),

    // 查询头像url
    @Deprecated("ED_废弃")
    QueryPictureUrl_1624(1624, QueryPictureUrl.getDefaultInstance(), QueryPictureUrlRt.getDefaultInstance()),

    //查询skin模块加成(皮肤(包含护卫)，头像框)
    QuerySkinEffectInfo_1625(
        1625,
        QuerySkinEffectInfo.getDefaultInstance(),
        QuerySkinEffectInfoRt.getDefaultInstance()
    ),

    // 上传自定义头像
    UploadPictureUrl_1626(1626, UploadPictureUrl.getDefaultInstance(), UploadPictureUrlRt.getDefaultInstance()),


    // 举报自定义头像
    @Deprecated("ED_暂时保留, 等外网前端经历过强更之后删除")
    ReportPictureUrl_1627(1627, ReportPictureUrl.getDefaultInstance(), ReportPictureUrlRt.getDefaultInstance()),

    // 刷新建筑视图
    RefreshHomeBuildingView_1631(
        1631,
        RefreshHomeBuildingView.getDefaultInstance(),
        RefreshHomeBuildingViewRt.getDefaultInstance()
    ),
    BarracksQuickMakeQuery_1664(
        1664,
        BarracksQuickMakeQuery.getDefaultInstance(),
        BarracksQuickMakeQueryRt.getDefaultInstance()
    ), // 兵营快速造兵查询
    BarracksQuickMakeApply_1665(
        1665,
        BarracksQuickMakeApply.getDefaultInstance(),
        BarracksQuickMakeApplyRt.getDefaultInstance()
    ), // 兵营快速造兵应用
    BarracksQuickUpQuery_1666(
        1666,
        BarracksQuickUpQuery.getDefaultInstance(),
        BarracksQuickUpQueryRt.getDefaultInstance()
    ), // 兵营快速升阶查询
    BarracksQuickUpApply_1667(
        1667,
        BarracksQuickUpApply.getDefaultInstance(),
        BarracksQuickUpApplyRt.getDefaultInstance()
    ), // 兵营快速升阶应用

    BarracksWoundedDismiss_1668(
        1668,
        BarracksWoundedDismiss.getDefaultInstance(),
        BarracksWoundedDismissRt.getDefaultInstance()
    ), // 遣散伤兵
    BarracksDismiss_1669(
        1669,
        BarracksDismiss.getDefaultInstance(),
        BarracksDismissRt.getDefaultInstance()
    ), // 遣散士兵
    QueryBarracksCancel_1670(
        1670,
        QueryBarracksCancel.getDefaultInstance(),
        QueryBarracksCancelRt.getDefaultInstance()
    ), // 查询取消返还的资源
    BarracksMakeStart_1671(
        1671,
        BarracksMakeStart.getDefaultInstance(),
        BarracksMakeStartRt.getDefaultInstance()
    ),  // 开始造兵
    BarracksMakeCancel_1672(
        1672,
        BarracksMakeCancel.getDefaultInstance(),
        BarracksMakeCancelRt.getDefaultInstance()
    ), // 取消造兵
    BarracksUpStart_1673(1673, BarracksUpStart.getDefaultInstance(), BarracksUpStartRt.getDefaultInstance()), // 士兵开始升阶
    BarracksUpCancel_1674(
        1674,
        BarracksUpCancel.getDefaultInstance(),
        BarracksUpCancelRt.getDefaultInstance()
    ), // 士兵升阶取消
    BarracksWoundedSoldierCure_1675(
        1675,
        BarracksWoundedSoldierCure.getDefaultInstance(),
        BarracksWoundedSoldierCureRt.getDefaultInstance()
    ), // 开始治疗伤兵
    BarracksQueueDraw_1676(
        1676,
        BarracksQueueDraw.getDefaultInstance(),
        BarracksQueueDrawRt.getDefaultInstance()
    ), // 手动领取兵营队列
    BarracksQueryNewUnlock_1677(
        1677,
        BarracksQueryNewUnlock.getDefaultInstance(),
        BarracksQueryNewUnlockRt.getDefaultInstance()
    ), // 查询新解锁的兵种
    BarracksWoundedSoldierCureCancel_1678(
        1678,
        BarracksWoundedSoldierCureCancel.getDefaultInstance(),
        BarracksWoundedSoldierCureCancelRt.getDefaultInstance()
    ), // 伤兵治疗取消
    BarracksWoundedSoldierCureCancelQuery_1679(
        1679,
        BarracksWoundedSoldierCureCancelQuery.getDefaultInstance(),
        BarracksWoundedSoldierCureCancelQueryRt.getDefaultInstance()
    ), // 伤兵治疗取消查询

    // 远征
    ExpeditionQuery_1680(
        1680,
        ExpeditionQuery.getDefaultInstance(),
        ExpeditionQueryRt.getDefaultInstance()
    ),

    ExpeditionSlgFight_1681(
        1681,
        ExpeditionSlgFight.getDefaultInstance(),
        ExpeditionSlgFightRt.getDefaultInstance()
    ),

    ExpeditionReset_1682(
        1682,
        ExpeditionReset.getDefaultInstance(),
        ExpeditionResetRt.getDefaultInstance()
    ),

    ExpeditionReceiveOutput_1683(
        1683,
        ExpeditionReceiveOutput.getDefaultInstance(),
        ExpeditionReceiveOutputRt.getDefaultInstance()
    ),
    ExpeditionQuickAfk_1684(
        1684,
        ExpeditionQuickAfk.getDefaultInstance(),
        ExpeditionQuickAfkRt.getDefaultInstance()
    ),
    ExpeditionChapterReward_1687(
        1687,
        ExpeditionChapterReward.getDefaultInstance(),
        ExpeditionChapterRewardRt.getDefaultInstance()
    ),
    ExpeditionHangUp_1688(
        1688,
        ExpeditionHangUp.getDefaultInstance(),
        ExpeditionHangUpRt.getDefaultInstance()
    ),
    BarracksRefugeSoldier_1689(
        1689,
        BarracksRefugeSoldier.getDefaultInstance(),
        BarracksRefugeSoldierRt.getDefaultInstance()
    ),// 避难所开始藏兵
    BarracksRefugeSoldierCancel_1690(
        1690,
        BarracksRefugeSoldierCancel.getDefaultInstance(),
        BarracksRefugeSoldierCancelRt.getDefaultInstance()
    ),//避难所藏兵召回

    ReceiveBattleFieldRewardBox_1691(
        1691,
        ReceiveBattleFieldRewardBox.getDefaultInstance(),
        ReceiveBattleFieldRewardBoxRt.getDefaultInstance()
    ),// 领取中立战场宝箱

    AutoMakeSoldierFuncChangeSwitch_1692(
        1692,
        AutoMakeSoldierFuncChangeSwitch.getDefaultInstance(),
        AutoMakeSoldierFuncChangeSwitchRt.getDefaultInstance()
    ), //自动造兵开关切换

    // 客户端报备购买付费礼包
    BuyGiftPackage_1701(1701, BuyGiftPackage.getDefaultInstance(), BuyGiftPackageRt.getDefaultInstance()),

    // 客户端取消报备购买付费礼包
    CancelBuyGiftPackage_1702(
        1702,
        CancelBuyGiftPackage.getDefaultInstance(),
        CancelBuyGiftPackageRt.getDefaultInstance()
    ),

    // 请求玩家当前购买的礼包状态
    QueryBuyGiftPackageInfo_1703(
        1703,
        QueryBuyGiftPackageInfo.getDefaultInstance(),
        QueryBuyGiftPackageInfoRt.getDefaultInstance()
    ),

    PayNotice_1705(1705, PayNotice.getDefaultInstance(), PayNoticeRt.getDefaultInstance()),

    FindCanBuyGiftPackage_1706(1706, FindCanBuyGiftPackage.getDefaultInstance(), FindCanBuyGiftPackageRt.getDefaultInstance()),

    // 腾讯点券兑换成钻石
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    ExchangeTencentRmb_1708(1708, ExchangeTencentRmb.getDefaultInstance(), ExchangeTencentRmbRt.getDefaultInstance()),

    // 购买活动带的自选礼包
    BuyPurchaseActivityDiyGiftPackage_1709(1709, BuyPurchaseActivityDiyGiftPackage.getDefaultInstance(), BuyPurchaseActivityDiyGiftPackageRt.getDefaultInstance()),

    // GM获得礼包
    GmBuyGiftPackage_1712(1712, GmBuyGiftPackage.getDefaultInstance(), GmBuyGiftPackageRt.getDefaultInstance()),

    // 更换自选礼包的奖励选项
    ExchangeGiftPackageItem_1713(1713, ExchangeGiftPackageItem.getDefaultInstance(), ExchangeGiftPackageItemRt.getDefaultInstance()),

    QueryInvestActivity_1714(1714, QueryInvestActivity.getDefaultInstance(), QueryInvestActivityRt.getDefaultInstance()),

    // 使用游戏内代币(资源)购买礼包
    ResBuyGiftPackage_1715(1715, ResBuyGiftPackage.getDefaultInstance(), ResBuyGiftPackageRt.getDefaultInstance()),

    // 为第三方支付获取各档位商品的价格
    QueryProductPrices_1716(1716, QueryProductPrices.getDefaultInstance(), QueryProductPricesRt.getDefaultInstance()),

    // 设置部队预设
    ArmyPreSet_1724(1724, ArmyPreSet.getDefaultInstance(), ArmyPreSetRt.getDefaultInstance()),

    // 查询救援物资
    QueryRescueRes_1725(1725, QueryRescueRes.getDefaultInstance(), QueryRescueResRt.getDefaultInstance()),

    // 领取救援物资
    GetRescueRes_1726(1726, GetRescueRes.getDefaultInstance(), GetRescueResRt.getDefaultInstance()),

    // 查看救援提示
    WatchRescueNotice_1727(1727, WatchRescueNotice.getDefaultInstance(), WatchRescueNoticeRt.getDefaultInstance()),

    // 设置部队预设
    SetForcePlan_1728(1728, SetForcePlan.getDefaultInstance(), SetForcePlanRt.getDefaultInstance()),

    // 上报延迟
    ReportElapsed_1730(1730, ReportElapsed.getDefaultInstance(), ReportElapsedRt.getDefaultInstance()),

    // 确认破保护罩
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    ConfirmCoverOver_1731(1731, ConfirmCoverOver.getDefaultInstance(), ConfirmCoverOverRt.getDefaultInstance()),

    // 检测名称是否合法
    CheckNameLegal_1732(1732, CheckNameLegal.getDefaultInstance(), CheckNameLegalRt.getDefaultInstance()),

    // 领取目标奖励
    GetTargetTaskReward_1733(
        1733,
        GetTargetTaskReward.getDefaultInstance(),
        GetTargetTaskRewardRt.getDefaultInstance()
    ),

    // 查询至高领主活动
    QueryLordActivity_1734(1734, QueryLordActivity.getDefaultInstance(), QueryLordActivityRt.getDefaultInstance()),

    // 领取至高领主活动阶段积分奖励
    GetLordActivityScoreReward_1735(
        1735,
        GetLordActivityScoreReward.getDefaultInstance(),
        GetLordActivityScoreRewardRt.getDefaultInstance()
    ),

    // 查询至高领主活动排行榜
    QueryLordActivityRank_1736(
        1736,
        QueryLordActivityRank.getDefaultInstance(),
        QueryLordActivityRankRt.getDefaultInstance()
    ),

    QueryCrossLordActivity_1740(
        1740,
        QueryCrossLordActivity.getDefaultInstance(),
        QueryCrossLordActivityRt.getDefaultInstance()
    ),

    // 查询至高领主活动历史
    QueryLordActivityHistory_2092(
        2092,
        QueryLordActivityHistory.getDefaultInstance(),
        QueryLordActivityHistoryRt.getDefaultInstance()
    ),

    // 删除部队预设
    DelForcePlan_1737(1737, DelForcePlan.getDefaultInstance(), DelForcePlanRt.getDefaultInstance()),

    // 查询自定义活动下的具体红点显示
    PurcaaseActivityRedPoint_1738(
        1738,
        PurcaaseActivityRedPoint.getDefaultInstance(),
        PurcaaseActivityRedPointRt.getDefaultInstance()
    ),

    // 挑选领主方案
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    ChooesLord_1739(1739, ChooesLord.getDefaultInstance(), ChooesLordRt.getDefaultInstance()),

    GuideInfo_1741(1741, GuideInfo.getDefaultInstance(), GuideInfoRt.getDefaultInstance()),

    //请求消逝大陆活动信息协议
    QueryDisappearLordActivity_1742(
        1742,
        QueryDisappearLordActivity.getDefaultInstance(),
        QueryDisappearLordActivityRt.getDefaultInstance()
    ),

    Match3TilesQuery_1751(
        1751,
        Match3TilesActivityQuery.getDefaultInstance(),
        Match3TilesActivityQueryRt.getDefaultInstance()
    ),
    Match3TilesActivityOpt_1752(
        1752,
        Match3TilesActivityOpt.getDefaultInstance(),
        Match3TilesActivityOptRt.getDefaultInstance()
    ),
    Match3TilesRefresh_1753(
        1753,
        Match3TilesRefresh.getDefaultInstance(),
        Match3TilesRefreshRt.getDefaultInstance()
    ),
    // 兑换礼品码
    DrawGiftKey_1799(
        1799,
        DrawGiftKey.getDefaultInstance(),
        DrawGiftKeyRt.getDefaultInstance()
    ),

    // 飞升 (1800 - 1804)
    Breakthrough_1800(1800, Breakthrough.getDefaultInstance(), BreakthroughRt.getDefaultInstance()),
    ExChangeBreakthroughExp_1801(
        1801,
        ExChangeBreakthroughExp.getDefaultInstance(),
        ExChangeBreakthroughExpRt.getDefaultInstance()
    ),

    // 联盟战(1810-1830)
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    OpenAllianceFight_1810(1810, OpenAllianceFight.getDefaultInstance(), OpenAllianceFightRt.getDefaultInstance()),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    OpenAllianceFightMain_1811(
        1811,
        OpenAllianceFightMain.getDefaultInstance(),
        OpenAllianceFightMainRt.getDefaultInstance()
    ),
    AllianceFightApply_1812(1812, AllianceFightApply.getDefaultInstance(), AllianceFightApplyRt.getDefaultInstance()),
    QueryAllianceFightLogs_1816(
        1816,
        QueryAllianceFightLogs.getDefaultInstance(),
        QueryAllianceFightLogsRt.getDefaultInstance()
    ),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    RewardAllianceFightMy_1817(
        1817,
        RewardAllianceFightMy.getDefaultInstance(),
        RewardAllianceFightMyRt.getDefaultInstance()
    ),

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    AskAllianceSolo_1818(
        1818,
        AskAllianceSolo.getDefaultInstance(),
        AskAllianceSoloRt.getDefaultInstance()
    ),

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    QueryAllianceSolo_1819(
        1819,
        QueryAllianceSolo.getDefaultInstance(),
        QueryAllianceSoloRt.getDefaultInstance()
    ),

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    QueryAllianceSoloMain_1820(
        1820,
        QueryAllianceSoloMain.getDefaultInstance(),
        QueryAllianceSoloMainRt.getDefaultInstance()
    ),

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    AllianceSoloEnd_1822(
        1822,
        AllianceSoloEnd.getDefaultInstance(),
        AllianceSoloEndRt.getDefaultInstance()
    ),

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    RewardAllianceSoloMy_1824(
        1824,
        RewardAllianceSoloMy.getDefaultInstance(),
        RewardAllianceSoloMyRt.getDefaultInstance()
    ),


    HeroTrainCardCombine_1839(
        1839,
        HeroTrainCardCombine.getDefaultInstance(),
        HeroTrainCardCombineRt.getDefaultInstance()
    ),

    // 琥珀秘境
    MysteryQuery_1840(1840, MysteryQuery.getDefaultInstance(), MysteryQueryRt.getDefaultInstance()),
    MysteryOpt_1841(1841, MysteryOpt.getDefaultInstance(), MysteryOptRt.getDefaultInstance()),
    QueryGrandPrizeRecord_1842(1842, QueryGrandPrizeRecord.getDefaultInstance(), QueryGrandPrizeRecordRt.getDefaultInstance()),
    QueryLotteryBoss_1843(1843, QueryLotteryBoss.getDefaultInstance(), QueryLotteryBossRt.getDefaultInstance()),
    DrawLotteryBoss_1844(1844, DrawLotteryBoss.getDefaultInstance(), DrawLotteryBossRt.getDefaultInstance()),
    RefreshLotteryBoss_1845(1845, RefreshLotteryBoss.getDefaultInstance(), RefreshLotteryBossRt.getDefaultInstance()),
    QueryLotteryBossOnly_1846(1846, QueryLotteryBossOnly.getDefaultInstance(), QueryLotteryBossOnlyRt.getDefaultInstance()),
    ReceiveAccFestivalReward_1847(1847, ReceiveAccFestivalReward.getDefaultInstance(), ReceiveAccFestivalRewardRt.getDefaultInstance()),

    // 单人PVE玩法协议 1851 - 1870
    OpenBigCity_1851(1851, OpenBigCity.getDefaultInstance(), OpenBigCityRt.getDefaultInstance()),

    // RewardOccupy_1852(1852, RewardOccupy.getDefaultInstance(), RewardOccupyRt.getDefaultInstance()),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    BeginFightBigCity_1856(1856, BeginFightBigCity.getDefaultInstance(), BeginFightBigCityRt.getDefaultInstance()),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    EndFightBigCity_1857(1857, EndFightBigCity.getDefaultInstance(), EndFightBigCityRt.getDefaultInstance()),
    ExitEliminateFight_1859(1859, ExitEliminateFight.getDefaultInstance(), ExitEliminateFightRt.getDefaultInstance()),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    BeginFightPveRob_1860(1860, BeginFightPveRob.getDefaultInstance(), BeginFightPveRobRt.getDefaultInstance()),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    EndFightPveRob_1861(1861, EndFightPveRob.getDefaultInstance(), EndFightPveRobRt.getDefaultInstance()),
    QuickPassKillRobInnerCity_1866(
        1866,
        QuickPassKillRobInnerCity.getDefaultInstance(),
        QuickPassKillRobInnerCityRt.getDefaultInstance()
    ),

    // 补充资源
    SupplyRes_1870(1870, SupplyRes.getDefaultInstance(), SupplyResRt.getDefaultInstance()),

    QueryEliminateFightType_1871(
        1871,
        QueryEliminateFightType.getDefaultInstance(),
        QueryEliminateFightTypeRt.getDefaultInstance()
    ),
    PveUnlockCloud_1872(1872, UnlockCloud.getDefaultInstance(), UnlockCloudRt.getDefaultInstance()),
    PickupResSingle_1873(1873, PickupResSingle.getDefaultInstance(), PickupResSingleRt.getDefaultInstance()),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    BeginAutoFightPveRob_1874(
        1874,
        BeginAutoFightPveRob.getDefaultInstance(),
        BeginAutoFightPveRobRt.getDefaultInstance()
    ),
    ResSingleWarFortuneRoll_1875(
        1875,
        ResSingleWarFortuneRoll.getDefaultInstance(),
        ResSingleWarFortuneRollRt.getDefaultInstance()
    ),
    PickupResSingleFortune_1877(
        1877,
        PickupResSingleFortune.getDefaultInstance(),
        PickupResSingleFortuneRt.getDefaultInstance()
    ),
    InnerCityAreaClean_1878(
        1878,
        InnerCityAreaClean.getDefaultInstance(),
        InnerCityAreaCleanRt.getDefaultInstance()
    ),
    FadeCloud_1879(
        1879,
        FadeCloud.getDefaultInstance(),
        FadeCloudRt.getDefaultInstance()
    ),

    WalkStop_1883(1883, WalkStop.getDefaultInstance(), WalkStopRt.getDefaultInstance()),
    WalkWithForce_1884(1884, WalkWithForce.getDefaultInstance(), WalkWithForceRt.getDefaultInstance()),
    WalkPvpFight_1885(1885, WalkPvpFight.getDefaultInstance(), WalkPvpFightRt.getDefaultInstance()),
    WatchOnMiniMap_1888(1888, WatchOnMiniMap.getDefaultInstance(), WatchOnMiniMapRt.getDefaultInstance()),
    WatchMapAllCastle_1889(1889, WatchMapAllCastle.getDefaultInstance(), WatchMapAllCastleRt.getDefaultInstance()),

    // 支线任务的三消战斗
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    BeginSideTaskFight_1892(1892, BeginSideTaskFight.getDefaultInstance(), BeginSideTaskFightRt.getDefaultInstance()),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    EndSideTaskFight_1893(1893, EndSideTaskFight.getDefaultInstance(), EndSideTaskFightRt.getDefaultInstance()),

    // 查询行军线详细信息
    QueryWalkLineDetail_1900(
        1900,
        QueryWalkLineDetail.getDefaultInstance(),
        QueryWalkLineDetailRt.getDefaultInstance()
    ),

    // 开始打劫采集行军线
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    BeginRobFarmWalkLineFight_1902(
        1902,
        BeginRobFarmWalkLineFight.getDefaultInstance(),
        BeginRobFarmWalkLineFightRt.getDefaultInstance()
    ),

    // 结束打劫采集行军线
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    EndRobFarmWalkLineFight_1903(
        1903,
        EndRobFarmWalkLineFight.getDefaultInstance(),
        EndRobFarmWalkLineFightRt.getDefaultInstance()
    ),

    // 查询行军小人位置
    QueryWalkRobotPos_1906(1906, QueryWalkRobotPos.getDefaultInstance(), QueryWalkRobotPosRt.getDefaultInstance()),

    // 查询旗帜信息
    QueryFlagInfo_1911(1911, QueryFlagInfo.getDefaultInstance(), QueryFlagInfoRt.getDefaultInstance()),

    // 修改旗帜
    UpdateFlagInfo_1912(1912, UpdateFlagInfo.getDefaultInstance(), UpdateFlagInfoRt.getDefaultInstance()),

    // task:Evo_19006【商业化】岛屿集市
    HeroFragmentsStoreOpt_1918(1918, HeroFragmentsStoreOpt.getDefaultInstance(), HeroFragmentsStoreOptRt.getDefaultInstance()),

    // 道具合成
    PropExchange_1919(1919, PropExchange.getDefaultInstance(), PropExchangeRt.getDefaultInstance()),

    // 英雄碎片商店查询
    HeroShardStoreQuery_1920(
        1920,
        HeroShardStoreQuery.getDefaultInstance(),
        HeroShardStoreQueryRt.getDefaultInstance()
    ),

    // 英雄碎片商店购买
    HeroShardStoreBuy_1921(1921, HeroShardStoreBuy.getDefaultInstance(), HeroShardStoreBuyRt.getDefaultInstance()),

    // 英雄碎片商店购买兑换券
    HeroShardStoreTicketBuy_1922(
        1922,
        HeroShardStoreTicketBuy.getDefaultInstance(),
        HeroShardStoreTicketBuyRt.getDefaultInstance()
    ),
    FestivalStoreQuery_1923(
        1923,
        FestivalStoreQuery.getDefaultInstance(),
        FestivalStoreQueryRt.getDefaultInstance()
    ),
    FestivalStoreBuy_1924(
        1924,
        FestivalStoreBuy.getDefaultInstance(),
        FestivalStoreBuyRt.getDefaultInstance()
    ),
    FestivalTicketBuy_1925(
        1925,
        FestivalTicketBuy.getDefaultInstance(),
        FestivalTicketBuyRt.getDefaultInstance()
    ),
    QueryTimeExchangeShop_1926(
        1926,
        QueryTimeExchangeShop.getDefaultInstance(),
        QueryTimeExchangeShopRt.getDefaultInstance()
    ),
    QueryFestivalActivity_1927(1927, QueryFestivalActivity.getDefaultInstance(), QueryFestivalActivityRt.getDefaultInstance()),
    FestivalActivityPlay_1928(1928, FestivalActivityPlay.getDefaultInstance(), FestivalActivityPlayRt.getDefaultInstance()),
    FestivalActivityReceive_1929(1929, FestivalActivityReceive.getDefaultInstance(), FestivalActivityReceiveRt.getDefaultInstance()),
    FestivalActivityStrategyReceive_1930(1930, FestivalActivityStrategyReceive.getDefaultInstance(), FestivalActivityStrategyReceiveRt.getDefaultInstance()),

    // 恐龙 1931-1940
    DinosaurOperate_1931(
        1931,
        DinosaurOperate.getDefaultInstance(),
        DinosaurOperateRt.getDefaultInstance()
    ),
    DinosaurQuery_1932(
        1932,
        DinosaurQuery.getDefaultInstance(),
        DinosaurQueryRt.getDefaultInstance()
    ),
    //恐龙射击关卡完成发奖
    DinosaurShootAwardPrizes_1933(
        1933,
        DinosaurShootAwardPrizes.getDefaultInstance(),
        DinosaurShootAwardPrizesRt.getDefaultInstance()
    ),
    //恐龙射击关卡开始
    DinosaurShootStar_1934(
        1934,
        DinosaurShootStar.getDefaultInstance(),
        DinosaurShootStarRt.getDefaultInstance()
    ),
    // 恐龙狩猎锦标赛关卡完成发奖
    DinosaurHuntingGamePrizes_1935(
        1935,
        DinosaurHuntingGamePrizes.getDefaultInstance(),
        DinosaurHuntingGamePrizesRt.getDefaultInstance()
    ),
    // 恐龙狩猎锦标赛关卡开始
    DinosaurHuntingGameStart_1936(
        1936,
        DinosaurHuntingGameStart.getDefaultInstance(),
        DinosaurHuntingGameStartRt.getDefaultInstance()
    ),
    DinosaurRadarMissionOpen_1938(
        1938,
        DinosaurRadarMissionOpen.getDefaultInstance(),
        DinosaurRadarMissionOpenRt.getDefaultInstance()
    ),
    DinosaurRadarMissionComplete_1939(
        1939,
        DinosaurRadarMissionComplete.getDefaultInstance(),
        DinosaurRadarMissionCompleteRt.getDefaultInstance()
    ),
    DinosaurBloodlineFragmentExchange_1940(
        1940,
        DinosaurBloodlineFragmentExchange.getDefaultInstance(),
        DinosaurBloodlineFragmentExchangeRt.getDefaultInstance()
    ),
    CreateAllianceBuild_2001(
        2001,
        CreateAllianceBuild.getDefaultInstance(),
        CreateAllianceBuildRt.getDefaultInstance()
    ),
    CancelCreateAllianceBuild_2002(
        2002,
        CancelCreateAllianceBuild.getDefaultInstance(),
        CancelCreateAllianceBuildRt.getDefaultInstance()
    ),
    RemoveAllianceBuild_2003(
        2003,
        RemoveAllianceBuild.getDefaultInstance(),
        RemoveAllianceBuildRt.getDefaultInstance()
    ),
    CancelRemoveAllianceBuild_2004(
        2004,
        CancelRemoveAllianceBuild.getDefaultInstance(),
        CancelRemoveAllianceBuildRt.getDefaultInstance()
    ),
    PutOutFireAllianceBuild_2005(
        2005,
        PutOutFireAllianceBuild.getDefaultInstance(),
        PutOutFireAllianceBuildRt.getDefaultInstance()
    ),
    QueryAllianceBuilds_2006(
        2006,
        QueryAllianceBuilds.getDefaultInstance(),
        QueryAllianceBuildsRt.getDefaultInstance()
    ),
    ConveneAllianceMembers_2007(
        2007,
        ConveneAllianceMembers.getDefaultInstance(),
        ConveneAllianceMembersRt.getDefaultInstance()
    ),
    TryResponseConvene_2008(2008, TryResponseConvene.getDefaultInstance(), TryResponseConveneRt.getDefaultInstance()),
    ChangeTpFlag_2009(2009, ChangeTpFlag.getDefaultInstance(), ChangeTpFlagRt.getDefaultInstance()),
    QueryTpFlags_2010(2010, QueryTpFlags.getDefaultInstance(), QueryTpFlagsRt.getDefaultInstance()),
    InviteJoinAllianceBuilding_2011(
        2011,
        InviteJoinAllianceBuilding.getDefaultInstance(),
        InviteJoinAllianceBuildingRt.getDefaultInstance()
    ),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    AtkAllianceFlag_2013(2013, AtkAllianceFlag.getDefaultInstance(), AtkAllianceFlagRt.getDefaultInstance()),

    // 联盟建筑迁移
    MoveAllianceBuild_2023(2023, MoveAllianceBuild.getDefaultInstance(), MoveAllianceBuildRt.getDefaultInstance()),

    // 每日三消活动
    OpenFightDayEliminate_2030(
        2030,
        OpenFightDayEliminate.getDefaultInstance(),
        OpenFightDayEliminateRt.getDefaultInstance()
    ),

    // 每日三消活动
    QueryHistoryInfo_2031(
        2031,
        QueryHistoryInfo.getDefaultInstance(),
        QueryHistoryInfoRt.getDefaultInstance()
    ),

    // 三消挑战商店购买物品
    BuyEliminateChallengeShop_2032(
        2032,
        BuyEliminateChallengeShop.getDefaultInstance(),
        BuyEliminateChallengeShopRt.getDefaultInstance()
    ),

    // 离线消息
    QueryOfflineMsg_2034(2034, QueryOfflineMsg.getDefaultInstance(), QueryOfflineMsgRt.getDefaultInstance()),

    // 检测目标点能否攻击
    CheckTargetCanAtk_2035(2035, CheckTargetCanAtk.getDefaultInstance(), CheckTargetCanAtkRt.getDefaultInstance()),

    // 设置集结目标
    SetMassTarget_2036(2036, SetMassTarget.getDefaultInstance(), SetMassTargetRt.getDefaultInstance()),

    // 响应集结
    ResponseMass_2037(2037, ResponseMass.getDefaultInstance(), ResponseMassRt.getDefaultInstance()),

    // 查询三消挑战赛排行
    QueryEliminateChallengeRank_2039(
        2039,
        QueryEliminateChallengeRank.getDefaultInstance(),
        QueryEliminateChallengeRankRt.getDefaultInstance()
    ),

    // 天下大势查询2
    WorldActivityQuery_2054(
        2054,
        WorldActivityQuery.getDefaultInstance(),
        WorldActivityQueryRt.getDefaultInstance()
    ),

    // 天下大势奖励领取2
    WorldActivityDraw_2055(
        2055,
        WorldActivityDraw.getDefaultInstance(),
        WorldActivityDrawRt.getDefaultInstance()
    ),

    //天下大势排行榜奖励领取
    WorldActivityRankRewardDraw_2056(
        2056,
        WorldActivityRankRewardDraw.getDefaultInstance(),
        WorldActivityRankRewardDrawRt.getDefaultInstance()
    ),

    // 战印升级
    HeroSharedEquipmentsUp_2070(
        2070,
        HeroSharedEquipmentsUp.getDefaultInstance(),
        HeroSharedEquipmentsUpRt.getDefaultInstance()
    ),

    // 离开码头
    LeaveMapBuild_2076(2076, LeaveMapBuild.getDefaultInstance(), LeaveMapBuildRt.getDefaultInstance()),

    // 发送部队标签
    SendForceExpression_2079(
        2079,
        SendForceExpression.getDefaultInstance(),
        SendForceExpressionRt.getDefaultInstance()
    ),

    // 联盟标记
    AllianceMark_2080(2080, AllianceMark.getDefaultInstance(), AllianceMarkRt.getDefaultInstance()),
    DeleteAllianceMark_2081(2081, DeleteAllianceMark.getDefaultInstance(), DeleteAllianceMarkRt.getDefaultInstance()),
    QueryAllianceMark_2082(2082, QueryAllianceMark.getDefaultInstance(), QueryAllianceMarkRt.getDefaultInstance()),
    ClearAllianceMarkReadStat_2083(
        2083,
        ClearAllianceMarkReadStat.getDefaultInstance(),
        ClearAllianceMarkReadStatRt.getDefaultInstance()
    ),

    // 联盟资源矿
    ReceiveAllianceResReward_2084(
        2084,
        ReceiveAllianceResReward.getDefaultInstance(),
        ReceiveAllianceResRewardRt.getDefaultInstance()
    ),

    // 联盟仓库
    QueryAllianceWarehouse_2085(
        2085,
        QueryAllianceWarehouse.getDefaultInstance(),
        QueryAllianceWarehouseRt.getDefaultInstance()
    ),
    QueryAllianceResNum_2086(
        2086,
        QueryAllianceResNum.getDefaultInstance(),
        QueryAllianceResNumRt.getDefaultInstance()
    ),
    QueryAllianceDailyLmt_2087(
        2087,
        QueryAllianceDailyLmt.getDefaultInstance(),
        QueryAllianceDailyLmtRt.getDefaultInstance()
    ),
    AllianceResourceExchange_2088(
        2088,
        AllianceResourceExchange.getDefaultInstance(),
        AllianceResourceExchangeRt.getDefaultInstance()
    ),

    // 资源运输
    WalkPvpTransport_2090(2090, WalkPvpTransport.getDefaultInstance(), WalkPvpTransportRt.getDefaultInstance()),

    // 夺宝奇兵
    QueryTurntableAct_2093(2093, QueryTurntableAct.getDefaultInstance(), QueryTurntableActRt.getDefaultInstance()),
    PlayTurntableAct_2094(2094, PlayTurntableAct.getDefaultInstance(), PlayTurntableActRt.getDefaultInstance()),
    RefreshTurntableAct_2095(
        2095,
        RefreshTurntableAct.getDefaultInstance(),
        RefreshTurntableActRt.getDefaultInstance()
    ),

    // 查询配置活动
    QueryConfigActivity_2096(
        2096,
        QueryConfigActivity.getDefaultInstance(),
        QueryConfigActivityRt.getDefaultInstance()
    ),

    // 冲榜活动
    QueryPartPointActivity_2097(
        2097,
        QueryPartPointActivity.getDefaultInstance(),
        QueryPartPointActivityRt.getDefaultInstance()
    ),
    ReceivePartPointActivityReward_2098(
        2098,
        ReceivePartPointActivityReward.getDefaultInstance(),
        ReceivePartPointActivityRewardRt.getDefaultInstance()
    ),
    QueryPartPointActivityRank_2099(
        2099,
        QueryPartPointActivityRank.getDefaultInstance(),
        QueryPartPointActivityRankRt.getDefaultInstance()
    ),

    // 联盟分盟 2100 - 2110
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    QueryAllianceFiliale_2100(
        2100,
        QueryAllianceFiliale.getDefaultInstance(),
        QueryAllianceFilialeRt.getDefaultInstance()
    ),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    InviteAllianceFiliale_2101(
        2101,
        InviteAllianceFiliale.getDefaultInstance(),
        InviteAllianceFilialeRt.getDefaultInstance()
    ),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    CancelInviteAllianceFiliale_2102(
        2102,
        CancelInviteAllianceFiliale.getDefaultInstance(),
        CancelInviteAllianceFilialeRt.getDefaultInstance()
    ),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    JoinAllianceFiliale_2103(
        2103,
        JoinAllianceFiliale.getDefaultInstance(),
        JoinAllianceFilialeRt.getDefaultInstance()
    ),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    RemoveAllianceFiliale_2104(
        2104,
        RemoveAllianceFiliale.getDefaultInstance(),
        RemoveAllianceFilialeRt.getDefaultInstance()
    ),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    QuitAllianceFiliale_2105(
        2105,
        QuitAllianceFiliale.getDefaultInstance(),
        QuitAllianceFilialeRt.getDefaultInstance()
    ),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    QueryAllianceFilialeReq_2106(
        2106,
        QueryAllianceFilialeReq.getDefaultInstance(),
        QueryAllianceFilialeReqRt.getDefaultInstance()
    ),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    ApplyAllianceFilialeQuit_2107(
        2107,
        ApplyAllianceFilialeQuit.getDefaultInstance(),
        ApplyAllianceFilialeQuitRt.getDefaultInstance()
    ),


    // 平判之乱 (2120-2125)
    OpenArmyActivity_2120(2120, OpenArmyActivity.getDefaultInstance(), OpenArmyActivityRt.getDefaultInstance()),
    ApplyArmyActivity_2121(2121, ApplyArmyActivity.getDefaultInstance(), ApplyArmyActivityRt.getDefaultInstance()),
    QueryArmyActivityRank_2122(
        2122,
        QueryArmyActivityRank.getDefaultInstance(),
        QueryArmyActivityRankRt.getDefaultInstance()
    ),
    ReserveArmyActivity_2123(
        2123,
        ReserveArmyActivity.getDefaultInstance(),
        ReserveArmyActivityRt.getDefaultInstance()
    ),
    CancelReserveArmyActivity_2124(
        2124,
        CancelReserveArmyActivity.getDefaultInstance(),
        CancelReserveArmyActivityRt.getDefaultInstance()
    ),

    // 联盟调整 (2126-2130)
    QueryAllianceTipId_2126(2126, QueryAllianceTipId.getDefaultInstance(), QueryAllianceTipIdRt.getDefaultInstance()),
    GiveAllianceThumbsUp_2127(
        2127,
        GiveAllianceThumbsUp.getDefaultInstance(),
        GiveAllianceThumbsUpRt.getDefaultInstance()
    ),
    SendAllianceRecruit_2128(
        2128,
        SendAllianceRecruit.getDefaultInstance(),
        SendAllianceRecruitRt.getDefaultInstance()
    ),

    // 联盟奇观战(2131-2140)
    QueryAllianceWorldWonder_2131(
        2131,
        QueryAllianceWorldWonder.getDefaultInstance(),
        QueryAllianceWorldWonderRt.getDefaultInstance()
    ),

    AllianceWorldWonderApply_2132(
        2132,
        AllianceWorldWonderApply.getDefaultInstance(),
        AllianceWorldWonderApplyRt.getDefaultInstance()
    ),

    QueryAllianceWorldWonderLog_2133(
        2133,
        QueryAllianceWorldWonderLog.getDefaultInstance(),
        QueryAllianceWorldWonderLogRt.getDefaultInstance()
    ),

    QueryWorldWonderInfo_2134(
        2134,
        QueryWorldWonderInfo.getDefaultInstance(),
        QueryWorldWonderInfoRt.getDefaultInstance()
    ),

    QueryWorldWonderForce_2135(
        2135,
        QueryWorldWonderForce.getDefaultInstance(),
        QueryWorldWonderForceRt.getDefaultInstance()
    ),

    WorldWonderSendReward_2136(
        2136,
        WorldWonderSendReward.getDefaultInstance(),
        WorldWonderSendRewardRt.getDefaultInstance()
    ),

    QueryWorldWonderScore_2137(
        2137,
        QueryWorldWonderScore.getDefaultInstance(),
        QueryWorldWonderScoreRt.getDefaultInstance()
    ),

    QueryWorldWonderRewardLog_2138(
        2138,
        QueryWorldWonderRewardLog.getDefaultInstance(),
        QueryWorldWonderRewardLogRt.getDefaultInstance()
    ),

    AllianceWorldWonderCancelApply_2139(
        2139,
        AllianceWorldWonderCancelApply.getDefaultInstance(),
        AllianceWorldWonderCancelApplyRt.getDefaultInstance()
    ),

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    QueryFortuitousReward_2141(
        2141,
        QueryFortuitousReward.getDefaultInstance(),
        QueryFortuitousRewardRt.getDefaultInstance()
    ),
    ReceiveStationedReward_2142(
        2142,
        ReceiveStationedReward.getDefaultInstance(),
        ReceiveStationedRewardRt.getDefaultInstance()
    ),

    // 查询活动状态
    QueryActivityTime_2143(
        2143,
        QueryActivityTime.getDefaultInstance(),
        QueryActivityTimeRt.getDefaultInstance()
    ),

    // 查询道具合成记录
    QueryItemCompoundRecord_2144(
        2144,
        QueryItemCompoundRecord.getDefaultInstance(),
        QueryItemCompoundRecordRt.getDefaultInstance()
    ),

    // 查询活动状态
    QueryActivityStatus_2145(
        2145,
        QueryActivityStatus.getDefaultInstance(),
        QueryActivityStatusRt.getDefaultInstance()
    ),

    // 联盟日程(2165-2169)
    QueryAllianceCalendar_2165(
        2165,
        QueryAllianceCalendar.getDefaultInstance(),
        QueryAllianceCalendarRt.getDefaultInstance()
    ),
    PublishAllianceCalendar_2166(
        2166,
        PublishAllianceCalendar.getDefaultInstance(),
        PublishAllianceCalendarRt.getDefaultInstance()
    ),
    DeleteAllianceCalendar_2167(
        2167,
        DeleteAllianceCalendar.getDefaultInstance(),
        DeleteAllianceCalendarRt.getDefaultInstance()
    ),

    QueryNpcCityActivity_2176(
        2176,
        QueryNpcCityActivity.getDefaultInstance(),
        QueryNpcCityActivityRt.getDefaultInstance()
    ),

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    EliminateInstanceAtkStart_2180(
        2180,
        EliminateInstanceAtkStart.getDefaultInstance(),
        EliminateInstanceAtkStartRt.getDefaultInstance()
    ),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    EliminateInstanceAtkFinish_2181(
        2181,
        EliminateInstanceAtkFinish.getDefaultInstance(),
        EliminateInstanceAtkFinishRt.getDefaultInstance()
    ),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    SlgInstanceAtkStart_2182(
        2182,
        SlgInstanceAtkStart.getDefaultInstance(),
        SlgInstanceAtkStartRt.getDefaultInstance()
    ),
    RexComingComplete_2191(2191, RexComingComplete.getDefaultInstance(), RexComingCompleteRt.getDefaultInstance()),
    RecvTssSdkData_2200(2200, RecvTssSdkData.getDefaultInstance(), RecvTssSdkDataRt.getDefaultInstance()),

    // 日月王城模块(2201-2230)
    // 盟主设置国王
    CapitalBattleKingSet_2201(
        2201,
        CapitalBattleKingSet.getDefaultInstance(),
        CapitalBattleKingSetRt.getDefaultInstance()
    ),

    // 国王设置官员
    CapitalBattleOfficerSet_2202(
        2202,
        CapitalBattleOfficerSet.getDefaultInstance(),
        CapitalBattleOfficerSetRt.getDefaultInstance()
    ),

    // 打开国王特权界面
    CapitalBattleOpen_2203(2203, CapitalBattleOpen.getDefaultInstance(), CapitalBattleOpenRt.getDefaultInstance()),

    // 修改王国公告
    CapitalBattleAnnouncementChange_2204(
        2204,
        CapitalBattleAnnouncementChange.getDefaultInstance(),
        CapitalBattleAnnouncementChangeRt.getDefaultInstance()
    ),

    // 使用国王技能
    CapitalBattleUseSkill_2205(
        2205,
        CapitalBattleUseSkill.getDefaultInstance(),
        CapitalBattleUseSkillRt.getDefaultInstance()
    ),

    // 国王颁发礼包
    CapitalBattleKingGiveGift_2206(
        2206,
        CapitalBattleKingGiveGift.getDefaultInstance(),
        CapitalBattleKingGiveGiftRt.getDefaultInstance()
    ),

    // 打开王国官员界面
    CapitalBattleOfficerInfoOpen_2207(
        2207,
        CapitalBattleOfficerInfoOpen.getDefaultInstance(),
        CapitalBattleOfficerInfoOpenRt.getDefaultInstance()
    ),

    // 打开王国礼包界面
    CapitalBattleKingGiftInfoOpen_2208(
        2208,
        CapitalBattleKingGiftInfoOpen.getDefaultInstance(),
        CapitalBattleKingGiftInfoOpenRt.getDefaultInstance()
    ),

    // 打开日月王城主界面
    CapitalBattleKingMainInfoOpen_2209(
        2209,
        CapitalBattleKingMainInfoOpen.getDefaultInstance(),
        CapitalBattleKingMainInfoOpenRt.getDefaultInstance()
    ),

    // 打开礼物派发日志界面
    CapitalBattleGiftLogOpen_2210(
        2210,
        CapitalBattleGiftLogOpen.getDefaultInstance(),
        CapitalBattleGiftLogOpenRt.getDefaultInstance()
    ),

    // 打开技能使用日志界面
    CapitalBattleUseSkillLogOpen_2211(
        2211,
        CapitalBattleUseSkillLogOpen.getDefaultInstance(),
        CapitalBattleUseSkillLogOpenRt.getDefaultInstance()
    ),

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    CancelNewBossOpen_2212(2212, CancelNewBossOpen.getDefaultInstance(), CancelNewBossOpenRt.getDefaultInstance()),

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    QuerySummonRank_2213(2213, QuerySummonRank.getDefaultInstance(), QuerySummonRankRt.getDefaultInstance()),

    QueryYanwuMember_2214(2214, QueryYanwuMember.getDefaultInstance(), QueryYanwuMemberRt.getDefaultInstance()),

    QueryYanwuRank_2215(2215, QueryYanwuRank.getDefaultInstance(), QueryYanwuRankRt.getDefaultInstance()),

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    QuerySummonSuccessRecord_2216(
        2216,
        QuerySummonSuccessRecord.getDefaultInstance(),
        QuerySummonSuccessRecordRt.getDefaultInstance()
    ),

    QueryTotalSummon_2217(
        2217,
        QueryTotalSummon.getDefaultInstance(),
        QueryTotalSummonRt.getDefaultInstance()
    ),

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    QuerySummonFightRecord_2218(
        2218,
        QuerySummonFightRecord.getDefaultInstance(),
        QuerySummonFightRecordRt.getDefaultInstance()
    ),

    AssistSummonReport_2219(
        2219,
        AssistSummonReport.getDefaultInstance(),
        AssistSummonReportRt.getDefaultInstance()
    ),

    // 开始自动打野
    BeginAutoFightCommonBoss_2220(
        2220,
        BeginAutoFightCommonBoss.getDefaultInstance(),
        BeginAutoFightCommonBossRt.getDefaultInstance()
    ),

    // 取消自动打野
    CancelAutoFightCommonBoss_2221(
        2221,
        CancelAutoFightCommonBoss.getDefaultInstance(),
        CancelAutoFightCommonBossRt.getDefaultInstance()
    ),

    // 查询演武场666奖励
    QueryYanwuLuckyRecord_2223(
        2223,
        QueryYanwuLuckyRecord.getDefaultInstance(),
        QueryYanwuLuckyRecordRt.getDefaultInstance()
    ),

    // 查询迷宫
    QueryLabyrinth_2224(
        2224,
        QueryLabyrinth.getDefaultInstance(),
        QueryLabyrinthRt.getDefaultInstance()
    ),

    // roll骰子
    RollLabyrinth_2225(
        2225,
        RollLabyrinth.getDefaultInstance(),
        RollLabyrinthRt.getDefaultInstance()
    ),

    // 刷新迷宫
    RefreshLabyrinth_2226(
        2226,
        RefreshLabyrinth.getDefaultInstance(),
        RefreshLabyrinthRt.getDefaultInstance()
    ),

    // 结束迷宫
    EndLabyrinth_2227(
        2227,
        EndLabyrinth.getDefaultInstance(),
        EndLabyrinthRt.getDefaultInstance()
    ),

    // 演武场排名详情
    QueryYanwuPlayerByRank_2228(
        2228,
        QueryYanwuPlayerByRank.getDefaultInstance(),
        QueryYanwuPlayerByRankRt.getDefaultInstance()
    ),

    // 联盟召集
    AllianceCallSend_2231(
        2231,
        AllianceCallSend.getDefaultInstance(),
        AllianceCallSendRt.getDefaultInstance()
    ),

    // 联盟召集忽视
    AllianceCallIgnore_2232(
        2232,
        AllianceCallIgnore.getDefaultInstance(),
        AllianceCallIgnoreRt.getDefaultInstance()
    ),

    AllianceMineOpt_2233(
        2233,
        AllianceMineOpt.getDefaultInstance(),
        AllianceMineOptRt.getDefaultInstance()
    ),

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    BeginAutoFightNpcCity_2240(
        2240,
        BeginAutoFightNpcCity.getDefaultInstance(),
        BeginAutoFightNpcCityRt.getDefaultInstance()
    ),

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    CancelAutoFightNpcCity_2241(
        2241,
        CancelAutoFightNpcCity.getDefaultInstance(),
        CancelAutoFightNpcCityRt.getDefaultInstance()
    ),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    BeginAutoFightAllianceBuild_2242(
        2242,
        BeginAutoFightAllianceBuild.getDefaultInstance(),
        BeginAutoFightAllianceBuildRt.getDefaultInstance()
    ),

    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    CancelAutoFightAllianceBuild_2243(
        2243,
        CancelAutoFightAllianceBuild.getDefaultInstance(),
        CancelAutoFightAllianceBuildRt.getDefaultInstance()
    ),

    ScrambleEggsQuery_2244(
        2244,
        ScrambleEggsQuery.getDefaultInstance(),
        ScrambleEggsQueryRt.getDefaultInstance()
    ),

    ScrambleEggsHistoryDetailQuery_2245(
        2245,
        ScrambleEggsHistoryDetailQuery.getDefaultInstance(),
        ScrambleEggsHistoryDetailQueryRt.getDefaultInstance()
    ),

    ScrambleEggsOpt_2246(
        2246,
        ScrambleEggsOpt.getDefaultInstance(),
        ScrambleEggsOptRt.getDefaultInstance()
    ),

    ScrambleEggsHistoryQuery_2247(
        2247,
        ScrambleEggsHistoryQuery.getDefaultInstance(),
        ScrambleEggsHistoryQueryRt.getDefaultInstance()
    ),

    QueryArenaInfo_2249(
        2249,
        QueryArenaInfo.getDefaultInstance(),
        QueryArenaInfoRt.getDefaultInstance()
    ),

    QueryArenaChallengeList_2250(
        2250,
        QueryArenaChallengeList.getDefaultInstance(),
        QueryArenaChallengeListRt.getDefaultInstance()
    ),

    SaveArenaFormation_2251(
        2251,
        SaveArenaFormation.getDefaultInstance(),
        SaveArenaFormationRt.getDefaultInstance()
    ),

    QueryArenaChallengeRecord_2252(
        2252,
        QueryArenaChallengeRecord.getDefaultInstance(),
        QueryArenaChallengeRecordRt.getDefaultInstance()
    ),

    QueryArenaPlayer_2253(
        2253,
        QueryArenaPlayer.getDefaultInstance(),
        QueryArenaPlayerRt.getDefaultInstance()
    ),

    BuyChallengeTimes_2254(
        2254,
        BuyChallengeTimes.getDefaultInstance(),
        BuyChallengeTimesRt.getDefaultInstance()
    ),

    RefreshChallengeList_2255(
        2255,
        RefreshChallengeList.getDefaultInstance(),
        RefreshChallengeListRt.getDefaultInstance()
    ),

    RefreshArenaChallengePos_2256(
        2256,
        RefreshArenaChallengePos.getDefaultInstance(),
        RefreshArenaChallengePosRt.getDefaultInstance()
    ),

    QueryCreateAllianceState_2257(
        2257,
        QueryCreateAllianceState.getDefaultInstance(),
        QueryCreateAllianceStateRt.getDefaultInstance()
    ),

    QueryOperationMuseumVisitList_2258(
        2258,
        OperationMuseumVisitListQurey.getDefaultInstance(),
        OperationMuseumVisitListQureyRt.getDefaultInstance()
    ),

    OperationMuseumVisit_2259(
        2259,
        OperationMuseumVisit.getDefaultInstance(),
        OperationMuseumVisitRt.getDefaultInstance()
    ),

    OperationMuseumLike_2260(
        2260,
        OperationMuseumLike.getDefaultInstance(),
        OperationMuseumLikeRt.getDefaultInstance()
    ),

    // 寻路
    FindPathBatch_2494(2494, FindPathBatch.getDefaultInstance(), FindPathBatchRt.getDefaultInstance()),
    FindPath_2495(2495, FindPath.getDefaultInstance(), FindPathRt.getDefaultInstance()),

    // 查询所有盟友位置
    QueryAllAllianceMemberPos_2496(
        2496,
        QueryAllAllianceMemberPos.getDefaultInstance(),
        QueryAllAllianceMemberPosRt.getDefaultInstance()
    ),

    // 获取全地图联盟建筑信息
    WatchAllAllianceBuild_2497(
        2497,
        WatchAllAllianceBuild.getDefaultInstance(),
        WatchAllAllianceBuildRt.getDefaultInstance()
    ),

    // 查看地图
    WatchWorld_2498(2498, WatchWorld.getDefaultInstance(), WatchWorldRt.getDefaultInstance()),

    // 三消测试-帮客户端生成结构
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    EliminateTestBuild_2499(2499, EliminateTestBuild.getDefaultInstance(), EliminateTestBuildRt.getDefaultInstance()),

    // 模块数据
    RequireModuleData_2500(2500, RequireModuleData.getDefaultInstance(), RequireModuleDataRt.getDefaultInstance()),

    /**联盟boss模块2501 - 2509*/
    // 联盟boss捐献
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    ALLIANCE_NEW_BOSS_DONATE(
        2501,
        AllianceNewBossDonate.getDefaultInstance(),
        AllianceNewBossDonateRt.getDefaultInstance()
    ),

    // 联盟boss开启
    AllianceNewBossOpen_2502(
        2502,
        AllianceNewBossOpen.getDefaultInstance(),
        AllianceNewBossOpenRt.getDefaultInstance()
    ),

    // 查询联盟boss伤害
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    QueryAllianceNewBossHurt_2503(
        2503,
        QueryAllianceNewBossHurt.getDefaultInstance(),
        QueryAllianceNewBossHurtRt.getDefaultInstance()
    ),

    // 查询联盟boss信息
    QueryAllianceNewBossInfo_2504(
        2504,
        QueryAllianceNewBossInfo.getDefaultInstance(),
        QueryAllianceNewBossInfoRt.getDefaultInstance()
    ),

    // 使用充能buff
    UseChargeBuff_2506(2506, UseChargeBuffInfo.getDefaultInstance(), UseChargeBuffInfoRt.getDefaultInstance()),

    // 查询巢穴集结次数
    QueryRelicMassCount_2507(
        2507,
        QueryRelicMassCount.getDefaultInstance(),
        QueryRelicMassCountRt.getDefaultInstance()
    ),

    Online_Hero_2516(
        2516,
        OnlineHeroReward.getDefaultInstance(),
        OnlineHeroRewardRt.getDefaultInstance()
    ),

    Change_Lord_Skin_2517(
        2517,
        ChangeLordSkin.getDefaultInstance(),
        ChangeLordSkinRt.getDefaultInstance()
    ),
    Buy_Lord_Skin_2518(
        2518,
        BuyLordSkin.getDefaultInstance(),
        BuyLordSkinRt.getDefaultInstance()
    ),

    // 联盟宝藏 2520 - 2530
    QuerySelfTreasure_2520(
        2520,
        QuerySelfTreasure.getDefaultInstance(),
        QuerySelfTreasureRt.getDefaultInstance()
    ),

    QueryAllianceTreasure_2521(
        2521,
        QueryAllianceTreasure.getDefaultInstance(),
        QueryAllianceTreasureRt.getDefaultInstance()
    ),

    WorkTreasure_2522(
        2522,
        WorkTreasure.getDefaultInstance(),
        WorkTreasureRt.getDefaultInstance()
    ),

    HelpTreasure_2523(
        2523,
        HelpTreasure.getDefaultInstance(),
        HelpTreasureRt.getDefaultInstance()
    ),

    QuickTreasure_2524(
        2524,
        QuickTreasure.getDefaultInstance(),
        QuickTreasureRt.getDefaultInstance()
    ),

    RewardTreasure_2525(
        2525,
        RewardTreasure.getDefaultInstance(),
        RewardTreasureRt.getDefaultInstance()
    ),

    RefreshTreasure_2526(
        2526,
        RefreshTreasure.getDefaultInstance(),
        RefreshTreasureRt.getDefaultInstance()
    ),

    SendHelpTreasure_2527(
        2527,
        SendHelpTreasure.getDefaultInstance(),
        SendHelpTreasureRt.getDefaultInstance()
    ),
    QueryFestivalDropLmt_2529(
        2529,
        QueryFestivalDropLmt.getDefaultInstance(),
        QueryFestivalDropLmtRt.getDefaultInstance()
    ),

    PrivacySwitchOpt_2530(
        2530,
        PrivacySwitchOpt.getDefaultInstance(),
        PrivacySwitchOptRt.getDefaultInstance()
    ),

    QueryPrivacySwitch_2531(
        2531,
        QueryPrivacySwitch.getDefaultInstance(),
        QueryPrivacySwitchRt.getDefaultInstance()
    ),
    TimeExchangeShop_2532(
        2532,
        TimeExchangeShop.getDefaultInstance(),
        TimeExchangeShopRt.getDefaultInstance()
    ),
    GetFestivalBossReward_2533(
        2533,
        GetFestivalBossReward.getDefaultInstance(),
        GetFestivalBossRewardRt.getDefaultInstance()
    ),
    QueryFestivalBossdAtk_2534(
        2534,
        QueryFestivalBossdAtk.getDefaultInstance(),
        QueryFestivalBossdAtkRt.getDefaultInstance()
    ),
    QueryFestivalBoss_2535(
        2535,
        QueryFestivalBoss.getDefaultInstance(),
        QueryFestivalBossRt.getDefaultInstance()
    ),
    QueryFestivalRewardRank_2536(
        2536,
        QueryFestivalRewardRank.getDefaultInstance(),
        QueryFestivalRewardRankRt.getDefaultInstance()
    ),
    EnterBattleField_2537(
        2537,
        EnterBattleField.getDefaultInstance(),
        EnterBattleFieldRt.getDefaultInstance(),
    ),
    ExitBattleField_2539(
        2539,
        ExitBattleField.getDefaultInstance(),
        ExitBattleFieldRt.getDefaultInstance(),
    ),
    BattlefieldWonderQuery_2540(
        2540,
        BattlefieldWonderQuery.getDefaultInstance(),
        BattlefieldWonderQueryRt.getDefaultInstance()
    ),
    BattleFieldInnerOpt_2541(
        2541,
        BattleFieldInnerOpt.getDefaultInstance(),
        BattleFieldInnerOptRt.getDefaultInstance()
    ),
    QueryNpcCityOccupyHistory_2542(
        2542,
        QueryNpcCityOccupyHistory.getDefaultInstance(),
        QueryNpcCityOccupyHistoryRt.getDefaultInstance()
    ),
    QueryOccupyNpcCity_2543(2543, QueryOccupyNpcCity.getDefaultInstance(), QueryOccupyNpcCityRt.getDefaultInstance()),
    QueryNpcCityFirstOccupyRank_2544(
        2544,
        QueryNpcCityFirstOccupyRank.getDefaultInstance(),
        QueryNpcCityFirstOccupyRankRt.getDefaultInstance()
    ),
    QueryTearDownSoldierInfo_2545(
        2545,
        QueryTearDownSoldierInfo.getDefaultInstance(),
        QueryTearDownSoldierInfoRt.getDefaultInstance()
    ),
    CheckCanWalk_2546(2546, CheckCanWalk.getDefaultInstance(), CheckCanWalkRt.getDefaultInstance()), // 检测能否行军
    GiveUpNpcCity_2547(2547, GiveUpNpcCity.getDefaultInstance(), GiveUpNpcCityRt.getDefaultInstance()), // 舍弃npc城池
    CancelGiveUpNpcCity_2548(2548, CancelGiveUpNpcCity.getDefaultInstance(), CancelGiveUpNpcCityRt.getDefaultInstance()),   // 取消舍弃npc城池
    SetNeedSoldier_2549(2549, SetNeedSoldier.getDefaultInstance(), SetNeedSoldierRt.getDefaultInstance()),  // 设置需要的士兵信息

    // 战场
    AllianceHegemonyRankQuery_2550(2550, AllianceHegemonyRankQuery.getDefaultInstance(), AllianceHegemonyRankQueryRt.getDefaultInstance()),
    AllianceHegemonyQuery_2551(2551, AllianceHegemonyQuery.getDefaultInstance(), AllianceHegemonyQueryRt.getDefaultInstance()),
    AllianceHegemonyApply_2552(2552, AllianceHegemonyApply.getDefaultInstance(), AllianceHegemonyApplyRt.getDefaultInstance()),
    AllianceHegemonyHistoryRank_2554(2554, AllianceHegemonyHistoryRank.getDefaultInstance(), AllianceHegemonyHistoryRankRt.getDefaultInstance()),
    AllianceHegemonyOpt_2555(2555, AllianceHegemonyOpt.getDefaultInstance(), AllianceHegemonyOptRt.getDefaultInstance()),

    BattlefieldInnerQuery_2556(2556, BattlefieldInnerQuery.getDefaultInstance(), BattlefieldInnerQueryRt.getDefaultInstance()),
    QueryBattleFieldPlayerScoreRank_2557(2557, QueryBattleFieldPlayerScoreRank.getDefaultInstance(), QueryBattleFieldPlayerScoreRankRt.getDefaultInstance()),
    ClearBattleFieldTime_2558(2558, ClearBattleFieldTime.getDefaultInstance(), ClearBattleFieldTimeRt.getDefaultInstance()),
    UseBattleFieldChargeBuff_2559(2559, UseBattleFieldChargeBuff.getDefaultInstance(), UseBattleFieldChargeBuffRt.getDefaultInstance()),
    UseBattleFieldCitySkill_2560(2560, UseBattleFieldCitySkill.getDefaultInstance(), UseBattleFieldCitySkillRt.getDefaultInstance()),
    MoveCityInBattleField_2561(2561, MoveCityInBattleField.getDefaultInstance(), MoveCityInBattleFieldRt.getDefaultInstance()),

    // 联盟资源补给
    QueryAllianceSupply_2562(2562, QueryAllianceSupply.getDefaultInstance(), QueryAllianceSupplyRt.getDefaultInstance()),
    AllianceSupplyRequest_2563(2563, AllianceSupplyRequest.getDefaultInstance(), AllianceSupplyRequestRt.getDefaultInstance()),
    AllianceSupplyGive_2564(2564, AllianceSupplyGive.getDefaultInstance(), AllianceSupplyGiveRt.getDefaultInstance()),
    AllianceSupplyReceive_2565(2565, AllianceSupplyReceive.getDefaultInstance(), AllianceSupplyReceiveRt.getDefaultInstance()),

    // 联盟BOSS斗兽场
    AllianceColosseumQuery_2566(2566, AllianceColosseumQuery.getDefaultInstance(), AllianceColosseumQueryRt.getDefaultInstance()),
    AllianceColosseumOpt_2567(2567, AllianceColosseumOpt.getDefaultInstance(), AllianceColosseumOptRt.getDefaultInstance()),

    BattlefieldWarSituation_2568(2568, BattlefieldWarSituation.getDefaultInstance(), BattlefieldWarSituationRt.getDefaultInstance()),

    // NpcCity
    NeutralCityQuery_2571(2571, NeutralCityQuery.getDefaultInstance(), NeutralCityQueryRt.getDefaultInstance()),
    NeutralCityOpt_2572(2572, NeutralCityOpt.getDefaultInstance(), NeutralCityOptRt.getDefaultInstance()),
    QueryNeutralCityRank_2574(2574, QueryNeutralCityRank.getDefaultInstance(), QueryNeutralCityRankRt.getDefaultInstance()),
    OpenNeutralCityMain_2575(2575, OpenNeutralCityMain.getDefaultInstance(), OpenNeutralCityMainRt.getDefaultInstance()),


    //关注社群2580-2585
    //关注社群活动查询
    FollowCommunityQuery_2580(
        2580,
        FollowCommunityQuery.getDefaultInstance(),
        FollowCommunityQueryRt.getDefaultInstance()
    ),

    //关注社群活动领奖
    ReceiveFollowCommunityReward_2581(
        2581,
        ReceiveFollowCommunityReward.getDefaultInstance(),
        ReceiveFollowCommunityRewardRt.getDefaultInstance()
    ),

    HeroEchoQueryInfo_2582(2582, QueryHeroEchoShop.getDefaultInstance(), QueryHeroEchoShopRt.getDefaultInstance()),
    HeroEchoPurchaseItem_2583(
        2583,
        PurchaseHeroEchoShop.getDefaultInstance(),
        PurchaseHeroEchoShopRt.getDefaultInstance()
    ),

    // 幸运宝箱信息获取
    LuckyTreasureInfo_2584(2584, QueryLuckyTreasure.getDefaultInstance(), QueryLuckyTreasureRt.getDefaultInstance()),

    // 幸运宝箱选择大奖
    LuckyTreasureChooseBig_2585(
        2585,
        LuckyTreasureChooseBig.getDefaultInstance(),
        LuckyTreasureChooseBigRt.getDefaultInstance()
    ),

    // 开幸运宝箱
    PlayLuckyTreasure_2586(2586, PlayLuckyTreasure.getDefaultInstance(), PlayLuckyTreasureRt.getDefaultInstance()),

    // 幸运宝箱领取阶段奖励
    LuckyTreasureGetStageReward_2587(
        2587,
        LuckyTreasureGetStageReward.getDefaultInstance(),
        LuckyTreasureGetStageRewardRt.getDefaultInstance()
    ),

    //2591-2595 私人订制
    //私人定制查询活动信息
    QueryPrivateCustomizationGiftInfo_2591(
        2591,
        QueryPrivateCustomizationGiftInfo.getDefaultInstance(),
        QueryPrivateCustomizationGiftInfoRt.getDefaultInstance()
    ),
    //私人订制活动，礼包自选道具变更信息
    ChangePrivateCustomizationGiftInfo_2592(
        2592,
        ChangePrivateCustomizationGiftInfo.getDefaultInstance(),
        ChangePrivateCustomizationGiftInfoRt.getDefaultInstance()
    ),
    //2596-2600
    //收回功能性建筑，1.是功能建筑2.是高级装饰物，满足这两个才可以收回!!!!
    InnerCityReclaimTheBuilding_2596(
        2596,
        InnerCityReclaimTheBuilding.getDefaultInstance(),
        InnerCityReclaimTheBuildingRt.getDefaultInstance()
    ),
    //将功能性建筑直接从建筑背包移到当前布局中
    InnerCityBuildingPlacement_2597(
        2597,
        InnerCityBuildingPlacement.getDefaultInstance(),
        InnerCityBuildingPlacementRt.getDefaultInstance()
    ),
    //使用高级装饰物特效
    UseAdvancedDecorationSpecial_2598(
        2598,
        UseAdvancedDecorationSpecial.getDefaultInstance(),
        UseAdvancedDecorationSpecialRt.getDefaultInstance()
    ),

    //岛主获取特定界面的战力排行榜.排除自己
    QueryKingRank_2599(
        2599,
        QueryKingRank.getDefaultInstance(),
        QueryKingRankRt.getDefaultInstance()
    ),

    FuzzyQueryKingRank_2600(
        2600,
        FuzzyQueryKingRank.getDefaultInstance(),
        FuzzyQueryKingRankRt.getDefaultInstance()
    ),

    //只作为装饰商店
    PersonalDurableShopQuery_2601(
        2601,
        PersonalDurableShopQuery.getDefaultInstance(),
        PersonalDurableShopQueryRt.getDefaultInstance()
    ),

    // 只作为装饰购买
    PersonalDurableShopExchange_2602(
        2602,
        PersonalDurableShopExchange.getDefaultInstance(),
        PersonalDurableShopExchangeRt.getDefaultInstance()
    ),

    // 获取喜气洋洋活动
    PuzzleTaskActvQuery_2603(
        2603,
        PuzzleTaskActvQuery.getDefaultInstance(),
        PuzzleTaskActvQueryRt.getDefaultInstance()
    ),

    // 简单类型商店的统一购买
    ReceivePuzzleTaskActvReward_2604(
        2604,
        ReceivePuzzleTaskActvReward.getDefaultInstance(),
        ReceivePuzzleTaskActvRewardRt.getDefaultInstance()
    ),

    // 获取签到活动
    ActivitySignInQuery_2605(
        2605,
        ActivitySignInQuery.getDefaultInstance(),
        ActivitySignInQueryRt.getDefaultInstance()
    ),

    // 签到活动签到
    MakeActivitySignIn_2606(
        2606,
        MakeActivitySignIn.getDefaultInstance(),
        MakeActivitySignInRt.getDefaultInstance()
    ),

    // 签到活动领奖
    ReceiveActivitySignInReward_2607(
        2607,
        ReceiveActivitySignInReward.getDefaultInstance(),
        ReceiveActivitySignInRewardRt.getDefaultInstance()
    ),

    // 装扮商店客户端通知的刷新
    RefreshPersonalDurableShop_2608(
        2608,
        RefreshPersonalDurableShop.getDefaultInstance(),
        RefreshPersonalDurableShopRt.getDefaultInstance()
    ),

    // 新翻译
    NewTranslate_2610(2610, NewTranslate.getDefaultInstance(), NewTranslateRt.getDefaultInstance()),

    // 检查被艾特玩家是否在线
    AtCheckPlayer_2611(2611, AtCheckPlayer.getDefaultInstance(), AtCheckPlayerRt.getDefaultInstance()),

    // 自动参与集结 2616-2620
    // 自动参与集结开启
    BeginAutoJoinMass_2616(2616, BeginAutoJoinMass.getDefaultInstance(), BeginAutoJoinMassRt.getDefaultInstance()),

    // 自动参与集结信息查询
    QueryAutoJoinMass_2617(2617, QueryAutoJoinMass.getDefaultInstance(), QueryAutoJoinMassRt.getDefaultInstance()),

    // 设置自动参与集结编队
    SetFormationPlan_2618(2618, SetFormationPlan.getDefaultInstance(), SetFormationPlanRt.getDefaultInstance()),

    // 查看自动参与集结编队
    QuesyFormationPlan_2619(2619, QuesyFormationPlan.getDefaultInstance(), QuesyFormationPlanRt.getDefaultInstance()),

    // 自动参与集结关闭
    CloseAutoJoinMass_2620(2620, CloseAutoJoinMass.getDefaultInstance(), CloseAutoJoinMassRt.getDefaultInstance()),

    // 获取bp活动
    BattlePassActvQuery_2621(
        2621,
        BattlePassActvQuery.getDefaultInstance(),
        BattlePassActvQueryRt.getDefaultInstance()
    ),

    // bp活动增加经验
    BattlePassActvAddExp_2622(
        2622,
        BattlePassActvAddExp.getDefaultInstance(),
        BattlePassActvAddExpRt.getDefaultInstance()
    ),

    // bp活动领取奖励
    ReceiveBattlePassActvReward_2623(
        2623,
        ReceiveBattlePassActvReward.getDefaultInstance(),
        ReceiveBattlePassActvRewardRt.getDefaultInstance()
    ),


    //通用举报
    ReportGeneral_2625(2625,  ReportGeneral.getDefaultInstance(), ReportGeneralRt.getDefaultInstance()),

    // 限时累充活动
    ActivityTotalPayQuery_2626(
        2626,
        ActivityTotalPayQuery.getDefaultInstance(),
        ActivityTotalPayQueryRt.getDefaultInstance()
    ),

    // 活动兑换商店兑换
    ActivityShopExchange_2627(
        2627,
        ActivityShopExchange.getDefaultInstance(),
        ActivityShopExchangeRt.getDefaultInstance()
    ),

    // 活动兑换商店查询
    ActivityShopQuery_2628(2628, ActivityShopQuery.getDefaultInstance(), ActivityShopQueryRt.getDefaultInstance()),

    // 一键领取月卡
    AllGetMonthReward_2629(
        2629,
        AllGetMonthReward.getDefaultInstance(),
        AllGetMonthRewardRt.getDefaultInstance()
    ),

    GetAppreciationInfo_2630(
        2630,
        GetAppreciationInfo.getDefaultInstance(),
        GetAppreciationInfoRt.getDefaultInstance()
    ),

    // 红包 2631-2635
    // 领取红包
    DrawRedPacket_2631(2631, DrawRedPacket.getDefaultInstance(), DrawRedPacketRt.getDefaultInstance()),
    // 查询红包信息
    QueryRedPacketById_2632(2632, QueryRedPacketById.getDefaultInstance(), QueryRedPacketByIdRt.getDefaultInstance()),

    // 红包红点刷新
    RedPacketRedPointRefresh_2633(
        2633,
        RedPacketRedPointRefresh.getDefaultInstance(),
        RedPacketRedPointRefreshRt.getDefaultInstance()
    ),

    // 查询红包列表
    GetRedPacketsInfo_2634(2634, GetRedPacketsInfo.getDefaultInstance(), GetRedPacketsInfoRt.getDefaultInstance()),

    // 宠物 2640-2650
    // 获取宠物信息
    PetInfoQuery_2640(
        2640,
        PetInfoQuery.getDefaultInstance(),
        PetInfoQueryRt.getDefaultInstance()
    ),

    // 捕捉宠物
    CatchPet_2641(
        2641,
        CatchPet.getDefaultInstance(),
        CatchPetRt.getDefaultInstance()
    ),

    // 宠物升级、突破
    PetLvUp_2642(
        2642,
        PetLvUp.getDefaultInstance(),
        PetLvUpRt.getDefaultInstance()
    ),

    // 使用宠物技能
    UsePetSkill_2643(
        2643,
        UsePetSkill.getDefaultInstance(),
        UsePetSkillRt.getDefaultInstance()
    ),

    // 设置技能可用提示
    SetPetSkillTip_2644(
        2644,
        SetPetSkillTip.getDefaultInstance(),
        SetPetSkillTipRt.getDefaultInstance()
    ),

    // 宠物洗练属性
    PetRefineProperty_2645(
        2645,
        PetRefineProperty.getDefaultInstance(),
        PetRefinePropertyRt.getDefaultInstance()
    ),

    // 替换宠物洗练属性
    PetReplaceProperty_2646(
        2646,
        PetReplaceProperty.getDefaultInstance(),
        PetReplacePropertyRt.getDefaultInstance()
    ),
    // 获取抓捕数据，包括新增和正在进行中的
    QueryNewPet_2647(
        2647,
        QueryNewPet.getDefaultInstance(),
        QueryNewPetRt.getDefaultInstance()
    ),
    // 寻找宠物,完成也发这一条
    FindNewPet_2648(
        2648,
        FindNewPet.getDefaultInstance(),
        FindNewPetRt.getDefaultInstance()
    ),
    // 抓捕时的答题
    AnswerPetQuest_2649(
        2649,
        AnswerPetQuest.getDefaultInstance(),
        AnswerPetQuestRt.getDefaultInstance()
    ),
    // 宠物改名
    ChangePetName_2650(
        2650,
        ChangePetName.getDefaultInstance(),
        ChangePetName.getDefaultInstance()
    ),


    //恐龙试炼召唤boss形象
    SummonAllianceNewBoss_2651(
        2651,
        SummonAllianceNewBoss.getDefaultInstance(),
        SummonAllianceNewBossRt.getDefaultInstance()
    ),
    //恐龙试炼申请援助
    AllianceNewBossAidApply_2652(
        2652,
        AllianceNewBossAidApply.getDefaultInstance(),
        AllianceNewBossAidApplyRt.getDefaultInstance()
    ),
    //恐龙试炼取消援助申请
    AllianceNewBossCancelAidApply_2653(
        2653,
        AllianceNewBossCancelAidApply.getDefaultInstance(),
        AllianceNewBossCancelAidApplyRt.getDefaultInstance()
    ),
    //恐龙试炼联盟援助申请界面信息
    AllianceNewBossAidApplicationInfo_2654(
        2654,
        AllianceNewBossAidApplicationInfo.getDefaultInstance(),
        AllianceNewBossAidApplicationInfoRt.getDefaultInstance()
    ),
    //恐龙试炼联盟援助加入集结小推送
    WidgetAllianceNewBossHelpRemind_2655(
        2655,
        WidgetAllianceNewBossHelpRemind.getDefaultInstance(),
        WidgetAllianceNewBossHelpRemindRt.getDefaultInstance()
    ),

    // 领取全部犒赏令奖励(犒赏令类型4和7)
    GetAppreciationAllReward_2656(
        2656,
        GetAppreciationAllReward.getDefaultInstance(),
        GetAppreciationAllRewardRt.getDefaultInstance()
    ),

    // 领取活动普通阶段奖励
    GetActivityStepReward_2657(
        2657,
        GetActivityStepReward.getDefaultInstance(),
        GetActivityStepRewardRt.getDefaultInstance()
    ),

    // 虚假帮助的数据,无参则只获取在线人数
    SendVirtualHelp_2658(
        2658,
        SendVirtualHelp.getDefaultInstance(),
        SendVirtualHelpRt.getDefaultInstance()
    ),

    // 接受虚假帮助
    ReceiveVirtualHelp_2659(
        2659,
        ReceiveVirtualHelp.getDefaultInstance(),
        ReceiveVirtualHelpRt.getDefaultInstance()
    ),

    // 上线触发一次离线帮助
    OfflineVirtualHelp_2660(
        2660,
        OfflineVirtualHelp.getDefaultInstance(),
        OfflineVirtualHelpRt.getDefaultInstance()
    ),

    //获取气球的数据
    GetShootBalloonData_2661(
        2661,
        GetShootBalloonData.getDefaultInstance(),
        GetShootBalloonDataRt.getDefaultInstance()
    ),

    //气球领奖
    ReceiveShootBalloonReward_2662(
        2662,
        ReceiveShootBalloonReward.getDefaultInstance(),
        ReceiveShootBalloonRewardRt.getDefaultInstance()
    ),

    // 获取气球活动信息
    GetShootBalloonActivity_2663(
        2663,
        GetShootBalloonActivity.getDefaultInstance(),
        GetShootBalloonActivityRt.getDefaultInstance()
    ),


    // 巧克力梦工厂2664-2669
    // 查询梦工厂活动信息
    QueryDreamWorksActivityInfo_2664(
        2664,
        QueryDreamWorksActivityInfo.getDefaultInstance(),
        QueryDreamWorksActivityInfoRt.getDefaultInstance()
    ),

    // 领取梦工厂每日积分奖励
    DrawTodayScoreReward_2665(
        2665,
        DrawTodayScoreReward.getDefaultInstance(),
        DrawTodayScoreRewardRt.getDefaultInstance()
    ),

    // 梦工厂制作
    DreamWorksCreate_2666(2666, DreamWorksCreate.getDefaultInstance(), DreamWorksCreateRt.getDefaultInstance()),

    // 梦工厂制作奖励记录查询(全部)
    QueryDreamWorksCreateRewardInfo_2667(
        2667,
        QueryDreamWorksCreateRewardInfo.getDefaultInstance(),
        QueryDreamWorksCreateRewardInfoRt.getDefaultInstance()
    ),

    // 查询梦工厂活动排行榜
    QueryDreamWorksRewardRank_2668(
        2668,
        QueryDreamWorksRewardRank.getDefaultInstance(),
        QueryDreamWorksRewardRankRt.getDefaultInstance()
    ),

    // 查询首充三日活动
    FirstThreeDayQuery_2669(
        2669,
        FirstThreeDayQuery.getDefaultInstance(),
        FirstThreeDayQueryRt.getDefaultInstance()
    ),

    // 领取首充三日活动奖励
    ReceiveFirstThreeDay_2670(
        2670,
        ReceiveFirstThreeDay.getDefaultInstance(),
        ReceiveFirstThreeDayRt.getDefaultInstance()
    ),

    // 发送集结邀请信息
    SendMassInfoChat_2671(
        2671,
        SendMassInfoChat.getDefaultInstance(),
        SendMassInfoChatRt.getDefaultInstance()
    ),

    // 英雄专武升级
    HeroWeaponLvUp_2672(
        2672,
        HeroWeaponLvUp.getDefaultInstance(),
        HeroWeaponLvUpRt.getDefaultInstance()
    ),

    //一键领取活跃度任务奖励
    GetHuoyueduTaskRewardQuickly_2673(
        2673,
        GetHuoyueduTaskRewardQuickly.getDefaultInstance(),
        GetHuoyueduTaskRewardQuicklyRt.getDefaultInstance()
    ),

    //岛主设置本区服国旗
    KingSetWorldFlag_2674(
        2674,
        KingSetWorldFlag.getDefaultInstance(),
        KingSetWorldFlagRt.getDefaultInstance()
    ),

    //获取其他世界的边界快照
    GetOtherWorldSnapshot_2675(
        2675,
        KingSetWorldFlag.getDefaultInstance(),
        KingSetWorldFlagRt.getDefaultInstance()
    ),

    //获取神秘实验室信息
    QueryContinuousRechargeInfo_2676(
        2676,
        QueryContinuousRechargeInfo.getDefaultInstance(),
        QueryContinuousRechargeInfoRt.getDefaultInstance()
    ),

    //领取神秘实验室大奖
    GetContinuousRechargeBigReward_2677(
        2677,
        GetContinuousRechargeBigReward.getDefaultInstance(),
        GetContinuousRechargeBigRewardRt.getDefaultInstance()
    ),

    //更换神秘实验室大奖
    ChangeContinuousRechargeBigReward_2678(
        2678,
        ChangeContinuousRechargeBigReward.getDefaultInstance(),
        ChangeContinuousRechargeBigRewardRt.getDefaultInstance()
    ),

    //获取最大区服号
    GetMaxAreaNo_2679(
        2679,
        GetMaxAreaNo.getDefaultInstance(),
        GetMaxAreaNoRt.getDefaultInstance()
    ),

    //验证超登权限
    CheckSuperLoginAuthority_2680(
        2680,
        CheckSuperLoginAuthority.getDefaultInstance(),
        CheckSuperLoginAuthorityRt.getDefaultInstance()
    ),

    // 记录应用商店评分+反馈
    SaveAppScore_2681(
        2681,
        SaveAppScore.getDefaultInstance(),
        SaveAppScoreRt.getDefaultInstance()
    ),

    // 恐龙对战快速战斗
    EliminateQuickFight_2682(
        2682,
        EliminateQuickFight.getDefaultInstance(),
        EliminateQuickFightRt.getDefaultInstance()
    ),

    // 跨服王战
    CrossKingdomLadderQuery_2691(
        2691,
        CrossKingdomLadderQuery.getDefaultInstance(),
        CrossKingdomLadderQueryRt.getDefaultInstance()
    ),
    CrossKingdomLadderReceive_2692(
        2692,
        CrossKingdomLadderReceive.getDefaultInstance(),
        CrossKingdomLadderReceiveRt.getDefaultInstance()
    ),
    CrossKingdomMatchQuery_2693(
        2693,
        CrossKingdomMatchQuery.getDefaultInstance(),
        CrossKingdomMatchQueryRt.getDefaultInstance()
    ),
    CrossKingdomWarfareQuery_2694(
        2694,
        CrossKingdomWarfareQuery.getDefaultInstance(),
        CrossKingdomWarfareQueryRt.getDefaultInstance()
    ),
    CrossKingdomWarfareReceive_2695(
        2695,
        CrossKingdomWarfareReceive.getDefaultInstance(),
        CrossKingdomWarfareReceiveRt.getDefaultInstance()
    ),
    CrossKingdomResuscitate_2696(
        2696,
        CrossKingdomResuscitate.getDefaultInstance(),
        CrossKingdomResuscitateRt.getDefaultInstance()
    ),
    CrossKingdomWarfareResult_2697(
        2697,
        CrossKingdomWarfareResult.getDefaultInstance(),
        CrossKingdomWarfareResultRt.getDefaultInstance()
    ),
    GetActivityRestrictedQuest_2698(
        2698,
        GetActivityRestrictedQuest.getDefaultInstance(),
        GetActivityRestrictedQuestRt.getDefaultInstance()
    ),

    GetActivityScoreRank_2700(
        2700,
        GetActivityScoreRank.getDefaultInstance(),
        GetActivityScoreRankRt.getDefaultInstance()
    ),
    GetMineActivityScoreRank_2701(
        2701,
        GetMineActivityScoreRank.getDefaultInstance(),
        GetMineActivityScoreRankRt.getDefaultInstance()
    ),

    QuerySupplyHappyGift_2702(
        2702,
        QuerySupplyHappyGift.getDefaultInstance(),
        QuerySupplyHappyGiftRt.getDefaultInstance()
    ),
    ChangeSupplyHappyGift_2703(
        2703,
        ChangeSupplyHappyGift.getDefaultInstance(),
        ChangeSupplyHappyGiftRt.getDefaultInstance()
    ),

    BatchAllianceDonateCritical_2704(
        2704,
        BatchAllianceDonateCritical.getDefaultInstance(),
        BatchAllianceDonateCriticalRt.getDefaultInstance()
    ),
    BatchAllianceDonate_2705(
        2705,
        BatchAllianceDonate.getDefaultInstance(),
        BatchAllianceDonateRt.getDefaultInstance()
    ),

    QueryFlipTowerInfo_2706(
        2706,
        QueryFlipTowerInfo.getDefaultInstance(),
        QueryFlipTowerInfoRt.getDefaultInstance()
    ),
    PlayFlipTower_2707(
        2707,
        PlayFlipTower.getDefaultInstance(),
        PlayFlipTowerRt.getDefaultInstance()
    ),
    FlipTowerNextLayer_2708(
        2708,
        FlipTowerNextLayer.getDefaultInstance(),
        FlipTowerNextLayerRt.getDefaultInstance()
    ),

    // 宠物派遣2710-2720
    PetTreasureInfoQuery_2710(
        2710,
        PetTreasureInfoQuery.getDefaultInstance(),
        PetTreasureInfoQueryRt.getDefaultInstance()
    ),
    PetTreasureAsk_2711(
        2711,
        PetTreasureAsk.getDefaultInstance(),
        PetTreasureAskRt.getDefaultInstance()
    ),
    PetGoTreasure_2712(
        2712,
        PetGoTreasure.getDefaultInstance(),
        PetGoTreasureRt.getDefaultInstance()
    ),
    PetTreasureReward_2713(
        2713,
        PetTreasureReward.getDefaultInstance(),
        PetTreasureRewardRt.getDefaultInstance()
    ),
    PetTreasureHelpInfo_2714(
        2714,
        PetTreasureHelpInfo.getDefaultInstance(),
        PetTreasureHelpInfoRt.getDefaultInstance()
    ),
    PetTreasureHelp_2715(
        2715,
        PetTreasureHelp.getDefaultInstance(),
        PetTreasureHelp.getDefaultInstance()
    ),
    GetPetTreasureAsk_2716(
        2716,
        GetPetTreasureAsk.getDefaultInstance(),
        GetPetTreasureAskRt.getDefaultInstance()
    ),
    SetPetShow_2717(
        2717,
        SetPetShow.getDefaultInstance(),
        SetPetShowRt.getDefaultInstance()
    ),
    QueryPetTreasureAskUuid_2718(
        2718,
        QueryPetTreasureAskUuid.getDefaultInstance(),
        QueryPetTreasureAskUuidRt.getDefaultInstance()
    ),
    SharePetAllianceTreasure_2719(
        2719,
        SharePetAllianceTreasure.getDefaultInstance(),
        SharePetAllianceTreasureRt.getDefaultInstance()
    ),
    QueryPetAllianceTreasure_2720(
        2720,
        QueryPetAllianceTreasure.getDefaultInstance(),
        QueryPetAllianceTreasureRt.getDefaultInstance()
    ),



    QueryRelicArchaeolInfo_2721(
        2721,
        QueryRelicArchaeolInfo.getDefaultInstance(),
        QueryRelicArchaeolInfoRt.getDefaultInstance()
    ),

    RelicArchaeolRoll_2722(
        2722,
        RelicArchaeolRoll.getDefaultInstance(),
        RelicArchaeolRollRt.getDefaultInstance()
    ),

    RelicArchaeolReceiveStageReward_2723(
        2723,
        RelicArchaeolReceiveStageReward.getDefaultInstance(),
        RelicArchaeolReceiveStageRewardRt.getDefaultInstance()
    ),

    //获取大大地图的服务器信息
    GetBigMapServerInfo_2724(
        2724,
        GetBigMapServerInfo.getDefaultInstance(),
        GetBigMapServerInfoRt.getDefaultInstance()
    ),

    QueryActivityFishInfo_2725(
        2725,
        QueryActivityFishInfo.getDefaultInstance(),
        QueryActivityFishInfoRt.getDefaultInstance()
    ),
    ActivityFishing_2726(
        2726,
        ActivityFishing.getDefaultInstance(),
        ActivityFishingRt.getDefaultInstance()
    ),
    ActivityFishDailyReward_2727(
        2727,
        ActivityFishDailyReward.getDefaultInstance(),
        ActivityFishDailyRewardRt.getDefaultInstance()
    ),
    QueryActivityFishAllReward_2728(
        2728,
        QueryActivityFishAllReward.getDefaultInstance(),
        QueryActivityFishAllRewardRt.getDefaultInstance()
    ),
    UsePropV2_2729(
        2729,
        UsePropV2.getDefaultInstance(),
        UsePropV2Rt.getDefaultInstance()
    ),
    ActivityFishStepReward_2730(
        2730,
        ActivityFishStepReward.getDefaultInstance(),
        ActivityFishStepRewardRt.getDefaultInstance()
    ),

    AllianceIslandreefsOpt_2731(2731, AllianceIslandreefsOpt.getDefaultInstance(), AllianceIslandreefsOptRt.getDefaultInstance()),
    AllianceIslandreefsMatchQuery_2732(2732, AllianceIslandreefsMatchQuery.getDefaultInstance(), AllianceIslandreefsMatchQueryRt.getDefaultInstance()),

    QueryActivityRelicPlant_2733(
        2733,
        QueryActivityRelicPlant.getDefaultInstance(),
        QueryActivityRelicPlantRt.getDefaultInstance()
    ),
    ReceiveActivityRelicPlant_2734(
        2734,
        ReceiveActivityRelicPlant.getDefaultInstance(),
        ReceiveActivityRelicPlantRt.getDefaultInstance()
    ),
    QueryActivitySavingBank_2735(
        2735,
        QueryActivitySavingBank.getDefaultInstance(),
        QueryActivitySavingBankRt.getDefaultInstance()
    ),
    ReceiveActivitySavingBank_2736(
        2736,
        ReceiveActivitySavingBank.getDefaultInstance(),
        ReceiveActivitySavingBankRt.getDefaultInstance()
    ),

    QueryThumbsUpRecords_2737(
        2737,
        QueryThumbsUpRecords.getDefaultInstance(),
        QueryThumbsUpRecordsRt.getDefaultInstance()
    ),
    ThumbsUpOther_2738(
        2738,
        ThumbsUpOther.getDefaultInstance(),
        ThumbsUpOtherRt.getDefaultInstance()
    ),
    QueryThumbsUpOtherRecords_2739(
        2739,
        QueryThumbsUpOtherRecords.getDefaultInstance(),
        QueryThumbsUpOtherRecordsRt.getDefaultInstance()
    ),
    QueryLordSkin_2740(
        2740,
        QueryLordSkin.getDefaultInstance(),
        QueryLordSkinRt.getDefaultInstance()
    ),
    LordSkinLvUp_2741(
        2741,
        LordSkinLvUp.getDefaultInstance(),
        LordSkinLvUpRt.getDefaultInstance()
    ),
    UseLordSkin_2742(
        2742,
        UseLordSkin.getDefaultInstance(),
        UseLordSkinRt.getDefaultInstance()
    ),

    QuerySouvenirCardInfo_2743(
        2743,
        QuerySouvenirCardInfo.getDefaultInstance(),
        QuerySouvenirCardInfoRt.getDefaultInstance()
    ),
    OpenSouvenirCard_2744(
        2744,
        OpenSouvenirCard.getDefaultInstance(),
        OpenSouvenirCardRt.getDefaultInstance()
    ),
    SouvenirCardExchange_2745(
        2745,
        SouvenirCardExchange.getDefaultInstance(),
        SouvenirCardExchangeRt.getDefaultInstance()
    ),
    SouvenirCardLevelUp_2746(
        2746,
        SouvenirCardLevelUp.getDefaultInstance(),
        SouvenirCardLevelUpRt.getDefaultInstance()
    ),
    AcceptSouvenirCardStageReward_2747(
        2747,
        AcceptSouvenirCardStageReward.getDefaultInstance(),
        AcceptSouvenirCardStageRewardRt.getDefaultInstance()
    ),
    ReceiveWhackMoleReward_2748(
        2748,
        ReceiveWhackMoleReward.getDefaultInstance(),
        ReceiveWhackMoleRewardRt.getDefaultInstance()
    ),
    GetWhackMoleData_2749(
        2749,
        GetWhackMoleData.getDefaultInstance(),
        GetWhackMoleDataRt.getDefaultInstance()
    ),
    QueryDayGiftPackageActivityInfo_2750(
        2750,
        QueryDayGiftPackageActivityInfo.getDefaultInstance(),
        QueryDayGiftPackageActivityInfoRt.getDefaultInstance(),
    ),
    GetDayGiftPackageActivityBigReward_2751(
        2751,
        GetDayGiftPackageActivityBigReward.getDefaultInstance(),
        GetDayGiftPackageActivityBigRewardRt.getDefaultInstance(),
    ),
    QueryTradeRoute_2752(
        2752,
        QueryTradeRoute.getDefaultInstance(),
        QueryTradeRouteRt.getDefaultInstance(),
    ),
    RefreshRacingQuality_2753(
        2753,
        RefreshRacingQuality.getDefaultInstance(),
        RefreshRacingQualityRt.getDefaultInstance(),
    ),
    GoMyRacing_2754(
        2754,
        GoMyRacing.getDefaultInstance(),
        GoMyRacingRt.getDefaultInstance(),
    ),
    QueryDetailRacing_2755(
        2755,
        QueryDetailRacing.getDefaultInstance(),
        QueryDetailRacingRt.getDefaultInstance(),
    ),
    QueryOtherRacing_2756(
        2756,
        QueryOtherRacing.getDefaultInstance(),
        QueryOtherRacingRt.getDefaultInstance(),
    ),
    OpenOtherRacingInfo_2757(
        2757,
        OpenOtherRacingInfo.getDefaultInstance(),
        OpenOtherRacingInfoRt.getDefaultInstance(),
    ),
    RobOtherRacing_2758(
        2758,
        RobOtherRacing.getDefaultInstance(),
        RobOtherRacingRt.getDefaultInstance(),
    ),
    OpenMyRacingHelpInfo_2759(
        2759,
        OpenMyRacingHelpInfo.getDefaultInstance(),
        OpenMyRacingHelpInfoRt.getDefaultInstance(),
    ),
    SendMyRacingHelp_2760(
        2760,
        SendMyRacingHelp.getDefaultInstance(),
        SendMyRacingHelpRt.getDefaultInstance(),
    ),
    QueryRacingHelpInfo_2761(
        2761,
        QueryRacingHelpInfo.getDefaultInstance(),
        QueryRacingHelpInfoRt.getDefaultInstance(),
    ),

    QueryMyRacingRecord_2763(
        2763,
        QueryMyRacingRecord.getDefaultInstance(),
        QueryMyRacingRecordRt.getDefaultInstance(),
    ),
    ReceiveRacingReward_2764(
        2764,
        ReceiveRacingReward.getDefaultInstance(),
        ReceiveRacingRewardRt.getDefaultInstance(),
    ),
    QueryRobMeLastRecord_2765(
        2765,
        QueryRobMeLastRecord.getDefaultInstance(),
        QueryRobMeLastRecordRt.getDefaultInstance(),
    ),
    DelTradeRouteRedPoint_2766(
        2766,
        DelTradeRouteRedPoint.getDefaultInstance(),
        DelTradeRouteRedPointRt.getDefaultInstance(),
    ),
    QueryDetailRacingRecord_2767(
        2767,
        QueryDetailRacingRecord.getDefaultInstance(),
        QueryDetailRacingRecordRt.getDefaultInstance(),
    ),
    GetFindGhostData_2771(
        2771,
        GetFindGhostData.getDefaultInstance(),
        GetFindGhostDataRt.getDefaultInstance()
    ),
    ReceiveFindGhostReward_2772(
        2772,
        ReceiveFindGhostReward.getDefaultInstance(),
        ReceiveFindGhostRewardRt.getDefaultInstance()
    ),
    ParkManagementQuery_2773(
        2773,
        ParkManagementQuery.getDefaultInstance(),
        ParkManagementQueryRt.getDefaultInstance()
    ),
    ParkManagementOpt_2774(
        2774,
        ParkManagementOpt.getDefaultInstance(),
        ParkManagementOptRt.getDefaultInstance()
    ),
    ParkManagementPlotFinish_2775(
        2775,
        ParkManagementPlotFinish.getDefaultInstance(),
        ParkManagementPlotFinishRt.getDefaultInstance()
    ),
    BloodArchePurify_2776(
        2776,
        BloodArchePurify.getDefaultInstance(),
        BloodArchePurifyRt.getDefaultInstance()
    ),
    QueryHackerMasterInfo_2777(
        2777,
        QueryHackerMasterInfo.getDefaultInstance(),
        QueryHackerMasterInfoRt.getDefaultInstance()
    ),
    HackerMasterPlay_2778(
        2778,
        HackerMasterPlay.getDefaultInstance(),
        HackerMasterPlayRt.getDefaultInstance()
    ),
    HackerMasterNextLayer_2779(
        2779,
        HackerMasterNextLayer.getDefaultInstance(),
        HackerMasterNextLayerRt.getDefaultInstance()
    ),
    HackerMasterSetBigReward_2780(
        2780,
        HackerMasterSetBigReward.getDefaultInstance(),
        HackerMasterSetBigRewardRt.getDefaultInstance()
    ),
    HackerMasterReceiveStageReward_2781(
        2781,
        HackerMasterReceiveStageReward.getDefaultInstance(),
        HackerMasterReceiveStageRewardRt.getDefaultInstance()
    ),
    BattlefieldMatchQuery_2786(
        2786,
        BattlefieldMatchQuery.getDefaultInstance(),
        BattlefieldMatchQueryRt.getDefaultInstance()
    ),
    QueryActivityCookInfo_2787(
        2787,
        QueryActivityCookInfo.getDefaultInstance(),
        QueryActivityCookInfoRt.getDefaultInstance()
    ),
    ActivityCookChefLvUp_2788(
        2788,
        ActivityCookChefLvUp.getDefaultInstance(),
        ActivityCookChefLvUpRt.getDefaultInstance()
    ),
    ActivityCooking_2789(
        2789,
        ActivityCooking.getDefaultInstance(),
        ActivityCookingRt.getDefaultInstance()
    ),
    ActivityCookDishLvUp_2790(
        2790,
        ActivityCookDishLvUp.getDefaultInstance(),
        ActivityCookDishLvUpRt.getDefaultInstance()
    ),
    ActivityCookReceiveUtensil_2791(
        2791,
        ActivityCookReceiveUtensil.getDefaultInstance(),
        ActivityCookReceiveUtensilRt.getDefaultInstance()
    ),
    QueryActivitySpecialPay_2793(
        2793,
        QueryActivitySpecialPay.getDefaultInstance(),
        QueryActivitySpecialPayRt.getDefaultInstance()
    ),
    DinosaurHeroInfoQuery_2794(
        2794,
        DinosaurHeroInfoQuery.getDefaultInstance(),
        DinosaurHeroInfoQueryRt.getDefaultInstance()
    ),
    DinosaurHeroLvUp_2795(
        2795,
        DinosaurHeroLvUp.getDefaultInstance(),
        DinosaurHeroLvUpRt.getDefaultInstance()
    ),
    DinosaurHeroSkillUp_2796(
        2796,
        DinosaurHeroSkillUp.getDefaultInstance(),
        DinosaurHeroSkillUpRt.getDefaultInstance()
    ),

    ActivityBlackFridayInfo_2821(
        2821,
        ActivityBlackFridayInfo.getDefaultInstance(),
        ActivityBlackFridayInfoRt.getDefaultInstance()
    ),
    ActivityBlackFridaySet_2822(
        2822,
        ActivityBlackFridaySet.getDefaultInstance(),
        ActivityBlackFridaySetRt.getDefaultInstance()
    ),
    ActivityBlackFridayPlay_2823(
        2823,
        ActivityBlackFridayPlay.getDefaultInstance(),
        ActivityBlackFridayPlayRt.getDefaultInstance()
    ),
    ActivityBlackFridayStepReward_2824(
        2824,
        ActivityBlackFridayStepReward.getDefaultInstance(),
        ActivityBlackFridayStepRewardRt.getDefaultInstance()
    ),
    QueryCrossGrandPrizeRecord_2826(
        2826,
        QueryCrossGrandPrizeRecord.getDefaultInstance(),
        QueryCrossGrandPrizeRecordRt.getDefaultInstance()
    ),
    SetupMedal_2827(
        2827,
        SetupMedal.getDefaultInstance(),
        SetupMedalRt.getDefaultInstance()
    ),
    QueryMedalShowInfo_2828(
        2828,
        QueryMedalShowInfo.getDefaultInstance(),
        QueryMedalShowInfoRt.getDefaultInstance()
    ),


    // 客户端推给服务器的消息.消息头从3000开始
    RefreshMoney_3000(3000, null, RefreshMoney.getDefaultInstance()), // 刷新资源
    EnterMaintenance_3001(3001, null, EnterMaintenance.getDefaultInstance()), // 通知客户端，服务器开始维护
    PaySucessNotify_3002(3002, null, PaySuccessNotify.getDefaultInstance()), // 部分主动发货的支付平台，将支付成功消息返回给客户端
    HeroStateChange_3004(3004, null, HeroStateChange.getDefaultInstance()), // 武将状态发生变化
    PlayerMedalChangeNotice_3008(3008, null, PlayerMedalChangeNotice.getDefaultInstance()), // 勋章变化推送
    YieldChange_3009(3009, null, YieldChange.getDefaultInstance()), // 产量变化主推
    HeroChange_3010(3010, null, HeroChange.getDefaultInstance()), // 武将升级推送
    SurveyCompleteNotice_3011(3011, null, SurveyCompleteNotice.getDefaultInstance()), // 问卷完成推送
    AssistSummonMailNotice_3012(3012, null, AssistSummonMailNotice.getDefaultInstance()), // 点赞圣女
    AssistAllianceChatNotice_3013(3013, null, AssistAllianceChatNotice.getDefaultInstance()), // 点赞联盟聊天
    UpdateLandBelong_3014(3014, null, UpdateLandBelong.getDefaultInstance()),
    DecreeChange_3015(3015, null, DecreeChange.getDefaultInstance()), // 令牌变化主推
    AllianceInfoChange_3018(3018, null, AllianceInfoChange.getDefaultInstance()), // 联盟信息变化推送（自己）
    AlliancePosChange_3023(3023, null, AlliancePosChange.getDefaultInstance()), // 联盟职位变化
    HuoyueduChange_3034(3034, null, HuoyueduChange.getDefaultInstance()), // 活跃度积分变更推送
    TaskChange_3035(3035, null, TaskChange.getDefaultInstance()), // 任务变化
    RescueEmailIdUpdate_3039(3039, null, RescueEmailIdUpdate.getDefaultInstance()),
    VisitQuestPop_3040(3040, null, VisitQuestPop.getDefaultInstance()),
    NoticeInfo_3055(3055, null, NoticeInfo.getDefaultInstance()), // 公告信息

    CabbageDataInfo_3060(3060, null, CabbageDataInfo.getDefaultInstance()), // 偷菜数据
    AutoFightCommonBossInfo_3061(3061, null, AutoFightCommonBossInfo.getDefaultInstance()), // 自动打野
    ChargeBuffChange_3062(3062, null, ChargeBuffChange.getDefaultInstance()), // 充能buff变更

    RoomDel_3073(3073, null, RoomDel.getDefaultInstance()), // 删除聊天室
    GroupChatInfo_3076(3076, null, GroupChatInfo.getDefaultInstance()), // 聊天室消息推送
    PrivateChatInfo_3079(3079, null, PrivateChatInfo.getDefaultInstance()), // 接收私聊消息
    NewChatMessage_3080(3080, null, NewChatMessage.getDefaultInstance()), // 接收聊天消息
    BagChange_3081(3081, null, BagChange.getDefaultInstance()), // 玩家物品背包变化
    AllianceTopicReplyChange_3100(3100, null, AllianceTopicReplyChange.getDefaultInstance()), // 联盟邮件新主题或新回复通知

    ChatBubbleChange_3111(3111, null, ChatBubbleChange.getDefaultInstance()), // 使用道具获得气泡
    ChangePickUpCount_3112(3112, null, ChangePickUpCount.getDefaultInstance()), // 当日拾取资源点次数
    ChangeNpcCityActivity_3113(3113, null, ChangeNpcCityActivity.getDefaultInstance()), // 神庙活动

    ResearchChange_3121(3121, null, ResearchChange.getDefaultInstance()), // 玩家科技信息变化

    GetAllianceHelp_3122(3122, null, GetAllianceHelp.getDefaultInstance()), // 玩家获得帮助提示窗
    BarracksNumChange_3123(3123, null, BarracksNumChange.getDefaultInstance()), // 兵数量变化
    BarracksQueueChange_3126(3126, null, BarracksQueueChange.getDefaultInstance()), // 兵营造兵队列变化
    BarracksWoundedSoldierChange_3127(3127, null, BarracksWoundedSoldierChange.getDefaultInstance()), // 兵营伤兵变更
    BarracksAddFromTrainSuccess_3128(3128, null, BarracksAddFromTrainSuccess.getDefaultInstance()), // 兵营训练成功加兵
    BarracksRefugeSoldierChange_3129(3129, null, BarracksRefugeSoldierChange.getDefaultInstance()), // 兵营避难兵变更
    VipChange_3133(3133, null, VipChange.getDefaultInstance()), // vip变化
    KingExpChange_3134(3134, null, KingExpChange.getDefaultInstance()), // 君主经验变化
    EnterGamePublicRt_3135(3135, null, EnterGamePublicRt.getDefaultInstance()), // 进游戏时的public服推送过来的数据

    WalkRobotShow_3140(3140, null, WalkRobotShow.getDefaultInstance()), // 行军线的新增与删除

    AttackNotice_3141(3141, null, AttackNotice.getDefaultInstance()), // 攻击通知

    WalkGroupChange_3142(3142, null, NoticeWalkGroupChange.getDefaultInstance()), // 行军组变化

    GetNewAllianceGift_3145(3145, null, GetNewAllianceGift.getDefaultInstance()), // 获得一个联盟礼物
    AllianceGiftChange_3146(3146, null, AllianceGiftChange.getDefaultInstance()), // 联盟大礼物数据发生变化

    BuffChange_3151(3151, null, BuffChange.getDefaultInstance()), // buff情况发生变化
    NoticeLanMsg_3154(3154, null, NoticeLanMsg.getDefaultInstance()), // 通知lan消息
    PlayerPowerChange_3161(3161, null, PlayerPowerChange.getDefaultInstance()), // 玩家实力变化
    StoreLimitChange_3165(3165, null, StoreLimitChange.getDefaultInstance()), // 资源产量上限变化
    CountryPositionChange_3166(3166, null, CountryPositionChange.getDefaultInstance()), // 官职变化主推
    CastlePosChange_3167(3167, null, CastlePosChange.getDefaultInstance()), // 玩家城位置变化
    InnerCityInfoChanged_3168(3168, null, InnerCityInfoChanged.getDefaultInstance()), // 内城建筑变化
    WonderForceChange_3169(3169, null, WonderForceChange.getDefaultInstance()), // 奇观部队变化
    AmnestyCountChange_3170(3170, null, AmnestyCountChange.getDefaultInstance()), // 赦免次数变化
    MonsterDamageInfo_3176(3176, null, MonsterDamageInfo.getDefaultInstance()),// 魔物伤害信息推送
    MarkNumChange_3177(3177, null, MarkNumChange.getDefaultInstance()),// 玩家收藏变化
    ArenaRankChange_3178(3178, null, ArenaRankChange.getDefaultInstance()), // 竞技场排名变化
    ArenaRewardGet_3179(3179, null, ArenaRewardGet.getDefaultInstance()),// 无用
    NewLibraryItem_3183(3183, null, NewLibraryItem.getDefaultInstance()),// 点亮相关功能
    GetRes_3184(3184, null, GetRes.getDefaultInstance()),
    FriendApplySuccess_3185(3185, null, FriendApplySuccess.getDefaultInstance()),
    ActivityEnterTimeChange_3187(3187, null, ActivityEnterTimeChange.getDefaultInstance()),
    EnterChatRoomInfo_3188(3188, null, EnterGameChatRoomInfo.getDefaultInstance()),
    SendStrangerInfo_3189(3189, null, SendStrangerInfo.getDefaultInstance()),

    // KillActivityBossReport_3190(3190, null, KillActivityBossReport.getDefaultInstance()),
    WonderOccupied_3191(3191, null, WonderOccupied.getDefaultInstance()),
    CheckConfig_3192(3192, null, CheckConfig.getDefaultInstance()),
    NewGrowthFund_3196(3196, null, NewGrowthFund.getDefaultInstance()),// 成长基金

    AllianceNewBossBuildStateChange_3197(3197, null, AllianceNewBossState.getDefaultInstance()),
    AllianceNewBossOpen_3198(3198, null, AllianceNewBossIsOpen.getDefaultInstance()),
    HieronOccupied_3199(3199, null, WonderOccupied.getDefaultInstance()),

    WineHallFreeNotice_3210(3210, null, WineHallFreeNotice.getDefaultInstance()),
    CabbageBeStolenNotice_3211(3211, null, CabbageBeStolenNotice.getDefaultInstance()),
    InnerCityFatigueChange_3250(3250, null, InnerCityFatigueChange.getDefaultInstance()),// 无用

    EliminateMonsterOnMapChange_3260(3260, null, EliminateMonsterOnMapChange.getDefaultInstance()),
    RadarMonsterOnMapChange_3261(3261, null, RadarMonsterOnMapChange.getDefaultInstance()),
    VirtualMapClearChange_3262(3262, null, VirtualMapClearChange.getDefaultInstance()),
    EnergySpecialChange_3270(3270, null, EnergySpecialChange.getDefaultInstance()),

    WonderInfoInit_3304(3304, null, WonderInfoInit.getDefaultInstance()),
    RandomEventInit_3305(3305, null, RandomEventInit.getDefaultInstance()), // 内城随机事件初始化推送

    PlayerTagChange_3320(3320, null, PlayerTagChange.getDefaultInstance()),
    AllianceTagChange_3321(3321, null, AllianceTagChange.getDefaultInstance()),

    SkinInfoInit_3350(3350, null, SkinInfoInit.getDefaultInstance()),
    PlayerAddInfoInit_3351(3351, null, PlayerAddInfoInit.getDefaultInstance()),
    MarkInfoInit_3353(3353, null, MarkInfoInit.getDefaultInstance()),// 收藏

    WorldWonderStatusChange_3361(3361, null, NotifyWorldWonderStatusChange.getDefaultInstance()),

    KickPlayerOffline_3371(3371, null, KickPlayerOffline.getDefaultInstance()),
    JjcTimeRewardChange_3372(3372, null, JjcTimeRewardChange.getDefaultInstance()),
    FireEndTimeChange_3373(3373, null, FireEndTimeChange.getDefaultInstance()),
    PlayerEffectChange_3375(3375, null, PlayerEffectChange.getDefaultInstance()),
    ActionQueueChange_3376(3376, null, ActionQueueChange.getDefaultInstance()),
    RedPointChange_3377(3377, null, RedPointChange.getDefaultInstance()),
    BuildingViewChange_3378(3378, null, BuildingViewChange.getDefaultInstance()),// 建筑视图
    QueueChange_3379(3379, null, QueueChange.getDefaultInstance()), // 队列
    GetSurpriseGiftPackage_3381(3381, null, GetSurpriseGiftPackage.getDefaultInstance()),
    SuccessGetGiftPackage_3382(3382, null, SuccessGetGiftPackage.getDefaultInstance()),
    ClubCardChange_3383(3383, null, ClubCardChange.getDefaultInstance()),
    ClubCardComboChange_3384(3384, null, ClubCardComboChange.getDefaultInstance()),
    AppreciationsChange_3402(3402, null, AppreciationsChange.getDefaultInstance()),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    WorldReboot_3403(3403, null, WorldReboot.getDefaultInstance()),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    CountryBuffChange_3405(3405, null, CountryBuffChange.getDefaultInstance()),
    InstanceTimeChange_3406(3406, null, InstanceTimeChange.getDefaultInstance()),
    AllianceBagScoreChange_3407(3407, null, AllianceBagScoreChange.getDefaultInstance()),
    NowPurchaseActivityChange_3408(3408, null, NowPurchaseActivityChange.getDefaultInstance()),
    DiamondInfoChange_3409(3409, null, DiamondInfoChange.getDefaultInstance()),
    FightAllianceStateChange_3412(3412, null, FightAllianceStateChange.getDefaultInstance()),
    PayNumChange_3413(3413, null, PayNumChange.getDefaultInstance()),
    JjcScoreChange_3414(3414, null, JjcScoreChange.getDefaultInstance()),
    WalkGroupFightConfirm_3416(3416, null, WalkGroupFightConfirm.getDefaultInstance()),
    AllianceFightScoreChange_3417(3417, null, AllianceFightScoreChange.getDefaultInstance()),
    WorldCheckPointOccupied_3421(3421, null, WorldCheckPointOccupied.getDefaultInstance()),
    BulletScreenNotice_3422(3422, null, BulletScreenNotice.getDefaultInstance()),
    ResOccupied_3421(3423, null, ResOccupied.getDefaultInstance()),
    WonderWarInfoChange_3424(3424, null, WonderWarInfoChange.getDefaultInstance()),
    MonsterInfoChange_3427(3427, null, MonsterInfoChange.getDefaultInstance()),
    FlagInfoChange_3428(3428, null, FlagInfoChange.getDefaultInstance()),
    AllianceMailNotifier_3429(3429, null, AllianceMailNotifier.getDefaultInstance()),
    CellXyConstraintChangeNotifier_3431(3431, null, CellXyConstraintChange.getDefaultInstance()),// 无用
    PopupNotice_3432(3432, null, PopupNotice.getDefaultInstance()),
    MassTargetNotice_3433(3433, null, MassTargetNotice.getDefaultInstance()),
    AllianceBuildNumChange_3436(3436, null, AllianceBuildNumChange.getDefaultInstance()),
    LandAroundChange_3437(3437, null, LandAroundChange.getDefaultInstance()),
    AllianceFightAllRevive_3438(3438, null, AllianceFightAllRevive.getDefaultInstance()),
    AllianceBuildFireChange_3439(3439, null, AllianceBuildFireChange.getDefaultInstance()),
    AllianceBuildBeAtk_3440(3440, null, AllianceBuildBeAtk.getDefaultInstance()),
    AllianceFlagSoliderChange_3443(3443, null, AllianceFlagSoliderChange.getDefaultInstance()),
    AllianceSoloStateChange_3444(3444, null, AllianceSoloStateChange.getDefaultInstance()),
    AllianceSoloMainChange_3445(3445, null, AllianceSoloMainChange.getDefaultInstance()),
    TotalPayRewardChange_3446(3446, null, TotalPayRewardChange.getDefaultInstance()),
    WorldActivityChange_3448(3448, null, WorldActivityChange.getDefaultInstance()),
    WorldActivityLotteryFinish_3449(3449, null, WorldActivityLotteryFinish.getDefaultInstance()),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    FarmedResNotice_3450(3450, null, FarmedResNotice.getDefaultInstance()),
    WalkGroupWipeOutNotice_3452(3452, null, WalkGroupWipeOutNotice.getDefaultInstance()),
    InstructionNotice_3453(3453, null, InstructionNotice.getDefaultInstance()),
    ForceExpressionNotice_3455(3455, null, ForceExpressionNotice.getDefaultInstance()),
    LandChangeNotice_3460(3460, null, LandChangeNotice.getDefaultInstance()),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    AllianceBuildChangeNotice_3461(3461, null, AllianceBuildChangeNotice.getDefaultInstance()),
    AllianceMarkChangeNotice_3462(3462, null, AlliMarkNotice.getDefaultInstance()),
    AllianceMemberPosChangeChangeNotice_3463(3463, null, AllianceMemberPosChangeChangeNotice.getDefaultInstance()),
    AllianceBuildDisappearNotice_3464(3464, null, AllianceBuildDisappear.getDefaultInstance()),
    WarnDataChangeNotice_3470(3470, null, WarnDataChangeNotice.getDefaultInstance()),
    AtkNotice_3471(3471, null, AtkNotice.getDefaultInstance()),
    PhotoChange_3472(3472, null, PhotoChange.getDefaultInstance()),
    WarnSpeedDataChangeNotice_3473(3473, null, WarnSpeedDataChangeNotice.getDefaultInstance()),
    PhotoFrameChange_3474(3474, null, PhotoFrameChangeNotice.getDefaultInstance()),
    CallRelicChangeNotice_3475(3475, null, CallRelicChangeNotice.getDefaultInstance()),
    MaxKillBossLvNotice_3476(3476, null, MaxKillBossLvNotice.getDefaultInstance()),
    AllianceTopInfoNotice_3477(3477, null, AllianceTopInfoNotice.getDefaultInstance()),
    ArmyActivityChangeNotice_3478(3478, null, ArmyActivityChangeNotice.getDefaultInstance()),
    MoreNoticeLanMsg_3479(3479, null, MoreNoticeLanMsg.getDefaultInstance()),
    ArmyActivityWinNotice_3481(3481, null, ArmyActivityWinNotice.getDefaultInstance()),
    WorldWonderChangeNotice_3482(3482, null, WorldWonderChangeNotice.getDefaultInstance()),
    AllianceCmpttTaskChgNotice_3486(3486, null, AllianceCmpttTaskChgNotice.getDefaultInstance()),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    PickUpResPointTakeMultiNotice_3487(3487, null, PickUpResPointTakeMultiNotice.getDefaultInstance()),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    CleanPlayerChatRecordsNotice_3489(3489, null, CleanPlayerChatRecordsNotice.getDefaultInstance()),
    BanInfoNotice_3490(3490, null, BanInfoNotice.getDefaultInstance()),
    CapitalBattleStateChange_3491(3491, null, CapitalBattleStateChange.getDefaultInstance()),
    CapitalBattleOfficer_3492(3492, null, CapitalBattleOfficer.getDefaultInstance()),
    CapitalBattleBelongChange_3493(3493, null, CapitalBattleBelongChange.getDefaultInstance()),
    CapitalBattleBeCannonAtk_3494(3494, null, CapitalBattleBeCannonAtk.getDefaultInstance()),
    JoinNoSuccessTellNotice_3495(3495, null, JoinNoSuccessTellNotice.getDefaultInstance()),
    MidasMoneyChange_3496(3496, null, MidasMoneyChange.getDefaultInstance()),
    GetResChangeNotice_3498(3498, null, GetResChangeNotice.getDefaultInstance()),
    FunctionBanChangeNotice_3500(3500, null, FunctionBanChangeNotice.getDefaultInstance()),
    CheckTextResultNotice_3501(3501, null, CheckTextResultNotice.getDefaultInstance()),
    LordSkinChange_3502(3502, null, LordSkinChange.getDefaultInstance()),
    @Deprecated("ED_暂时保留 废弃消息，要移除的话，确认前端不再调用，连同proto一起移除")
    TreasureAutoRefTimeChangeNotice_3503(3503, null, TreasureAutoRefTimeChange.getDefaultInstance()),
    TreasureChangeNotice_3504(3504, null, TreasureChange.getDefaultInstance()),
    NewMailNotice_3505(3505, null, NewMailNotice.getDefaultInstance()),
    UiconditionOpenNotice_3506(3506, null, UiconditionOpenNotice.getDefaultInstance()),
    WorldChatRespNotice_3507(3507, null, WorldChatRespNotice.getDefaultInstance()),
    JjcOpenInfoNotice_3508(3508, null, JjcOpenInfoNotice.getDefaultInstance()),
    FestivalRewardChangeNotice_3510(3510, null, FestivalRewardChangeNotice.getDefaultInstance()),
    FestivalBossAtkNumChangeNotice_3511(3511, null, FestivalBossAtkNumChangeNotice.getDefaultInstance()),
    YanwuAttackNumChangeNotice_3512(3512, null, YanwuAttackNumChangeNotice.getDefaultInstance()),
    AllianceCallNotice_3514(3514, null, AllianceCallNotice.getDefaultInstance()),
    LeaveAllianceCdNotice_3515(3515, null, LeaveAllianceCdNotice.getDefaultInstance()),
    NpcCityOccupyNotice_3516(3516, null, NpcCityOccupyNotice.getDefaultInstance()),
    NpcCityOccupyChangeNotice_3517(3517, null, NpcCityOccupyChangeNotice.getDefaultInstance()),
    AllianceJourneyChangeNotice_3530(3530, null, AllianceJourneyChangeNotice.getDefaultInstance()),
    PlunderLimitInfoChangeNotice_3533(3533, null, PlunderLimitInfoChangeNotice.getDefaultInstance()),
    ClientUpdateNotice_3534(3534, null, ClientUpdateNotice.getDefaultInstance()),
    PictureUrlChangeNotice_3535(3535, null, PictureUrlChangeNotice.getDefaultInstance()),

    BattleFieldAllianceScoreInfoChange_3537(3537, null, BattleFieldAllianceScoreInfoChange.getDefaultInstance()),
    BattleFieldBuildingInfoChange_3538(3538, null, BattleFieldBuildingInfoChange.getDefaultInstance()),
    BattleFieldBackWorldNotice_3540(3540, null, BattleFieldBackWorldNotice.getDefaultInstance()),
    BattleFieldEndNotice_3539(3539, null, BattleFieldEndNotice.getDefaultInstance()),
    BattleFieldChargeBuffChange_3541(3541, null, BattleFieldChargeBuffChange.getDefaultInstance()),
    BattleFieldCitySkillUseNotice_3542(3542, null, BattleFieldCitySkillUseNotice.getDefaultInstance()),
    BattlefieldMemberNumNotice_3544(3544, null, BattlefieldMemberNumNotice.getDefaultInstance()),

    AllianceColosseumNoticee_3543(3543, null, AllianceColosseumNotice.getDefaultInstance()),
    AllianceDefCannonAttackNotice_3550(3550, null, AllianceDefCannonAttackNotice.getDefaultInstance()),
    CabbageActivityExpChange_3560(3560, null, CabbageActivityExpChange.getDefaultInstance()),
    DinosaurNotice_3561(3561, null, DinosaurNotice.getDefaultInstance()),
    DinosaurMissionNotice_3562(3562, null, DinosaurMissionNotice.getDefaultInstance()),
    NeutralCityRegisterNotice_3563(3563, null, NeutralCityRegisterNotice.getDefaultInstance()),
    QuestionnaireChangeNotice_3564(3564, null, QuestionnaireChangeNotice.getDefaultInstance()),
    ArmyActivityRobotChangeNotice_3565(3565, null, ArmyActivityRobotChangeNotice.getDefaultInstance()),
    BuyAllianceGiftSupportBoxBuyTimeChange_3566(3566, null, BuyAllianceGiftSupportBoxBuyTimeChange.getDefaultInstance()),
    CapitalBlackLandKickNotice_3568(3568, null, CapitalBlackLandKickNotice.getDefaultInstance()),
    AddDecorationBuildNotice_3569(3569, null, AddDecorationBuildNotice.getDefaultInstance()),
    NeutralCityNotice_3570(3570, null, NeutralCityNotice.getDefaultInstance()),
    BattlefieldResourceNotice_3571(3571, null, BattlefieldResourceNotice.getDefaultInstance()),
    RexComingNotice_3572(3572, null, RexComingNotice.getDefaultInstance()),
    BattlefieldHeroNotice_3573(3573, null, BattlefieldHeroNotice.getDefaultInstance()),
    AllianceUnitTaskNotice_3574(3574, null, AllianceUnitTaskNotice.getDefaultInstance()),
    NewRedPacketMessage_3575(3575, null, NewRedPacketMessage.getDefaultInstance()),
    MysteryUnlockNotice_3576(3576, null, MysteryUnlockNotice.getDefaultInstance()),
    AllianceNewBossHelpMessageNotice_3577(3577, null, AllianceNewBossHelpMessageNotice.getDefaultInstance()),
    WidgetAllianceNewBossHelpRemindNotice_3578(3578, null, WidgetAllianceNewBossHelpRemindNotice.getDefaultInstance()),
    OperationWarehouseNotice_3580(3580, null, OperationWarehouseNotice.getDefaultInstance()),
    ArenaDefenseFailNotice_3581(3581, null, ArenaDefenseFailNotice.getDefaultInstance()),
    OperationAttributeNotice_3582(3582, null, OperationAttributeNotice.getDefaultInstance()),
    OperationBookUnlockNotice_3583(3583, null, OperationBookUnlockNotice.getDefaultInstance()),
    OperationMuseumLikeNotice_3584(3584, null, OperationMuseumLikeNotice.getDefaultInstance()),
    CrossKingdomActivityTimeInfoNotice_3585(3585, null, CrossKingdomActivityTimeInfoNotice.getDefaultInstance()),
    CrossKingdomWinnerNotice_3586(3586, null, CrossKingdomWinnerNotice.getDefaultInstance()),
    CrossKingdomLadderLoserNotice_3587(3587, null, CrossKingdomLadderLoserNotice.getDefaultInstance()),
    RestrictedQuestChangeNotice_3588(3588, null, RestrictedQuestChangeNotice.getDefaultInstance()),
    FrontendRefreshNotice_3589(3589, null, FrontendRefreshNotice.getDefaultInstance()),
    CrossKingdomWarfareKickNotice_3589(3590, null, CrossKingdomWarfareKickNotice.getDefaultInstance()),
    PetTreasureHelpNotice_3591(3591, null, PetTreasureHelpNotice.getDefaultInstance()),
    MergeServerNotice_3592(3592, null, MergeServerNotice.getDefaultInstance()),
    HeroComponentChangeNotice_3593(3593, null, HeroComponentChange.getDefaultInstance()),
    SurpriseActivityNotice_3594(3594, null, SurpriseActivityNotice.getDefaultInstance()),
    LotteryBossChange_3595(3595, null, LotteryBossChange.getDefaultInstance()),
    ThumbsUpMeNotice_3596(3596, null, ThumbsUpMeNotice.getDefaultInstance()),
    BattlefieldCityGuardianChange_3597(3597, null, BattlefieldCityGuardianChangeNotice.getDefaultInstance()),
    OperationTransportChange_3598(3598, null, OperationTransportChange.getDefaultInstance()),
    SouvenirCardChange_3599(3599, null, SouvenirCardChange.getDefaultInstance()),
    BattleFieldInformationChange_3600(3600, null, BattleFieldInformationChange.getDefaultInstance()),
    BattleFieldHotInfoChange_3601(3601, null, BattleFieldHotInfoChange.getDefaultInstance()),

    DinouaurHuntingChange_3602(3602, null, DinosaurHuntingChange.getDefaultInstance()),

    BattleFieldPlayerScoreInfoChange_3603(3603, null, BattleFieldPlayerScoreInfoChange.getDefaultInstance()),
    ParkManagementPlotAdd_3604(3604, null, ParkManagementPlotAdd.getDefaultInstance()),
    ParkManagementValueChange_3605(3605, null, ParkManagementValueChange.getDefaultInstance()),
    DinosaurBloodArcheGet_3606(3606, null, DinosaurBloodArcheGet.getDefaultInstance()),

    TradeRouteNewRecord_3607(3607, null, TradeRouteNewRecord.getDefaultInstance()),
    AllianceBuildingChange_3608(3608, null, AllianceBuildingChange.getDefaultInstance()),
    SyncTradeRouteRacing_3609(3609, null, SyncTradeRouteRacing.getDefaultInstance()),

    DinouaurHuntingCouponChange_3610(3610, null, DinosaurHuntingCouponChange.getDefaultInstance()),
    AutoMakeSoldierSwitchCloseNotice_3611(3611, null, AutoMakeSoldierSwitchCloseNotice.getDefaultInstance()),
    AutoDrawSoldierNotice_3612(3612, null, AutoDrawSoldierNotice.getDefaultInstance()),
    SyncActivityCookUtensils_3613(3613, null, SyncActivityCookUtensils.getDefaultInstance()),
    FestivalSimpleInfoChangeNotice_3614(3614, null, FestivalSimpleInfoChangeNotice.getDefaultInstance()),
    HeroCompoundNotice_3615(3615, null, HeroCompoundNotice.getDefaultInstance()),
    NpcCityNotice_3616(3616, null, NpcCityNotice.getDefaultInstance()),
    DisappearBuildingChanged_3617(3617, null, DisappearBuildingChanged.getDefaultInstance()),
    ;

    companion object : EnumConverter<Int, MsgType>(buildValueMap(MsgType::msgType)) {

        // request
        fun fromReq(value: Int): MessageLite? {
            val msgType = fromValue(value)
            if (msgType == null) {
                return null
            }
            return msgType.req
        }

        // response
        fun fromResp(value: Int): MessageLite? {
            val msgType = fromValue(value)
            if (msgType == null) {
                return null
            }
            return msgType.resp
        }

    }
}

