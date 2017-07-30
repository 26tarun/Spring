package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@SpringBootApplication
public class Application extends SpringBootServletInitializer{
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		 
	        return application.sources(Application.class);
	    }
    public static void main(String[] args) {
//    	AnnotationConfigWebApplicationContext ctx= new AnnotationConfigWebApplicationContext();;
//    	try{
//    	ctx.register(SpringJDBCConfig.class);
//    	ctx.refresh();
    	SpringApplication.run(Application.class, args);
//    	}
    	
//    	finally{
//    		ctx.close();
//    	}
        
    }

}
