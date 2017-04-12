package com.crm.biz.util;

import java.util.ArrayList;
import java.util.List;

public class ExcelTemplate {
	public static List<String> GOODS_TITLE = new ArrayList<String>();
	static {
		GOODS_TITLE.add("物流主码");
		GOODS_TITLE.add("商品名称");
		GOODS_TITLE.add("商品品牌");
//		GOODS_TITLE.add("供应商");
//		GOODS_TITLE.add("一级分类");
//		GOODS_TITLE.add("二级分类");
//		GOODS_TITLE.add("三级分类");
//		GOODS_TITLE.add("销售渠道");
//		GOODS_TITLE.add("发货方式");
//		GOODS_TITLE.add("商品进价");
//		 GOODS_TITLE.add("定金价");
//		 GOODS_TITLE.add("市场价");
//		GOODS_TITLE.add("商品类型");
//		GOODS_TITLE.add("采销类型");
//		GOODS_TITLE.add("是否生鲜");
//		GOODS_TITLE.add("是否自营");
//		GOODS_TITLE.add("采购经理");
//		GOODS_TITLE.add("采购总监");
//		GOODS_TITLE.add("上下架状态");
//		GOODS_TITLE.add("保质期");
//		GOODS_TITLE.add("最小采购量");
	}
	public static List<String> GOODS_DETAIL = new ArrayList<String>();
	static {
		GOODS_DETAIL.add("供应商名称");
		GOODS_DETAIL.add("采销经理");
		GOODS_DETAIL.add("采销类型");
		GOODS_DETAIL.add("发货方式");
		GOODS_DETAIL.add("保质期");
		GOODS_DETAIL.add("商品名称");
		GOODS_DETAIL.add("最小包装单位");
		GOODS_DETAIL.add("一级分类");
		GOODS_DETAIL.add("商品进价");
		GOODS_DETAIL.add("物流主码");
		GOODS_DETAIL.add("物流子码");
		GOODS_DETAIL.add("条形码");
		GOODS_DETAIL.add("选型规则");
		GOODS_DETAIL.add("颜色");
		GOODS_DETAIL.add("尺码");
	}
	public static List<String> PUBLIC_SUPPLIER = new ArrayList<String>();
	static {
		PUBLIC_SUPPLIER.add("供应商编码");
		PUBLIC_SUPPLIER.add("供应商名称");
		PUBLIC_SUPPLIER.add("供应商级别");
		PUBLIC_SUPPLIER.add("经营性质");
		PUBLIC_SUPPLIER.add("营业执照号");
		PUBLIC_SUPPLIER.add("税务登记号");
		PUBLIC_SUPPLIER.add("组织机构代码");
		PUBLIC_SUPPLIER.add("固定电话");
		PUBLIC_SUPPLIER.add("公司传真");
		PUBLIC_SUPPLIER.add("企业邮箱");
		PUBLIC_SUPPLIER.add("邮政编码");
		PUBLIC_SUPPLIER.add("经营地址");
		PUBLIC_SUPPLIER.add("开户名");
		PUBLIC_SUPPLIER.add("银行账号");
		PUBLIC_SUPPLIER.add("开户行");
		PUBLIC_SUPPLIER.add("开户行支行");
		PUBLIC_SUPPLIER.add("开户支行地址");
		PUBLIC_SUPPLIER.add("销售联系人");
		PUBLIC_SUPPLIER.add("物流联系人");
	}
	public static List<String> SUPPLIER_TITLE = new ArrayList<String>();
	static {
		SUPPLIER_TITLE.add("供应商编码");
		SUPPLIER_TITLE.add("供应商名称");
		SUPPLIER_TITLE.add("供应商级别");
		SUPPLIER_TITLE.add("经营性质");
		SUPPLIER_TITLE.add("营业执照号");
		SUPPLIER_TITLE.add("税务登记号");
		SUPPLIER_TITLE.add("组织机构代码");
		SUPPLIER_TITLE.add("固定电话");
		SUPPLIER_TITLE.add("公司传真");
		SUPPLIER_TITLE.add("企业邮箱");
		SUPPLIER_TITLE.add("邮政编码");
		SUPPLIER_TITLE.add("经营地址");
		SUPPLIER_TITLE.add("开户名");
		SUPPLIER_TITLE.add("银行账号");
		SUPPLIER_TITLE.add("开户行");
		SUPPLIER_TITLE.add("开户行支行");
		SUPPLIER_TITLE.add("开户支行地址");
		SUPPLIER_TITLE.add("销售联系人");
		SUPPLIER_TITLE.add("物流联系人");
		SUPPLIER_TITLE.add("采购经理");
		SUPPLIER_TITLE.add("采购总监");
	}

