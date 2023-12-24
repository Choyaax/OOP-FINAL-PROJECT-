/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.deliverysystem; 
import java.awt.*;   
import javax.swing.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;  
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener; 
import javax.swing.Timer; 

/**
 *
 * @author Craig    //nahuman og 5:20 pm December 18 2023
 */
public class DevForm extends javax.swing.JFrame { 
 private Timer Timer; 
 private ButtonGroup packageGroup;  
 private JLabel confirmLabel;
    /**
     * Creates new form DevForm
     */
    public DevForm() {
        initComponents();   
        initializeRadioButtons();  
         confirmLabel = new JLabel("Confirm Delivery");
        confirmLabel.setVisible(false); 
    //   attachDocumentListeners();   
       initializeTimer();   //e initialize nato diri una and also mao ni siya ang hinungdan para dili mo overload or di lag ang algorithm.
       
         CalculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CalculateCost();
            }
        });
    } 
    
    private void initializeTimer(){  //The algorithm, para dili mo lag after calculating the total then choosing  one of the radio buttons 
    int delay  = 500; 
    Timer = new Timer(delay, e-> CalculateCost());  
    Timer.setRepeats(false);
    }

   /*    private void attachDocumentListeners(){
      
       weight.getDocument().addDocumentListener(new DocumentListener() {
       
        @Override 
        public void insertUpdate(DocumentEvent e) {
            CalculateCost();
      
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            CalculateCost();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            CalculateCost();
        }
    });

    costfee.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            CalculateCost();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            CalculateCost();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            CalculateCost();
        }
    });

    flatfee.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            CalculateCost();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            CalculateCost();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            CalculateCost();
        }
    });

    addfee.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            CalculateCost();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            CalculateCost();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            CalculateCost();
        }
    });

         
   
       
       } 
    */
 
 private void initializeRadioButtons() {
        // Create a ButtonGroup
      ButtonGroup packageGroup = new ButtonGroup();

   

        packageGroup.add(standardpackage);
        packageGroup.add(twodaypackage);
        packageGroup.add(overnightpackage);

      
        state.add(standardpackage);
        state.add(twodaypackage);
        state.add(overnightpackage);
    }
    
   private void CalculateCost(){ 
   

     //This is where the cooking is done  
  /* if (!Person()) {
    return;
}
    try {
            double cost = Double.parseDouble(costfee.getText());

            if (standardpackage.isSelected()) {
                double totalCost = Double.parseDouble(weight.getText()) * cost;
                total.setText("Total cost: " + totalCost);
            } else if (twodaypackage.isSelected()) {
                double flatFee = Double.parseDouble(flatfee.getText());
                double totalCost = Double.parseDouble(weight.getText()) * cost + flatFee;
                total.setText("Total cost: " + totalCost);
            } else if (overnightpackage.isSelected()) {
                double addFee = Double.parseDouble(addfee.getText());
                double totalCost = (cost + addFee) * Double.parseDouble(weight.getText());
                total.setText("Total cost: " + totalCost);
            }
        } catch (NumberFormatException ex) {
            total.setText("Invalid input");   //with try catch 
        }
     */ 
  if (!Person()) {
    return;
}
try {
    double cost = Double.parseDouble(costfee.getText());
    double weightValue = Double.parseDouble(weight.getText());

    if (cost < 0 || weightValue < 0) {
        total.setText("Invalid input");
        return;
    }

    if (standardpackage.isSelected()) {
        double totalCost = weightValue * cost;
        total.setText("Total cost: " + totalCost);
    } else if (twodaypackage.isSelected()) {
        if (flatfee.getText().isEmpty()) {
            total.setText("Invalid input");
            return;
        }
        double flatFee = Double.parseDouble(flatfee.getText());
        if (flatFee < 0) {
            total.setText("Invalid input");
            return;
        }
        double totalCost = weightValue * cost + flatFee;
        total.setText("Total cost: " + totalCost);
    } else if (overnightpackage.isSelected()) {
        if (addfee.getText().isEmpty()) {
            total.setText("Invalid input:");
            return;
        }
        double addFee = Double.parseDouble(addfee.getText());
        if (addFee < 0) {
            total.setText("Invalid input");
            return;
        }
        double totalCost = (cost + addFee) * weightValue;
        total.setText("Total cost: " + totalCost);
    }
} catch (NumberFormatException ex) {
    total.setText("Invalid input");
}
  
  
    JPanel confirmPanel = new JPanel();
JButton confirmButton = new JButton("Confirm Delivery");
confirmButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Success!"); // Show success message on button click
    }
});
confirmPanel.add(confirmButton);

