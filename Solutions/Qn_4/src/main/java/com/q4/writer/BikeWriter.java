package com.q4.writer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.q4.model.Bike;

public class BikeWriter {
	
	public StaxEventItemWriter<Bike> writer(){
	    XStreamMarshaller unMarshaller = new XStreamMarshaller();
	    @SuppressWarnings("rawtypes")
		Map<String, Class> aliases = new HashMap<String, Class>();
	    aliases.put("Bike", Bike.class);
	    unMarshaller.setAliases(aliases);
		
		
		StaxEventItemWriter<Bike> writer = new StaxEventItemWriter<>();
	    writer.setResource(new ClassPathResource("bikes.xml"));
	    writer.setMarshaller(unMarshaller);
	    writer.setRootTagName("Bike");
	    
	    return writer;
	}

}
