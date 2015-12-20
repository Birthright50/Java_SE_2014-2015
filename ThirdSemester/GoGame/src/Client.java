import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Birthright on 28.11.2015.
 */
public class Client {
    private static final int SERVER_PORT = 3456;
    private static final String HOST = "localhost";
    private ObjectInputStream ois;
    private ObjectOutputStream ous;
    public static final String NEW_ROOM = "New Room";

    public Client() {
        try {
            Socket socket = new Socket(HOST, SERVER_PORT);
            ous = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void startGame(StoneColor stoneColor) {
        if (stoneColor == null) {
            try {
                stoneColor = (StoneColor) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
            new GameBoard(stoneColor, ous, ois);
    }


    public void enterName() {
        ArrayList names = null;
        try {
            names = (ArrayList) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        JFrame jFrame = new JFrame("Enter your name") {
            {
                setResizable(false);
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                setBackground(new java.awt.Color(204, 204, 204));
            }
        };
        JLabel info = new JLabel("Enter your name") {
            {
                setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            }
        };
        TextField field_name = new TextField();
        final ArrayList finalNames = names;
        JButton enter = new JButton("Enter") {
            {
                addActionListener(e -> {
                    String name = field_name.getText();
                    assert finalNames != null;
                    if (finalNames.contains(name) || name.length() == 0) {
                        info.setText("Name already exists/ length = 0");
                    } else {
                        try {
                            ous.writeUTF(name);
                            ous.flush();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        jFrame.dispatchEvent(new WindowEvent(jFrame, WindowEvent.WINDOW_CLOSING));
                        chooseRoom();
                    }
                });

            }
        };
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jFrame.getContentPane());
        jFrame.getContentPane().setLayout(layout);


        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(137, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                        .addComponent(field_name)
                                        .addComponent(enter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(field_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(enter)
                                .addGap(0, 177, Short.MAX_VALUE))
        );
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

    }

    private void chooseRoom() {
        try {
            ArrayList names = (ArrayList) ois.readObject();

            JFrame jFrame = new JFrame("Choose the room") {
                {
                    setBackground(new java.awt.Color(204, 204, 204));
                    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                    setForeground(java.awt.Color.black);
                    setResizable(false);
                }
            };
            Box.Filler filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(250, 0), new java.awt.Dimension(250, 0), new java.awt.Dimension(250, 32767));
            Object[] objects = names.toArray();
            JComboBox<String> comboBox = new JComboBox<String>() {
                {
                    setModel(new DefaultComboBoxModel<>(Arrays.copyOf(objects, objects.length, String[].class)));

                }
            };
            JButton new_room = new JButton(NEW_ROOM) {
                {
                    addActionListener(e -> {
                        try {
                            ous.writeUTF(NEW_ROOM);
                            ous.flush();
                            jFrame.dispatchEvent(new WindowEvent(jFrame, WindowEvent.WINDOW_CLOSING));
                            waitingRoom();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    });
                }
            };

            JLabel choose_the_room = new JLabel("Choose the room") {
                {
                    setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    setFont(new java.awt.Font("Trebuchet MS", 0, 11));
                }
            };
            JButton go = new JButton("Go") {
                {
                    addActionListener(e -> {
                        String name = String.valueOf(comboBox.getSelectedItem());

                        if (!name.equals("null")) {
                            try {
                                ous.writeUTF(name);
                                ous.flush();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            jFrame.dispatchEvent(new WindowEvent(jFrame, WindowEvent.WINDOW_CLOSING));
                            startGame(null);
                        }
                    });
                }
            };
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jFrame.getContentPane());
            jFrame.getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(165, 165, 165)
                                    .addComponent(new_room, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(175, 175, 175))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap(156, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(64, 64, 64))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(choose_the_room, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(152, 152, 152))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(go)
                                                    .addGap(226, 226, 226))))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(new_room)
                                    .addGap(33, 33, 33)
                                    .addComponent(choose_the_room)
                                    .addGap(18, 18, 18)
                                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(go)
                                    .addGap(0, 214, Short.MAX_VALUE))
            );

            jFrame.pack();
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void waitingRoom() {
        javax.swing.Box.Filler filler1;
        javax.swing.JLabel jLabel1;

        JFrame jFrame = new JFrame() {
            {
                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setBackground(new java.awt.Color(204, 204, 204));
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                setForeground(java.awt.Color.black);
                setResizable(false);
            }
        };
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(250, 0), new java.awt.Dimension(250, 0), new java.awt.Dimension(250, 32767));
        jLabel1 = new javax.swing.JLabel() {
            {
                setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                setText("Waiting your opponent...");
            }
        };
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jFrame.getContentPane());
        jFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(83, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(64, 64, 64))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(103, 103, 103))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addGap(0, 87, Short.MAX_VALUE))
        );
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        new Thread(() -> {
            try {
                StoneColor stoneColor = (StoneColor) ois.readObject();
                jFrame.dispatchEvent(new WindowEvent(jFrame, WindowEvent.WINDOW_CLOSING));
                startGame(stoneColor);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }).start();


    }


    public static void main(String[] args) {
        Client client = new Client();
        client.enterName();
    }
}

