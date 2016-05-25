package com.qa.ims;

/**
 * Author - Tom
 */
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

import com.qa.ims.model.Address;
import com.qa.ims.model.Category;
import com.qa.ims.model.LineItem;
import com.qa.ims.model.Order;
import com.qa.ims.model.ProdCat;
import com.qa.ims.model.ProdSup;
import com.qa.ims.model.Product;
import com.qa.ims.model.SupplierModel;
import com.qa.ims.model.SupplierOrder;
import com.qa.ims.model.UserModel;
import com.qa.ims.util.OrderStatus;
import com.qa.ims.util.ProductType;

@Singleton
public class InitialData {
	private ArrayList<LineItem> lineItems = new ArrayList<LineItem>();
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<SupplierOrder> supplierOrders = new ArrayList<SupplierOrder>();
	private ArrayList<Product> products = new ArrayList<Product>();
	private ArrayList<ProdCat> prodCats = new ArrayList<ProdCat>();
	private ArrayList<Category> categories = new ArrayList<Category>();
	private ArrayList<Address> addresses = new ArrayList<Address>();
	private ArrayList<ProdSup> prodSups = new ArrayList<ProdSup>();
	private ArrayList<SupplierModel> suppliers = new ArrayList<SupplierModel>();
	private ArrayList<UserModel> users = new ArrayList<UserModel>();

	@PostConstruct
	public void initial(){
		setAddressInitialData();
		setUserInitialData();
		setSupplierInitialData();
		setOrderInitialData();
		setProductInitialData();
		setLineItemsInitialData();
		setSupplierOrderInitialData();
		setCategoriesInitialData();
		setProdCatInitialData();
		setProdSupInitialData();
	}

	/**
	 * 
	 * Created by Omar
	 * 
	 */
	/*
	 * The below is a getMethod that will retrieve the dummy data from the
	 * necessary variables Then it will return those values in the form of an
	 * array
	 */

	private void setSupplierInitialData() {

		// Create a list of names to fill the supplier data
		String[] name = { "GaleTech", "UmbrellerCorp", "Skynet", "V.I.K.I", "Team Rocket" };

		// Create a loop to retrieve data a specific number of times
		for (int i = 0; i < 5; i++) {
			// adds data retrieved from other classes to array
			suppliers.add(new SupplierModel(name[i], getAddresses().get(i)));
		}
	}

	public ArrayList<SupplierModel> getSuppliers() {
		return this.suppliers;
	}

	public void addSupplier(SupplierModel supplier) {
		this.suppliers.add(supplier);
	}

	public void setSupplier(ArrayList<SupplierModel> suppliers) {
		this.suppliers = suppliers;
	}

	/* end of section */

	/**
	 * 
	 * Created by Omar
	 * 
	 */
	/*
	 * The below is a getMethod that will retrieve the dummy data from the
	 * necessary variables Then it will return those values in the form of an
	 * array
	 */

	private void setAddressInitialData() {
		String[] addressLine1 = { "1 abbey lane", "2 north road", "3 south road", "4 east road", "5 west road" };
		String[] addressLine2 = { "ayfter road", "north", "South", "North", "West" };
		String[] addressLine3 = { "Birgmingham", "Leeds", "Southampton", "Norwich", "Aberystwyth" };
		String[] addressLine4 = { "UK", "UK", "UK", "UK", "UK" };
		String[] postCode = { "NX7 4GH", "LE7 4GH", "SO7 4GH", "NX7 4GH", "NX7 4GH" };

		for (int i = 0; i < 5; i++) {
			addresses.add(new Address(addressLine1[i], addressLine2[i], addressLine3[i], addressLine4[i], postCode[i]));
		}
	}

	public ArrayList<Address> getAddresses() {
		return this.addresses;
	}

	public void addAddress(Address address) {
		this.addresses.add(address);
	}

	public void setAddress(ArrayList<Address> addresses) {
		this.addresses = addresses;
	}


