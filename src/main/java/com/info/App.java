package com.info;

import java.io.IOException;

import com.info.controller.MainMenuController;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        MainMenuController menu = new MainMenuController();

        menu.main();
    }
}
