package inventory;

public class Product {
	private String sku;			//SKU
	private String brandName;	//ブランド名
	private String category;	//商品カテゴリ

	private Purchase purchase;	//仕入れ価格
	private Sale sale;			//販売価格

	//コンストラクタ
	public Product(String sku, String brandName, String category, Purchase purchase) {
		this.sku = sku;
		this.brandName = brandName;
		this.category = category;
		this.purchase = purchase;
	}

	//
	public boolean isSold() {
		return sale != null;
	}

	//粗利益の計算
	public int getGrossProfit() {
		if(sale == null) return 0;
		return sale.getSalePrice() - purchase.getPurchasePrice() - sale.getFee();
	}

	//売れた価格の設定
	public void sell(Sale sale) {
		if(this.sale != null) {
			throw new IllegalStateException("すでに売却済みです");
		}
		this.sale = sale;
	}

	public String getSku() {
		return this.sku;
	}

	public String getBrandName() {
		return this.brandName;
	}

 }
