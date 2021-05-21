package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
        public static int rn = (int) (Math.random() * ((49 - 1) + 1)) + 1; //random num
        public static int rnd = rn; //rand call
        public static String token1; //name call
        public static URL path = Main.class.getResource("Town.txt"); //txt call
        public static List<String> temps = new ArrayList<String>(); //list to array for name
        public static Scanner inFile1; //scanner
        //make important vars

    public Main() throws FileNotFoundException {

    }
    //make town name
    static {
        try {
            inFile1 = new Scanner(new File(path.getFile())).useDelimiter(",\\s*");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (inFile1.hasNext()) {
            token1 = inFile1.next();
            temps.add(token1);
        }
        inFile1.close();
    }

    public static class GridsCanvas extends Canvas { //code borrowed from http://www.java2s.com/Code/Java/2D-Graphics-GUI/Programtodrawgrids.htm{
        int width, height;

        int rows;

        int cols;

        GridsCanvas(int w, int h, int r, int c) {
            setSize(width = w, height = h);
            rows = r;
            cols = c;
        }
        private static final String BACKHGROUND_IMAGE_URL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTS4Cm3dVaboywa3suvMp1etMpbBIhXtfEX5_RKEH3usNP78oiqpA";
        public void paint(Graphics g) {
            ImageIcon backgroundImage = null;
            try {
                backgroundImage = new ImageIcon(new URL(BACKHGROUND_IMAGE_URL));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            super.paint(g);
            g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            int i;
            width = getSize().width;
            height = getSize().height;

            // draw the rows
            int rowHt = height / (rows);
            for (i = 0; i < rows; i++)
                g.drawLine(0, i * rowHt, width, i * rowHt);
            // draw the columns
            int rowWid = width / (cols);
            for (i = 0; i < cols; i++)
                g.drawLine(i * rowWid, 0, i * rowWid, height);
        }
    }
    public static class Grids extends Frame {//code borrowed from http://www.java2s.com/Code/Java/2D-Graphics-GUI/Programtodrawgrids.htm
        /*
         * Construct a GfxDemo2 given its title, width and height. Uses a
         * GridBagLayout to make the Canvas resize properly.
         */
        String[] tempsArray = temps.toArray(new String[50]);
        String names = tempsArray[rnd];
        Grids(int w, int h, int rows, int cols) {
            setTitle(names);

            // Now create a Canvas and add it to the Frame.
            GridsCanvas xyz = new GridsCanvas(w, h, rows, cols);
            add(xyz);

            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    setVisible(false);
                    dispose();
                    System.exit(0);
                }
            });
            pack();
        }
    }
    public static void main(String[] a) throws IOException {
        String[] tempsArray = temps.toArray(new String[50]);
        String names = tempsArray[rnd];

        Scanner in = new Scanner(System.in);
        int population = (int)(Math.random() * ((25000 - 100) + 1)) + 1; //find population
        int feel = (int)(Math.random() * ((5 - 1) + 1)) + 1; //vibe num
        String vibe = "";
        //find vibe
        if(feel == 1) {
            vibe = "Desperate";
        }
        else if(feel == 2) {
            vibe = "Unfriendly";
        }
        else if(feel == 3) {
            vibe = "Average";
        }
        else if(feel == 4) {
            vibe = "Unique";
        }
        else if(feel == 5) {
            vibe = "Suspiciously welcoming... they're too nice.";
        }
        //print basic town details
        System.out.println(names + "\nPopulation: " + population + "\nVibe: " + vibe); //print vibe
        //print inn details
        if(population <= 250) {
            System.out.println("Inn D/C: 18 \nInn Cost(if found): 5 SP/Night");
            //town details
            if(rnd >= 48) {
                System.out.println("Parade happening getting around is slow, but you don't stick out at all.");
                if (feel == 2) {
                    System.out.print("It is quite violent though... (any small and/or medium sized pc's take 1 damage per 2 actions.)");
                }
            }
            else if (rnd <= 47 && rnd >= 38) {
                System.out.println("Party in town center. Sounds of music come from the town square, as well as a tower of smoke. It looks like a burning of some sort. Probably best to avoid...");
            }
            else {
                System.out.println("Few people out. Those that are are staring.");
            }
            new Grids(250, 250, 25, 25).setVisible(true);
        }
        else if(population <= 1000 && population >= 251) {
            System.out.println("Inn D/C: 15 \nInn Cost(if found): 1 GP/Night");
            //town details
            if(rnd >= 48) {
                System.out.println("Parade happening getting around is slow, but you don't stick out at all.");
                if (feel == 2) {
                    System.out.print("It is quite violent though... (any small and/or medium sized pc's take 1 damage per action.)");
                }
            }
            else if (rnd <= 47 && rnd >= 38) {
                System.out.println("Party in town center. Sounds of music come from the town square, as well as a tower of smoke. It looks like a burning of some sort. Probably best to avoid...");
            }
            else {
                System.out.println("Some people in street. Many staring.");
            }
            new Grids(250, 250, 25, 25).setVisible(true);
        }
        else if(population <= 2500 && population >= 1001) {
            System.out.println("Inn D/C: 15 \nInn Cost(if found): 1 GP/Night");
            //town details
            if(rnd >= 48) {
                System.out.println("Parade happening getting around is slow, but you don't stick out at all.");
                if (feel == 2) {
                    System.out.print("It is quite violent though... (any small and/or medium sized pc's take 1 damage per action.)");
                }
            }
            else if (rnd <= 47 && rnd >= 38) {
                System.out.println("Party in town center. Sounds of music come from the town square, as well as a tower of smoke. It looks like a burning of some sort. Probably best to avoid...");
            }
            else {
                System.out.println("Some people in street. A few staring.");
            }
            new Grids(400, 400, 30, 30).setVisible(true);
        }
        else if(population <= 5000 && population >= 2501) {
            System.out.println("Inn D/C: 15 \nInn Cost(if found): 2 GP/Night");
            //town details
            if(rnd >= 48) {
                System.out.println("Parade happening getting around is slow, but you don't stick out at all.");
                if (feel == 2) {
                    System.out.print("It is quite violent though... (any small and/or medium sized pc's take 2 damage per action.)");
                }
            }
            else if (rnd <= 47 && rnd >= 38) {
                System.out.println("Party in town center. Sounds of music come from the town square, as well as a tower of smoke. It looks like a burning of some sort. Probably best to avoid...");
            }
            else {
                System.out.println("Quite a few people in street. Not very many pay you any mind.");
            }
            new Grids(600, 600, 50, 50).setVisible(true);
        }
        else if(population <= 10000 && population >= 5001) {
            System.out.println("Inn D/C: 12 \nInn Cost(if found): 2 GP/Night/Night");
            //town details
            if(rnd >= 48) {
                System.out.println("Parade happening getting around is slow, but you don't stick out at all.");
                if (feel == 2) {
                    System.out.print("It is quite violent though... (any small and/or medium sized pc's take 2 damage per action.)");
                }
            }
            else if (rnd <= 47 && rnd >= 38) {
                System.out.println("Party in town center. Sounds of music come from the town square, as well as a tower of smoke. It looks like a burning of some sort. Probably best to avoid...");
            }
            else {
                System.out.println("Many people in street. None seem to see you.");
            }
            new Grids(720, 660, 60, 60).setVisible(true);
        }
        else if(population >= 10001) {
            System.out.println("Inn D/C: 10 \nInn Cost(if found): 3 GP/Night");
            //town details
            if(rnd >= 48) {
                System.out.println("Parade happening getting around is slow, but you don't stick out at all.");
                if (feel == 2) {
                    System.out.print("It is quite violent though... (any small and/or medium sized pc's take 2 damage per action.)");
                }
            }
            else if (rnd <= 47 && rnd >= 38) {
                System.out.println("Party in town center. Sounds of music come from the town square, as well as a tower of smoke. It looks like a burning of some sort. Probably best to avoid...");
            }
            else {
                System.out.println("Lots of people in street. No one notices you.");
            }
            new Grids(750, 675, 75, 75).setVisible(true);
        }
        else {
            System.out.println("Error");
        }
    }
}