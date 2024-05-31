package co.edu.unbosque.dresscode;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.json.simple.parser.ParseException;

@ManagedBean
public class DressCodeBean {
	private List<Customer> list_customers = listaCus();
	private List<Supplier> list_suppliers = listaSup();
	private List<Product> list_products = listaProd();
	private List<SaleDetail> list_sale_detail = listaSaleDet();
	private List<SaleDetail> list_sale_detail2 = listaSaleDet2();
	private List<Amortization> list_amor = listaAmor();
	private List<Sale> list_vent = listaSale();
	private List<Check> list_check = listaCheck();
	private List<PurchaseDetail> list_purchase_detail = listaPurchaseDet();
	
	private List<PurchaseDetail> listaPurchaseDet() {
        try {
            return Listas.crearListaCarroCompras();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
	
	public List<Check> listaCheck() {
		try {
			return Listas.crearListaCheques();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Sale> listaSale() {
		try {
			return Listas.crearListaVentas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Amortization> listaAmor() {
		try {
			return Listas.crearListaAmortizacion();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Customer> listaCus() {
		try {
			return Listas.crearListaCustomers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Supplier> listaSup() {
		try {
			return Listas.crearListaSuppliers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Product> listaProd() {
		try {
			return Listas.crearListaProducts();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<SaleDetail> listaSaleDet2() {
		try {
			return Listas.crearListaVentasDetalles();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<SaleDetail> listaSaleDet() {
		try {
			return Listas.crearListaCarroVentas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Amortization> getList_amor() {
		return list_amor;
	}

	public void setList_amor(List<Amortization> list_amor) {
		this.list_amor = list_amor;
	}

	public List<Customer> getList_customers() {
		return list_customers;
	}

	public void setList_customers(List<Customer> list_customers) {
		this.list_customers = list_customers;
	}

	public List<Supplier> getList_suppliers() {
		return list_suppliers;
	}

	public void setList_suppliers(List<Supplier> list_suppliers) {
		this.list_suppliers = list_suppliers;
	}

	public List<Product> getList_products() {
		return list_products;
	}

	public void setList_products(List<Product> list_products) {
		this.list_products = list_products;
	}

	public List<SaleDetail> getList_sale_detail() {
		return list_sale_detail;
	}

	public void setList_sale_detail(List<SaleDetail> list_sale_detail) {
		this.list_sale_detail = list_sale_detail;
	}

	public List<Sale> getList_vent() {
		return list_vent;
	}

	public void setList_vent(List<Sale> list_vent) {
		this.list_vent = list_vent;
	}

	public List<SaleDetail> getList_sale_detail2() {
		return list_sale_detail2;
	}

	public void setList_sale_detail2(List<SaleDetail> list_sale_detail2) {
		this.list_sale_detail2 = list_sale_detail2;
	}

	public List<Check> getList_check() {
		return list_check;
	}

	public void setList_check(List<Check> list_check) {
		this.list_check = list_check;
	}

	public List<PurchaseDetail> getList_purchase_detail() {
		return list_purchase_detail;
	}

	public void setList_purchase_detail(List<PurchaseDetail> list_purchase_detail) {
		this.list_purchase_detail = list_purchase_detail;
	}

}
