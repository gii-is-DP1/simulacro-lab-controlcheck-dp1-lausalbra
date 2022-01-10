package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{
	private final ProductService productService;
	
	@Autowired
	public ProductTypeFormatter(ProductService productService) {
		this.productService = productService;
	}
	
    @Override
    public String print(ProductType object, Locale locale) {
        // TODO Auto-generated method stub
    	 String nombre = object.getName();
    	 return nombre;
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
    	ProductType p = this.productService.getProductType(text);
    	if(p==null) {
    		throw new ParseException("productType not found: "+ text, 0);
    	}else {
    		return p;
    	}
    }
    
}
