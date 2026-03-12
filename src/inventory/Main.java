package inventory;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Purchase purchase = new Purchase(LocalDate.of(2026, 3, 1),"仕入れ先A",3000);

		Product product = new Product("SKU001", "COMME des GARCONS", "Jacket", purchase);

		Sale sale = new Sale(LocalDate.of(2026, 3, 2), 8000, 800, "Mercari");

		product.sell(sale);
		//	product.sell(sale);	//防御ロジック確認

		System.out.println(product.getGrossProfit());

		ProductService service = new ProductService();
		service.addProduct(product);

		Scanner scanner = new Scanner(System.in);	//コンソール入力

		//メニュー入力
		while(true) {
			System.out.println("1:商品追加 2:一覧 3:削除 4:販売　5:終了");

			int choice = scanner.nextInt();

			switch(choice) {
				case 1:
					addProductMenu(scanner, service);
					break;

				case 2:
					printInventory(service.getAllProducts());
					break;

				case 3:
					removeProductMenu(scanner, service);
					break;

				case 4:
					sellProduct(scanner, service);
					break;

				case 5:
					System.out.println("終了します");
					return;
			}
		}
	}

	public static void addProductMenu(Scanner scanner, ProductService service) {
		scanner.nextLine();	//改行を消す（重要）

		System.out.println("SKU");
		String sku = scanner.nextLine();

		System.out.println("ブランド");
		String brand = scanner.nextLine();

		System.out.println("カテゴリ");
		String category = scanner.nextLine();

		System.out.println("仕入価格");
		int price = scanner.nextInt();

		Purchase newPurchase = new Purchase(LocalDate.now(), "仕入先", price);

		Product newProduct = new Product(sku, brand, category, newPurchase);

		service.addProduct(newProduct);

		System.out.println("追加しました");
	}

	public static void removeProductMenu(Scanner scanner, ProductService service) {
		scanner.nextLine();

		System.out.println("削除するSKUを入力してください");
		String sku = scanner.nextLine();

		service.removeProduct(sku);

		System.out.println("削除しました");
	}

	public static void sellProduct(Scanner scanner, ProductService service) {
		scanner.nextLine();

		System.out.println("販売するSKUを入力してください");
		String sku = scanner.nextLine();

		Product foundProduct= service.findBySku(sku);

		if(foundProduct == null) {
			System.out.println("商品が見つかりません");
			return;	//メソッドを終了する（mainのwhileループに戻る）（エラーのため、continue;から変更した）
		}

		System.out.println("販売価格を入力してください");
		int price = scanner.nextInt();

		System.out.println("手数料を入力してください");
		int fee = scanner.nextInt();

		scanner.nextLine();

		System.out.println("販売プラットフォームを入力してください");
		String platform = scanner.nextLine();

		Sale productSale = new Sale(LocalDate.now(), price, fee, platform);

		foundProduct.sell(productSale);

		System.out.println("販売登録しました");
	}

	public static void printInventory(List<Product> products) {
		for(Product p : products) {
			System.out.println(p.getSku() + " " + p.getBrandName() + " " + (p.isSold() ? "売却済" : "在庫あり"));
		}
	}



}
