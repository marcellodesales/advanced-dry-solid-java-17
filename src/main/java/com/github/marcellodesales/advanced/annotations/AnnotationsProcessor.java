package com.github.marcellodesales.advanced.annotations;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class AnnotationsProcessor {

    private static Set<Class> findClassNames(String packageName) {
        var inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(
                packageName.replaceAll("[.]", "/"));
        var bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return bufferedReader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClassName(packageName, line))
                .collect(Collectors.toSet());
    }

    private static Class getClassName(String packageName, String className) {
        try {
            String fullClassName = packageName + "."
                    + className.substring(0, className.lastIndexOf('.'));
            return Class.forName(fullClassName);

        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }

    public static void main(String[] args) {
        // find the name of all classes within this package
        Set<Class> classNames = findClassNames(AnnotationsProcessor.class.getPackageName());

        // convert the classes that have a command annotation to class objects
        List<Class<?>> commandClasses = new ArrayList<>();
        for (var foundClass : classNames) {
            var annotations = Arrays.asList(foundClass.getDeclaredAnnotations());
            if (annotations.size() > 0) {
                System.out.printf("Found annotations: %s", annotations);
            }
            var superAnnotations = annotations.stream()
                    .filter(annotation -> annotation instanceof CommandsByPass)
                    .collect(Collectors.toSet());
            for (var annotation : superAnnotations) {
                var byPass = (CommandsByPass)annotation;
                for (SuperCommand superCommand : byPass.value()) {
                    System.out.printf("Found command %s, order: %d%n", superCommand.value(), superCommand.order());
                    commandClasses.add(foundClass);
                }
            }
        }
        // sort by the order value
        //commandClasses.sort(Comparator.comparingInt(clazz -> clazz.getAnnotation(SuperCommand.class).order()));

        System.out.println(commandClasses);
    }
}
