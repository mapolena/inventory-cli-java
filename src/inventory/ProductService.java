package inventory;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
	private List<Product> products = new ArrayList<>();	//商品リストを作成

	//商品リストに商品を追加
	public void addProduct(Product product) {
		products.add(product);
	}

	//SKUから商品を探す
	public Product findBySku(String sku) {
		for(Product p : products) {
			if(sku.equals(p.getSku())) {
				return p;
			}
		}
		return null;
	}

	//商品リストのゲッター
	public List<Product> getAllProducts(){
		return products;
	}


	public void removeProduct(String sku) {
		Product product = findBySku(sku);
		if(product != null) {
			products.remove(product);
		}

		//products.removeIf(p -> sku.equals(p.getSku()));	//ラムダ式
	}


}
