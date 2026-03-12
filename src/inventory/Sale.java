package inventory;

import java.time.LocalDate;

public class Sale {
	private LocalDate saleDate;	//販売日
	private int salePrice;		//販売価格
	private int fee;			//販売手数料+送料
	private String platform;	//販売したプラットフォーム

	//コンストラクタ
	public Sale(LocalDate saleDate, int salePrice, int fee, String platform) {
		this.saleDate = saleDate;
		this.salePrice = salePrice;
		this.fee = fee;
		this.platform = platform;
	}

	//salePriceのゲッター
	public int getSalePrice() {
		return salePrice;
	}

	//feeのゲッター
	public int getFee() {
		return fee;
	}

}
