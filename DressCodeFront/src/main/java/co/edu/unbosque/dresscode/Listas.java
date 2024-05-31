package co.edu.unbosque.dresscode;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Listas {
	private static URL url;
	private static String sitio = "http://localhost:8081/";

	//CUSTOMERS
	public static ArrayList<Customer> crearListaCustomers() throws IOException, ParseException{
		url = new URL(sitio+"customers");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<Customer> lista = new ArrayList<Customer>();
		lista = parsingCustomers(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Customer> parsingCustomers(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Customer> lista = new ArrayList<Customer>();
        JSONArray usuarios = (JSONArray) jsonParser.parse(json);
        Iterator i = usuarios.iterator();
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            Customer usuario = new Customer();
            usuario.setId_customer(Integer.parseInt(innerObj.get("id_customer").toString()));
            usuario.setDocument(innerObj.get("document").toString());
            usuario.setName(innerObj.get("name").toString());
            usuario.setAddress(innerObj.get("address").toString());
            usuario.setPhone_number(innerObj.get("phone_number").toString());
            usuario.setEmail(innerObj.get("email").toString());
            lista.add(usuario);
        }
        return lista;
	}
	
	//SUPPLIERS
	public static ArrayList<Supplier> crearListaSuppliers() throws IOException, ParseException{
		url = new URL(sitio+"suppliers");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<Supplier> lista = new ArrayList<Supplier>();
		lista = parsingSuppliers(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Supplier> parsingSuppliers(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Supplier> lista = new ArrayList<Supplier>();
        JSONArray usuarios = (JSONArray) jsonParser.parse(json);
        Iterator i = usuarios.iterator();
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            Supplier prov = new Supplier();
            prov.setId_supplier(Integer.parseInt(innerObj.get("id_supplier").toString()));
            prov.setNit(innerObj.get("nit").toString());
            prov.setName(innerObj.get("name").toString());
            prov.setAddress(innerObj.get("address").toString());
            prov.setPhone_number(innerObj.get("phone_number").toString());
            prov.setCity(innerObj.get("city").toString());
            lista.add(prov);
        }
        return lista;
	}
	
	//PRODUCTS
	public static ArrayList<Product> crearListaProducts() throws IOException, ParseException{
		url = new URL(sitio+"products");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<Product> lista = new ArrayList<Product>();
		lista = parsingProducts(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Product> parsingProducts(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Product> lista = new ArrayList<Product>();
        JSONArray usuarios = (JSONArray) jsonParser.parse(json);
        Iterator i = usuarios.iterator();
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            Product prod = new Product();
            prod.setId_product(Integer.parseInt(innerObj.get("id_product").toString()));
            prod.setNit_supplier(innerObj.get("nit_supplier").toString());
            prod.setName(innerObj.get("name").toString());
            prod.setPurchase_price(Float.parseFloat(innerObj.get("purchase_price").toString()));
            prod.setSales_price(Float.parseFloat(innerObj.get("sales_price").toString()));
            lista.add(prod);
        }
        return lista;
	}
	
	//SALESDETAIL
	public static ArrayList<SaleDetail> crearListaCarroVentas() throws IOException, ParseException{
		url = new URL(sitio+"saledetail");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<SaleDetail> lista = new ArrayList<SaleDetail>();
		lista = parsingSaleDetail(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<SaleDetail> parsingSaleDetail(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<SaleDetail> lista = new ArrayList<SaleDetail>();
        JSONArray usuarios = (JSONArray) jsonParser.parse(json);
        Iterator i = usuarios.iterator();
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            SaleDetail prod = new SaleDetail();
            prod.setId_sale_detail(Integer.parseInt(innerObj.get("id_sale_detail").toString()));
            prod.setCustomer_doc(innerObj.get("customer_doc").toString());
            prod.setId_product(Integer.parseInt(innerObj.get("id_product").toString()));
            prod.setId_sale(Integer.parseInt(innerObj.get("id_sale").toString()));
            prod.setQuantity(Integer.parseInt(innerObj.get("quantity").toString()));
            prod.setUnit_value(Float.parseFloat(innerObj.get("unit_value").toString()));
            prod.setTotal_value(Float.parseFloat(innerObj.get("total_value").toString()));
            lista.add(prod);
        }
        return lista;
	}
	
	//SALESDETAIL
		public static ArrayList<SaleDetail> crearListaVentasDetalles() throws IOException, ParseException{
			url = new URL(sitio+"saledetail/all");
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Accept", "application/json");
			InputStream respuesta = http.getInputStream();
			byte[] inp = respuesta.readAllBytes();
			String json = "";
			for (int i = 0; i<inp.length ; i++) {
				json += (char)inp[i];
			}
			ArrayList<SaleDetail> lista = new ArrayList<SaleDetail>();
			lista = parsingSaleDetails(json);
			http.disconnect();
			return lista;
		}
		
		public static ArrayList<SaleDetail> parsingSaleDetails(String json) throws ParseException {
	        JSONParser jsonParser = new JSONParser();
	        ArrayList<SaleDetail> lista = new ArrayList<SaleDetail>();
	        JSONArray usuarios = (JSONArray) jsonParser.parse(json);
	        Iterator i = usuarios.iterator();
	        while (i.hasNext()) {
	            JSONObject innerObj = (JSONObject) i.next();
	            SaleDetail prod = new SaleDetail();
	            prod.setId_sale_detail(Integer.parseInt(innerObj.get("id_sale_detail").toString()));
	            prod.setCustomer_doc(innerObj.get("customer_doc").toString());
	            prod.setId_product(Integer.parseInt(innerObj.get("id_product").toString()));
	            prod.setId_sale(Integer.parseInt(innerObj.get("id_sale").toString()));
	            prod.setQuantity(Integer.parseInt(innerObj.get("quantity").toString()));
	            prod.setUnit_value(Float.parseFloat(innerObj.get("unit_value").toString()));
	            prod.setTotal_value(Float.parseFloat(innerObj.get("total_value").toString()));
	            lista.add(prod);
	        }
	        return lista;
		}
	
	//AMORTIZATION
	public static ArrayList<Amortization> crearListaAmortizacion() throws IOException, ParseException{
		url = new URL(sitio+"amortization");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<Amortization> lista = new ArrayList<Amortization>();
		lista = parsingAmortizacion(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Amortization> parsingAmortizacion(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Amortization> lista = new ArrayList<Amortization>();
        JSONArray usuarios = (JSONArray) jsonParser.parse(json);
        Iterator i = usuarios.iterator();
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            Amortization amor = new Amortization();
            amor.setId_amortization(Integer.parseInt(innerObj.get("id_amortization").toString()));
            amor.setId_credit(Integer.parseInt(innerObj.get("id_credit").toString()));
            amor.setQuota_number(Integer.parseInt(innerObj.get("quota_number").toString()));
            amor.setBalance(Float.parseFloat(innerObj.get("balance").toString()));
            amor.setQuota_value(Float.parseFloat(innerObj.get("quota_value").toString()));
            amor.setInterest(Float.parseFloat(innerObj.get("interest").toString()));
            amor.setAmortization(Float.parseFloat(innerObj.get("amortization").toString()));
            lista.add(amor);
        }
        return lista;
	}
	
	//Sale
	public static ArrayList<Sale> crearListaVentas() throws IOException, ParseException{
		url = new URL(sitio+"sale");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<Sale> lista = new ArrayList<Sale>();
		lista = parsingVentas(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Sale> parsingVentas(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Sale> lista = new ArrayList<Sale>();
        JSONArray usuarios = (JSONArray) jsonParser.parse(json);
        Iterator i = usuarios.iterator();
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            Sale sale = new Sale();
            sale.setId_sale(Integer.parseInt(innerObj.get("id_sale").toString()));
            sale.setCustomer_document(innerObj.get("customer_document").toString());
            sale.setTotal(Float.parseFloat(innerObj.get("total").toString()));
            sale.setIva(Float.parseFloat(innerObj.get("iva").toString()));
            sale.setTotal_iva(Float.parseFloat(innerObj.get("total_iva").toString()));
            lista.add(sale);
        }
        return lista;
	}
	
	//CHeQUE
		public static ArrayList<Check> crearListaCheques() throws IOException, ParseException{
			url = new URL(sitio+"checktable");
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Accept", "application/json");
			InputStream respuesta = http.getInputStream();
			byte[] inp = respuesta.readAllBytes();
			String json = "";
			for (int i = 0; i<inp.length ; i++) {
				json += (char)inp[i];
			}
			ArrayList<Check> lista = new ArrayList<Check>();
			lista = parsingCheques(json);
			http.disconnect();
			return lista;
		}
		
		public static ArrayList<Check> parsingCheques(String json) throws ParseException {
	        JSONParser jsonParser = new JSONParser();
	        ArrayList<Check> lista = new ArrayList<Check>();
	        JSONArray usuarios = (JSONArray) jsonParser.parse(json);
	        Iterator i = usuarios.iterator();
	        while (i.hasNext()) {
	            JSONObject innerObj = (JSONObject) i.next();
	            Check ch = new Check();
	            ch.setId_check(Integer.parseInt(innerObj.get("id_chech").toString()));
	            ch.setId_purchase(Integer.parseInt(innerObj.get("id_purchase").toString()));
	            ch.setNit_supplier(innerObj.get("nit_supplier").toString());
	            ch.setTotal(Float.parseFloat(innerObj.get("total").toString()));
	            lista.add(ch);
	        }
	        return lista;
		}
		
		//PURCHASEDETAIL
	    public static ArrayList<PurchaseDetail> crearListaCarroCompras() throws IOException, ParseException{
	        url = new URL(sitio+"purchasedetail");
	        HttpURLConnection http = (HttpURLConnection)url.openConnection();
	        http.setRequestMethod("GET");
	        http.setRequestProperty("Accept", "application/json");
	        InputStream respuesta = http.getInputStream();
	        byte[] inp = respuesta.readAllBytes();
	        String json = "";
	        for (int i = 0; i<inp.length ; i++) {
	            json += (char)inp[i];
	        }
	        ArrayList<PurchaseDetail> lista = new ArrayList<PurchaseDetail>();
	        lista = parsingPurchaseDetail(json);
	        http.disconnect();
	        return lista;
	    }

	    public static ArrayList<PurchaseDetail> parsingPurchaseDetail(String json) throws ParseException {
	        JSONParser jsonParser = new JSONParser();
	        ArrayList<PurchaseDetail> lista = new ArrayList<PurchaseDetail>();
	        JSONArray usuarios = (JSONArray) jsonParser.parse(json);
	        Iterator i = usuarios.iterator();
	        while (i.hasNext()) {
	            JSONObject innerObj = (JSONObject) i.next();
	            PurchaseDetail prod = new PurchaseDetail();
	            prod.setId_purchase_detail(Integer.parseInt(innerObj.get("id_purchase_detail").toString()));
	            prod.setId_product(Integer.parseInt(innerObj.get("id_product").toString()));
	            prod.setId_purchase(Integer.parseInt(innerObj.get("id_purchase").toString()));
	            prod.setQuantity(Integer.parseInt(innerObj.get("quantity").toString()));
	            prod.setTotal_value(Float.parseFloat(innerObj.get("total_value").toString()));
	            lista.add(prod);
	        }
	        return lista;
	    }
}
