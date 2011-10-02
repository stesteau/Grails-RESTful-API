package com.moskiteau.converters.marshaller

import grails.converters.XML;
import groovy.lang.GroovyObject;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import groovy.time.*
import org.codehaus.groovy.grails.web.converters.exceptions.ConverterException;
import org.codehaus.groovy.grails.web.converters.marshaller.*;
import org.springframework.beans.BeanUtils;

class CustomObjectMarshaller implements ObjectMarshaller {

    public boolean supports(Object object) {
        if(object instanceof java.util.ArrayList) {
            return false
        } else if(object instanceof Collection) {
            return false
        } else if(object instanceof Date) {
            return false
        }
        return true
    }

    public void marshalObject(java.lang.Object object, org.codehaus.groovy.grails.web.converters.Converter converter) {
        try {
            for (PropertyDescriptor property : BeanUtils.getPropertyDescriptors(object.getClass())) {
                String name = property.getName();
                Method readMethod = property.getReadMethod();
                if (readMethod != null && !(name.equals("metaClass"))
                    && (!name.equals("class")) && (name != "version") 
                    && (name != 'errors') && (object."${name}" != null)) {
                    converter.startNode(name);
                    converter.convertAnother(object."${name}");
                    converter.end();
                }
            }
        }
        catch (ConverterException ce) {
            throw ce;
        }
        catch (Exception e) {
            throw new ConverterException("Error converting Bean with class " + object.getClass().getName(), e);
        }
    }

}



