package com.rfg.goldsprint.view.parameter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.rfg.goldsprint.properties.InitProperties;
import com.rfg.goldsprint.view.extcomponent.ComboItem;
import com.rfg.goldsprint.view.utils.ViewUtils;

public class PlayerParameterComponent extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2937471634946226528L;
	
	private JTextField playerName;
	private JComboBox wheelSize;
	private JComboBox crankSize; 
	private JComboBox cogSize; 
	private Color playerCurrentColor;
	
	public PlayerParameterComponent(String player1Name, int tire, int crank, int cog,Color playerColor) {
		super();
		initComponent(player1Name,tire,crank,cog,playerColor);
		
	}
	
	public void initComponent(String player1Name, int tire, int crank, int cog,Color playerColor) {
	
	GridLayout componentLayout = new GridLayout(0,2);
	this.setLayout(componentLayout);

	Font police = new Font(InitProperties.FONT, Font.PLAIN, 10);
	
	playerName = new JTextField(player1Name);
	playerName.setFont(police);
	playerName.setHorizontalAlignment(JLabel.LEFT);
	playerName.setPreferredSize(new Dimension(150, 20));
	
	wheelSize = new JComboBox();
	wheelSize.setFont(police);
	wheelSize.setPreferredSize(new Dimension(150, 20));
	wheelSize.setBackground(InitProperties.BACKGROUNDCOLOR);
	
	wheelSize.addItem(new ComboItem(2325,"700x56 (622-56)"));
	wheelSize.addItem(new ComboItem(2293,"700x50 (622-50)"));
	wheelSize.addItem(new ComboItem(2224,"700x44 (622-44)"));
	wheelSize.addItem(new ComboItem(2180,"700x38 (622-38)"));
	wheelSize.addItem(new ComboItem(2168,"700x35 (622-35)"));
	wheelSize.addItem(new ComboItem(2155,"700x32 (622-32)"));
	wheelSize.addItem(new ComboItem(2136,"700x28 (622-28)"));
	wheelSize.addItem(new ComboItem(2105,"700x25 (622-25)"));
	wheelSize.addItem(new ComboItem(2097,"700x23 (622-23)"));
	wheelSize.addItem(new ComboItem(2086,"700x20 (622-20)"));
	wheelSize.addItem(new ComboItem(2169,"27x1'3/8 (630-35)"));
	wheelSize.addItem(new ComboItem(2161,"27x1'1/4 (630-32)"));
	wheelSize.addItem(new ComboItem(2155,"27x1'1/8 (630-28)"));
	wheelSize.addItem(new ComboItem(2145,"27x1' (630-25)"));
	wheelSize.addItem(new ComboItem(2070,"26x2'1/8 (559-54)"));
	wheelSize.addItem(new ComboItem(2055,"26x1.9' (559-47)"));
	wheelSize.addItem(new ComboItem(1985,"26x1'/2 (559-38)"));
	wheelSize.addItem(new ComboItem(1953,"26x1'1/4 (559-32)"));
	wheelSize.addItem(new ComboItem(1913,"26x1' (559-25)"));
	wheelSize.addItem(new ComboItem(1952,"26x1' (571-25)"));
	wheelSize.addItem(new ComboItem(1952,"650C (571-25)"));
	wheelSize.addItem(new ComboItem(2117,"Tubular (Wide)"));
	wheelSize.addItem(new ComboItem(2105,"Tubular (Narrow)"));
	wheelSize.addItem(new ComboItem(2068,"26x1 3/8 (590-35)"));
	wheelSize.addItem(new ComboItem(1916,"24 (Most)"));
	wheelSize.addItem(new ComboItem(1753,"24x1 (520-25)"));
	wheelSize.addItem(new ComboItem(1491,"20x1'3/4 (406-44)"));
	wheelSize.addItem(new ComboItem(1618,"20x1'1/4 (451-28)"));
	wheelSize.addItem(new ComboItem(1367,"18x1'1/2 (355-40)"));
	wheelSize.addItem(new ComboItem(1325,"17x1'1/4 (369-28)"));
	wheelSize.addItem(new ComboItem(1282,"16x1'3/8 (349-35)"));
	wheelSize.addItem(new ComboItem(1079,"16x1'1/2 (305-37)"));
	
	//used to select the correct value
	wheelSize.setSelectedIndex(ViewUtils.indexToSelect(tire, wheelSize));
	
	
	crankSize = new JComboBox();
	crankSize.setFont(police);
	crankSize.setPreferredSize(new Dimension(150, 20));
	crankSize.setBackground(InitProperties.BACKGROUNDCOLOR);
	
	crankSize.addItem(new ComboItem(28,"28t"));
	crankSize.addItem(new ComboItem(29,"29t"));
	crankSize.addItem(new ComboItem(30,"30t"));
	crankSize.addItem(new ComboItem(31,"31t"));
	crankSize.addItem(new ComboItem(32,"32t"));
	crankSize.addItem(new ComboItem(33,"33t"));
	crankSize.addItem(new ComboItem(34,"34t"));
	crankSize.addItem(new ComboItem(35,"35t"));
	crankSize.addItem(new ComboItem(36,"36t"));
	crankSize.addItem(new ComboItem(37,"37t"));
	crankSize.addItem(new ComboItem(38,"38t"));
	crankSize.addItem(new ComboItem(39,"39t"));
	crankSize.addItem(new ComboItem(40,"40t"));
	crankSize.addItem(new ComboItem(41,"41t"));
	crankSize.addItem(new ComboItem(42,"42t"));
	crankSize.addItem(new ComboItem(34,"43t"));
	crankSize.addItem(new ComboItem(35,"44t"));
	crankSize.addItem(new ComboItem(36,"45t"));
	crankSize.addItem(new ComboItem(37,"46t"));
	crankSize.addItem(new ComboItem(38,"47t"));
	crankSize.addItem(new ComboItem(39,"48t"));
	crankSize.addItem(new ComboItem(40,"49t"));
	crankSize.addItem(new ComboItem(50,"50t"));
	crankSize.addItem(new ComboItem(51,"51t"));
	crankSize.addItem(new ComboItem(52,"52t"));
	crankSize.addItem(new ComboItem(53,"53t"));
	crankSize.addItem(new ComboItem(54,"54t"));
	crankSize.addItem(new ComboItem(55,"55t"));
	crankSize.addItem(new ComboItem(56,"56t"));
	crankSize.addItem(new ComboItem(57,"57t"));
	crankSize.addItem(new ComboItem(58,"58t"));
	
	//used to select the correct value
	crankSize.setSelectedIndex(ViewUtils.indexToSelect(crank, crankSize));
	
	cogSize = new JComboBox();
	cogSize.setFont(police);
	cogSize.setPreferredSize(new Dimension(150, 20));
	cogSize.setBackground(InitProperties.BACKGROUNDCOLOR);
	
	cogSize.addItem(new ComboItem(9,"9t"));
	cogSize.addItem(new ComboItem(10,"10t"));
	cogSize.addItem(new ComboItem(11,"11t"));
	cogSize.addItem(new ComboItem(12,"12t"));
	cogSize.addItem(new ComboItem(13,"13t"));
	cogSize.addItem(new ComboItem(14,"14t"));
	cogSize.addItem(new ComboItem(15,"15t"));
	cogSize.addItem(new ComboItem(16,"16t"));
	cogSize.addItem(new ComboItem(17,"17t"));
	cogSize.addItem(new ComboItem(18,"18t"));
	cogSize.addItem(new ComboItem(19,"19t"));
	cogSize.addItem(new ComboItem(20,"20t"));
	cogSize.addItem(new ComboItem(21,"21t"));
	
	//used to select the correct value
	cogSize.setSelectedIndex(ViewUtils.indexToSelect(cog, cogSize));
	
	final JButton colorSelector = new JButton();
	colorSelector.setBackground(playerColor);
	this.add(colorSelector);
    
	colorSelector.addActionListener(new ActionListener(  ) {
      public void actionPerformed(ActionEvent e) {
    	  playerCurrentColor = JColorChooser.showDialog(colorSelector,"change", colorSelector.getBackground());
        if (playerCurrentColor != null) colorSelector.setBackground(playerCurrentColor);
      }
    });
	
	
	this.add(new JLabel("Player Name :"));
	this.add(playerName);
	
	this.add(new JLabel("Tire :"));
	this.add(wheelSize);
	
	this.add(new JLabel("Chain ring :"));
	this.add(crankSize);
	
	this.add(new JLabel("Sproket :"));
	this.add(cogSize);
	this.add(new JLabel("Color :"));
	this.add(colorSelector);
	
	}

	public JTextField getPlayerName() {
		return playerName;
	}

	public void setPlayerName(JTextField playerName) {
		this.playerName = playerName;
	}

	public JComboBox getWheelSize() {
		return wheelSize;
	}

	public void setWheelSize(JComboBox wheelSize) {
		this.wheelSize = wheelSize;
	}

	public JComboBox getCrankSize() {
		return crankSize;
	}

	public void setCrankSize(JComboBox crankSize) {
		this.crankSize = crankSize;
	}

	public JComboBox getCogSize() {
		return cogSize;
	}

	public void setCogSize(JComboBox cogSize) {
		this.cogSize = cogSize;
	}

	/**
	 * @return the playerColor
	 */
	public Color getPlayerCurrentColor() {
		return playerCurrentColor;
	}

	/**
	 * @param playerColor the playerColor to set
	 */
	public void setPlayerCurrentColor(Color playerColor) {
		this.playerCurrentColor = playerColor;
	}
	
}
