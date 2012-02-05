package com.rfg.goldsprint.view.parameter;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.rfg.goldsprint.properties.InitProperties;

public class RaceParameterComponent extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -826410492640246551L;
	
	protected JTextField raceDistance;
	protected JCheckBox mockMode;
	protected JCheckBox fsMode;
	
	public RaceParameterComponent() {
		super();
		initComponent();
		
	}
	
	public void initComponent() {
		
		this.setBackground(InitProperties.BACKGROUNDCOLOR);
		
		GridLayout componentLayout = new GridLayout(0,2);
		this.setLayout(componentLayout);
		Font police = new Font(InitProperties.FONT, Font.PLAIN, 10);

		raceDistance = new JTextField(String.valueOf(InitProperties.RACEDISTANCE));
		raceDistance.setFont(police);
		raceDistance.setHorizontalAlignment(JLabel.LEFT);
		raceDistance.setPreferredSize(new Dimension(150, 20));

		mockMode = new JCheckBox();
		mockMode.setBackground(InitProperties.BACKGROUNDCOLOR);
		fsMode = new JCheckBox();
		fsMode.setBackground(InitProperties.BACKGROUNDCOLOR);
		
		this.add(new JLabel("Race Distance :"));
		this.add(raceDistance);
		
		this.add(new JLabel("Mock Mode :"));
		this.add(mockMode);
		
		this.add(new JLabel("False Start :"));
		this.add(fsMode);
	}

	public JTextField getRaceDistance() {
		return raceDistance;
	}

	public void setRaceDistance(JTextField raceDistance) {
		this.raceDistance = raceDistance;
	}

	public JCheckBox getMockMode() {
		return mockMode;
	}

	public void setMockMode(JCheckBox mockMode) {
		this.mockMode = mockMode;
	}

	public JCheckBox getFsMode() {
		return fsMode;
	}

	public void setFsMode(JCheckBox fsMode) {
		this.fsMode = fsMode;
	}
	
	
	
}
