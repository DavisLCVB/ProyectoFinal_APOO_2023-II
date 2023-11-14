/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8.finalproject.userinterface.apartamentos;

import com.grupo8.finalproject.userinterface.tejado.*;
import com.grupo8.finalproject.userinterface.apartamentos.*;
import components.JPanelRound;
import java.awt.Color;

/**
 *
 * @author leocv
 */
public class PanelBorde extends JPanelRound {

    public PanelBorde() {
        this.setBounds(0, 0, 785, 539);
        this.setBackground(Color.WHITE);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopLeft(50);
        this.setRoundTopRight(50);
    }

}