	public static List<String> CONTRACT_TITLE = new ArrayList<String>();
	static {
		CONTRACT_TITLE.add("合同编号");
		CONTRACT_TITLE.add("供应商名称");
		CONTRACT_TITLE.add("公司注册地址");
		CONTRACT_TITLE.add("公司经营地址");
		CONTRACT_TITLE.add("法人代表");
		CONTRACT_TITLE.add("固定电话");
		CONTRACT_TITLE.add("企业邮箱");
		CONTRACT_TITLE.add("收款方开户行");
		CONTRACT_TITLE.add("收款方开户行支行");
		CONTRACT_TITLE.add("收款方开户名");
		CONTRACT_TITLE.add("收款账号");
		CONTRACT_TITLE.add("合同类型");
		CONTRACT_TITLE.add("合同开始日期");
		CONTRACT_TITLE.add("合同截止日期");
		CONTRACT_TITLE.add("物流保障金");
		CONTRACT_TITLE.add("结算方式");
		// CONTRACT_TITLE.add("结算日期");
		// CONTRACT_TITLE.add("其他结算方式");
		// CONTRACT_TITLE.add("补充条款");
		CONTRACT_TITLE.add("采购经理");
		CONTRACT_TITLE.add("采购总监");
	}

	public static List<String> GOODSBASEINFO_TITLE = new ArrayList<String>();
	static {
		GOODSBASEINFO_TITLE.add("商品名称");
		GOODSBASEINFO_TITLE.add("发货方式");
		GOODSBASEINFO_TITLE.add("销售渠道");
		GOODSBASEINFO_TITLE.add("物流主码");
		GOODSBASEINFO_TITLE.add("进价");
		GOODSBASEINFO_TITLE.add("定金价");
		GOODSBASEINFO_TITLE.add("售价");
		GOODSBASEINFO_TITLE.add("会员价");
		GOODSBASEINFO_TITLE.add("市场价");
		GOODSBASEINFO_TITLE.add("CMS可售库存");
		GOODSBASEINFO_TITLE.add("实际库存");
		GOODSBASEINFO_TITLE.add("不良库存");
		GOODSBASEINFO_TITLE.add("便利体系可订货库存");
		GOODSBASEINFO_TITLE.add("最早成交日");
		GOODSBASEINFO_TITLE.add("累计销量");
		GOODSBASEINFO_TITLE.add("库存周转天数");
		GOODSBASEINFO_TITLE.add("一级分类");
		GOODSBASEINFO_TITLE.add("二级分类");
		GOODSBASEINFO_TITLE.add("三级分类");
		GOODSBASEINFO_TITLE.add("采销类型");
		GOODSBASEINFO_TITLE.add("采购经理");
		GOODSBASEINFO_TITLE.add("采购总监");
		GOODSBASEINFO_TITLE.add("状态");
		GOODSBASEINFO_TITLE.add("供应商");
		GOODSBASEINFO_TITLE.add("售卖区域");
	}

	public static List<String> RESULTSREPORT_TITLE = new ArrayList<String>();
	static {
		RESULTSREPORT_TITLE.add("采购经理");
		RESULTSREPORT_TITLE.add("采购总监");
		RESULTSREPORT_TITLE.add("总销售额");
		RESULTSREPORT_TITLE.add("员工代购销售额");
		RESULTSREPORT_TITLE.add("B2C销售额");
		RESULTSREPORT_TITLE.add("便利店销售额");
		RESULTSREPORT_TITLE.add("总毛利额");
		RESULTSREPORT_TITLE.add("员工代购毛利额");
		RESULTSREPORT_TITLE.add("B2C毛利额");
		RESULTSREPORT_TITLE.add("便利店毛利额");
		RESULTSREPORT_TITLE.add("退款金额");
	}