	private void setOrderInitialData() {
		double[] price = { 10.10, 20.20, 30.30, 40.40, 50.50 };

		for (int i = 0; i < 5; i++) {
			if(i != 0){
				orders.add(new Order(i, price[i], new Date(), new Date(), null, users.get(i)));
			} else {
				orders.add(new Order(i, price[i], new Date(), null, OrderStatus.PENDING, users.get(i)));
			}
		}
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	// Creates an ArrayList that is populated by dummy data.
	public ArrayList<UserModel> getUsers() {
		return this.users;
	}

	private void setUserInitialData() {
		users.add(new UserModel("Sam", "Chickens1"));
		users.add(new UserModel("Boris", "willpower3"));
		users.add(new UserModel("Will", "Password123"));
		users.add(new UserModel("Tom", "Thisisapassword"));
		users.add(new UserModel("James", "JamesPassword"));
	}

	public void setUsers(ArrayList<UserModel> users) {
		this.users = users;
	}

	public void addUser(UserModel user) {
		this.users.add(user);
	}

	private void setLineItemsInitialData() {

		// Author : willseaford - This method sets an ArrayList of LineItems
		// objects and has a dependency on the order and product object classes
		// being instantiated.

		ArrayList<Order> order = getOrders();
		ArrayList<Product> product = getProducts();

		LineItem lineItem1 = new LineItem(order.get(0), product.get(3), 1, (product.get(3).getPrice()*1), 34);
		order.get(0).setLineItem(setLineItemForOrder(lineItem1));
		LineItem lineItem2 = new LineItem(order.get(1), product.get(1), 2, (product.get(1).getPrice()*2), 67);
		order.get(1).setLineItem(setLineItemForOrder(lineItem2));
		LineItem lineItem3 = new LineItem(order.get(2), product.get(2), 3, (product.get(2).getPrice()*3), 2);
		order.get(2).setLineItem(setLineItemForOrder(lineItem3));
		LineItem lineItem4 = new LineItem(order.get(3), product.get(3), 4, (product.get(3).getPrice()*4), 45);
		order.get(3).setLineItem(setLineItemForOrder(lineItem4));
		LineItem lineItem5 = new LineItem(order.get(4), product.get(4), 5, (product.get(4).getPrice()*5), 235);
		order.get(4).setLineItem(setLineItemForOrder(lineItem5));
	}

	public ArrayList<LineItem> setLineItemForOrder(LineItem lineItem){
		lineItems.add(lineItem);
		ArrayList<LineItem> li = new ArrayList<LineItem>();
		li.add(lineItem);
		return li;
	}

	public void addLineItems(LineItem lineitem) {
		this.lineItems.add(lineitem);
	}

	public ArrayList<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(ArrayList<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	private void setSupplierOrderInitialData() {
		int received[] = { 1, 2, 3, 4, 4 };

		for (int i = 0; i < 5; i++) {
			supplierOrders.add(new SupplierOrder(getProducts().get(i), OrderStatus.AWAITINGDISPATCH,
					getSuppliers().get(i), i, new Date(), received[i]));
		}
	}

	public ArrayList<SupplierOrder> getSupplierOrders() {
		return supplierOrders;
	}

	public void addSupplierOrder(SupplierOrder supplierOrder) {
		supplierOrders.add(supplierOrder);
	}

	public void setSupplierOrders(ArrayList<SupplierOrder> supplierOrders) {
		this.supplierOrders = supplierOrders;
	}

	// Products nabz & Dean
	private void setProductInitialData() {
		products.add(new Product(0, "Happy gnome", "GHTY-YTER-GFDG", "blue", 44.99, false, "HappyGnome", 500,
				ProductType.GNOME, "A traditional garden gnome, a great new addition to your lawn. To be cleaned of with a dam cloth.", 40, 500));

		products.add(new Product(1, "Sunflower Seeds", "SDFF-DFGF-JGGJ", "yellow", 3.99, false, "SunflowerSeeds", 600,
				ProductType.SEED, "Helianthus annuus, Sunflower seeds forms beautiful tall sunflowers which are bright yellow.", 60, 700));

		products.add(new Product(2, "Wheelbarrow", "EWRE-WRFS-SAZC", "red", 20.99, false, "WheelBarrow", 700,
				ProductType.TOOL, "This sturdy and reliable wheelbarrow is ideal for gardening work, with a great capacity.", 70, 400));

		products.add(new Product(3, "Peace Gnome", "GHTY-YTER-GFD2", "blue", 39.99, false, "PeaceGnome", 500,
				ProductType.GNOME, "This garden gnome ideal for garden beds, adds a vibrant feel to your garden.", 40, 500));

		products.add(new Product(4, "Pumpkin Seeds", "SDFF-DFGF-JGG2", "orange", 2.99, false, "PumpkinSeeds", 600,
				ProductType.SEED, "Cucurbita maxima, Pumpkin Seeds form large orange pumpkins, great for decoration at festive times like halloween.", 60, 700));

		products.add(new Product(5, "Lawn Mower", "EWRE-WRFS-SAZ2", "blue", 1072.00, false, "LawnMower", 700,
				ProductType.TOOL, "Top of the range WORX robotic lawn mower, cuts the lawn so you don't have to. Provides multiple height settings for different lawn heights. Intergated with a 36V lithium-ion battery technology.", 70, 400));
		
		products.add(new Product(6, "Sesame Seeds", "SDFF-DFGF-JGG8", "yellow", 4.99, false, "SesameSeeds", 600,
				ProductType.SEED, "Sesame (Sesamum indicum) is a flowering plant in the genus Sesamum. It is widely naturalized in tropical regions around the world and is cultivated for its edible seeds, which grow in pods.", 60, 700));
		
		products.add(new Product(7, "Coriander Seeds", "SDFF-YFGF-JGG8", "yellow", 3.99, false, "CorianderSeeds", 600,
				ProductType.SEED, "Coriander (Coriandrum sativum), is an annual herb in the family Apiaceae. All parts of the plant are edible, but the fresh leaves and the dried seeds are the parts most traditionally used in cooking.", 60, 700));
		
		products.add(new Product(8, "Game of Gnomes", "SYFF-DFGF-JGG8", "yellow", 75.99, false, "GameOfGnomes", 600,
				ProductType.GNOME, "Want to brighten up your garden, with our collectable selection. Now you will know when winter is coming. PS Spoilers not included", 60, 700));
		
		products.add(new Product(9, "Pipe Gnome", "SYFF-HJKO-JGG8", "yellow", 48.99, false, "PipeGnome", 800,
				ProductType.GNOME, "The traditional gentleman gnome, very good for Styling up your garden.", 60, 700));
		
		products.add(new Product(10, "Garden Rake", "KOPO-HJKO-KKP8", "purple", 15.99, false, "Rake", 650,
				ProductType.TOOL, "The traditional garden rake, great for clearing up your garden in the autumn mouths.", 60, 700));
		
		products.add(new Product(11, "Garden Hose", "KOPO-PLKO-KKP8", "yellow", 30.99, false, "Hose", 750,
				ProductType.TOOL, "The ultimate hose, 30m is lightweight and anti-twist robust hose. Perfect for those hot summers", 60, 900));
		
		products.add(new Product(12, "Flash Gnome", "GNOM-EFLA-SHP8", "red", 61.99, false, "FlashGnome", 750,
				ProductType.GNOME, "Do you need someone to save your garden, let your garden be a safer place with this flash gnome our fastest selling product", 60, 900));
		
		products.add(new Product(13, "Super Gnome Collection", "GNOM-ESUP-ERP8", "blue", 171.99, false, "SuperGnome", 750,
				ProductType.GNOME, "Do you more than one hero to save your garden, with our group of 3 super gnomes worry no more.", 60, 900));
		
		products.add(new Product(14, "Rose Seeds", "ROSE-SEED-ERP8", "red", 6.59, false, "RoseSeeds", 750,
				ProductType.SEED, "Grow some of the most beautiful flowers of them all, grows to be lovely shades of pink and red.", 60, 900));
		
		products.add(new Product(15, "Tomatos Seeds", "TOMA-TOSD-ERP8", "red", 2.59, false, "TomatoSeeds", 750,
				ProductType.SEED, "Grow our own tomato, they grow to be big red tomatos for the freshest of salads.", 60, 900));
		
		products.add(new Product(16, "Violet Seeds", "VIOL-ETSE-EDP8", "violet", 3.59, false, "VioletSeeds", 750,
				ProductType.SEED, "Bring a luxury feel to your garden, has large open bloom with yellow stems perfect for garden boarders.", 60, 900));
		
		products.add(new Product(17, "Hedge Trimmer", "TOOL-ETSE-EDP8", "green", 96.99, false, "HedgeTrimmer", 750,
				ProductType.TOOL, "Sculpt your garden to perfection, battery powered hedge trimmer with a two 16V lithum batteries.", 60, 900));
		
		products.add(new Product(18, "Trowel", "TOOL-TROW-ELP8", "green", 4.49, false, "Trowel", 750,
				ProductType.TOOL, "A sturdy garden trowel which is lightwieght and rust proof, great for weeding and a welcome addition to your other garden tools", 60, 900));
		
		
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	private void setProdCatInitialData() {
		for (int i = 0; i < 5; i++) {
			prodCats.add(new ProdCat(getProducts().get(i), getCategories().get(i)));
		}
	}

	public ArrayList<ProdCat> getProdCats() {
		return prodCats;
	}

	public void addProdCat(ProdCat prodCat) {
		prodCats.add(prodCat);
	}

	public void setProdCats(ArrayList<ProdCat> prodCats) {
		this.prodCats = prodCats;
	}
	// Category Nabz & Dean

	private void setCategoriesInitialData() {
		categories.add(new Category(1, "axe wielding"));
		categories.add(new Category(2, "zombie"));
		categories.add(new Category(3, "big and scary"));
		categories.add(new Category(4, "small and scary"));
		categories.add(new Category(5, "big and not scary"));
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

	public void addCategory(Category category) {
		categories.add(category);
	}

	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}

	/**
	 * 
	 * Created by Omar
	 * 
	 */

	private void setProdSupInitialData() {
		double[] cost = { 100.05, 200.40, 400.09, 300.02, 800.32 };

		for (int i = 0; i < 5; i++) {
			prodSups.add(new ProdSup(getSuppliers().get(i), getProducts().get(i), cost[i]));
		}
	}

	public ArrayList<ProdSup> getProdSups() {
		return this.prodSups;
	}

	public void addProdSup(ProdSup prodSup) {
		this.prodSups.add(prodSup);
	}

	public void setProdSups(ArrayList<ProdSup> prodSups) {
		this.prodSups = prodSups;
	}
}
