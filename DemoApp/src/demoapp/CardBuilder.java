/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demoapp;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;


public class CardBuilder {
    
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<FlashCard> cardList;
    private JFrame frame;
    
    public CardBuilder()
    {
        frame = new JFrame("FlashCard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        Font font = new Font("Helvetica Neue", Font.BOLD, 21);
        question = new JTextArea(6,20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(font);
        
        JScrollPane qJScrollPane = new JScrollPane(question);
        qJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        answer = new JTextArea(6,20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(font);
        
        JScrollPane aJscrollPane = new JScrollPane(answer);
        aJscrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aJscrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JButton nextButton = new JButton("Next Card");
        cardList = new ArrayList<FlashCard>();
        
        JLabel qLabel = new JLabel("Question");
        JLabel aLabel = new JLabel("Answer");
        
        
        mainPanel.add(qLabel);
        mainPanel.add(qJScrollPane);
        mainPanel.add(aLabel);
        mainPanel.add(aJscrollPane);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        
        
        
        newMenuItem.addActionListener(new NewMenuItemListener());
        saveMenuItem.addActionListener(new SaveMenuItemListener());
        
        
        frame.setJMenuBar(menuBar);
        
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500,600);
        frame.setVisible(true);
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new CardBuilder();
            }
            
        });
    }
    
    class NextCardListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            FlashCard card = new FlashCard(question.getText(), answer.getText());
            cardList.add(card);
            clearCard();
            
        }

        private void clearCard() {
            question.setText("");
            answer.setText("");
            question.requestFocus();
        }
        
    }
    
    class NewMenuItemListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        }  
        
        
    }
    
    class SaveMenuItemListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            FlashCard card = new FlashCard(question.getText(), answer.getText());
            cardList.add(card);
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
            
        }

        private void saveFile(File selectedFile) {
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));
                Iterator<FlashCard> cardIterator = cardList.iterator();
                while(cardIterator.hasNext())
                {
                    FlashCard card = (FlashCard)cardIterator.next();
                    writer.write(card.getQuestion()+"/");
                    writer.write(card.getAnswer()+"\n");
                }
                writer.close();
            } catch(Exception e)
            {
                System.out.println("Couldn't write to File");
                e.printStackTrace();
            }
        }
        
    }
    
}
