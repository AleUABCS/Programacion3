package models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ProductModel {

	public ProductModel () {
		
	}
	
	public JSONArray get()
	{
		
		JSONParser jsonParser = new JSONParser();
		String url = AuthModel.class.getResource("/files/productos.json").getPath();
        
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
	

}

