package com.seedbank.common.utils;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

public class AppiumServerUtils {
      public static void startServer() {
            CommandLine cmd = new CommandLine("C:\\Program Files\\nodejs\\node.exe");
            cmd.addArgument("C:\\Users\\20723\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js");
            cmd.addArgument("--address");
            cmd.addArgument("127.0.0.1");
            cmd.addArgument("--port");
            cmd.addArgument("4723");
           cmd.addArgument("--no-reset");
            
            DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
            DefaultExecutor executor = new DefaultExecutor();
            executor.setExitValue(1);
            try {
                  executor.execute(cmd, handler);
                  Thread.sleep(10000);
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }
      
      public static void stopServer() {
            Runtime runtime = Runtime.getRuntime();
            try {
                  runtime.exec("taskkill /F /IM node.exe");
            } catch (IOException e) {
                  e.printStackTrace();
            }
      }
      
      
      public static void main(String[] args) {
    	//  AppiumServerUtils appiumServer = new AppiumServerUtils();
            AppiumServerUtils.startServer();

           // appiumServer.stopServer();
      }
}

