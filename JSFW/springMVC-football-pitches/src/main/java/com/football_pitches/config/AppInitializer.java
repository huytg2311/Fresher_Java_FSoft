package com.football_pitches.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/*
 * Account: HuyTG8
 * Birthday: 2001/11/23
 * Controller
 * */
/**
 * @author Ramesh Fadatare
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class < ? > [] getRootConfigClasses() {
        return new Class[] {
                PersistenceJPAConfig.class
        };
        //return null;
    }

    @Override
    protected Class < ? > [] getServletConfigClasses() {
        return new Class[] {
                WebMvcConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {
                "/"
        };
    }
}