// Show a confirmation dialog with the confirmPanel
try {
    // Parse the input and calculate the cost
    double cost = Double.parseDouble(costfee.getText());

    if (standardpackage.isSelected()) {
        double totalCost = Double.parseDouble(weight.getText()) * cost;
        total.setText("Total cost: " + totalCost);
    } else if (twodaypackage.isSelected()) {
        double flatFee = Double.parseDouble(flatfee.getText());
        double totalCost = Double.parseDouble(weight.getText()) * cost + flatFee;
        total.setText("Total cost: " + totalCost);
    } else if (overnightpackage.isSelected()) {
        double addFee = Double.parseDouble(addfee.getText());
        double totalCost = (cost + addFee) * Double.parseDouble(weight.getText());
        total.setText("Total cost: " + totalCost);
    }

    
    
    int option = JOptionPane.showOptionDialog(
        null,
        confirmLabel, // Replace with the relevant panel or message you want to show
        "Confirm Delivery",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.PLAIN_MESSAGE,
        null,
        new Object[]{"Yes", "No"},
        "Yes"
    );

    if (option == JOptionPane.YES_OPTION) {
        JOptionPane.showMessageDialog(null, "Success!");
    }

    // If "No" or the close button is clicked, don't show success message
        CalculateButton.setEnabled(true);
} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(null, "Invalid input!");
    total.setText("Invalid input");
     //   CalculateButton.setEnabled(true); // Disable the button in case of number format exception
}
    }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField10 = new javax.swing.JTextField();
        state = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        standardpackage = new javax.swing.JRadioButton();
        twodaypackage = new javax.swing.JRadioButton();
        overnightpackage = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sender = new javax.swing.JTextField();
        receiver = new javax.swing.JTextField();
        CalculateButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Cityy = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        zipcode2 = new javax.swing.JTextField();
        Address = new javax.swing.JTextField();
        city = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        State = new javax.swing.JTextField();
        zipcode = new javax.swing.JTextField();
        costfee = new javax.swing.JTextField();
        weight = new javax.swing.JTextField();
        flatfee = new javax.swing.JTextField();
        ADDFEE = new javax.swing.JLabel();
        addfee = new javax.swing.JTextField();
        total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 204));
        setResizable(false);

        state.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Delivery express");

        standardpackage.setForeground(new java.awt.Color(255, 255, 255));
        standardpackage.setText("Standard package");
        standardpackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standardpackageActionPerformed(evt);
            }
        });

        twodaypackage.setForeground(new java.awt.Color(255, 255, 255));
        twodaypackage.setText("Two day package");
        twodaypackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twodaypackageActionPerformed(evt);
            }
        });

        overnightpackage.setForeground(new java.awt.Color(255, 255, 255));
        overnightpackage.setText("Overnight package");
        overnightpackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overnightpackageActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" Sender: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Receiver:");

        sender.setText("Enter a name...");
        sender.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                senderFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                senderFocusLost(evt);
            }
        });
        sender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senderActionPerformed(evt);
            }
        });

        receiver.setText("Enter a name...");
        receiver.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                receiverFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                receiverFocusLost(evt);
            }
        });
        receiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiverActionPerformed(evt);
            }
        });

        CalculateButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CalculateButton.setText("Calculate");
        CalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Weight:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("flatfee:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cost:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("City:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Address:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("State:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("State");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Zip code:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Address:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("City:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("State:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Zip code:");

        costfee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costfeeActionPerformed(evt);
            }
        });

        weight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightActionPerformed(evt);
            }
        });

        flatfee.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                flatfeeComponentMoved(evt);
            }
        });
        flatfee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flatfeeActionPerformed(evt);
            }
        });

        ADDFEE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ADDFEE.setForeground(new java.awt.Color(255, 255, 255));
        ADDFEE.setText("addfee:");

        addfee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addfeeActionPerformed(evt);
            }
        });

        total.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setText("Total cost:  ");

        javax.swing.GroupLayout stateLayout = new javax.swing.GroupLayout(state);
        state.setLayout(stateLayout);
        stateLayout.setHorizontalGroup(
            stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(overnightpackage)
                    .addComponent(twodaypackage)
                    .addComponent(standardpackage)
                    .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(stateLayout.createSequentialGroup()
                            .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(stateLayout.createSequentialGroup()
                                    .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(65, 65, 65))
                                .addGroup(stateLayout.createSequentialGroup()
                                    .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(zipcode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(State)
                                        .addComponent(Cityy, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(sender))
                                    .addGap(35, 35, 35)))
                            .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(receiver, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(Address)
                                    .addComponent(jTextField12)
                                    .addComponent(zipcode2)
                                    .addComponent(city))
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(stateLayout.createSequentialGroup()
                            .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, stateLayout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(flatfee))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, stateLayout.createSequentialGroup()
                                    .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(weight, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(costfee))))
                            .addGap(18, 18, 18)
                            .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(stateLayout.createSequentialGroup()
                                    .addComponent(ADDFEE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(addfee, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(total, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stateLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(83, 83, 83))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(stateLayout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(220, Short.MAX_VALUE)))
        );
        stateLayout.setVerticalGroup(
            stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stateLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(standardpackage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(twodaypackage)
                .addGap(18, 18, 18)
                .addComponent(overnightpackage)
                .addGap(81, 81, 81)
                .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(24, 24, 24)
                .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sender, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(receiver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(stateLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(stateLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cityy, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(State, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipcode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zipcode2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(costfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADDFEE)
                    .addComponent(addfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(total)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flatfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(stateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stateLayout.createSequentialGroup()
                    .addContainerGap(617, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(134, 134, 134)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(state, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(state, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private boolean Person() {
    String senderInfo = sender.getText();
    String receiverInfo = receiver.getText();
    String addressInfo = address.getText();
    String cityInfo = city.getText();
    String stateInfo = State.getText();
    
    String zipInfo = zipcode.getText();
    
    if (senderInfo.isEmpty() || receiverInfo.isEmpty() || addressInfo.isEmpty() || cityInfo.isEmpty() || stateInfo.isEmpty() || zipInfo.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Enter information first");
        return false;
    }
    return true;
}
    
    
  
    
    
    
    
    private void standardpackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standardpackageActionPerformed
        // TODO add your handling code here: 
      
    }//GEN-LAST:event_standardpackageActionPerformed

    private void overnightpackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overnightpackageActionPerformed
        // TODO add your handling code here:  
    
     
    }//GEN-LAST:event_overnightpackageActionPerformed

    private void twodaypackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twodaypackageActionPerformed
        // TODO add your handling code here: 
       //CalculateCost(); 
    }//GEN-LAST:event_twodaypackageActionPerformed

    private void senderFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_senderFocusGained
        // TODO add your handling code here: 
  
   
 
    }//GEN-LAST:event_senderFocusGained

    private void senderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senderActionPerformed

    private void receiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receiverActionPerformed

    private void senderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_senderFocusLost
        // TODO add your handling code here: 
        
   
    }//GEN-LAST:event_senderFocusLost

    private void receiverFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receiverFocusGained
        // TODO add your handling code here: 
      
        
    }//GEN-LAST:event_receiverFocusGained

    private void receiverFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receiverFocusLost
        // TODO add your handling code here: 
        
     
    }//GEN-LAST:event_receiverFocusLost

    private void CalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateButtonActionPerformed
        // TODO add your handling code here:   
        CalculateCost();  //tawagon ra diri sa calculate button 
     
        
    }//GEN-LAST:event_CalculateButtonActionPerformed

    private void costfeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costfeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costfeeActionPerformed

    private void weightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightActionPerformed
        // TODO add your handling code here:   
      
        
    }//GEN-LAST:event_weightActionPerformed

    private void flatfeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flatfeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flatfeeActionPerformed

    private void addfeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addfeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addfeeActionPerformed

    private void flatfeeComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_flatfeeComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_flatfeeComponentMoved


    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DevForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DevForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DevForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DevForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DevForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ADDFEE;
    private javax.swing.JTextField Address;
    private javax.swing.JButton CalculateButton;
    private javax.swing.JTextField Cityy;
    private javax.swing.JTextField State;
    private javax.swing.JTextField addfee;
    private javax.swing.JTextField address;
    private javax.swing.JTextField city;
    private javax.swing.JTextField costfee;
    private javax.swing.JTextField flatfee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JRadioButton overnightpackage;
    private javax.swing.JTextField receiver;
    private javax.swing.JTextField sender;
    private javax.swing.JRadioButton standardpackage;
    private javax.swing.JPanel state;
    private javax.swing.JLabel total;
    private javax.swing.JRadioButton twodaypackage;
    private javax.swing.JTextField weight;
    private javax.swing.JTextField zipcode;
    private javax.swing.JTextField zipcode2;
    // End of variables declaration//GEN-END:variables
}
