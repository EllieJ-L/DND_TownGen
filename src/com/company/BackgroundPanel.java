package com.company;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {

    public static final int CENTERED = 0;
    public static final int SCALED   = 1;

    private Image backgroundImage = null;
    private int   backgroundType  = CENTERED;

    public BackgroundPanel() {
        super();
    }

    public BackgroundPanel( boolean isDoubleBuffered ) {
        super( isDoubleBuffered );
    }

    public BackgroundPanel( LayoutManager layout ) {
        super( layout );
    }

    public BackgroundPanel( LayoutManager layout, boolean isDoubleBuffered ) {
        super( layout, isDoubleBuffered );
    }

    public void setBackgroundImage( Image image ) {
        backgroundImage = image;
        repaint();
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundType( int type ) {
        if ( type == CENTERED || type == SCALED ) {
            backgroundType = type;
            repaint();
        }
        else {
            throw new IllegalArgumentException( "background type should be SCALED or CENTERED." );
        }
    }

    public int getBackgroundType() {
        return backgroundType;
    }

    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        if ( backgroundImage != null ) {
            if ( backgroundType == CENTERED ) {
                int imageX = (getWidth() - backgroundImage.getWidth( this )) / 2;
                int imageY = (getHeight() - backgroundImage.getHeight( this )) / 2;
                imageX = Math.max( 0, imageX );
                imageY = Math.max( 0, imageY );
                g.drawImage( backgroundImage, imageX, imageY, this );
            }
            else if ( backgroundType == SCALED ) {
                g.drawImage( backgroundImage, 0, 0, getWidth(), getHeight(), this );
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame( "BackgroundPanelTest" );

        BackgroundPanel p = new BackgroundPanel();
        Image i = Toolkit.getDefaultToolkit().getImage( "face.png" );
        p.setBackgroundImage( i );
        p.setBackgroundType( BackgroundPanel.SCALED );
        frame.getContentPane().add( p );
        JLabel label = new JLabel( "Name: " );
        p.add( label );
        JTextField text = new JTextField( 10 );
        p.add( text );
        JButton button = new JButton( "Enter" );
        p.add( button );

        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        frame.setSize( 300, 300 );
        frame.setVisible( true );

    }
}
