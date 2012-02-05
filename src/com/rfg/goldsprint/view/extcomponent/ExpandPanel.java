package com.rfg.goldsprint.view.extcomponent;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.rfg.goldsprint.properties.InitProperties;

public class ExpandPanel extends JPanel {  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = -1170474859506364504L;
	private boolean selected;  
    JPanel contentPanel_;  
    HeaderPanel headerPanel_;  
  
    private class HeaderPanel extends JPanel implements MouseListener {  
        /**
		 * 
		 */
		private static final long serialVersionUID = 2320019772241230911L;
		String text_;  
        Font font;  
        @SuppressWarnings("unused")
		BufferedImage open, closed;  
        @SuppressWarnings("unused")
		final int OFFSET = 30, PAD = 5;  
  
        @SuppressWarnings("unused")
		public HeaderPanel(String text) {  
            addMouseListener(this);  
            setBackground(Color.BLACK);
            text_ = text;  
            font = new Font(InitProperties.FONT, Font.PLAIN, 12);  
        
            // setRequestFocusEnabled(true);  
            setPreferredSize(new Dimension(500, 30));  
            int w = getWidth();  
            int h = getHeight();  
  
//           try { 
//        	   open = ImageIO.read(this.getClass().getResource("/images/br_down.png")); 
//                closed = ImageIO.read(this.getClass().getResource("/images/br_up.png")); 
//            } catch (IOException e) { 
//                e.printStackTrace(); 
//            }  
  
        }  
  
        protected void paintComponent(Graphics g) {  
            super.paintComponent(g);  
            Graphics2D g2 = (Graphics2D) g;  
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);  
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.9f));
            int h = getHeight();  
//            if (selected) {
//                g2.drawImage(open, PAD, 0, h, h, this); 
//            }else{ 
//                g2.drawImage(closed, PAD, 0, h, h, this); 
//            }
            g2.setFont(font);  
            FontRenderContext frc = g2.getFontRenderContext();  
            g2.setColor(Color.WHITE);
            LineMetrics lm = font.getLineMetrics(text_, frc);  
            float height = lm.getAscent() + lm.getDescent();  
            float x = OFFSET;  
            float y = (h + height) / 2 - lm.getDescent();  
            g2.drawString(text_, x, y);  
        }  
  
        public void mouseClicked(MouseEvent e) {  
            toggleSelection();  
        }  
  
        public void mouseEntered(MouseEvent e) {  
        }  
  
        public void mouseExited(MouseEvent e) {  
        }  
  
        public void mousePressed(MouseEvent e) {  
        }  
  
        public void mouseReleased(MouseEvent e) {  
        }  
  
    }  
  
    public ExpandPanel(String text, JPanel panel) {  
        super(new GridBagLayout());  
        GridBagConstraints gbc = new GridBagConstraints();  
        gbc.insets = new Insets(1, 3, 0, 3);  
        gbc.weightx = 1.0;  
        gbc.fill = GridBagConstraints.HORIZONTAL;  
        gbc.gridwidth = GridBagConstraints.REMAINDER;  
  
        selected = false;  
        headerPanel_ = new HeaderPanel(text);  
        setOpaque(false);
        setBackground(Color.WHITE);  
        contentPanel_ = panel;  
  
        add(headerPanel_, gbc);  
        add(contentPanel_, gbc);  
        contentPanel_.setVisible(false);  
        
        
        Border line = new LineBorder(Color.DARK_GRAY);
		Border margin = new EmptyBorder(2, 2, 2, 2);
		Border compound = new CompoundBorder(line, margin);
        
        contentPanel_.setBorder(compound);
        JLabel padding = new JLabel();  
        gbc.weighty = 1.0;  
        add(padding, gbc);  
  
    }  
  
    public void toggleSelection() {  
        selected = !selected;  
  
        if (contentPanel_.isShowing())  
            contentPanel_.setVisible(false);  
        else  
            contentPanel_.setVisible(true);  
  
        validate();  
  
        headerPanel_.repaint();  
    }  
  
}  

