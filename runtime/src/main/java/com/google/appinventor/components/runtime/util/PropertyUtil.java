// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0
package com.google.appinventor.components.runtime.util;

import com.google.appinventor.components.runtime.Component;

import java.lang.reflect.Method;

/**
 * Utilities for copying properties between different instances of the same component.
 *
 * @author markf@google.com (Mark Friedman)
 */
public class PropertyUtil {

    /**
     * Copy properties from one component to another of the same class.
     *
     * @param source the source component
     * @param target the target component
     * @return the target component (for convenience in chaining)
     * @throws Throwable
     */
    public static Component copyComponentProperties(Component source, Component target)
            throws Throwable {
        if (!source.getClass().equals(target.getClass())) {
            throw new IllegalArgumentException("Source and target classes must be identical");
        }

        final Class componentClass = source.getClass();
        final Method[] componentMethods = componentClass.getMethods();
        for (Method componentMethod : componentMethods) {
            // A SimpleProperty which takes a single argument is a property setter.
//      if (componentMethod.isAnnotationPresent(SimpleProperty.class)
//          && componentMethod.getParameterTypes().length == 1) {
//        final Method propertySetterMethod = componentMethod;
//        try {
//          final String propertyName = propertySetterMethod.getName();
//
//          // Look for a property copier method.
//          final Method propertyCopierMethod =
//              getPropertyCopierMethod("Copy" + propertyName, componentClass);
//          if (propertyCopierMethod != null) {
//            propertyCopierMethod.invoke(target, source);
//            continue; // Don't return here because we still need to copy more properties.
//          }
//          // It's fine if there's no copy method.  We'll look for a getter.
//
//          // The getter will have the same name as the setter
//          final Method propertyGetterMethod = componentClass.getMethod(propertyName);
//          final Class propertySetterParameterType = propertySetterMethod.getParameterTypes()[0];
//          // The getter also needs to be a SimpleProperty and its return type needs to be
//          // compatible with the setter's single argument type
//          if (propertyGetterMethod.isAnnotationPresent(SimpleProperty.class) &&
//              propertySetterParameterType.isAssignableFrom(propertyGetterMethod.getReturnType())) {
//            final Object propertyValue = propertyGetterMethod.invoke(source);
//            propertySetterMethod.invoke(target, propertyValue);
//          }
//        } catch (NoSuchMethodException e) {
//          // It's fine if there's no getter method.  We just won't invoke the setter.
//          continue;
//        } catch (InvocationTargetException e2) {
//          // This re-throws any Exceptions generated by the property getters or setters themselves.
//          throw e2.getCause();
//        }
//      }
        }
        return target;
    }

    private static Method getPropertyCopierMethod(String copierMethodName, Class componentClass) {
        // If the copier method is declared in a superclass of componentClass, the parameter
        // would be the superclass also.
        // For example, componentClass might be Button. But the CopyWidth method is declared in
        // AndroidViewComponent and the paremeter is also AndroidViewComponent.
        // So, we may need to look up the superclass chain to
//    do {
//      try {
//        Method propertyCopierMethod = componentClass.getMethod(copierMethodName, componentClass);
//        if (propertyCopierMethod.isAnnotationPresent(SimplePropertyCopier.class)) {
//          return propertyCopierMethod;
//        }
//      } catch (NoSuchMethodException e) {
//        // It's fine if there's no copier method.  We'll try the superclass.
//      }
//      componentClass = componentClass.getSuperclass();
//    } while (componentClass != null);

        // It's fine if we didn't find a copier method. Just return null;
        return null;
    }
}
