package inventory;

import java.time.LocalDate;

public class Purchase {
	private LocalDate purchaseDate;	//仕入れ日
	private String supplier;		//仕入れ先
	private int purchasePrice;		//仕入れ価格

	//コンストラクタ
	public Purchase(LocalDate purchaseDate, String supplier, int purchasePrice) {
		this.purchaseDate = purchaseDate;
		this.supplier = supplier;
		this.purchasePrice = purchasePrice;
	}

	//purchasePriceのゲッター
	public int getPurchasePrice() {
		return purchasePrice;
	}

}
