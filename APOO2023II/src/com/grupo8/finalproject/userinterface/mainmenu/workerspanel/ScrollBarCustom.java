package com.grupo8.finalproject.userinterface.mainmenu.workerspanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;
import javax.swing.plaf.metal.MetalScrollBarUI;

public class ScrollBarCustom extends MetalScrollBarUI {

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        g.setColor(new Color(158, 213, 217));
        g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(Color.WHITE);
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new JButton() {
            {
                setContentAreaFilled(false);
                setFocusable(false);
                setBorder(BorderFactory.createEmptyBorder());
            }
        };
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new JButton() {
            {
                setContentAreaFilled(false);
                setFocusable(false);
                setBorder(BorderFactory.createEmptyBorder());
            }
        };
    }
}
