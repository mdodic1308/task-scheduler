package com.example.schedulerapp.executor;

import groovy.lang.GroovyShell;

public class ExecutorThread implements Runnable {

    private final String script;

    public ExecutorThread(String script) {
        this.script = script;
    }

    @Override
    public void run() {
        GroovyShell groovyShell = new GroovyShell();
        System.out.println("Script: " + script);
        groovyShell.evaluate(script);
    }
}
