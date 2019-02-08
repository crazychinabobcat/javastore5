package cn.itcase.lynx.daomain;

import java.util.Date;

public class Product {

	private String pid; // 商品编号
	private String pname; // 商品名称
	private double market_price; // 商品市场价格
	private double shop_price; // 商品商场价格
	private String pimage; // 商城图片路径
	private Date padte; // 商品上架日期
	private int is_hot; // 商品是否热门
	private String pdesc; // 商品描述
	private int pflag; // 商品是否在货架上
	private String cid; // 商品分类id

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String pid, String pname, double market_price, double shop_price, String pimage, Date padte,
			int is_hot, String pdesc, int pflag, String cid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.market_price = market_price;
		this.shop_price = shop_price;
		this.pimage = pimage;
		this.padte = padte;
		this.is_hot = is_hot;
		this.pdesc = pdesc;
		this.pflag = pflag;
		this.cid = cid;
	}

	/**
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * @return the market_price
	 */
	public double getMarket_price() {
		return market_price;
	}

	/**
	 * @param market_price the market_price to set
	 */
	public void setMarket_price(double market_price) {
		this.market_price = market_price;
	}

	/**
	 * @return the shop_price
	 */
	public double getShop_price() {
		return shop_price;
	}

	/**
	 * @param shop_price the shop_price to set
	 */
	public void setShop_price(double shop_price) {
		this.shop_price = shop_price;
	}

	/**
	 * @return the pimage
	 */
	public String getPimage() {
		return pimage;
	}

	/**
	 * @param pimage the pimage to set
	 */
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	/**
	 * @return the padte
	 */
	public Date getPadte() {
		return padte;
	}

	/**
	 * @param padte the padte to set
	 */
	public void setPadte(Date padte) {
		this.padte = padte;
	}

	/**
	 * @return the is_hot
	 */
	public int getIs_hot() {
		return is_hot;
	}

	/**
	 * @param is_hot the is_hot to set
	 */
	public void setIs_hot(int is_hot) {
		this.is_hot = is_hot;
	}

	/**
	 * @return the pdesc
	 */
	public String getPdesc() {
		return pdesc;
	}

	/**
	 * @param pdesc the pdesc to set
	 */
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	/**
	 * @return the pflag
	 */
	public int getPflag() {
		return pflag;
	}

	/**
	 * @param pflag the pflag to set
	 */
	public void setPflag(int pflag) {
		this.pflag = pflag;
	}

	/**
	 * @return the cid
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", market_price=" + market_price + ", shop_price="
				+ shop_price + ", pimage=" + pimage + ", padte=" + padte + ", is_hot=" + is_hot + ", pdesc=" + pdesc
				+ ", pflag=" + pflag + ", cid=" + cid + "]";
	}

}
