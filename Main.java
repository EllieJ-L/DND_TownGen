package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
        public void paint(Graphics g) {
            ImageIcon backgroundImage = null;
            backgroundImage = new ImageIcon(images.jpg);
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
        System.out.print("\n‎\n‎\n‎\n‎\n‎\n‎\n‎\n‎" + names + "\nPopulation: " + population + "\nVibe: " + vibe);
        //print inn details
        if(population <= 250) {
            System.out.print("\nInn D/C: 18 \nInn Cost(if found): 6 SP/Night");
            //town details
            if(rnd >= 48) {
                System.out.print("\nParade happening getting around is slow, and the shops are mostly closed.");
                if (feel == 2) {
                    System.out.print("It is quite violent though... Probably some sort of a cult.");
                }
            }
            else if (rnd <= 47 && rnd >= 38) {
                System.out.print("\nParty in town center. Sounds of music come from the town square, as well as a tower of smoke. It looks like a burning of some sort. Probably best to avoid...");
            }
            else {
                System.out.print("\nFew people out. Those that are are staring.");
            }
            new Grids(250, 250, 25, 25).setVisible(true);
        }
        else if(population <= 1000 && population >= 251) {
            System.out.print("\nInn D/C: 15 \nInn Cost(if found): 8 SP/Night");
            //town details
            if(rnd >= 48) {
                System.out.print("\nParade happening getting around is slow, and the shops are mostly closed.");
                if (feel == 2) {
                    System.out.print("It is quite violent though... Probably a cult of some sort.");
                }
            }
            else if (rnd <= 47 && rnd >= 38) {
                System.out.print("\nParty in town center. Sounds of music come from the town square, as well as a tower of smoke. It looks like a burning of some sort. Probably best to avoid...");
            }
            else {
                System.out.print("\nSome people in street. Many staring.");
            }
            new Grids(250, 250, 25, 25).setVisible(true);
        }
        else if(population <= 2500 && population >= 1001) {
            System.out.print("\nInn D/C: 15 \nInn Cost(if found): 1 GP/Night");
            //town details
            if(rnd >= 49) {
                System.out.print("\nParade happening getting around is slow, and the shops are mostly closed.");
                if (feel == 2) {
                    System.out.print("It seems quite violent though... Maybe some sort of cult?");
                }
            }
            else if (rnd < 49 && rnd >= 38) {
                System.out.print("\nParty in town center. Sounds of music come from the town square, as well as a tower of smoke. It looks like a burning of some sort. Probably best to avoid...");
            }
            else {
                System.out.print("\nSome people in street. A few staring.");
            }
            new Grids(400, 400, 30, 30).setVisible(true);
        }
        else if(population <= 5000 && population >= 2501) {
            System.out.print("\nInn D/C: 15 \nInn Cost(if found): 1 GP/Night");
            //town details
            if(rnd >= 48) {
                System.out.print("\nParade happening getting around is slow, and the shops are mostly closed.");
                if (feel == 2) {
                    System.out.print("It is quite violent though... Maybe some sort of cult?");
                }
            }
            else if (rnd <= 47 && rnd >= 38) {
                System.out.print("\nParty in town center. Sounds of music come from the town square, as well as a tower of smoke. It looks like a burning of some sort. Probably best to avoid...");
            }
            else {
                System.out.print("\nQuite a few people in street. Not very many pay you any mind.");
            }
            new Grids(600, 600, 50, 50).setVisible(true);
        }
        else if(population <= 10000 && population >= 5001) {
            System.out.print("\nInn D/C: 12 \nInn Cost(if found): 1 GP/Night/Night");
            //town details
            if(rnd >= 48) {
                System.out.print("\nParade happening getting around is slow, and the shops are mostly closed.");
                if (feel == 2) {
                    System.out.print("It is quite violent though... Maybe some sort of a cult?");
                }
            }
            else if (rnd <= 47 && rnd >= 38) {
                System.out.print("\nParty in town center. Sounds of music come from the town square, as well as a tower of smoke. It looks like a burning of some sort. Probably best to avoid...");
            }
            else {
                System.out.print("\nMany people in street. None seem to see you.");
            }
            new Grids(720, 660, 60, 60).setVisible(true);
        }
        else if(population >= 10001) {
            System.out.print("\nInn D/C: 10 \nInn Cost(if found): 1 GP/Night");
            //town details
            if(rnd >= 48) {
                System.out.print("\nParade happening getting around is slow, and the shops are mostly closed.");
                if (feel == 2) {
                    System.out.print("It is quite violent though... Maybe a cult? or a witch trial...");
                }
            }
            else if (rnd <= 47 && rnd >= 38) {
                System.out.print("\nParty in town center. Sounds of music come from the town square, as well as a tower of smoke. It looks like a burning of some sort. Probably best to avoid...");
            }
            else {
                System.out.print("\nLots of people in street. No one notices you.");
            }
            new Grids(750, 675, 75, 75).setVisible(true);
        }
        else {
            System.out.print("\nError");
        }
    }
}