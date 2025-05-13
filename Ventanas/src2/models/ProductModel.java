package models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ProductModel {

	String url = "src2/files/productos.json";

	public ProductModel () {
		
	}
	
	public JSONArray get()
	{
		
		JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(url))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray productList = (JSONArray) obj;
              
            return productList;
           
            //Iterate over  array
           // productList.forEach( emp -> parseTestData( (JSONObject) emp ) );
  
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } catch (IOException e) 
        {
            e.printStackTrace();
        } catch (ParseException e) 
        {
            e.printStackTrace();
        }
        
        return null;
	}
	
	public ArrayList<Object> toObjectArrayList(JSONObject product)
    {
		// Regresar los valores como ArrayList
		
		String name = (String) product.get("Nombre");   
		long id = (long) product.get("ID");   
	    long stock = (long) product.get("Stock"); 
	    double price = (double) product.get("Precio"); 
	    
	    ArrayList<Object> array = new ArrayList<>(); 
	    array.add(name);
	    array.add(id);
	    array.add(stock);
	    array.add(price);
	    
	    return array;
    }
	
	public ArrayList<Object> toObjectArrayListIndex (int index) {
		JSONObject productoSeleccionado = (JSONObject)get().get(index);
		ArrayList<Object> array = toObjectArrayList(productoSeleccionado);
		return array;
	}
	
	public void addProduct(String name, long id, long stock, double price) {
		JSONObject newProduct = new JSONObject();
		newProduct.put("Nombre", name);
		newProduct.put("ID", id);
		newProduct.put("Stock", stock);
		newProduct.put("Precio", price);
		
		JSONArray productList = get();
		productList.add(newProduct);
		String url = "src2/files/productos.json";

		try (FileWriter write = new FileWriter(url)) {
			String newProductString = ""+productList;
			write.write(newProductString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteProductId (int index) {
		System.out.println("id: " + index);
		JSONArray productList = get();
		
		productList.remove(index);
		
		try (FileWriter write = new FileWriter(url)) {
			String newProductString = ""+productList;
			write.write(newProductString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