	public static List<String> SALESREPORT_TITLE = new ArrayList<String>();
	static {
		SALESREPORT_TITLE.add("商品名称");
		SALESREPORT_TITLE.add("售卖渠道");
		SALESREPORT_TITLE.add("物流主码");
		SALESREPORT_TITLE.add("wms库存");
		SALESREPORT_TITLE.add("进价");
		SALESREPORT_TITLE.add("售价");
		SALESREPORT_TITLE.add("会员价");
		SALESREPORT_TITLE.add("定金价");
		SALESREPORT_TITLE.add("市场价");
		SALESREPORT_TITLE.add("活动价");
		SALESREPORT_TITLE.add("总销量");
		SALESREPORT_TITLE.add("销售额");
		SALESREPORT_TITLE.add("会员卡支付数量");
		SALESREPORT_TITLE.add("会员卡支付销售额");
		SALESREPORT_TITLE.add("会员价销量");
		SALESREPORT_TITLE.add("会员价销售额");
		SALESREPORT_TITLE.add("毛利额");
		SALESREPORT_TITLE.add("毛利率");
		SALESREPORT_TITLE.add("退货数量");
		SALESREPORT_TITLE.add("退货金额");
		SALESREPORT_TITLE.add("退货率");
		SALESREPORT_TITLE.add("商品投诉率");
		SALESREPORT_TITLE.add("日均销量");
		SALESREPORT_TITLE.add("售卖形态");
		SALESREPORT_TITLE.add("一级分类");
		SALESREPORT_TITLE.add("二级分类");
		SALESREPORT_TITLE.add("三级分类");
		SALESREPORT_TITLE.add("采购经理");
		SALESREPORT_TITLE.add("采购总监");
		SALESREPORT_TITLE.add("发货方式");
		SALESREPORT_TITLE.add("采销方式");
		SALESREPORT_TITLE.add("供应商");
	}
	public static List<String> FINE_COUNT_TITLE = new ArrayList<String>();
	static {
		FINE_COUNT_TITLE.add("供应商名称");
		FINE_COUNT_TITLE.add("累计金额");
		FINE_COUNT_TITLE.add("统计金额");
		FINE_COUNT_TITLE.add("采销经理");
	}
	public static List<String> SUPPLIER_FINE_TITLE = new ArrayList<String>();
	static {
		SUPPLIER_FINE_TITLE.add("罚款金额");
		SUPPLIER_FINE_TITLE.add("业务日期");
		SUPPLIER_FINE_TITLE.add("操作人");
		SUPPLIER_FINE_TITLE.add("罚款原因");
		SUPPLIER_FINE_TITLE.add("订单号");
		SUPPLIER_FINE_TITLE.add("财务状态");
		SUPPLIER_FINE_TITLE.add("财务日期");
		SUPPLIER_FINE_TITLE.add("财务操作人");
		SUPPLIER_FINE_TITLE.add("业务编号");
		SUPPLIER_FINE_TITLE.add("结算单号");
		SUPPLIER_FINE_TITLE.add("问题描述");
	}
	public static List<String> CARRIAGE_COUNT_TITLE = new ArrayList<String>();
	static {
		CARRIAGE_COUNT_TITLE.add("供应商名称");
		CARRIAGE_COUNT_TITLE.add("累计金额");
		CARRIAGE_COUNT_TITLE.add("统计金额");
		CARRIAGE_COUNT_TITLE.add("采销经理");
	}
	public static List<String> CARRIAGE_DETAIL_TITLE = new ArrayList<String>();
	static {
		CARRIAGE_DETAIL_TITLE.add("运费金额");
		CARRIAGE_DETAIL_TITLE.add("发生日期");
		CARRIAGE_DETAIL_TITLE.add("业务操作人");
		CARRIAGE_DETAIL_TITLE.add("退货单号");
		CARRIAGE_DETAIL_TITLE.add("财务状态");
		CARRIAGE_DETAIL_TITLE.add("财务日期");
		CARRIAGE_DETAIL_TITLE.add("财务操作人");
		CARRIAGE_DETAIL_TITLE.add("业务编号");
		CARRIAGE_DETAIL_TITLE.add("结算单号");
		CARRIAGE_DETAIL_TITLE.add("问题描述");
	}

	public static List<String> SECURITY_MONEY_MAIN = new ArrayList<String>();
	static {
		SECURITY_MONEY_MAIN.add("供应商名称");
		SECURITY_MONEY_MAIN.add("累计增加额");
		SECURITY_MONEY_MAIN.add("累计扣减额");
		SECURITY_MONEY_MAIN.add("清算额");
		SECURITY_MONEY_MAIN.add("余额");
		SECURITY_MONEY_MAIN.add("是否清算");
		SECURITY_MONEY_MAIN.add("采销经理");
	}
	public static List<String> SECURITY_MONEY_DETAIL = new ArrayList<String>();
	static {
		SECURITY_MONEY_DETAIL.add("发生金额");
		SECURITY_MONEY_DETAIL.add("发生方向");
		SECURITY_MONEY_DETAIL.add("业务发生日期");
		SECURITY_MONEY_DETAIL.add("业务操作人");
		SECURITY_MONEY_DETAIL.add("财务确认");
		SECURITY_MONEY_DETAIL.add("财务确认日期");
		SECURITY_MONEY_DETAIL.add("财务确认人");
		SECURITY_MONEY_DETAIL.add("保障金来源");
		SECURITY_MONEY_DETAIL.add("业务编号");
		SECURITY_MONEY_DETAIL.add("结算单号");
		SECURITY_MONEY_DETAIL.add("摘要");

	}
	public static List<String> PROCUREMENT_TITLE = new ArrayList<String>();
	static{
		PROCUREMENT_TITLE.add("采购单号");
		PROCUREMENT_TITLE.add("供应商名称");
		PROCUREMENT_TITLE.add("商品名称");
		PROCUREMENT_TITLE.add("物流子码");
		PROCUREMENT_TITLE.add("包装单位");
		PROCUREMENT_TITLE.add("预计收货数量");
		PROCUREMENT_TITLE.add("实际收货数量");
		PROCUREMENT_TITLE.add("入库区域");
		PROCUREMENT_TITLE.add("创建时间");
		PROCUREMENT_TITLE.add("收货完成时间");
		
	}
}
