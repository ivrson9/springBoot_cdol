package com.cdol.template.util;

import java.util.List;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.cdol.template.contents.dto.ContentsVO;
import com.cdol.template.contents.service.ContentsService;
import com.cdol.template.menu.dto.MenuVO;
import com.cdol.template.menu.service.MenuService;

@Configuration
public class ConfigurationForTiles {
	
	@Autowired
	ContentsService contentsService;
	
	@Autowired
	MenuService menuService;

	@Bean
	public TilesConfigurer tilesConfigurer() {
		final TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] { "WEB-INF/config/tiles-config.xml" });
		configurer.setCheckRefresh(true);
		
		// Provide Spring Beans as view preparers
        configurer.setPreparerFactoryClass(SpringBeanPreparerFactory.class);
        
		return configurer;
	}

	@Bean
	public TilesViewResolver tilesViewResolver() {
		final TilesViewResolver resolver = new TilesViewResolver();
		resolver.setViewClass(TilesView.class);
		return resolver;
	}
	
	
	@Bean
    public MenuPreparer menuPreparer() {
        return new MenuPreparer();
    }
	
	/**
     * A View Preparer that queries the spring security context. If it finds an authenticated user object
     * then it makes it available as a cascading attribute that can be accessed in a view thus:
     * 
     * <tiles:getAsString name="user" />
     * 
     * @author Mark Meany
     */
    protected class MenuPreparer implements ViewPreparer {

    	@Override
    	public void execute(Request context, AttributeContext attributeContext) throws PreparerException {
    		List<ContentsVO> contents = null;
    		List<MenuVO> menu = null;
    		try {
    			contents = contentsService.getContents();
    			menu = menuService.getMenu();
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		attributeContext.putAttribute("contents", new Attribute(contents), true);
    		attributeContext.putAttribute("menu", new Attribute(menu), true);
    		
    	}
    }
}